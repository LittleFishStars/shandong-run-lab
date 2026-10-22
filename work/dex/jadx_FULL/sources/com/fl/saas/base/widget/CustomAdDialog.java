package com.fl.saas.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CustomAdDialog extends Dialog {
    private Context mContext;
    private View mView;

    public CustomAdDialog(Context context, View view) {
        super(context);
        this.mContext = context;
        this.mView = view;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        int mobileWidth;
        int mobileHeight;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        if (DeviceUtil.getMobileWidth() > DeviceUtil.getMobileHeight()) {
            mobileHeight = (int) (((double) DeviceUtil.getMobileHeight()) * 0.8d);
            mobileWidth = (mobileHeight / 16) * 8;
        } else {
            mobileWidth = (int) (((double) DeviceUtil.getMobileWidth()) * 0.8d);
            mobileHeight = (mobileWidth / 9) * 16;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mobileWidth, mobileHeight);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
        relativeLayout.removeAllViews();
        relativeLayout.addView(this.mView, layoutParams);
        setContentView(relativeLayout);
    }
}
