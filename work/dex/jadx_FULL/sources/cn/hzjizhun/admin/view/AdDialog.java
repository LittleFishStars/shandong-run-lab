package cn.hzjizhun.admin.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.api.ApiManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdDialog extends Dialog {
    private int mTopY;
    private int touchValue;

    public AdDialog(Context context) {
        super(context, R.style.JZInsertDialogStyle);
        this.touchValue = 0;
        this.mTopY = -1;
    }

    private void init() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        int i = this.mTopY;
        if (i > 0) {
            attributes.gravity = 48;
            attributes.y = i;
        } else {
            attributes.gravity = 17;
        }
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    public void noChannelSetTouch() {
        this.touchValue = ApiManager.dialogTouchKeenValue();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.touchValue == 0) {
            super.onBackPressed();
        }
        this.touchValue--;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    public void setDimAmount(float f) {
        if (f < 0.0f) {
            return;
        }
        if (f <= 0.1f) {
            f = 0.1f;
        }
        try {
            getWindow().setDimAmount(f);
        } catch (Throwable unused) {
        }
    }

    public void setSize(int i, int i2) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = i;
        attributes.height = i2;
        int i3 = this.mTopY;
        if (i3 > 0) {
            attributes.gravity = 48;
            attributes.y = i3;
        } else {
            attributes.gravity = 17;
        }
        getWindow().setAttributes(attributes);
    }

    public AdDialog(Context context, int i) {
        super(context, R.style.JZInsertDialogStyle);
        this.touchValue = 0;
        this.mTopY = i;
    }
}
