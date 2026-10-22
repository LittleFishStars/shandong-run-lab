package com.alibaba.triver.resource;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.utils.CommonUtils;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends AppxResourcePackage {
    private static final String b = "TriverAppxResourcePacka";
    private static final int c = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25163a;
    private ResourceContext d;
    private int e;

    public e(ResourceContext resourceContext) {
        super(resourceContext);
        this.f25163a = false;
        this.e = 0;
        this.d = resourceContext;
    }

    private synchronized RVHttpResponse a(RVTransportService rVTransportService, String str, String str2) {
        int i = this.e + 1;
        this.e = i;
        if (i <= 3) {
            try {
                RVHttpResponse rVHttpResponseHttpRequest = rVTransportService.httpRequest(RVHttpRequest.newBuilder().method("GET").url(str + str2).requestData(null).timeout(5000L).build());
                if (rVHttpResponseHttpRequest.getStatusCode() == 301) {
                    return a(rVTransportService, str, rVHttpResponseHttpRequest.getHeaders().get("Location").get(0));
                }
                this.e = 0;
                return rVHttpResponseHttpRequest;
            } catch (Exception e) {
                RVLogger.e(b, "appx proxy request error", e);
            }
        }
        this.e = 0;
        return null;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        if (CommonUtils.useProxy() && CommonUtils.isApkDebug() && !TextUtils.isEmpty(com.alibaba.triver.appinfo.storage.c.a().b()) && com.alibaba.triver.appinfo.storage.c.a().c() && RVConstants.TINY_WEB_COMMON_APPID.equals(parseContext.appId)) {
            HashMap map = new HashMap();
            int i = 0;
            for (String str : keySet()) {
                if (str.startsWith(com.alibaba.ariver.resource.runtime.a.b)) {
                    i++;
                    Resource resourceA = a(str);
                    if (resourceA == null || resourceA.getBytes() == null || resourceA.getBytes().length == 0) {
                        break;
                    } else {
                        map.put(str, resourceA);
                    }
                }
            }
            if (map.size() != i || i == 0) {
                this.f25163a = false;
                return;
            }
            for (String str2 : map.keySet()) {
                remove(str2);
                add((Resource) map.get(str2));
            }
            this.f25163a = true;
        }
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = RVProxy.get(RVResourceManager.class) instanceof BasicResourceManager;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        String templateId;
        String developerVersion;
        super.onVerifyError(parseFailedException);
        try {
            AppModel appModel = getAppModel();
            String str = null;
            if (appModel != null) {
                String appVersion = appModel.getAppVersion();
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                templateId = appModel.getAppInfoModel().getTemplateConfig() != null ? appModel.getAppInfoModel().getTemplateConfig().getTemplateId() : null;
                str = appVersion;
            } else {
                templateId = null;
                developerVersion = null;
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(parseFailedException.getParseContext().appId).setVersion(str).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage("package").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setErrorCode("" + parseFailedException.getCode()).setErrorMsg(parseFailedException.getMessage()).create());
        } catch (Exception e) {
            RVLogger.e(b, e);
        }
    }

    private Resource a(String str) {
        try {
            RVHttpResponse rVHttpResponseA = a((RVTransportService) RVProxy.get(RVTransportService.class), "http://" + com.alibaba.triver.appinfo.storage.c.a().b(), str.substring(7));
            if (rVHttpResponseA != null && rVHttpResponseA.getStatusCode() == 200) {
                InputStream resStream = rVHttpResponseA.getResStream();
                byte[] bArr = new byte[resStream.available()];
                resStream.read(bArr);
                new String(bArr);
                return new OfflineResource(str, bArr);
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(b, "appx proxy response error", e);
            return null;
        }
    }
}
