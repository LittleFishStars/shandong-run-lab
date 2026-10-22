package cj.mobile.wm;

import android.os.Environment;
import android.text.TextUtils;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s0 {
    public static String dexa;

    public static String dexa() {
        File externalFilesDir;
        if (TextUtils.isEmpty(dexa)) {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = InsightProxy.getApplication().getExternalFilesDir(null)) != null) {
                dexa = externalFilesDir.getAbsolutePath() + File.separator + "ad_download";
            }
            if (TextUtils.isEmpty(dexa)) {
                dexa = InsightProxy.getApplication().getFilesDir().getAbsolutePath() + File.separator + "ad_download";
            }
        }
        return dexa;
    }
}
