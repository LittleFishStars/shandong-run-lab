package cj.mobile.wm;

import android.app.Application;
import android.content.SharedPreferences;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class je {
    public static float dexa(String str, float f) {
        try {
            Application application = InsightProxy.getApplication();
            return application == null ? f : application.getSharedPreferences("fanti_sp_file", 0).getFloat(str, f);
        } catch (Exception unused) {
            return dexa(str, String.valueOf(f));
        }
    }

    public static float dexa(String str, String str2) {
        try {
            return Float.parseFloat(dexb(str, str2));
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public static long dexa(String str) {
        try {
            Application application = InsightProxy.getApplication();
            if (application == null) {
                return -1L;
            }
            return application.getSharedPreferences("fanti_sp_file", 0).getLong(str, -1L);
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String dexa() {
        try {
            Application application = InsightProxy.getApplication();
            return application == null ? "" : application.getSharedPreferences("fanti_sp_file", 0).getString("installed_list", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void dexa(String str, long j) {
        try {
            Application application = InsightProxy.getApplication();
            if (application == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = application.getSharedPreferences("fanti_sp_file", 0).edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dexa(List<String> list) {
        try {
            Application application = InsightProxy.getApplication();
            if (application == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = application.getSharedPreferences("fanti_sp_file", 0).edit();
            String strDexb = ae.dexb(dex04.b(list), "ykaduscNO7X8D5Ny");
            Objects.requireNonNull(strDexb);
            editorEdit.putString("installed_list", strDexb);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String dexb(String str, String str2) {
        try {
            Application application = InsightProxy.getApplication();
            return application == null ? "" : application.getSharedPreferences("fanti_sp_file", 0).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void dexc(String str, String str2) {
        try {
            Application application = InsightProxy.getApplication();
            if (application == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = application.getSharedPreferences("fanti_sp_file", 0).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
