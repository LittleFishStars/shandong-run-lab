package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class aa {
    private static final AtomicBoolean aIM = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static String HL() {
        String strCV = com.kwad.sdk.api.c.cV("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(strCV) ? strCV : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.Hv()) {
            return;
        }
        AtomicBoolean atomicBoolean = aIM;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.aa.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - b.r(context, "lastUpdateTime")) < b.r(context, "interval") * 1000) {
                        return;
                    }
                    s.HK().a(new ab() { // from class: com.kwad.sdk.api.loader.aa.1.1
                        @Override // com.kwad.sdk.api.loader.ab
                        public final String HM() {
                            return aa.HL();
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final IKsAdSDK HN() {
                            return iKsAdSDK;
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final Context getContext() {
                            return context;
                        }
                    }, new s.c<Boolean>() { // from class: com.kwad.sdk.api.loader.aa.1.2
                        private static void d(Boolean bool) {
                        }

                        @Override // com.kwad.sdk.api.loader.s.c
                        public final /* synthetic */ void m(Boolean bool) {
                            d(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void bv(Context context) {
        i.s(context, "");
    }
}
