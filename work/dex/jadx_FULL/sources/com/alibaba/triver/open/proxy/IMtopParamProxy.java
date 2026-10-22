package com.alibaba.triver.open.proxy;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IMtopParamProxy extends Proxiable {
    void parseMtopParam(JSONObject jSONObject, Bundle bundle, String str, AppModel appModel);
}
