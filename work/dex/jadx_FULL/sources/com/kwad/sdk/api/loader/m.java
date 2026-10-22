package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
final class m {
    private final String aIu;
    private final String aIv;
    private final String aIw;
    private Resources aIx;
    private ClassLoader aIy;
    private IKsAdSDK aIz;

    private m(String str, String str2, String str3) {
        this.aIu = str;
        this.aIv = str2;
        this.aIw = str3;
    }

    private void HG() {
        if (TextUtils.isEmpty(this.aIu)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.aIu);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public static synchronized m a(Context context, ClassLoader classLoader, String str) {
        try {
        } catch (Throwable th) {
            com.kwad.sdk.api.c.t(th);
            return null;
        }
        return b(context, classLoader, j.y(context, str), j.z(context, str), j.A(context, str));
    }

    public static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        m mVar = new m(str, str2, str3);
        mVar.a(context, classLoader);
        return mVar;
    }

    public final Resources HE() {
        return this.aIx;
    }

    public final IKsAdSDK HF() {
        return this.aIz;
    }

    public final ClassLoader getClassLoader() {
        return this.aIy;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.aIu + "', mDexDir='" + this.aIv + "', mNativeLibDir='" + this.aIw + "', mResource=" + this.aIx + ", mClassLoader=" + this.aIy + ", mKsSdk=" + this.aIz + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        HG();
        Resources resourcesA = w.a(context, context.getResources(), this.aIu);
        ClassLoader classLoaderA = g.a(context, classLoader, this.aIu, this.aIv, this.aIw);
        IKsAdSDK iKsAdSDKA = Loader.a(classLoaderA);
        this.aIx = resourcesA;
        this.aIy = classLoaderA;
        this.aIz = iKsAdSDKA;
        if (iKsAdSDKA.getClass().getClassLoader() instanceof g.a) {
            int sDKType = iKsAdSDKA.getSDKType();
            if (sDKType == 1) {
                return;
            }
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
        throw new RuntimeException("classLoader is not expect dynamic classloader:");
    }
}
