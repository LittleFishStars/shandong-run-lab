package com.alibaba.triver.triver_worker.v8worker.jsi;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.triver.kit.api.cache.ResourceFallbackCenter;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.utils.AppxLoadUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends com.alibaba.ariver.v8worker.d {
    public static final String b = "https://appx/security-patch.min.js";
    public static final String c = "https://appx/";
    private App d;
    private V8Worker e;

    public b(App app, V8Worker v8Worker) {
        super(app, v8Worker);
        this.d = app;
        this.e = v8Worker;
    }

    private String b(String str) {
        String str2 = str;
        App app = this.d;
        if (app == null) {
            return null;
        }
        if (!TRiverUrlUtils.isShop(app)) {
            if (!str2.startsWith(c)) {
                return null;
            }
            if (str2.contains("#")) {
                str2 = str2.split("#")[0];
            }
            String appxAssertResource = ResourceFallbackCenter.getAppxAssertResource(str2);
            if (appxAssertResource != null) {
                return appxAssertResource;
            }
            return null;
        }
        if (c(str)) {
            String pluginResource = ResourceFallbackCenter.getPluginResource(d(str), "index.worker.js");
            if (TextUtils.isEmpty(pluginResource) || pluginResource.length() < 100) {
                HashMap map = new HashMap();
                map.put("resourceUrl", str2);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏4", "页面资源丢失，页面白屏", new HashMap(), map);
            }
            return pluginResource;
        }
        if (str2.equals(this.e.getWorkerId())) {
            String templatePkgResource = ResourceFallbackCenter.getTemplatePkgResource("index.worker.js");
            if (templatePkgResource == null) {
                templatePkgResource = ResourceFallbackCenter.readAssert("shop.index.worker.js");
            }
            if (TextUtils.isEmpty(templatePkgResource) || templatePkgResource.length() < 100) {
                HashMap map2 = new HashMap();
                map2.put("resourceUrl", "index.worker.js");
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏5", "页面资源丢失，页面白屏", new HashMap(), map2);
            }
            return templatePkgResource;
        }
        if (!str2.startsWith(c)) {
            return null;
        }
        if (str2.contains("#")) {
            str2 = str2.split("#")[0];
        }
        String appxAssertResource2 = ResourceFallbackCenter.getAppxAssertResource(str2);
        if (appxAssertResource2 != null) {
            return appxAssertResource2;
        }
        HashMap map3 = new HashMap();
        map3.put("resourceUrl", str2);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏6", "页面资源丢失，页面白屏", new HashMap(), map3);
        return null;
    }

    private boolean c(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("__plugins__/");
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length < 3) {
            return null;
        }
        return strArrSplit[strArrSplit.length - 2];
    }

    @Override // com.alibaba.ariver.v8worker.d
    public String a(String str) {
        if (this.d == null) {
            if (str.equals("https://appx/af-appx.worker.min.js") || str.equals("https://appx/security-patch.min.js")) {
                try {
                    ResourcePackage appxPackageFromRAM = AppxLoadUtils.getAppxPackageFromRAM();
                    if (appxPackageFromRAM instanceof AppxResourcePackage) {
                        AppxResourcePackage appxResourcePackage = (AppxResourcePackage) appxPackageFromRAM;
                        Resource resource = appxResourcePackage.get(new ResourceQuery(str));
                        V8Worker v8Worker = this.e;
                        if (v8Worker instanceof d) {
                            ((d) v8Worker).a(appxResourcePackage.hashCode());
                        }
                        if (resource != null) {
                            return new String(resource.getBytes(), "UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (c(str)) {
                try {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "get plugin url : " + str);
                    String strD = d(str);
                    String pluginWorkerIndexJs = ((GetShopPluginResourcePoint) ExtensionPoint.as(GetShopPluginResourcePoint.class).nullable().create()).getPluginWorkerIndexJs(strD);
                    if (pluginWorkerIndexJs != null) {
                        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "plugin : " + strD + " loaded");
                        return pluginWorkerIndexJs;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        String strA = super.a(str);
        if (strA == null) {
            strA = b(str);
        }
        if (strA != null && str.endsWith("prefetch.js")) {
            TRiverUtils.toastInDebug("prefetch js");
        }
        return strA;
    }

    @Override // com.alibaba.ariver.v8worker.d
    public void a(App app) {
        super.a(app);
        this.d = app;
    }
}
