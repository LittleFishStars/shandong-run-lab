package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private IKsAdSDK aIA;
    private m aIB;
    private final AtomicBoolean mHasInit;

    public static class a {
        private static final Loader aIC = new Loader(0);
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    private static void C(Context context, String str) {
        j.B(context, str);
    }

    private static void HI() {
        try {
            int iHw = com.kwad.sdk.api.c.Hw();
            if (iHw > 0) {
                try {
                    f.bn(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.bn(mContext));
                    f.bn(mContext).m1061do(iHw);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(p3.f, new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (IKsAdSDK) objInvoke;
    }

    private boolean bt(Context context) {
        try {
            String strBo = i.bo(context);
            String strBp = i.bp(context);
            if (TextUtils.isEmpty(strBo) && TextUtils.isEmpty(strBp)) {
                return false;
            }
            if (!TextUtils.isEmpty(strBp) && i.N(strBp, strBo)) {
                i.s(context, strBp);
                C(context, strBo);
                i.t(context, "");
                strBo = strBp;
            }
            return !TextUtils.isEmpty(strBo);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.t(th);
            return false;
        }
    }

    private static void bu(Context context) {
        try {
            String strBq = i.bq(context);
            boolean zB = b.b(context, i.aIf, false);
            if (TextUtils.isEmpty(strBq) || !strBq.equals(BuildConfig.VERSION_NAME) || zB) {
                String strBo = i.bo(context);
                i.s(context, "");
                i.t(context, "");
                b.a(context, i.aIf, false);
                j.j(j.x(context, strBo));
                i.u(context, BuildConfig.VERSION_NAME);
            }
        } catch (Throwable th) {
            com.kwad.sdk.api.c.t(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.HD();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, com.getui.gtc.dyc.b.b.f30337a)));
    }

    public static Loader get() {
        return a.aIC;
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        m mVar = this.aIB;
        ClassLoader classLoader = mVar != null ? mVar.getClassLoader() : null;
        if (com.kwad.sdk.api.a.aHz.booleanValue()) {
            classLoader = this.aIA.getClass().getClassLoader();
            Objects.toString(classLoader);
        }
        Objects.toString(classLoader);
        return classLoader;
    }

    @MainThread
    public Resources getExternalResource() {
        m mVar = this.aIB;
        if (mVar != null) {
            return mVar.HE();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.aIB;
        return mVar != null ? mVar.getClassLoader() : getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.aIA;
        }
        mContext = context.getApplicationContext();
        bu(context);
        if (bt(context)) {
            this.aIB = m.a(context, classLoader, i.bo(context));
        }
        boolean zBooleanValue = com.kwad.sdk.api.a.aHz.booleanValue();
        m mVar = this.aIB;
        if (mVar == null && zBooleanValue) {
            ClassLoader classLoaderInitDex = DexLoader.initDex(context, classLoader);
            if (classLoaderInitDex == null) {
                return null;
            }
            classLoaderInitDex.toString();
            this.aIA = a(classLoaderInitDex);
            Objects.toString(this.aIA);
        } else if (mVar == null) {
            IKsAdSDK iKsAdSDKA = a(getClass().getClassLoader());
            this.aIA = iKsAdSDKA;
            iKsAdSDKA.setIsExternal(false);
        } else {
            IKsAdSDK iKsAdSDKHF = mVar.HF();
            this.aIA = iKsAdSDKHF;
            iKsAdSDKHF.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.aIA);
        if (this.aIB != null) {
            HI();
        }
        this.mHasInit.set(true);
        return this.aIA;
    }

    public boolean isExternalLoaded() {
        return this.aIB != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.aIA.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.aIA.newInstance(cls);
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.aIA = null;
        this.aIB = null;
    }

    private Loader() {
        this.aIB = null;
        this.mHasInit = new AtomicBoolean(false);
    }
}
