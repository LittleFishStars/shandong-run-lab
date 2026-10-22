package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_SIGN_FAILED})
public class DynamicTimeOuterSkip extends DynamicButton implements com.byazt.kn.ve {
    public boolean c;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.c = dynamicRootView.getRenderRequest().z();
        }
    }

    private String c(boolean z) {
        String str = "跳过";
        if (!"skip-with-time-skip-btn".equals(this.u.da().getType())) {
            return "跳过";
        }
        if (com.byazt.sr.uj.c() && this.c) {
            str = "X";
        }
        return z ? str : "| ".concat(str);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.u.da().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.z.setTextAlignment(1);
            ((TextView) this.z).setGravity(17);
        } else {
            super.n();
        }
        if (!"skip-with-time-skip-btn".equals(this.u.da().getType())) {
            this.z.setTextAlignment(1);
            ((TextView) this.z).setGravity(17);
        }
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.z).getText())) {
            setMeasuredDimension(0, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicButton, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (!TextUtils.equals(this.u.da().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.z).setText("");
        return true;
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.z).setText(c(z2));
        } else {
            if (z2) {
                ((TextView) this.z).setText(c(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
