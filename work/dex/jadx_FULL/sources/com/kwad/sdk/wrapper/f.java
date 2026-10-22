package com.kwad.sdk.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.w;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Resources aDN;
    private Resources btS;
    private i btT;
    private boolean btU;
    private ClassLoader btV;
    private boolean btW;
    private final AtomicBoolean mHasInit;

    public static class a {
        private static final f btX = new f(0);
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    private boolean FW() {
        boolean zFu = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu();
        if (!this.btW || zFu) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FW();
        }
        return false;
    }

    private static boolean FX() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FX();
    }

    public static f XT() {
        return a.btX;
    }

    private boolean XV() {
        Context contextUd = ServiceProvider.Ud();
        if (m.eS(contextUd)) {
            this.aDN = contextUd.getResources();
            return true;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
        return false;
    }

    private boolean XW() {
        Object objA;
        try {
            Context contextUd = ServiceProvider.Ud();
            if (!m.eS(contextUd)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
                return false;
            }
            Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
            Resources resourcesA = null;
            Object objInvoke = cls.getDeclaredMethod(p3.f, new Class[0]).invoke(null, new Object[0]);
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (objA = ab.a(field, objInvoke)) != null) {
                    for (Field field2 : objA.getClass().getDeclaredFields()) {
                        if (field2.getType() == Resources.class) {
                            field2.setAccessible(true);
                            String strY = com.kwad.sdk.wrapper.a.y(contextUd, w.bo(contextUd));
                            if (TextUtils.isEmpty(strY)) {
                                com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                            } else {
                                resourcesA = com.kwad.library.b.b.b.a(contextUd, contextUd.getResources(), strY);
                                com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                            }
                            if (resourcesA == null) {
                                resourcesA = (Resources) field2.get(objA);
                            }
                            Resources resources = contextUd.getResources();
                            i iVar = new i(resourcesA, resources);
                            ab.a(field2, objA, iVar);
                            this.aDN = resources;
                            this.btS = resourcesA;
                            this.btT = iVar;
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    public final boolean Wn() {
        return this.mHasInit.get();
    }

    public final boolean XU() {
        return this.btW;
    }

    public final ClassLoader getClassLoader() {
        return this.btV;
    }

    public final Resources getResources() {
        boolean zFu = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.btW + ", mHostResources: " + this.aDN + ", isExternal: " + zFu);
        return (!this.btW || zFu) ? this.btT : this.aDN;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu()) {
                if (FW() && XW()) {
                    this.btV = getClass().getClassLoader();
                    j.cL(FX());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.btU = true;
                } else {
                    this.btU = false;
                }
            } else if (this.btW) {
                j.cL(true);
                XV();
                this.btV = getClass().getClassLoader();
                this.btU = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aDN + ", mResResources=" + this.btS + ", mPluginResources=" + this.btT + ", mEnable=" + this.btU + '}';
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.btW = com.kwad.framework.a.a.ayQ.booleanValue();
    }
}
