package com.byazt.fqu;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1010, 13})
public class tt {

    @com.byazt.zqa.c(c = {0, 1, 1010, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public Function<SparseArray<Object>, Object> c;

        public c(Function<SparseArray<Object>, Object> function) {
            this.c = function;
        }

        public IMediationAdSlot c() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260031);
            Object objApply = this.c.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }

    public static final SparseArray<Object> c(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        veVarC.c(260001, adSlot.getAdId());
        veVarC.c(260002, adSlot.getCreativeId());
        veVarC.c(260003, adSlot.getExt());
        veVarC.c(260004, adSlot.getCodeId());
        veVarC.c(260005, adSlot.isAutoPlay());
        veVarC.c(260006, adSlot.getImgAcceptedWidth());
        veVarC.c(260007, adSlot.getImgAcceptedHeight());
        veVarC.c(260008, adSlot.getExpressViewAcceptedWidth());
        veVarC.c(260009, adSlot.getExpressViewAcceptedHeight());
        veVarC.c(260010, adSlot.isSupportDeepLink());
        veVarC.c(260011, adSlot.isSupportRenderConrol());
        veVarC.c(2600012, adSlot.getAdCount());
        veVarC.c(260013, adSlot.getMediaExtra());
        veVarC.c(260014, adSlot.getUserID());
        veVarC.c(260015, adSlot.getOrientation());
        veVarC.c(260016, adSlot.getNativeAdType());
        veVarC.c(260017, adSlot.getExternalABVid());
        veVarC.c(260018, adSlot.getAdloadSeq());
        veVarC.c(260019, adSlot.getPrimeRit());
        veVarC.c(260020, adSlot.getAdType());
        veVarC.c(260021, adSlot.getBidAdm());
        veVarC.c(260022, adSlot.getUserData());
        veVarC.c(260023, c(adSlot.getAdLoadType()));
        veVarC.c(260024, new Supplier<String>() { // from class: com.byazt.fqu.tt.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        veVarC.c(260025, new Supplier<Integer>() { // from class: com.byazt.fqu.tt.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        veVarC.c(260026, new Supplier<Boolean>() { // from class: com.byazt.fqu.tt.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            veVarC.c(8260028, new com.byazt.fr.c(adSlot.getMediationAdSlot()));
        }
        return veVarC.tt().sparseArray();
    }

    public static AdSlot c(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        if (valueSetTt != null) {
            builder.setAdId(valueSetTt.stringValue(260001)).setCodeId(valueSetTt.stringValue(260002)).setExt(valueSetTt.stringValue(260003)).setCodeId(valueSetTt.stringValue(260004)).setIsAutoPlay(valueSetTt.booleanValue(260005)).setImageAcceptedSize(valueSetTt.intValue(260006), valueSetTt.intValue(260007)).setExpressViewAcceptedSize(valueSetTt.floatValue(260008), valueSetTt.floatValue(260009)).setSupportDeepLink(valueSetTt.booleanValue(260010)).setAdCount(valueSetTt.intValue(2600012)).setMediaExtra(valueSetTt.stringValue(260013)).setUserID(valueSetTt.stringValue(260014)).setExternalABVid((int[]) valueSetTt.objectValue(260017, int[].class)).setAdloadSeq(valueSetTt.intValue(260018)).setPrimeRit(valueSetTt.stringValue(260019)).setAdType(valueSetTt.intValue(260020)).withBid(valueSetTt.stringValue(260021)).setUserData(valueSetTt.stringValue(260022)).setAdLoadType(c(valueSetTt.intValue(260023))).setMediationAdSlot(new c(z.c(valueSetTt.objectValue(8260028, Object.class))).c()).setOrientation(valueSetTt.intValue(260015)).setRewardName((String) valueSetTt.objectValue(260024, String.class)).setRewardAmount(valueSetTt.intValue(260025));
            if (valueSetTt.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer c(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType c(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }
}
