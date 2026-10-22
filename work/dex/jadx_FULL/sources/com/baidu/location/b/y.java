package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f26402a;
    private long b = 0;
    private long c = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static y f26403a = new y();
    }

    public class b extends com.baidu.location.e.f {
        private boolean d = false;
        private String e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f26404a = false;
        public long b = 0;

        public b() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            String strC = com.baidu.location.e.b.a().c();
            if (strC != null) {
                strC = strC + "&gnsst=" + this.b;
            }
            String strA = n.a().a(strC);
            String strReplaceAll = !TextUtils.isEmpty(strA) ? strA.trim().replaceAll("\r|\n", "") : "null";
            String strA2 = n.a().a(this.e);
            String strReplaceAll2 = TextUtils.isEmpty(strA2) ? "null" : strA2.trim().replaceAll("\r|\n", "");
            try {
                this.el.put(AliyunLogCommon.LogLevel.INFO, URLEncoder.encode(strReplaceAll, "utf-8"));
                this.el.put("enl", URLEncoder.encode(strReplaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }

        public void a(String str, long j) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = str;
            this.b = j;
            ExecutorService executorServiceC = x.a().c();
            if (executorServiceC != null) {
                a(executorServiceC, com.baidu.location.e.d.n);
            } else {
                b(com.baidu.location.e.d.n);
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.ej != null) {
                try {
                    new JSONObject(this.ej);
                    this.f26404a = true;
                } catch (Throwable unused) {
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.d = false;
        }

        public boolean b() {
            return this.d;
        }
    }

    public static y a() {
        return a.f26403a;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        t.a().a(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }

    public void b() {
        ArrayList<String> arrayListB;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= 20000) {
            return;
        }
        if (this.f26402a == null) {
            this.f26402a = new b();
        }
        b bVar = this.f26402a;
        if (bVar == null || bVar.b() || (arrayListB = t.a().b()) == null || arrayListB.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayListB.iterator();
        int i = 0;
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i++;
            if (i != arrayListB.size()) {
                stringBuffer.append(com.alipay.sdk.m.y.l.b);
            }
        }
        this.f26402a.a(stringBuffer.toString(), this.c);
    }
}
