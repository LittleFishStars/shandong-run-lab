package com.beizi.fusion.unified;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface BZUnifiedAdResponse {
    String getActionText();

    String getAdBrand();

    String getCreativeId();

    String getDeeplink();

    String getDesc();

    BZUnifiedAdDownloadAppInfo getDownloadAppInfo();

    String getDownloadUrl();

    int getEcpm();

    BZUnifiedAdImageInfo getIcon();

    BZUnifiedAdImageInfo getImage();

    List<BZUnifiedAdImageInfo> getImageList();

    int getImageMode();

    int getInteractionType();

    String getLandingPage();

    BZUnifiedAdImageInfo getLogo();

    String getTitle();

    BZUnifiedAdVideoInfo getVideo();
}
