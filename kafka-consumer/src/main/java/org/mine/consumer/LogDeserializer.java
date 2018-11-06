package org.mine.consumer;

import java.util.Arrays;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.mine.myThrift.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class LogDeserializer.
 */
public class LogDeserializer implements Deserializer<Log> {

	/**
	 * Close.
	 */
	@Override
	public void close() {
		// No-op
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// No-op
	}

	/**
	 * Deserialize.
	 * 
	 *
	 * @param topic the topic
	 * @param data the data
	 * @return the log
	 */
	@Override
	public Log deserialize(String topic, byte[] data) {
		Log cp = new Log();
		try {
			TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
			deserializer.deserialize(cp, data);
			return cp;
		} catch (Exception ex) {
			throw new SerializationException(
					"Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
		}
	}
}
