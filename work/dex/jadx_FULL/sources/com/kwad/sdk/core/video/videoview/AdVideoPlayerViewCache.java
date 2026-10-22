package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> GI;

    public enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        Holder() {
        }

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.GI.put(str, new WeakReference<>(aVar));
    }

    public final a ft(String str) {
        WeakReference<a> weakReference = this.GI.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.GI.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.GI.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.GI = new HashMap<>(1);
    }
}
