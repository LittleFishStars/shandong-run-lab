package com.byazt.mm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1704, 46})
public class n implements EventListener {
    public Function<SparseArray<Object>, Object> c;

    public n(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (this.c == null) {
            return null;
        }
        Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(i).c(-99999979, result != null ? com.byazt.yxi.n.c().c(result.code()).c(result.isSuccess()).c(result.message()).c(new c(result.values())).tt() : null).c(SparseArray.class).tt());
        if (objApply instanceof SparseArray) {
            return com.byazt.iob.c.tt((SparseArray<Object>) objApply);
        }
        return null;
    }
}
