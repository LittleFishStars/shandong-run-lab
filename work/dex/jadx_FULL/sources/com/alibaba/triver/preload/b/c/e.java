package com.alibaba.triver.preload.b.c;

import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import com.alibaba.ariver.app.NodeInstance;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.preload.annotation.PreloadThreadType;
import com.alibaba.triver.kit.api.preload.annotation.RunningAfterAppxJob;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.kit.api.utils.VersionCompareUtils;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class e implements IPreloadJob<d>, com.alibaba.triver.preload.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f25128a = 1;
    protected String b;
    private long c = 0;
    private long d = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25131a;

        private a() {
            this.f25131a = 100;
        }

        public void a(int i) {
            this.f25131a = i;
        }

        public int a() {
            return this.f25131a;
        }
    }

    private InputStream k() {
        try {
            return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getResources().getAssets().open("index.html");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract InputStream a(String str, AppxResourcePackage appxResourcePackage);

    public String a() {
        return "WVRender";
    }

    @PreloadThreadType(ExecutorType.IDLE)
    @RunningAfterAppxJob(true)
    public d b(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        RVLogger.e("WVRenderPreLoadJob preload start");
        try {
            if (!Triver.isInitUCJSEngine()) {
                a(j(), 1, this.b);
                return null;
            }
            if (e()) {
                RVLogger.e("WVRenderPreLoadJob", "current process is wml5 , do not open preload render");
                return null;
            }
            return b();
        } catch (Throwable th) {
            RVLogger.e("Render预启失败：" + th.getMessage());
        }
    }

    public WebResourceResponse c() {
        return null;
    }

    public WebResourceResponse d() {
        return null;
    }

    public boolean e() {
        String processName = ProcessUtils.getProcessName();
        return processName != null && processName.endsWith("wml5");
    }

    public boolean f() {
        return Triver.isMainProcess(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    public void g() {
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<d> getResultClazz() {
        return d.class;
    }

    public long h() {
        return this.c;
    }

    public long i() {
        return this.d;
    }

    public long j() {
        if (i() == 0) {
            b(System.currentTimeMillis());
        }
        return i() - h();
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @PreloadThreadType(ExecutorType.IDLE)
    @RunningAfterAppxJob(true)
    public /* synthetic */ d preLoad(Map map, PreloadScheduler.PointType pointType) {
        return b((Map<String, Object>) map, pointType);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 != null) {
            return bArr2;
        }
        if (bArr2 == null && bArr != null) {
            return bArr;
        }
        if (bArr == null && bArr2 == null) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WVUCWebViewClient a(final com.alibaba.triver.resource.e eVar, final CountDownLatch countDownLatch) {
        return new WVUCWebViewClient(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()) { // from class: com.alibaba.triver.preload.b.c.e.2
            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                RVLogger.e("WVRenderPreLoadJob", "onPageFinish : " + str);
                try {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                InputStream inputStreamA;
                WebResourceResponse webResourceResponse = null;
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                    return null;
                }
                String string = webResourceRequest.getUrl().toString();
                if (string.contains("index.js")) {
                    return e.this.c();
                }
                if (string.contains("templateSnapshot.js")) {
                    return e.this.d();
                }
                if (string.equals("https://hybrid.miniapp.taobao.com/index.html#pages/index/index")) {
                    try {
                        InputStream inputStreamA2 = e.this.a(eVar);
                        if (inputStreamA2 == null) {
                            return null;
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "uft-8", inputStreamA2);
                        try {
                            HashMap map = new HashMap();
                            map.put("Access-Control-Allow-Origin", "*");
                            map.put("Cache-Control", "no-cache");
                            webResourceResponse2.setResponseHeaders(map);
                            return webResourceResponse2;
                        } catch (Exception e) {
                            e = e;
                            webResourceResponse = webResourceResponse2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    e.printStackTrace();
                    return webResourceResponse;
                }
                if (string.startsWith(com.alibaba.triver.triver_worker.v8worker.jsi.b.c)) {
                    if (string.startsWith("https://appx/af-appx.min.css")) {
                        InputStream inputStreamB = e.this.b(string, eVar);
                        if (inputStreamB != null) {
                            webResourceResponse = new WebResourceResponse("text/css", "uft-8", inputStreamB);
                        }
                    } else if (string.startsWith("https://appx/af-appx.min.js") && (inputStreamA = e.this.a(string, eVar)) != null) {
                        webResourceResponse = new WebResourceResponse(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "uft-8", inputStreamA);
                    }
                }
                if (webResourceResponse == null) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                HashMap map2 = new HashMap();
                map2.put("Access-Control-Allow-Origin", "*");
                map2.put("Cache-Control", "no-cache");
                webResourceResponse.setResponseHeaders(map2);
                return webResourceResponse;
            }
        };
    }

    public InputStream a(com.alibaba.triver.resource.e eVar) {
        if (eVar == null) {
            return k();
        }
        Resource resource = eVar.get(new ResourceQuery("https://appx/index.html"));
        if (resource != null) {
            return resource.getStream();
        }
        return k();
    }

    public d b() {
        d dVar;
        d dVar2;
        final com.alibaba.triver.resource.e eVarB = com.alibaba.triver.preload.b.a.a.b();
        String str = "WVRenderPreLoadJob";
        if (eVarB == null) {
            RVLogger.w("WVRenderPreLoadJob", "Appx package not found in global!");
            a(j(), 3, this.b);
            return null;
        }
        if (eVarB.getAppModel() != null && eVarB.getAppModel().getAppInfoModel() != null) {
            String developerVersion = eVarB.getAppModel().getAppInfoModel().getDeveloperVersion();
            RVLogger.d("WVRenderPreLoadJob", "Appx package already in global!");
            try {
                if (!VersionCompareUtils.aBiggerThanB(developerVersion, "1.23.4.0")) {
                    RVLogger.w("WVRenderPreLoadJob", "appx 不高于 1.23.4.0");
                    a(j(), 5, this.b);
                    return null;
                }
            } catch (Throwable th) {
                RVLogger.e("Render预启失败：" + th.getMessage());
            }
            try {
                if (this instanceof b) {
                    c cVar = (c) PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, c.class);
                    if (cVar != null) {
                        RVLogger.d("WVRenderPreLoadJob", "preload resource reuse.");
                        return cVar;
                    }
                } else {
                    d dVar3 = (d) PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, d.class);
                    if (dVar3 != null) {
                        RVLogger.d("WVRenderPreLoadJob", "preload resource reuse.");
                        return dVar3;
                    }
                }
            } catch (Throwable th2) {
                RVLogger.e("Render预启失败：" + th2.getMessage());
            }
            if (!a((ResourcePackage) eVarB)) {
                a(j(), 9, this.b);
                g();
                return null;
            }
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final long jGenerateNodeId = NodeInstance.generateNodeId();
                final WMLTRWebView[] wMLTRWebViewArr = new WMLTRWebView[1];
                final a aVar = new a();
                try {
                    if (WMLTRWebView.k()) {
                        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.preload.b.c.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (countDownLatch == null || ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext() == null) {
                                        wMLTRWebViewArr[0] = null;
                                        aVar.a(7);
                                        CountDownLatch countDownLatch2 = countDownLatch;
                                        if (countDownLatch2 != null) {
                                            countDownLatch2.countDown();
                                        }
                                    } else {
                                        wMLTRWebViewArr[0] = new WMLTRWebView(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                                        wMLTRWebViewArr[0].setWebViewClient(e.this.a(eVarB, countDownLatch));
                                        wMLTRWebViewArr[0].setPreload(true);
                                        wMLTRWebViewArr[0].injectJsEarly(IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), TRiverConstants.H5_BRIDGE_PART1_NAME).replace("{bridge_token}", "bridge_token_" + jGenerateNodeId));
                                        wMLTRWebViewArr[0].loadUrl("https://hybrid.miniapp.taobao.com/index.html#pages/index/index");
                                        PreloadScheduler.UA = wMLTRWebViewArr[0].getUserAgentString() + " " + EngineUtils.getUserAgentSuffix();
                                    }
                                } catch (Throwable unused) {
                                    aVar.a(8);
                                    CountDownLatch countDownLatch3 = countDownLatch;
                                    if (countDownLatch3 != null) {
                                        countDownLatch3.countDown();
                                    }
                                }
                            }
                        });
                    } else {
                        wMLTRWebViewArr[0] = null;
                        countDownLatch.countDown();
                    }
                    countDownLatch.await(6L, TimeUnit.SECONDS);
                    WMLTRWebView wMLTRWebView = wMLTRWebViewArr[0];
                    if (wMLTRWebView != null) {
                        dVar2 = new d(wMLTRWebView, jGenerateNodeId);
                        try {
                            dVar2.a(eVarB.hashCode());
                            dVar2.b(this.b);
                        } catch (Throwable unused) {
                            dVar = dVar2;
                            dVar2 = dVar;
                        }
                        RVLogger.e(str, "Render preload success");
                        return dVar2;
                    }
                    a(j(), aVar.a(), this.b);
                    return null;
                } catch (Throwable unused2) {
                    dVar = null;
                    dVar2 = dVar;
                    RVLogger.e(str, "Render preload success");
                    return dVar2;
                }
            } catch (Throwable unused3) {
                str = "WVRenderPreLoadJob";
            }
        } else {
            RVLogger.e("WVRenderPreLoadJob", "Appx pkg appModel or appInfoModel is null");
            a(j(), 4, this.b);
            return null;
        }
    }

    public boolean a(ResourcePackage resourcePackage) {
        return TRiverUtils.verifyAppXResource(resourcePackage, "RenderResourceVerify");
    }

    public void a(long j) {
        this.c = j;
    }

    @Override // com.alibaba.triver.preload.a.a
    public void a(long j, String str) {
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTRiverPreloadPerf(TriverLaunchPointer.build().setStatus(Double.valueOf(1.0d)).create(), a(), true, j, 0);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", a() + " render preload success , costTime = :" + j);
        if (this instanceof b) {
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.r, str, null);
        }
    }

    @Override // com.alibaba.triver.preload.a.a
    public void a(long j, int i, String str) {
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTRiverPreloadPerf(TriverLaunchPointer.build().setStatus(Double.valueOf(1.0d)).create(), a(), false, j, i);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", a() + " render preload failed ,code =  " + i);
        if (this instanceof b) {
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.s, str, null);
        }
    }

    public InputStream b(String str, AppxResourcePackage appxResourcePackage) {
        Resource resource = appxResourcePackage != null ? appxResourcePackage.get(new ResourceQuery(str)) : null;
        if (resource != null) {
            return resource.getStream();
        }
        try {
            return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getResources().getAssets().open("af-appx.min.css");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(long j) {
        this.d = j;
    }
}
