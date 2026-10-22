package com.alibaba.ariver.resource.api;

import android.util.Pair;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PluginInstallCallback {
    void onFailed(int i, String str);

    void onSingleFailed(PluginModel pluginModel, int i, String str);

    void onSuccess(List<Pair<PluginModel, String>> list);
}
