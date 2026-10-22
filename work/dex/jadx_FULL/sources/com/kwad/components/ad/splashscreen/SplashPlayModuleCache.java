package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> GI;

    public enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        Holder() {
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    private SplashPlayModuleCache() {
        this.GI = new HashMap<>(1);
    }
}
