package com.aliyun.teaxml;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Client {
    public static Map<String, Object> parseXml(String str, Class cls) {
        try {
            return XmlUtil.DeserializeXml(str, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toXML(Map<String, Object> map) {
        try {
            return XmlUtil.mapToXml(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
