package cj.mobile.jt.core.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cj.mobile.jt.core.ui.widget.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Keep
public class JuTuiNativeAdView extends FrameLayout {
    private w dispatchFrameLayout;
    public boolean mIsInWindow;

    public JuTuiNativeAdView(@NonNull Context context) {
        super(context);
    }

    private void initDispatchLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
    }

    public void renderAdView(View view) {
    }

    public JuTuiNativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JuTuiNativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
