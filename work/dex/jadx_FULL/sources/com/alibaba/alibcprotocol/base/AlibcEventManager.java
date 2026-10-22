package com.alibaba.alibcprotocol.base;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcEventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, ICommonListener> f23604a = new ConcurrentHashMap();

    public static Map<String, ICommonListener> getListenerMap() {
        return f23604a;
    }

    public static synchronized void registerListener(String str, ICommonListener iCommonListener) {
        if (iCommonListener != null) {
            if (!TextUtils.isEmpty(str)) {
                if (f23604a.get(str) != null) {
                    return;
                }
                f23604a.put(str, iCommonListener);
            }
        }
    }

    public static synchronized void unRegisterListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f23604a.remove(str);
    }
}
