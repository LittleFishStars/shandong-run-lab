package com.byazt.wz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.omf.p;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 54})
public class ve extends n implements com.byazt.pop.ve {
    public ve(Context context, ic icVar, String str) {
        super(context, icVar, str);
    }

    @Override // com.byazt.wz.c
    public boolean sl() {
        if (this.ve.yp() != null) {
            String strTt = this.ve.yp().tt();
            if (TextUtils.isEmpty(strTt)) {
                t();
            } else {
                nu.c((String) null);
                Uri uri = Uri.parse(strTt);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                nb.ve(intent);
                HashMap map = new HashMap();
                map.put("source", "AndroidRDMLicManager");
                map.put(NativeModel.JSON_KEY_SCHEME, nb.c(strTt));
                com.byazt.ddx.uj.c(this.ve, this.uj, map, this.u);
                try {
                    Context context = getContext();
                    nb.c(this.u, this.ve, this.uj, sp());
                    com.byazt.nr.tt.startActivity(context, intent, TextUtils.equals(p.x, "internal"));
                    com.byazt.ddx.uj.c(this.ve, this.uj, (Throwable) null, this.u, true);
                    com.byazt.ddx.x.c().c(this.ve, this.uj, this.u, sp(), null);
                    return true;
                } catch (Throwable th) {
                    com.byazt.ddx.uj.ve(this.ve, this.uj, "open_fallback_download");
                    com.byazt.ddx.uj.c(this.ve, this.uj, th, this.u, false);
                }
            }
        }
        return false;
    }
}
