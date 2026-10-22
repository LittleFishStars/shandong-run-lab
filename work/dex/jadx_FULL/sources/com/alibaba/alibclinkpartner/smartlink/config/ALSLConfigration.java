package com.alibaba.alibclinkpartner.smartlink.config;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.a.a;
import com.alibaba.alibclinkpartner.smartlink.b.a.h;
import com.alibaba.alibclinkpartner.smartlink.b.a.l;
import com.alibaba.alibclinkpartner.smartlink.b.a.m;
import com.alibaba.alibclinkpartner.smartlink.callback.ALSLLocalConfig;
import com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback;
import com.alibaba.alibclinkpartner.smartlink.callback.SmartLinkDataGetCallback;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLConfigConstants;
import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkData;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;
import com.alibaba.alibclinkpartner.smartlink.manager.b;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.c;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLConfigration {
    private static final String MATRIX_APP_REQUEST_URL = "https://userlink.alicdn.com/matrix_app/android/matrix_app_config.json";
    public static final String SAFE_PACKAGE_URL = "https://userlink.alicdn.com/matrix_app/android/safe_package_config.json";
    private static final String SMART_LINK_REQUEST_URL = "https://userlink.alicdn.com/smart_link/smart_link_config.json";
    public static final String SMART_LINK_SWITCH_URL = "https://userlink.alicdn.com/smart_link/android/alsl_switch_config.json";
    public static SmartLinkData sSmartLinkData = new SmartLinkData();
    public static MAtrixAppData sMatrixAPPData = new MAtrixAppData();

    public static void getMatrixAppDetailData(MatrixDataGetCallback matrixDataGetCallback) throws Throwable {
        f.a(ALSLConfigConstants.LAST_MATRIX_CONFIG_REQUEST_TIME, Long.valueOf(System.currentTimeMillis()));
        b.a(new com.alibaba.alibclinkpartner.smartlink.b.a.f());
        com.alibaba.alibclinkpartner.smartlink.a.b bVarA = a.a(MATRIX_APP_REQUEST_URL, (Map<String, String>) null);
        MAtrixAppData mAtrixAppDataA = c.a(bVarA.b);
        if (mAtrixAppDataA != null && !com.alibaba.alibclinkpartner.smartlink.util.b.a(bVarA.b, mAtrixAppDataA.sign)) {
            matrixDataGetCallback.getData(new MAtrixAppData());
            return;
        }
        matrixDataGetCallback.getData(mAtrixAppDataA);
        ALSLLogUtil.d("ALSLConfigration", "getMatrixAppDetailData", "拉到的矩阵APP信息：" + bVarA.b);
        if (bVarA.f23568a == 200) {
            b.a(new h());
            f.a(ALSLConfigConstants.LAST_MATRIX_CONFIG_DETECT_TIME, Long.valueOf(System.currentTimeMillis()));
        }
        if (TextUtils.equals(sMatrixAPPData.version, mAtrixAppDataA.version)) {
            return;
        }
        sMatrixAPPData = mAtrixAppDataA;
        f.c(ALSLConfigConstants.MATRIX_CONFIG_DATA, mAtrixAppDataA);
    }

    public static void getMatrixAppList(Application application) {
        com.alibaba.alibclinkpartner.smartlink.a.a(new Runnable() { // from class: com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.1
            @Override // java.lang.Runnable
            public void run() {
                Map<String, MatrixAppInfoDetail> map = ALSLConfigration.sMatrixAPPData.appinfo;
                if (map == null || map.size() == 0) {
                    ALSLConfigration.sMatrixAPPData = (MAtrixAppData) f.d(ALSLConfigConstants.MATRIX_CONFIG_DATA, new MAtrixAppData());
                }
                Map<String, MatrixAppInfoDetail> map2 = ALSLConfigration.sMatrixAPPData.appinfo;
                if (map2 == null || map2.size() == 0) {
                    ALSLConfigration.sMatrixAPPData = c.a(ALSLLocalConfig.LOCAL_CONFIG);
                }
            }
        });
    }

    public static void getSmartLinkData(Context context, String str) throws Throwable {
        requestSmartLinkData(str, new SmartLinkDataGetCallback() { // from class: com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.2
            @Override // com.alibaba.alibclinkpartner.smartlink.callback.SmartLinkDataGetCallback
            public void getData(SmartLinkData smartLinkData) throws Throwable {
                f.a(ALSLConfigConstants.LAST_SMART_LINK_CONFIG_REQUEST_TIME, Long.valueOf(System.currentTimeMillis()));
                if (smartLinkData == null || TextUtils.equals(smartLinkData.version, ALSLConfigration.sSmartLinkData.version)) {
                    return;
                }
                ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端配置请求成功：version不同，表示配置有更新  更新本地变量");
                ALSLConfigration.sSmartLinkData = smartLinkData;
                f.c(ALSLConfigConstants.SMART_LINK_DATA, smartLinkData);
                if (TextUtils.equals(ALSLConfigration.sSmartLinkData.appConfigVersion, ALSLConfigration.sMatrixAPPData.version)) {
                    return;
                }
                ALSLConfigration.getMatrixAppDetailData(new MatrixDataGetCallback() { // from class: com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.2.1
                    @Override // com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback
                    public void getData(MAtrixAppData mAtrixAppData) {
                        ALSLConfigration.matrixAppDetectiveAndSend(ALSLContext.instance().mApplication, mAtrixAppData, true);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void matrixAppDetectiveAndSend(Application application, MAtrixAppData mAtrixAppData, boolean z) {
        long jLongValue = ((Long) f.b(ALSLConfigConstants.LAST_MATRIX_CONFIG_DETECT_TIME, 0L)).longValue();
        if (!z && System.currentTimeMillis() - jLongValue < 86400000) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "距离上次请求矩阵APP小于一天，不再重新请求");
        }
        ALSLAppCheckManager.getInstallAppList(application, com.alibaba.alibclinkpartner.smartlink.util.a.a(sMatrixAPPData));
        com.alibaba.alibclinkpartner.smartlink.b.a.b bVar = new com.alibaba.alibclinkpartner.smartlink.b.a.b();
        b.a(bVar);
        ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "上报设备探针信息：" + bVar.b());
    }

    public static void requestSmartLinkData(String str, SmartLinkDataGetCallback smartLinkDataGetCallback) throws Throwable {
        b.a(new l());
        HashMap map = new HashMap();
        map.put("appKey", str);
        com.alibaba.alibclinkpartner.smartlink.a.b bVarA = a.a(SMART_LINK_REQUEST_URL, map);
        if (bVarA.f23568a != 200) {
            ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端接口请求失败，错误码：：" + bVarA.f23568a);
            return;
        }
        SmartLinkData smartLinkDataB = c.b(bVarA.b);
        if (!com.alibaba.alibclinkpartner.smartlink.util.b.a(bVarA.b, smartLinkDataB.sign)) {
            smartLinkDataGetCallback.getData(new SmartLinkData());
            return;
        }
        smartLinkDataGetCallback.getData(smartLinkDataB);
        ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端配置请求成功：" + bVarA.b);
        if (bVarA.f23568a == 200) {
            b.a(new m());
        }
    }

    public static void updateSmartLinkData(Context context, String str) throws Throwable {
        long jLongValue;
        String str2;
        if (sSmartLinkData.data == null) {
            sSmartLinkData = (SmartLinkData) f.d(ALSLConfigConstants.SMART_LINK_DATA, new SmartLinkData());
        }
        SmartLinkData smartLinkData = sSmartLinkData;
        if (smartLinkData.data == null) {
            str2 = "本地智能唤端数据为空，进行智能唤端配置请求";
        } else {
            long jLongValue2 = 0;
            try {
                jLongValue = Long.valueOf(smartLinkData.validtime).longValue();
                try {
                    jLongValue2 = ((Long) f.b(ALSLConfigConstants.LAST_SMART_LINK_CONFIG_REQUEST_TIME, 0L)).longValue();
                } catch (Exception e) {
                    e = e;
                    ALSLLogUtil.d("ALSLConfigration", "updateSmartLinkData", "异常信息：" + e.toString());
                }
            } catch (Exception e2) {
                e = e2;
                jLongValue = 0;
            }
            if (System.currentTimeMillis() - jLongValue2 <= jLongValue) {
                return;
            } else {
                str2 = "本地智能唤端数据过期，请求新的配置";
            }
        }
        ALSLLogUtil.d("ALSLConfigration", "updateSmartLinkData", str2);
        getSmartLinkData(context, str);
    }
}
