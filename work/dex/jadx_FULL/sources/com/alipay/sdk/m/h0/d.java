package com.alipay.sdk.m.h0;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25443a = "";
    public static String b = "";
    public static String c = "";

    public static synchronized void a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList);
    }

    public static synchronized void a(String str, String str2, String str3) {
        f25443a = str;
        b = str2;
        c = str3;
    }

    public static synchronized void a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(th));
        a(arrayList);
    }

    public static synchronized void a(List<String> list) {
        if (!com.alipay.sdk.m.d0.a.a(b) && !com.alipay.sdk.m.d0.a.a(c)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(c);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(", " + it.next());
            }
            stringBuffer.append("\n");
            try {
                File file = new File(f25443a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f25443a, b);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                fileWriter.write(stringBuffer.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
