package com.alibaba.triver.appinfo.core;

import androidx.annotation.WorkerThread;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface a {
    @WorkerThread
    void a(String str, String str2, String str3, JSONObject jSONObject);

    @WorkerThread
    void a(String str, List<AppModel> list);
}
