package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CustomScrollingViewBehavior extends KSAppBarLayout.d {
    public CustomScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.d, com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
    @Keep
    public int getScrollRange(View view) {
        if (!(view instanceof KSAppBarLayout)) {
            return super.getScrollRange(view);
        }
        Object behavior = ((KSCoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior();
        return behavior instanceof CustomAppBarCustomAttrListener ? ((KSAppBarLayout) view).getTotalScrollRange() - ((CustomAppBarCustomAttrListener) behavior).getExtraFixedSize() : ((KSAppBarLayout) view).getTotalScrollRange();
    }
}
