package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t {
    public static Map<String, String> a(File file) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                Object object = objectInputStream.readObject();
                if (!(object instanceof Map)) {
                    objectInputStream.close();
                    return null;
                }
                Map<String, String> map = (Map) object;
                objectInputStream.close();
                return map;
            } catch (Throwable th) {
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return null;
        }
        return null;
    }

    public static String b(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    return sb.toString();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                th.printStackTrace();
            }
            bufferedReader.close();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
