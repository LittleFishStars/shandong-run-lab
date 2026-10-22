package com.byazt.ph;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 763, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    public final TTAppDownloadListener c;

    public ve(TTAppDownloadListener tTAppDownloadListener) {
        this.c = tTAppDownloadListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 221101:
                this.c.onIdle();
                return null;
            case 221102:
                this.c.onDownloadActive(valueSetTt.longValue(0), valueSetTt.longValue(1), valueSetTt.stringValue(2), valueSetTt.stringValue(3));
                return null;
            case 221103:
                this.c.onDownloadPaused(valueSetTt.longValue(0), valueSetTt.longValue(1), valueSetTt.stringValue(2), valueSetTt.stringValue(3));
                return null;
            case 221104:
                this.c.onDownloadFailed(valueSetTt.longValue(0), valueSetTt.longValue(1), valueSetTt.stringValue(2), valueSetTt.stringValue(3));
                return null;
            case 221105:
                this.c.onDownloadFinished(valueSetTt.longValue(0), valueSetTt.stringValue(1), valueSetTt.stringValue(2));
                return null;
            case 221106:
                this.c.onInstalled(valueSetTt.stringValue(0), valueSetTt.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
