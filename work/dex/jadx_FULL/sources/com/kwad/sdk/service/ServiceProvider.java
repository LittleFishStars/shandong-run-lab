package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.wrapper.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ServiceProvider {
    private static List<Throwable> PT;

    @SuppressLint({"StaticFieldLeak"})
    private static Context bnZ;

    @SuppressLint({"StaticFieldLeak"})
    private static Context boa;
    private static boolean bob;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    public static void Uc() {
        bob = true;
    }

    @NonNull
    @Deprecated
    public static Context Ud() {
        return mContext;
    }

    private static void b(Throwable th) {
        if (PT == null) {
            PT = new CopyOnWriteArrayList();
        }
        PT.add(th);
    }

    public static void cJ(Context context) {
        bnZ = context;
        mContext = m.eT(context);
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    @NonNull
    public static Context getContext() {
        if (bob) {
            return Ud();
        }
        if (boa == null) {
            boa = m.wrapContextIfNeed(mContext);
        }
        return boa;
    }

    @NonNull
    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void h(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = PT;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        PT.clear();
        PT = null;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }
}
