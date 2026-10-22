package com.huachenjie.common.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BaseAlertDialog extends AlertDialog implements LifecycleObserver {
    private Lifecycle mLifecycleOwner;
    private boolean mRegisterLifecycle;

    public BaseAlertDialog(Context context) {
        super(context);
        initDialog(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initDialog(Context context) {
        if (context instanceof LifecycleOwner) {
            this.mLifecycleOwner = ((LifecycleOwner) context).getLifecycle();
        }
    }

    private void registerLifecycle() {
        Lifecycle lifecycle = this.mLifecycleOwner;
        if (lifecycle == null || this.mRegisterLifecycle) {
            return;
        }
        this.mRegisterLifecycle = true;
        lifecycle.addObserver(this);
    }

    private void unregisterLifecycle() {
        Lifecycle lifecycle = this.mLifecycleOwner;
        if (lifecycle == null || !this.mRegisterLifecycle) {
            return;
        }
        this.mRegisterLifecycle = false;
        lifecycle.removeObserver(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
        unregisterLifecycle();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if (isShowing()) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerLifecycle();
    }

    public BaseAlertDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog(context);
    }

    public BaseAlertDialog(Context context, int themeResId) {
        super(context, themeResId);
        initDialog(context);
    }
}
