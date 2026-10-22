package com.kc.dw.gather.huawei;

import com.huawei.hms.ads.HwAds;
import com.huawei.openalliance.ad.inter.HiAd;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWInitManager extends CustomInitLoader {
    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "HW";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getHWVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        HwAds.init(a.getContext());
        HiAd.getInstance(a.getContext()).enableUserInfo(true);
        HiAd.getInstance(a.getContext()).initLog(true, 4);
        callInitSucc();
    }
}
