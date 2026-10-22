package com.baidu.mshield.rp.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.baidu.mshield.utility.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26716a;

    public a(Context context) {
        this.f26716a = context;
    }

    public boolean a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        com.baidu.mshield.b.c.a.b("report from" + str3);
        com.baidu.mshield.b.c.a.b("sj-trigger report" + str);
        try {
            if (TextUtils.isEmpty(str2)) {
                str4 = null;
            } else {
                str4 = "&topic=" + str2;
            }
            String str5 = com.baidu.mshield.utility.a.f(this.f26716a) + "p/1/r";
            com.baidu.mshield.b.c.a.b("sj-trigger report" + str5);
            String strA = d.a(this.f26716a, str5, str, false, false, str4);
            return !TextUtils.isEmpty(strA) && new JSONObject(strA).getInt(ConnectionLog.CONN_LOG_STATE_RESPONSE) == 1;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return true;
        }
    }

    public void a() {
        try {
            JSONObject jSONObject = new JSONObject(d.a(this.f26716a, com.baidu.mshield.utility.a.f(this.f26716a) + "p/1/rs", false, true)).getJSONObject("c");
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.f26716a);
            int iOptInt = jSONObject.optInt("n");
            if (iOptInt > 0) {
                aVarA.i(iOptInt);
            }
            int iOptInt2 = jSONObject.optInt("i");
            if (iOptInt2 > 0) {
                aVarA.m(iOptInt2);
            }
            int iOptInt3 = jSONObject.optInt("i2");
            if (iOptInt3 > 0) {
                aVarA.l(iOptInt3);
            }
            int iOptInt4 = jSONObject.optInt("w");
            if (iOptInt4 > 0) {
                aVarA.h(iOptInt4);
            }
            if (jSONObject.optInt("s1") > 0) {
                aVarA.j(jSONObject.optInt("s1"));
            }
            int iOptInt5 = jSONObject.optInt("s2");
            if (iOptInt5 > 0) {
                aVarA.f(iOptInt5);
            }
            int iOptInt6 = jSONObject.optInt("t");
            if (iOptInt6 > 0) {
                aVarA.k(iOptInt6);
            }
            int iOptInt7 = jSONObject.optInt("l1");
            if (iOptInt7 > 0) {
                aVarA.n(iOptInt7);
            }
            int iOptInt8 = jSONObject.optInt("l2");
            if (iOptInt8 > 0) {
                aVarA.o(iOptInt8);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
