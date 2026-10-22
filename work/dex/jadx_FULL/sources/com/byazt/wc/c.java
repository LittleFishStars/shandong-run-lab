package com.byazt.wc;

import android.util.SparseArray;
import com.byazt.yxi.ve;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1692, 20})
public class c extends com.byazt.me.c {
    public c(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetTt;
        if (function == null || (pluginValueSetTt = ve.tt(function)) == null) {
            return;
        }
        uj(pluginValueSetTt.stringValue(8505));
        n(pluginValueSetTt.stringValue(8506));
        c(pluginValueSetTt.longValue(8507));
        a(pluginValueSetTt.stringValue(8508));
        c((Map<String, String>) pluginValueSetTt.objectValue(8509, Map.class));
        sp(pluginValueSetTt.stringValue(8510));
        x(pluginValueSetTt.stringValue(8511));
        tt((Map<String, Object>) pluginValueSetTt.objectValue(8512, Map.class));
        ve(pluginValueSetTt.stringValue(8551));
        c(pluginValueSetTt.stringValue(8559));
    }
}
