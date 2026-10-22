package com.alibaba.ariver.commonability.core.util;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.u15;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23951a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final String d = "CommonAbility#Monitor";
    private static final String e = "middle";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f23952a;
        String b;
        Map<String, String> c;
        int d;

        public a(String str) {
            this(str, "middle");
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.c.put("source_appid", str);
            }
            return this;
        }

        public a(String str, String str2) {
            this.f23952a = str;
            this.b = str2;
            this.c = new HashMap();
            this.d = 1;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a a(String str, Object obj) {
            if (obj == null) {
                return this;
            }
            this.c.put(str, String.valueOf(obj));
            return this;
        }

        public void a() {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            if (rVMonitor == null) {
                return;
            }
            rVMonitor.event(this.f23952a, this.b, this.d, this.c);
            Map<String, String> map = this.c;
            if (map == null || map.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                sb.append(entry.getKey());
                sb.append(u15.f19942b);
                sb.append(entry.getValue());
                sb.append(l.b);
            }
            RVLogger.d(c.d, sb.toString());
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static a a(String str) {
        return new a(str);
    }
}
