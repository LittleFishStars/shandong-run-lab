package com.alibaba.triver.resource;

import android.app.Application;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.triver.utils.ResourceUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverResourcePreseter implements RVResourcePresetProxy, com.alibaba.triver.appinfo.channel.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, AppModel> f25150a;
    private static Map<String, RVResourcePresetProxy.PresetPackage> b;

    private void a() {
        if (f25150a == null || b == null) {
            final Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            f25150a = new HashMap();
            b = new HashMap();
            AppModel appModelA = ResourceUtils.a(applicationContext, "66666692.appinfo.json");
            if (appModelA != null) {
                f25150a.put(appModelA.getAppId(), appModelA);
                if (b.get(appModelA.getAppId()) == null) {
                    b.put(appModelA.getAppId(), new RVResourcePresetProxy.PresetPackage(appModelA.getAppId(), appModelA.getAppVersion(), new RVResourcePresetProxy.InputStreamGetter() { // from class: com.alibaba.triver.resource.TriverResourcePreseter.1
                        @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy.InputStreamGetter
                        public InputStream onGetInputStream() {
                            try {
                                return ResourceUtils.b(applicationContext, "66666692.amr");
                            } catch (IOException e) {
                                RVLogger.e("AriverTriver:TriverResourcePreseter", "66666692 getAppPackageFromAssets error", e);
                                return null;
                            }
                        }
                    }));
                }
            }
            AppModel appModelA2 = ResourceUtils.a(applicationContext, "68687029.appinfo.json");
            if (appModelA2 != null) {
                f25150a.put(appModelA2.getAppId(), appModelA2);
                if (b.get(appModelA2.getAppId()) == null) {
                    b.put(appModelA2.getAppId(), new RVResourcePresetProxy.PresetPackage(appModelA2.getAppId(), appModelA2.getAppVersion(), new RVResourcePresetProxy.InputStreamGetter() { // from class: com.alibaba.triver.resource.TriverResourcePreseter.2
                        @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy.InputStreamGetter
                        public InputStream onGetInputStream() {
                            try {
                                return ResourceUtils.b(applicationContext, "68687029.amr");
                            } catch (IOException e) {
                                RVLogger.e("AriverTriver:TriverResourcePreseter", "68687029 getAppPackageFromAssets error", e);
                                return null;
                            }
                        }
                    }));
                }
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy
    @Nullable
    public Map<String, AppModel> getPresetAppInfos() {
        a();
        return f25150a;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy
    @Nullable
    public Map<String, RVResourcePresetProxy.PresetPackage> getPresetPackage() {
        a();
        return b;
    }

    @Override // com.alibaba.triver.appinfo.channel.f
    public AppModel getPresetTemplateAppInfo(String str) {
        return ResourceUtils.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), str + ".appinfo.json");
    }
}
