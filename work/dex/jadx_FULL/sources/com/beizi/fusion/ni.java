package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ni implements rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27562a;
    private final AdItemModel b;
    private final ba c;
    private final AdTraceModel d;

    public ni(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        this.f27562a = context;
        this.b = adItemModel;
        this.c = baVar;
        this.d = adTraceModel;
        ReportModel3 report = adItemModel.getReport();
        if (report != null) {
            adTraceModel.setCSensorModel(report.getCSensor());
            adTraceModel.setTSensorModel(report.getTSensor());
        }
    }

    @Override // com.beizi.fusion.rd
    public AdTraceModel a() {
        return this.d;
    }

    @Override // com.beizi.fusion.rd
    public ba b() {
        return this.c;
    }

    @Override // com.beizi.fusion.rd
    public AdItemModel c() {
        return this.b;
    }

    @Override // com.beizi.fusion.rd
    public Context getContext() {
        return this.f27562a;
    }
}
