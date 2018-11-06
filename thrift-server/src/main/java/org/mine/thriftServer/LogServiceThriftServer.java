package org.mine.thriftServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.mine.myThrift.LogService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class LogServiceThriftServer.
 *
 * LogServiceThriftServer listens to a specified port 
 * for incoming calls from thrift clients and passes them
 * to LogService
 *
 */

@Component
public class LogServiceThriftServer {
	
	/** The log service. */
	@Autowired
	LogService.Iface logService;
	
	/** The server. */
	private TServer server;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceThriftServer.class);
	
	/** The server port. */
    @Value("${thrift.server.port}")
	private int serverPort;
    
    /**
     * Start.
     */
    public void start()  {
    
    try {
        TServerTransport serverTransport = new TServerSocket(serverPort);
        server = new TSimpleServer(new TServer.Args(serverTransport).processor(new LogService.Processor<>(logService)));
        /** Starting the  t-server */
        LOGGER.info("Starting the  t-server...");
        server.serve();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    /**
     * Stop.
     */
    public void stop() {
            server.stop();
            LOGGER.info("Stopping the t-server...");
    }
}
