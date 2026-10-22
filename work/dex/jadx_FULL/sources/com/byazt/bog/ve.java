package com.byazt.bog;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 935, 54})
public class ve implements Manager {
    public final Function<SparseArray<Object>, Object> c;

    public ve(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.ve.ve : function;
    }

    public Function<SparseArray<Object>, Object> c(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof Function) {
            return (Function) objApply;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, Function.class);
        return new tt((Function) this.c.apply(sparseArray));
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.byazt.rl.ve.c((SparseArray<Object>) objApply).tt();
        }
        return null;
    }
}
