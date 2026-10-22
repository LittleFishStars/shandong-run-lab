package com.alibaba.ariver.engine.common.track;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JsApiStatTrackServiceImpl implements RVJsStatTrackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24072a = "AriverEngine:JsApiStatTrackServcieImpl";
    private List<String> b = Collections.synchronizedList(new ArrayList());
    public boolean sEnableTinyAppJsApiStat;

    public JsApiStatTrackServiceImpl() {
        this.sEnableTinyAppJsApiStat = false;
        List<String> listA = a();
        if (listA != null) {
            this.b.addAll(listA);
        }
        this.sEnableTinyAppJsApiStat = this.b.size() > 0;
    }

    private List<String> a() {
        String[] strArrSplit;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        String configWithProcessCache = rVConfigService != null ? rVConfigService.getConfigWithProcessCache("tinyapp_jsapi_whitelist_for_monitor", "") : null;
        if (TextUtils.isEmpty(configWithProcessCache) || (strArrSplit = configWithProcessCache.split("\\|")) == null) {
            return null;
        }
        return (strArrSplit.length == 1 && "no".equalsIgnoreCase(strArrSplit[0])) ? Collections.emptyList() : Arrays.asList(strArrSplit);
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onCallDispatch(NativeCallContext nativeCallContext) {
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded()) {
                    return;
                }
                jsApiStatTrackStore.jsapiStatMap.put(nativeCallContext.getId(), new JsApiStatTrackStore.TinyAppJsApiStatInfo(nativeCallContext.getName(), System.currentTimeMillis(), 0L));
            } catch (Throwable th) {
                RVLogger.e(f24072a, "onCallDispatch exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onInvoke(NativeCallContext nativeCallContext) {
        JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo;
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded() || (tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId())) == null) {
                    return;
                }
                tinyAppJsApiStatInfo.invokeTs = System.currentTimeMillis();
            } catch (Throwable th) {
                RVLogger.e(f24072a, "onInvoke exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onSendBack(NativeCallContext nativeCallContext) {
        JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo;
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded() || (tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId())) == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = tinyAppJsApiStatInfo.callTs;
                jsApiStatTrackStore.appendJsApiDetail4TinyWithT2(tinyAppJsApiStatInfo.name, jCurrentTimeMillis - j, tinyAppJsApiStatInfo.invokeTs - j, jCurrentTimeMillis, jElapsedRealtime);
            } catch (Throwable th) {
                RVLogger.e(f24072a, "onSendBack exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void writeJsApiStatToMap(Node node, Map<String, String> map) {
        JsApiStatTrackStore jsApiStatTrackStore;
        if (!this.sEnableTinyAppJsApiStat || map == null || node == null) {
            return;
        }
        try {
            if (!(node instanceof Page) || (jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) node).getData(JsApiStatTrackStore.class, false)) == null) {
                return;
            }
            String jsApiDetail4TinyWithT2 = jsApiStatTrackStore.getJsApiDetail4TinyWithT2();
            if (TextUtils.isEmpty(jsApiDetail4TinyWithT2)) {
                return;
            }
            map.put("tinyapp_jsapi_stat_within_t2", jsApiDetail4TinyWithT2);
            if (RVKernelUtils.isDebug()) {
                RVLogger.d(f24072a, "tinyapp_jsapi_stat_within_t2: " + jsApiDetail4TinyWithT2);
            }
            jsApiStatTrackStore.setJsApiDetail4TinyWithinT2Uploaded(true);
            jsApiStatTrackStore.clear();
        } catch (Throwable th) {
            RVLogger.e(f24072a, "writeJsApiStatToMap exception", th);
        }
    }

    private boolean a(NativeCallContext nativeCallContext) {
        try {
            return this.sEnableTinyAppJsApiStat && nativeCallContext != null && (nativeCallContext.getNode() instanceof Page) && ((Page) nativeCallContext.getNode()).getApp() != null && ((Page) nativeCallContext.getNode()).getApp().isTinyApp() && ((Page) nativeCallContext.getNode()).getApp().isFirstPage() && this.b.contains(nativeCallContext.getName());
        } catch (Throwable th) {
            RVLogger.e(f24072a, "recordJsApiInfoIfNeeded exception", th);
            return false;
        }
    }
}
