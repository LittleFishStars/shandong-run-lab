package com.easyjson.serializer;

import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    private DecimalFormat decimalFormat;

    private NumberCodec() {
        this.decimalFormat = null;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }

    public NumberCodec(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.lang.Number, java.math.BigDecimal] */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strNumberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(strNumberString));
            }
            if (type == Float.TYPE || type == Float.class) {
                String strNumberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(strNumberString2));
            }
            long jLongValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf((short) jLongValue);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf((byte) jLongValue);
            }
            return (jLongValue < -2147483648L || jLongValue > 2147483647L) ? (T) Long.valueOf(jLongValue) : (T) Integer.valueOf((int) jLongValue);
        }
        if (i != 3) {
            Object obj2 = defaultJSONParser.parse();
            if (obj2 == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return (T) TypeUtils.castToDouble(obj2);
            }
            if (type == Float.TYPE || type == Float.class) {
                return (T) TypeUtils.castToFloat(obj2);
            }
            if (type == Short.TYPE || type == Short.class) {
                return (T) TypeUtils.castToShort(obj2);
            }
            return (type == Byte.TYPE || type == Byte.class) ? (T) TypeUtils.castToByte(obj2) : (T) TypeUtils.castToBigDecimal(obj2);
        }
        if (type == Double.TYPE || type == Double.class) {
            String strNumberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(strNumberString3));
        }
        if (type == Float.TYPE || type == Float.class) {
            String strNumberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Float.valueOf(Float.parseFloat(strNumberString4));
        }
        ?? r8 = (T) jSONLexer.decimalValue();
        jSONLexer.nextToken(16);
        if (type == Short.TYPE || type == Short.class) {
            return (T) Short.valueOf(r8.shortValue());
        }
        return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r8.byteValue()) : r8;
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String string;
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
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (Float.isNaN(fFloatValue) || Float.isInfinite(fFloatValue)) {
                serializeWriter.writeNull();
                return;
            }
            String string2 = Float.toString(fFloatValue);
            if (string2.endsWith(".0")) {
                string2 = string2.substring(0, string2.length() - 2);
            }
            serializeWriter.write(string2);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                serializeWriter.write(70);
                return;
            }
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            string = Double.toString(dDoubleValue);
            if (string.endsWith(".0")) {
                string = string.substring(0, string.length() - 2);
            }
        } else {
            string = decimalFormat.format(dDoubleValue);
        }
        serializeWriter.append((CharSequence) string);
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            serializeWriter.write(68);
        }
    }
}
