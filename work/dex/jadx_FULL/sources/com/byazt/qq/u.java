package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 67})
public class u extends c {
    public c nu;

    public u(Activity activity, ic icVar) {
        super(activity, icVar);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        c cVar = this.nu;
        if (cVar == null) {
            return null;
        }
        String strC = cVar.c();
        try {
            JSONObject jSONObject = new JSONObject(strC);
            jSONObject.put("is_need_click", this.n);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return strC;
        }
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        ArrayList<g> arrayListGt = kp.gt(this.sp);
        if (arrayListGt == null) {
            return new tt.c(false, 0, "");
        }
        for (g gVar : arrayListGt) {
            switch (gVar.ve()) {
                case 1:
                    this.nu = new t(this.x, this.sp, gVar);
                    break;
                case 2:
                    this.nu = new sl(this.x, this.sp, gVar);
                    break;
                case 3:
                    this.nu = new a(this.x, this.sp, gVar);
                    break;
                case 4:
                    this.nu = new sp(this.x, this.sp, gVar);
                    break;
                case 5:
                    this.nu = new i(this.x, this.sp, gVar);
                    break;
                case 6:
                    this.nu = new uj(this.x, this.sp, gVar);
                    break;
            }
            c cVar = this.nu;
            if (cVar != null) {
                cVar.c(this.ve);
                this.nu.c(this.c);
                this.nu.tt(this.tt);
                this.nu.tt(this.uj);
                this.nu.ve(this.t);
                this.nu.uj(this.sl);
                this.nu.ve(this.f28981a);
                this.nu.uj(this.n);
                this.nu.c(this.m);
                this.nu.tt(x());
                tt.c cVarTt = this.nu.tt(daVar);
                if (cVarTt.ve()) {
                    return cVarTt;
                }
            }
        }
        return new tt.c(false, 0, "");
    }

    @Override // com.byazt.qq.tt
    public void tt(String str) {
        super.tt(str);
        c cVar = this.nu;
        if (cVar == null) {
            return;
        }
        cVar.tt(str);
    }
}
