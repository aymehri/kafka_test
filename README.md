# Kafka Test

This project is to demonstrate how to work with kafka and debezium kafka connector

## Run Confluent Cli

_**Download**_ the confluent plateform from `https://www.confluent.io/download/`[Confluent](https://www.confluent.io/download/).

| Folder | Description 
|---|---|
**/bin/** | /etc/ 
**/etc/** | Configuration files
**/lib/** | Systemd services
**/logs/** | Log files
**/share/** | Jars and licenses
**/src/** | Source files that require a platform-dependent build

_**Run**_ `<path-to-confluent>/bin/confluent start`

And should see : 

```sh
Starting zookeeper
zookeeper is [UP]
Starting kafka
kafka is [UP]
Starting schema-registry
schema-registry is [UP]
Starting kafka-rest
kafka-rest is [UP]
Starting connect
connect is [UP]
Starting ksql-server
ksql-server is [UP]
```

##Run Mysql

Run `docker-compose -f mysql up` to run mysql database.
