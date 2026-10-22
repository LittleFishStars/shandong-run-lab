package com.alibaba.triver.extensions;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.point.TriverOpenModeProxy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefOpenModeExtension implements TriverOpenModeProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24949a = 2;

    private int a() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("maxInstanceCount");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int i = Integer.parseInt(str);
                    if (i < 2) {
                        return 2;
                    }
                    return i;
                } catch (Exception e) {
                    RVLogger.e("TROrangeController", "getMaxInstanceCount parseInt error", e);
                }
            }
        }
        return 2;
    }

    @Override // com.alibaba.triver.point.TriverOpenModeProxy
    public int getMaxInstanceCount(String str, Uri uri) {
        return a();
    }

    @Override // com.alibaba.triver.point.TriverOpenModeProxy
    public TriverOpenModeProxy.OpenMode getOpenMode(String str, Uri uri, List<RVAppRecord> list) {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str2 = configsByGroup.get("multiInstanceWhiteList");
                if (!TextUtils.isEmpty(str2)) {
                    for (Object obj : JSON.parseArray(str2)) {
                        if ((obj instanceof String) && TextUtils.equals((String) obj, str)) {
                            return TriverOpenModeProxy.OpenMode.MULTI_INSTANCE;
                        }
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e("TriverOpenModePoint", "getOpenMode error", e);
        }
        return TriverOpenModeProxy.OpenMode.SINGLE_INSTANCE;
    }

    @Override // com.alibaba.triver.point.TriverOpenModeProxy
    public TriverOpenModeProxy.SingleMode getSingleMode(String str, Uri uri) {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup != null) {
                String str2 = configsByGroup.get("getSingleMode");
                if (TextUtils.isEmpty(str2) || !"clearTop".equalsIgnoreCase(str2)) {
                    Log.e("DefOpenModeExtension", "getSingleMode newInstance");
                    return TriverOpenModeProxy.SingleMode.NEW_INSTANCE;
                }
                Log.e("DefOpenModeExtension", "getSingleMode clearTop");
                return TriverOpenModeProxy.SingleMode.CLEAR_TOP;
            }
        } catch (Throwable th) {
            Log.e("DefOpenModeExtension", "getSingleMode exception", th);
        }
        return TriverOpenModeProxy.SingleMode.NEW_INSTANCE;
    }
}
