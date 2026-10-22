package com.byazt.uj;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 15})
public class uj extends x {
    public uj(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(8127).c(Void.class).c(8034, this).tt());
            c();
        }
    }

    private void c() {
        PluginValueSet pluginValueSetTt = com.byazt.yxi.ve.tt(((ve) this).i);
        if (pluginValueSetTt != null) {
            Map<String, Object> map = (Map) pluginValueSetTt.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
            String strStringValue = pluginValueSetTt.stringValue(8045);
            String strStringValue2 = pluginValueSetTt.stringValue(8046);
            String strStringValue3 = pluginValueSetTt.stringValue(8048);
            String strStringValue4 = pluginValueSetTt.stringValue(8049);
            String strStringValue5 = pluginValueSetTt.stringValue(8050);
            int iIntValue = pluginValueSetTt.intValue(8051);
            int iIntValue2 = pluginValueSetTt.intValue(8052);
            List<String> list = (List) pluginValueSetTt.objectValue(8053, List.class);
            String strStringValue6 = pluginValueSetTt.stringValue(8054);
            double dDoubleValue = pluginValueSetTt.doubleValue(8016);
            boolean zBooleanValue = pluginValueSetTt.booleanValue(8033);
            int iIntValue3 = pluginValueSetTt.intValue(8060);
            String strStringValue7 = pluginValueSetTt.stringValue(8061);
            double dDoubleValue2 = pluginValueSetTt.doubleValue(8082);
            int iIntValue4 = pluginValueSetTt.intValue(8420);
            int iIntValue5 = pluginValueSetTt.intValue(8421);
            int iIntValue6 = pluginValueSetTt.intValue(8059);
            Function function = (Function) pluginValueSetTt.objectValue(8315, Function.class);
            if (dDoubleValue > AudioStats.AUDIO_AMPLITUDE_NONE) {
                setCpm(dDoubleValue);
            }
            setMediaExtraInfo(map);
            setTitle(strStringValue);
            setAdDescription(strStringValue2);
            setIconUrl(strStringValue3);
            setImageUrl(strStringValue5);
            setImageWidth(iIntValue2);
            setImageHeight(iIntValue);
            setActionText(strStringValue7);
            setPackageName(strStringValue6);
            setVideoWidth(iIntValue4);
            setVideoHeight(iIntValue5);
            setRating(dDoubleValue2);
            setImages(list);
            setSource(strStringValue4);
            setExpressAd(zBooleanValue);
            setImageMode(iIntValue3);
            setInteractionType(iIntValue6);
            if (function != null) {
                com.byazt.wc.c cVar = new com.byazt.wc.c(function);
                setAppName(cVar.ve());
                setAuthorName(cVar.uj());
                setPackageSizeBytes(cVar.n());
                setPermissionsUrl(cVar.a());
                setPrivacyAgreement(cVar.x());
                setVersionName(cVar.i());
                setPermissionsMap(cVar.sp());
                setFunctionDescUrl(cVar.tt());
                setRegUrl(cVar.c());
            }
        }
    }

    @Override // com.byazt.yl.ve, com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderFail code:" + iIntValue + " msg:" + strStringValue + " view" + view);
            callNativeRenderFail(view, strStringValue, iIntValue);
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderSuccess width:" + fFloatValue + " height:" + fFloatValue2);
            callNativeRenderSuccess(fFloatValue, fFloatValue2);
        } else if (i == 8130) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeAdClick");
            callNativeAdClick();
        } else if (i == 8113) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeAdShow");
            callNativeAdShow();
        } else if (i == 8145) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoStart");
            callNativeVideoStart();
        } else if (i == 8146) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoPause");
            callNativeVideoPause();
        } else if (i == 8150) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoResume");
            callNativeVideoResume();
        } else if (i == 8118) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoCompleted");
            callNativeVideoCompleted();
        } else if (i == 8117) {
            int iIntValue2 = pluginValueSet.intValue(8014);
            String strStringValue2 = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError code:" + iIntValue2 + " msg:" + strStringValue2);
            callNativeVideoError(new com.byazt.zm.c(iIntValue2, strStringValue2));
        } else if (i == 8154) {
            long jLongValue = pluginValueSet.longValue(8072);
            long jLongValue2 = pluginValueSet.longValue(8073);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError current:" + jLongValue + " duration:" + jLongValue2);
            callNativeVideoProgressUpdate(jLongValue, jLongValue2);
        } else if (i == 8152) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnIdle");
            callNativeOnIdle();
        } else if (i == 8187) {
            long jLongValue3 = pluginValueSet.longValue(8062);
            long jLongValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadActive totalBytes:" + jLongValue3 + " curlBytes:" + jLongValue4);
            callNativeOnDownloadActive(jLongValue3, jLongValue4, "", "");
        } else if (i == 8158) {
            long jLongValue5 = pluginValueSet.longValue(8062);
            long jLongValue6 = pluginValueSet.longValue(8063);
            String strStringValue3 = pluginValueSet.stringValue(8066);
            String strStringValue4 = pluginValueSet.stringValue(8056);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadPaused totalBytes:" + jLongValue5 + " curlBytes:" + jLongValue6 + " fileName:" + strStringValue3 + " appName:" + strStringValue4);
            callNativeOnDownloadPaused(jLongValue5, jLongValue6, strStringValue3, strStringValue4);
        } else if (i == 8157) {
            long jLongValue7 = pluginValueSet.longValue(8062);
            long jLongValue8 = pluginValueSet.longValue(8063);
            String strStringValue5 = pluginValueSet.stringValue(8066);
            String strStringValue6 = pluginValueSet.stringValue(8056);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFailed totalBytes:" + jLongValue7 + " curlBytes:" + jLongValue8 + " fileName:" + strStringValue5 + " appName:" + strStringValue6);
            callNativeOnDownloadFailed(jLongValue7, jLongValue8, strStringValue5, strStringValue6);
        } else if (i == 8155) {
            long jLongValue9 = pluginValueSet.longValue(8062);
            String strStringValue7 = pluginValueSet.stringValue(8066);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished totalBytes:" + jLongValue9 + " fileName:" + strStringValue7 + " appName:" + strStringValue8);
            callNativeOnDownloadFinished(jLongValue9, strStringValue7, strStringValue8);
        } else if (i == 8156) {
            String strStringValue9 = pluginValueSet.stringValue(8066);
            String strStringValue10 = pluginValueSet.stringValue(8056);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished  fileName:" + strStringValue9 + " appName:" + strStringValue10);
            callNativeOnInstalled(strStringValue9, strStringValue10);
        } else if (i == 8185) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeShow");
            callNativeDislikeShow();
        } else if (i == 8184) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeCancel");
            callNativeDislikeCancel();
        } else if (i != 6085) {
            if (i == 8110) {
                boolean zIsClientBiddingAd = isClientBiddingAd();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : isClientBiddingAd :".concat(String.valueOf(zIsClientBiddingAd)));
                return (T) Boolean.valueOf(zIsClientBiddingAd);
            }
            if (i == 8136) {
                boolean zIsServerBiddingAd = isServerBiddingAd();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : isServerBiddingAd :".concat(String.valueOf(zIsServerBiddingAd)));
                return (T) Boolean.valueOf(zIsServerBiddingAd);
            }
            if (i == 8160) {
                boolean zIsUseCustomVideo = isUseCustomVideo();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : isUseCustomVideo :".concat(String.valueOf(zIsUseCustomVideo)));
                return (T) Boolean.valueOf(zIsUseCustomVideo);
            }
            if (i == 8226) {
                int adNetworkSlotType = getAdNetworkSlotType();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : getBiddingType :".concat(String.valueOf(adNetworkSlotType)));
                return (T) Integer.valueOf(adNetworkSlotType);
            }
            if (i == 8132) {
                int iIntValue3 = pluginValueSet.intValue(8038);
                String strStringValue11 = pluginValueSet.stringValue(8039);
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeSelected postion:" + iIntValue3 + " value:" + strStringValue11);
                callNativeDislikeSelected(iIntValue3, strStringValue11);
            }
        }
        return (T) com.byazt.hf.c.c(cls);
    }

    public void callNativeAdClick() {
        checkClick(new c() { // from class: com.byazt.uj.uj.2
            @Override // com.byazt.uj.c
            public void c() {
                if (uj.this.getGMDrawAdListener() != null) {
                    uj.this.getGMDrawAdListener().c(null);
                }
            }
        });
    }

    public void callNativeAdShow() {
        checkShow(new c() { // from class: com.byazt.uj.uj.3
            @Override // com.byazt.uj.c
            public void c() {
                if (uj.this.getGMDrawAdListener() != null) {
                    uj.this.getGMDrawAdListener().c();
                }
            }
        });
    }

    public void callNativeDislikeCancel() {
        if (getDislikeCallback() != null) {
            getDislikeCallback().tt();
        }
    }

    public void callNativeDislikeSelected(int i, String str) {
        com.byazt.wn.tt ttVar = ((ve) this).x;
        if (ttVar != null) {
            ttVar.nativeDislikeClick(this, str);
        }
        if (getDislikeCallback() != null) {
            getDislikeCallback().c(i, str, false);
        }
    }

    public void callNativeDislikeShow() {
        if (getDislikeCallback() != null) {
            getDislikeCallback().c();
        }
    }

    public void callNativeOnDownloadActive(long j, long j2, String str, String str2) {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().c(j, j2, -1, 1, str, str2);
        }
    }

    public void callNativeOnDownloadFailed(long j, long j2, String str, String str2) {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().tt(j, j2, str, str2);
        }
    }

    public void callNativeOnDownloadFinished(long j, String str, String str2) {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().c(j, str, str2);
        }
    }

    public void callNativeOnDownloadPaused(long j, long j2, String str, String str2) {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().c(j, j2, str, str2);
        }
    }

    public void callNativeOnIdle() {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().c();
        }
    }

    public void callNativeOnInstalled(String str, String str2) {
        if (getGMAdAppDownloadListener() != null) {
            getGMAdAppDownloadListener().c(str, str2);
        }
    }

    public void callNativeRenderFail(View view, String str, int i) {
        if (getGMDrawAdListener() instanceof com.byazt.fy.uj) {
            try {
                ((com.byazt.fy.uj) getGMDrawAdListener()).c(view, str, i);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public void callNativeRenderSuccess(float f, float f2) {
        if (getGMDrawAdListener() instanceof com.byazt.fy.uj) {
            try {
                ((com.byazt.fy.uj) getGMDrawAdListener()).c(f, f2);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public void callNativeVideoCompleted() {
        if (getGMVideoListener() != null) {
            getGMVideoListener().n();
        }
    }

    public void callNativeVideoError(com.byazt.zm.c cVar) {
        if (getGMVideoListener() != null) {
            getGMVideoListener().c(new com.byazt.pp.c(49012, com.byazt.pp.c.c(49012), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.tt()));
        }
    }

    public void callNativeVideoPause() {
        if (getGMVideoListener() != null) {
            getGMVideoListener().ve();
        }
    }

    public void callNativeVideoProgressUpdate(long j, long j2) {
        if (getGMVideoListener() != null) {
            getGMVideoListener().c(j, j2);
        }
    }

    public void callNativeVideoResume() {
        if (getGMVideoListener() != null) {
            getGMVideoListener().uj();
        }
    }

    public void callNativeVideoStart() {
        if (getGMVideoListener() != null) {
            getGMVideoListener().tt();
        }
    }

    @Override // com.byazt.yl.ve
    public void dislikeClick(String str, Map<String, Object> map) {
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8194).c(Void.class).c(8036, str).c(8075, map).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public View getAdView() {
        if (((ve) this).i == null) {
            return super.getAdView();
        }
        Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(6081).c(View.class).tt());
        if (objApply instanceof View) {
            return (View) objApply;
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.nc.sp getDislikeDialog(Activity activity) {
        if (((ve) this).i == null) {
            return null;
        }
        Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(6072).c(Object.class).c(20033, activity).tt());
        if (objApply == null) {
            return null;
        }
        final com.byazt.ch.a aVar = new com.byazt.ch.a(com.byazt.gxc.ve.c(objApply));
        return new com.byazt.nc.sp() { // from class: com.byazt.uj.uj.1
            @Override // com.byazt.nc.sp
            public boolean isShow() {
                return false;
            }

            @Override // com.byazt.nc.sp
            public void resetDislikeStatus() {
            }

            @Override // com.byazt.nc.sp
            public void setDislikeInteractionCallback(com.byazt.dhf.c cVar) {
                aVar.c(new com.byazt.wc.tt(cVar));
            }

            @Override // com.byazt.nc.sp
            public void setDislikeSource(String str) {
            }

            @Override // com.byazt.nc.sp
            public void showDislikeDialog() {
                aVar.c();
            }
        };
    }

    @Override // com.byazt.yl.ve
    public com.byazt.me.n getGMNativeCustomVideoReporter() {
        if (((ve) this).i != null) {
            Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8320).c(Function.class).tt());
            if (objApply instanceof Function) {
                return com.byazt.zr.c.c((Function) objApply);
            }
        }
        return super.getGMNativeCustomVideoReporter();
    }

    @Override // com.byazt.yl.ve
    public String getVideoUrl() {
        if (((ve) this).i == null) {
            return super.getVideoUrl();
        }
        Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8228).c(String.class).tt());
        if (objApply instanceof String) {
            return objApply.toString();
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public View getVideoView() {
        if (((ve) this).i == null) {
            return super.getVideoView();
        }
        Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(6164).c(View.class).tt());
        if (objApply instanceof View) {
            return (View) objApply;
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public boolean hasDislike() {
        if (((ve) this).i == null) {
            return super.hasDislike();
        }
        Object objApply = ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8135).c(Boolean.class).tt());
        return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
    }

    @Override // com.byazt.uj.ve, com.byazt.yl.ve
    public Integer isReadyStatus() {
        if (((ve) this).i != null) {
            Integer numC = com.byazt.sq.c.c(((ve) this).i.apply(com.byazt.yxi.uj.c().c(8121).c(20068, 1).c(Object.class).tt()));
            if (numC != null) {
                return numC;
            }
        }
        return 1;
    }

    @Override // com.byazt.uj.ve, com.byazt.yl.ve
    public void onDestroy() {
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8109).c(Void.class).tt());
        }
    }

    @Override // com.byazt.uj.ve, com.byazt.yl.ve
    public void onPause() {
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8149).c(Void.class).tt());
        }
    }

    @Override // com.byazt.uj.ve, com.byazt.yl.ve
    public void onResume() {
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8148).c(Void.class).tt());
        }
    }

    @Override // com.byazt.uj.ve
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8225).c(Void.class).c(8406, Boolean.valueOf(z)).c(8407, Double.valueOf(d)).c(8408, Integer.valueOf(i)).c(8075, map).tt());
        }
    }

    @Override // com.byazt.uj.x
    public void register(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar) {
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8159).c(Void.class).c(20033, activity).c(8067, viewGroup).c(8068, list).c(8069, list2).c(8070, list3).c(8071, com.byazt.me.da.c(daVar)).tt());
        }
    }
}
