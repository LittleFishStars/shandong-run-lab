package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import com.kwad.sdk.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup DY;
    public Activity mActivity;
    protected final Context mContext;

    public g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.wrapper.m.wrapContextIfNeed(activity);
    }

    public float dB() {
        return -1.0f;
    }

    public ViewGroup dC() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.wrapper.m.u(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.DY.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    public abstract void g(View view);

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.DY = (ViewGroup) com.kwad.sdk.wrapper.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.DY = dC();
            }
            setContentView(this.DY);
            setCanceledOnTouchOutside(pH());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (dB() != -1.0f) {
                attributes.dimAmount = dB();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            g(this.DY);
        } catch (Throwable th) {
            if (!o.Gs().Fu()) {
                throw th;
            }
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    public boolean pH() {
        return false;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        this.DY = (ViewGroup) com.kwad.sdk.wrapper.m.inflate(this.mContext, i, null);
    }
}
