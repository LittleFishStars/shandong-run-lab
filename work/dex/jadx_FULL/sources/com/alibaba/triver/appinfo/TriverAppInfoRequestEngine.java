package com.alibaba.triver.appinfo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.room.FtsOptions;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.channel.AppInfoDefaultRequestClient;
import com.alibaba.triver.appinfo.channel.AppInfoMtopRequestClient;
import com.alibaba.triver.appinfo.channel.AppInfoResult;
import com.alibaba.triver.appinfo.channel.RouterConfigModel;
import com.alibaba.triver.appinfo.channel.TriverAppModel;
import com.alibaba.triver.appinfo.channel.b;
import com.alibaba.triver.appinfo.channel.c;
import com.alibaba.triver.appinfo.channel.d;
import com.alibaba.triver.appinfo.core.AppInfoClient;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.utils.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAppInfoRequestEngine implements AppInfoClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24626a = "AppInfoCenter";

    private boolean a(AppRequestParams appRequestParams) {
        JSONArray requests;
        return (appRequestParams == null || (requests = appRequestParams.getRequests()) == null || requests.size() <= 1) ? false : true;
    }

    private boolean b(AppRequestParams appRequestParams) {
        Bundle bundle;
        return (appRequestParams == null || (bundle = appRequestParams.startParams) == null || !bundle.getBoolean("mtopDefault")) ? false : true;
    }

    @Override // com.alibaba.triver.appinfo.core.AppInfoClient
    public boolean needCache(AppRequestParams appRequestParams) {
        if (appRequestParams == null) {
            return true;
        }
        return appRequestParams.needCache;
    }

    @Override // com.alibaba.triver.appinfo.core.AppInfoClient
    public AppInfoResult requestAppInfo(AppRequestParams appRequestParams) {
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponseA;
        String str;
        RouterConfigModel.ChannelModel channelModelB;
        String str2 = appRequestParams.oriUrl;
        Pair<String, String> pair = appRequestParams.mainRequest;
        String str3 = pair != null ? (String) pair.first : null;
        RouterConfigModel.ChannelModel channelModelA = (TextUtils.isEmpty(str3) || appRequestParams.notOnline || CommonUtils.closeAppInfoRouter() || !ProcessUtils.isMainProcess() || a(appRequestParams) || b(appRequestParams)) ? null : com.alibaba.triver.appinfo.channel.a.a().a(str3, str2);
        if (channelModelA != null) {
            d dVarA = a(channelModelA);
            str = channelModelA.name;
            RVLogger.d("AppInfoCenter", str3 + " channel " + str + " start request.");
            commonResponseA = dVarA.a(appRequestParams);
            if (commonResponseA.success) {
                String strA = a(str3, commonResponseA.successData);
                if (TextUtils.isEmpty(strA)) {
                    return new AppInfoResult(str, commonResponseA.successData);
                }
                if (dVarA.a() == null || dVarA.a().errorCode == null) {
                    return new AppInfoResult(str, commonResponseA.successData);
                }
                Iterator<String> it = dVarA.a().errorCode.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        channelModelB = null;
                        break;
                    }
                    if (TextUtils.equals(it.next(), strA)) {
                        channelModelB = com.alibaba.triver.appinfo.channel.a.a().b(dVarA.a().channel);
                        break;
                    }
                }
                if (channelModelB == null) {
                    return new AppInfoResult(str, commonResponseA.successData);
                }
                d dVarA2 = a(channelModelB);
                RVLogger.d("AppInfoCenter", str3 + " channel " + str + " request fail, guardChannel " + channelModelB.name + " request start.");
                commonResponseA = dVarA2.a(appRequestParams);
                if (commonResponseA.success) {
                    return new AppInfoResult(str, commonResponseA.successData);
                }
            } else if (!TROrangeController.closeCdnRequestDowngrade()) {
                RVLogger.d("AppInfoCenter", str3 + str + " request downgrade to default, start request.");
                commonResponseA = new AppInfoDefaultRequestClient().a(appRequestParams);
                if (commonResponseA.success) {
                    return new AppInfoResult(str, commonResponseA.successData);
                }
            }
        } else {
            RVLogger.d("AppInfoCenter", str3 + " channel default start request.");
            commonResponseA = new AppInfoDefaultRequestClient().a(appRequestParams);
            if (commonResponseA.success) {
                return new AppInfoResult("default", commonResponseA.successData);
            }
            str = "default";
        }
        RVLogger.d("AppInfoCenter", str3 + " channel " + str + " request fail.");
        Pair<String, String> pair2 = appRequestParams.mainRequest;
        if (pair2 == null || TextUtils.isEmpty((CharSequence) pair2.first)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TriverAppModel triverAppModel = new TriverAppModel();
        triverAppModel.success = false;
        triverAppModel.errorCode = commonResponseA.errorCode;
        triverAppModel.errorMsg = commonResponseA.errorMsg;
        triverAppModel.extInfo = commonResponseA.errorData;
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId((String) appRequestParams.mainRequest.first);
        triverAppModel.setAppInfoModel(appInfoModel);
        arrayList.add(triverAppModel);
        return new AppInfoResult(str, arrayList);
    }

    private d a(RouterConfigModel.ChannelModel channelModel) {
        if (TextUtils.equals("mtop", channelModel.type)) {
            AppInfoMtopRequestClient appInfoMtopRequestClient = new AppInfoMtopRequestClient();
            appInfoMtopRequestClient.a(channelModel);
            return appInfoMtopRequestClient;
        }
        if (TextUtils.equals("http", channelModel.type)) {
            b bVar = new b();
            bVar.a(channelModel);
            return bVar;
        }
        if (TextUtils.equals(FtsOptions.TOKENIZER_SIMPLE, channelModel.type)) {
            c cVar = new c();
            cVar.a(channelModel);
            return cVar;
        }
        return new AppInfoDefaultRequestClient();
    }

    private String a(String str, List<TriverAppModel> list) {
        for (TriverAppModel triverAppModel : list) {
            if (!triverAppModel.success && TextUtils.equals(triverAppModel.getAppId(), str)) {
                return triverAppModel.errorCode;
            }
        }
        return null;
    }
}
