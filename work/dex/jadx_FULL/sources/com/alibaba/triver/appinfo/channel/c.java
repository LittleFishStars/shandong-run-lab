package com.alibaba.triver.appinfo.channel;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements d {
    private static final String b = "extObj";
    private static final String c = "templateId";
    private static final String d = "appKey";
    private static final String e = "bizType";
    private static final String f = "subBizType";
    private static final String g = "name";
    private static final String h = "logo";
    private static final String i = "sellerId";
    private static final String j = "sellerInfo";
    private static final String k = "https://ossgw.alicdn.com/taobao-miniapp/img/115f7014ed38112fc14286a137c5dd9a.png";
    private static final String l = "旗舰店";
    private static final String m = "AppInfoSimpleRequestClient";
    private static final String n = "ASSEMBLE_APPINFO_ERROR";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouterConfigModel.ChannelModel f24635a;

    /* JADX WARN: Type inference failed for: r0v24, types: [T, java.util.ArrayList, java.util.List] */
    @Override // com.alibaba.triver.appinfo.channel.d
    public CommonResponse<List<TriverAppModel>, JSONObject> a(AppRequestParams appRequestParams) {
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponse;
        String str;
        String str2 = appRequestParams.oriUrl;
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponse2 = new CommonResponse<>();
        commonResponse2.success = false;
        if (com.alibaba.triver.appinfo.a.a.d()) {
            RVLogger.e(m, "simple request closed");
            return commonResponse2;
        }
        if (TextUtils.isEmpty(str2)) {
            RVLogger.e(m, "url is empty");
            commonResponse2.errorCode = "EMPTY_URL";
            commonResponse2.errorMsg = "url is empty";
            return commonResponse2;
        }
        Uri uri = Uri.parse(str2);
        Pair<String, String> pair = appRequestParams.mainRequest;
        String str3 = pair != null ? (String) pair.first : null;
        String queryParameter = uri.getQueryParameter("appKey");
        String queryParameter2 = uri.getQueryParameter(c);
        String queryParameter3 = uri.getQueryParameter(b);
        String queryParameter4 = uri.getQueryParameter("bizType");
        String queryParameter5 = uri.getQueryParameter("subBizType");
        String queryParameter6 = uri.getQueryParameter("name");
        String queryParameter7 = uri.getQueryParameter(h);
        String queryParameter8 = uri.getQueryParameter(i);
        if (!a(uri) || TextUtils.isEmpty(str3)) {
            RVLogger.e(m, "necessary url params lacked");
            commonResponse2.errorCode = "NECESSARY_URL_PARAMS_LACKED";
            commonResponse2.errorMsg = "necessary url params lacked";
            return commonResponse2;
        }
        if (!com.alibaba.triver.appinfo.a.a.c(queryParameter2)) {
            RVLogger.e(m, "invalid templateId");
            commonResponse2.errorCode = "INVALID_TEMPLATEID";
            commonResponse2.errorMsg = "templateId isn't in white list";
            return commonResponse2;
        }
        try {
            AppModel appModelA = com.alibaba.triver.appinfo.a.a.a(queryParameter2);
            if (appModelA == null && (appModelA = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(new AppInfoQuery(queryParameter2))) == null) {
                RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
                if (rVResourcePresetProxy instanceof f) {
                    appModelA = ((f) rVResourcePresetProxy).getPresetTemplateAppInfo(queryParameter2);
                }
                if (appModelA == null) {
                    appModelA = appModelA;
                    RVLogger.e(m, "templateInfo not exists");
                    commonResponse2.errorCode = "TEMPLATEINFO_NOT_EXISTS";
                    commonResponse2.errorMsg = "templateId's templateInfo isn't exist";
                    return commonResponse2;
                }
            }
            appModelA = appModelA;
            TriverAppModel triverAppModel = (TriverAppModel) JSON.parseObject(JSON.toJSONString(appModelA), TriverAppModel.class);
            AppInfoModel appInfoModel = triverAppModel.getAppInfoModel();
            if (appInfoModel == null) {
                return commonResponse2;
            }
            try {
                TemplateConfigModel templateConfig = appInfoModel.getTemplateConfig();
                if (templateConfig == null || TextUtils.isEmpty(templateConfig.getTemplateId()) || !templateConfig.getTemplateId().equals(queryParameter2)) {
                    commonResponse = commonResponse2;
                    str = m;
                    try {
                        RVLogger.e(str, "invalid templateInfo");
                        commonResponse.errorCode = "INVALID_TEMPLATEINFO";
                        commonResponse.errorMsg = "templateId don't match with cached templateInfo";
                        return commonResponse;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    TemplateExtModel extModel = templateConfig.getExtModel();
                    try {
                        extModel.setExtEnable(true);
                        if (!TextUtils.isEmpty(queryParameter3)) {
                            try {
                                extModel.setExtObj(JSON.parseObject(queryParameter3));
                            } catch (Exception e3) {
                                e = e3;
                                str = m;
                                commonResponse = commonResponse2;
                            }
                        }
                        JSONObject extendInfos = triverAppModel.getExtendInfos();
                        if (!TextUtils.isEmpty(queryParameter8)) {
                            HashMap map = new HashMap();
                            map.put(i, queryParameter8);
                            extendInfos.put(j, (Object) map);
                        }
                        if (!TextUtils.isEmpty(queryParameter4) && TextUtils.isDigitsOnly(queryParameter4)) {
                            extendInfos.put("bizType", (Object) Integer.valueOf(queryParameter4));
                        }
                        if (!TextUtils.isEmpty(queryParameter5) && TextUtils.isDigitsOnly(queryParameter5)) {
                            extendInfos.put("subBizType", (Object) Integer.valueOf(queryParameter5));
                        }
                        if (appInfoModel.getVhost().contains(queryParameter2)) {
                            appInfoModel.setVhost(appInfoModel.getVhost().replace(queryParameter2, str3));
                        }
                        appInfoModel.setAppId(str3);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            appInfoModel.setAppKey(queryParameter);
                        }
                        if (TextUtils.isEmpty(queryParameter6)) {
                            queryParameter6 = l;
                        }
                        appInfoModel.setName(queryParameter6);
                        appInfoModel.setLogo(TextUtils.isEmpty(queryParameter7) ? k : queryParameter7);
                        appInfoModel.setTemplateConfig(templateConfig);
                        triverAppModel.setAppInfoModel(appInfoModel);
                        ?? arrayList = new ArrayList();
                        triverAppModel.success = true;
                        arrayList.add(triverAppModel);
                        commonResponse = commonResponse2;
                        try {
                            commonResponse.success = true;
                            commonResponse.successData = arrayList;
                            appRequestParams.needCache = false;
                            return commonResponse;
                        } catch (Exception e4) {
                            e = e4;
                            str = m;
                            RVLogger.e(str, "get AppModel error", e);
                            commonResponse.errorCode = e.getMessage();
                            commonResponse.errorMsg = e.getMessage();
                            return commonResponse;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        commonResponse = commonResponse2;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                commonResponse = commonResponse2;
            }
            RVLogger.e(str, "get AppModel error", e);
            commonResponse.errorCode = e.getMessage();
            commonResponse.errorMsg = e.getMessage();
            return commonResponse;
        } catch (Exception e7) {
            e = e7;
            commonResponse = commonResponse2;
            str = m;
        }
    }

    private boolean a(Uri uri) {
        for (String str : com.alibaba.triver.appinfo.a.a.e()) {
            String queryParameter = uri.getQueryParameter(str);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            if ("bizType".equals(str) || "subBizType".equals(str)) {
                if (!TextUtils.isDigitsOnly(queryParameter)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public void a(RouterConfigModel.ChannelModel channelModel) {
        this.f24635a = channelModel;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public RouterConfigModel.GuardConfig a() {
        RouterConfigModel.ChannelModel channelModel = this.f24635a;
        if (channelModel != null) {
            return channelModel.guardConfig;
        }
        return null;
    }
}
