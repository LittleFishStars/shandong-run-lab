package com.alibaba.ariver.jsapi.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultDialogImplExtension implements DialogPoint {
    private static final String TAG = "AriverAPI:DefaultDialogImplExtension";

    @Override // com.alibaba.ariver.app.api.point.dialog.DialogPoint
    public Dialog createDialog(Activity activity, CreateDialogParam createDialogParam) {
        if (activity == null || activity.isFinishing()) {
            RVLogger.d(TAG, "activity is finishing");
            return null;
        }
        if (TextUtils.isEmpty(createDialogParam.getTitle()) && TextUtils.isEmpty(createDialogParam.getMessage())) {
            RVLogger.w(TAG, "empty title and message");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!TextUtils.isEmpty(createDialogParam.getTitle())) {
            builder.setTitle(createDialogParam.getTitle());
        }
        if (!TextUtils.isEmpty(createDialogParam.getMessage())) {
            builder.setMessage(createDialogParam.getMessage());
        }
        if (!TextUtils.isEmpty(createDialogParam.getPositiveString())) {
            builder.setNegativeButton(createDialogParam.getPositiveString(), createDialogParam.positiveListener);
        }
        if (!TextUtils.isEmpty(createDialogParam.getNegativeString())) {
            builder.setPositiveButton(createDialogParam.getNegativeString(), createDialogParam.negativeListener);
        }
        builder.setCancelable(createDialogParam.cancelable);
        builder.setOnCancelListener(createDialogParam.cancelListener);
        return builder.create();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
