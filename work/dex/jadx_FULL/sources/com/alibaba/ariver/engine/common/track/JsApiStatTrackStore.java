package com.alibaba.ariver.engine.common.track;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.zj.adlib.u15;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JsApiStatTrackStore {
    private static final int e = 5000;
    private static final int f = 100;
    private static final String g = "__error_too_long__:0";
    private long b;
    private int c;
    private boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24073a = "";
    public final Map<String, Object> jsapiStatMap = new ConcurrentHashMap();

    public static class TinyAppJsApiStatInfo {
        public long callTs;
        public long invokeTs;
        public String name;

        public TinyAppJsApiStatInfo(String str, long j, long j2) {
            this.name = str;
            this.callTs = j;
            this.invokeTs = j2;
        }
    }

    public void appendJsApiDetail4TinyWithT2(String str, long j, long j2, long j3, long j4) {
        try {
            StringBuilder sb = new StringBuilder();
            if (this.b == 0) {
                this.b = j3;
                sb.append("basetime1:");
                sb.append(j3);
                sb.append("|");
                sb.append("basetime2:");
                sb.append(j4);
                sb.append("|");
            }
            long j5 = j3 - this.b;
            if (j5 > 5000) {
                return;
            }
            if (this.c >= 100) {
                if (this.f24073a.endsWith(g)) {
                    return;
                }
                this.f24073a += g;
                return;
            }
            sb.append(str);
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(j5);
            sb.append(u15.f19942b);
            sb.append(j);
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(j2);
            sb.append("|");
            this.f24073a += sb.toString();
            this.c++;
        } catch (Throwable th) {
            RVLogger.e("JsApiStatTrackStore", "appendJsApiDetail4TinyWithT2 exception", th);
        }
    }

    public void clear() {
        this.f24073a = "";
        this.b = 0L;
        this.c = 0;
        this.d = false;
        this.jsapiStatMap.clear();
    }

    public String getJsApiDetail4TinyWithT2() {
        if (this.f24073a.length() <= 0 || !this.f24073a.endsWith("|")) {
            return this.f24073a;
        }
        String str = this.f24073a;
        return str.substring(0, str.length() - 1);
    }

    public boolean isJsApiDetail4TinyWithinT2Uploaded() {
        return this.d;
    }

    public void setJsApiDetail4TinyWithinT2Uploaded(boolean z) {
        this.d = z;
    }
}
