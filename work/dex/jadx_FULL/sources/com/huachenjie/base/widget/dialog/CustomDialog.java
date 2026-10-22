package com.huachenjie.base.widget.dialog;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CustomDialog extends AppCompatDialog {
    public CustomDialog(Context context) {
        this(context, 0);
    }

    private boolean isFullScreen(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public void initWindow() {
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 17;
        attributes.format = -3;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R.color.transparent);
        if (isFullScreen(getOwnerActivity())) {
            getWindow().setFlags(1024, 1024);
        }
        View viewFindViewById = findViewById(getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initWindow();
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(view);
        initWindow();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initWindow();
    }
}
