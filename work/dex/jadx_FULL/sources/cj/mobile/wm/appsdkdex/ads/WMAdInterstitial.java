package cj.mobile.wm.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import cj.mobile.wm.appsdkdex.Iparameter.InterstitialParameter;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;
import cj.mobile.wm.common.Iinterface.InterstitialInterface;
import cj.mobile.wm.common.Ilistener.XAdInterstitialListener;
import cj.mobile.wm.common.bean.InterstialBean;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.dexa;
import cj.mobile.wm.dexc;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdInterstitial implements InterstitialInterface, InterstitialParameter {
    public int adHeight;
    public XAdInterstitialListener adListener;
    public String adSlotId;
    public int adWidth;
    public boolean isMuted;
    public InterstitialInterface mInterstitialInterface;
    public boolean parametersIsValid = false;

    public WMAdInterstitial(WMAdSlot wMAdSlot, XAdInterstitialListener xAdInterstitialListener) {
        if (parametersIsValid(wMAdSlot, xAdInterstitialListener)) {
            this.adSlotId = wMAdSlot.getSlotId();
            this.isMuted = wMAdSlot.isMuted();
            this.adListener = xAdInterstitialListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdInterstitialListener xAdInterstitialListener;
        if (z && (xAdInterstitialListener = this.adListener) != null) {
            xAdInterstitialListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adSlotId, i, str, str2);
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface
    public void close() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.close();
            }
        } catch (Throwable th) {
            String str = dexc.dexa("XNQpqvqBe!dmptf!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexc.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface
    public void destroy() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.destroy();
                this.mInterstitialInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNQpqvqBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900015, dexc.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexc.dexa("XNQpqvqBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface
    public Map getAdInfo() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.getAdInfo();
        }
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexc.dexa("XNQpqvqBe!beXjeui>") + this.adWidth);
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
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNQpqvqBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexc.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public int getECPM() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public InterstialBean getExtraBean() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.InterstitialParameter
    public XAdInterstitialListener getInterstitialistener() {
        return this.adListener;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNQpqvqBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexc.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.InterstitialParameter
    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface, cj.mobile.wm.common.Ibase.IBaseInterface
    public boolean isReady() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.isReady();
        }
        return false;
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface
    public void load() {
        if (this.parametersIsValid) {
            dexa.dexa(getContext(), this.adSlotId, new dexa.dexb() { // from class: cj.mobile.wm.appsdkdex.ads.WMAdInterstitial.1
                @Override // cj.mobile.wm.dexa.dexb
                public void onFailed(String str) {
                    String str2 = dexc.dexa("XNQpqvqBe!cvjme!beMpbefs!gbjm!") + str;
                    DebugLog.common_e(str2);
                    if (WMAdInterstitial.this.adListener != null) {
                        WMAdInterstitial.this.adListener.onNoAd(str2);
                    }
                }

                @Override // cj.mobile.wm.dexa.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    if (iAdLoader == null) {
                        String strDexa = dexc.dexa("XNQpqvqBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                        DebugLog.common_e(strDexa);
                        WMAdInterstitial.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, true);
                        return;
                    }
                    iAdLoader.fetchInterstialAd(WMAdInterstitial.this);
                    if (WMAdInterstitial.this.mInterstitialInterface != null) {
                        WMAdInterstitial.this.mInterstitialInterface.load();
                        return;
                    }
                    String strDexa2 = dexc.dexa("XNQpqvqBe!poMpbefe!gbjm-JoufstujujbmJoufsgbdf!jt!ovmm");
                    DebugLog.common_e(strDexa2);
                    WMAdInterstitial.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, true);
                }
            });
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdInterstitialListener xAdInterstitialListener) {
        DebugLog.common_all(dexc.dexa("XNQpqvqBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            String strDexa = dexc.dexa("XNQpqvqBe!beTmpu!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            this.parametersIsValid = false;
            return false;
        }
        if (xAdInterstitialListener != null) {
            this.parametersIsValid = true;
            return true;
        }
        String strDexa2 = dexc.dexa("XNQpqvqBe!beMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        this.parametersIsValid = false;
        return false;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Iinterface.InterstitialInterface
    public void show(Context context) {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.show(context);
            } else {
                DebugLog.common_e(dexc.dexa("XNQpqvqBe!tipx!gbjm-nJoufstujujbmJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            String str = dexc.dexa("XNQpqvqBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexc.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void setImplement(InterstitialInterface interstitialInterface) {
        this.mInterstitialInterface = interstitialInterface;
    }
}
