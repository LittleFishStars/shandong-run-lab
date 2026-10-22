package com.hailiang.advlib.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class IMultiAdObject {
    public static final int INTERACTION_TYPE_DOWNLOAD = 2;
    public static final int INTERACTION_TYPE_LANDPAGE = 1;
    public static final int MATERIAL_TYPE_BIG_IMAGE = 2;
    public static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    public static final int MATERIAL_TYPE_INCITE_VIDEO = 12;
    public static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    public static final int MATERIAL_TYPE_SPLASH = 6;
    public static final int MATERIAL_TYPE_VIDEO_H = 4;
    public static final int MATERIAL_TYPE_VIDEO_V = 9;
    public static final int PUT_TYPE_DEFAULT = 0;
    public static final int PUT_TYPE_LIVE = 2;
    public static final int PUT_TYPE_NEW = 1;

    @Keep
    public interface ADEventListener {
        void onADExposed();

        void onAdClick();

        void onAdFailed(String str);
    }

    @Keep
    public interface ADStateListener {
        void onAdEvent(int i, Bundle bundle);
    }

    @Keep
    public interface MediaStateListener {
        void onVideoCompleted();

        void onVideoPause();

        void onVideoReady();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop();
    }

    @Keep
    public interface SplashEventListener {
        void onObClicked();

        void onObShow();

        void onObSkip();

        void onObTimeOver();
    }

    public void bindEvent(ViewGroup viewGroup, List<View> list, ADEventListener aDEventListener) {
    }

    public void bindEvent(ViewGroup viewGroup, List<View> list, List<View> list2, ADEventListener aDEventListener) {
    }

    public void bindView(ViewGroup viewGroup, ADEventListener aDEventListener) {
    }

    public void closeInteractionAd() {
    }

    public void destroy() {
    }

    public AppInformation getAppInformation() {
        return null;
    }

    public String getAppLogoUrl() {
        return "";
    }

    public String getAppName() {
        return "";
    }

    public String getAppPackageName() {
        return "";
    }

    public String getDesc() {
        return "";
    }

    public DownloadAdController getDownloadAdController() {
        return null;
    }

    public String getDownloadUrl() {
        return "";
    }

    public int getECPM() {
        return 0;
    }

    public Map<String, Object> getExtraInfo() {
        return null;
    }

    public int getIdeaId() {
        return 0;
    }

    public List<String> getImageUrls() {
        return new ArrayList();
    }

    public int getInteractionType() {
        return 0;
    }

    public String getLandingPageUrl() {
        return "";
    }

    public int getMaterialType() {
        return 0;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return new HashMap();
    }

    public Pair<Integer, Integer> getMediaSize() {
        return null;
    }

    public int getPutType() {
        return 0;
    }

    public String getQMLogo() {
        return "";
    }

    public String getRequestId() {
        return "";
    }

    public View getTView(Context context, int i) {
        return null;
    }

    public String getTitle() {
        return "";
    }

    public String getVideoCoverImage() {
        return "";
    }

    public int getVideoDuration() {
        return 0;
    }

    public String getVideoUrl() {
        return "";
    }

    public View getVideoView(Context context) {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void lossNotice(int i, String str, String str2) {
    }

    public void setADStateListener(ADStateListener aDStateListener) {
    }

    public void setDownloadListener(IAppDownloadListener iAppDownloadListener) {
    }

    public void setOnMediaStateListener(MediaStateListener mediaStateListener) {
    }

    public void showInteractionAd(Activity activity, AdRequestParam.ADInteractionListener aDInteractionListener) {
    }

    public void showRewardVideo(Activity activity, AdRequestParam.ADRewardVideoListener aDRewardVideoListener) {
    }

    public void showSplashView(ViewGroup viewGroup, SplashEventListener splashEventListener) {
    }

    public void showWithdrawalTask(Activity activity, AdRequestParam.ADWithdrawalTaskListener aDWithdrawalTaskListener) {
    }

    public void triggerTwist(View view) {
    }

    public void winNotice(int i) {
    }
}
