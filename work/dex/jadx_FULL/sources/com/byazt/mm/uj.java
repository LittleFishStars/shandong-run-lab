package com.byazt.mm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1704, 15})
public class uj implements Function<SparseArray<Object>, Object> {
    public EventListener c;

    public uj(EventListener eventListener) {
        this.c = eventListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || this.c == null) {
            return null;
        }
        return this.c.onEvent(((Integer) sparseArray.get(-99999987)).intValue(), com.byazt.iob.c.c((SparseArray<Object>) sparseArray.get(-99999979)));
    }
}
