package com.beizi.fusion;

import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface NativeUnifiedAdResponse {
    String getActionText();

    String getAdLogoUrl();

    String getDescription();

    UnifiedAdDownloadAppInfo getDownloadAppInfo();

    int getECPM();

    String getIconUrl();

    String getImageUrl();

    List<String> getImgList();

    int getMaterialType();

    String getTitle();

    View getVideoView();

    ViewGroup getViewContainer();

    boolean isVideo();

    void registerDownloadAppInfoClickEvent(View view);

    void registerViewForInteraction(List<View> list);
}
