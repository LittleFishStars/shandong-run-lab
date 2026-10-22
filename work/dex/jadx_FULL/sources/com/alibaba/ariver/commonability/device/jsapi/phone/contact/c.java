package com.alibaba.ariver.commonability.device.jsapi.phone.contact;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23972a = 10721;
    private static final String b = "ContactUtils";
    private static b c;

    public static void a(a aVar) {
        b bVar = c;
        if (bVar != null) {
            bVar.a(aVar);
        }
        c = null;
    }

    public static void a(App app, b bVar) {
        RVLogger.d(b, "pickFromContactsList");
        Activity activityA = a();
        if (activityA == null || a(activityA, bVar)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
            activityA.startActivityForResult(intent, f23972a);
            c = bVar;
        } catch (Exception e) {
            RVLogger.e(b, e);
        }
    }

    private static boolean a(Activity activity, b bVar) {
        boolean z;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null || TextUtils.equals(rVConfigService.getConfig("ta_check_contact_permission", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE), AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return false;
        }
        try {
            z = ContextCompat.checkSelfPermission(activity, Permission.READ_CONTACTS) == 0;
        } catch (Exception unused) {
        }
        RVLogger.d(b, "选择系统手机联系人权限:" + z);
        if (z) {
            return false;
        }
        bVar.a(null);
        return true;
    }

    public static Activity a() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            RVLogger.e(b, "RVEnvironmentService is null");
            return null;
        }
        Activity activity = rVEnvironmentService.getTopActivity() != null ? rVEnvironmentService.getTopActivity().get() : null;
        if (activity == null) {
            RVLogger.e(b, "activity is null");
        }
        return activity;
    }
}
