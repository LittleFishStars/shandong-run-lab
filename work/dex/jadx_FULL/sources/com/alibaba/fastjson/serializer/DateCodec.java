package com.alibaba.fastjson.serializer;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r6v25, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Date(TypeUtils.longValue((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String strSubstring = (String) obj2;
        if (strSubstring.length() == 0) {
            return null;
        }
        if (strSubstring.length() == 23 && strSubstring.endsWith(" 000")) {
            strSubstring = strSubstring.substring(0, 19);
        }
        JSONScanner jSONScanner = new JSONScanner(strSubstring);
        try {
            if (jSONScanner.scanISO8601DateIfMatch(false)) {
                ?? r6 = (T) jSONScanner.getCalendar();
                if (type == Calendar.class) {
                    jSONScanner.close();
                    return r6;
                }
                T t = (T) r6.getTime();
                jSONScanner.close();
                return t;
            }
            jSONScanner.close();
            String dateFomartPattern = defaultJSONParser.getDateFomartPattern();
            if (strSubstring.length() == dateFomartPattern.length() || (strSubstring.length() == 22 && dateFomartPattern.equals("yyyyMMddHHmmssSSSZ")) || (strSubstring.indexOf(84) != -1 && dateFomartPattern.contains("'T'") && strSubstring.length() + 2 == dateFomartPattern.length())) {
                try {
                    return (T) defaultJSONParser.getDateFormat().parse(strSubstring);
                } catch (ParseException unused) {
                }
            }
            if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
            }
            if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf(124);
            if (iLastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    JSONScanner jSONScanner2 = new JSONScanner(strSubstring.substring(0, iLastIndexOf));
                    try {
                        if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                            ?? r7 = (T) jSONScanner2.getCalendar();
                            r7.setTimeZone(timeZone);
                            return type == Calendar.class ? r7 : (T) r7.getTime();
                        }
                    } finally {
                        jSONScanner2.close();
                    }
                }
            }
            return (T) new Date(Long.parseLong(strSubstring));
        } catch (Throwable th) {
            jSONScanner.close();
            throw th;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class && !serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            long time = ((java.sql.Date) obj).getTime();
            if ((time + ((long) jSONSerializer.timeZone.getOffset(time))) % 86400000 == 0 && !SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteClassName)) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time2 = ((Time) obj).getTime();
            if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2 / 1000);
                return;
            } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2);
                return;
            } else if (time2 < 86400000) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        Date dateCastToDate = obj instanceof Date ? (Date) obj : TypeUtils.castToDate(obj);
        if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(dateCastToDate.getTime() / 1000);
            return;
        }
        if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(dateCastToDate.getTime());
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                String fastJsonConfigDateFormatPattern = jSONSerializer.getFastJsonConfigDateFormatPattern();
                if (fastJsonConfigDateFormatPattern == null) {
                    fastJsonConfigDateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fastJsonConfigDateFormatPattern, jSONSerializer.locale);
                simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
                dateFormat = simpleDateFormat;
            }
            serializeWriter.writeString(dateFormat.format(dateCastToDate));
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && cls != type) {
            if (cls == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                serializeWriter.write(41);
                return;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(cls.getName());
                serializeWriter.writeFieldValue(',', "val", ((Date) obj).getTime());
                serializeWriter.write(125);
                return;
            }
        }
        long time3 = dateCastToDate.getTime();
        if (!serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            serializeWriter.writeLong(time3);
            return;
        }
        int i2 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        serializeWriter.write(i2);
        Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
        calendar.setTimeInMillis(time3);
        int i3 = calendar.get(1);
        int i4 = calendar.get(2) + 1;
        int i5 = calendar.get(5);
        int i6 = calendar.get(11);
        int i7 = calendar.get(12);
        int i8 = calendar.get(13);
        int i9 = calendar.get(14);
        if (nanos > 0) {
            charArray = "0000-00-00 00:00:00.000000000".toCharArray();
            IOUtils.getChars(nanos, 29, charArray);
            IOUtils.getChars(i8, 19, charArray);
            IOUtils.getChars(i7, 16, charArray);
            IOUtils.getChars(i6, 13, charArray);
            IOUtils.getChars(i5, 10, charArray);
            IOUtils.getChars(i4, 7, charArray);
            IOUtils.getChars(i3, 4, charArray);
        } else if (i9 != 0) {
            char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
            IOUtils.getChars(i9, 23, charArray2);
            IOUtils.getChars(i8, 19, charArray2);
            IOUtils.getChars(i7, 16, charArray2);
            IOUtils.getChars(i6, 13, charArray2);
            IOUtils.getChars(i5, 10, charArray2);
            IOUtils.getChars(i4, 7, charArray2);
            IOUtils.getChars(i3, 4, charArray2);
            charArray = charArray2;
        } else if (i8 == 0 && i7 == 0 && i6 == 0) {
            char[] charArray3 = "0000-00-00".toCharArray();
            IOUtils.getChars(i5, 10, charArray3);
            IOUtils.getChars(i4, 7, charArray3);
            IOUtils.getChars(i3, 4, charArray3);
            charArray = charArray3;
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            IOUtils.getChars(i8, 19, charArray);
            IOUtils.getChars(i7, 16, charArray);
            IOUtils.getChars(i6, 13, charArray);
            IOUtils.getChars(i5, 10, charArray);
            IOUtils.getChars(i4, 7, charArray);
            IOUtils.getChars(i3, 4, charArray);
        }
        if (nanos > 0) {
            int i10 = 0;
            while (i10 < 9 && charArray[(charArray.length - i10) - 1] == '0') {
                i10++;
            }
            serializeWriter.write(charArray, 0, charArray.length - i10);
            serializeWriter.write(i2);
            return;
        }
        serializeWriter.write(charArray);
        float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
        int i11 = (int) offset;
        if (i11 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            serializeWriter.write(90);
        } else {
            if (i11 > 9) {
                serializeWriter.write(43);
                serializeWriter.writeInt(i11);
            } else if (i11 > 0) {
                serializeWriter.write(43);
                serializeWriter.write(48);
                serializeWriter.writeInt(i11);
            } else if (i11 < -9) {
                serializeWriter.write(45);
                serializeWriter.writeInt(-i11);
            } else if (i11 < 0) {
                serializeWriter.write(45);
                serializeWriter.write(48);
                serializeWriter.writeInt(-i11);
            }
            serializeWriter.write(58);
            serializeWriter.append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) (Math.abs(offset - i11) * 60.0f))));
        }
        serializeWriter.write(i2);
    }
}
