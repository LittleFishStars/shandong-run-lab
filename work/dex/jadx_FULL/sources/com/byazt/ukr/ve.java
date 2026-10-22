package com.byazt.ukr;

import android.util.SparseArray;
import com.byazt.dna.z;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1081, 54})
public class ve implements z, Function {
    public final long c = 60000;
    public long tt;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                onExceptionEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Throwable) sparseArray.get(3));
                break;
            case 2:
                onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                break;
            case 3:
                onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (JSONObject) sparseArray.get(3));
                break;
            case 4:
                onAppLogMiscEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                break;
            case 5:
                onAdEventReport((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3), (String) sparseArray.get(4));
                break;
            case 6:
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                Object obj5 = sparseArray.get(4);
                Object obj6 = sparseArray.get(5);
                Object obj7 = sparseArray.get(6);
                Object ttVar = sparseArray.get(7);
                if (ttVar != null) {
                    ttVar = new com.byazt.ya.tt((Function) ttVar);
                }
                onAdEventReport((String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (JSONObject) obj7, (com.byazt.ya.c) ttVar);
                break;
        }
        return null;
    }

    @Override // com.byazt.dna.z
    public void onAdEventReport(String str, String str2, String str3, String str4) {
        com.byazt.ddx.uj.c(str, str2, str3, str4, (com.byazt.ya.c) null);
    }

    @Override // com.byazt.dna.z
    public void onAppLogMiscEvent(String str, JSONObject jSONObject) {
        com.byazt.omf.a.c().c(str, jSONObject);
    }

    @Override // com.byazt.dna.z
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        if (str == null || !("okhttp_connectFailed".equals(str) || "okhttp_callFailed".equals(str))) {
            yp.c().c(str, jSONObject, th);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.tt > 60000) {
            yp.c().c(str, jSONObject, th);
            this.tt = jCurrentTimeMillis;
        }
    }

    @Override // com.byazt.dna.z
    public void onStatsEvent(String str, JSONObject jSONObject) {
        yp.c().c(str, jSONObject);
    }

    @Override // com.byazt.dna.z
    public void onAdEventReport(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, com.byazt.ya.c cVar) {
        com.byazt.ddx.uj.c(str, str2, str3, str4, str5, jSONObject, cVar);
    }

    @Override // com.byazt.dna.z
    public void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        yp.c().c(str, jSONObject, jSONObject2);
    }
}
