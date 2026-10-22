package cj.mobile.jt.core.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cj.mobile.jt.core.modle.AppInformation;
import cj.mobile.jt.core.modle.IJuTuiBiddingAdData;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface JuTuiNativeAdData extends IJuTuiBiddingAdData {
    void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, View view);

    void destroy();

    int getAdMaterialType();

    View getAdMediaView();

    AppInformation getAppInformation();

    String getAppName();

    String getCreativeId();

    String getDescription();

    String getDownloadUrl();

    String getImgUrl();

    List<String> getImgUrls();

    String getLogoUrl();

    View getShakeView(Context context);

    String getSource();

    String getTitle();

    boolean isValid();

    void onPause();

    void onResume();

    void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener);

    void setVideoListener(NativeVideoListener nativeVideoListener);
}
