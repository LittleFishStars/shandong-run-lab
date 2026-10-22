package cj.mobile.wm.appsdkdex.ads;

import android.content.Context;
import android.os.Bundle;
import cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;
import cj.mobile.wm.common.Iinterface.IRewordInterface;
import cj.mobile.wm.common.Ilistener.XAdRewardVideoListener;
import cj.mobile.wm.common.bean.RewordBean;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.dexa;
import cj.mobile.wm.dexc;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdRewardVideo implements IRewordInterface, IRewordParameter {
    public int adHeight;
    public XAdRewardVideoListener adListener;
    public int adWidth;
    public String adslotId;
    public boolean isMuted;
    public int orientation;
    public boolean parametersIsValid = false;
    public String rewardExtMap;
    public IRewordInterface rewordInterface;
    public String userId;

    public WMAdRewardVideo(WMAdSlot wMAdSlot, XAdRewardVideoListener xAdRewardVideoListener) {
        if (parametersIsValid(wMAdSlot, xAdRewardVideoListener)) {
            this.adslotId = wMAdSlot.getSlotId();
            this.isMuted = wMAdSlot.isMutedSet() ? wMAdSlot.isMuted() : false;
            this.orientation = wMAdSlot.getOrientation();
            this.adListener = xAdRewardVideoListener;
            this.adWidth = wMAdSlot.getAdWidth();
            this.adHeight = wMAdSlot.getAdHeight();
            this.userId = wMAdSlot.getUserId();
            this.rewardExtMap = wMAdSlot.getRewardExt();
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

    @Override // cj.mobile.wm.common.Iinterface.IRewordInterface
    public void destroy() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.destroy();
                this.rewordInterface = null;
            }
            this.adListener = null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNSfxbseBe!eftuspz!gbjm!") + th;
            DebugLog.common_weak(str);
            onError(900016, dexc.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdHeight() {
        DebugLog.common_all(dexc.dexa("XNSfxbseBe!beIfjhiu>") + this.adHeight);
        return this.adHeight;
    }

    @Override // cj.mobile.wm.common.Iinterface.IRewordInterface
    public Map getAdInfo() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.getAdInfo();
        }
        return null;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adslotId;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public int getAdWidth() {
        DebugLog.common_all(dexc.dexa("XNSfxbseBe!beXjeui>") + this.adWidth);
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
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNSfxbseBe!hfuDvssfouWDpef!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexc.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public int getECPM() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public RewordBean getExtraBean() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter
    public int getOrientation() {
        return this.orientation;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            String str = dexc.dexa("XNSfxbseBe!hfuSfrvftuJe!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexc.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
            return null;
        }
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter
    public String getRewardExtMap() {
        return this.rewardExtMap;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter
    public XAdRewardVideoListener getRewardListener() {
        return this.adListener;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseParameter
    public String getServerBidToken() {
        return null;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter
    public String getUserId() {
        return this.userId;
    }

    @Override // cj.mobile.wm.appsdkdex.Iparameter.IRewordParameter
    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public boolean isReady() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.isReady();
        }
        return false;
    }

    @Override // cj.mobile.wm.common.Iinterface.IRewordInterface
    public void load() {
        if (this.parametersIsValid) {
            dexa.dexa(WMDexAdHelper.gapc(), this.adslotId, new dexa.dexb() { // from class: cj.mobile.wm.appsdkdex.ads.WMAdRewardVideo.1
                @Override // cj.mobile.wm.dexa.dexb
                public void onFailed(String str) {
                    String str2 = dexc.dexa("XNSfxbseBe!cvjme!beMpbefs!gbjm!") + str;
                    DebugLog.common_e(str2);
                    if (WMAdRewardVideo.this.adListener != null) {
                        WMAdRewardVideo.this.adListener.onNoAd(str2);
                    }
                }

                @Override // cj.mobile.wm.dexa.dexb
                public void onLoaded(IAdLoader iAdLoader) {
                    if (iAdLoader == null) {
                        String strDexa = dexc.dexa("XNSfxbseBe!poMpbefe!gbjm-BeMpbefs!jt!ovmm");
                        DebugLog.common_e(strDexa);
                        WMAdRewardVideo.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, true);
                        return;
                    }
                    iAdLoader.fetchRewordVideoAd(WMAdRewardVideo.this);
                    if (WMAdRewardVideo.this.rewordInterface != null) {
                        WMAdRewardVideo.this.rewordInterface.load();
                        return;
                    }
                    String strDexa2 = dexc.dexa("XNSfxbseBe!poMpbefe!gbjm-sfxpseJoufsgbdf!jt!ovmm");
                    DebugLog.common_e(strDexa2);
                    WMAdRewardVideo.this.onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, true);
                }
            });
        }
    }

    public boolean parametersIsValid(WMAdSlot wMAdSlot, XAdRewardVideoListener xAdRewardVideoListener) {
        DebugLog.common_all(dexc.dexa("XNSfxbseBe!mpbe!tubsu"));
        if (wMAdSlot == null) {
            String strDexa = dexc.dexa("XNSfxbseBe!beTmpu!jt!ovmm");
            DebugLog.common_e(strDexa);
            onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa, false);
            this.parametersIsValid = false;
            return false;
        }
        if (xAdRewardVideoListener != null) {
            this.parametersIsValid = true;
            return true;
        }
        String strDexa2 = dexc.dexa("XNSfxbseBe!beMjtufofs!jt!ovmm");
        DebugLog.common_e(strDexa2);
        onError(200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2, false);
        this.parametersIsValid = false;
        return false;
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // cj.mobile.wm.common.Iinterface.IRewordInterface
    public void show(Context context) {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.show(context);
            } else {
                DebugLog.common_e(dexc.dexa("XNSfxbseBe!tipx!gbjm-sfxpseJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            String str = dexc.dexa("XNSfxbseBe!tipx!gbjm!") + th;
            DebugLog.common_e(str);
            onError(900016, dexc.dexa("邛摉���拲騇꣒��撋楅葇楲鵦"), str, false);
        }
    }

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    public void setImplement(IRewordInterface iRewordInterface) {
        this.rewordInterface = iRewordInterface;
    }
}
