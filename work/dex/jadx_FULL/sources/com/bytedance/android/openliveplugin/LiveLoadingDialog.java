package com.bytedance.android.openliveplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.gromore.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveLoadingDialog {
    private static Dialog loadingDialog;

    public static boolean dismiss() {
        Dialog dialog = loadingDialog;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        loadingDialog.dismiss();
        return true;
    }

    public static void show(Activity activity) {
        if (activity == null) {
            return;
        }
        Dialog dialog = loadingDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                return;
            }
            loadingDialog.show();
            return;
        }
        float f = activity.getResources().getDisplayMetrics().density;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.live_init_progress_dialog, (ViewGroup) null);
        viewInflate.findViewById(R.id.live_progress_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.openliveplugin.LiveLoadingDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveLoadingDialog.loadingDialog.dismiss();
            }
        });
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        loadingDialog = alertDialogCreate;
        if (alertDialogCreate.getWindow() != null) {
            loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            loadingDialog.getWindow().setDimAmount(0.0f);
            loadingDialog.show();
            loadingDialog.getWindow().setLayout(Math.round(92.0f * f), Math.round(f * 80.0f));
        }
    }
}
