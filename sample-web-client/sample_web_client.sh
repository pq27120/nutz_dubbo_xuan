#! /bin/bash

nohup mvn tomcat7:run >/home/logs/sample_client.log 2>/home/logs/sample_client_error.log &