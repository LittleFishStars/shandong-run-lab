package com.byazt.bog;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 935, 15})
public class uj implements Initializer {
    public final Function<SparseArray<Object>, Object> c;

    public uj(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.c == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999000);
        return new ve((Function) this.c.apply(sparseArray));
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.c == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        com.byazt.ut.uj.getAppContext(valueSet.stringValue(261001)).updateInitParams(sparseArray);
        this.c.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function == null) {
            return false;
        }
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
