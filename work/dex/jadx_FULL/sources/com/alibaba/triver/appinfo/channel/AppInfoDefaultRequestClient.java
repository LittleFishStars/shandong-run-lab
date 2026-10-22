package com.alibaba.triver.appinfo.channel;

import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoDefaultRequestClient extends SyncRequestClient<AppInfoRequestParams, List<TriverAppModel>, JSONObject> implements d {

    public class AppInfoRequestParams extends RequestParams {
        AppRequestParams mParams;

        /* JADX WARN: Illegal instructions before constructor call */
        public AppInfoRequestParams(AppRequestParams appRequestParams) {
            Pair<String, String> pair = appRequestParams.mainRequest;
            super(pair != null ? (String) pair.first : null, appRequestParams.startParams);
            this.mParams = appRequestParams;
            this.api = "mtop.taobao.miniapp.fusion.appinfo.get";
            this.version = "1.0";
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("apps", JSON.toJSONString(this.mParams.getRequests()));
            map.put("sdk_version", TRiverConstants.REQUEST_SDK_VERSION);
            return map;
        }
    }

    public static class DataDO implements Serializable {
        public ResultDO data;
    }

    public static class ResultDO implements Serializable {
        public List<TriverAppModel> result;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public RouterConfigModel.GuardConfig a() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<TriverAppModel> configSuccessResponse(byte[] bArr) {
        ResultDO resultDO;
        DataDO dataDO = (DataDO) JSON.parseObject(bArr, DataDO.class, new Feature[0]);
        if (dataDO == null || (resultDO = dataDO.data) == null) {
            return null;
        }
        return resultDO.result;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public void a(RouterConfigModel.ChannelModel channelModel) {
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject configFailureResponse(byte[] bArr) {
        JSONObject object = JSON.parseObject(new String(bArr));
        if (object != null) {
            return object.getJSONObject("data");
        }
        return null;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public CommonResponse<List<TriverAppModel>, JSONObject> a(AppRequestParams appRequestParams) {
        AppInfoRequestParams appInfoRequestParams = new AppInfoRequestParams(appRequestParams);
        this.mParams = appInfoRequestParams;
        return execute(appInfoRequestParams);
    }
}
