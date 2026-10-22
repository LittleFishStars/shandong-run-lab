package com.kc.bw.common.nativepot;

import android.view.View;
import android.view.ViewGroup;
import com.kc.bw.common.Ilistener.IWMAppDownloadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface NativeWMResponse {
    void bindToAdContainer(ViewGroup viewGroup, View view);

    ViewGroup buildContainer();

    HtmlBean buildHtmlView();

    WMVideoBean buildVideoView(WMVideoOption wMVideoOption, WMVideoListener wMVideoListener);

    AdBaseInfo getBaseInfo();

    void notifyAdViewShow();

    void registerClickableViews(List<View> list);

    void setAppDownloadListener(IWMAppDownloadListener iWMAppDownloadListener);
}
