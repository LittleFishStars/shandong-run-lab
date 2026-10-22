package com.getui.gtc;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.getui.gtc.g.a;
import com.getui.gtc.g.b;
import java.io.File;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SdkLoader {
    private static void load(Context context, String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
            Constructor<?>[] declaredConstructors = Class.forName(new String(Base64.decode("ZGFsdmlrLnN5c3RlbS5EZXhDbGFzc0xvYWRlcg==", 0))).getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor<?> constructor = declaredConstructors[0];
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str2, a.a(file.getName()));
                if (file2.exists()) {
                    File file3 = new File(str2, file.getName().replace(com.getui.gtc.c.a.b, com.getui.gtc.c.a.f30288a));
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file2.renameTo(file3);
                }
            }
            if (Build.VERSION.SDK_INT >= 34) {
                new File(str).setReadOnly();
            }
            ClassLoader classLoader = (ClassLoader) constructor.newInstance(str, str2, null, context.getClassLoader());
            File file4 = new File(str);
            if (file4.exists()) {
                File file5 = new File(str2, file4.getName().replace(com.getui.gtc.c.a.b, com.getui.gtc.c.a.f30288a));
                if (file5.exists()) {
                    File file6 = new File(str2, a.a(file4.getName()));
                    if (file6.exists()) {
                        file6.delete();
                    }
                    file5.renameTo(file6);
                }
            }
            com.getui.gtc.i.c.a.a(" ---load--- :".concat(String.valueOf(str)));
            b.a(context, classLoader, str3, str4, str5);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            throw th;
        }
    }
}
