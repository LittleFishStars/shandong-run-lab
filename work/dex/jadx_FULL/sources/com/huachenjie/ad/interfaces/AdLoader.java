package com.huachenjie.ad.interfaces;

import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import com.kc.openset.config.OSETSDK;
import com.kc.openset.config.controller.OSETCustomController;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AdLoader {

    public class a extends OSETCustomController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f32742a;

        public a(boolean z) {
            this.f32742a = z;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canReadInstalledPackages() {
            return false;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canReadLocation() {
            return false;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canUseMacAddress() {
            return false;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canUseNetworkState() {
            return false;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canUsePersonalizedAd() {
            return this.f32742a;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public boolean canUsePhoneState() {
            return false;
        }
    }

    public static void b(boolean z) {
        HashMap map = new HashMap();
        Boolean bool = Boolean.FALSE;
        map.put("hieib", bool);
        GlobalSetting.setConvOptimizeInfo(map);
        HashMap map2 = new HashMap();
        map2.put("wipaddr", bool);
        map2.put("mipaddr", bool);
        map2.put("cell_id", bool);
        GlobalSetting.setAgreeReadPrivacyInfo(map2);
        GlobalSetting.setEnableCollectAppInstallStatus(false);
        OSETSDK.getInstance().setCustomController(new a(z));
    }

    public abstract int a();

    public void addLifecycleObserver(Lifecycle lifecycle, DefaultLifecycleObserver defaultLifecycleObserver) {
        lifecycle.addObserver(defaultLifecycleObserver);
    }
}
