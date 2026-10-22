package com.easyjson.serializer;

import com.easyjson.JSON;
import com.easyjson.JSONException;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.Feature;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import com.google.common.net.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    private DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.util.Calendar] */
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        JSONLexer jSONLexer = new JSONLexer(str);
        try {
            if (!jSONLexer.scanISO8601DateIfMatch(false)) {
                jSONLexer.close();
                try {
                    return (T) defaultJSONParser.getDateFormat().parse(str);
                } catch (ParseException unused) {
                    return (T) new Date(Long.parseLong(str));
                }
            }
            ?? r2 = (T) jSONLexer.getCalendar();
            if (type == Calendar.class) {
                jSONLexer.close();
                return r2;
            }
            T t = (T) r2.getTime();
            jSONLexer.close();
            return t;
        } catch (Throwable th) {
            jSONLexer.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, java.util.Calendar] */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object objValueOf;
        Object obj2;
        String strStringVal;
        Object time;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Object objValueOf2 = Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
            obj2 = objValueOf2;
        } else if (i == 4) {
            strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if ((jSONLexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(strStringVal);
                if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                    ?? r1 = (T) jSONLexer2.getCalendar();
                    if (type == Calendar.class) {
                        obj2 = strStringVal;
                        time = strStringVal;
                        jSONLexer2.close();
                        return r1;
                    }
                    obj2 = strStringVal;
                    time = strStringVal;
                    time = r1.getTime();
                }
                obj2 = strStringVal;
                time = strStringVal;
                jSONLexer2.close();
                obj2 = time;
            }
        } else if (i == 8) {
            jSONLexer.nextToken();
            obj2 = null;
        } else {
            if (i == 12) {
                jSONLexer.nextToken();
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                if (JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    Type typeLoadClass = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader);
                    if (typeLoadClass != null) {
                        type = typeLoadClass;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                jSONLexer.nextTokenWithChar(c.b);
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error : " + jSONLexer.tokenName());
                }
                long jLongValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                objValueOf = Long.valueOf(jLongValue);
            } else if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
                defaultJSONParser.accept(16);
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(jSONLexer.stringVal())) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                objValueOf = defaultJSONParser.parse();
            } else {
                obj2 = defaultJSONParser.parse();
            }
            defaultJSONParser.accept(13);
            obj2 = objValueOf;
        }
        obj2 = strStringVal;
        T t = (T) cast(defaultJSONParser, type, obj, obj2);
        if (type != Calendar.class || (t instanceof Calendar)) {
            return t;
        }
        Date date = (Date) t;
        if (date == null) {
            return null;
        }
        ?? r13 = (T) Calendar.getInstance(jSONLexer.timeZone, jSONLexer.locale);
        r13.setTime(date);
        return r13;
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        char[] charArray;
        int i;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                i = 41;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeLong(((Date) obj).getTime());
                i = 125;
            }
            serializeWriter.write(i);
            return;
        }
        Date time = obj instanceof Calendar ? ((Calendar) obj).getTime() : (Date) obj;
        if ((serializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(time));
            return;
        }
        long time2 = time.getTime();
        int i2 = serializeWriter.features;
        if ((SerializerFeature.UseISO8601DateFormat.mask & i2) == 0) {
            serializeWriter.writeLong(time2);
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseSingleQuotes;
        if ((i2 & serializerFeature.mask) != 0) {
            serializeWriter.write(39);
        } else {
            serializeWriter.write(34);
        }
        Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
        calendar.setTimeInMillis(time2);
        int i3 = calendar.get(1);
        int i4 = calendar.get(2) + 1;
        int i5 = calendar.get(5);
        int i6 = calendar.get(11);
        int i7 = calendar.get(12);
        int i8 = calendar.get(13);
        int i9 = calendar.get(14);
        if (i9 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            SerializeWriter.getChars(i9, 23, charArray);
            SerializeWriter.getChars(i8, 19, charArray);
            SerializeWriter.getChars(i7, 16, charArray);
            SerializeWriter.getChars(i6, 13, charArray);
            SerializeWriter.getChars(i5, 10, charArray);
            SerializeWriter.getChars(i4, 7, charArray);
            SerializeWriter.getChars(i3, 4, charArray);
        } else if (i8 == 0 && i7 == 0 && i6 == 0) {
            charArray = "0000-00-00".toCharArray();
            SerializeWriter.getChars(i5, 10, charArray);
            SerializeWriter.getChars(i4, 7, charArray);
            SerializeWriter.getChars(i3, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            SerializeWriter.getChars(i8, 19, charArray);
            SerializeWriter.getChars(i7, 16, charArray);
            SerializeWriter.getChars(i6, 13, charArray);
            SerializeWriter.getChars(i5, 10, charArray);
            SerializeWriter.getChars(i4, 7, charArray);
            SerializeWriter.getChars(i3, 4, charArray);
        }
        serializeWriter.write(charArray);
        serializeWriter.write((serializeWriter.features & serializerFeature.mask) != 0 ? 39 : 34);
    }
}
