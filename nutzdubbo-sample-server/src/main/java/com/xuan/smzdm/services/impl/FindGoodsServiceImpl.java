/**
 *
 */
package com.xuan.smzdm.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xuan.smzdm.beans.Goods;
import com.xuan.smzdm.services.IFindGoodsServices;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nutz.ioc.loader.annotation.IocBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengjianfang@sunivo.com
 *         <p>
 *         2013年12月9日 下午9:33:17
 */
@IocBean(name = "findService")
public class FindGoodsServiceImpl implements IFindGoodsServices {

    @Override
    public String findGodPricesGoods() {
        return "GodPrices";
    }

    public static void main(String[] args) {
        long timeTag = (System.currentTimeMillis() - 900000) / 1000;
        List<Goods> goodsList = new ArrayList<Goods>();
        try {
            Document doc = Jsoup.connect("http://faxian.smzdm.com/").userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .post();
            Elements liList = doc.select("li[class=list]");
            for (int i = 0; i < liList.size(); i++) {
                Element li = liList.get(i);
                Elements p = li.select("p");
                if (p.toString().contains("神价")) {
                    Goods goods = new Goods();
                    goods.setTitle(p.toString());
                    goods.setHref(li.select("a[class=picBox]").first().attr("href"));
                    goodsList.add(goods);
                } else {
                    Elements aList = li.select("a[class=picBox]");
                    Element a = aList.first();
                    Document aDoc = Jsoup.connect(a.attr("href")).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                            .post();
                    if (aDoc.body().toString().contains("神价")) {
                        Goods goods = new Goods();
                        goods.setTitle(p.toString());
                        goods.setHref(li.select("a[class=picBox]").first().attr("href"));
                        goodsList.add(goods);
                    }
                }
                if (i == liList.size() - 1) {
                    long lastTimeSort = Long.valueOf(li.attr("timesort"));
                    if (lastTimeSort >= timeTag) {
                        getGoodsPage(lastTimeSort, timeTag, goodsList);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(goodsList);
    }

    private static void getGoodsPage(long lastTimeSort, long timeTag, List<Goods> goodsList) {
        try {
            Document aDoc = Jsoup.connect("http://faxian.smzdm.com/json_more?timesort=" + lastTimeSort).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .post();
            String article = aDoc.body().text();
            List<Goods> list = JSON.parseObject(article, new TypeReference<List<Goods>>() {
            });
            for (int i = 0; i < list.size(); i++) {
                Goods goods = list.get(i);
                Document doc = Jsoup.connect(goods.getArticleUrl()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                        .post();
                if (doc.body().toString().contains("神价")) {
                    goods.setTitle(goods.getArticleTitle());
                    goods.setHref(goods.getArticleUrl());
                    goodsList.add(goods);
                }
                if (i == list.size() - 1) {
                    lastTimeSort = Long.valueOf(goods.getTimesort());
                    if (lastTimeSort >= timeTag) {
                        getGoodsPage(lastTimeSort, timeTag, goodsList);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
