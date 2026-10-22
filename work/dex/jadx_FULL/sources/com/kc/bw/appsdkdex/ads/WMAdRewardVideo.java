package com.kc.bw.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import com.kc.bw.appsdkdex.Iparameter.IRewordParameter;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.kc.bw.common.Iinterface.IRewordInterface;
import com.kc.bw.common.Ilistener.XAdRewardVideoListener;
import com.kc.bw.common.bean.RewordBean;
import com.kc.bw.common.bean.WMAdSlot;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMAdRewardVideo implements IRewordInterface, IRewordParameter {
    public int adHeight;
    public XAdRewardVideoListener adListener;
    public int adWidth;
    public String adslotId;
    public int orientation;
    public boolean parametersIsValid = false;
    public IRewordInterface rewordInterface;

    public WMAdRewardVideo(WMAdSlot wMAdSlot, XAdRewardVideoListener xAdRewardVideoListener) {
        if (parametersIsValid(wMAdSlot, xAdRewardVideoListener)) {
            this.adslotId = wMAdSlot.getSlotId();
            this.orientation = wMAdSlot.getOrientation();
            this.adListener = xAdRewardVideoListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str, String str2, boolean z) {
        XAdRewardVideoListener xAdRewardVideoListener;
        if (z && (xAdRewardVideoListener = this.adListener) != null) {
            xAdRewardVideoListener.onNoAd(str2);
        }
        ReportUtils.exReport(getContext(), this.adslotId, i, str, str2);
    }

    @Override // com.kc.bw.common.Iinterface.IRewordInterface
    public void destroy() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.destroy();
                this.rewordInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNSfxbseBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900016, dexg.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexg.dexa("XNSfxbseBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // com.kc.bw.common.Iinterface.IRewordInterface
    public Map getAdInfo() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.getAdInfo();
        }
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adslotId;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexg.dexa("XNSfxbseBe!beXjeui>") + this.adWidth);
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
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNSfxbseBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexg.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public int getECPM() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public RewordBean getExtraBean() {
        return null;
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.IRewordParameter
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexg.dexa("XNSfxbseBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexg.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // com.kc.bw.appsdkdex.Iparameter.IRewordParameter
    public XAdRewardVideoListener getRewardListener() {
        return this.adListener;
    }

    @Override // com.kc.bw.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public boolean isReady() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.isReady();
        }
        return false;
    }

    @Override // com.kc.bw.common.Iinterface.IRewordInterface
    public void load() {
        if (this.parametersIsValid) {
            dexe.dexa(WMDexAdHelper.gapc(), this.adslotId, new dexe.dexb(this) { // from class: com.kc.bw.appsdkdex.ads.WMAdRewardVideo.1
                public final WMAdRewardVideo this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.bw.dexe.dexb
                public void onFailed(String str) {
                    String str2 = dexg.dexa("XNSfxbseBe!cvjme!beMpbefs!gbjm!") + str;
                    DebugLog.common_e(str2);
                    if (this.this$0.adListener != null) {
                        this.this$0.adListener.onNoAd(str2);
                    }
                }

                @Override // com.kc.bw.dexe.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    String str;
                    if (iAdLoader != null) {
                        iAdLoader.fetchRewordVideoAd(this.this$0);
                        if (this.this$0.rewordInterface != null) {
                            this.this$0.rewordInterface.load();
                            return;
                        }
                        str = "XNSfxbseBe!poMpbefe!gbjm-sfxpseJoufsgbdf!jt!ovmm";
                    } else {
                        str = "XNSfxbseBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm";
                    }
                    String strDexa = dexg.dexa(str);
                    DebugLog.common_e(strDexa);
                    this.this$0.onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, true);
                }
            });
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdRewardVideoListener xAdRewardVideoListener) {
        String str;
        DebugLog.common_all(dexg.dexa("XNSfxbseBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            str = "XNSfxbseBe!beTmpu!jt!ovmm";
        } else {
            if (xAdRewardVideoListener != null) {
                this.parametersIsValid = true;
                return true;
            }
            str = "XNSfxbseBe!beMjtufofs!jt!ovmm";
        }
        String strDexa = dexg.dexa(str);
        DebugLog.common_e(strDexa);
        onError(200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa, false);
        this.parametersIsValid = false;
        return false;
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    public void setImplement(IRewordInterface iRewordInterface) {
        this.rewordInterface = iRewordInterface;
    }

    @Override // com.kc.bw.common.Iinterface.IRewordInterface
    public void show(Context context) {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.show(context);
            } else {
                DebugLog.common_e(dexg.dexa("XNSfxbseBe!tipx!gbjm-sfxpseJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            String str = dexg.dexa("XNSfxbseBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexg.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
        }
    }
}
