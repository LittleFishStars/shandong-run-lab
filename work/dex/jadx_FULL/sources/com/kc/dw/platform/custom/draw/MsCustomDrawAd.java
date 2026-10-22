package com.kc.dw.platform.custom.draw;

import android.view.ViewGroup;
import com.kc.dw.core.ad.draw.DrawAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomDrawAd extends DrawAd {
    private final MsCustomDrawAdapter drawAdapter;

    public MsCustomDrawAd(MsCustomDrawAdapter msCustomDrawAdapter, String str) {
        super(msCustomDrawAdapter, str);
        this.drawAdapter = msCustomDrawAdapter;
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomDrawAdapter msCustomDrawAdapter = this.drawAdapter;
        if (msCustomDrawAdapter != null) {
            return msCustomDrawAdapter.getExtraMap();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void render() {
        if (!isMSPlatform() || isAutoRender()) {
            return;
        }
        super.render();
        MsCustomDrawAdapter msCustomDrawAdapter = this.drawAdapter;
        if (msCustomDrawAdapter != null) {
            msCustomDrawAdapter.render();
        }
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        super.showAd(viewGroup);
        MsCustomDrawAdapter msCustomDrawAdapter = this.drawAdapter;
        if (msCustomDrawAdapter != null) {
            msCustomDrawAdapter.showAd(viewGroup);
        }
    }
}
