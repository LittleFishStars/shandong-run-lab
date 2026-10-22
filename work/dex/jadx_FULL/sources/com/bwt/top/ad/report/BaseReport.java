package com.bwt.top.ad.report;

import com.bwt.top.http.HttpManager;
import com.bwt.top.http.RequestCallback;
import com.bwt.top.util.ALog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class BaseReport {
    private static final String TIME_MS = "__BC_TIME__";
    private static final String TIME_S = "__BC_TIME_S__";
    public static final String action_adObj_click = "click";
    public static final String action_adObj_display = "display";
    public static final String action_adObj_request = "request";
    public static final String action_adObj_request_success = "request-success";
    protected String TAG = getClass().getSimpleName();

    public class a implements RequestCallback {
        public a() {
        }

        @Override // com.bwt.top.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // com.bwt.top.http.RequestCallback
        public void onSuccess(String str) {
            ALog.v(BaseReport.this.TAG, "doReportOnly onSuccess");
        }
    }

    public class b implements RequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f1475a;

        public b(String str) {
            this.f1475a = str;
        }

        @Override // com.bwt.top.http.RequestCallback
        public void onFail(Throwable th) {
            ALog.e(BaseReport.this.TAG, "doReport action:" + this.f1475a + ",onFail:" + th.getMessage());
        }

        @Override // com.bwt.top.http.RequestCallback
        public void onSuccess(String str) {
            ALog.i(BaseReport.this.TAG, "doReport action:" + this.f1475a + ",onSuccess");
        }
    }

    public void clickReport() {
    }

    public void deepLinkFailReport() {
    }

    public void deepLinkReport() {
    }

    public void deepLinkSuccessReport() {
    }

    public void displayReport() {
    }

    public void doReport(String str) {
        String next;
        List<String> reportUrl = getReportUrl();
        if (reportUrl == null || reportUrl.size() <= 0) {
            return;
        }
        Iterator<String> it = reportUrl.iterator();
        while (it.hasNext() && (next = it.next()) != null && next.length() >= 1 && str != null && str.length() >= 1) {
            String strReplace = next.replace("{action}", str);
            ALog.i(this.TAG, "doReport action:" + str + ",url:" + strReplace);
            HttpManager.instance().get(strReplace, null, new b(str));
        }
    }

    public void doReportOnly(String str) {
        if (str == null || str.length() < 1) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (str.contains(TIME_S)) {
                str = str.replaceAll(TIME_S, String.valueOf(jCurrentTimeMillis / 1000));
            }
            if (str.contains(TIME_MS)) {
                str = str.replaceAll(TIME_MS, String.valueOf(jCurrentTimeMillis));
            }
        } catch (Exception unused) {
        }
        HttpManager.instance().get(str, null, new a());
    }

    public abstract List<String> getReportUrl();
}
