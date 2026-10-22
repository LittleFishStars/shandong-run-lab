package com.alibaba.triver.triver_render.render;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alipay.sdk.m.y.l;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25222a = "WVRenderUtils";

    public static String a(Page page) {
        return "bridge_token_" + page.getNodeId();
    }

    public static String b(Map<String, String> map, Page page, String str) throws Throwable {
        String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "render_h5_bridge.js");
        if (TextUtils.isEmpty(asset)) {
            RVLogger.d(f25222a, "no bridge data defined!");
            return asset;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            sb.append(";AlipayJSBridge.");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(l.b);
        }
        if (TextUtils.isEmpty(sb.toString())) {
            RVLogger.d(f25222a, "no params data defined!");
        } else {
            asset = asset.replace("AlipayJSBridge.startupParams='{startupParams}'", sb.toString());
        }
        return asset.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from core raw\");").replace("'{APVIEWID}'", str).replace("{bridge_token}", page != null ? a(page) : "");
    }

    public static String a(Map<String, String> map, Page page, String str) throws Throwable {
        String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), TRiverConstants.H5_BRIDGE_PART2_NAME);
        if (TextUtils.isEmpty(asset)) {
            RVLogger.d(f25222a, "no bridge data defined!");
            return asset;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            sb.append(";window.AlipayJSBridge.");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(l.b);
        }
        if (TextUtils.isEmpty(sb.toString())) {
            RVLogger.d(f25222a, "no params data defined!");
        } else {
            asset = asset.replace("AlipayJSBridge.startupParams='{startupParams}'", sb.toString());
        }
        return asset.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from core raw\");").replace("'{APVIEWID}'", str);
    }

    public static boolean a() {
        try {
            return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("closeGoBackEvent", false);
        } catch (Exception e) {
            RVLogger.e(f25222a, "closeGoBackEvent error", e);
            return false;
        }
    }
}
