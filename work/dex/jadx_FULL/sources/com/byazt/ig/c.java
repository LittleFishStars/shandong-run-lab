package com.byazt.ig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byakv.z.SoftDecTool;
import com.byazt.nys.tt;
import com.byazt.of.a;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.huachenjie.common.constants.UserConstants;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.MODIFY_PHONE_ERROR_CODE.b, 20})
public class c {
    public static c c;
    public long tt = 0;

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c cVar = new c();
                    c = cVar;
                    cVar.tt = 0L;
                }
            }
        }
        return c;
    }

    private boolean tt() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean ve() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.tt = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.tt >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return tt();
        }
        if (i != 0 || this.tt < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return tt();
    }

    private String tt(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public synchronized JSONObject c(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strTt = tt(context);
            if (!TextUtils.isEmpty(strTt) && ve()) {
                File file = new File(strTt);
                if (file.exists()) {
                    jSONObject = c(file, context, str);
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    private JSONObject c(File file, Context context, String str) {
        JSONObject jSONObjectC = a.c(file);
        File fileC = tt.c(context);
        if (fileC != null) {
            a.c(jSONObjectC, "files", c(!TextUtils.isEmpty(str) ? tt.c(context).getParent() : tt.c(context).getPath()), false);
            File parentFile = fileC.getParentFile();
            if (parentFile != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb.append("/shared_prefs");
                List<String> listC = c(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb2.append("/databases");
                List<String> listC2 = c(sb2.toString());
                a.c(jSONObjectC, "prefs", listC, false);
                a.c(jSONObjectC, "databases", listC2, false);
            }
        }
        try {
            JSONObject jSONObjectC2 = c(context);
            if (jSONObjectC2 != null && jSONObjectC2.length() > 0) {
                jSONObjectC.put("manifest", jSONObjectC2);
            }
            jSONObjectC.put("rt", this.tt);
            jSONObjectC.put("path", str);
        } catch (JSONException unused) {
        }
        return jSONObjectC;
    }

    private List<String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put(RequestPermission.PERMISSIONS, jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
