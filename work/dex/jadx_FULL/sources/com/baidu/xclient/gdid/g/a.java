package com.baidu.xclient.gdid.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.j.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public String a(String str, String str2, boolean z) {
        String strA;
        String strOptString = "";
        try {
            byte[] bArrA = d.a();
            try {
                strA = this.c.a(str, URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(bArrA, e.a(com.baidu.mshield.b.b.a.a(this.b)).getBytes()), 0)));
            } catch (Throwable th) {
                d.a(th);
                strA = "";
            }
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                String strA2 = a(strA, this.c.a(bArrA, str2));
                if (TextUtils.isEmpty(strA2)) {
                    return null;
                }
                if (!z) {
                    return strA2;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strA2);
                    jSONObject.optString("request_id");
                    String strOptString2 = jSONObject.optString("skey");
                    strOptString = jSONObject.optString("data");
                    return new String(com.baidu.mshield.b.f.d.a(Base64.decode(strOptString.getBytes(), 0), com.baidu.mshield.b.f.d.c(Base64.decode(strOptString2.getBytes(), 0), e.a(com.baidu.mshield.b.b.a.a(this.b)).getBytes())));
                } catch (Throwable th2) {
                    d.a(th2);
                    return strOptString;
                }
            } catch (Throwable th3) {
                d.a(th3);
                return null;
            }
        } catch (Throwable th4) {
            d.a(th4);
            return null;
        }
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String strA = a("gd/2/pin/", jSONObject.toString(), true);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return new JSONObject(strA);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public boolean a(String str) {
        try {
            String strA = a("f/2/ejc/", str, false);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            try {
                return !new JSONObject(strA).has("err_code");
            } catch (Throwable th) {
                d.a(th);
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        return false;
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("2", com.baidu.xclient.gdid.e.e().j());
            jSONObject.put("1", 2);
            return a("s/3/gd/", jSONObject.toString(), true);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }
}
