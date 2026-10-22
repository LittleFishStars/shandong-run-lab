package com.alibaba.triver.kit.api;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.alibaba.triver.kit.api.model.WindowInfoModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Page {
    void applyTransparentTitle(boolean z);

    boolean canGoback();

    Bitmap captureView();

    TinyApp getApp();

    int getIndex();

    String getPagePath();

    Bundle getSceneParams();

    Bundle getStartParams();

    WindowInfoModel getWindowInfo();

    boolean isFirstTab();

    boolean isHomePage();

    boolean isStartPage();

    boolean isTabPage();

    void reload();

    void scrollToTop();
}
