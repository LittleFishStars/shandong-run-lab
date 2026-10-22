package com.aliyun.openplatform20191219;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadRequest;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadResponse;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teaopenapi.models.OpenApiRequest;
import com.aliyun.teaopenapi.models.Params;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client extends com.aliyun.teaopenapi.Client {
    public Client(Config config) throws Exception {
        super(config);
        this._endpointRule = "";
        checkConfig(config);
        this._endpoint = getEndpoint("openplatform", this._regionId, this._endpointRule, this._network, this._suffix, this._endpointMap, this._endpoint);
    }

    public AuthorizeFileUploadResponse authorizeFileUpload(AuthorizeFileUploadRequest authorizeFileUploadRequest) throws Exception {
        return authorizeFileUploadWithOptions(authorizeFileUploadRequest, new RuntimeOptions());
    }

    public AuthorizeFileUploadResponse authorizeFileUploadWithOptions(AuthorizeFileUploadRequest authorizeFileUploadRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(authorizeFileUploadRequest);
        return (AuthorizeFileUploadResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "AuthorizeFileUpload"), new TeaPair("version", "2019-12-19"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "GET"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("query", com.aliyun.openapiutil.Client.query(com.aliyun.openapiutil.Client.query(Common.toMap(authorizeFileUploadRequest)))))), runtimeOptions), new AuthorizeFileUploadResponse());
    }

    public String getEndpoint(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) throws Exception {
        if (Common.empty(str6)) {
            return (Common.isUnset(map) || Common.empty(map.get(str2))) ? com.aliyun.endpointutil.Client.getEndpointRules(str, str2, str3, str4, str5) : map.get(str2);
        }
        return str6;
    }
}
