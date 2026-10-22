package com.byazt.wrq;

import android.util.SparseArray;
import com.byazt.omf.p;
import com.byazt.ou.DownloadMarketInterceptor;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1557, 54})
public abstract class ve extends com.byazt.fb.uj implements DownloadMarketInterceptor, LongSupplier {
    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null && i == 223901) {
            if (!com.byazt.lq.uj.c(p.uj)) {
                pluginValueSet = com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).tt();
            }
            if (pluginValueSet != null) {
                return (T) com.byazt.yxi.uj.c().c(223902, interceptObmMarket((Map) com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).tt().objectValue(223902, Map.class))).tt();
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
