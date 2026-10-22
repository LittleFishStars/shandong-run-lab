package com.acse.ottn;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r0 extends ProgressDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23146a;

    public r0(Context context) {
        super(context);
        this.f23146a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(getContext(), R.layout.customprogressdialog, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public r0(Context context, int i) {
        super(context, i);
        this.f23146a = context;
    }
}
