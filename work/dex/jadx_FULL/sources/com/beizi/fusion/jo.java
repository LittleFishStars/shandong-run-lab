package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.unite.UniteControlModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class jo {
    private final Context c;
    private long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27454a = "asnp_ad_%s_common";
    private final String b = "%s_unite";
    private final String e = m0.a();

    public jo(Context context) {
        this.c = context;
    }

    public boolean a(StrategyFilterModel strategyFilterModel) {
        UniteControlModel uniteControlModel = strategyFilterModel.getUniteControlModel();
        if (uniteControlModel != null) {
            int random = uniteControlModel.getRandom();
            long duration = uniteControlModel.getDuration();
            long jA = a();
            long jCurrentTimeMillis = System.currentTimeMillis() - jA;
            if (jA > 0 && duration > 0 && jCurrentTimeMillis < duration && random < this.d && random != 100) {
                return true;
            }
        }
        return false;
    }

    public void b(long j) {
        this.d = j;
    }

    public void a(long j) {
        p0.b(this.c, String.format("asnp_ad_%s_common", this.e), String.format("%s_unite", this.e), j);
    }

    private long a() {
        return p0.a(this.c, String.format("asnp_ad_%s_common", this.e), String.format("%s_unite", this.e), 0L);
    }
}
