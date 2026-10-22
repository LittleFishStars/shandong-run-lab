package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aq.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 837})
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (com.byazt.sr.uj.c()) {
            ImageView imageView = new ImageView(context);
            this.z = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.sp = this.x;
        } else {
            this.z = new TextView(context);
        }
        this.z.setTag(3);
        addView(this.z, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.z);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().da() && dynamicRootView.getRenderRequest().p()) {
                return;
            }
            this.z.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        ((TextView) this.z).setText("反馈");
        this.z.setTextAlignment(this.t.x());
        ((TextView) this.z).setTextColor(this.t.sp());
        ((TextView) this.z).setTextSize(this.t.n());
        this.z.setBackground(getBackgroundDrawable());
        if (this.t.qy()) {
            int iGu = this.t.gu();
            if (iGu > 0) {
                ((TextView) this.z).setLines(iGu);
                ((TextView) this.z).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.z).setMaxLines(1);
            ((TextView) this.z).setGravity(17);
            ((TextView) this.z).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.z.setPadding((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.tt()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.c()));
        ((TextView) this.z).setGravity(17);
        return true;
    }
}
