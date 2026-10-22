package com.kc.bw.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import com.kc.bw.appsdkdex.Iparameter.INativePotParameter;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.kc.bw.common.Iinterface.INativePotInterface;
import com.kc.bw.common.Ilistener.XAdNativePotListener;
import com.kc.bw.common.bean.NativeBean;
import com.kc.bw.common.bean.WMAdSlot;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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

    @Override // com.kc.bw.common.Iinterface.INativePotInterface
    public void destroy() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                iNativePotInterface.destroy();
                this.nativePotInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNObujwfBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900014, dexg.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexg.dexa("XNObujwfBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexg.dexa("XNObujwfBe!beXjeui>") + this.adWidth);
        return this.adWidth;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public IGetBuyerIdListener getBuyerIdListener() {
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public Context getContext() {
        return WMDexAdHelper.gapc();
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNObujwfBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900014, dexg.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public int getECPM() {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            return iNativePotInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public NativeBean getExtraBean() {
        return null;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.INativePotParameter
    public XAdNativePotListener getNativePotListener() {
        return this.adListener;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNObujwfBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900014, dexg.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public boolean isReady() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.isReady();
            }
        } catch (Throwable th) {
            String str = dexg.dexa("XNObujwfBe!jtSfbez!gbjm!") + th;
            DebugLog.common_w(str);
            onError(900014, dexg.dexa("邛摉���炰綂鈫繳研��撋楅葇楲鵦"), str, false);
        }
        return false;
    }

    public void loadAd() {
        dexe.dexa(getContext(), this.adSlotId, new dexe.dexb(this) { // from class: com.kc.bw.appsdkdex.ads.WMAdNativePot.1
            public final WMAdNativePot this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.dexe.dexb
            public void onFailed(String str) {
                String str2 = dexg.dexa("XNObujwfBe!cvjme!beMpbefs!gbjm!") + str;
                DebugLog.common_e(str2);
                if (this.this$0.adListener != null) {
                    this.this$0.adListener.onNoAd(str2);
                }
            }

            @Override // com.kc.bw.dexe.dexb
            public void onLoaded(IAdLoader iAdLoader) {
                if (iAdLoader != null) {
                    iAdLoader.fetchNativePotAd(this.this$0);
                    return;
                }
                String strDexa = dexg.dexa("XNObujwfBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                DebugLog.common_e(strDexa);
                this.this$0.onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, true);
            }
        });
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdNativePotListener xAdNativePotListener) {
        String str;
        DebugLog.common_all(dexg.dexa("XNObujwfBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            str = "XNObujwfBe!beTmpu!jt!ovmm";
        } else {
            if (xAdNativePotListener != null) {
                return true;
            }
            str = "XNObujwfBe!beMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        return false;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void setImplement(INativePotInterface iNativePotInterface) {
        this.nativePotInterface = iNativePotInterface;
    }
}
