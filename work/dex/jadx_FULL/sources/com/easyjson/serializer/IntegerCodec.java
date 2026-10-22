package com.easyjson.serializer;

import com.easyjson.JSONException;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e) {
                    throw new JSONException("int value overflow, field : " + obj, e);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        }
        if (i == 3) {
            BigDecimal bigDecimalDecimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(bigDecimalDecimalValue.longValue()) : (T) Integer.valueOf(bigDecimalDecimalValue.intValue());
        }
        T t2 = (T) defaultJSONParser.parse();
        try {
            t2 = (type == Long.TYPE || type == Long.class) ? (T) TypeUtils.castToLong(t2) : (T) TypeUtils.castToInt(t2);
            return t2;
        } catch (Exception e2) {
            throw new JSONException("cast error, field : " + obj + ", value " + t2, e2);
        }
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        int i;
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                i = 66;
            } else if (cls == Short.class) {
                i = 83;
            } else {
                if (cls != Long.class) {
                    return;
                }
                long jLongValue = number.longValue();
                if (jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
                    return;
                } else {
                    i = 76;
                }
            }
            serializeWriter.write(i);
        }
    }
}
