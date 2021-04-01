# EnkeSystems-ELK Stack

### Default username: elastic && password: changeme

To run project follow the steps

1. Enable resource sharing in Docker
2. Do mvn clean install
3. docker-compose up

To Add logs in logstash call following endpoints

1. { http://localhost:8080/model } will create user and log it.
2. { http://localhost:8080/exception } will throw an exception and log it.
3. { http://localhost:8080/hello } will ping with you

To run project (locally)
make sure that you have changed the destination to localhost
in logback.xml file