package com.alipay.sdk.m.d0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    /* JADX WARN: Code duplicated, block: B:22:0x0040 A[Catch: all -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0043, blocks: (B:11:0x002d, B:22:0x0040), top: B:29:0x0006 }] */
    public static String a(String str, String str2) throws Throwable {
        Throwable th;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                File file = new File(str, str2);
                if (!file.exists()) {
                    return null;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader == null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (Throwable unused2) {
                            throw th;
                        }
                    }
                }
                bufferedReader2.close();
                return sb.toString();
            } catch (Throwable unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th3) {
            th = th3;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }
}
