package com.kwad.components.ad.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends e implements p {
    @Override // com.kwad.sdk.components.p
    public final JSONObject D(String str) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = str;
        return a.a(appPackageInfo);
    }

    @Override // com.kwad.sdk.components.p
    public final Map<String, AppPackageInfo> P(Context context) {
        return a.P(context);
    }

    @Override // com.kwad.sdk.components.p
    public final void a(Context context, com.kwad.sdk.g.a<JSONArray> aVar) {
        a.a(context, aVar);
    }

    @Override // com.kwad.sdk.components.p
    public final JSONArray[] b(Context context, List<String> list) {
        return a.b(context, list);
    }

    @Override // com.kwad.sdk.components.p
    @NonNull
    public final JSONArray c(@NonNull Map<String, AppPackageInfo> map) {
        return a.c(map);
    }

    @Override // com.kwad.sdk.components.p
    public final JSONObject e(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = aa.getPackageInfo(context, str, 0);
            if (packageInfo != null) {
                return a.a(a.a(packageInfo, packageManager));
            }
            return null;
        } catch (Throwable th) {
            c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return p.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
