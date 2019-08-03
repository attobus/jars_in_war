The example of rest endpoints located in the separate jars in the single war.

To create the war file with jars:

1. Create jars:
- create the first jar: in the directory methodA run "mvn package -Dsimple-jar";
- create the second jar: in the directory methodA run "mvn package -Dsimple-jar";

The jars will be placed in the "target" subdirectory in the "methodA" and "methodA".


2. Add the jars to the local repository in the main "app" project:
- in the "app" directory run

	mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=../methodA/target/jarA-0.0.1-annotations.jar -DgroupId=demo.jars_in_war -DartifactId=jarA -Dversion=0.0.1-annotations -Dpackaging=jar -DlocalRepositoryPath=${basedir}/local-maven-repo 
	mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=../methodB/target/jarB-0.0.1-annotations.jar -DgroupId=demo.jars_in_war -DartifactId=jarB -Dversion=0.0.1-annotations -Dpackaging=jar -DlocalRepositoryPath=${basedir}/local-maven-repo 

3. Create the war:
- in the "app" directory run "mvn package"

The war will be placed in the "target" subdirectory of "app" directory . This war can be deployed to the tomcat.


Note: 

methodA and methodB can be used as separate Spring Boot apps.
Run the command "mvn package" in one of these directories and it will create the executable jar which can be started as "java -jar target\jarA-0.0.1.jar"
This can be used for separate developing and testing. This jar can't be used as a library jar to create the deployable war. The flag “-Dsimple-jar” must be used to create the library jar.

