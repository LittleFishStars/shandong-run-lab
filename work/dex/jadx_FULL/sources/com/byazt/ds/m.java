package com.byazt.ds;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 130})
public class m extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28427a;
    public final Context n;

    public m(Context context, x xVar) {
        super(false, false);
        this.n = context;
        this.f28427a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        int i;
        ApplicationInfo applicationInfo;
        int i2;
        String packageName = this.n.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f28427a.lr())) {
            jSONObject.put("package", packageName);
        } else {
            if (com.byazt.yv.da.tt) {
                com.byazt.yv.da.c("has zijie pkg", null);
            }
            jSONObject.put("package", this.f28427a.lr());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.n.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                com.byazt.yv.da.tt(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (TextUtils.isEmpty(this.f28427a.zb())) {
            jSONObject.put(AlibcCommonConstant.APP_VERSION, packageInfo != null ? packageInfo.versionName : "");
        } else {
            jSONObject.put(AlibcCommonConstant.APP_VERSION, this.f28427a.zb());
        }
        if (TextUtils.isEmpty(this.f28427a.pf())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.f28427a.pf());
        }
        if (this.f28427a.h() != 0) {
            jSONObject.put("version_code", this.f28427a.h());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.f28427a.d() != 0) {
            jSONObject.put("update_version_code", this.f28427a.d());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.f28427a.eo() != 0) {
            jSONObject.put("manifest_version_code", this.f28427a.eo());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.f28427a.md())) {
            jSONObject.put("app_name", this.f28427a.md());
        }
        if (!TextUtils.isEmpty(this.f28427a.or())) {
            jSONObject.put("tweaked_channel", this.f28427a.or());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i2 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.n.getString(i2));
        return true;
    }
}
