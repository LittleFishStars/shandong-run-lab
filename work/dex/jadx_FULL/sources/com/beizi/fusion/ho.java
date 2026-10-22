package com.beizi.fusion;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f27374a = 0;

    public void a(long j) {
        this.f27374a = j;
    }

    public boolean a(StrategyFilterModel strategyFilterModel) {
        return strategyFilterModel != null && ((long) strategyFilterModel.getMinTime()) > 0 && this.f27374a <= ((long) strategyFilterModel.getMinTime());
    }
}
