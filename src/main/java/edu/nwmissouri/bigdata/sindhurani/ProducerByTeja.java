package edu.nwmissouri.bigdata.sindhurani;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ProducerByTeja{
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
	    
	   
	      String message = findvowels();
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
	  
	  private static String findvowels(){
		  String line = "This website is aw3som3.";
    int vowels = 0, consonants = 0, digits = 0, spaces = 0;

    line = line.toLowerCase();
    for (int i = 0; i < line.length(); ++i) {
      char ch = line.charAt(i);

      // check if character is any of a, e, i, o, u
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        ++vowels;
      }

      // check if character is in between a to z
      else if ((ch >= 'a' && ch <= 'z')) {
        ++consonants;
      }

      
      // check if character is in between 0 to 9
      else if (ch >= '0' && ch <= '9') {
        ++digits;
      }
      
      // check if character is a white space
      else if (ch == ' ') {
        ++spaces;
      }
    }

   

return "Vowels: " + vowels+ ", Consonants: " + consonants+", Digits: " + digits+", White spaces: " + spaces;
 
	  }
}