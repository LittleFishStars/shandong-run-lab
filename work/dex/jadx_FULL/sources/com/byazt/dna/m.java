package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 130})
public class m implements z, Function {
    public volatile Function c;
    public volatile z tt;

    public m(z zVar) {
        this.tt = zVar;
    }

    public m(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.dna.z
    public void onAdEventReport(String str, String str2, String str3, String str4) {
        if (this.tt != null) {
            this.tt.onAdEventReport(str, str2, str3, str4);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        sparseArray.put(4, str4);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.z
    public void onAdEventReport(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, com.byazt.ya.c cVar) {
        com.byazt.ya.c ttVar = cVar;
        if (this.tt != null) {
            this.tt.onAdEventReport(str, str2, str3, str4, str5, jSONObject, cVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        sparseArray.put(4, str4);
        sparseArray.put(5, str5);
        sparseArray.put(6, jSONObject);
        if (ttVar != null) {
            ttVar = new com.byazt.ya.tt(ttVar);
        }
        sparseArray.put(7, ttVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.z
    public void onAppLogMiscEvent(String str, JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.onAppLogMiscEvent(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.z
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        if (this.tt != null) {
            this.tt.onExceptionEvent(str, jSONObject, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, th);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.z
    public void onStatsEvent(String str, JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.onStatsEvent(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.z
    public void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.tt != null) {
            this.tt.onStatsEvent(str, jSONObject, jSONObject2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, jSONObject2);
        this.c.apply(sparseArray);
    }
}
