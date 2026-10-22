package cj.mobile.wm.common.nativepot;

import android.view.View;
import android.view.ViewGroup;
import cj.mobile.wm.common.Ilistener.IWMAppDownloadListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
