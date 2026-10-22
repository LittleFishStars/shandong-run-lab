package com.aliyun.vod.common.utils;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StringCodingUtils {
    public static byte[] getBytes(String str, Charset charset) {
        return str.getBytes(charset);
    }
}
