package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;
import com.byazt.nwh.AnimationButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2153})
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.z = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.z, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!com.byazt.sr.uj.c() || !"fillButton".equals(this.u.da().getType())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.z).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.z).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.t.rh() * 2;
        widgetLayoutParams.height -= this.t.rh() * 2;
        widgetLayoutParams.topMargin += this.t.rh();
        int iRh = widgetLayoutParams.leftMargin + this.t.rh();
        widgetLayoutParams.leftMargin = iRh;
        widgetLayoutParams.setMarginStart(iRh);
        widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        return widgetLayoutParams;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (TextUtils.equals("download-progress-button", this.u.da().getType()) && TextUtils.isEmpty(this.t.da())) {
            this.z.setVisibility(4);
            return true;
        }
        this.z.setTextAlignment(this.t.x());
        ((TextView) this.z).setText(this.t.da());
        ((TextView) this.z).setTextColor(this.t.sp());
        ((TextView) this.z).setTextSize(this.t.n());
        ((TextView) this.z).setGravity(17);
        ((TextView) this.z).setIncludeFontPadding(false);
        if ("fillButton".equals(this.u.da().getType())) {
            this.z.setPadding(0, 0, 0, 0);
        } else {
            this.z.setPadding(this.t.ve(), this.t.tt(), this.t.uj(), this.t.c());
        }
        return true;
    }
}
