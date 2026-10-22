package com.alibaba.ariver.app.api.point.app;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AppCreateMenuPoint extends Extension {

    @Keep
    public static class Action {
        public String method;
        public JSONObject params;
    }

    @Keep
    public enum Type {
        ABOUT
    }

    Action createMenuAction(App app, Type type);
}
