#! /bin/bash

nohup mvn tomcat7:run >/dev/null 2>/home/logs/sample_error.log &