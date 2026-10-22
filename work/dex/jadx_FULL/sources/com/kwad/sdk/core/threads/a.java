package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static Map<String, WeakReference<C1288a>> aYp = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C1288a {
        private HandlerThread aYq;
        private Handler jk;

        public C1288a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aYq = handlerThread;
            handlerThread.start();
            this.jk = new Handler(this.aYq.getLooper());
        }

        public final Handler getHandler() {
            return this.jk;
        }
    }

    public static synchronized Handler NR() {
        return fp("reportHT").getHandler();
    }

    @NonNull
    private static C1288a fp(String str) {
        WeakReference<C1288a> weakReference = aYp.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C1288a c1288a = new C1288a(str);
        aYp.put(str, new WeakReference<>(c1288a));
        return c1288a;
    }
}
