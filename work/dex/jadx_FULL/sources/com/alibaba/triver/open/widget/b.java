package com.alibaba.triver.open.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.action.IBackableAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends Action implements IBackableAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f25087a;
    private ImageView b;

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(Context context) {
        if (this.f25087a == null) {
            this.f25087a = new FrameLayout(context);
            int iDip2px = CommonUtils.dip2px(context, 27.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iDip2px, iDip2px);
            layoutParams.setMargins(CommonUtils.dip2px(context, 9.0f), 0, 0, 0);
            this.f25087a.setLayoutParams(layoutParams);
            this.f25087a.setBackgroundResource(R.drawable.triver_round_border_back);
            int iDip2px2 = CommonUtils.dip2px(context, 20.0f);
            int iDip2px3 = CommonUtils.dip2px(context, 17.0f);
            ImageView imageView = new ImageView(context);
            this.b = imageView;
            imageView.setContentDescription("返回");
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iDip2px2, iDip2px3);
            layoutParams2.gravity = 17;
            this.f25087a.addView(this.b, layoutParams2);
            this.b.setImageResource(R.drawable.triver_miniapp_bar_return_light);
        }
        return this.f25087a;
    }

    @Override // com.alibaba.triver.kit.api.widget.action.IBackableAction
    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public void setStyle(String str) {
        if (this.b != null) {
            this.f25087a.setBackgroundResource(isDark(str) ? R.drawable.triver_round_border_back_dark : R.drawable.triver_round_border_back);
            this.b.setImageResource(isDark(str) ? R.drawable.triver_miniapp_bar_return_dark : R.drawable.triver_miniapp_bar_return_light);
        }
    }
}
