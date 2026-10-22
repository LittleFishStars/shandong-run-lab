package com.kc.bw.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import com.kc.bw.appsdkdex.Iparameter.InterstitialParameter;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.kc.bw.common.Iinterface.InterstitialInterface;
import com.kc.bw.common.Ilistener.XAdInterstitialListener;
import com.kc.bw.common.bean.InterstialBean;
import com.kc.bw.common.bean.WMAdSlot;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface
    public void close() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.close();
            }
        } catch (Throwable th) {
            String str = dexg.dexa("XNQpqvqBe!dmptf!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexg.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface
    public void destroy() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.destroy();
                this.mInterstitialInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNQpqvqBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900015, dexg.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexg.dexa("XNQpqvqBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface
    public Map getAdInfo() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.getAdInfo();
        }
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adSlotId;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexg.dexa("XNQpqvqBe!beXjeui>") + this.adWidth);
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
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNQpqvqBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexg.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public int getECPM() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public InterstialBean getExtraBean() {
        return null;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.InterstitialParameter
    public XAdInterstitialListener getInterstitialistener() {
        return this.adListener;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNQpqvqBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexg.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.InterstitialParameter
    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface, com.kc.bw.common.Ibase.IBaseInterface
    public boolean isReady() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.isReady();
        }
        return false;
    }

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface
    public void load() {
        if (this.parametersIsValid) {
            dexe.dexa(getContext(), this.adSlotId, new dexe.dexb(this) { // from class: com.kc.bw.appsdkdex.ads.WMAdInterstitial.1
                public final WMAdInterstitial this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.bw.dexe.dexb
                public void onFailed(String str) {
                    String str2 = dexg.dexa("XNQpqvqBe!cvjme!beMpbefs!gbjm!") + str;
                    DebugLog.common_e(str2);
                    if (this.this$0.adListener != null) {
                        this.this$0.adListener.onNoAd(str2);
                    }
                }

                @Override // com.kc.bw.dexe.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    String str;
                    if (iAdLoader != null) {
                        iAdLoader.fetchInterstialAd(this.this$0);
                        if (this.this$0.mInterstitialInterface != null) {
                            this.this$0.mInterstitialInterface.load();
                            return;
                        }
                        str = "XNQpqvqBe!poMpbefe!gbjm-JoufstujujbmJoufsgbdf!jt!ovmm";
                    } else {
                        str = "XNQpqvqBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm";
                    }
                    String strDexa = dexg.dexa(str);
                    DebugLog.common_e(strDexa);
                    this.this$0.onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, true);
                }
            });
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdInterstitialListener xAdInterstitialListener) {
        String str;
        DebugLog.common_all(dexg.dexa("XNQpqvqBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            str = "XNQpqvqBe!beTmpu!jt!ovmm";
        } else {
            if (xAdInterstitialListener != null) {
                this.parametersIsValid = true;
                return true;
            }
            str = "XNQpqvqBe!beMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        this.parametersIsValid = false;
        return false;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void setImplement(InterstitialInterface interstitialInterface) {
        this.mInterstitialInterface = interstitialInterface;
    }

    @Override // com.kc.bw.common.Iinterface.InterstitialInterface
    public void show(Context context) {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.show(context);
            } else {
                DebugLog.common_e(dexg.dexa("XNQpqvqBe!tipx!gbjm-nJoufstujujbmJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            String str = dexg.dexa("XNQpqvqBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900015, dexg.dexa("邛摉琓沐��撋楅葇楲鵦"), str, false);
        }
    }
}
