package com.byazt.bb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 34})
public class a implements com.byazt.hl.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f28311a;
    public com.byazt.hl.c c;
    public Map<String, Object> i;
    public int n;
    public Map<String, Object> sp;
    public Context tt;
    public String uj;
    public String ve;
    public i x;

    public a(i iVar, Context context, String str, String str2, Map<String, Object> map) {
        this.x = iVar;
        this.tt = context;
        this.ve = str;
        this.uj = str2;
        this.i = map;
        tt();
    }

    public static boolean c(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    private ic ve() {
        return com.byazt.ppf.ve.c(this.x, this.i);
    }

    @Override // com.byazt.hl.c
    public boolean c(Map<String, Object> map) {
        boolean zC = c();
        tt();
        if (zC) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.ve);
        if (!TextUtils.isEmpty(this.uj)) {
            map2.put("dpa_tag", this.uj);
        }
        map2.put("material_meta", ve());
        int iC = com.byazt.apd.tt.c().c(this.tt, this.x, map2) & 255;
        ve(iC);
        if (iC == 0) {
            return true;
        }
        com.byazt.hl.c cVar = this.c;
        return cVar != null && cVar.c(map);
    }

    public void tt(Map<String, Object> map) {
        this.sp = map;
    }

    private void tt() {
        i iVar = this.x;
        if (iVar != null) {
            this.n = iVar.n();
        } else {
            this.n = -1;
        }
    }

    private void ve(int i) {
        com.byazt.cr.uj ujVar;
        if (i == 0) {
            ujVar = com.byazt.cr.uj.ve;
        } else if (i == 1) {
            ujVar = com.byazt.cr.uj.n;
        } else if (i != 3) {
            ujVar = i != 4 ? com.byazt.cr.uj.uj : com.byazt.cr.uj.f28376a;
        } else {
            ujVar = com.byazt.cr.uj.sp;
        }
        com.byazt.ppf.ve.c(this.i, ujVar);
    }

    public void tt(int i) {
        this.n = i;
    }

    private boolean c() {
        if (this.n < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (c(this.n)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.n));
        }
        if (this.i.containsKey("saas_status_while_click")) {
            map.put("saas_status_while_click", this.i.get("saas_status_while_click"));
        }
        map.put("event_tag", this.ve);
        String str = this.uj;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        map.put("material_meta", ve());
        if (this.sp == null) {
            this.sp = new HashMap();
        }
        com.byazt.apd.tt.c().c(this.f28311a, this.x.sl(), map, this.sp);
        int iC = com.byazt.apd.tt.c().c(this.tt, this.x, map);
        int i = iC & 255;
        int i2 = (iC & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.sp.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void c(View view) {
        this.f28311a = view;
    }
}
