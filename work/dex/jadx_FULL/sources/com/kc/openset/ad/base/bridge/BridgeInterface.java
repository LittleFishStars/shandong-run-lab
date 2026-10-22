package com.kc.openset.ad.base.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.kc.openset.ad.DummyBtnConfig;
import com.kc.openset.bean.Orientation;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface BridgeInterface {
    void doAdClick(View view);

    void doAdClose(View view);

    void doAdDetailViewClosed();

    void doAdImp(View view);

    void doAdLoadFailed(String str, String str2);

    void doAdLoadSuccess();

    void doAdRenderFail(View view, String str, String str2);

    void doAdRenderSuccess(View view);

    void doAdReward();

    void doAdShowFail(String str, String str2);

    void doAdSkip();

    void doAdVideoComplete(View view);

    void doAdVideoContinuePlay(View view);

    void doAdVideoEnd();

    void doAdVideoPause(View view);

    void doAdVideoStart();

    void doAdVideoStart(View view);

    void doBidFail(String str);

    void doBidSuccess(String str);

    Map<String, Object> getADNServicesInfo();

    Activity getActivity();

    int getAdObjIsNullBidDefaultPrice();

    double getAdWhRatio();

    int[] getAdWhSize();

    int getBannerImgRadius();

    double getCommissionPrice();

    Context getContext();

    int getDefaultCacheTime();

    int getDefaultLoadTimeout();

    double getDiscount();

    DummyBtnConfig getDummyBtnConfig();

    String getErrorTypeLoad();

    String getErrorTypeOther();

    String getErrorTypePlay();

    int getExceptionBidDefaultPrice();

    String getMediaUid();

    Orientation getOrientation();

    String getPosId();

    int getPrice();

    String getReplaceMaxNetwork();

    double getReplaceMaxPrice();

    double getReplacePrice();

    String getRequestId();

    String getSsAdId();

    long getStartCacheTime();

    double getSubsidyRatio();

    int[] getTiltSensorSen();

    String getToken();

    int getUpr();

    String getUserId();

    boolean isChangePrice();

    boolean isClickCallback();

    boolean isFilter();

    boolean isLoadSuccess();

    void requestErrorLogUpLoad(String str, String str2);

    void requestErrorLogUpLoad(String str, String str2, String str3);

    void updateParentAdKey(String str);

    void updateSonPlat(String str);

    void viewLoadToShow(View view);
}
