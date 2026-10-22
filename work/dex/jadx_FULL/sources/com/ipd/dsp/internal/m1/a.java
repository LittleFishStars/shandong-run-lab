package com.ipd.dsp.internal.m1;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZiCustomController;
import com.beizi.fusion.BeiZis;
import com.ipd.dsp.DspCustomController;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.k;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38408a = "init";

    /* JADX INFO: renamed from: com.ipd.dsp.internal.m1.a$a, reason: collision with other inner class name */
    public class C0900a extends BeiZiCustomController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DspCustomController f38409a;

        public C0900a(DspCustomController dspCustomController) {
            this.f38409a = dspCustomController;
        }

        @Override // com.beizi.fusion.BeiZiCustomController
        public boolean isCanUseGaid() {
            return this.f38409a.canUseAndroidId();
        }

        @Override // com.beizi.fusion.BeiZiCustomController
        public boolean isCanUseLocation() {
            return this.f38409a.canReadLocation();
        }

        @Override // com.beizi.fusion.BeiZiCustomController
        public boolean isCanUseOaid() {
            return this.f38409a.canUseAndroidId();
        }

        @Override // com.beizi.fusion.BeiZiCustomController
        public boolean isCanUsePhoneState() {
            return this.f38409a.canUsePhoneState();
        }

        @Override // com.beizi.fusion.BeiZiCustomController
        public boolean isCanUseWifiState() {
            return this.f38409a.canUseMacAddress();
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            k.b("init", "BeiZis.appId is empty");
            return;
        }
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        try {
            DspCustomController dspCustomControllerI = g.a().i();
            if (dspCustomControllerI != null) {
                BeiZis.init(context, str, new C0900a(dspCustomControllerI));
            } else {
                BeiZis.init(context, str);
            }
        } catch (Throwable th) {
            k.b("init", "init BeiZis error", th);
        }
    }
}
