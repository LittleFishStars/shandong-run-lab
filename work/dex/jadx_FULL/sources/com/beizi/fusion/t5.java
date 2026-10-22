package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.complain.ComplainModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class t5 {
    public static boolean a(Context context, ba baVar, StrategyFilterModel strategyFilterModel) {
        if (baVar != null && strategyFilterModel != null) {
            String strG = baVar.g();
            if (!TextUtils.isEmpty(strG)) {
                long jA = p0.a(context, a(m0.a()), a("c_ts_%s", strG), 0L);
                if (jA != 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - jA;
                    ComplainModel complainModel = strategyFilterModel.getComplainModel();
                    if (complainModel != null && complainModel.getDuration() > jCurrentTimeMillis) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void a(Context context, ba baVar, long j) {
        if (baVar != null) {
            String strG = baVar.g();
            if (j != 0) {
                p0.b(context, a(m0.a()), a("c_ts_%s", strG), j);
            }
        }
    }

    private static String a(String str) {
        return String.format("ansp_complain_%s", str);
    }

    private static String a(String str, String str2) {
        return String.format(str, str2);
    }
}
