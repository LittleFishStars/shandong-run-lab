package com.byazt.io;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1422, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.CSJSplashAdListener c;

    public tt(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.c = cSJSplashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 114102:
                this.c.onSplashLoadSuccess(new com.byazt.hj.tt(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.c.onSplashLoadFail(new com.byazt.hj.c(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.c.onSplashRenderSuccess(new com.byazt.hj.tt((Function) valueSetTt.objectValue(0, Function.class)));
                return null;
            case 114105:
                this.c.onSplashRenderFail(new com.byazt.hj.tt(z.c(valueSetTt.objectValue(0, Object.class))), new com.byazt.hj.c(z.c(valueSetTt.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
