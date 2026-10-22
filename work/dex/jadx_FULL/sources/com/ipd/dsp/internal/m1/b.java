package com.ipd.dsp.internal.m1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ipd.dsp.DspCustomController;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.m1.b;
import com.octopus.ad.Octopus;
import com.octopus.ad.OctopusAdSdkController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38410a = "init";

    public class a extends OctopusAdSdkController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DspCustomController f38411a;

        public a(DspCustomController dspCustomController) {
            this.f38411a = dspCustomController;
        }

        public String getImei() {
            return this.f38411a.getImei();
        }

        public String getOaid() {
            return this.f38411a.getOaid();
        }

        public boolean isCanUsePhoneState() {
            return this.f38411a.canUsePhoneState();
        }
    }

    public static void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            k.b("init", "OctopusGroup.appId is empty");
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.ska
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(str);
                }
            });
        }
    }

    public static /* synthetic */ void b(String str) {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        try {
            DspCustomController dspCustomControllerI = g.a().i();
            if (dspCustomControllerI != null) {
                a aVar = new a(dspCustomControllerI);
                if (dspCustomControllerI.canUseOAID()) {
                    Octopus.init(context, str, aVar);
                } else {
                    Octopus.init(context, str, aVar, g.a().v());
                }
            } else {
                Octopus.init(context, str);
            }
            Octopus.setLimitPersonalAds(!com.ipd.dsp.internal.l1.a.a().getPersonalRecommend());
        } catch (Throwable th) {
            k.b("init", "init OctopusGroup error", th);
        }
    }
}
