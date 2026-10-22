package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.byazt.bog.a;
import com.byazt.op.tt;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 1469, 2422})
public class MediationCustomNativeAd extends com.byazt.op.c implements IMediationCustomNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29309a;
    private double c;
    private String da;
    private Function gt;
    private String i;
    private boolean m;
    private MediationNativeAdAppInfo my;
    private String n;
    private int nu;
    private int rh;
    private MediationCustomNativeDislikeDialog rl;
    private int sl;
    private int sp;
    private int t;
    private Map<String, Object> tt;
    private double u;
    private String uj;
    private String ve;
    private int x;
    private List<String> yp;
    private String z;

    private Integer c() {
        MediationConstant.AdIsReadyStatus adIsReadyStatusIsReadyCondition = isReadyCondition();
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        return adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY ? 4 : 1;
    }

    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.gt = tt.covertToFunction(valueSet.objectValue(8034, Object.class));
        } else if (i == 6083) {
            render();
        } else {
            if (i == 6081) {
                return (T) getExpressView();
            }
            if (i == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder(tt.covertToFunction(valueSet.objectValue(8071, Object.class))));
            } else {
                if (i == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8121) {
                        return (T) c();
                    }
                    if (i == 8194) {
                        String strStringValue = valueSet.stringValue(8036, null);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.rl;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(strStringValue, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.rl;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new com.byazt.vh.tt(dislikeDialog);
                        }
                    } else {
                        if (i == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            a.ve(MediationConstant.TAG, "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        } else if (i == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8130);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8113);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8184);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i, String str) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8132);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8038, Integer.valueOf(i));
            sparseArray.put(8039, str);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8185);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8187);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8157);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8155);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8158);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8152);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8156);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i, String str) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8134);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f, float f2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8133);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f));
            sparseArray.put(8041, Float.valueOf(f2));
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8118);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i, String str) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8117);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8146);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8154);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8072, Long.valueOf(j));
            sparseArray.put(8073, Long.valueOf(j2));
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8150);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8145);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        return getValues();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8226);
            sparseArray.put(-99999985, Integer.class);
            Integer num = (Integer) this.gt.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    public SparseArray<Object> getValues() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8016, Double.valueOf(this.c));
        sparseArray.put(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.tt);
        sparseArray.put(8045, this.ve);
        sparseArray.put(8046, this.uj);
        sparseArray.put(8048, this.n);
        sparseArray.put(8050, this.f29309a);
        sparseArray.put(8051, Integer.valueOf(this.x));
        sparseArray.put(8052, Integer.valueOf(this.sp));
        sparseArray.put(8061, this.i);
        sparseArray.put(8054, this.da);
        sparseArray.put(8420, Integer.valueOf(this.sl));
        sparseArray.put(8421, Integer.valueOf(this.t));
        sparseArray.put(8082, Double.valueOf(this.u));
        sparseArray.put(8053, this.yp);
        sparseArray.put(8049, this.z);
        sparseArray.put(8033, Boolean.valueOf(this.m));
        sparseArray.put(8060, Integer.valueOf(this.nu));
        sparseArray.put(8059, Integer.valueOf(this.rh));
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.my;
        if (mediationNativeAdAppInfo != null) {
            sparseArray.put(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return sparseArray;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    public View getVideoView() {
        return null;
    }

    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8110);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.gt.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8136);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.gt.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8160);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.gt.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(@Nullable Activity activity, @Nullable ViewGroup viewGroup, @Nullable List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, @Nullable MediationViewBinder mediationViewBinder) {
    }

    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.i = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i) {
        this.nu = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d) {
        this.c = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.uj = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        if (this.gt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 6085);
            sparseArray.put(-99999985, Void.class);
            this.gt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.m = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.n = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i) {
        this.x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.yp = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.f29309a = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i) {
        this.sp = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i) {
        this.rh = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.tt = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.my = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.da = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.z = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d) {
        this.u = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.ve = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i) {
        this.t = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i) {
        this.sl = i;
    }
}
