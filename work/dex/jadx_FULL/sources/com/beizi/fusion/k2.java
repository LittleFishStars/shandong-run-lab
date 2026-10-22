package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.common.analyse2.db.AnalyseEventDBModel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class k2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ja f27458a;
    private final p2 b;
    private final Context c;

    public k2(Context context, ja jaVar, p2 p2Var) {
        this.c = context.getApplicationContext();
        this.b = p2Var;
        this.f27458a = jaVar;
    }

    private void a() {
        if (this.f27458a != null) {
            long jA = l6.a(3);
            om.a("AnalyseDBHistoryTask", "删除过期的日志... 共计: " + this.f27458a.a(AnalyseEventDBModel.class, StrategyEventDBModel.COLUMN_EVENT_TIME, jA + ""));
        }
    }

    private List b() {
        ja jaVar = this.f27458a;
        if (jaVar == null) {
            return null;
        }
        List listA = jaVar.a(AnalyseEventDBModel.class, jaVar.a(StrategyEventDBModel.COLUMN_EVENT_TIME));
        StringBuilder sb = new StringBuilder();
        sb.append("从数据库查询数据...");
        sb.append(listA != null ? Integer.valueOf(listA.size()) : " 历史数据为空...");
        om.a("AnalyseDBHistoryTask", sb.toString());
        return listA;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        List listB = b();
        if (listB == null || listB.isEmpty()) {
            return;
        }
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            ((AnalyseEventDBModel) it.next()).a(true);
        }
        q2 q2Var = new q2(this.c, this.f27458a, this.b);
        q2Var.c(listB);
        q2Var.run();
    }
}
