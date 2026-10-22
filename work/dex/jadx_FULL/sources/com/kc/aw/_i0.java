package com.kc.aw;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i0 implements _dd {
    @Override // com.kc.aw._dd
    public final GradientDrawable _a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 100.0f, context.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(-1724697805);
        return gradientDrawable;
    }
}
