package com.byazt.whk;

import android.text.TextUtils;
import com.byazt.aas.eo;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 20})
public class c {
    public static volatile c c;
    public Map<String, tt> tt = new HashMap();

    private c() {
        c(com.byazt.wun.c.c());
        c(com.byazt.qu.c.c());
        c(com.byazt.ddx.tt.c());
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private void c(tt ttVar) {
        this.tt.put(ttVar.tt(), ttVar);
    }

    public String c(String str, String str2, String str3) {
        if (this.tt.containsKey(str)) {
            String strC = this.tt.get(str).c(str2, str3);
            return TextUtils.isEmpty(strC) ? "-1" : strC;
        }
        return eo.c(str).get(str2, "-1");
    }

    public void c(String str, String str2, String str3, String str4) {
        if (this.tt.containsKey(str)) {
            this.tt.get(str).c(str2, str3, str4);
        } else {
            eo.c(str).put(str2, str3);
        }
    }
}
