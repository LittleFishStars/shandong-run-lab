package com.byazt.zlb;

import android.util.SparseArray;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 568, 15})
public class uj implements Function<SparseArray<Object>, Object> {
    public static volatile uj c;

    private uj() {
    }

    public static uj create() {
        if (c == null) {
            c = new uj();
        }
        return c;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        if (iIntValue == 10001) {
            x.m().sl(pluginValueSetTt.booleanValue(1));
        } else {
            if (iIntValue == 10002) {
                return Boolean.valueOf(x.m().tx());
            }
            if (iIntValue == 10003) {
                gt.c().c((Function<SparseArray<Object>, Object>) pluginValueSetTt.objectValue(0, Function.class));
            } else if (iIntValue == 10004) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSetTt.objectValue(0, Function.class);
                String str = (String) pluginValueSetTt.objectValue(1, String.class);
                String str2 = (String) pluginValueSetTt.objectValue(2, String.class);
                String str3 = (String) pluginValueSetTt.objectValue(3, String.class);
                String str4 = (String) pluginValueSetTt.objectValue(4, String.class);
                HashMap map = new HashMap();
                map.put("adtype", str2);
                map.put("rit", str);
                map.put("image_mode", str3);
                map.put("preview_extra", str4);
                gt.c().c(map, function);
            } else {
                if (iIntValue == 10005) {
                    com.byazt.rl.c cVarC = com.byazt.rl.c.c();
                    cVarC.c(0, x.m().os());
                    cVarC.c(1, x.m().oz());
                    cVarC.c(2, x.m().r());
                    cVarC.c(3, x.m().s());
                    cVarC.c(4, x.m().y());
                    return cVarC.tt().sparseArray();
                }
                if (iIntValue == 10006) {
                    gt.c().c((Map<String, Object>) pluginValueSetTt.objectValue(0, Map.class), (Function<SparseArray<Object>, Object>) pluginValueSetTt.objectValue(1, Function.class));
                } else if (iIntValue == 10007) {
                    x.m().c((x.ve) null);
                } else if (iIntValue == 10008) {
                    return Boolean.valueOf(x.m().bx());
                }
            }
        }
        return null;
    }
}
