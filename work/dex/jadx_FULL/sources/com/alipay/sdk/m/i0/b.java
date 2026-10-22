package com.alipay.sdk.m.i0;

import android.util.Log;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f25447a;
    public final /* synthetic */ c b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.f25447a = dataReportRequest;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DataReportResult unused = c.e = this.b.c.reportData(this.f25447a);
            Log.d("APSecuritySdk", "rpc success");
        } catch (Throwable th) {
            DataReportResult unused2 = c.e = new DataReportResult();
            c.e.success = false;
            c.e.resultCode = "static data rpc upload error, " + com.alipay.sdk.m.d0.a.a(th);
            Log.d("APSecuritySdk", "rpc failed:" + com.alipay.sdk.m.d0.a.a(th));
        }
    }
}
