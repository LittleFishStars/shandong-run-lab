package com.alibaba.ariver.resource.api;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONObject;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVResourceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24418a = "checkPermission";

    public static int compareVersion(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str2 != null && str2.length() != 0) {
                        if (!str.contains("*") && !str2.contains("*")) {
                            String[] strArrSplit = str.split("\\.");
                            String[] strArrSplit2 = str2.split("\\.");
                            int length = strArrSplit.length;
                            int length2 = strArrSplit2.length;
                            int iMin = Math.min(length, length2);
                            for (int i = 0; i < iMin; i++) {
                                long j = TypeUtils.parseLong(strArrSplit[i]);
                                long j2 = TypeUtils.parseLong(strArrSplit2[i]);
                                if (j > j2) {
                                    return 1;
                                }
                                if (j < j2) {
                                    return -1;
                                }
                            }
                            if (length > length2) {
                                while (iMin < length) {
                                    if (TypeUtils.parseLong(strArrSplit[iMin]) > 0) {
                                        return 1;
                                    }
                                    iMin++;
                                }
                            } else if (length < length2) {
                                while (iMin < length2) {
                                    if (TypeUtils.parseLong(strArrSplit2[iMin]) > 0) {
                                        return -1;
                                    }
                                    iMin++;
                                }
                            }
                        }
                        return 0;
                    }
                    return 1;
                }
                if (str2 == null && str2.length() != 0) {
                    return -1;
                }
            } catch (Exception e) {
                RVLogger.e(RVConstants.RESOURCE_TAG, "compareVersion exception!", e);
            }
        } else if (str2 == null) {
        }
        return 0;
    }

    @Nullable
    public static File getExtDirectory(AppModel appModel, boolean z) {
        String strCombinePath = FileUtils.combinePath(((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel), "ariver_ext_" + appModel.getAppVersion());
        if (TextUtils.isEmpty(strCombinePath)) {
            return null;
        }
        File file = new File(strCombinePath);
        if (!z || file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static boolean needSkipPermissionCheck(Node node) {
        AppModel appModel;
        JSONObject extendInfos;
        JSONObject jSONObject;
        App app = (App) node.bubbleFindNode(App.class);
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (extendInfos = appModel.getExtendInfos()) == null || (jSONObject = JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_LAUNCH_PARAMS, null)) == null) {
            return false;
        }
        return "NO".equalsIgnoreCase(JSONUtils.getString(jSONObject, f24418a, "YES"));
    }
}
