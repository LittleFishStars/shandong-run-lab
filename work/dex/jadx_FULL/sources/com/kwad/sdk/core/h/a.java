package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static C1285a aYU;
    private static boolean aYV;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean aYW = true;

    /* JADX INFO: renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    @KsJson
    public static class C1285a extends com.kwad.sdk.core.response.a.a {
        public List<String> aYX;
        public int aYY;
        public List<String> aYZ;
        public List<String> aZa;
    }

    public static void Ov() {
        i.execute(new bi() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C1285a unused = a.aYU = new C1285a();
                    boolean unused2 = a.aYV = ((h) ServiceProvider.get(h.class)).Gf();
                    String strGg = ((h) ServiceProvider.get(h.class)).Gg();
                    if (a.aYV && !TextUtils.isEmpty(strGg)) {
                        a.aYU.parseJson(new JSONObject(strGg));
                        a.Ow();
                        return;
                    }
                    boolean unused3 = a.aYW = a.aYV;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ow() {
        aYW = true;
        if (aYU == null) {
            return;
        }
        eI(Ox());
        ai.l("ksadsdk_tk_switch", "tk_config", aYW);
    }

    private static int Ox() {
        int i = !aYU.aYZ.isEmpty() ? 1 : 0;
        C1285a c1285a = aYU;
        int i2 = c1285a.aYY != 0 ? 2 : 0;
        return ((i ^ i2) ^ (!c1285a.aYX.isEmpty() ? 4 : 0)) ^ (aYU.aZa.isEmpty() ? 0 : 8);
    }

    public static boolean Oy() {
        return mHasInit.get() ? aYW : ai.m("ksadsdk_tk_switch", "tk_config", true);
    }

    private static void eI(int i) {
        for (int i2 = 0; i2 < Integer.toBinaryString(i).length(); i2++) {
            if (((1 << i2) & i) != 0) {
                aYW = false;
                eJ(i2);
                if (aYW) {
                    return;
                }
            }
        }
    }

    private static void eJ(int i) {
        if (i == 0) {
            if (aYU.aYZ.contains(bt.WN())) {
                return;
            }
            aYW = true;
        } else if (i == 1) {
            if (aYU.aYY < bt.WX()) {
                aYW = true;
            }
        } else if (i == 2) {
            if (aYU.aYX.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aYW = true;
        } else if (i == 3 && !aYU.aZa.contains(bt.WM())) {
            aYW = true;
        }
    }
}
