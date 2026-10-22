package com.byazt.mm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1704, 13})
public class tt implements Bridge {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999977) {
            if (this.c instanceof ve) {
                T t = (T) this.c.apply(com.byazt.yxi.uj.c().c(-99999977).c(Bridge.class).tt());
                if (t instanceof Bridge) {
                    return t;
                }
            }
            return (T) this.c;
        }
        if (this.c == null) {
            return null;
        }
        c cVar = new c(valueSet);
        cVar.put(-99999987, Integer.valueOf(i));
        cVar.put(-99999985, cls);
        T t2 = (T) com.byazt.iob.c.tt(this.c.apply(cVar));
        return t2 != null ? t2 : (T) com.byazt.rl.ve.ve.apply(cVar);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge, com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            return com.byazt.iob.c.tt(com.byazt.iob.c.c(function));
        }
        return null;
    }
}
