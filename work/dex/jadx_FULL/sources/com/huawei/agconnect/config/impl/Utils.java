package com.huawei.agconnect.config.impl;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(TAG, "Exception when closing the 'Closeable'.");
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                return;
            } else {
                writer.write(cArr, 0, i);
            }
        }
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map2.put(fixPath(entry.getKey()), entry.getValue());
        }
        return map2;
    }

    public static String fixPath(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return WVNativeCallbackUtil.SEPERATER + str.substring(i);
    }

    public static AGCRoutePolicy getRoutePolicyFromJson(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return AGCRoutePolicy.CHINA;
                }
                if (str2.contains("connect-dre")) {
                    return AGCRoutePolicy.GERMANY;
                }
                if (str2.contains("connect-drru")) {
                    return AGCRoutePolicy.RUSSIA;
                }
                if (str2.contains("connect-dra")) {
                    return AGCRoutePolicy.SINGAPORE;
                }
            }
            return AGCRoutePolicy.UNKNOWN;
        }
        switch (str) {
            case "CN":
                return AGCRoutePolicy.CHINA;
            case "DE":
                return AGCRoutePolicy.GERMANY;
            case "RU":
                return AGCRoutePolicy.RUSSIA;
            case "SG":
                return AGCRoutePolicy.SINGAPORE;
            default:
                return AGCRoutePolicy.UNKNOWN;
        }
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
