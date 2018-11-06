/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.mine.myThrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-10-18")
public class Log implements org.apache.thrift.TBase<Log, Log._Fields>, java.io.Serializable, Cloneable, Comparable<Log> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Log");

  private static final org.apache.thrift.protocol.TField V_FIELD_DESC = new org.apache.thrift.protocol.TField("v", org.apache.thrift.protocol.TType.I16, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("time", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField M_FIELD_DESC = new org.apache.thrift.protocol.TField("m", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LogStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LogTupleSchemeFactory());
  }

  public short v; // required
  public long time; // required
  public String m; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    V((short)1, "v"),
    TIME((short)2, "time"),
    M((short)3, "m");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // V
          return V;
        case 2: // TIME
          return TIME;
        case 3: // M
          return M;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __V_ISSET_ID = 0;
  private static final int __TIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.V, new org.apache.thrift.meta_data.FieldMetaData("v", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.TIME, new org.apache.thrift.meta_data.FieldMetaData("time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.M, new org.apache.thrift.meta_data.FieldMetaData("m", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Log.class, metaDataMap);
  }

  public Log() {
  }

  public Log(
    short v,
    long time,
    String m)
  {
    this();
    this.v = v;
    setVIsSet(true);
    this.time = time;
    setTimeIsSet(true);
    this.m = m;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Log(Log other) {
    __isset_bitfield = other.__isset_bitfield;
    this.v = other.v;
    this.time = other.time;
    if (other.isSetM()) {
      this.m = other.m;
    }
  }

  public Log deepCopy() {
    return new Log(this);
  }

  @Override
  public void clear() {
    setVIsSet(false);
    this.v = 0;
    setTimeIsSet(false);
    this.time = 0;
    this.m = null;
  }

  public short getV() {
    return this.v;
  }

  public Log setV(short v) {
    this.v = v;
    setVIsSet(true);
    return this;
  }

  public void unsetV() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __V_ISSET_ID);
  }

  /** Returns true if field v is set (has been assigned a value) and false otherwise */
  public boolean isSetV() {
    return EncodingUtils.testBit(__isset_bitfield, __V_ISSET_ID);
  }

  public void setVIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __V_ISSET_ID, value);
  }

  public long getTime() {
    return this.time;
  }

  public Log setTime(long time) {
    this.time = time;
    setTimeIsSet(true);
    return this;
  }

  public void unsetTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIME_ISSET_ID);
  }

  /** Returns true if field time is set (has been assigned a value) and false otherwise */
  public boolean isSetTime() {
    return EncodingUtils.testBit(__isset_bitfield, __TIME_ISSET_ID);
  }

  public void setTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIME_ISSET_ID, value);
  }

  public String getM() {
    return this.m;
  }

  public Log setM(String m) {
    this.m = m;
    return this;
  }

  public void unsetM() {
    this.m = null;
  }

  /** Returns true if field m is set (has been assigned a value) and false otherwise */
  public boolean isSetM() {
    return this.m != null;
  }

  public void setMIsSet(boolean value) {
    if (!value) {
      this.m = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case V:
      if (value == null) {
        unsetV();
      } else {
        setV((Short)value);
      }
      break;

    case TIME:
      if (value == null) {
        unsetTime();
      } else {
        setTime((Long)value);
      }
      break;

    case M:
      if (value == null) {
        unsetM();
      } else {
        setM((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case V:
      return getV();

    case TIME:
      return getTime();

    case M:
      return getM();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case V:
      return isSetV();
    case TIME:
      return isSetTime();
    case M:
      return isSetM();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Log)
      return this.equals((Log)that);
    return false;
  }

  public boolean equals(Log that) {
    if (that == null)
      return false;

    boolean this_present_v = true;
    boolean that_present_v = true;
    if (this_present_v || that_present_v) {
      if (!(this_present_v && that_present_v))
        return false;
      if (this.v != that.v)
        return false;
    }

    boolean this_present_time = true;
    boolean that_present_time = true;
    if (this_present_time || that_present_time) {
      if (!(this_present_time && that_present_time))
        return false;
      if (this.time != that.time)
        return false;
    }

    boolean this_present_m = true && this.isSetM();
    boolean that_present_m = true && that.isSetM();
    if (this_present_m || that_present_m) {
      if (!(this_present_m && that_present_m))
        return false;
      if (!this.m.equals(that.m))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_v = true;
    list.add(present_v);
    if (present_v)
      list.add(v);

    boolean present_time = true;
    list.add(present_time);
    if (present_time)
      list.add(time);

    boolean present_m = true && (isSetM());
    list.add(present_m);
    if (present_m)
      list.add(m);

    return list.hashCode();
  }

  @Override
  public int compareTo(Log other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetV()).compareTo(other.isSetV());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.v, other.v);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTime()).compareTo(other.isSetTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.time, other.time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetM()).compareTo(other.isSetM());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetM()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.m, other.m);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Log(");
    boolean first = true;

    sb.append("v:");
    sb.append(this.v);
    first = false;
    if (!first) sb.append(", ");
    sb.append("time:");
    sb.append(this.time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("m:");
    if (this.m == null) {
      sb.append("null");
    } else {
      sb.append(this.m);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LogStandardSchemeFactory implements SchemeFactory {
    public LogStandardScheme getScheme() {
      return new LogStandardScheme();
    }
  }

  private static class LogStandardScheme extends StandardScheme<Log> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Log struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // V
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.v = iprot.readI16();
              struct.setVIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.time = iprot.readI64();
              struct.setTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // M
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.m = iprot.readString();
              struct.setMIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Log struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(V_FIELD_DESC);
      oprot.writeI16(struct.v);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIME_FIELD_DESC);
      oprot.writeI64(struct.time);
      oprot.writeFieldEnd();
      if (struct.m != null) {
        oprot.writeFieldBegin(M_FIELD_DESC);
        oprot.writeString(struct.m);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LogTupleSchemeFactory implements SchemeFactory {
    public LogTupleScheme getScheme() {
      return new LogTupleScheme();
    }
  }

  private static class LogTupleScheme extends TupleScheme<Log> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Log struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetV()) {
        optionals.set(0);
      }
      if (struct.isSetTime()) {
        optionals.set(1);
      }
      if (struct.isSetM()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetV()) {
        oprot.writeI16(struct.v);
      }
      if (struct.isSetTime()) {
        oprot.writeI64(struct.time);
      }
      if (struct.isSetM()) {
        oprot.writeString(struct.m);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Log struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.v = iprot.readI16();
        struct.setVIsSet(true);
      }
      if (incoming.get(1)) {
        struct.time = iprot.readI64();
        struct.setTimeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.m = iprot.readString();
        struct.setMIsSet(true);
      }
    }
  }

}

