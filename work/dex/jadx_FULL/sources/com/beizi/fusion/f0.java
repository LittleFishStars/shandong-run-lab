package com.beizi.fusion;

import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ClkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ShowModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class f0 implements s9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ReportModel3 f27260a;

    @Override // com.beizi.fusion.s9
    public void a(ReportModel3 reportModel3) {
        this.f27260a = reportModel3;
    }

    @Override // com.beizi.fusion.s9
    public void a(xa xaVar, View view, AdTraceModel adTraceModel, s9.a aVar) {
        ShowModel show;
        ClkModel clk;
        we.b bVarA;
        we.b bVarA2;
        if (xaVar == x9.a.AD_CLICK && (clk = this.f27260a.getClk()) != null) {
            boolean zA = gn.a.a(view, clk.getAv());
            boolean z = clk.getNcb() == 1;
            if (!zA || z) {
                return;
            }
            if (clk.getAcb() == 1) {
                int interactiveType = adTraceModel.getInteractiveType();
                if (interactiveType == dd.a.EULER_INTERACTIVE_TRIGGER.getEventCode()) {
                    int agl = clk.getAgl();
                    we.c sensorRecord = adTraceModel.getSensorRecord();
                    if (sensorRecord != null && (bVarA2 = sensorRecord.a(4)) != null) {
                        float f = agl;
                        if (bVarA2.f27907a < f && bVarA2.b < f && bVarA2.c < f) {
                            return;
                        }
                    }
                }
                if (interactiveType == dd.a.SHAKE_INTERACTIVE_TRIGGER.getEventCode()) {
                    int at = clk.getAt();
                    we.c sensorRecord2 = adTraceModel.getSensorRecord();
                    if (sensorRecord2 != null && (bVarA = sensorRecord2.a(1)) != null && bVarA.a("XYZ") < at) {
                        return;
                    }
                }
            }
        }
        if (xaVar != gc.a.AD_EXPOSURE || (show = this.f27260a.getShow()) == null || a(show, adTraceModel)) {
            aVar.b();
            aVar.a();
        }
    }

    private boolean a(ShowModel showModel, AdTraceModel adTraceModel) {
        return System.currentTimeMillis() - adTraceModel.getExposureTimestamp() >= ((long) showModel.getRt());
    }
}
