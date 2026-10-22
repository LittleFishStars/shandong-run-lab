package com.alibaba.triver.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TinyAppInnerProxyImpl implements TinyAppInnerProxy {
    @Override // com.alibaba.ariver.app.api.service.TinyAppInnerProxy
    public boolean isEmbedWebViewInnerAppBlack(Page page) {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.service.TinyAppInnerProxy
    public boolean isInner(App app) {
        JSONObject extendInfos;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        return (appModel == null || (extendInfos = appModel.getExtendInfos()) == null || 5 != extendInfos.getIntValue("appChannel")) ? false : true;
    }
}
