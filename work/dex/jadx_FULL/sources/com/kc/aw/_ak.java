package com.kc.aw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _ak extends Dialog {
    public Context _a;
    public View _b;

    public _ak(Activity activity, int i) {
        super(activity, i);
        _a(activity);
    }

    public final void _a(Activity activity) {
        this._a = activity;
        requestWindowFeature(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this._a.getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        super.dismiss();
        View view = this._b;
        if (view != null) {
            view.clearAnimation();
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        _c6 _c6Var = new _c6(onDismissListener);
        super.setOnDismissListener(_c6Var);
        _c6Var._a(this);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    @Override // android.app.Dialog
    public final void show() {
        boolean z;
        Context context = this._a;
        if (context == null) {
            z = true;
        } else {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            return;
        }
        super.show();
    }
}
