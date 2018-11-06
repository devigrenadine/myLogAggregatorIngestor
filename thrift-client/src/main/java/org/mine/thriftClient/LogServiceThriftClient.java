package org.mine.thriftClient;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.thrift.transport.TTransport;
import org.mine.myThrift.Log;
import org.mine.myThrift.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class LogServiceThriftClient.
 * 
 * * *NOTE* : serverAddress,server port are configurable as all value annotated
 * parameters in our module application.properties thus avoiding hard-coded
 * values alligned with clean code principles
 * 
 */
@Component
public class LogServiceThriftClient {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceThriftClient.class);

	/** The server address. */
	@Value("${thrift.server.address}")
	private String serverAddress;

	/** The server port. */
	@Value("${thrift.server.port}")
	private int serverPort;

	/**
	 * Send.
	 *
	 * @param log the log
	 * @throws TException the t exception
	 */
	public void send(final Log log) throws TException {
		TTransport transport = null;
		try {
			transport = new TSocket(this.serverAddress, this.serverPort);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			LogService.Client client = new LogService.Client(protocol);

			/**
			 * GetLog is Thrift server's remote function.
			 *
			 * @param log the log
			 */
			client.getLog(log);
		} catch (TException tte) {
			throw tte;
		} finally {
			if (transport != null)
				transport.close();
		}
	}
}