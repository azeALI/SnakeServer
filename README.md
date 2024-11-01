An RDBMS is required to run the project.MySQL is used in this projec.
If you want to use other RDBMS, edit pom.xml file, there is a dependency named "com.mysql". You can change the  dependency according to your driver.
You can find drivers in maven repo : https://mvnrepository.com/open-source/jdbc-drivers. Just select the driver, select the version, and change lines between <dependency>....<dependency> tags according to yor driver.


You have to configure your database credentials first. Go to src/main/resources , edit application.properties file to your needs.
Then come to the root folder of project and run this to build the project: $ mvn install  
target folder will appear on root directory, go into it and there will be a .jar file, you can run it with : $ java -jar somejarfile.jar
