package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f31198a = new Rect();
    public static final boolean d = false;
    public static final /* synthetic */ boolean e = false;
    public static final String f = "FlexboxLayoutManager";
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<View> f5412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f5413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OrientationHelper f5414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.Recycler f5415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.State f5416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SavedState f5417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f5418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f5419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.flexbox.b.C0706b f5420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.flexbox.b f5421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<com.google.android.flexbox.a> f5422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5423a;
    public OrientationHelper b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5424b;
    public boolean c;

    public class b {
        public static final /* synthetic */ boolean d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31199a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5426a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5427b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f5428c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f5429d;

        public b() {
            this.f5429d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i) {
            int i2 = bVar.f5429d + i;
            bVar.f5429d = i2;
            return i2;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f5423a) {
                this.c = this.f5426a ? FlexboxLayoutManager.this.f5414a.getEndAfterPadding() : FlexboxLayoutManager.this.f5414a.getStartAfterPadding();
            } else {
                this.c = this.f5426a ? FlexboxLayoutManager.this.f5414a.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f5414a.getStartAfterPadding();
            }
        }

        public final void s(View anchor) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.L == 0 ? FlexboxLayoutManager.this.b : FlexboxLayoutManager.this.f5414a;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f5423a) {
                if (this.f5426a) {
                    this.c = orientationHelper.getDecoratedEnd(anchor) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.c = orientationHelper.getDecoratedStart(anchor);
                }
            } else if (this.f5426a) {
                this.c = orientationHelper.getDecoratedStart(anchor) + orientationHelper.getTotalSpaceChange();
            } else {
                this.c = orientationHelper.getDecoratedEnd(anchor);
            }
            this.f31199a = FlexboxLayoutManager.this.getPosition(anchor);
            this.f5428c = false;
            int[] iArr = FlexboxLayoutManager.this.f5421a.f5440a;
            int i = this.f31199a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.f5422a.size() > this.b) {
                this.f31199a = ((com.google.android.flexbox.a) FlexboxLayoutManager.this.f5422a.get(this.b)).l;
            }
        }

        public final void t() {
            this.f31199a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f5427b = false;
            this.f5428c = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.L == 0) {
                    this.f5426a = FlexboxLayoutManager.this.K == 1;
                    return;
                } else {
                    this.f5426a = FlexboxLayoutManager.this.L == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.L == 0) {
                this.f5426a = FlexboxLayoutManager.this.K == 3;
            } else {
                this.f5426a = FlexboxLayoutManager.this.L == 2;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f31199a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.f5429d + ", mLayoutFromEnd=" + this.f5426a + ", mValid=" + this.f5427b + ", mAssignedFromSavedState=" + this.f5428c + '}';
        }
    }

    public static class c {
        public static final int i = Integer.MIN_VALUE;
        public static final int j = -1;
        public static final int k = 1;
        public static final int l = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31200a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5430a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5431b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public c() {
            this.g = 1;
            this.h = 1;
        }

        public static /* synthetic */ int c(c cVar, int i2) {
            int i3 = cVar.d + i2;
            cVar.d = i3;
            return i3;
        }

        public static /* synthetic */ int d(c cVar, int i2) {
            int i3 = cVar.d - i2;
            cVar.d = i3;
            return i3;
        }

        public static /* synthetic */ int i(c cVar, int i2) {
            int i3 = cVar.f31200a - i2;
            cVar.f31200a = i3;
            return i3;
        }

        public static /* synthetic */ int l(c cVar) {
            int i2 = cVar.b;
            cVar.b = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int m(c cVar) {
            int i2 = cVar.b;
            cVar.b = i2 - 1;
            return i2;
        }

        public static /* synthetic */ int n(c cVar, int i2) {
            int i3 = cVar.b + i2;
            cVar.b = i3;
            return i3;
        }

        public static /* synthetic */ int q(c cVar, int i2) {
            int i3 = cVar.e + i2;
            cVar.e = i3;
            return i3;
        }

        public static /* synthetic */ int u(c cVar, int i2) {
            int i3 = cVar.c + i2;
            cVar.c = i3;
            return i3;
        }

        public static /* synthetic */ int v(c cVar, int i2) {
            int i3 = cVar.c - i2;
            cVar.c = i3;
            return i3;
        }

        public final boolean D(RecyclerView.State state, List<com.google.android.flexbox.a> flexLines) {
            int i2;
            int i3 = this.c;
            return i3 >= 0 && i3 < state.getItemCount() && (i2 = this.b) >= 0 && i2 < flexLines.size();
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f31200a + ", mFlexLinePosition=" + this.b + ", mPosition=" + this.c + ", mOffset=" + this.d + ", mScrollingOffset=" + this.e + ", mLastScrollDelta=" + this.f + ", mItemDirection=" + this.g + ", mLayoutDirection=" + this.h + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= childSize;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == childSize;
        }
        return true;
    }

    private boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, RecyclerView.LayoutParams lp) {
        return (!child.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(child.getWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp).width) && isMeasurementUpToDate(child.getHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp).height)) ? false : true;
    }

    public final int A(com.google.android.flexbox.a flexLine, c layoutState) {
        return isMainAxisDirectionHorizontal() ? B(flexLine, layoutState) : C(flexLine, layoutState);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:49:0x010e  */
    /* JADX WARN: Code duplicated, block: B:52:0x012f  */
    /* JADX WARN: Code duplicated, block: B:53:0x014f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0192 A[SYNTHETIC] */
    public final int B(com.google.android.flexbox.a flexLine, c layoutState) {
        float f2;
        float f3;
        float f4;
        float measuredWidth;
        float measuredWidth2;
        float fMax;
        int iC;
        int i;
        int i2;
        View flexItemAt;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float leftDecorationWidth;
        float rightDecorationWidth;
        int topDecorationHeight;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i3 = layoutState.d;
        if (layoutState.h == -1) {
            i3 -= flexLine.g;
        }
        int i4 = i3;
        int i5 = layoutState.c;
        int i6 = this.M;
        int i7 = 1;
        if (i6 != 0) {
            if (i6 == 1) {
                int i8 = flexLine.e;
                float f5 = (width - i8) + paddingRight;
                f4 = 0.0f;
                f3 = i8 - paddingLeft;
                f2 = f5;
            } else if (i6 == 2) {
                int i9 = flexLine.e;
                f2 = paddingLeft + ((width - i9) / 2.0f);
                f3 = (width - paddingRight) - ((width - i9) / 2.0f);
            } else if (i6 == 3) {
                f2 = paddingLeft;
                int i10 = flexLine.h;
                f4 = (width - flexLine.e) / (i10 != 1 ? i10 - 1 : 1.0f);
                f3 = width - paddingRight;
            } else if (i6 == 4) {
                int i11 = flexLine.h;
                f4 = i11 != 0 ? (width - flexLine.e) / i11 : 0.0f;
                float f6 = f4 / 2.0f;
                f2 = paddingLeft + f6;
                f3 = (width - paddingRight) - f6;
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.M);
                }
                int i12 = flexLine.h;
                f4 = i12 != 0 ? (width - flexLine.e) / (i12 + 1) : 0.0f;
                f2 = paddingLeft + f4;
                f3 = (width - paddingRight) - f4;
            }
            measuredWidth = f2 - this.f5418a.f5429d;
            measuredWidth2 = f3 - this.f5418a.f5429d;
            fMax = Math.max(f4, 0.0f);
            iC = flexLine.c();
            i = 0;
            i2 = i5;
            while (i2 < i5 + iC) {
                flexItemAt = getFlexItemAt(i2);
                if (flexItemAt != null) {
                    if (layoutState.h == i7) {
                        calculateItemDecorationsForChild(flexItemAt, f31198a);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, f31198a);
                        addView(flexItemAt, i);
                        i++;
                    }
                    int i13 = i;
                    com.google.android.flexbox.b bVar = this.f5421a;
                    long j = bVar.f5441a[i2];
                    iY = bVar.y(j);
                    iX = this.f5421a.x(j);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                        flexItemAt.measure(iY, iX);
                    }
                    leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = measuredWidth2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt));
                    topDecorationHeight = i4 + getTopDecorationHeight(flexItemAt);
                    if (this.f5423a) {
                        this.f5421a.Q(flexItemAt, flexLine, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        this.f5421a.Q(flexItemAt, flexLine, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i = i13;
                    measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                    measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
                }
                i2++;
                i7 = 1;
            }
            c.n(layoutState, this.f5419a.h);
            return flexLine.a();
        }
        f2 = paddingLeft;
        f3 = width - paddingRight;
        f4 = 0.0f;
        measuredWidth = f2 - this.f5418a.f5429d;
        measuredWidth2 = f3 - this.f5418a.f5429d;
        fMax = Math.max(f4, 0.0f);
        iC = flexLine.c();
        i = 0;
        i2 = i5;
        while (i2 < i5 + iC) {
            flexItemAt = getFlexItemAt(i2);
            if (flexItemAt != null) {
                if (layoutState.h == i7) {
                    calculateItemDecorationsForChild(flexItemAt, f31198a);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, f31198a);
                    addView(flexItemAt, i);
                    i++;
                }
                int i14 = i;
                com.google.android.flexbox.b bVar2 = this.f5421a;
                long j2 = bVar2.f5441a[i2];
                iY = bVar2.y(j2);
                iX = this.f5421a.x(j2);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                    flexItemAt.measure(iY, iX);
                }
                leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = measuredWidth2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt));
                topDecorationHeight = i4 + getTopDecorationHeight(flexItemAt);
                if (this.f5423a) {
                    this.f5421a.Q(flexItemAt, flexLine, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                } else {
                    this.f5421a.Q(flexItemAt, flexLine, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                }
                i = i14;
                measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
            }
            i2++;
            i7 = 1;
        }
        c.n(layoutState, this.f5419a.h);
        return flexLine.a();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:45:0x0101  */
    /* JADX WARN: Code duplicated, block: B:48:0x011f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0128  */
    /* JADX WARN: Code duplicated, block: B:52:0x0144  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code duplicated, block: B:55:0x0172  */
    /* JADX WARN: Code duplicated, block: B:56:0x0198  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x01c0  */
    public final int C(com.google.android.flexbox.a flexLine, c layoutState) {
        float f2;
        float f3;
        float f4;
        float measuredHeight;
        float measuredHeight2;
        float fMax;
        int iC;
        int i;
        int i2;
        View flexItemAt;
        float f5;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float topDecorationHeight;
        float bottomDecorationHeight;
        int leftDecorationWidth;
        int rightDecorationWidth;
        boolean z;
        boolean z2;
        View view;
        int i3;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = layoutState.d;
        int i5 = layoutState.d;
        if (layoutState.h == -1) {
            int i6 = flexLine.g;
            i4 -= i6;
            i5 += i6;
        }
        int i7 = i4;
        int i8 = i5;
        int i9 = layoutState.c;
        int i10 = this.M;
        boolean z3 = true;
        if (i10 != 0) {
            if (i10 == 1) {
                int i11 = flexLine.e;
                float f6 = (height - i11) + paddingBottom;
                f4 = 0.0f;
                f3 = i11 - paddingTop;
                f2 = f6;
            } else if (i10 == 2) {
                int i12 = flexLine.e;
                f2 = paddingTop + ((height - i12) / 2.0f);
                f3 = (height - paddingBottom) - ((height - i12) / 2.0f);
            } else if (i10 == 3) {
                f2 = paddingTop;
                int i13 = flexLine.h;
                f4 = (height - flexLine.e) / (i13 != 1 ? i13 - 1 : 1.0f);
                f3 = height - paddingBottom;
            } else if (i10 == 4) {
                int i14 = flexLine.h;
                f4 = i14 != 0 ? (height - flexLine.e) / i14 : 0.0f;
                float f7 = f4 / 2.0f;
                f2 = paddingTop + f7;
                f3 = (height - paddingBottom) - f7;
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.M);
                }
                int i15 = flexLine.h;
                f4 = i15 != 0 ? (height - flexLine.e) / (i15 + 1) : 0.0f;
                f2 = paddingTop + f4;
                f3 = (height - paddingBottom) - f4;
            }
            measuredHeight = f2 - this.f5418a.f5429d;
            measuredHeight2 = f3 - this.f5418a.f5429d;
            fMax = Math.max(f4, 0.0f);
            iC = flexLine.c();
            i = 0;
            i2 = i9;
            while (i2 < i9 + iC) {
                flexItemAt = getFlexItemAt(i2);
                if (flexItemAt == null) {
                    i3 = i2;
                    z2 = z3;
                    f5 = fMax;
                } else {
                    com.google.android.flexbox.b bVar = this.f5421a;
                    f5 = fMax;
                    long j = bVar.f5441a[i2];
                    iY = bVar.y(j);
                    iX = this.f5421a.x(j);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                        flexItemAt.measure(iY, iX);
                    }
                    topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(flexItemAt);
                    bottomDecorationHeight = measuredHeight2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (layoutState.h == 1) {
                        calculateItemDecorationsForChild(flexItemAt, f31198a);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, f31198a);
                        addView(flexItemAt, i);
                        i++;
                    }
                    int i16 = i;
                    leftDecorationWidth = i7 + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = i8 - getRightDecorationWidth(flexItemAt);
                    z = this.f5423a;
                    if (z) {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        if (this.f5424b) {
                            this.f5421a.R(view, flexLine, z, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.f5421a.R(view, flexLine, z, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else if (this.f5424b) {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        this.f5421a.R(flexItemAt, flexLine, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        this.f5421a.R(view, flexLine, z, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                    View view2 = view;
                    measuredHeight = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(view2) + f5;
                    i = i16;
                    measuredHeight2 = bottomDecorationHeight - (((view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(view2)) + f5);
                }
                i2 = i3 + 1;
                fMax = f5;
                z3 = z2;
            }
            c.n(layoutState, this.f5419a.h);
            return flexLine.a();
        }
        f2 = paddingTop;
        f3 = height - paddingBottom;
        f4 = 0.0f;
        measuredHeight = f2 - this.f5418a.f5429d;
        measuredHeight2 = f3 - this.f5418a.f5429d;
        fMax = Math.max(f4, 0.0f);
        iC = flexLine.c();
        i = 0;
        i2 = i9;
        while (i2 < i9 + iC) {
            flexItemAt = getFlexItemAt(i2);
            if (flexItemAt == null) {
                i3 = i2;
                z2 = z3;
                f5 = fMax;
            } else {
                com.google.android.flexbox.b bVar2 = this.f5421a;
                f5 = fMax;
                long j2 = bVar2.f5441a[i2];
                iY = bVar2.y(j2);
                iX = this.f5421a.x(j2);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                    flexItemAt.measure(iY, iX);
                }
                topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(flexItemAt);
                bottomDecorationHeight = measuredHeight2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(flexItemAt));
                if (layoutState.h == 1) {
                    calculateItemDecorationsForChild(flexItemAt, f31198a);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, f31198a);
                    addView(flexItemAt, i);
                    i++;
                }
                int i17 = i;
                leftDecorationWidth = i7 + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = i8 - getRightDecorationWidth(flexItemAt);
                z = this.f5423a;
                if (z) {
                    z2 = true;
                    view = flexItemAt;
                    i3 = i2;
                    if (this.f5424b) {
                        this.f5421a.R(view, flexLine, z, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.f5421a.R(view, flexLine, z, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                } else if (this.f5424b) {
                    z2 = true;
                    view = flexItemAt;
                    i3 = i2;
                    this.f5421a.R(flexItemAt, flexLine, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                } else {
                    z2 = true;
                    view = flexItemAt;
                    i3 = i2;
                    this.f5421a.R(view, flexLine, z, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                }
                View view3 = view;
                measuredHeight = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(view3) + f5;
                i = i17;
                measuredHeight2 = bottomDecorationHeight - (((view3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(view3)) + f5);
            }
            i2 = i3 + 1;
            fMax = f5;
            z3 = z2;
        }
        c.n(layoutState, this.f5419a.h);
        return flexLine.a();
    }

    public final void D(RecyclerView.Recycler recycler, c layoutState) {
        if (layoutState.f5431b) {
            if (layoutState.h == -1) {
                E(recycler, layoutState);
            } else {
                F(recycler, layoutState);
            }
        }
    }

    public final void E(RecyclerView.Recycler recycler, c layoutState) {
        int childCount;
        int i;
        View childAt;
        int i2;
        if (layoutState.e < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt((i = childCount - 1))) == null || (i2 = this.f5421a.f5440a[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f5422a.get(i2);
        for (int i3 = i; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!h(childAt2, layoutState.e)) {
                    break;
                }
                if (aVar.l != getPosition(childAt2)) {
                    continue;
                } else if (i2 <= 0) {
                    childCount = i3;
                    break;
                } else {
                    i2 += layoutState.h;
                    aVar = this.f5422a.get(i2);
                    childCount = i3;
                }
            }
        }
        recycleChildren(recycler, childCount, i);
    }

    public final void F(RecyclerView.Recycler recycler, c layoutState) {
        int childCount;
        View childAt;
        if (layoutState.e < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i = this.f5421a.f5440a[getPosition(childAt)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f5422a.get(i);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!i(childAt2, layoutState.e)) {
                    break;
                }
                if (aVar.m != getPosition(childAt2)) {
                    continue;
                } else if (i >= this.f5422a.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += layoutState.h;
                    aVar = this.f5422a.get(i);
                    i2 = i3;
                }
            }
        }
        recycleChildren(recycler, 0, i2);
    }

    public final void G() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.f5419a.f5430a = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void H() {
        int layoutDirection = getLayoutDirection();
        int i = this.K;
        if (i == 0) {
            this.f5423a = layoutDirection == 1;
            this.f5424b = this.L == 2;
            return;
        }
        if (i == 1) {
            this.f5423a = layoutDirection != 1;
            this.f5424b = this.L == 2;
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            this.f5423a = z;
            if (this.L == 2) {
                this.f5423a = !z;
            }
            this.f5424b = false;
            return;
        }
        if (i != 3) {
            this.f5423a = false;
            this.f5424b = false;
            return;
        }
        boolean z2 = layoutDirection == 1;
        this.f5423a = z2;
        if (this.L == 2) {
            this.f5423a = !z2;
        }
        this.f5424b = true;
    }

    public final boolean I(RecyclerView.State state, b anchorInfo) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewO = anchorInfo.f5426a ? o(state.getItemCount()) : m(state.getItemCount());
        if (viewO == null) {
            return false;
        }
        anchorInfo.s(viewO);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.f5414a.getDecoratedStart(viewO) >= this.f5414a.getEndAfterPadding() || this.f5414a.getDecoratedEnd(viewO) < this.f5414a.getStartAfterPadding()) {
                anchorInfo.c = anchorInfo.f5426a ? this.f5414a.getEndAfterPadding() : this.f5414a.getStartAfterPadding();
            }
        }
        return true;
    }

    public final boolean J(RecyclerView.State state, b anchorInfo, SavedState savedState) {
        int i;
        View childAt;
        if (!state.isPreLayout() && (i = this.P) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                anchorInfo.f31199a = this.P;
                anchorInfo.b = this.f5421a.f5440a[anchorInfo.f31199a];
                SavedState savedState2 = this.f5417a;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    anchorInfo.c = this.f5414a.getStartAfterPadding() + savedState.mAnchorOffset;
                    anchorInfo.f5428c = true;
                    anchorInfo.b = -1;
                    return true;
                }
                if (this.Q != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.f5423a) {
                        anchorInfo.c = this.f5414a.getStartAfterPadding() + this.Q;
                    } else {
                        anchorInfo.c = this.Q - this.f5414a.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.P);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        anchorInfo.f5426a = this.P < getPosition(childAt);
                    }
                    anchorInfo.r();
                } else {
                    if (this.f5414a.getDecoratedMeasurement(viewFindViewByPosition) > this.f5414a.getTotalSpace()) {
                        anchorInfo.r();
                        return true;
                    }
                    if (this.f5414a.getDecoratedStart(viewFindViewByPosition) - this.f5414a.getStartAfterPadding() < 0) {
                        anchorInfo.c = this.f5414a.getStartAfterPadding();
                        anchorInfo.f5426a = false;
                        return true;
                    }
                    if (this.f5414a.getEndAfterPadding() - this.f5414a.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        anchorInfo.c = this.f5414a.getEndAfterPadding();
                        anchorInfo.f5426a = true;
                        return true;
                    }
                    anchorInfo.c = anchorInfo.f5426a ? this.f5414a.getDecoratedEnd(viewFindViewByPosition) + this.f5414a.getTotalSpaceChange() : this.f5414a.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.P = -1;
            this.Q = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void K(RecyclerView.State state, b anchorInfo) {
        if (J(state, anchorInfo, this.f5417a) || I(state, anchorInfo)) {
            return;
        }
        anchorInfo.r();
        anchorInfo.f31199a = 0;
        anchorInfo.b = 0;
    }

    public final void L(int positionStart) {
        if (positionStart >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f5421a.t(childCount);
        this.f5421a.u(childCount);
        this.f5421a.s(childCount);
        if (positionStart >= this.f5421a.f5440a.length) {
            return;
        }
        this.T = positionStart;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.P = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            this.Q = this.f5414a.getDecoratedStart(childClosestToStart) - this.f5414a.getStartAfterPadding();
        } else {
            this.Q = this.f5414a.getDecoratedEnd(childClosestToStart) + this.f5414a.getEndPadding();
        }
    }

    public final void M(int childCount) {
        boolean z;
        int i;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i2 = this.R;
            z = (i2 == Integer.MIN_VALUE || i2 == width) ? false : true;
            i = this.f5419a.f5430a ? this.f5411a.getResources().getDisplayMetrics().heightPixels : this.f5419a.f31200a;
        } else {
            int i3 = this.S;
            z = (i3 == Integer.MIN_VALUE || i3 == height) ? false : true;
            i = this.f5419a.f5430a ? this.f5411a.getResources().getDisplayMetrics().widthPixels : this.f5419a.f31200a;
        }
        int i4 = i;
        this.R = width;
        this.S = height;
        int i5 = this.T;
        if (i5 == -1 && (this.P != -1 || z)) {
            if (this.f5418a.f5426a) {
                return;
            }
            this.f5422a.clear();
            this.f5420a.a();
            if (isMainAxisDirectionHorizontal()) {
                this.f5421a.e(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.f5418a.f31199a, this.f5422a);
            } else {
                this.f5421a.h(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.f5418a.f31199a, this.f5422a);
            }
            this.f5422a = this.f5420a.f5443a;
            this.f5421a.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f5421a.X();
            b bVar = this.f5418a;
            bVar.b = this.f5421a.f5440a[bVar.f31199a];
            this.f5419a.b = this.f5418a.b;
            return;
        }
        int iMin = i5 != -1 ? Math.min(i5, this.f5418a.f31199a) : this.f5418a.f31199a;
        this.f5420a.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.f5422a.size() > 0) {
                this.f5421a.j(this.f5422a, iMin);
                this.f5421a.b(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i4, iMin, this.f5418a.f31199a, this.f5422a);
            } else {
                this.f5421a.s(childCount);
                this.f5421a.d(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i4, 0, this.f5422a);
            }
        } else if (this.f5422a.size() > 0) {
            this.f5421a.j(this.f5422a, iMin);
            this.f5421a.b(this.f5420a, iMakeMeasureSpec2, iMakeMeasureSpec, i4, iMin, this.f5418a.f31199a, this.f5422a);
        } else {
            this.f5421a.s(childCount);
            this.f5421a.g(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i4, 0, this.f5422a);
        }
        this.f5422a = this.f5420a.f5443a;
        this.f5421a.q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.f5421a.Y(iMin);
    }

    public final void N(int layoutDirection, int absDelta) {
        this.f5419a.h = layoutDirection;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !zIsMainAxisDirectionHorizontal && this.f5423a;
        if (layoutDirection == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f5419a.d = this.f5414a.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewP = p(childAt, this.f5422a.get(this.f5421a.f5440a[position]));
            this.f5419a.g = 1;
            c cVar = this.f5419a;
            cVar.c = position + cVar.g;
            if (this.f5421a.f5440a.length <= this.f5419a.c) {
                this.f5419a.b = -1;
            } else {
                c cVar2 = this.f5419a;
                cVar2.b = this.f5421a.f5440a[cVar2.c];
            }
            if (z) {
                this.f5419a.d = this.f5414a.getDecoratedStart(viewP);
                this.f5419a.e = (-this.f5414a.getDecoratedStart(viewP)) + this.f5414a.getStartAfterPadding();
                c cVar3 = this.f5419a;
                cVar3.e = Math.max(cVar3.e, 0);
            } else {
                this.f5419a.d = this.f5414a.getDecoratedEnd(viewP);
                this.f5419a.e = this.f5414a.getDecoratedEnd(viewP) - this.f5414a.getEndAfterPadding();
            }
            if ((this.f5419a.b == -1 || this.f5419a.b > this.f5422a.size() - 1) && this.f5419a.c <= getFlexItemCount()) {
                int i = absDelta - this.f5419a.e;
                this.f5420a.a();
                if (i > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.f5421a.d(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i, this.f5419a.c, this.f5422a);
                    } else {
                        this.f5421a.g(this.f5420a, iMakeMeasureSpec, iMakeMeasureSpec2, i, this.f5419a.c, this.f5422a);
                    }
                    this.f5421a.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f5419a.c);
                    this.f5421a.Y(this.f5419a.c);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f5419a.d = this.f5414a.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewN = n(childAt2, this.f5422a.get(this.f5421a.f5440a[position2]));
            this.f5419a.g = 1;
            int i2 = this.f5421a.f5440a[position2];
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 > 0) {
                this.f5419a.c = position2 - this.f5422a.get(i2 - 1).c();
            } else {
                this.f5419a.c = -1;
            }
            this.f5419a.b = i2 > 0 ? i2 - 1 : 0;
            if (z) {
                this.f5419a.d = this.f5414a.getDecoratedEnd(viewN);
                this.f5419a.e = this.f5414a.getDecoratedEnd(viewN) - this.f5414a.getEndAfterPadding();
                c cVar4 = this.f5419a;
                cVar4.e = Math.max(cVar4.e, 0);
            } else {
                this.f5419a.d = this.f5414a.getDecoratedStart(viewN);
                this.f5419a.e = (-this.f5414a.getDecoratedStart(viewN)) + this.f5414a.getStartAfterPadding();
            }
        }
        c cVar5 = this.f5419a;
        cVar5.f31200a = absDelta - cVar5.e;
    }

    public final void O(b anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            G();
        } else {
            this.f5419a.f5430a = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            this.f5419a.f31200a = this.f5414a.getEndAfterPadding() - anchorInfo.c;
        } else {
            this.f5419a.f31200a = anchorInfo.c - getPaddingRight();
        }
        this.f5419a.c = anchorInfo.f31199a;
        this.f5419a.g = 1;
        this.f5419a.h = 1;
        this.f5419a.d = anchorInfo.c;
        this.f5419a.e = Integer.MIN_VALUE;
        this.f5419a.b = anchorInfo.b;
        if (!fromNextLine || this.f5422a.size() <= 1 || anchorInfo.b < 0 || anchorInfo.b >= this.f5422a.size() - 1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f5422a.get(anchorInfo.b);
        c.l(this.f5419a);
        c.u(this.f5419a, aVar.c());
    }

    public final void P(b anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            G();
        } else {
            this.f5419a.f5430a = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            this.f5419a.f31200a = anchorInfo.c - this.f5414a.getStartAfterPadding();
        } else {
            this.f5419a.f31200a = (this.f5413a.getWidth() - anchorInfo.c) - this.f5414a.getStartAfterPadding();
        }
        this.f5419a.c = anchorInfo.f31199a;
        this.f5419a.g = 1;
        this.f5419a.h = -1;
        this.f5419a.d = anchorInfo.c;
        this.f5419a.e = Integer.MIN_VALUE;
        this.f5419a.b = anchorInfo.b;
        if (!fromPreviousLine || anchorInfo.b <= 0 || this.f5422a.size() <= anchorInfo.b) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f5422a.get(anchorInfo.b);
        c.m(this.f5419a);
        c.v(this.f5419a, aVar.c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.L == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.f5413a;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.L == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.f5413a;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        k();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        return Math.min(this.f5414a.getTotalSpace(), this.f5414a.getDecoratedEnd(viewO) - this.f5414a.getDecoratedStart(viewM));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() != 0 && viewM != null && viewO != null) {
            int position = getPosition(viewM);
            int position2 = getPosition(viewO);
            int iAbs = Math.abs(this.f5414a.getDecoratedEnd(viewO) - this.f5414a.getDecoratedStart(viewM));
            int[] iArr = this.f5421a.f5440a;
            int i = iArr[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((iArr[position2] - i) + 1))) + (this.f5414a.getStartAfterPadding() - this.f5414a.getDecoratedStart(viewM)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        return (int) ((Math.abs(this.f5414a.getDecoratedEnd(viewO) - this.f5414a.getDecoratedStart(viewM)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition()) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int targetPosition) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i = targetPosition < getPosition(childAt) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(0.0f, i) : new PointF(i, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final void ensureLayoutState() {
        if (this.f5419a == null) {
            this.f5419a = new c();
        }
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewQ = q(0, getChildCount(), true);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findFirstVisibleItemPosition() {
        View viewQ = q(0, getChildCount(), false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewQ = q(getChildCount() - 1, -1, true);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findLastVisibleItemPosition() {
        View viewQ = q(getChildCount() - 1, -1, false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public final int fixLayoutEndGap(int endOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int iX;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.f5423a) {
            int startAfterPadding = endOffset - this.f5414a.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iX = x(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.f5414a.getEndAfterPadding() - endOffset;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iX = -x(-endAfterPadding2, recycler, state);
        }
        int i = endOffset + iX;
        if (!canOffsetChildren || (endAfterPadding = this.f5414a.getEndAfterPadding() - i) <= 0) {
            return iX;
        }
        this.f5414a.offsetChildren(endAfterPadding);
        return endAfterPadding + iX;
    }

    public final int fixLayoutStartGap(int startOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int iX;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            int startAfterPadding2 = startOffset - this.f5414a.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iX = -x(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.f5414a.getEndAfterPadding() - startOffset;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iX = x(-endAfterPadding, recycler, state);
        }
        int i = startOffset + iX;
        if (!canOffsetChildren || (startAfterPadding = i - this.f5414a.getStartAfterPadding()) <= 0) {
            return iX;
        }
        this.f5414a.offsetChildren(-startAfterPadding);
        return iX - startAfterPadding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c2, AttributeSet attrs) {
        return new LayoutParams(c2, attrs);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.N;
    }

    public final View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), padding, childDimension, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), padding, childDimension, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.K;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int index) {
        View view = this.f5412a.get(index);
        return view != null ? view : this.f5415a.getViewForPosition(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.f5416a.getItemCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    @NonNull
    public List<com.google.android.flexbox.a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f5422a.size());
        int size = this.f5422a.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.a aVar = this.f5422a.get(i);
            if (aVar.c() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<com.google.android.flexbox.a> getFlexLinesInternal() {
        return this.f5422a;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.L;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.M;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.f5422a.size() == 0) {
            return 0;
        }
        int size = this.f5422a.size();
        int iMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.f5422a.get(i).e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.O;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.c;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int index) {
        return getFlexItemAt(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.f5422a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.f5422a.get(i2).g;
        }
        return i;
    }

    public final boolean h(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            return this.f5414a.getDecoratedStart(view) >= this.f5414a.getEnd() - scrollingOffset;
        }
        return this.f5414a.getDecoratedEnd(view) <= scrollingOffset;
    }

    public final boolean i(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.f5423a) {
            return this.f5414a.getDecoratedEnd(view) <= scrollingOffset;
        }
        return this.f5414a.getEnd() - this.f5414a.getDecoratedStart(view) <= scrollingOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRtl() {
        return this.f5423a;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.K;
        return i == 0 || i == 1;
    }

    public final void j() {
        this.f5422a.clear();
        this.f5418a.t();
        this.f5418a.f5429d = 0;
    }

    public final void k() {
        if (this.f5414a != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.L == 0) {
                this.f5414a = OrientationHelper.createHorizontalHelper(this);
                this.b = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f5414a = OrientationHelper.createVerticalHelper(this);
                this.b = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.L == 0) {
            this.f5414a = OrientationHelper.createVerticalHelper(this);
            this.b = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f5414a = OrientationHelper.createHorizontalHelper(this);
            this.b = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int l(RecyclerView.Recycler recycler, RecyclerView.State state, c layoutState) {
        if (layoutState.e != Integer.MIN_VALUE) {
            if (layoutState.f31200a < 0) {
                c.q(layoutState, layoutState.f31200a);
            }
            D(recycler, layoutState);
        }
        int i = layoutState.f31200a;
        int iA = layoutState.f31200a;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iA2 = 0;
        while (true) {
            if ((iA <= 0 && !this.f5419a.f5430a) || !layoutState.D(state, this.f5422a)) {
                break;
            }
            com.google.android.flexbox.a aVar = this.f5422a.get(layoutState.b);
            layoutState.c = aVar.l;
            iA2 += A(aVar, layoutState);
            if (zIsMainAxisDirectionHorizontal || !this.f5423a) {
                c.c(layoutState, aVar.a() * layoutState.h);
            } else {
                c.d(layoutState, aVar.a() * layoutState.h);
            }
            iA -= aVar.a();
        }
        c.i(layoutState, iA2);
        if (layoutState.e != Integer.MIN_VALUE) {
            c.q(layoutState, iA2);
            if (layoutState.f31200a < 0) {
                c.q(layoutState, layoutState.f31200a);
            }
            D(recycler, layoutState);
        }
        return i - layoutState.f31200a;
    }

    public final View m(int itemCount) {
        View viewR = r(0, getChildCount(), itemCount);
        if (viewR == null) {
            return null;
        }
        int i = this.f5421a.f5440a[getPosition(viewR)];
        if (i == -1) {
            return null;
        }
        return n(viewR, this.f5422a.get(i));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public final View n(View firstView, com.google.android.flexbox.a firstVisibleLine) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = firstVisibleLine.h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f5423a || zIsMainAxisDirectionHorizontal) {
                    if (this.f5414a.getDecoratedStart(firstView) > this.f5414a.getDecoratedStart(childAt)) {
                        firstView = childAt;
                    }
                } else if (this.f5414a.getDecoratedEnd(firstView) < this.f5414a.getDecoratedEnd(childAt)) {
                    firstView = childAt;
                }
            }
        }
        return firstView;
    }

    public final View o(int itemCount) {
        View viewR = r(getChildCount() - 1, -1, itemCount);
        if (viewR == null) {
            return null;
        }
        return p(viewR, this.f5422a.get(this.f5421a.f5440a[getPosition(viewR)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f5413a = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.c) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        L(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        L(Math.min(from, to));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        L(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        L(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.f5415a = recycler;
        this.f5416a = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        H();
        k();
        ensureLayoutState();
        this.f5421a.t(itemCount);
        this.f5421a.u(itemCount);
        this.f5421a.s(itemCount);
        this.f5419a.f5431b = false;
        SavedState savedState = this.f5417a;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.P = this.f5417a.mAnchorPosition;
        }
        if (!this.f5418a.f5427b || this.P != -1 || this.f5417a != null) {
            this.f5418a.t();
            K(state, this.f5418a);
            this.f5418a.f5427b = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f5418a.f5426a) {
            P(this.f5418a, false, true);
        } else {
            O(this.f5418a, false, true);
        }
        M(itemCount);
        l(recycler, state, this.f5419a);
        if (this.f5418a.f5426a) {
            i2 = this.f5419a.d;
            O(this.f5418a, true, false);
            l(recycler, state, this.f5419a);
            i = this.f5419a.d;
        } else {
            i = this.f5419a.d;
            P(this.f5418a, true, false);
            l(recycler, state, this.f5419a);
            i2 = this.f5419a.d;
        }
        if (getChildCount() > 0) {
            if (this.f5418a.f5426a) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f5417a = null;
        this.P = -1;
        this.Q = Integer.MIN_VALUE;
        this.T = -1;
        this.f5418a.t();
        this.f5412a.clear();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, com.google.android.flexbox.a flexLine) {
        calculateItemDecorationsForChild(view, f31198a);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.e += leftDecorationWidth;
            flexLine.f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            flexLine.e += topDecorationHeight;
            flexLine.f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(com.google.android.flexbox.a flexLine) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.f5417a = (SavedState) state;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f5417a != null) {
            return new SavedState(this.f5417a);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.f5414a.getDecoratedStart(childClosestToStart) - this.f5414a.getStartAfterPadding();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    public final View p(View lastView, com.google.android.flexbox.a lastVisibleLine) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - lastVisibleLine.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f5423a || zIsMainAxisDirectionHorizontal) {
                    if (this.f5414a.getDecoratedEnd(lastView) < this.f5414a.getDecoratedEnd(childAt)) {
                        lastView = childAt;
                    }
                } else if (this.f5414a.getDecoratedStart(lastView) > this.f5414a.getDecoratedStart(childAt)) {
                    lastView = childAt;
                }
            }
        }
        return lastView;
    }

    public final View q(int fromIndex, int toIndex, boolean completelyVisible) {
        int i = toIndex > fromIndex ? 1 : -1;
        while (fromIndex != toIndex) {
            View childAt = getChildAt(fromIndex);
            if (z(childAt, completelyVisible)) {
                return childAt;
            }
            fromIndex += i;
        }
        return null;
    }

    public final View r(int start, int end, int itemCount) {
        int position;
        k();
        ensureLayoutState();
        int startAfterPadding = this.f5414a.getStartAfterPadding();
        int endAfterPadding = this.f5414a.getEndAfterPadding();
        int i = end > start ? 1 : -1;
        View view = null;
        View view2 = null;
        while (start != end) {
            View childAt = getChildAt(start);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f5414a.getDecoratedStart(childAt) >= startAfterPadding && this.f5414a.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            start += i;
        }
        return view != null ? view : view2;
    }

    public final void recycleChildren(RecyclerView.Recycler recycler, int startIndex, int endIndex) {
        while (endIndex >= startIndex) {
            removeAndRecycleViewAt(endIndex, recycler);
            endIndex--;
        }
    }

    public final int s(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.L == 0) {
            int iX = x(dx, recycler, state);
            this.f5412a.clear();
            return iX;
        }
        int iY = y(dx);
        b.l(this.f5418a, iY);
        this.b.offsetChildren(-iY);
        return iY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.P = position;
        this.Q = Integer.MIN_VALUE;
        SavedState savedState = this.f5417a;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.L == 0 && !isMainAxisDirectionHorizontal())) {
            int iX = x(dy, recycler, state);
            this.f5412a.clear();
            return iX;
        }
        int iY = y(dy);
        b.l(this.f5418a, iY);
        this.b.offsetChildren(-iY);
        return iY;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int alignItems) {
        int i = this.N;
        if (i != alignItems) {
            if (i == 4 || alignItems == 4) {
                removeAllViews();
                j();
            }
            this.N = alignItems;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int flexDirection) {
        if (this.K != flexDirection) {
            removeAllViews();
            this.K = flexDirection;
            this.f5414a = null;
            this.b = null;
            j();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<com.google.android.flexbox.a> flexLines) {
        this.f5422a = flexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int flexWrap) {
        if (flexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i = this.L;
        if (i != flexWrap) {
            if (i == 0 || flexWrap == 0) {
                removeAllViews();
                j();
            }
            this.L = flexWrap;
            this.f5414a = null;
            this.b = null;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int justifyContent) {
        if (this.M != justifyContent) {
            this.M = justifyContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int maxLine) {
        if (this.O != maxLine) {
            this.O = maxLine;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.c = recycleChildrenOnDetach;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public final int t(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int u(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int position, View view) {
        this.f5412a.put(position, view);
    }

    public final int v(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public int w(int position) {
        return this.f5421a.f5440a[position];
    }

    public final int x(int delta, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        k();
        int i = 1;
        this.f5419a.f5431b = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.f5423a;
        if (!z ? delta <= 0 : delta >= 0) {
            i = -1;
        }
        int iAbs = Math.abs(delta);
        N(i, iAbs);
        int iL = this.f5419a.e + l(recycler, state, this.f5419a);
        if (iL < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iL) {
                delta = (-i) * iL;
            }
        } else if (iAbs > iL) {
            delta = i * iL;
        }
        this.f5414a.offsetChildren(-delta);
        this.f5419a.f = delta;
        return delta;
    }

    public final int y(int delta) {
        int iMin;
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        k();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.f5413a;
        int width = zIsMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(delta);
            if (delta < 0) {
                iMin = Math.min((width2 + this.f5418a.f5429d) - width, iAbs);
            } else {
                if (this.f5418a.f5429d + delta <= 0) {
                    return delta;
                }
                iMin = this.f5418a.f5429d;
            }
        } else {
            if (delta > 0) {
                return Math.min((width2 - this.f5418a.f5429d) - width, delta);
            }
            if (this.f5418a.f5429d + delta >= 0) {
                return delta;
            }
            iMin = this.f5418a.f5429d;
        }
        return -iMin;
    }

    public final boolean z(View view, boolean completelyVisible) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iT = t(view);
        int iV = v(view);
        int iU = u(view);
        int iS = s(view);
        boolean z = paddingLeft <= iT && width >= iU;
        boolean z2 = iT >= width || iU >= paddingLeft;
        boolean z3 = paddingTop <= iV && height >= iS;
        boolean z4 = iV >= height || iS >= paddingTop;
        if (completelyVisible) {
            return z && z3;
        }
        return z2 && z4;
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int itemCount) {
            int i = this.mAnchorPosition;
            return i >= 0 && i < itemCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mAnchorPosition);
            dest.writeInt(this.mAnchorOffset);
        }

        public SavedState() {
        }

        private SavedState(Parcel in) {
            this.mAnchorPosition = in.readInt();
            this.mAnchorOffset = in.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.O = -1;
        this.f5422a = new ArrayList();
        this.f5421a = new com.google.android.flexbox.b(this);
        this.f5418a = new b();
        this.P = -1;
        this.Q = Integer.MIN_VALUE;
        this.R = Integer.MIN_VALUE;
        this.S = Integer.MIN_VALUE;
        this.f5412a = new SparseArray<>();
        this.T = -1;
        this.f5420a = new com.google.android.flexbox.b.C0706b();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        this.f5411a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        L(positionStart);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int alignSelf) {
            this.mAlignSelf = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float flexBasisPercent) {
            this.mFlexBasisPercent = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float flexGrow) {
            this.mFlexGrow = flexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float flexShrink) {
            this.mFlexShrink = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            ((ViewGroup.MarginLayoutParams) this).height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.mMaxHeight = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.mMaxWidth = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            ((ViewGroup.MarginLayoutParams) this).width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean wrapBefore) {
            this.mWrapBefore = wrapBefore;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = source.mFlexGrow;
            this.mFlexShrink = source.mFlexShrink;
            this.mAlignSelf = source.mAlignSelf;
            this.mFlexBasisPercent = source.mFlexBasisPercent;
            this.mMinWidth = source.mMinWidth;
            this.mMinHeight = source.mMinHeight;
            this.mMaxWidth = source.mMaxWidth;
            this.mMaxHeight = source.mMaxHeight;
            this.mWrapBefore = source.mWrapBefore;
        }

        public LayoutParams(Parcel in) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = in.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.O = -1;
        this.f5422a = new ArrayList();
        this.f5421a = new com.google.android.flexbox.b(this);
        this.f5418a = new b();
        this.P = -1;
        this.Q = Integer.MIN_VALUE;
        this.R = Integer.MIN_VALUE;
        this.S = Integer.MIN_VALUE;
        this.f5412a = new SparseArray<>();
        this.T = -1;
        this.f5420a = new com.google.android.flexbox.b.C0706b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attrs, defStyleAttr, defStyleRes);
        int i = properties.orientation;
        if (i != 0) {
            if (i == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.f5411a = context;
    }
}
