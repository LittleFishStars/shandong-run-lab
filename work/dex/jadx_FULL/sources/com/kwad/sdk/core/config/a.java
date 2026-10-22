package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static final String[] aMV = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean cP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            return eg(host) || eh(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean eg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aMV) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean eh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e.Jv().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
