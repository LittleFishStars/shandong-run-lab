package cj.mobile.wm.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import cj.mobile.wm.appsdkdex.Iparameter.INativePotParameter;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;
import cj.mobile.wm.common.Iinterface.INativePotInterface;
import cj.mobile.wm.common.Ilistener.XAdNativePotListener;
import cj.mobile.wm.common.bean.NativeBean;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.dexa;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdNativePot implements INativePotInterface, INativePotParameter {
    public int adHeight;
    public XAdNativePotListener adListener;
    public String adSlotId;
    public int adWidth;
    public INativePotInterface nativePotInterface;

    public WMAdNativePot(WMAdSlot wMAdSlot, XAdNativePotListener xAdNativePotListener) {
        if (parametersIsValid(wMAdSlot, xAdNativePotListener)) {
            this.adSlotId = wMAdSlot.getSlotId();
            this.adListener = xAdNativePotListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            loadAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdNativePotListener xAdNativePotListener;
        if (z && (xAdNativePotListener = this.adListener) != null) {
            xAdNativePotListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adSlotId, i, str, str2);
    }

    @Override // cj.mobile.wm.common.Iinterface.INativePotInterface
    public void destroy() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                iNativePotInterface.destroy();
                this.nativePotInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNObujwfBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900014, dexc.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexc.dexa("XNObujwfBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexc.dexa("XNObujwfBe!beXjeui>") + this.adWidth);
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
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNObujwfBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900014, dexc.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public int getECPM() {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            return iNativePotInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public NativeBean getExtraBean() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.INativePotParameter
    public XAdNativePotListener getNativePotListener() {
        return this.adListener;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNObujwfBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900014, dexc.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public boolean isReady() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.isReady();
            }
        } catch (Throwable th) {
            String str = dexc.dexa("XNObujwfBe!jtSfbez!gbjm!") + th;
            DebugLog.common_w(str);
            onError(900014, dexc.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
        }
        return false;
    }

    public void loadAd() {
        dexa.dexa(getContext(), this.adSlotId, new dexa.dexb() { // from class: cj.mobile.wm.appsdkdex.ads.WMAdNativePot.1
            @Override // cj.mobile.wm.dexa.dexb
            public void onFailed(String str) {
                String str2 = dexc.dexa("XNObujwfBe!cvjme!beMpbefs!gbjm!") + str;
                DebugLog.common_e(str2);
                if (WMAdNativePot.this.adListener != null) {
                    WMAdNativePot.this.adListener.onNoAd(str2);
                }
            }

            @Override // cj.mobile.wm.dexa.dexb
            public void onLoaded(IAdLoader iAdLoader) {
                if (iAdLoader != null) {
                    iAdLoader.fetchNativePotAd(WMAdNativePot.this);
                    return;
                }
                String strDexa = dexc.dexa("XNObujwfBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                DebugLog.common_e(strDexa);
                WMAdNativePot.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, true);
            }
        });
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdNativePotListener xAdNativePotListener) {
        DebugLog.common_all(dexc.dexa("XNObujwfBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            String strDexa = dexc.dexa("XNObujwfBe!beTmpu!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            return false;
        }
        if (xAdNativePotListener != null) {
            return true;
        }
        String strDexa2 = dexc.dexa("XNObujwfBe!beMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        return false;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void setImplement(INativePotInterface iNativePotInterface) {
        this.nativePotInterface = iNativePotInterface;
    }
}
