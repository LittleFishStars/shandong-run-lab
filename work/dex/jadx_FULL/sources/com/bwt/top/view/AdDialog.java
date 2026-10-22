package com.bwt.top.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdDialog extends Dialog {
    public AdDialog(Context context) {
        this(context, 0);
    }

    public AdDialog(Context context, int i) {
        super(context, i);
    }

    private void init() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = -2;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
        setCanceledOnTouchOutside(false);
    }

    public void setSize(int i, int i2) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = i;
        attributes.height = i2;
        getWindow().setAttributes(attributes);
    }
}
