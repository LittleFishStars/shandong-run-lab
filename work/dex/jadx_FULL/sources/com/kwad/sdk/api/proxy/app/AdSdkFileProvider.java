package com.kwad.sdk.api.proxy.app;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.loader.b;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class AdSdkFileProvider extends FileProvider {
    private static final String SP_INSTALLER_CHECK_PKG_AB_SWITCH = "installerCheckPkgAbSwitch";
    private static final String SP_INSTALLER_EXTRA_PKGS_KEY = "installerCheckExtraPkgs";
    private static final String SP_OPEN_FILE_RECORD = "SP_OPEN_FILE_RECORD";
    private static final String TAG = "AdSdkFileProvider";
    public static long sLaunchTime;
    private static Set<String> sSystemInstallers;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        sSystemInstallers = copyOnWriteArraySet;
        copyOnWriteArraySet.add("com.android.packageinstaller");
        sSystemInstallers.add("com.google.android.packageinstaller");
    }

    private void checkLocalConfig() {
        try {
            String string = ApiConfigUtils.readString(getContext(), SP_INSTALLER_EXTRA_PKGS_KEY, "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(getDecodeString(string));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string2 = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string2)) {
                    sSystemInstallers.add(string2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !ApiBase64.isEncodeKsSdk(str)) ? str : ApiBase64.decodeKsSdk(str);
    }

    private boolean isInstallerPkgCheckOpen() {
        try {
            return ApiConfigUtils.readInt(getContext(), SP_INSTALLER_CHECK_PKG_AB_SWITCH, 0) == 1;
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(getContext().getApplicationContext());
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        boolean zContains;
        String string;
        Objects.toString(uri);
        if (isInstallerPkgCheckOpen()) {
            checkLocalConfig();
            String callingPackage = getCallingPackage();
            zContains = sSystemInstallers.contains(callingPackage);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callingPkg", callingPackage);
                jSONObject.put("checkResult", String.valueOf(zContains));
                jSONObject.put("uri", uri.toString());
                String strB = b.b(getContext(), SP_OPEN_FILE_RECORD, "");
                if (TextUtils.isEmpty(strB)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    string = jSONArray.toString();
                } else {
                    JSONArray jSONArray2 = new JSONArray(strB);
                    jSONArray2.put(jSONObject);
                    string = jSONArray2.toString();
                }
                b.c(getContext(), SP_OPEN_FILE_RECORD, string);
            } catch (Throwable unused) {
            }
        } else {
            zContains = true;
        }
        if (zContains) {
            return super.openFile(uri, str);
        }
        return null;
    }
}
