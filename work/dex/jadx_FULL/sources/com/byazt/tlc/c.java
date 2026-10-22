package com.byazt.tlc;

import android.content.Context;
import com.byazt.ogz.sl;
import com.byazt.rs.a;
import com.byazt.rs.ve;
import com.byazt.ukr.yp;
import com.byazt.vif.uj;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1664, 20})
public final class c {
    public static void c(Context context, final String str, sl slVar) {
        a.c().c(context);
        a.c().c(new com.byazt.rs.tt() { // from class: com.byazt.tlc.c.1
            @Override // com.byazt.rs.tt
            public String c(String str2, String str3, String str4) {
                return uj.c(str, str2).getString(str3, str4);
            }

            @Override // com.byazt.rs.tt
            public void tt(String str2, String str3, String str4) {
                uj.c(str, str2).put(str3, str4);
            }
        });
        a.c().c(new ve() { // from class: com.byazt.tlc.c.2
            @Override // com.byazt.rs.ve
            public void c(final String str2, final JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.tlc.c.2.1
                    @Override // com.byazt.ee.c
                    public com.byazt.qal.c c() throws Exception {
                        return com.byazt.qal.tt.tt().c(str2).tt(jSONObject.toString());
                    }
                }, str2);
            }
        });
        c(slVar.t(), slVar.u());
    }

    public static void c(int i, boolean z) {
        a.c().c(i);
        a.c().c(z);
    }
}
