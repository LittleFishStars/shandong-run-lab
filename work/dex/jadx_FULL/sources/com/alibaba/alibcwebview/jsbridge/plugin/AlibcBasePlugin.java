package com.alibaba.alibcwebview.jsbridge.plugin;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcBasePlugin extends AlibcApiPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23731a = "AlibcBasePlugin";

    private void a(AlibcJsCallback alibcJsCallback, String str) {
        String[] strArr;
        try {
            JSONArray jSONArray = JSON.parseObject(str).getJSONArray("apps");
            if (jSONArray != null) {
                strArr = new String[jSONArray.size()];
                for (int i = 0; i < jSONArray.size(); i++) {
                    try {
                        strArr[i] = String.valueOf(jSONArray.get(i));
                    } catch (JSONException e) {
                        e = e;
                        AlibcLogger.e(f23731a, "json parse exception: " + e.getMessage());
                    }
                }
            } else {
                strArr = null;
            }
        } catch (JSONException e2) {
            e = e2;
            strArr = null;
        }
        if (strArr == null) {
            alibcJsCallback.fail(buildResult(AlibcJsEnum.FAIL, null));
            return;
        }
        HashMap map = new HashMap(16);
        for (String str2 : strArr) {
            map.put(str2, Boolean.valueOf(AlibcCommonUtils.isAppInstalled(AlibcBaseTradeCommon.context, str2)));
        }
        alibcJsCallback.success(buildResult(AlibcJsEnum.SUCCESS, map));
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallback alibcJsCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || alibcJsCallback == null) {
            Map<String, Object> mapBuildResult = buildResult(AlibcJsEnum.PARAM_ERR, null);
            if (alibcJsCallback == null) {
                return false;
            }
            alibcJsCallback.fail(mapBuildResult);
            return false;
        }
        if ("getDeviceInfo".equals(str)) {
            HashMap map = new HashMap(16);
            map.put(ze1.k, Build.MODEL);
            map.put("brand", Build.BRAND);
            alibcJsCallback.success(buildResult(AlibcJsEnum.SUCCESS, map));
            return true;
        }
        if ("isInstalled".equals(str)) {
            a(alibcJsCallback, str2);
            return true;
        }
        if (!"closeWebView".equals(str)) {
            "getApplinkKey".equals(str);
            return true;
        }
        Activity activity = (Activity) this.mWebView.getContext();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public String getPluginTag() {
        return "AliBCBase";
    }
}
