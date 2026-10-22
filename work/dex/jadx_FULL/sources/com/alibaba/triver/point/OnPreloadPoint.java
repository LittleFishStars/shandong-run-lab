package com.alibaba.triver.point;

import android.os.Bundle;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface OnPreloadPoint extends Extension {
    void afterParsePackages(App app, PluginModel pluginModel, String str);

    void appInfoPointPreload(String str, long j, AppModel appModel, Bundle bundle);

    void closeAppPointPreload(App app);

    void createActivityPreload(Map<String, Object> map);

    void createAppContext(App app);

    void dataPrefetch(AppNode appNode, String str, long j, AppModel appModel, Bundle bundle);

    void openPagePointPreload(Page page);

    void prepareResources(AppModel appModel, PluginModel pluginModel, String str);

    void processCreatedPointPreload();

    void processDiedPreload();

    void resourcePointPreload();
}
