package com.byazt.op;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1062, 13})
public class tt extends c {
    private final Bridge c;

    public tt(Bridge bridge) {
        this.c = bridge == null ? ve.tt : bridge;
    }

    public static Function<SparseArray<Object>, Object> covertToFunction(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        if (obj instanceof Bridge) {
            return new tt((Bridge) obj);
        }
        return null;
    }

    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) this.c.call(i, valueSet, cls);
    }

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        if (this.c.values() == null) {
            return null;
        }
        SparseArray<Object> sparseArray = this.c.values().sparseArray();
        return sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public Bridge getBridge() {
        return this.c;
    }
}
