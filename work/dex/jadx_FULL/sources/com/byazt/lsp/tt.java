package com.byazt.lsp;

import android.util.SparseArray;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_APPKEY_ERROR, 13})
public class tt {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.c.apply(sparseArray);
    }

    public void tt(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.c.apply(sparseArray);
    }

    public void ve(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.c.apply(sparseArray);
    }

    public JSONObject c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 144102);
        sparseArray.put(-99999985, JSONObject.class);
        return (JSONObject) this.c.apply(sparseArray);
    }

    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 144105);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
