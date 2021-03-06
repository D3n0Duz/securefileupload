#!/usr/bin/env bash
cd securefileupload/src/non-maven-libs
mvn install:install-file -Dfile=aspose-cells-8.7.0.jar -DgroupId=aspose.com -DartifactId=aspose-cells -Dversion=8.7.0 -Dpackaging=jar
mvn install:install-file -Dfile=aspose-words-16.1.0-jdk16.jar -DgroupId=aspose.com -DartifactId=aspose-words -Dversion=16.1.0 -Dpackaging=jar
mvn install:install-file -Dfile=aspose-slides-18.4-jdk16.jar -DgroupId=aspose.com -DartifactId=aspose-slides -Dversion=18.4.0 -Dpackaging=jar
mvn install:install-file -Dfile=commons-imaging-1.0.jar -DgroupId=org.apache.commons -DartifactId=commons-imaging -Dversion=1.0 -Dpackaging=jar