package com.alibaba.triver.extensions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.PermissionGuildePoint;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.support.ui.R;
import java.text.MessageFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthGuideExtension implements PermissionGuildePoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.permission.api.extension.PermissionGuildePoint
    public boolean startPermissionGuide(String str, String str2) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "NOTIFICATION":
                string = InternationalUtil.getString(R.string.triver_notification);
                break;
            case "LBS":
            case "LBSSERVICE":
                string = InternationalUtil.getString(R.string.triver_location);
                break;
            case "PHOTO":
                string = InternationalUtil.getString(R.string.triver_photo);
                break;
            case "ADDRESSBOOK":
                string = InternationalUtil.getString(R.string.triver_addressbook);
                break;
            case "MICROPHONE":
                string = InternationalUtil.getString(R.string.triver_microphone);
                break;
            case "CAMERA":
                string = InternationalUtil.getString(R.string.triver_camera);
                break;
            default:
                string = "";
                break;
        }
        final Activity activity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get();
        if (TextUtils.isEmpty(string) || activity == null) {
            return false;
        }
        new AlertDialog.Builder(activity).setMessage(MessageFormat.format(InternationalUtil.getString(R.string.triver_open_one_permission), string)).setPositiveButton(InternationalUtil.getString(R.string.triver_open_permission_btn), new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthGuideExtension.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                try {
                    activity.startActivity(intent);
                } catch (Exception e) {
                    RVLogger.w(Log.getStackTraceString(e));
                }
            }
        }).setNegativeButton(InternationalUtil.getString(R.string.triver_core_cancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthGuideExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create().show();
        return true;
    }
}
