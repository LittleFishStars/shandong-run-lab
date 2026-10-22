package com.alibaba.ariver.websocket.core;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24536a = "AriverWebSocket:RVWebSocketManager";
    private final Map<String, f> b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static e f24537a = new e();

        private a() {
        }
    }

    public static e a() {
        return a.f24537a;
    }

    public synchronized f b(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(f24536a, "getSocketSession: socketId is empty.");
            return null;
        }
        return this.b.get(str);
    }

    private e() {
        this.b = new HashMap();
    }

    public synchronized f a(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(f24536a, "createSocketSession: socketId is empty.");
            return null;
        }
        f fVar = this.b.get(str);
        if (fVar == null) {
            RVLogger.d(f24536a, String.format("getSocketSession: new WebSocketSession id:[%s]", str));
        } else {
            fVar.b();
            this.b.remove(str);
        }
        f fVar2 = new f(str);
        this.b.put(str, fVar2);
        return fVar2;
    }
}
