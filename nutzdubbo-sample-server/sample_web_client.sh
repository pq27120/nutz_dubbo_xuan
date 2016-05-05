#! /bin/bash

nohup mvn exec:java -Dexec.mainClass="com.sunivo.nutzdubbo.beans.Server" > /home/logs/sample_server.log &