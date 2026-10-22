package com.easyjson.serializer;

import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BigDecimalCodec instance = new BigDecimalCodec();

    private BigDecimalCodec() {
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.math.BigDecimal] */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            String strNumberString = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return type == BigInteger.class ? (T) new BigInteger(strNumberString) : (T) new BigDecimal(strNumberString);
        }
        if (i == 3) {
            ?? r5 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return type == BigInteger.class ? (T) r5.toBigInteger() : r5;
        }
        Object obj2 = defaultJSONParser.parse();
        if (obj2 == null) {
            return null;
        }
        return type == BigInteger.class ? (T) TypeUtils.castToBigInteger(obj2) : (T) TypeUtils.castToBigDecimal(obj2);
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof BigInteger) {
            serializeWriter.write(((BigInteger) obj).toString());
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        serializeWriter.write(bigDecimal.toString());
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || type == BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        serializeWriter.write(46);
    }
}
