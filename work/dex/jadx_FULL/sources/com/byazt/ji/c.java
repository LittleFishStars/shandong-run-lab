package com.byazt.ji;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.pm.sl;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 20})
public class c extends tt implements com.byazt.rb.tt {
    public String sl;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Object obj;
        com.byazt.xj.ve veVarA;
        com.byazt.rb.c cVarDa;
        Map<String, Object> map = this.n;
        if (map == null || map.size() <= 0 || (obj = this.n.get("name")) == null) {
            return false;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return false;
        }
        Object obj2 = this.n.get("state");
        if (obj2 != null) {
            this.sl = String.valueOf(obj2);
        }
        com.byazt.xj.ve veVar = this.tt;
        com.byazt.xj.ve veVarTt = veVar.tt(veVar);
        if (veVarTt != null && (veVarA = veVarTt.a(strValueOf)) != null && (cVarDa = veVarA.da(strValueOf)) != null) {
            cVarDa.c(this);
        }
        return false;
    }

    @Override // com.byazt.rb.tt
    public void tt() {
        sl slVar;
        if ((TextUtils.equals(this.sl, "complete") || TextUtils.isEmpty(this.sl)) && (slVar = this.c) != null) {
            slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
        }
    }

    @Override // com.byazt.rb.tt
    public void c() {
        sl slVar;
        if ((TextUtils.equals(this.sl, "start") || TextUtils.isEmpty(this.sl)) && (slVar = this.c) != null) {
            slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
        }
    }
}
