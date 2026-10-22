package cj.mobile.wm.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.Iparameter.ISplashParameter;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;
import cj.mobile.wm.common.Iinterface.ISplashInterface;
import cj.mobile.wm.common.Ilistener.XAdSplashListener;
import cj.mobile.wm.common.bean.SplashBean;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.dexa;
import cj.mobile.wm.dexc;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdSplashad implements ISplashInterface, ISplashParameter {
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
    public boolean isMuted = true;
    public final int SPLASH_BOTTOM_LAYOUT_HEIGHT = 120;

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdSplashListener xAdSplashListener;
        if (z && (xAdSplashListener = this.adListener) != null) {
            xAdSplashListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adSlotId, i, str, str2);
    }

    public void buildAdLoader(final int i) {
        if (this.splashInterface != null) {
            doRequest(i);
        } else {
            dexa.dexa(getContext(), this.adSlotId, new dexa.dexb() { // from class: cj.mobile.wm.appsdkdex.ads.WMAdSplashad.1
                @Override // cj.mobile.wm.dexa.dexb
                public void onFailed(String str) {
                    String str2 = dexc.dexa("XNTqmbtiBe!cvjme!beMpbefs!gbjm-") + str;
                    DebugLog.common_e(str2);
                    if (WMAdSplashad.this.adListener != null) {
                        WMAdSplashad.this.adListener.onNoAd(str2);
                    }
                }

                @Override // cj.mobile.wm.dexa.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    if (iAdLoader == null) {
                        String strDexa = dexc.dexa("XNTqmbtiBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                        DebugLog.common_e(strDexa);
                        WMAdSplashad.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, true);
                        return;
                    }
                    iAdLoader.fetchSplashAd(WMAdSplashad.this);
                    if (WMAdSplashad.this.splashInterface != null) {
                        WMAdSplashad.this.doRequest(i);
                        return;
                    }
                    String strDexa2 = dexc.dexa("XNSfxbseBe!poMpbefe!gbjm-sfxpseJoufsgbdf!jt!ovmm");
                    DebugLog.common_e(strDexa2);
                    WMAdSplashad.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, true);
                }
            });
        }
    }

    public boolean buyerIdParametersIsValid(String str, IGetBuyerIdListener iGetBuyerIdListener) {
        if (TextUtils.isEmpty(str)) {
            String strDexa = dexc.dexa("XNTqmbtiBe!beTmpuJe!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            return false;
        }
        if (iGetBuyerIdListener != null) {
            return true;
        }
        String strDexa2 = dexc.dexa("XNTqmbtiBe!hfuCvzfsJeMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        return false;
    }

    @Override // cj.mobile.wm.common.Iinterface.ISplashInterface
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
            String str = dexc.dexa("XNTqmbtiBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900017, dexc.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
        }
    }

    public void doRequest(int i) {
        if (i == ConstantInfo.Config.REQUEST_SERVER_BID_BUYER_ID) {
            this.splashInterface.getBuyerIdWithAdSlotId(this.adSlotId, this.getBuyerIdListener);
        } else {
            this.splashInterface.load(this.adSlot, this.adListener);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdHeight() {
        if (this.adHeight > 0 && getExtraBean() != null) {
            this.adHeight -= Utils.dip2px(120);
        }
        if (this.getBuyerIdListener == null) {
            DebugLog.common_all(dexc.dexa("XNTqmbtiBe!beIfjhiu>") + this.adHeight);
        }
        return this.adHeight;
    }

    @Override // cj.mobile.wm.common.Iinterface.ISplashInterface
    public Map getAdInfo() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.getAdInfo();
        }
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdWidth() {
        if (this.getBuyerIdListener == null) {
            DebugLog.common_all(dexc.dexa("XNTqmbtiBe!beXjeui>") + this.adWidth);
        }
        return this.adWidth;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public IGetBuyerIdListener getBuyerIdListener() {
        return this.getBuyerIdListener;
    }

    @Override // cj.mobile.wm.common.Iinterface.ISplashInterface
    public void getBuyerIdWithAdSlotId(String str, IGetBuyerIdListener iGetBuyerIdListener) {
        if (buyerIdParametersIsValid(str, iGetBuyerIdListener)) {
            this.adSlotId = str;
            this.getBuyerIdListener = iGetBuyerIdListener;
            buildAdLoader(ConstantInfo.Config.REQUEST_SERVER_BID_BUYER_ID);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public Context getContext() {
        return WMDexAdHelper.gapc();
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.ISplashParameter
    public int getCountDownDuration() {
        if (ConstantInfo.Config.VALID_COUNTDOWN_RANGES.contains(Integer.valueOf(this.countDownDuration))) {
            DebugLog.init_weak(dexc.dexa("dvtupn!dpvouEpxo!") + this.countDownDuration);
        } else {
            this.countDownDuration = 5;
            DebugLog.init_weak(dexc.dexa("efgbvmu!dpvouEpxo!") + this.countDownDuration);
        }
        return this.countDownDuration;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNTqmbtiBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexc.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public int getECPM() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.getECPM();
        }
        return 0;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNTqmbtiBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexc.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return this.serverBidToken;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.ISplashParameter
    public XAdSplashListener getSplashListener() {
        return this.adListener;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.ISplashParameter
    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public boolean isReady() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.isReady();
        }
        return false;
    }

    @Override // cj.mobile.wm.common.Iinterface.ISplashInterface
    public void load(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener) {
        this.adListener = xAdSplashListener;
        this.getBuyerIdListener = null;
        if (parametersIsValid(wMAdSlot, xAdSplashListener)) {
            this.adSlot = wMAdSlot;
            this.adSlotId = wMAdSlot.getSlotId();
            this.serverBidToken = wMAdSlot.getServerBidToken();
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            this.isMuted = wMAdSlot.isMuted();
            this.countDownDuration = wMAdSlot.getCountDownDuration();
            if (wMAdSlot.getExt() != null) {
                this.mapSplashDrop = (SplashBean) wMAdSlot.getExt().get(dexc.dexa("fyu`tqmbti`cfbo"));
            }
            if (TextUtils.isEmpty(wMAdSlot.getServerBidToken())) {
                buildAdLoader(ConstantInfo.Config.REQUEST_STANDARD_LOAD);
            } else {
                buildAdLoader(ConstantInfo.Config.REQUEST_SERVER_BID_LOAD);
            }
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener) {
        DebugLog.common_all(dexc.dexa("XNTqmbtiBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            String strDexa = dexc.dexa("XNTqmbtiBe!beTmpu!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            return false;
        }
        if (xAdSplashListener != null) {
            return true;
        }
        String strDexa2 = dexc.dexa("XNTqmbtiBe!beMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        return false;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Iinterface.ISplashInterface
    public void show(ViewGroup viewGroup) {
        try {
            if (viewGroup != null) {
                ISplashInterface iSplashInterface = this.splashInterface;
                if (iSplashInterface != null) {
                    iSplashInterface.show(viewGroup);
                } else {
                    DebugLog.common_e(dexc.dexa("XNTqmbtiBe!tipx!gbjm-tqmbtiJoufsgbdf!jt!ovmm"));
                }
            } else {
                DebugLog.common_e(dexc.dexa("XNTqmbtiBe!tipx!gbjm-tqmbtiDpoubjofs!jt!ovmm"));
            }
        } catch (Throwable th) {
            String str = dexc.dexa("XNTqmbtiBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900017, dexc.dexa("邛摉潁沐��撋楅葇楲鵦"), str, false);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public SplashBean getExtraBean() {
        return this.mapSplashDrop;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void setImplement(ISplashInterface iSplashInterface) {
        this.splashInterface = iSplashInterface;
    }
}
