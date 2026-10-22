package com.kc.bw.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.bw.appsdkdex.Iparameter.ISplashParameter;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.kc.bw.common.Iinterface.ISplashInterface;
import com.kc.bw.common.Ilistener.XAdSplashListener;
import com.kc.bw.common.bean.SplashBean;
import com.kc.bw.common.bean.WMAdSlot;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.common.utils.Utils;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMAdSplashad implements ISplashInterface, ISplashParameter {
    public final int SPLASH_BOTTOM_LAYOUT_HEIGHT = 120;
    public int adHeight;
    public XAdSplashListener adListener;
    public WMAdSlot adSlot;
    public String adSlotId;
    public int adWidth;
    public int countDownDuration;
    public IGetBuyerIdListener getBuyerIdListener;
    public SplashBean mapSplashDrop;
    public String serverBidToken;
    public ISplashInterface splashInterface;

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdSplashListener xAdSplashListener;
        if (z && (xAdSplashListener = this.adListener) != null) {
            xAdSplashListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adSlotId, i, str, str2);
    }

    public void buildAdLoader(int i) {
        if (this.splashInterface != null) {
            doRequest(i);
        } else {
            dexe.dexa(getContext(), this.adSlotId, new dexe.dexb(this, i) { // from class: com.kc.bw.appsdkdex.ads.WMAdSplashad.1
                public final WMAdSplashad this$0;
                public final int val$requestType;

                {
                    this.this$0 = this;
                    this.val$requestType = i;
                }

                @Override // com.kc.bw.dexe.dexb
                public void onFailed(String str) {
                    String str2 = dexg.dexa("XNTqmbtiBe!cvjme!beMpbefs!gbjm-") + str;
                    DebugLog.common_e(str2);
                    if (this.this$0.adListener != null) {
                        this.this$0.adListener.onNoAd(str2);
                    }
                }

                @Override // com.kc.bw.dexe.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    String str;
                    if (iAdLoader != null) {
                        iAdLoader.fetchSplashAd(this.this$0);
                        if (this.this$0.splashInterface != null) {
                            this.this$0.doRequest(this.val$requestType);
                            return;
                        }
                        str = "XNSfxbseBe!poMpbefe!gbjm-sfxpseJoufsgbdf!jt!ovmm";
                    } else {
                        str = "XNTqmbtiBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm";
                    }
                    String strDexa = dexg.dexa(str);
                    DebugLog.common_e(strDexa);
                    this.this$0.onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, true);
                }
            });
        }
    }

    public boolean buyerIdParametersIsValid(String str, IGetBuyerIdListener iGetBuyerIdListener) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "XNTqmbtiBe!beTmpuJe!jt!ovmm";
        } else {
            if (iGetBuyerIdListener != null) {
                return true;
            }
            str2 = "XNTqmbtiBe!hfuCvzfsJeMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str2);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        return false;
    }

    @Override // com.kc.bw.common.Iinterface.ISplashInterface
    public void destroy() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                iSplashInterface.destroy();
                this.splashInterface = null;
            }
            this.adListener = null;
            this.mapSplashDrop = null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNTqmbtiBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900017, dexg.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
        }
    }

    public void doRequest(int i) {
        if (i == ConstantInfo.Config.REQUEST_SERVER_BID_BUYER_ID) {
            this.splashInterface.getBuyerIdWithAdSlotId(this.adSlotId, this.getBuyerIdListener);
        } else {
            this.splashInterface.load(this.adSlot, this.adListener);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdHeight() {
        if (this.adHeight > 0 && getExtraBean() != null) {
            this.adHeight -= Utils.dip2px(120);
        }
        if (this.getBuyerIdListener == null) {
            DebugLog.common_all(dexg.dexa("XNTqmbtiBe!beIfjhiu>") + this.adHeight);
        }
        return this.adHeight;
    }

    @Override // com.kc.bw.common.Iinterface.ISplashInterface
    public Map getAdInfo() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.getAdInfo();
        }
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdWidth() {
        if (this.getBuyerIdListener == null) {
            DebugLog.common_all(dexg.dexa("XNTqmbtiBe!beXjeui>") + this.adWidth);
        }
        return this.adWidth;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public IGetBuyerIdListener getBuyerIdListener() {
        return this.getBuyerIdListener;
    }

    @Override // com.kc.bw.common.Iinterface.ISplashInterface
    public void getBuyerIdWithAdSlotId(String str, IGetBuyerIdListener iGetBuyerIdListener) {
        if (buyerIdParametersIsValid(str, iGetBuyerIdListener)) {
            this.adSlotId = str;
            this.getBuyerIdListener = iGetBuyerIdListener;
            buildAdLoader(ConstantInfo.Config.REQUEST_SERVER_BID_BUYER_ID);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public Context getContext() {
        return WMDexAdHelper.gapc();
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.ISplashParameter
    public int getCountDownDuration() {
        StringBuilder sb;
        String str;
        if (ConstantInfo.Config.VALID_COUNTDOWN_RANGES.contains(Integer.valueOf(this.countDownDuration))) {
            sb = new StringBuilder();
            str = "dvtupn!dpvouEpxo!";
        } else {
            this.countDownDuration = 5;
            sb = new StringBuilder();
            str = "efgbvmu!dpvouEpxo!";
        }
        sb.append(dexg.dexa(str));
        sb.append(this.countDownDuration);
        DebugLog.init_weak(sb.toString());
        return this.countDownDuration;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNTqmbtiBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexg.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public int getECPM() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public SplashBean getExtraBean() {
        return this.mapSplashDrop;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNTqmbtiBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexg.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return this.serverBidToken;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.ISplashParameter
    public XAdSplashListener getSplashListener() {
        return this.adListener;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public boolean isReady() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.isReady();
        }
        return false;
    }

    @Override // com.kc.bw.common.Iinterface.ISplashInterface
    public void load(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener) {
        this.adListener = xAdSplashListener;
        this.getBuyerIdListener = null;
        if (parametersIsValid(wMAdSlot, xAdSplashListener)) {
            this.adSlot = wMAdSlot;
            this.adSlotId = wMAdSlot.getSlotId();
            this.serverBidToken = wMAdSlot.getServerBidToken();
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            this.countDownDuration = wMAdSlot.getCountDownDuration();
            if (wMAdSlot.getExt() != null) {
                this.mapSplashDrop = (SplashBean) wMAdSlot.getExt().get(dexg.dexa("fyu`tqmbti`cfbo"));
            }
            buildAdLoader(!TextUtils.isEmpty(wMAdSlot.getServerBidToken()) ? ConstantInfo.Config.REQUEST_SERVER_BID_LOAD : ConstantInfo.Config.REQUEST_STANDARD_LOAD);
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener) {
        String str;
        DebugLog.common_all(dexg.dexa("XNTqmbtiBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            str = "XNTqmbtiBe!beTmpu!jt!ovmm";
        } else {
            if (xAdSplashListener != null) {
                return true;
            }
            str = "XNTqmbtiBe!beMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        return false;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void setImplement(ISplashInterface iSplashInterface) {
        this.splashInterface = iSplashInterface;
    }

    @Override // com.kc.bw.common.Iinterface.ISplashInterface
    public void show(ViewGroup viewGroup) {
        String strDexa;
        try {
            if (viewGroup != null) {
                ISplashInterface iSplashInterface = this.splashInterface;
                if (iSplashInterface != null) {
                    iSplashInterface.show(viewGroup);
                    return;
                }
                strDexa = dexg.dexa("XNTqmbtiBe!tipx!gbjm-tqmbtiJoufsgbdf!jt!ovmm");
            } else {
                strDexa = dexg.dexa("XNTqmbtiBe!tipx!gbjm-tqmbtiDpoubjofs!jt!ovmm");
            }
            DebugLog.common_e(strDexa);
        } catch (Throwable th) {
            String str = dexg.dexa("XNTqmbtiBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexg.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
        }
    }
}
