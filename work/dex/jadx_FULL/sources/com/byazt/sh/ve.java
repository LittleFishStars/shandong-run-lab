package com.byazt.sh;

import android.util.SparseArray;
import com.byazt.hj.da;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_FORMAT, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.FullScreenVideoAdListener c;

    public ve(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.c = fullScreenVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 132101:
                this.c.onError(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            case 132102:
                this.c.onFullScreenVideoAdLoad(new da((Function) valueSetTt.objectValue(0, Function.class)));
                return null;
            case 132103:
                this.c.onFullScreenVideoCached(new da((Function) valueSetTt.objectValue(0, Function.class)));
                return null;
            case 132104:
                this.c.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
