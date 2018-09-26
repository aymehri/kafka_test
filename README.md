# Kafka Test

This project demonstrate how to work with kafka and debezium connector

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

## Play with Confluent Cli

Create topics :
```sh
<path-to-confluent>/bin/kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```
List kafka topics :
```sh
<path-to-confluent>/bin/kafka-topics --list --zookeeper localhost:2181
```
Produce messages : 
```sh
<path-to-confluent>/bin/kafka-console-producer --broker-list localhost:9092 --topic test
```
Consume messages : 
```sh
<path-to-confluent>/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
```

##Run Mysql

Run `docker-compose -f mysql up` to run mysql database.

## Install debezium connector archive
Download [MySQL Connector plugin archive](https://repo1.maven.org/maven2/io/debezium/debezium-connector-mysql/0.8.3.Final/debezium-connector-mysql-0.8.3.Final-plugin.tar.gz).

Extract the archive
```
tar -xzf debezium-connector-mysql-0.8.3.Final-plugin.tar.gz
```

And copy `debezium-connector-mysql` to `<path-to-confluent>/share/java/`


## Kafka Connect Source
Open a new terminal, and use it to check the status of the Kafka Connect service:
```sh
$ curl -H "Accept:application/json" localhost:8083/
```

Check the connectors working
```sh
$ curl -H "Accept:application/json" localhost:8083/connectors/
```

Add connector 
```sh
$ curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors/ -d '{ "name": "inventory-connector", "config": { "connector.class": "io.debezium.connector.mysql.MySqlConnector", "tasks.max": "1", "database.hostname": "localhost", "database.port": "3306", "database.user": "debezium", "database.password": "dbz", "database.server.id": "184054", "database.server.name": "dbserver1", "database.whitelist": "inventory", "database.history.kafka.bootstrap.servers": "localhost:9092", "database.history.kafka.topic": "dbhistory.inventory" } }'
```

A pretty json passed in the previous request :
```sh
{
  "name": "inventory-connector",
  "config": {
    "connector.class": "io.debezium.connector.mysql.MySqlConnector",
    "tasks.max": "1",
    "database.hostname": "localhost",
    "database.port": "3306",
    "database.user": "debezium",
    "database.password": "dbz",
    "database.server.id": "184054",
    "database.server.name": "dbserver1",
    "database.whitelist": "inventory",
    "database.history.kafka.bootstrap.servers": "localhost:9092",
    "database.history.kafka.topic": "schema-changes.inventory"
  }
}
```

See some topics who were added : 
```sh
<path-to-confluent>/bin/kafka-topics --list --zookeeper localhost:2181
```

Consume one of these new topics : 
```sh
<path-to-confluent>/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic dbserver1.inventory.customers --from-beginning
```

## Kafka Connect Sink