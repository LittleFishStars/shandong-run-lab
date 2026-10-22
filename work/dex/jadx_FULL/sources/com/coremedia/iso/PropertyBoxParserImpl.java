package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PropertyBoxParserImpl extends AbstractBoxParser {
    static String[] EMPTY_STRING_ARRAY = new String[0];
    Properties mapping;
    Pattern constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
    StringBuilder buildLookupStrings = new StringBuilder();
    ThreadLocal<String> clazzName = new ThreadLocal<>();
    ThreadLocal<String[]> param = new ThreadLocal<>();

    public PropertyBoxParserImpl(String... strArr) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/isoparser-default.properties");
        try {
            Properties properties = new Properties();
            this.mapping = properties;
            try {
                properties.load(resourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    InputStream inputStreamOpenStream = resources.nextElement().openStream();
                    try {
                        this.mapping.load(inputStreamOpenStream);
                        inputStreamOpenStream.close();
                    } catch (Throwable th) {
                        inputStreamOpenStream.close();
                        throw th;
                    }
                }
                for (String str : strArr) {
                    this.mapping.load(getClass().getResourceAsStream(str));
                }
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th2) {
            try {
                resourceAsStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th2;
        }
    }

    @Override // com.coremedia.iso.AbstractBoxParser
    public Box createBox(String str, byte[] bArr, String str2) {
        invoke(str, bArr, str2);
        String[] strArr = this.param.get();
        try {
            Class<?> cls = Class.forName(this.clazzName.get());
            if (strArr.length <= 0) {
                return (Box) cls.newInstance();
            }
            Class<?>[] clsArr = new Class[strArr.length];
            Object[] objArr = new Object[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                if ("userType".equals(strArr[i])) {
                    objArr[i] = bArr;
                    clsArr[i] = byte[].class;
                } else if ("type".equals(strArr[i])) {
                    objArr[i] = str;
                    clsArr[i] = String.class;
                } else {
                    if (!"parent".equals(strArr[i])) {
                        throw new InternalError("No such param: " + strArr[i]);
                    }
                    objArr[i] = str2;
                    clsArr[i] = String.class;
                }
            }
            return (Box) cls.getConstructor(clsArr).newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void invoke(String str, byte[] bArr, String str2) {
        String property;
        if (bArr == null) {
            property = this.mapping.getProperty(str);
            if (property == null) {
                StringBuilder sb = this.buildLookupStrings;
                sb.append(str2);
                sb.append('-');
                sb.append(str);
                String string = sb.toString();
                this.buildLookupStrings.setLength(0);
                property = this.mapping.getProperty(string);
            }
        } else {
            if (!"uuid".equals(str)) {
                throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
            }
            property = this.mapping.getProperty("uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
            if (property == null) {
                property = this.mapping.getProperty(String.valueOf(str2) + "-uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
            }
            if (property == null) {
                property = this.mapping.getProperty("uuid");
            }
        }
        if (property == null) {
            property = this.mapping.getProperty("default");
        }
        if (property == null) {
            throw new RuntimeException("No box object found for " + str);
        }
        if (!property.endsWith(")")) {
            this.param.set(EMPTY_STRING_ARRAY);
            this.clazzName.set(property);
            return;
        }
        Matcher matcher = this.constuctorPattern.matcher(property);
        if (!matcher.matches()) {
            throw new RuntimeException("Cannot work with that constructor: " + property);
        }
        this.clazzName.set(matcher.group(1));
        if (matcher.group(2).length() == 0) {
            this.param.set(EMPTY_STRING_ARRAY);
        } else {
            this.param.set(matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0]);
        }
    }

    public PropertyBoxParserImpl(Properties properties) {
        this.mapping = properties;
    }
}
