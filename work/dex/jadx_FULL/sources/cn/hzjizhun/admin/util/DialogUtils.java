package cn.hzjizhun.admin.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.h5.AdSdkH5Helper;
import cn.hzjizhun.admin.util.DialogUtils;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DialogUtils {
    private static final String TAG = "DialogUtils";

    private static AlertDialog createDialog(Context context, String str, final AdSdkH5Helper.DialogCallback dialogCallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.JZDownloadAlertDialogStyle);
        builder.setTitle(str).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.zj.adlib.ym2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogUtils.lambda$createDialog$1(dialogCallback, dialogInterface, i);
            }
        }).setNegativeButton(OptionsPickerHelper.e, new DialogInterface.OnClickListener() { // from class: com.zj.adlib.zm2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogUtils.lambda$createDialog$2(dialogCallback, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    private static void dismissSafely(DialogInterface dialogInterface) {
        if (dialogInterface instanceof AlertDialog) {
            AlertDialog alertDialog = (AlertDialog) dialogInterface;
            if (alertDialog.isShowing()) {
                try {
                    alertDialog.dismiss();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDialog$1(AdSdkH5Helper.DialogCallback dialogCallback, DialogInterface dialogInterface, int i) {
        notifyCallback(dialogCallback, true);
        dismissSafely(dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDialog$2(AdSdkH5Helper.DialogCallback dialogCallback, DialogInterface dialogInterface, int i) {
        notifyCallback(dialogCallback, false);
        dismissSafely(dialogInterface);
    }

    private static void notifyCallback(AdSdkH5Helper.DialogCallback dialogCallback, boolean z) {
        if (dialogCallback != null) {
            try {
                if (z) {
                    dialogCallback.sure();
                } else {
                    dialogCallback.cancel();
                }
            } catch (Throwable unused) {
                ALog.e(TAG, "Dialog callback error");
            }
        }
    }

    private static void setupDialogWindow(AlertDialog alertDialog, Context context) {
        Window window = alertDialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayUtil.screenWidth(context) - (DisplayUtil.dp2px(12) * 2);
        window.setAttributes(attributes);
    }

    public static void show(final Context context, final String str, final AdSdkH5Helper.DialogCallback dialogCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            ALog.e(TAG, "Invalid parameters: context or title is null");
            notifyCallback(dialogCallback, false);
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.xm2
                @Override // java.lang.Runnable
                public final void run() {
                    DialogUtils.show(context, str, dialogCallback);
                }
            });
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                ALog.e(TAG, "Activity is finishing or destroyed, skip showing dialog");
                notifyCallback(dialogCallback, false);
                return;
            }
        }
        try {
            setupDialogWindow(createDialog(context, str, dialogCallback), context);
        } catch (Throwable unused) {
            ALog.e(TAG, "Failed to show dialog");
            notifyCallback(dialogCallback, false);
        }
    }
}
