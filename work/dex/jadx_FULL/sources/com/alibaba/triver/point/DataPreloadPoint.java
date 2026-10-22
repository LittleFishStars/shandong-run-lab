package com.alibaba.triver.point;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface DataPreloadPoint extends Extension {
    boolean onPreload(String str, long j, List<JSONObject> list);
}
