package com.byazt.ap;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATURE_NONSUPPORTED_SIGN_TYPE, 13})
public class tt implements Initializer {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.c == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999000);
        sparseArray.put(-99999985, Function.class);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof Function) {
            return new uj((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        com.byazt.mm.c cVar = new com.byazt.mm.c(valueSet);
        cVar.put(-99999987, -999001);
        cVar.put(-99999985, Void.class);
        cVar.put(-998000, context);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(cVar);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -999002);
            sparseArray.put(-99999985, Boolean.TYPE);
            Object objApply = this.c.apply(sparseArray);
            if (objApply != null && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
