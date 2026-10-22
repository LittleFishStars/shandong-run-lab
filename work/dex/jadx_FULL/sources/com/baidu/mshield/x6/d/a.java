package com.baidu.mshield.x6.d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public String a(String str) {
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.b);
            try {
                String strA = h.a(16);
                String strC = this.c.c(strA);
                if (TextUtils.isEmpty(strC)) {
                    return "";
                }
                String strA2 = a(strC, h.b(c.a(str.getBytes()), strA.getBytes()));
                com.baidu.mshield.b.c.a.a("getCheckZipResponse:" + strA2);
                if (TextUtils.isEmpty(strA2)) {
                    return "";
                }
                bVar.j("");
                bVar.a(0);
                bVar.w("");
                bVar.i(0);
                bVar.x("");
                bVar.m(1);
                try {
                    JSONObject jSONObject = new JSONObject(strA2);
                    String string = jSONObject.getString("data");
                    com.baidu.mshield.b.c.a.a("dataStr:" + string);
                    String string2 = jSONObject.getString("skey");
                    if (string != null && string2 != null) {
                        String str2 = new String(h.a(Base64.decode(string, 0), h.c(Base64.decode(string2.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.b)).getBytes())));
                        com.baidu.mshield.b.c.a.a("dataDecrypt:" + str2);
                        return str2;
                    }
                    return "";
                } catch (Throwable th) {
                    f.b(th);
                    if (bVar.F() == 0) {
                        bVar.d(-3);
                    }
                    return "";
                }
            } catch (com.baidu.mshield.b.d.c unused) {
                com.baidu.mshield.b.c.a.a("getCheckZipResponse:NetworkErrorWrongResponseCodeException");
                if (bVar.F() == 0) {
                    bVar.d(-3);
                }
                return "";
            } catch (InterruptedException e) {
                bVar.m(0);
                f.b(e);
                return "";
            } catch (Throwable th2) {
                f.b(th2);
                return "";
            }
        } catch (Throwable th3) {
            f.b(th3);
        }
    }

    public String b(String str) {
        try {
            try {
                String strA = h.a(16);
                String strA2 = this.c.a(strA);
                if (TextUtils.isEmpty(strA2)) {
                    return "";
                }
                String strA3 = a(strA2, h.b(c.a(str.getBytes()), strA.getBytes()));
                com.baidu.mshield.b.c.a.a("getBdid:" + strA3);
                if (TextUtils.isEmpty(strA3)) {
                    return "";
                }
                try {
                    JSONObject jSONObject = new JSONObject(strA3);
                    String string = jSONObject.getString("data");
                    com.baidu.mshield.b.c.a.a("dataStr:" + string);
                    String string2 = jSONObject.getString("skey");
                    if (string != null && string2 != null) {
                        String str2 = new String(h.a(Base64.decode(string, 0), h.c(Base64.decode(string2.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.b)).getBytes())));
                        com.baidu.mshield.b.c.a.a("dataDecrypt:" + str2);
                        return str2;
                    }
                } catch (Throwable th) {
                    f.b(th);
                    return "";
                }
            } catch (Throwable th2) {
                f.b(th2);
                return "";
            }
        } catch (Throwable th3) {
            f.b(th3);
        }
        return "";
    }

    public String c(String str) {
        String strA;
        try {
            try {
                String strA2 = h.a(16);
                String strB = this.c.b(strA2);
                if (TextUtils.isEmpty(strB)) {
                    return "";
                }
                byte[] bArrB = h.b(c.a(str.getBytes()), strA2.getBytes());
                com.baidu.mshield.b.c.a.a("getCharacter:" + strB);
                strA = a(strB, bArrB);
                com.baidu.mshield.b.c.a.a("getCharacter resp:" + strA);
                if (TextUtils.isEmpty(strA)) {
                    return "";
                }
                try {
                    JSONObject jSONObject = new JSONObject(strA);
                    String strOptString = jSONObject.optString("skey");
                    String str2 = new String(h.a(Base64.decode(jSONObject.optString("data").getBytes(), 0), h.c(Base64.decode(strOptString.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.b)).getBytes())));
                    if (TextUtils.isEmpty(str2)) {
                        return "";
                    }
                    com.baidu.mshield.b.c.a.a("getCharacter sdata:" + str2);
                    return str2;
                } catch (Throwable th) {
                    f.b(th);
                    return "";
                }
            } catch (Throwable th2) {
                f.b(th2);
                strA = "";
            }
        } catch (Throwable th3) {
            f.b(th3);
            return "";
        }
    }
}
