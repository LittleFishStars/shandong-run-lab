package com.byazt.qi;

import android.text.TextUtils;
import android.util.Base64;
import com.byakv.z.SoftDecTool;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 42})
public class i {
    public static volatile i c = null;
    public static volatile boolean tt = false;
    public static AtomicInteger ve = new AtomicInteger(0);

    private i() {
    }

    public static i c() {
        if (c == null) {
            synchronized (i.class) {
                if (c == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.byazt.bzd.sp.c("panglearmor");
                        tt = true;
                        ve.set(1);
                    } catch (Throwable unused) {
                        tt = false;
                        ve.set(2);
                    }
                    c = new i();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    x xVarA = a.a();
                    if (xVarA != null) {
                        xVarA.c(jCurrentTimeMillis2 - jCurrentTimeMillis, tt);
                    }
                }
            }
        }
        return c;
    }

    public static boolean tt() {
        return tt;
    }

    public static int ve() {
        return ve.get();
    }

    public byte[] tt(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && tt) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] c(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && tt) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null || !tt) {
            return null;
        }
        try {
            byte[] bArrC = c(jSONObject.toString().getBytes());
            if (bArrC == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrC, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", strEncodeToString);
            jSONObject2.put("cypher", 4);
            return jSONObject2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String c(String str) {
        if (str == null || str.length() == 0 || !tt) {
            return null;
        }
        try {
            byte[] bArrTt = tt(Base64.decode(str, 0));
            if (bArrTt != null) {
                return new String(bArrTt);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
