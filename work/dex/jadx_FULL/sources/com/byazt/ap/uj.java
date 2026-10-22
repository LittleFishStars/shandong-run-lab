package com.byazt.ap;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATURE_NONSUPPORTED_SIGN_TYPE, 15})
public class uj implements Bridge, Manager {
    public final Function<SparseArray<Object>, Object> c;

    public uj(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.c == null) {
            return null;
        }
        com.byazt.mm.c cVar = new com.byazt.mm.c(valueSet);
        cVar.put(-99999987, Integer.valueOf(i));
        cVar.put(-99999985, cls);
        T t = (T) com.byazt.iob.c.tt(this.c.apply(cVar));
        return t != null ? t : (T) com.byazt.rl.ve.ve.apply(cVar);
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        if (this.c == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-99999985, Function.class);
        sparseArray.put(-998000, context);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof Function) {
            return new ve((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        if (this.c == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, Function.class);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.byazt.mm.tt((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge, com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        if (this.c == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.byazt.iob.c.tt((SparseArray<Object>) objApply);
        }
        return null;
    }
}
