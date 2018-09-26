FROM mysql:5.7.20

MAINTAINER Aymen Mehri

# see : https://debezium.io/docs/connectors/mysql/
COPY mysql.cnf /etc/mysql/conf.d/
COPY initdb.sql /docker-entrypoint-initdb.d/