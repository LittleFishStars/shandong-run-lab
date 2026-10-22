package com.byazt.ia;

import android.content.Context;
import android.os.Process;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.mg.z;
import com.byazt.uy.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 515, 54})
public abstract class ve {
    public com.byazt.uy.ve c;
    public uj n;
    public Context tt;
    public tt uj;
    public com.byazt.uy.n ve = x.c().ve();

    public ve(com.byazt.uy.ve veVar, Context context, tt ttVar, uj ujVar) {
        this.c = veVar;
        this.tt = context;
        this.uj = ttVar;
        this.n = ujVar;
    }

    private void n(com.byazt.xz.c cVar) {
        List<com.byazt.uy.c> listC = x.tt().c(this.c);
        if (listC != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.byazt.uy.c> it = listC.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapC = it.next().c(this.c);
                if (mapC != null) {
                    try {
                        for (String str : mapC.keySet()) {
                            jSONObject.put(str, mapC.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            cVar.c("custom", jSONObject);
        }
    }

    public com.byazt.xz.c c(com.byazt.xz.c cVar) {
        if (cVar == null) {
            cVar = new com.byazt.xz.c();
        }
        tt(cVar);
        n(cVar);
        return cVar;
    }

    public boolean c() {
        return true;
    }

    public void tt(com.byazt.xz.c cVar) {
        tt ttVar;
        if (tt() && (ttVar = this.uj) != null) {
            cVar.c(ttVar);
        }
        cVar.c(x.a());
        tt ttVar2 = this.uj;
        cVar.c("is_background", Boolean.valueOf((ttVar2 == null || !ttVar2.ve()) && !com.byazt.mg.c.c(this.tt)));
        cVar.c("pid", Integer.valueOf(Process.myPid()));
        cVar.c("battery", Integer.valueOf(this.n.c()));
        cVar.c(this.ve.n());
        cVar.tt(x.i());
        cVar.c(x.da(), x.sl());
        cVar.c(this.ve.a());
        cVar.c(z.c(this.tt));
        if (c()) {
            uj(cVar);
        }
        cVar.c(this.ve.uj());
        String strSp = x.sp();
        if (strSp != null) {
            cVar.c("business", strSp);
        }
        if (x.x()) {
            cVar.c("is_mp", (Object) 1);
        }
        cVar.ve(x.tt().c());
        cVar.c("crash_uuid", UUID.randomUUID().toString());
    }

    public boolean tt() {
        return true;
    }

    public void uj(com.byazt.xz.c cVar) {
        cVar.tt(com.byazt.rx.uj.c(x.n().uj(), x.n().n()));
    }

    public void ve(com.byazt.xz.c cVar) {
        Map<String, Object> mapC = x.c().c();
        if (mapC == null) {
            return;
        }
        if (mapC.containsKey(AlibcCommonConstant.APP_VERSION)) {
            cVar.c("crash_version", mapC.get(AlibcCommonConstant.APP_VERSION));
        }
        if (mapC.containsKey("version_name")) {
            cVar.c(AlibcCommonConstant.APP_VERSION, mapC.get("version_name"));
        }
        if (mapC.containsKey("version_code")) {
            try {
                cVar.c("crash_version_code", Integer.valueOf(Integer.parseInt(mapC.get("version_code").toString())));
            } catch (Exception unused) {
                cVar.c("crash_version_code", mapC.get("version_code"));
            }
        }
        if (mapC.containsKey("update_version_code")) {
            try {
                cVar.c("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapC.get("update_version_code").toString())));
            } catch (Exception unused2) {
                cVar.c("crash_update_version_code", mapC.get("update_version_code"));
            }
        }
    }
}
