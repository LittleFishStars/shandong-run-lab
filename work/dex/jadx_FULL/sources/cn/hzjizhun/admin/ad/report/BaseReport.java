package cn.hzjizhun.admin.ad.report;

import cn.hzjizhun.admin.http.HttpManager;
import cn.hzjizhun.admin.http.RequestCallback;
import cn.hzjizhun.admin.util.ALog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            ALog.v(BaseReport.this.TAG, "doReportOnly onSuccess");
        }
    }

    public class b implements RequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f273a;

        public b(String str) {
            this.f273a = str;
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
            ALog.e(BaseReport.this.TAG, "doReport action:" + this.f273a + ",onFail:" + th.getMessage());
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            ALog.i(BaseReport.this.TAG, "doReport action:" + this.f273a + ",onSuccess");
        }
    }

    public void clickReport(String str) {
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
        try {
            List<String> reportUrl = getReportUrl();
            if (reportUrl == null || reportUrl.isEmpty()) {
                return;
            }
            Iterator<String> it = reportUrl.iterator();
            while (it.hasNext() && (next = it.next()) != null && !next.isEmpty() && str != null && !str.isEmpty()) {
                String strReplace = next.replace("{action}", str);
                ALog.i(this.TAG, "doReport action:" + str + ",url:" + strReplace);
                HttpManager.instance().get(strReplace, null, new b(str));
            }
        } catch (Throwable unused) {
        }
    }

    public void doReportOnly(String str) {
        doReportOnly(str, null);
    }

    public HashMap<String, String> getReportHeader() {
        return null;
    }

    public abstract List<String> getReportUrl();

    public void doReportOnly(String str, HashMap<String, String> map) {
        if (str == null || str.isEmpty()) {
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
            str = str.replaceAll("_clickTime10_", (jCurrentTimeMillis / 1000) + "").replaceAll("_clickTime13_", jCurrentTimeMillis + "");
            if (map != null) {
                for (String str2 : map.keySet()) {
                    str = str.replaceAll(str2, map.get(str2));
                }
            }
        } catch (Throwable unused) {
        }
        HttpManager.instance().get(str, null, getReportHeader(), new a());
    }
}
