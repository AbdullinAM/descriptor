# Descriptor

Small library that allows to represent any Java variable (either object or 
primitive value) as a descriptor &mdash; a wrapper that retains all the
structural information about given variable. Descriptors are used to encode
input parameters for [Kex](https://github.com/vorpal-research/kex).

## Build

```shell
mvn clean package
```

## Usage

The latest release is available through [Vorpal GitHub Packages repository](https://github.com/orgs/vorpal-research/packages).
Add the link to the repository to your `pom.xml`:
```xml
<repository>
    <id>github-vorpal-research-kotlin-maven</id>
    <url>https://maven.vorpal-research.science</url>
</repository>
```

Include:
```xml
<dependency>
	<groupId>org.jetbrains.research</groupId>
	<artifactId>descriptor</artifactId>
	<version>1.2.0</version>
</dependency>
``` 