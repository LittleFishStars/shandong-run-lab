package com.alibaba.ariver.resource.api.preset;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PresetUtils {
    public static AppModel getPresetAppModel(String str) {
        Map<String, AppModel> presetAppInfos;
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        if (rVResourcePresetProxy == null || (presetAppInfos = rVResourcePresetProxy.getPresetAppInfos()) == null) {
            return null;
        }
        return presetAppInfos.get(str);
    }
}
