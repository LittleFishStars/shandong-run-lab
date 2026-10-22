package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f26658a = new ThreadLocal();

    public static boolean a() {
        try {
            String str = (String) AccessController.doPrivileged(new b());
            if (str == null) {
                return false;
            }
            int i = d.f26659a;
            char[] charArray = str.toCharArray();
            boolean z = false;
            for (int i2 = 0; i2 != charArray.length; i2++) {
                char c = charArray[i2];
                if ('A' <= c && 'Z' >= c) {
                    charArray[i2] = (char) ((c - 'A') + 97);
                    z = true;
                }
            }
            if (z) {
                str = new String(charArray);
            }
            return "true".equals(str);
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
