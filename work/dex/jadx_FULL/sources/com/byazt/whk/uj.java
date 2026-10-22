package com.byazt.whk;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 15})
public class uj implements ve, Function {
    public volatile Function c;
    public volatile ve tt;

    public uj(ve veVar) {
        this.tt = veVar;
    }

    public uj(Function function) {
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

    @Override // com.byazt.whk.ve
    public void init(Context context, Function function) {
        if (this.tt != null) {
            this.tt.init(context, function);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, function);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.whk.ve
    public boolean isPitayaEnvAvailable() {
        if (this.tt != null) {
            return this.tt.isPitayaEnvAvailable();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.whk.ve
    public boolean isPitayaInitSuccess() {
        if (this.tt != null) {
            return this.tt.isPitayaInitSuccess();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.whk.ve
    public void onAppLogEvent(String str, JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.onAppLogEvent(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.whk.ve
    public void queryPackage(String str, Function function) {
        if (this.tt != null) {
            this.tt.queryPackage(str, function);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, function);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.whk.ve
    public void runTask(String str, JSONObject jSONObject, Function function) {
        if (this.tt != null) {
            this.tt.runTask(str, jSONObject, function);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, function);
        this.c.apply(sparseArray);
    }
}
