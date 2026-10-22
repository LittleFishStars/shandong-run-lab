package com.alibaba.alibcapplink;

import android.content.Context;
import com.alibaba.alibclinkpartner.linkpartner.ALPTBLinkPartnerSDK;
import com.alibaba.alibclinkpartner.linkpartner.b;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcSDKInitResult;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcApplink implements IAlibcApplinkProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23551a = "AlibcApplink";
    private boolean b;

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy
    public synchronized AlibcSDKInitResult init() {
        if (this.b) {
            return new AlibcSDKInitResult(2);
        }
        ALPTBLinkPartnerSDK.setDebugStatus(AlibcBaseTradeCommon.isDebug(), AlibcBaseTradeCommon.isDebug());
        ALPTBLinkPartnerSDK.setTTID(AlibcBaseTradeCommon.ttid);
        int iInit = b.init(AlibcBaseTradeCommon.context, AlibcBaseTradeCommon.getAppKey());
        if (2 == iInit / 100) {
            ALPTBLinkPartnerSDK.setSupportJumpFailedOpenTaobao(true);
            this.b = true;
            return new AlibcSDKInitResult(0);
        }
        if (301 == iInit) {
            return new AlibcSDKInitResult(iInit, "application is null");
        }
        return new AlibcSDKInitResult(1);
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy
    public void openUrl(Context context, String str, Map<String, Object> map, final AppLinkOpenCallback appLinkOpenCallback) {
        if (!AlibcSdkManager.getInstance().supportComponent("applink_sdk")) {
            appLinkOpenCallback.supportFail("5200", AlibcProtocolConstant.APPLINK_NOT_SUPPORT_MSG);
        } else {
            map.put("bcLinkCode", Integer.valueOf(TRiverConstant.BC_LINK_CODE));
            ALSLSmartLinkSDK.openUrl(context, a.a(context, str, map), new ALPSmartLinkCallback() { // from class: com.alibaba.alibcapplink.AlibcApplink.1
                @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                public final void getLinkUrl(boolean z, String str2, String str3, int i) {
                    appLinkOpenCallback.getLinkUrl(z, str2, str3, i);
                }
            });
        }
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy
    public void turnOffDebug() {
        ALPTBLinkPartnerSDK.setDebugStatus(false, false);
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy
    public void turnOnDebug() {
        ALPTBLinkPartnerSDK.setDebugStatus(true, true);
    }
}
