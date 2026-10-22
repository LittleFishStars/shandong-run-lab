package com.byazt.wrq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1557, 46})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener tTAdInteractionListener;

    public n(TTAdInteractionListener tTAdInteractionListener) {
        this.tTAdInteractionListener = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tTAdInteractionListener == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        if (pluginValueSetTt.intValue(-99999987) == 100101) {
            this.tTAdInteractionListener.onAdEvent(pluginValueSetTt.intValue(0), (Map) pluginValueSetTt.objectValue(1, Map.class));
        }
        return null;
    }
}
