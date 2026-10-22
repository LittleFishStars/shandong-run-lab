package com.alibaba.alibcwebview.jsbridge.plugin;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.AlibcTradeHelper;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcWebViewPlugin extends AlibcApiPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23732a = "AlibcWebViewPlugin";

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallback alibcJsCallback) {
        Map<String, String> mapCreateUrlParams;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || alibcJsCallback == null) {
            Map<String, Object> mapBuildResult = buildResult(AlibcJsEnum.PARAM_ERR, null);
            if (alibcJsCallback != null) {
                alibcJsCallback.fail(mapBuildResult);
                return false;
            }
        }
        if (!"setYbhpss".equals(str)) {
            return true;
        }
        try {
            Map<String, String> mapObj2MapString = StringUtils.obj2MapString(JSON.parseObject(str2));
            if (mapObj2MapString != null && (mapCreateUrlParams = AlibcTradeHelper.createUrlParams(mapObj2MapString)) != null && mapCreateUrlParams.size() > 0 && AlibcTradeContext.getInstance() != null) {
                for (Map.Entry<String, String> entry : mapCreateUrlParams.entrySet()) {
                    AlibcTradeContext.getInstance().trackParams.put(entry.getKey(), entry.getValue());
                }
            }
            alibcJsCallback.success(buildResult(AlibcJsEnum.SUCCESS, new HashMap(16)));
            return true;
        } catch (Exception e) {
            AlibcLogger.e(f23732a, "parse json object exception: " + e.getMessage());
            return true;
        }
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public String getPluginTag() {
        return "AliBCWebView";
    }
}
