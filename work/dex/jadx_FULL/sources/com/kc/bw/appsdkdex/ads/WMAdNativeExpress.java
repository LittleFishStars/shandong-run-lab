package com.kc.bw.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import com.kc.bw.appsdkdex.Iparameter.INativeExpressParameter;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.kc.bw.common.Iinterface.INativeExpressInterface;
import com.kc.bw.common.Ilistener.XAdNativeExpressListener;
import com.kc.bw.common.bean.NativeExpressBean;
import com.kc.bw.common.bean.WMAdSlot;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMAdNativeExpress implements INativeExpressInterface, INativeExpressParameter {
    public int adHeight;
    public XAdNativeExpressListener adListener;
    public String adSlotId;
    public int adWidth;
    public INativeExpressInterface nativeExpressInterface;

    public WMAdNativeExpress(WMAdSlot wMAdSlot, XAdNativeExpressListener xAdNativeExpressListener) {
        if (parametersIsValid(wMAdSlot, xAdNativeExpressListener)) {
            this.adSlotId = wMAdSlot.getSlotId();
            this.adListener = xAdNativeExpressListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            loadAd();
        }
    }

    private void loadAd() {
        dexe.dexa(getContext(), this.adSlotId, new dexe.dexb(this) { // from class: com.kc.bw.appsdkdex.ads.WMAdNativeExpress.1
            public final WMAdNativeExpress this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.dexe.dexb
            public void onFailed(String str) {
                String str2 = dexg.dexa("XNFyqsfttBe!cvjme!beMpbefs!gbjm-") + str;
                DebugLog.common_e(str2);
                if (this.this$0.adListener != null) {
                    this.this$0.adListener.onNoAd(str2);
                }
            }

            @Override // com.kc.bw.dexe.dexb
            public void onLoaded(IAdLoader iAdLoader) {
                if (iAdLoader != null) {
                    iAdLoader.fetchNativeExpressAd(this.this$0);
                    return;
                }
                String strDexa = dexg.dexa("XNFyqsfttBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                DebugLog.common_e(strDexa);
                this.this$0.onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, true);
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

    @Override // com.kc.bw.common.Iinterface.INativeExpressInterface
    public void destroy() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                iNativeExpressInterface.destroy();
                this.nativeExpressInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNFyqsfttBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900013, dexg.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexg.dexa("XNFyqsfttBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // com.kc.bw.common.Iinterface.INativeExpressInterface
    public Map getAdInfo() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.getAdInfo();
        }
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexg.dexa("XNFyqsfttBe!beXjeui>") + this.adWidth);
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
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNFyqsfttBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900013, dexg.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public int getECPM() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public NativeExpressBean getExtraBean() {
        return null;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.INativeExpressParameter
    public XAdNativeExpressListener getNativeExpressListener() {
        return this.adListener;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNFyqsfttBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900013, dexg.dexa("邛摉���炰綂穢����撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public boolean isReady() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.isReady();
        }
        return false;
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdNativeExpressListener xAdNativeExpressListener) {
        String str;
        DebugLog.common_all(dexg.dexa("XNFyqsfttBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            str = "XNFyqsfttBe!beTmpu!jt!ovmm";
        } else {
            if (xAdNativeExpressListener != null) {
                return true;
            }
            str = "XNFyqsfttBe!beMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        return false;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void setImplement(INativeExpressInterface iNativeExpressInterface) {
        this.nativeExpressInterface = iNativeExpressInterface;
    }
}
