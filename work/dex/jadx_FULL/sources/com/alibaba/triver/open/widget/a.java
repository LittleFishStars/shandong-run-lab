package com.alibaba.triver.open.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.Action;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f25086a;

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.f25086a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25086a.setVisibility(0);
        ((IImageProxy) RVProxy.get(IImageProxy.class)).setImageUrl(this.f25086a, str, null);
        this.f25086a.setOnClickListener(onClickListener);
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(Context context) {
        if (this.f25086a == null) {
            this.f25086a = new ImageView(context);
            this.f25086a.setLayoutParams(new LinearLayout.LayoutParams(CommonUtils.dip2px(context, 45.0f), CommonUtils.dip2px(context, 48.0f)));
            this.f25086a.setPadding(CommonUtils.dip2px(context, 11.0f), CommonUtils.dip2px(context, 12.5f), CommonUtils.dip2px(context, 11.0f), CommonUtils.dip2px(context, 12.5f));
        }
        return this.f25086a;
    }

    public void a(Drawable drawable, View.OnClickListener onClickListener) {
        ImageView imageView = this.f25086a;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f25086a.setImageDrawable(drawable);
            this.f25086a.setOnClickListener(onClickListener);
        }
    }
}
