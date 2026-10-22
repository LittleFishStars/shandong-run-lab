package com.alibaba.ariver.commonability.device.jsapi.phone;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TelephonyInfoBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23969a = "TelephonyInfoBridgeExtension";
    private static final String b = "carrierName";
    private HashMap<String, String> c = new HashMap<String, String>() { // from class: com.alibaba.ariver.commonability.device.jsapi.phone.TelephonyInfoBridgeExtension.1
        {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
            put("46020", "中国铁通");
            put("46004", "中国航天");
            put("CMCC", "中国移动");
            put("CUCC", "中国联通");
            put("CTCC", "中国电信");
        }
    };

    private String a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null) {
            return null;
        }
        try {
            return telephonyManager.getSimOperatorName();
        } catch (Exception e) {
            RVLogger.e(f23969a, e);
            return null;
        }
    }

    private String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null) {
            return null;
        }
        try {
            return telephonyManager.getSimOperator();
        } catch (Exception e) {
            RVLogger.e(f23969a, e);
            return null;
        }
    }

    private boolean c(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getCarrierName(@BindingApiContext ApiContext apiContext) {
        String strA;
        Activity activity = apiContext.getActivity();
        if (activity == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        String strB = b(activity);
        String strB2 = !TextUtils.isEmpty(strB) ? b(strB) : null;
        if (TextUtils.isEmpty(strB2)) {
            RVLogger.w(f23969a, ((String) null) + " from getSubscriberId no name.");
            strA = a(activity);
            if (!TextUtils.isEmpty(strA)) {
                strB2 = a(strA);
            }
        } else {
            strA = null;
        }
        if (TextUtils.isEmpty(strB2)) {
            RVLogger.w(f23969a, "take nothing from getSimOperatorName.");
        }
        RVLogger.w(f23969a, "name=" + strA + " sim=" + strB + "imsi=" + ((String) null));
        return TextUtils.isEmpty(strB2) ? new BridgeResponse.NamedValue(b, "") : new BridgeResponse.NamedValue(b, strB2);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private String c(String str) {
        try {
            for (String str2 : this.c.keySet()) {
                if (str.startsWith(str2)) {
                    return this.c.get(str2);
                }
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(f23969a, e);
            return null;
        }
    }

    private String a(String str) {
        String str2;
        try {
            str2 = this.c.get(str);
        } catch (Exception e) {
            RVLogger.e(f23969a, e);
            str2 = null;
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    private String b(String str) {
        try {
            return this.c.get(str);
        } catch (Exception e) {
            RVLogger.e(f23969a, e);
            return null;
        }
    }
}
