package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends LinearLayoutManager {

    @NonNull
    private final RecyclerView YL;
    private boolean YM;
    private int YN;
    private int YO;
    private g YP;
    private boolean YQ;

    @NonNull
    private final Context mContext;
    private int maxHeight;

    public static class a {
        private boolean YM = true;
        private int YU = 250;
        private int YV = 200;

        public a(boolean z, int i, int i2) {
        }
    }

    public class b extends LinearSmoothScroller {
        private final Interpolator YW;

        public b(Context context) {
            super(context);
            this.YW = new a(this, (byte) 0);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0030 A[PHI: r0
          0x0030: PHI (r0v10 float) = (r0v7 float), (r0v8 float) binds: [B:14:0x002e, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
        private int bd(int i) {
            if (f.this.YP instanceof g.e) {
                return super.calculateTimeForScrolling(i);
            }
            if (i == 0) {
                return 0;
            }
            if (i == 10000) {
                return 4000;
            }
            float fPx2dip = com.kwad.sdk.c.a.a.px2dip(f.this.mContext, i) / 26.0f;
            float f = 3.4f;
            if (fPx2dip < 3.4f) {
                fPx2dip = f;
            } else {
                f = 10.0f;
                if (fPx2dip > 10.0f) {
                    fPx2dip = f;
                }
            }
            return (int) (fPx2dip * 30.0f);
        }

        private int be(int i) {
            int iBi;
            g gVar = f.this.YP;
            return (c(gVar) && (iBi = ((g.d) gVar).bi(i)) != 0) ? iBi : bh(i);
        }

        private int bf(int i) {
            int iBh;
            if (i == 0) {
                com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "updateComments, calculateTimeForScrollingForNewStrategy, dx == 0");
                return 0;
            }
            if (f.this.YP instanceof g.b) {
                iBh = (i * 1000) / com.kwad.sdk.c.a.a.a(f.this.mContext, 1000.0f);
            } else if (f.this.YP instanceof g.e) {
                iBh = f.this.YO == 0 ? super.calculateTimeForScrolling(i) : (i * 1000) / f.this.YO;
            } else if (f.this.YP instanceof g.c) {
                iBh = f.this.YN == 0 ? super.calculateTimeForScrolling(i) : (i * 1000) / f.this.YN;
            } else {
                iBh = bh(i);
            }
            int iMax = Math.max(iBh, 10);
            com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "updateComments, calculateTimeForScrollingForNewStrategydx" + i + "adjustTime" + iMax + "time" + iBh);
            return iMax;
        }

        private int bg(int i) {
            if (i == 0) {
                com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "updateComments, calculateTimeForScrollingForOptimalStrategy, dx == 0");
                return 0;
            }
            int iSW = f.this.YP instanceof g.f ? ((g.f) f.this.YP).sW() : 0;
            int iBh = iSW == 0 ? bh(i) : (i * 1000) / iSW;
            int iMax = Math.max(iBh, 10);
            com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "updateComments, calculateTimeForScrollingForNewStrategydx" + i + "adjustTime" + iMax + "time" + iBh);
            return iMax;
        }

        private int bh(int i) {
            return Math.max(super.calculateTimeForScrolling(i), 10);
        }

        private static boolean c(g gVar) {
            return gVar instanceof g.d;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return f.this.YP instanceof g.e ? 8.0f / displayMetrics.density : super.calculateSpeedPerPixel(displayMetrics);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForDeceleration(int i) {
            if (f.this.YP instanceof g.a) {
                return 0;
            }
            if (f.this.YP instanceof g.d) {
                return be(i);
            }
            if (f.this.YP instanceof g.f) {
                return bg(i);
            }
            return f.this.YM ? bf(i) : super.calculateTimeForDeceleration(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForScrolling(int i) {
            if (f.this.YP instanceof g.a) {
                return ((g.a) f.this.YP).sU();
            }
            if (f.this.YP instanceof g.d) {
                return be(i);
            }
            if (f.this.YP instanceof g.f) {
                return bg(i);
            }
            return f.this.YM ? bf(i) : bd(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public final PointF computeScrollVectorForPosition(int i) {
            return f.this.computeScrollVectorForPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
            int iCalculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
            if (f.this.YP instanceof g.a) {
                int iSU = ((g.a) f.this.YP).sU();
                if (iSU <= 1) {
                    iSU = 300;
                }
                action.update(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iSU, new com.kwad.components.core.innerEc.live.widget.b(0.42f, 0.0f, 0.58f, 1.0f));
                return;
            }
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((iCalculateDxToMakeVisible * iCalculateDxToMakeVisible) + (iCalculateDyToMakeVisible * iCalculateDyToMakeVisible)));
            if (iCalculateTimeForDeceleration > 0) {
                action.update(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iCalculateTimeForDeceleration, c(f.this.YP) ? this.YW : this.mDecelerateInterpolator);
            }
        }

        public class a implements Interpolator {
            private final Interpolator YX;

            private a() {
                this.YX = new DecelerateInterpolator();
            }

            private float a(float f, List<k> list) {
                k next;
                Iterator<k> it = list.iterator();
                float fTg = 0.0f;
                float fTh = 0.0f;
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (f - fTg <= next.tg()) {
                        break;
                    }
                    fTg += next.tg();
                    fTh += next.th();
                }
                if (next == null) {
                    return f;
                }
                return fTh + (this.YX.getInterpolation((f - fTg) / next.tg()) * next.th());
            }

            private float f(float f) {
                return ((LinearSmoothScroller) b.this).mDecelerateInterpolator.getInterpolation(f);
            }

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                g gVar = f.this.YP;
                if (!(gVar instanceof g.d)) {
                    return f(f);
                }
                List<k> listSV = ((g.d) gVar).sV();
                if (!g.n(listSV)) {
                    return f(f);
                }
                try {
                    return a(f, listSV);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "calculateSegmentInterpolation error" + e);
                    return f(f);
                }
            }

            public /* synthetic */ a(b bVar, byte b) {
                this();
            }
        }
    }

    public f(@NonNull RecyclerView recyclerView) {
        super(recyclerView.getContext(), 1, false);
        this.YP = g.c.YZ;
        this.maxHeight = 0;
        this.YQ = false;
        this.YL = recyclerView;
        this.mContext = recyclerView.getContext();
        setStackFromEnd(true);
    }

    private void sT() {
        this.YL.postDelayed(new Runnable() { // from class: com.kwad.components.core.innerEc.live.widget.f.1
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.YL.isComputingLayout()) {
                    return;
                }
                final RecyclerView.ItemAnimator itemAnimator = f.this.YL.getItemAnimator();
                f fVar = f.this;
                f.a(itemAnimator);
                f.this.YL.setItemAnimator(null);
                f.this.requestLayout();
                f.this.YL.postDelayed(new Runnable() { // from class: com.kwad.components.core.innerEc.live.widget.f.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.YL.setItemAnimator(itemAnimator);
                    }
                }, 48L);
            }
        }, 32L);
    }

    public final void aL(boolean z) {
        this.YQ = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(RecyclerView.State state) {
        if (!this.YQ) {
            return super.getExtraLayoutSpace(state);
        }
        if (this.maxHeight < getHeight()) {
            this.maxHeight = getHeight();
        }
        int i = this.maxHeight;
        return Math.max(i << 2, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IllegalArgumentException e) {
            com.kwad.sdk.core.d.c.e("LiveCommentLinearLayoutManager", "onLayoutChildrenException", e);
            a(recycler);
            sT();
        }
    }

    public final g sS() {
        return this.YP;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        b bVar = new b(recyclerView.getContext());
        bVar.setTargetPosition(i);
        startSmoothScroll(bVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public final void b(g gVar) {
        com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "setScrollStrategyscrollStrategy" + gVar);
        this.YP = gVar;
    }

    public final void a(@Nullable a aVar) {
        this.YM = aVar.YM;
        this.YN = aVar.YU;
        this.YO = aVar.YV;
        com.kwad.sdk.core.d.c.i("LiveCommentLinearLayoutManager", "updateComments, setLiveCommentScrollConfigmEnableNewSpeedStrategy" + this.YM + "mFastScrollSpeedPx" + this.YN + "mSlowScrollSpeedPx" + this.YO);
    }

    private void a(RecyclerView.Recycler recycler) {
        a(this.YL.getItemAnimator());
        this.YL.stopScroll();
        this.YL.stopNestedScroll();
        detachAndScrapAttachedViews(recycler);
        removeAndRecycleAllViews(recycler);
        if (this.YL.getAdapter() != null) {
            RecyclerView recyclerView = this.YL;
            recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@Nullable RecyclerView.ItemAnimator itemAnimator) {
        if (itemAnimator != null) {
            int i = 0;
            while (i < 10 && itemAnimator.isRunning()) {
                i++;
                try {
                    itemAnimator.endAnimations();
                } catch (IllegalArgumentException e) {
                    com.kwad.sdk.core.d.c.e("LiveCommentLinearLayoutManager", "resetRecyclerState, clearCount: " + i, e);
                }
            }
        }
    }
}
