package com.byazt.wr;

import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.acse.ottn.p3;
import com.alipay.sdk.m.y.l;
import com.byazt.nr.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 34})
public class a implements com.byazt.yy.c, com.byazt.yy.tt {
    public final com.byazt.iy.ve c;
    public final boolean tt;

    public a(com.byazt.iy.ve veVar) {
        this.c = veVar;
        this.tt = false;
    }

    @Override // com.byazt.yy.c
    public Map<String, Object> c(File file) throws Throwable {
        HashMap map = new HashMap();
        if (!file.exists()) {
            return map;
        }
        if (!file.canRead()) {
            m.tt("XmlSimpleReader", "can't read file " + file);
            return map;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream2, null);
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 2) {
                            String name = xmlPullParserNewPullParser.getName();
                            if (TypedValues.Custom.S_STRING.equals(name) || "int".equals(name) || "long".equals(name) || TypedValues.Custom.S_FLOAT.equals(name) || TypedValues.Custom.S_BOOLEAN.equals(name) || p3.h.equals(name)) {
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                                Object objC = c(xmlPullParserNewPullParser, name);
                                if (attributeValue != null && objC != null) {
                                    map.put(attributeValue, objC);
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return new com.byazt.et.tt().c(map, this.c, this.tt);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return new com.byazt.et.tt().c(map, this.c, this.tt);
    }

    public a(com.byazt.iy.ve veVar, boolean z) {
        this.c = veVar;
        this.tt = z;
    }

    private Object c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            case "set":
                return c(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, "value")));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value")));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "value")));
            default:
                return null;
        }
    }

    private Set<String> c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && p3.h.equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && TypedValues.Custom.S_STRING.equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void c(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.attribute(null, "name", str);
            xmlSerializer.text(c((String) obj));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
            return;
        }
        if (obj instanceof Integer) {
            c(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            c(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            c(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            c(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            c(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            c(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void c(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void c(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void c(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_FLOAT);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_FLOAT);
    }

    private void c(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void c(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_BOOLEAN);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_BOOLEAN);
    }

    private void c(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, p3.h);
        xmlSerializer.attribute(null, "name", str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.text(c(str2));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
        }
        xmlSerializer.endTag(null, p3.h);
    }

    @Override // com.byazt.yy.tt
    public void c(Map<String, Object> map, File file) throws Throwable {
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> mapTt = new com.byazt.et.tt().tt(map, this.c, this.tt);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                    xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                    xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                    xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    xmlSerializerNewSerializer.startTag(null, "map");
                    for (String str : mapTt.keySet()) {
                        if (str != null) {
                            c(str, mapTt.get(str), xmlSerializerNewSerializer);
                        }
                    }
                    xmlSerializerNewSerializer.endTag(null, "map");
                    xmlSerializerNewSerializer.endDocument();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    m.tt("XmlSimpleReader", "write file exception ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String c(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < ' ' || cCharAt > 55295) && !((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (cCharAt == '\"') {
                    sb.append("&quot;");
                } else if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt != '\'') {
                    if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                        char cCharAt2 = str.charAt(i);
                        if (Character.isLowSurrogate(cCharAt2)) {
                            sb.append(cCharAt);
                            sb.append(cCharAt2);
                            i2 = i;
                        }
                    } else {
                        sb.append("&#");
                        sb.append((int) cCharAt);
                        sb.append(l.b);
                    }
                } else {
                    sb.append("&apos;");
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
