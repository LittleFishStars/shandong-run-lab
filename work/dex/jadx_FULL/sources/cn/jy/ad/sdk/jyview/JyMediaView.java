package cn.jy.ad.sdk.jyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JyMediaView extends FrameLayout {
    private final ViewGroup mAdContainer;
    private final List<View> mClickViews;
    private final List<View> mCustomViews;
    private final FrameLayout.LayoutParams mLogoParams;

    public JyMediaView(@NonNull Context context, AttributeSet attributeSet, int i, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable FrameLayout.LayoutParams layoutParams) {
        super(context, attributeSet, i);
        this.mAdContainer = viewGroup;
        this.mClickViews = list;
        this.mCustomViews = list2;
        this.mLogoParams = layoutParams;
    }

    public JyMediaView(@NonNull Context context, AttributeSet attributeSet, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable FrameLayout.LayoutParams layoutParams) {
        this(context, null, 0, viewGroup, list, list2, layoutParams);
    }

    public JyMediaView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        this(context, viewGroup, list, null);
    }

    public JyMediaView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2) {
        this(context, null, viewGroup, list, list2, null);
    }

    public JyMediaView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable FrameLayout.LayoutParams layoutParams) {
        this(context, null, viewGroup, list, list2, layoutParams);
    }

    public ViewGroup getAdContainer() {
        return this.mAdContainer;
    }

    public List<View> getClickViews() {
        return this.mClickViews;
    }

    public List<View> getCustomViews() {
        return this.mCustomViews;
    }

    public FrameLayout.LayoutParams getParams() {
        return this.mLogoParams;
    }
}
