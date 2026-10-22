package com.kc.aw;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.ViewTreeObserver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c6 implements DialogInterface.OnDismissListener {
    public DialogInterface.OnDismissListener _a;

    @Keep
    public final class _a implements ViewTreeObserver.OnWindowAttachListener {
        public final Dialog _a;
        public final _c6 _b;

        public _a(_c6 _c6Var, Dialog dialog) {
            this._b = _c6Var;
            this._a = dialog;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public final void onWindowAttached() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public final void onWindowDetached() {
            DialogInterface.OnDismissListener onDismissListener = this._b._a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this._a);
            }
            this._b._a = null;
        }
    }

    public _c6(DialogInterface.OnDismissListener onDismissListener) {
        this._a = onDismissListener;
    }

    public final void _a(Dialog dialog) {
        dialog.getWindow().getDecorView().getViewTreeObserver().addOnWindowAttachListener(new _a(this, dialog));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = this._a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
