package com.alibaba.analytics.core.d;

import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.t;
import com.alibaba.analytics.a.x;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f23777a = new h();
    private long d = 0;
    private String az = "http://";
    private String aA = "acs.m.taobao.com";
    private String aB = "/gw/mtop.common.getTimestamp/*";
    private String aC = "http://acs.m.taobao.com/gw/mtop.common.getTimestamp/*";
    private boolean K = false;

    public long e() {
        return System.currentTimeMillis() + this.d;
    }

    public boolean s() {
        return this.K;
    }

    public void startSync() {
        x.a().schedule(null, new Runnable() { // from class: com.alibaba.analytics.core.d.h.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = h.this.aA;
                String strB = t.b(com.alibaba.analytics.core.d.a().getContext(), "time_adjust_host");
                if (!TextUtils.isEmpty(strB)) {
                    str = strB;
                }
                String str2 = h.this.az + str + h.this.aB;
                com.alibaba.analytics.a.f.a aVarA = com.alibaba.analytics.a.f.a(1, str2, null, false);
                j.d("TimeStampAdjustMgr", "url", str2, ConnectionLog.CONN_LOG_STATE_RESPONSE, aVarA);
                if (aVarA == null || aVarA.data == null) {
                    return;
                }
                try {
                    byte[] bArr = aVarA.data;
                    JSONObject jSONObjectOptJSONObject = new JSONObject(new String(bArr, 0, bArr.length)).optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("t");
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        try {
                            h.this.d = Long.parseLong(strOptString) - jCurrentTimeMillis;
                            h.this.K = true;
                            j.d("TimeStampAdjustMgr", "t", strOptString, "now", Long.valueOf(jCurrentTimeMillis), "diff", Long.valueOf(h.this.d));
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 0L);
    }

    public static h a() {
        return f23777a;
    }

    public long a(String str) {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = Long.parseLong(str);
        } catch (Exception e) {
            j.d("TimeStampAdjustMgr", e);
            jCurrentTimeMillis = 0;
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jCurrentTimeMillis + this.d;
    }
}
