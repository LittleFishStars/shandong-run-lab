package com.kwad.components.core.innerEc.live;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.core.innerEc.e;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.slide.LiveDetailActivity;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveInfo;
import com.kwad.sdk.utils.ab;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {

    @Nullable
    public static a Tr;
    private static AtomicBoolean Ts = new AtomicBoolean(false);

    public static void b(Context context, final AdTemplate adTemplate, final com.kwad.components.core.e.d.a.C1201a c1201a) {
        com.kwad.components.core.innerEc.logger.a.aS(adTemplate);
        Tr = new a() { // from class: com.kwad.components.core.innerEc.live.b.1
            @Override // com.kwad.components.core.innerEc.live.a
            public final void rs() {
                c.d("FullLiveModule", "FullLiveModule onLaunchSuccess");
            }

            @Override // com.kwad.components.core.innerEc.live.a
            public final void rt() {
                c.d("FullLiveModule", "FullLiveModule onLaunchFail");
                adTemplate.setHasInnerEcFailed(true);
                com.kwad.components.core.innerEc.logger.a.l(adTemplate, "onLaunchFail");
                com.kwad.components.core.e.d.a.C1201a c1201a2 = c1201a;
                if (c1201a2 != null) {
                    f.G(c1201a2);
                }
                b.Tr = null;
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append(e.rf().getUserId());
        String string = sb.toString();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        LiveInfo liveInfo = adTemplate.liveInfo;
        liveInfo.kwaiUserId = string;
        liveInfo.deeplink = com.kwad.sdk.core.response.helper.a.da(adInfoEO);
        long jFl = com.kwad.sdk.core.response.helper.e.fl(adTemplate);
        if (!(com.kwad.sdk.core.response.helper.e.eI(adTemplate) == 2) || c1201a == null || c1201a.eg() != 115 || jFl == 0) {
            adTemplate.liveInfo.shopItemId = "";
        } else {
            adTemplate.liveInfo.shopItemId = String.valueOf(jFl);
        }
        LiveDetailActivity.launch(context, adTemplate.createAdResultData());
    }

    public static void c(Application application) {
        if (Ts.get()) {
            return;
        }
        com.kwad.components.core.emotion.a.a(application);
        Ts.set(true);
    }

    public static boolean ru() {
        boolean z = false;
        try {
            if (ab.a("java.lang.String", "join", new Class[]{CharSequence.class, Iterable.class}) != null) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        c.d("FullLiveModule", "checkEnv envEnable" + z);
        return z;
    }
}
