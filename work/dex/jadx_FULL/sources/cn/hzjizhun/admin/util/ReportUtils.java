package cn.hzjizhun.admin.util;

import android.text.TextUtils;
import cn.hzjizhun.admin.custom_ad.CustomReport;
import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReportUtils {
    private static ReportUtils mReportUtils;
    private Map<String, CustomReport> reportMap = new HashMap();

    private ReportUtils() {
    }

    public static String createKey() {
        return System.currentTimeMillis() + LoginConstants.UNDER_LINE + Math.random();
    }

    public static ReportUtils getInstance() {
        if (mReportUtils == null) {
            synchronized (ReportUtils.class) {
                if (mReportUtils == null) {
                    mReportUtils = new ReportUtils();
                }
            }
        }
        return mReportUtils;
    }

    public void addReport(String str, CustomReport customReport) {
        try {
            if (!TextUtils.isEmpty(str) && customReport != null) {
                this.reportMap.put(str, customReport);
            }
        } catch (Throwable unused) {
        }
    }

    public void deepLinkSuccessReport(String str) {
        try {
            CustomReport report = getReport(str);
            if (report != null) {
                report.deepLinkSuccessReport();
            }
        } catch (Throwable unused) {
        }
    }

    public CustomReport getReport(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.reportMap.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void h5ActionReport(String str, int i) {
        try {
            CustomReport report = getReport(str);
            if (report != null) {
                report.h5ActionReport(i);
            }
        } catch (Throwable unused) {
        }
    }

    public void h5CloseReport(String str) {
        try {
            CustomReport report = getReport(str);
            if (report != null) {
                report.h5CloseReport();
            }
        } catch (Throwable unused) {
        }
    }

    public void h5loadCompleteReport(String str) {
        try {
            CustomReport report = getReport(str);
            if (report != null) {
                report.h5loadCompleteReport();
            }
        } catch (Throwable unused) {
        }
    }

    public void removeReport(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.reportMap.remove(str);
        } catch (Throwable unused) {
        }
    }
}
