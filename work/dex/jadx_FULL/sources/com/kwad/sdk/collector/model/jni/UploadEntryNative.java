package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class UploadEntryNative extends NativeObject implements e {
    public UploadEntryNative(long j) {
        this.mPtr = j;
    }

    private String Ig() {
        try {
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return strUploadEntryGetOriginFilePath.substring(strUploadEntryGetOriginFilePath.indexOf(strUploadEntryGetPackageName)).replaceFirst(strUploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    @Override // com.kwad.sdk.collector.model.e
    @Nullable
    @WorkerThread
    public final JSONObject Ie() {
        try {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, AppStatusNative.uploadEntryGetPackageName(this));
            ac.putValue(jSONObject, "content", com.kwad.sdk.collector.e.dm(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            ac.putValue(jSONObject, "fileName", Ig());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteUploadEntry(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (strUploadEntryGetPackageName == null ? a(uploadEntryNative) != null : !strUploadEntryGetPackageName.equals(a(uploadEntryNative))) {
                return false;
            }
            if (strUploadEntryGetOriginFilePath != null) {
                return strUploadEntryGetOriginFilePath.equals(AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative));
            }
            if (AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative) == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        return ((strUploadEntryGetPackageName != null ? strUploadEntryGetPackageName.hashCode() : 0) * 31) + (strUploadEntryGetOriginFilePath != null ? strUploadEntryGetOriginFilePath.hashCode() : 0);
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString(ALPParamConstant.PACKAGENAME);
        String strOptString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, strOptString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, strOptString2);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, AppStatusNative.uploadEntryGetPackageName(this));
        ac.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + '}';
    }

    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }
}
