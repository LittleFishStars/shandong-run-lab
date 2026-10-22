package com.byazt.vd;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 34})
public class a extends c {
    public a(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Map<String, Object> map = this.f29129a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Object obj = this.f29129a.get("id");
        if (obj == null) {
            c(this.ve);
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            c(this.ve);
            return;
        }
        com.byazt.xj.ve veVar = this.ve;
        com.byazt.xj.ve veVarTt = veVar.tt(veVar);
        if (veVarTt == null) {
            return;
        }
        c(veVarTt.uj(strValueOf));
    }

    private void c(com.byazt.xj.ve veVar) {
        Object obj;
        if (veVar == null) {
            return;
        }
        for (String str : this.f29129a.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id") && (obj = this.f29129a.get(str)) != null) {
                veVar.c(str, String.valueOf(obj));
            }
        }
        veVar.c(this.f29129a.containsKey("width"), this.f29129a.containsKey("height"));
        veVar.tt();
    }
}
