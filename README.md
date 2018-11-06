	LOG AGGREGATOR/INGESTOR

	GOAL 					
	The goal of this project is to implement an aggregation/ingestion system for logging events. 
	A thift client sends randomly generated logging events to a server that accepts the events and pushes them on to Kafka. 
	Another server consumes the log events and writes them to a Cassandra database as shown in the following simplified 	communication scheme.

		ThriftClient    <------>   ThriftServer ---->  Kafka Producer --- > Kafka Consumer  --> Cassandra DB
   

	Modules
	 * thrift-client
	 * thrift-server
	 * kafka-consumer
	 * thrift-generator 
	 	description: produces the thrift generated Log,LogService 
	 	and gets injected to the other models as maven dependency
	
	 
	Steps
	1. Execute mvn clean package from root folder
	2. Start zookeeper from kafka
	
		bin/zookeeper-server-start.sh config/zookeeper.properties
	
	 	or if you are using windows
	
		.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
		
	3. Start kafka server
 	 
		bin/kafka-server-start.sh config/server.properties
		
		or if you are using windows
		
		\bin\windows\kafka-server-start.bat .\config\server.properties
	
	4. Start your cassandra 
		/bin/cassandra.sh
	
		or for windows	
	
		/bin/cassandra.bat
		
	5. Run	/bin/cqlsh for cqlsh utility
	
	6. cd to thrift-server 
		and
		 ./run.sh 
		( mvn spring-boot:run) 
	
	7. cd to kafka-consumer 
		and 
		./run.sh 
		( mvn spring-boot:run) 
	 
	8. cd to thrift-client 
		and 
		./run.sh 
		( mvn spring-boot:run) 
	 	 	
		 
	 
	 CASSANDRA CSQL SCRIPTS
	  Check the Cassandra Scripts file in the root parent folder
    
    
    
      APPLICATION.PROPERTIES
       Each module contains an application.properties file under resources folder.
       This file contains the declaration and setting of values (server.adress, server.port, kafka-topic etc.)
       This is to avoid hard-coded values and serves for clean coding and configurability.
       
       TECHNOLOGIES USED
        Java 8
        Spring framework
        Apache Thift 0.9.3
        Apache Kafka 2.11
        Zookeeper 3-4-13
        Apache Cassandra 2.2.13 (chosen instead of version 3 due to incompatibility issues that arose)
       
    
