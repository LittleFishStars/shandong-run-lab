package com.alipay.sdk.m.i0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.ab;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.x;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements a {
    public static c d;
    public static DataReportResult e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f25448a;
    public BugTrackMessageService b;
    public DataReportService c;

    public c(Context context, String str) {
        this.f25448a = null;
        this.b = null;
        this.c = null;
        ab abVar = new ab();
        abVar.a(str);
        h hVar = new h(context);
        this.f25448a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, abVar);
        this.c = (DataReportService) this.f25448a.a(DataReportService.class, abVar);
    }

    public static synchronized c a(Context context, String str) {
        if (d == null) {
            d = new c(context, str);
        }
        return d;
    }

    @Override // com.alipay.sdk.m.i0.a
    public DataReportResult a(DataReportRequest dataReportRequest) throws InterruptedException {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new Thread(new b(this, dataReportRequest)).start();
            for (int i = com.alipay.sdk.m.j0.a.f25451a; e == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return e;
    }

    @Override // com.alipay.sdk.m.i0.a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        String strLogCollect;
        if (com.alipay.sdk.m.d0.a.a(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        try {
            strLogCollect = bugTrackMessageService.logCollect(com.alipay.sdk.m.d0.a.f(str));
        } catch (Throwable unused) {
            strLogCollect = null;
        }
        if (com.alipay.sdk.m.d0.a.a(strLogCollect)) {
            return false;
        }
        return ((Boolean) new JSONObject(strLogCollect).get("success")).booleanValue();
    }
}
