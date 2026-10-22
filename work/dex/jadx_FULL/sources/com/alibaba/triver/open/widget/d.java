package com.alibaba.triver.open.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.kit.api.widget.action.ICloseableAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends Action implements ICloseableAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f25090a;
    private Page b;

    @Override // com.alibaba.triver.kit.api.widget.Action
    public void attatchPage(Page page) {
        this.b = page;
        super.attatchPage(page);
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(final Context context) {
        if (this.f25090a == null) {
            ImageView imageView = new ImageView(context);
            this.f25090a = imageView;
            imageView.setContentDescription("关闭");
            this.f25090a.setImageResource(R.drawable.triver_loading_close);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(CommonUtils.dip2px(context, 42.0f), CommonUtils.dip2px(context, 20.0f));
            layoutParams.setMargins(0, 0, CommonUtils.dip2px(context, 12.0f), 0);
            this.f25090a.setPadding(CommonUtils.dip2px(context, 16.0f), CommonUtils.dip2px(context, 5.0f), CommonUtils.dip2px(context, 16.0f), CommonUtils.dip2px(context, 5.0f));
            this.f25090a.setLayoutParams(layoutParams);
            this.f25090a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        ((Activity) context2).finish();
                    }
                }
            });
        }
        return this.f25090a;
    }

    @Override // com.alibaba.triver.kit.api.widget.action.ICloseableAction
    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f25090a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
