package cj.mobile.wm.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import cj.mobile.wm.appsdkdex.Iparameter.INativeExpressParameter;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;
import cj.mobile.wm.common.Iinterface.INativeExpressInterface;
import cj.mobile.wm.common.Ilistener.XAdNativeExpressListener;
import cj.mobile.wm.common.bean.NativeExpressBean;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.dexa;
import cj.mobile.wm.dexc;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdNativeExpress implements INativeExpressInterface, INativeExpressParameter {
    public int adHeight;
    public XAdNativeExpressListener adListener;
    public String adSlotId;
    public int adWidth;
    public boolean isMuted;
    public INativeExpressInterface nativeExpressInterface;

    public WMAdNativeExpress(WMAdSlot wMAdSlot, XAdNativeExpressListener xAdNativeExpressListener) {
        if (parametersIsValid(wMAdSlot, xAdNativeExpressListener)) {
            this.adSlotId = wMAdSlot.getSlotId();
            this.isMuted = wMAdSlot.isMuted();
            this.adListener = xAdNativeExpressListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            loadAd();
        }
    }

    private void loadAd() {
        dexa.dexa(getContext(), this.adSlotId, new dexa.dexb() { // from class: cj.mobile.wm.appsdkdex.ads.WMAdNativeExpress.1
            @Override // cj.mobile.wm.dexa.dexb
            public void onFailed(String str) {
                String str2 = dexc.dexa("XNFyqsfttBe!cvjme!beMpbefs!gbjm-") + str;
                DebugLog.common_e(str2);
                if (WMAdNativeExpress.this.adListener != null) {
                    WMAdNativeExpress.this.adListener.onNoAd(str2);
                }
            }

            @Override // cj.mobile.wm.dexa.dexb
            public void onLoaded(IAdLoader iAdLoader) {
                if (iAdLoader != null) {
                    iAdLoader.fetchNativeExpressAd(WMAdNativeExpress.this);
                    return;
                }
                String strDexa = dexc.dexa("XNFyqsfttBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                DebugLog.common_e(strDexa);
                WMAdNativeExpress.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdNativeExpressListener xAdNativeExpressListener;
        if (z && (xAdNativeExpressListener = this.adListener) != null) {
            xAdNativeExpressListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adSlotId, i, str, str2);
    }

    @Override // cj.mobile.wm.common.Iinterface.INativeExpressInterface
    public void destroy() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                iNativeExpressInterface.destroy();
                this.nativeExpressInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNFyqsfttBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900013, dexc.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexc.dexa("XNFyqsfttBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // cj.mobile.wm.common.Iinterface.INativeExpressInterface
    public Map getAdInfo() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.getAdInfo();
        }
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexc.dexa("XNFyqsfttBe!beXjeui>") + this.adWidth);
        return this.adWidth;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public IGetBuyerIdListener getBuyerIdListener() {
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public Context getContext() {
        return WMDexAdHelper.gapc();
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNFyqsfttBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900013, dexc.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public int getECPM() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public NativeExpressBean getExtraBean() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.INativeExpressParameter
    public XAdNativeExpressListener getNativeExpressListener() {
        return this.adListener;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNFyqsfttBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900013, dexc.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.INativeExpressParameter
    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public boolean isReady() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.isReady();
        }
        return false;
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdNativeExpressListener xAdNativeExpressListener) {
        DebugLog.common_all(dexc.dexa("XNFyqsfttBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            String strDexa = dexc.dexa("XNFyqsfttBe!beTmpu!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            return false;
        }
        if (xAdNativeExpressListener != null) {
            return true;
        }
        String strDexa2 = dexc.dexa("XNFyqsfttBe!beMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        return false;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void setImplement(INativeExpressInterface iNativeExpressInterface) {
        this.nativeExpressInterface = iNativeExpressInterface;
    }
}
