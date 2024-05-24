# Lucille Example Project (Maven)

This project is an example of how a developer can leverage [Lucille]([url](https://github.com/kmwtechnology/lucille)), the opensource search ETL solution, for their own use case.

You can find the current release of [Lucille on maven central]([url](https://mvnrepository.com/artifact/com.kmwllc/lucille-core)).

# Requirements

- Java 11

# Getting Started

- Include `lucille-core` and `lucille-bom` as a maven dependency.
- Set up the run configurations. You can find `run/example.conf`.
- Compile the code to create the necessary jar files, `mvn clean install` in the top directory.
- Run `./run/runIngest.sh` which runs a java process

You can create your own stages, connectors, etc. by adding them to the src code and using them in a configuration file.

