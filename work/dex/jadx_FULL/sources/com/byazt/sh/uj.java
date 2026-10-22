package com.byazt.sh;

import android.util.SparseArray;
import com.byazt.hj.t;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_FORMAT, 15})
public class uj implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.NativeAdListener c;

    public uj(TTAdNative.NativeAdListener nativeAdListener) {
        this.c = nativeAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 143101:
                this.c.onError(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            case 143102:
                List arrayList = (List) valueSetTt.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new t(z.c(it.next())));
                }
                this.c.onNativeAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
