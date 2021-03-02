package edu.nwmissouri.bigdata.sindhurani;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ProducerByAnshitha{
	 private static Scanner in;

	  public static void main(String[] argv) throws Exception {
	    if (argv.length != 1) {
	      System.err.println("Please specify 1 parameter (the name of the topic)");
	      System.exit(-1);
	    }
	    String topicName = argv[0];
	    in = new Scanner(System.in);
	    System.out.println("Thank you for providing the topic " + topicName + "\n");
	    System.out.println("Enter message (type exit to quit).\n");

	    // Configure the Producer
	    Properties configProperties = new Properties();
	    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.ByteArraySerializer");
	    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.StringSerializer");
	    System.out.println("The configuration properties are: " + configProperties.toString());
	    System.out.println("\nWill use this configuration to create a producer.\n");

	    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

	    // Make our own messages - create your custom logic here
//	    String msg="finding vowels!";
//	    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, msg);
//	    producer.send(record);
	    
	   
	      String message = findCharacters();
	      ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
	      producer.send(record);

	    // still allow input from keyboard
		String line = in.nextLine();
	    while (!line.equals("exit")) {
	      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
	      producer.send(rec);
	      line = in.nextLine();
	    }

	    in.close();
	    producer.close();

	  }
	  
	  private static String findCharacters(){
		  //ASCII values ranges upto 256
	int counter[] = new int[256]; 

	String str="beginnersbook";
	//String length
	int len = str.length(); 

	/* This array holds the occurrence of each char, For example
	 * ASCII value of A is 65 so if A is found twice then 
	 * counter[65] would have the value 2, here 65 is the ASCII value
	 * of A
	 */
	for (int i = 0; i < len; i++) 
		counter[str.charAt(i)]++; 

	// We are creating another array with the size of String
	char array[] = new char[str.length()]; 
        for (int i = 0; i < len; i++) { 
	   array[i] = str.charAt(i); 
	   int flag = 0; 
	   for (int j = 0; j <= i; j++) { 

		/* If a char is found in String then set the flag 
		 * so that we can print the occurrence
		 */
		if (str.charAt(i) == array[j])  
			flag++;                 
	   } 

	   if (flag == 1)  
return "Occurrence of char " + str.charAt(i)
+ " in the String is:" + counter[str.charAt(i)];
 
	  }

	}
}
