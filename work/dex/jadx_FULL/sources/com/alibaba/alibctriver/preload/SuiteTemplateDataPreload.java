package com.alibaba.alibctriver.preload;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.prefetch.mtop.c;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SuiteTemplateDataPreload implements IPreloadJob<Void> {

    public static class SuiteRequestParams extends RequestParams {
        private static final long serialVersionUID = -3730398761225762952L;
        private final Map<String, Object> dataMap;

        public SuiteRequestParams(SendMtopParams sendMtopParams) {
            super(sendMtopParams.getAppId(), sendMtopParams.getStartParams());
            Map<String, String> dataMap = sendMtopParams.getDataMap();
            this.dataMap = new HashMap(dataMap.size());
            if (dataMap.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                this.dataMap.put(entry.getKey(), entry.getValue());
            }
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            return this.dataMap;
        }
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        String str;
        byte[] bArr;
        if (pointType == PreloadScheduler.PointType.DATA_PREFETCH && map != null && map.get("appInfo") != null && map.get("url") != null) {
            String queryParameter = Uri.parse(map.get("url").toString()).getQueryParameter("query");
            if (!TextUtils.isEmpty(queryParameter)) {
                String[] strArrSplit = Uri.decode(queryParameter).split("&");
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].split("=");
                    if (MediationConstant.KEY_USE_POLICY_PAGE_ID.equals(strArrSplit2[0])) {
                        str = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            } else {
                str = null;
                break;
            }
            AppModel appModel = (AppModel) map.get("appInfo");
            if (!TextUtils.isEmpty(str) && appModel != null) {
                try {
                    Uri uri = Uri.parse(AlibcConfigService.getInstance().getConfig().getMisc().getExtConfigApi());
                    SendMtopParams sendMtopParams = new SendMtopParams(appModel.getAppId(), new Bundle());
                    sendMtopParams.api = uri.getHost();
                    sendMtopParams.v = uri.getQueryParameter("version");
                    sendMtopParams.addData("hostAppId", appModel.getAppId());
                    SuiteRequestParams suiteRequestParams = new SuiteRequestParams(sendMtopParams);
                    suiteRequestParams.api = sendMtopParams.api;
                    suiteRequestParams.needLogin = sendMtopParams.needLogin;
                    suiteRequestParams.version = sendMtopParams.v;
                    IMtopProxy iMtopProxy = (IMtopProxy) RVProxy.get(IMtopProxy.class);
                    if (iMtopProxy != null) {
                        c.a(suiteRequestParams);
                        try {
                            SendMtopResponse sendMtopResponseRequestInnerSync = iMtopProxy.requestInnerSync(sendMtopParams);
                            if (sendMtopResponseRequestInnerSync.success && (bArr = sendMtopResponseRequestInnerSync.data) != null && bArr.length > 0) {
                                String str2 = new String(bArr, Charset.forName("UTF-8"));
                                if (!TextUtils.isEmpty(str2)) {
                                    c.a(suiteRequestParams, str2, TROrangeController.getMtopCacheTimeoutBySecond() * 1000);
                                }
                            }
                        } finally {
                            c.a(sendMtopParams.api);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "open-data-prefetch";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Void> getResultClazz() {
        return null;
    }
}
