package com.byazt.ysz;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.aas.bx;
import com.byazt.aas.nb;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.qy;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 589, 20})
public abstract class c implements uj {
    public volatile Function<SparseArray<Object>, Object> c = null;
    public volatile String tt;
    public JSONObject ve;

    public void a_(String str) {
    }

    @Override // com.byazt.ysz.uj
    public void c() {
    }

    @Override // com.byazt.ysz.uj
    public void c(String str, ic icVar, long j) {
    }

    @Override // com.byazt.ysz.uj
    public void c(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.c = function;
    }

    public abstract boolean r_();

    public int tt(i iVar) {
        nu nuVarYp;
        if (1 != com.byazt.apd.tt.c().n()) {
            return 2;
        }
        if (!com.byazt.wu.c.c(iVar)) {
            return 3;
        }
        if (nb.yv() && (nuVarYp = iVar.yp()) != null) {
            String strTt = nuVarYp.tt();
            if (!TextUtils.isEmpty(strTt)) {
                Uri uri = Uri.parse(strTt);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return nb.tt(intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.byazt.ysz.uj
    public long ve() {
        return -1L;
    }

    @Override // com.byazt.ysz.uj
    public void ve(i iVar) {
    }

    public boolean c(i iVar) {
        if (iVar == null) {
            return false;
        }
        return c(iVar.da(), iVar.n());
    }

    @Override // com.byazt.ysz.uj
    public boolean c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public long c(ic icVar) {
        if (icVar == null) {
            return 0L;
        }
        String strDa = icVar.da();
        if (TextUtils.isEmpty(strDa)) {
            strDa = c(icVar.yp());
        }
        try {
            return Long.parseLong(strDa);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String c(nu nuVar) {
        Map<String, String> mapC;
        if (nuVar == null) {
            return null;
        }
        String strTt = nuVar.tt();
        if (TextUtils.isEmpty(strTt)) {
            return null;
        }
        if ((strTt.startsWith("snssdk2329") || strTt.startsWith("snssdk1128")) && (mapC = bx.c(strTt)) != null) {
            return mapC.get("room_id");
        }
        return null;
    }

    public String c(i iVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strN = qy.n(iVar.u(), str2);
            if (TextUtils.isEmpty(strN)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strN);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            m.tt(com.byazt.we.ve.TAG, e);
            yp.c().c("getEcomLiveParams", e);
            return str;
        }
    }

    public void c(ic icVar, String str, int i, int i2, int i3) {
        com.byazt.ddx.uj.c(icVar, str, i, i2, i3, r_());
    }

    public boolean c(i iVar, int i) {
        return iVar.n() == 7 || i == 103;
    }
}
