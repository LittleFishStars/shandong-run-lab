package com.alibaba.alibctriver.extensions;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.FuncDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.model.SuiteDO;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.triver.kit.api.point.FirstScreenLoadedPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcAppLoadedExtension implements FirstScreenLoadedPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23659a = "AlibcAppLoadedExtension";
    private AtomicInteger b = new AtomicInteger(0);

    private boolean a(String str) {
        PageDO page;
        List<SuiteDO> suites;
        if (!TextUtils.isEmpty(str) && (page = AlibcConfigService.getInstance().getPage()) != null && (suites = page.getSuites()) != null && suites.size() > 0) {
            Iterator<SuiteDO> it = suites.iterator();
            while (it.hasNext()) {
                List<FuncDO> funcs = it.next().getFuncs();
                if (funcs != null && funcs.size() > 0) {
                    Iterator<FuncDO> it2 = funcs.iterator();
                    while (it2.hasNext()) {
                        if (str.equals(it2.next().getAppId())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.kit.api.point.FirstScreenLoadedPoint
    public void onScreenAppLoaded(App app) {
    }

    @Override // com.alibaba.triver.kit.api.point.FirstScreenLoadedPoint
    public boolean onScreenPageLoaded(Page page) {
        Map<String, PluginModel> dynamicPluginModelMap;
        if (page == null || page.getSceneParams() == null) {
            return false;
        }
        String pageURI = page.getPageURI();
        if (TextUtils.isEmpty(pageURI)) {
            return false;
        }
        if (!pageURI.contains(PluginParamModel.PLUGIN_PAGE_PREFIX)) {
            this.b.incrementAndGet();
            return false;
        }
        PluginStore pluginStore = (PluginStore) page.getApp().getData(PluginStore.class);
        if (pluginStore != null && (dynamicPluginModelMap = pluginStore.getDynamicPluginModelMap()) != null) {
            Iterator<Map.Entry<String, PluginModel>> it = dynamicPluginModelMap.entrySet().iterator();
            while (it.hasNext()) {
                if (a(it.next().getKey()) && 1 == this.b.get()) {
                    this.b.decrementAndGet();
                    return true;
                }
            }
        }
        return false;
    }
}
