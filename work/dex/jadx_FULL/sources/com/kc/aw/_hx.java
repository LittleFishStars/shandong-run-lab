package com.kc.aw;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hx implements _dd {
    @Override // com.kc.aw._dd
    public final GradientDrawable _a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 100.0f, context.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(1883390530);
        gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()), 1895825407);
        return gradientDrawable;
    }
}
