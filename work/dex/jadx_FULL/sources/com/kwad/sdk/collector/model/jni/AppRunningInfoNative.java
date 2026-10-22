package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.ac;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    private static SimpleDateFormat asa = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* JADX INFO: renamed from: If, reason: merged with bridge method [inline-methods] */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative);
        if (jAppRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return jAppRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    private static String aw(long j) {
        return asa.format(new Date(j));
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String strAppRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String strAppRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        if (jAppRunningInfoGetLastRunningTime / jAppRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / jAppRunningInfoGetGranularity && strAppRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return strAppRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / jAppRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (jAppRunningInfoGetLastRunningTime ^ (jAppRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, AppStatusNative.appRunningInfoGetPackageName(this));
        ac.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + aw(c.c(this)) + '}';
    }

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }
}
