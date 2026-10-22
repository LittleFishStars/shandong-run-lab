package com.byazt.aas;

import android.text.TextUtils;
import com.byazt.ete.ic;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 131, 123})
    public static class c implements Comparable<c> {
        public long c;
        public String tt;

        public c(String str, long j) {
            this.tt = str;
            this.c = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            if (cVar == null) {
                return 1;
            }
            long j = this.c;
            long j2 = cVar.c;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }

    public static void c(com.byazt.ete.c cVar, int i, int i2, String str) {
        if (cVar == null || cVar.tt() == null || i2 <= 0) {
            return;
        }
        List<ic> listTt = cVar.tt();
        int size = listTt.size();
        try {
            com.byazt.it.sp spVarVe = com.byazt.vif.uj.ve(str, i + "_prefetch_new");
            delete(i, i2, spVarVe, size);
            for (ic icVar : listTt) {
                String strY = icVar.y();
                String strTt = com.byazt.nr.c.tt(icVar.yg().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strTt);
                spVarVe.put(strY, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private static boolean c(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    private static void delete(int i, int i2, com.byazt.it.sp spVar, int i3) {
        if (spVar == null) {
            return;
        }
        try {
            Map all = spVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (c(i)) {
                    if (size > 1) {
                        spVar.clear();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    spVar.clear();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = (str == null || !str.contains("pre_fetch_time")) ? null : new JSONObject(str);
                        if (jSONObject != null) {
                            priorityQueue.add(new c((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        spVar.clear();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        c cVar = (c) priorityQueue.poll();
                        if (cVar != null) {
                            spVar.remove(cVar.tt);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static ic c(String str, int i, String str2) {
        if (com.byazt.omf.gt.tt().lr() <= 0) {
            return null;
        }
        com.byazt.it.sp spVarVe = com.byazt.vif.uj.ve(str2, i + "_prefetch_new");
        String strOptString = spVarVe.get(str, "");
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                if (strOptString.contains("pre_fetch_time")) {
                    strOptString = new JSONObject(strOptString).optString("message");
                }
                ic icVarC = com.byazt.omf.c.c(new JSONObject(com.byazt.nr.c.ve(strOptString)));
                spVarVe.remove(str);
                return icVarC;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
