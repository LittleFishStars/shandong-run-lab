package com.alibaba.ariver.integration.ipc.server;

import androidx.collection.LongSparseArray;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f24087a;
    private static LongSparseArray<Set<String>> b = new LongSparseArray<>();
    private static Map<String, SendToNativeCallback> c = new HashMap();

    public static e a() {
        if (f24087a == null) {
            synchronized (e.class) {
                if (f24087a == null) {
                    f24087a = new e();
                }
            }
        }
        return f24087a;
    }

    public synchronized void a(long j, String str, SendToNativeCallback sendToNativeCallback) {
        if (sendToNativeCallback == null) {
            return;
        }
        Set<String> hashSet = b.get(j);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            b.put(j, hashSet);
        }
        hashSet.add(str);
        c.put(str, sendToNativeCallback);
    }

    public synchronized void a(long j) {
        Set<String> set = b.get(j);
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                c.remove(it.next());
            }
            b.remove(j);
        }
    }

    public synchronized SendToNativeCallback a(long j, String str, boolean z) {
        SendToNativeCallback sendToNativeCallback;
        sendToNativeCallback = c.get(str);
        if (!z) {
            c.remove(str);
            Set<String> set = b.get(j);
            if (set != null) {
                set.remove(str);
            }
        }
        return sendToNativeCallback;
    }
}
