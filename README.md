# kafka-java-group3


## Team Lead
- ### Sindhu Rani Goli-[Github Profile](https://github.com/sindhurani29)
- I have created ProducerBySindhuRaniGoli.java class to display the given string with spaces removed.

## Team Memebers
* Naga Anshitha Velagapudi-[Github Profile](https://github.com/anshithavelagapudi)
* Tarun Sarpanjeri-[Github Profile](https://github.com/dexterstr)
* ### Tejaswi Reddy Kandula-[Github Profile](https://github.com/Teju2404) 
- I have created ProducerByTeja.java and worked on displaying number of "Vowels,Consonants,Digits,white spaces" in a string.
* Sindhuja Valeti-[Github Profile](https://github.com/Sindhujav18)
* Mohan Krishna Alavala-[Github Profile](https://github.com/Mohanalavala)

## Commands to Start Services:

- Note: Always use a new Powershell as Administrator window  to run the services and leave the window open.

### Zookeeper:
- To start a zookeeper service, open Powershell in your C:\kafka_2.13-2.7.0 directory and run this command

```Powershell
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
### Kafka:
- To start a kafka service, open Powershell in your C:\kafka_2.13-2.7.0 directory and run this command

```Powershell
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
### Create a topic
- Create a new topic,open Powershell in your C:\kafka_2.13-2.7.0 directory and run this command

```PowerShell
 .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic Universities
```
## Compile and Build the Fat Jar File

- Open PowerShell in the root project folder, then compile the code using Maven and create an executable jar file. Generated artificacts can be found in the new 'target' folder.

```PowerShell
mvn clean compile assembly:single
```
## Consumer

- Open PowerShell in the root project folder, start the original consumer app using topic Universities and group1 with:

```PowerShell
  java -cp target/kafka-java-group3-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.sindhurani.Consumer Universities group1
```
## Producer

- Open PowerShell in the root project folder then, start the Producer app using topic Universities:

```PowerShell
 
  java -cp target/kafka-java-group3-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.sindhurani.ProducerByTeja Univiersities
```
