package com.byazt.xe;

import android.os.SystemClock;
import com.byazt.uq.i;
import com.byazt.uq.u;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 46})
public class n {

    public interface c {
        boolean c(String str, int i);
    }

    public static void c() {
        GlobalParam.getInstance().getReporter().c("zeus_stage_dex_opt", "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((i.a() || i.x()) && com.byazt.th.uj.tt(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().c("zeus_stage_dex_opt", "post");
            com.byazt.th.n.tt(new Runnable() { // from class: com.byazt.xe.n.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().c("zeus_stage_dex_opt", "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    n.tt();
                }
            });
        }
    }

    public static synchronized void tt() {
        Map<String, ?> all = tt.c(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (ve().c(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    tt.c(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    u.c().tt(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static c ve() {
        if (i.x()) {
            return new uj();
        }
        return i.a() ? new ve() : new c() { // from class: com.byazt.xe.n.2
            @Override // com.byazt.xe.n.c
            public boolean c(String str, int i) {
                return true;
            }
        };
    }
}
