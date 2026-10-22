package com.kwad.components.core.offline.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.offline.moitor.AdLivePlayMonitorInfo;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcHostProvider;
import com.kwad.components.offline.api.core.adInnerEc.IFullLive;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bv;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l implements IOfflineHostApi {
    private IAsync abL;
    private IEnvironment abM;
    private IZipper abN;
    private INet abO;
    private IEncrypt abP;
    private IOfflineCompoLogcat abQ;
    private ICrash abR;
    private ILoggerReporter abS;
    private IDownloader abT;
    private IImageLoader abU;
    private IVideo abV;
    private ILive abW;
    private ICache abX;
    private IWebView abY;
    private IVibratorUtil abZ;
    private IIdc aca;
    private IImagePlayer acb;
    private ILifeCycle acc;
    private INetworkManager acd;
    private ISystemProperties ace;
    private IFlowUuid acf;
    private ISensorManagerProxy acg;
    private o ach;
    private a aci;
    private IFullLive acj;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    /* JADX INFO: renamed from: tF, reason: merged with bridge method [inline-methods] */
    public o deviceManager() {
        if (this.ach == null) {
            this.ach = new o();
        }
        return this.ach;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void adLiveErrorReport(int i, String str, String str2, Long l, int i2, String str3) {
        if (l == null) {
            l = -1L;
        }
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_live_video_error_monitor", "status").b(BusinessType.OTHER).A(new AdLivePlayMonitorInfo().setScene(i).setAppId(str).setAuthorId(str2).setUserId(l).setErrorCode(i2).setErrorMsg(str3)).a(com.kwai.adclient.kscommerciallogger.model.b.buV));
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.abL == null) {
            this.abL = new b();
        }
        return this.abL;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IBundleService bundleService() {
        return new IBundleService() { // from class: com.kwad.components.core.offline.b.a.l.4
            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundle(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.yH().b(context, str, new com.kwad.components.core.webview.tachikoma.g.b() { // from class: com.kwad.components.core.offline.b.a.l.4.1
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundleWithString(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.yH().a(context, str, new com.kwad.components.core.webview.tachikoma.g.b() { // from class: com.kwad.components.core.offline.b.a.l.4.2
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void unloadBundle(String str) {
                com.kwad.components.core.webview.tachikoma.g.yH().unloadBundle(str);
            }
        };
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.abX == null) {
            this.abX = new c();
        }
        return this.abX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean canUseStorage() {
        return !be.useStoragePermissionDisable();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.abR == null) {
            this.abR = new ICrash() { // from class: com.kwad.components.core.offline.b.a.l.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addCustomKeyValue(final ICrashCustomKeyValue iCrashCustomKeyValue) {
                    com.kwad.sdk.service.d.b(new com.kwad.sdk.service.a.c() { // from class: com.kwad.components.core.offline.b.a.l.1.1
                        @Override // com.kwad.sdk.service.a.c
                        public final String getKey() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getKey();
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.service.a.c
                        public final JSONObject getValue() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getValue();
                            }
                            return null;
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addOnCrashListener(final ICrashOccurListener iCrashOccurListener) {
                    com.kwad.sdk.service.d.a(new com.kwad.sdk.service.a.g() { // from class: com.kwad.components.core.offline.b.a.l.1.2
                        @Override // com.kwad.sdk.service.a.g
                        public final void p(int i, String str) {
                            ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                            if (iCrashOccurListener2 != null) {
                                iCrashOccurListener2.onCrashOccur(i, str);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.d.gatherException(th);
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
                    com.kwad.sdk.service.d.J(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
                }
            };
        }
        return this.abR;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.abT == null) {
            this.abT = new IDownloader() { // from class: com.kwad.components.core.offline.b.a.l.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.d(str, file);
                }
            };
        }
        return this.abT;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.abP == null) {
            this.abP = new d();
        }
        return this.abP;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.abM == null) {
            this.abM = new e();
        }
        return this.abM;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFlowUuid flowUuid() {
        if (this.acf == null) {
            this.acf = new f();
        }
        return this.acf;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAdInnerEcHostProvider getAdInnerEcHostProvider() {
        if (this.aci == null) {
            this.aci = new a();
        }
        return this.aci;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getAppIconId(Context context) {
        return bc.getAppIconId(context);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getDrawableId(Context context, String str) {
        return bc.aD(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFullLive getFullLive() {
        if (this.acj == null) {
            this.acj = new g();
        }
        return this.acj;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getId(Context context, String str) {
        return bc.getId(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final PackageInfo getPackageInfo(Context context, String str, int i) {
        return aa.getPackageInfo(context, str, i);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final long getSystemTimeInMs(Context context, boolean z) {
        return bv.C(context, z);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getTKErrorDetailCount() {
        return com.kwad.sdk.core.config.e.getTKErrorDetailCount();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final List<String> getTKPreloadMemCacheTemplates() {
        return com.kwad.sdk.core.config.e.getTKPreloadMemCacheTemplates();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final String getWaynePlayerPlayConfig() {
        return com.kwad.sdk.core.config.e.KM();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.aca == null) {
            this.aca = new p();
        }
        return this.aca;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.abU == null) {
            this.abU = new h();
        }
        return this.abU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImagePlayer imagePlayer() {
        com.kwad.components.core.h.d dVar = new com.kwad.components.core.h.d();
        this.acb = dVar;
        return dVar;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean isOrientationPortrait() {
        return as.isOrientationPortrait();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILifeCycle lifeCycle() {
        if (this.acc == null) {
            this.acc = new i();
        }
        return this.acc;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.abW == null) {
            this.abW = new com.kwad.components.core.offline.b.b.a();
        }
        return this.abW;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.abQ == null) {
            this.abQ = new m();
        }
        return this.abQ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.abS == null) {
            this.abS = new ILoggerReporter() { // from class: com.kwad.components.core.offline.b.a.l.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(com.kwad.sdk.commercial.d dVar) {
                    com.kwad.sdk.commercial.c.d(dVar);
                }
            };
        }
        return this.abS;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.abO == null) {
            this.abO = new j();
        }
        return this.abO;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INetworkManager networkManager() {
        if (this.acd == null) {
            this.acd = new k();
        }
        return this.acd;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void saveTKTemplateCache(String str, int i, String str2) {
        com.kwad.components.core.webview.tachikoma.h.yK().b(str, i, str2);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISensorManagerProxy sensorManager() {
        if (this.acg == null) {
            this.acg = new s();
        }
        return this.acg;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISystemProperties systemProperty() {
        if (this.ace == null) {
            this.ace = new r();
        }
        return this.ace;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.abZ == null) {
            this.abZ = new u();
        }
        return this.abZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.abV == null) {
            this.abV = new com.kwad.components.core.offline.b.c.e();
        }
        return this.abV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.abY == null) {
            this.abY = new com.kwad.components.core.offline.b.d.b();
        }
        return this.abY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.abN == null) {
            this.abN = new v();
        }
        return this.abN;
    }
}
