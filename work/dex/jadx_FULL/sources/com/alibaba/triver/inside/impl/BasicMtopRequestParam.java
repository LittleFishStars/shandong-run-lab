package com.alibaba.triver.inside.impl;

import android.os.Bundle;
import com.alibaba.triver.kit.api.model.RequestParams;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BasicMtopRequestParam extends RequestParams {
    Map<String, Object> mapData;

    public BasicMtopRequestParam(String str, Bundle bundle, Map<String, String> map) {
        super(str, bundle);
        this.mapData = null;
        HashMap map2 = new HashMap();
        this.mapData = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    @Override // com.alibaba.triver.kit.api.model.RequestParams
    public Map<String, Object> toMap() {
        return this.mapData;
    }
}
