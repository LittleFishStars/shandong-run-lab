package com.byazt.jk;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 801, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.EasyPlayWidgetListener c;

    public tt(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.c = easyPlayWidgetListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 144101:
                this.c.onInfo((JSONObject) valueSetTt.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.c.getEstimatedInteractionArea();
            case 144103:
                this.c.onCanRenderSuccess((JSONObject) valueSetTt.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.c.onCanRenderFail((JSONObject) valueSetTt.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.c.onClose();
                return null;
            default:
                return null;
        }
    }
}
