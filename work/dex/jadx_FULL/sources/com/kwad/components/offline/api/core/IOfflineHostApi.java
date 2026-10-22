package com.kwad.components.offline.api.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcHostProvider;
import com.kwad.components.offline.api.core.adInnerEc.IFullLive;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IOfflineDeviceManagerProxy;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineHostApi {
    void adLiveErrorReport(int i, String str, String str2, Long l, int i2, String str3);

    IAsync async();

    IBundleService bundleService();

    ICache cache();

    boolean canUseStorage();

    ICrash crash();

    IOfflineDeviceManagerProxy deviceManager();

    IDownloader downloader();

    IEncrypt encrypt();

    IEnvironment env();

    IFlowUuid flowUuid();

    IAdInnerEcHostProvider getAdInnerEcHostProvider();

    int getAppIconId(Context context);

    int getDrawableId(Context context, String str);

    IFullLive getFullLive();

    int getId(Context context, String str);

    PackageInfo getPackageInfo(Context context, String str, int i);

    long getSystemTimeInMs(Context context, boolean z);

    int getTKErrorDetailCount();

    List<String> getTKPreloadMemCacheTemplates();

    String getWaynePlayerPlayConfig();

    IIdc idc();

    IImageLoader imageLoader();

    IImagePlayer imagePlayer();

    boolean isOrientationPortrait();

    ILifeCycle lifeCycle();

    ILive live();

    IOfflineCompoLogcat log();

    ILoggerReporter loggerReporter();

    INet net();

    INetworkManager networkManager();

    void saveTKTemplateCache(String str, int i, String str2);

    ISensorManagerProxy sensorManager();

    ISystemProperties systemProperty();

    IVibratorUtil vibratorUtil();

    IVideo video();

    IWebView webview();

    IZipper zipper();
}
