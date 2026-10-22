package com.alibaba.triver.appinfo;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.channel.AppInfoDefaultRequestClient;
import com.alibaba.triver.appinfo.channel.AppInfoResult;
import com.alibaba.triver.appinfo.channel.TriverAppModel;
import com.alibaba.triver.appinfo.core.AppInfoClient;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoRequestEngine implements AppInfoClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24625a = "AppInfoCenter";

    @Override // com.alibaba.triver.appinfo.core.AppInfoClient
    public boolean needCache(AppRequestParams appRequestParams) {
        return false;
    }

    @Override // com.alibaba.triver.appinfo.core.AppInfoClient
    public AppInfoResult requestAppInfo(AppRequestParams appRequestParams) {
        Pair<String, String> pair = appRequestParams.mainRequest;
        String str = pair != null ? (String) pair.first : null;
        RVLogger.d("AppInfoCenter", str + " channel default start request.");
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponseA = new AppInfoDefaultRequestClient().a(appRequestParams);
        if (commonResponseA.success) {
            List<TriverAppModel> list = commonResponseA.successData;
            for (TriverAppModel triverAppModel : list) {
                if (triverAppModel != null) {
                    JSONObject extendInfos = triverAppModel.getExtendInfos();
                    if (extendInfos == null) {
                        extendInfos = new JSONObject();
                        triverAppModel.setExtendInfos(extendInfos);
                    }
                    extendInfos.put("appChannel", (Object) 4);
                }
            }
            return new AppInfoResult("default", list);
        }
        RVLogger.d("AppInfoCenter", str + " channel default request fail.");
        Pair<String, String> pair2 = appRequestParams.mainRequest;
        if (pair2 == null || TextUtils.isEmpty((CharSequence) pair2.first)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TriverAppModel triverAppModel2 = new TriverAppModel();
        triverAppModel2.success = false;
        triverAppModel2.errorCode = commonResponseA.errorCode;
        triverAppModel2.errorMsg = commonResponseA.errorMsg;
        triverAppModel2.extInfo = commonResponseA.errorData;
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId((String) appRequestParams.mainRequest.first);
        triverAppModel2.setAppInfoModel(appInfoModel);
        arrayList.add(triverAppModel2);
        return new AppInfoResult("default", arrayList);
    }
}
