# Lucille Example Project

This project is an example of how a developer can leverage [Lucille]([url](https://github.com/kmwtechnology/lucille)), the opensource search ETL solution, for their own use case.
You can create your own stages, connectors, etc. by adding them to the src code and using them in a configuration file.

## Requirements
- Java 11 or higher

## Maven
You can find the current release of [Lucille on maven central]([url](https://mvnrepository.com/artifact/com.kmwllc/lucille-core)).

### Getting Started
- Compile the code to create the necessary jar files, `mvn clean install` in the top directory.
- Run `./lucille.sh` in the top directory which runs a java process that takes the configuration in `example.conf` to extract, transform, and index the data.
- The example creates dummy docs, transforms the data a little, and creates docs to be indexed into OpenSearch. 
The default here does not actually send the docs, but if you want to actually see the indexed data, here are some instructions for setting up OpenSearch locally.
  - [OpenSearch Installation Docs](https://opensearch.org/docs/latest/install-and-configure/install-opensearch/index/)
  - We would reccommend using docker to install OpenSearch if you are already familiar with docker.
  - Once installed, make sure the OpenSearch section `example.conf` is set up correctly for your configuration of OpenSearch (localhost port, user/password) AND set indexer.sendEnabled to `true`.
  - 

## Gradle
TODO



