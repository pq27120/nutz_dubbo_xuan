#! /bin/bash

nohup mvn exec:java -Dexec.mainClass="com.sunivo.nutzdubbo.beans.Server" >/dev/null 2>/home/logs/sample_error.log &