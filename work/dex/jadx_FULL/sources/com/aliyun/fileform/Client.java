package com.aliyun.fileform;

import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public static String getBoundary() {
        return String.format("%014d", Long.valueOf((long) (Math.random() * 1.0E14d)));
    }

    public static InputStream toFileForm(Map<String, Object> map, String str) {
        return new FileFormInputStream(map, str);
    }
}
