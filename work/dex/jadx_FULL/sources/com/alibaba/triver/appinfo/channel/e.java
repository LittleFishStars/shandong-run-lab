package com.alibaba.triver.appinfo.channel;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.network.CommonResponse;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24636a = "ERR_DOWNGRADE_TO_DEFAULT_REQUEST";

    public static CommonResponse<List<TriverAppModel>, JSONObject> a() {
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponse = new CommonResponse<>();
        commonResponse.success = false;
        commonResponse.errorCode = f24636a;
        commonResponse.errorMsg = "出现异常降级到mtop请求";
        return commonResponse;
    }

    public static boolean a(CommonResponse<List<TriverAppModel>, JSONObject> commonResponse) {
        return commonResponse == null || TextUtils.equals(f24636a, commonResponse.errorCode);
    }
}
