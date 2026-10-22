package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PrepareCallbackParam {
    public StartAction action;

    @Nullable
    public AppModel appInfo;
    public boolean needWaitIpc;

    @Nullable
    public Bundle sceneParams;

    @Nullable
    public Bundle startParams;

    public PrepareCallbackParam(PrepareContext prepareContext) {
        this.appInfo = prepareContext.getAppModel();
        this.startParams = prepareContext.getStartParams();
        this.sceneParams = prepareContext.getSceneParams();
    }

    public String toString() {
        return "PrepareCallbackParam{, needWaitIpc=" + this.needWaitIpc + ", action=" + this.action + '}';
    }
}
