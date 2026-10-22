package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.az;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    final RecyclerView afs;
    final RecyclerView.LayoutManager aft;

    private f(RecyclerView recyclerView) {
        this.afs = recyclerView;
        this.aft = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper orientationHelperCreateVerticalHelper = this.aft.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.aft) : OrientationHelper.createHorizontalHelper(this.aft);
        int startAfterPadding = orientationHelperCreateVerticalHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelperCreateVerticalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.aft.getChildAt(i);
            int decoratedStart = orientationHelperCreateVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelperCreateVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        az.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View viewA = a(0, this.aft.getChildCount(), false, true);
        if (viewA == null) {
            return -1;
        }
        return this.afs.getChildAdapterPosition(viewA);
    }

    public final int findLastVisibleItemPosition() {
        View viewA = a(this.aft.getChildCount() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return this.afs.getChildAdapterPosition(viewA);
    }
}
