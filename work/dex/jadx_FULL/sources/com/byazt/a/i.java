package com.byazt.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 42})
public class i extends c {
    public String n;
    public String uj;

    public i(Context context, com.byazt.k.c cVar, String str, String str2, String str3) {
        super(context, cVar, str);
        this.uj = str2;
        this.n = str3;
    }

    @Override // com.byazt.a.n
    public Intent tt() {
        String str;
        String strVe = this.tt.ve("s");
        String strC = com.byazt.i.ve.c(this.tt.ve("ak"), strVe);
        String strC2 = com.byazt.i.ve.c(this.tt.ve("am"), strVe);
        String strC3 = com.byazt.i.ve.c(this.tt.ve(com.alipay.sdk.m.w.a.w), strVe);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strC3) && strC3.split(",").length == 2) {
            String[] strArrSplit = strC3.split(",");
            String strC4 = com.byazt.i.ve.c(this.tt.ve(bolts.c.c), strVe);
            String strC5 = com.byazt.i.ve.c(this.tt.ve("ao"), strVe);
            if (!TextUtils.isEmpty(strC5) && strC5.split(",").length == 2) {
                String[] strArrSplit2 = strC5.split(",");
                JSONObject jSONObjectUj = this.tt.uj("download_dir");
                if (jSONObjectUj != null) {
                    String strOptString = jSONObjectUj.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.n;
                    } else {
                        try {
                            str = String.format(strOptString, this.n);
                        } catch (Throwable unused) {
                            str = this.n;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strC4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strC);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strC2, this.uj);
                intent.putExtra(strC4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
