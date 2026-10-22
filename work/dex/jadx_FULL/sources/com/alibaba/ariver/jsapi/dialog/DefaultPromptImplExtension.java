package com.alibaba.ariver.jsapi.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.point.dialog.CreatePromptParam;
import com.alibaba.ariver.app.api.point.dialog.PromptPoint;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultPromptImplExtension implements PromptPoint {
    private static final String TAG = "AriverAPI:DefaultDialogImplExtension";

    /* JADX INFO: Access modifiers changed from: private */
    public void hideKeyboard(Activity activity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "hideKeyboard exception!", th);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.dialog.PromptPoint
    public Dialog createDialog(final Activity activity, final CreatePromptParam createPromptParam) {
        if (activity == null || activity.isFinishing()) {
            RVLogger.d(TAG, "activity is finishing");
            return null;
        }
        if (TextUtils.isEmpty(createPromptParam.getTitle()) && TextUtils.isEmpty(createPromptParam.getMessage())) {
            RVLogger.w(TAG, "empty title and message");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final EditText editText = new EditText(activity);
        if (!TextUtils.isEmpty(createPromptParam.getTitle())) {
            builder.setTitle(createPromptParam.getTitle());
        }
        if (!TextUtils.isEmpty(createPromptParam.getMessage())) {
            builder.setMessage(createPromptParam.getMessage());
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DefaultPromptImplExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DefaultPromptImplExtension defaultPromptImplExtension = DefaultPromptImplExtension.this;
                Activity activity2 = activity;
                defaultPromptImplExtension.hideKeyboard(activity2, activity2.getWindow().getDecorView());
                CreatePromptParam.PositiveListener positiveListener = createPromptParam.positiveListener;
                if (positiveListener != null) {
                    positiveListener.onClick(dialogInterface, editText.getText().toString());
                }
            }
        };
        if (!TextUtils.isEmpty(createPromptParam.getPositiveString())) {
            builder.setNegativeButton(createPromptParam.getPositiveString(), onClickListener);
        }
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.dialog.DefaultPromptImplExtension.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DefaultPromptImplExtension defaultPromptImplExtension = DefaultPromptImplExtension.this;
                Activity activity2 = activity;
                defaultPromptImplExtension.hideKeyboard(activity2, activity2.getWindow().getDecorView());
                DialogInterface.OnClickListener onClickListener3 = createPromptParam.negativeListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i);
                }
            }
        };
        if (!TextUtils.isEmpty(createPromptParam.getNegativeString())) {
            builder.setPositiveButton(createPromptParam.getNegativeString(), onClickListener2);
        }
        builder.setCancelable(createPromptParam.cancelable);
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.jsapi.dialog.DefaultPromptImplExtension.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                DefaultPromptImplExtension defaultPromptImplExtension = DefaultPromptImplExtension.this;
                Activity activity2 = activity;
                defaultPromptImplExtension.hideKeyboard(activity2, activity2.getWindow().getDecorView());
                DialogInterface.OnCancelListener onCancelListener = createPromptParam.cancelListener;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setView(editText, DimensionUtil.dip2px(activity, 15.0f), 0, DimensionUtil.dip2px(activity, 15.0f), 0);
        return alertDialogCreate;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
