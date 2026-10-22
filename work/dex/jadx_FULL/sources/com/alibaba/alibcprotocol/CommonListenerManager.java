package com.alibaba.alibcprotocol;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.CommonListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonListenerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23601a = "CommonListenerManager";
    private static Map<String, CommonListener> b = new ConcurrentHashMap();

    public static Map<String, CommonListener> getListenerMap() {
        return b;
    }

    public static synchronized void registerListener(String str, CommonListener commonListener) {
        if (commonListener != null) {
            if (!TextUtils.isEmpty(str)) {
                if (b.get(str) != null) {
                    return;
                }
                b.put(str, commonListener);
            }
        }
    }

    public static synchronized void unRegisterListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.remove(str);
    }
}
