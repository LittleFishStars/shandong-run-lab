package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 34})
public class a implements n.c, Function {
    public volatile Function c;
    public volatile n.c tt;

    public a(n.c cVar) {
        this.tt = cVar;
    }

    public a(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.tt.reportSensorData((JSONObject) sparseArray.get(1));
        return null;
    }

    @Override // com.byazt.dna.n.c
    public void reportSensorData(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        this.c.apply(sparseArray);
    }
}
