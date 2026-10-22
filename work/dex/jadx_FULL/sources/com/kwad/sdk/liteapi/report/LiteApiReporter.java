package com.kwad.sdk.liteapi.report;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteApiReporter {
    private static final String REPORT_URL = "https://open.e.kuaishou.com/rest/e/v3/open/logDex";
    private static final String TAG = "LiteApiReporter";

    public static void reportDexError(Context context, String str, int i) {
        LiteApiLogger.w(TAG, "reportDexError dexErrorCode: " + i);
        try {
            LiteApiReportRequest liteApiReportRequestNewInstance = LiteApiReportRequest.newInstance(context, str, i);
            LiteReportHttp liteReportHttp = new LiteReportHttp(REPORT_URL);
            LiteApiLogger.w(TAG, "reportDexError before  reportHttp.request ");
            liteReportHttp.request(context, liteApiReportRequestNewInstance, new LiteReportHttp.a() { // from class: com.kwad.sdk.liteapi.report.LiteApiReporter.1
                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void a(LiteApiReportResponse liteApiReportResponse) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onSuccess: " + liteApiReportResponse);
                }

                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void b(Exception exc) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onError: " + exc.getMessage());
                    exc.printStackTrace();
                }
            });
        } catch (Throwable th) {
            LiteApiLogger.w(TAG, "reportDexError  error: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
