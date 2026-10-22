package com.ali.auth.third.core.rpc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static ByteArrayOutputStream a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static String a(String str) {
        return "utf-8";
    }

    public static void a(int i) {
        if (i == 200) {
            return;
        }
        throw new RuntimeException("http request exception, response code: " + i);
    }
}
