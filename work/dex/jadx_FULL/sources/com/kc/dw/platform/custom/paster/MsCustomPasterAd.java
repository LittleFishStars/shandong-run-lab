package com.kc.dw.platform.custom.paster;

import com.kc.dw.core.ad.paster.PasterAdImpl;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomPasterAd extends PasterAdImpl {
    private final MsCustomPasterAdapter pasterAdapter;

    public MsCustomPasterAd(MsCustomPasterAdapter msCustomPasterAdapter, String str) {
        super(msCustomPasterAdapter, str);
        this.pasterAdapter = msCustomPasterAdapter;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void destroy() {
        MsCustomPasterAdapter msCustomPasterAdapter = this.pasterAdapter;
        if (msCustomPasterAdapter != null) {
            msCustomPasterAdapter.destroy();
        }
        super.destroy();
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomPasterAdapter msCustomPasterAdapter = this.pasterAdapter;
        if (msCustomPasterAdapter != null) {
            return msCustomPasterAdapter.getExtraMap();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void render() {
        if (!isMSPlatform() || isAutoRender()) {
            return;
        }
        super.render();
        MsCustomPasterAdapter msCustomPasterAdapter = this.pasterAdapter;
        if (msCustomPasterAdapter != null) {
            msCustomPasterAdapter.render();
        }
    }
}
