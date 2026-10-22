package com.byazt.iw;

import android.content.Context;
import com.byazt.se.tt;
import com.byazt.se.ve;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 806, 20})
public abstract class c {
    public final List<Future<com.byazt.co.c>> c = new ArrayList();
    public final Context tt;
    public final tt uj;
    public final com.byazt.az.c ve;

    public c(Context context, tt ttVar, com.byazt.az.c cVar) {
        this.uj = ttVar;
        this.ve = cVar;
        this.tt = context;
    }

    public abstract List<String> c();

    public void c(com.byazt.se.c cVar, Long l) {
        this.c.add(com.byazt.ww.c.c(new ve(cVar, l)));
    }

    public boolean c(JSONObject jSONObject) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0008 A[SYNTHETIC] */
    public void c(Map<String, JSONObject> map, long j) {
        byte b;
        com.byazt.se.c cVar;
        com.byazt.se.c cVar2;
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                if (c().contains(entry.getKey())) {
                    int iHashCode = key.hashCode();
                    if (iHashCode != 3073450) {
                        if (iHashCode == 3073698 && key.equals("d_i0")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (key.equals("d_a0")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b != 0) {
                        if (b != 1) {
                            cVar2 = null;
                        } else {
                            cVar = new com.byazt.ry.tt(this.tt, entry.getValue());
                        }
                        if (cVar2 != null) {
                            c(cVar2, Long.valueOf(j));
                        }
                    } else {
                        cVar = new com.byazt.ry.c(this.tt, entry.getValue());
                    }
                    cVar2 = cVar;
                    if (cVar2 != null) {
                        c(cVar2, Long.valueOf(j));
                    }
                }
            } catch (Exception e) {
                com.byazt.tf.c.uj("__kite", "error " + e.getMessage());
            }
        }
    }
}
