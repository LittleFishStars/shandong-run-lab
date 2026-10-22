package com.byazt.sx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.ng.a;
import com.byazt.vx.qy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 928, 15})
public class uj {
    public static Context c;
    public static volatile c tt;
    public static volatile c ve;

    @com.byazt.zqa.c(c = {0, 1, 928, 123})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29036a;
        public final Handler c;
        public Map<String, Object> da;
        public final int n;
        public final JSONObject sp;
        public final long uj;
        public final String ve;
        public final long x;
        public volatile boolean tt = false;
        public int i = 0;

        public c(String str, long j, long j2, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
            this.x = j == -1 ? System.currentTimeMillis() : j;
            this.ve = str;
            this.uj = j2;
            this.n = i;
            this.f29036a = i2;
            this.sp = jSONObject;
            this.da = map;
            this.c = new Handler(Looper.getMainLooper());
        }

        public static /* synthetic */ int tt(c cVar) {
            int i = cVar.i;
            cVar.i = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.c.postDelayed(new Runnable() { // from class: com.byazt.sx.uj.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.tt(c.this);
                    if (c.this.i >= 5 || uj.c()) {
                        c.this.c(1);
                        return;
                    }
                    com.byazt.eu.tt.c("TMe", "--==-- 重试一次 eventType:" + c.this.ve + ", 重试次数：" + c.this.i);
                    c.this.c();
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:25:0x0087  */
        public synchronized void c(int i) {
            byte b;
            this.c.removeCallbacksAndMessages(null);
            if (this.tt) {
                return;
            }
            this.tt = true;
            if (i == 1) {
                com.byazt.eu.tt.c("TMe", "--==-- 最终上报：eventType:" + this.ve + ", 重试次数：" + this.i + ", did: " + uj.n());
            } else if (i == 2) {
                com.byazt.eu.tt.c("TMe", "--==-- 最终上报：eventType:" + this.ve + ", 从applog回调中上报, did: " + uj.n());
            }
            String str = this.ve;
            int iHashCode = str.hashCode();
            if (iHashCode != -834688111) {
                if (iHashCode == 270071285 && str.equals("sdk_init")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("sdk_init_end")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                uj.tt(this.x);
            } else {
                if (b == 1) {
                    uj.c(this.uj, this.n, this.f29036a, this.x, this.sp, this.da);
                }
            }
        }
    }

    public static void c(Context context) {
        c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n() {
        return qy.c();
    }

    public static void tt() {
        new com.byazt.xo.tt(1).c(new Runnable() { // from class: com.byazt.sx.uj.1
            @Override // java.lang.Runnable
            public void run() {
                a.ve();
            }
        });
    }

    public static void ve() {
        new com.byazt.xo.tt(2).c(new Runnable() { // from class: com.byazt.sx.uj.2
            @Override // java.lang.Runnable
            public void run() {
                a.c();
            }
        });
    }

    public static void c(long j) {
        c cVar = new c("sdk_init", j, 0L, 0, 0, null, null);
        tt = cVar;
        cVar.c();
    }

    public static void tt(final long j) {
        new com.byazt.xo.tt(4).c(new Runnable() { // from class: com.byazt.sx.uj.3
            @Override // java.lang.Runnable
            public void run() {
                a.c(j);
            }
        });
    }

    public static void c(long j, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
        c cVar = new c("sdk_init_end", -1L, j, i, i2, jSONObject, map);
        ve = cVar;
        cVar.c();
    }

    public static boolean c() {
        return !TextUtils.isEmpty(qy.c());
    }

    public static void c(final long j, final int i, final int i2, final long j2, final JSONObject jSONObject, final Map<String, Object> map) {
        new com.byazt.xo.tt(8).c(new Runnable() { // from class: com.byazt.sx.uj.4
            @Override // java.lang.Runnable
            public void run() {
                a.c(j, i, i2, j2, jSONObject, (Map<String, Object>) map);
            }
        });
    }

    public static void c(final boolean z) {
        new com.byazt.xo.tt(16).c(new Runnable() { // from class: com.byazt.sx.uj.5
            @Override // java.lang.Runnable
            public void run() {
                a.c(z);
            }
        });
    }

    public static void c(final int i, final int i2, final long j, final boolean z, final boolean z2, final JSONObject jSONObject, final long j2, final JSONObject jSONObject2) {
        new com.byazt.xo.tt(32).c(new Runnable() { // from class: com.byazt.sx.uj.6
            @Override // java.lang.Runnable
            public void run() {
                a.c(i, i2, j, z, z2, jSONObject, j2, jSONObject2);
            }
        });
    }
}
