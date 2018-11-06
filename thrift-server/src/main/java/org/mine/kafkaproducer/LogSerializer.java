package org.mine.kafkaproducer;

import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.mine.myThrift.Log;

/**
 * The Class LogSerializer implements serializable Serializes our log data to a
 * byte representation in order to be sent to our kafka topic
 */
public class LogSerializer implements Serializer<Log> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// no-op
	}

	@Override
	public byte[] serialize(String topic, Log payload) {
		try {
			TSerializer ser = new TSerializer(new TBinaryProtocol.Factory());
			return ser.serialize(payload);
		} catch (TException ex) {
			throw new SerializationException("Can't serialize data='" + payload + "' for topic='" + topic + "'", ex);
		}
	}

	@Override
	public void close() {
		// no-op
	}
}
