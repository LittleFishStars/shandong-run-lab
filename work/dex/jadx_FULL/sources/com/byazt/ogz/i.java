package com.byazt.ogz;

import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 42})
public class i {
    public static final AtomicInteger c = new AtomicInteger(com.byazt.nys.tt.tt(gt.getContext(), "sync_switch", 0).getInt("status", 1));
    public static com.byazt.omf.ve tt;
    public static PluginValueSet ve;

    public static boolean c() {
        return c.get() == 1;
    }

    public static void c(int i) {
        com.byazt.omf.ve veVar;
        if (i == 1 || i == 2) {
            com.byazt.nys.tt.tt(gt.getContext(), "sync_switch", 0).edit().putInt("status", i).apply();
            AtomicInteger atomicInteger = c;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (veVar = tt) == null || veVar.isInitSuccess()) {
                return;
            }
            try {
                tt.init(gt.getContext(), ve, new com.byazt.fb.ve((Function) ve.objectValue(15, Function.class)));
                tt = null;
                ve = null;
            } catch (Throwable th) {
                m.ve("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
