package com.alibaba.triver.appinfo.channel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface d {
    RouterConfigModel.GuardConfig a();

    CommonResponse<List<TriverAppModel>, JSONObject> a(AppRequestParams appRequestParams);

    void a(RouterConfigModel.ChannelModel channelModel);
}
