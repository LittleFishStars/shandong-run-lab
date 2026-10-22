package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Drawable f31197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseIntArray f5406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b.C0706b f5407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f5408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<a> f5409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f5410a;

    @Nullable
    public Drawable b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public final boolean a(int flexLineIndex) {
        for (int i = 0; i < flexLineIndex; i++) {
            if (this.f5409a.get(i).d() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.f5406a == null) {
            this.f5406a = new SparseIntArray(getChildCount());
        }
        this.f5410a = this.f5408a.n(child, index, params, this.f5406a);
        super.addView(child, index, params);
    }

    public final boolean b(int index, int indexInFlexLine) {
        for (int i = 1; i <= indexInFlexLine; i++) {
            View reorderedChildAt = getReorderedChildAt(index - i);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void c(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f5409a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f5409a.get(i);
            for (int i2 = 0; i2 < aVar.h; i2++) {
                int i3 = aVar.l + i2;
                View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i3, i2)) {
                        f(canvas, isRtl ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.T, aVar.f5435b, aVar.g);
                    }
                    if (i2 == aVar.h - 1 && (this.R & 4) > 0) {
                        f(canvas, isRtl ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.T : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, aVar.f5435b, aVar.g);
                    }
                }
            }
            if (h(i)) {
                e(canvas, paddingLeft, fromBottomToTop ? aVar.d : aVar.f5435b - this.S, iMax);
            }
            if (i(i) && (this.Q & 4) > 0) {
                e(canvas, paddingLeft, fromBottomToTop ? aVar.f5435b - this.S : aVar.d, iMax);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public final void d(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f5409a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f5409a.get(i);
            for (int i2 = 0; i2 < aVar.h; i2++) {
                int i3 = aVar.l + i2;
                View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i3, i2)) {
                        e(canvas, aVar.f5432a, fromBottomToTop ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.S, aVar.g);
                    }
                    if (i2 == aVar.h - 1 && (this.Q & 4) > 0) {
                        e(canvas, aVar.f5432a, fromBottomToTop ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.S : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, aVar.g);
                    }
                }
            }
            if (h(i)) {
                f(canvas, isRtl ? aVar.c : aVar.f5432a - this.T, paddingTop, iMax);
            }
            if (i(i) && (this.R & 4) > 0) {
                f(canvas, isRtl ? aVar.f5432a - this.T : aVar.c, paddingTop, iMax);
            }
        }
    }

    public final void e(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.f31197a;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, length + left, this.S + top);
        this.f31197a.draw(canvas);
    }

    public final void f(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, this.T + left, length + top);
        this.b.draw(canvas);
    }

    public final boolean g(int index, int indexInFlexLine) {
        if (b(index, indexInFlexLine)) {
            if (isMainAxisDirectionHorizontal()) {
                return (this.R & 1) != 0;
            }
            return (this.Q & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.R & 2) != 0;
        }
        return (this.Q & 2) != 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.O;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.N;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(heightSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(widthSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int i;
        int i2;
        if (isMainAxisDirectionHorizontal()) {
            i = g(index, indexInFlexLine) ? 0 + this.T : 0;
            if ((this.R & 4) <= 0) {
                return i;
            }
            i2 = this.T;
        } else {
            i = g(index, indexInFlexLine) ? 0 + this.S : 0;
            if ((this.Q & 4) <= 0) {
                return i;
            }
            i2 = this.S;
        }
        return i + i2;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f31197a;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.b;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.K;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int index) {
        return getChildAt(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f5409a.size());
        for (a aVar : this.f5409a) {
            if (aVar.d() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLinesInternal() {
        return this.f5409a;
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
        Iterator<a> it = this.f5409a.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.P;
    }

    public View getReorderedChildAt(int index) {
        if (index < 0) {
            return null;
        }
        int[] iArr = this.f5410a;
        if (index >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[index]);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int index) {
        return getReorderedChildAt(index);
    }

    public int getShowDividerHorizontal() {
        return this.Q;
    }

    public int getShowDividerVertical() {
        return this.R;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.f5409a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f5409a.get(i2);
            if (h(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.S : this.T;
            }
            if (i(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.S : this.T;
            }
            i += aVar.g;
        }
        return i;
    }

    public final boolean h(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f5409a.size()) {
            return false;
        }
        if (a(flexLineIndex)) {
            if (isMainAxisDirectionHorizontal()) {
                return (this.Q & 1) != 0;
            }
            return (this.R & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.Q & 2) != 0;
        }
        return (this.R & 2) != 0;
    }

    public final boolean i(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f5409a.size()) {
            return false;
        }
        for (int i = flexLineIndex + 1; i < this.f5409a.size(); i++) {
            if (this.f5409a.get(i).d() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.Q & 4) != 0;
        }
        return (this.R & 4) != 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.K;
        return i == 0 || i == 1;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:48:0x0107  */
    /* JADX WARN: Code duplicated, block: B:49:0x0111  */
    /* JADX WARN: Code duplicated, block: B:52:0x011a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0122  */
    /* JADX WARN: Code duplicated, block: B:55:0x0127  */
    /* JADX WARN: Code duplicated, block: B:59:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0132  */
    /* JADX WARN: Code duplicated, block: B:61:0x0163  */
    /* JADX WARN: Code duplicated, block: B:62:0x018d  */
    /* JADX WARN: Code duplicated, block: B:64:0x019a  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:71:0x020c  */
    public final void j(boolean isRtl, int left, int top, int right, int bottom) {
        float measuredWidth;
        float f;
        float f2;
        float fMax;
        int i;
        int i2;
        View reorderedChildAt;
        int i3;
        int i4;
        int i5;
        char c;
        LayoutParams layoutParams;
        float f3;
        float f4;
        float f5;
        int i6;
        char c2;
        int i7;
        LayoutParams layoutParams2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i8 = right - left;
        int paddingBottom = (bottom - top) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f5409a.size();
        int i9 = 0;
        while (i9 < size) {
            a aVar = this.f5409a.get(i9);
            if (h(i9)) {
                int i10 = this.S;
                paddingBottom -= i10;
                paddingTop += i10;
            }
            int i11 = this.M;
            char c3 = 4;
            int i12 = 1;
            if (i11 == 0) {
                measuredWidth = paddingLeft;
                f = i8 - paddingRight;
            } else if (i11 != 1) {
                if (i11 == 2) {
                    int i13 = aVar.e;
                    measuredWidth = paddingLeft + ((i8 - i13) / 2.0f);
                    f = (i8 - paddingRight) - ((i8 - i13) / 2.0f);
                } else if (i11 == 3) {
                    measuredWidth = paddingLeft;
                    int iD = aVar.d();
                    f2 = (i8 - aVar.e) / (iD != 1 ? iD - 1 : 1.0f);
                    f = i8 - paddingRight;
                } else if (i11 == 4) {
                    int iD2 = aVar.d();
                    f2 = iD2 != 0 ? (i8 - aVar.e) / iD2 : 0.0f;
                    float f6 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f6;
                    f = (i8 - paddingRight) - f6;
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.M);
                    }
                    int iD3 = aVar.d();
                    f2 = iD3 != 0 ? (i8 - aVar.e) / (iD3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i8 - paddingRight) - f2;
                }
                fMax = Math.max(f2, 0.0f);
                i = 0;
                while (i < aVar.h) {
                    i2 = aVar.l + i;
                    reorderedChildAt = getReorderedChildAt(i2);
                    if (reorderedChildAt != null) {
                        i3 = paddingLeft;
                        i4 = i12;
                        i5 = i;
                        c = c3;
                    } else if (reorderedChildAt.getVisibility() == 8) {
                        i3 = paddingLeft;
                        i4 = i12;
                        i5 = i;
                        c = 4;
                    } else {
                        layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f3 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        f4 = f - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        if (g(i2, i)) {
                            int i14 = this.T;
                            float f7 = i14;
                            f3 += f7;
                            i6 = i14;
                            f5 = f4 - f7;
                        } else {
                            f5 = f4;
                            i6 = 0;
                        }
                        if (i == aVar.h - i12) {
                            c2 = 4;
                            i7 = (this.R & 4) > 0 ? this.T : 0;
                            if (this.L == 2) {
                                i3 = paddingLeft;
                                i4 = i12;
                                i5 = i;
                                layoutParams2 = layoutParams;
                                c = c2;
                                if (isRtl) {
                                    this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + reorderedChildAt.getMeasuredHeight());
                                } else {
                                    this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingTop, Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                                }
                            } else if (isRtl) {
                                i4 = i12;
                                i5 = i;
                                i3 = paddingLeft;
                                layoutParams2 = layoutParams;
                                c = c2;
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                i3 = paddingLeft;
                                i4 = i12;
                                i5 = i;
                                layoutParams2 = layoutParams;
                                c = c2;
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                            }
                            measuredWidth = f3 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                            float measuredWidth2 = f5 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                            if (isRtl) {
                                aVar.h(reorderedChildAt, i7, 0, i6, 0);
                            } else {
                                aVar.h(reorderedChildAt, i6, 0, i7, 0);
                            }
                            f = measuredWidth2;
                        } else {
                            c2 = 4;
                        }
                        if (this.L == 2) {
                            i3 = paddingLeft;
                            i4 = i12;
                            i5 = i;
                            layoutParams2 = layoutParams;
                            c = c2;
                            if (isRtl) {
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + reorderedChildAt.getMeasuredHeight());
                            } else {
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingTop, Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (isRtl) {
                            i4 = i12;
                            i5 = i;
                            i3 = paddingLeft;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i3 = paddingLeft;
                            i4 = i12;
                            i5 = i;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        float measuredWidth3 = f5 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        if (isRtl) {
                            aVar.h(reorderedChildAt, i7, 0, i6, 0);
                        } else {
                            aVar.h(reorderedChildAt, i6, 0, i7, 0);
                        }
                        f = measuredWidth3;
                    }
                    i = i5 + 1;
                    paddingLeft = i3;
                    i12 = i4;
                    c3 = c;
                }
                int i15 = paddingLeft;
                int i16 = aVar.g;
                paddingTop += i16;
                paddingBottom -= i16;
                i9++;
                paddingLeft = i15;
            } else {
                int i17 = aVar.e;
                f = i17 - paddingLeft;
                measuredWidth = (i8 - i17) + paddingRight;
            }
            f2 = 0.0f;
            fMax = Math.max(f2, 0.0f);
            i = 0;
            while (i < aVar.h) {
                i2 = aVar.l + i;
                reorderedChildAt = getReorderedChildAt(i2);
                if (reorderedChildAt != null) {
                    i3 = paddingLeft;
                    i4 = i12;
                    i5 = i;
                    c = c3;
                } else if (reorderedChildAt.getVisibility() == 8) {
                    i3 = paddingLeft;
                    i4 = i12;
                    i5 = i;
                    c = 4;
                } else {
                    layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    f3 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    f4 = f - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    if (g(i2, i)) {
                        int i18 = this.T;
                        float f8 = i18;
                        f3 += f8;
                        i6 = i18;
                        f5 = f4 - f8;
                    } else {
                        f5 = f4;
                        i6 = 0;
                    }
                    if (i == aVar.h - i12) {
                        c2 = 4;
                        if ((this.R & 4) > 0) {
                        }
                        if (this.L == 2) {
                            i3 = paddingLeft;
                            i4 = i12;
                            i5 = i;
                            layoutParams2 = layoutParams;
                            c = c2;
                            if (isRtl) {
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + reorderedChildAt.getMeasuredHeight());
                            } else {
                                this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingTop, Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (isRtl) {
                            i4 = i12;
                            i5 = i;
                            i3 = paddingLeft;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i3 = paddingLeft;
                            i4 = i12;
                            i5 = i;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        float measuredWidth4 = f5 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        if (isRtl) {
                            aVar.h(reorderedChildAt, i7, 0, i6, 0);
                        } else {
                            aVar.h(reorderedChildAt, i6, 0, i7, 0);
                        }
                        f = measuredWidth4;
                    } else {
                        c2 = 4;
                    }
                    if (this.L == 2) {
                        i3 = paddingLeft;
                        i4 = i12;
                        i5 = i;
                        layoutParams2 = layoutParams;
                        c = c2;
                        if (isRtl) {
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + reorderedChildAt.getMeasuredHeight());
                        } else {
                            this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingTop, Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                        }
                    } else if (isRtl) {
                        i4 = i12;
                        i5 = i;
                        i3 = paddingLeft;
                        layoutParams2 = layoutParams;
                        c = c2;
                        this.f5408a.Q(reorderedChildAt, aVar, Math.round(f5) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f5), paddingBottom);
                    } else {
                        i3 = paddingLeft;
                        i4 = i12;
                        i5 = i;
                        layoutParams2 = layoutParams;
                        c = c2;
                        this.f5408a.Q(reorderedChildAt, aVar, Math.round(f3), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f3) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                    }
                    measuredWidth = f3 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    float measuredWidth5 = f5 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                    if (isRtl) {
                        aVar.h(reorderedChildAt, i7, 0, i6, 0);
                    } else {
                        aVar.h(reorderedChildAt, i6, 0, i7, 0);
                    }
                    f = measuredWidth5;
                }
                i = i5 + 1;
                paddingLeft = i3;
                i12 = i4;
                c3 = c;
            }
            int i19 = paddingLeft;
            int i110 = aVar.g;
            paddingTop += i110;
            paddingBottom -= i110;
            i9++;
            paddingLeft = i19;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:49:0x0101  */
    /* JADX WARN: Code duplicated, block: B:50:0x010d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0119  */
    /* JADX WARN: Code duplicated, block: B:55:0x0121  */
    /* JADX WARN: Code duplicated, block: B:56:0x0126  */
    /* JADX WARN: Code duplicated, block: B:59:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x012e  */
    /* JADX WARN: Code duplicated, block: B:61:0x015d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0185  */
    /* JADX WARN: Code duplicated, block: B:64:0x018f  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:71:0x0206  */
    public final void k(boolean isRtl, boolean fromBottomToTop, int left, int top, int right, int bottom) {
        float f;
        int i;
        float f2;
        float f3;
        float fMax;
        int i2;
        int i3;
        View reorderedChildAt;
        int i4;
        boolean z;
        char c;
        LayoutParams layoutParams;
        float f4;
        float f5;
        float f6;
        float f7;
        int i5;
        char c2;
        int i6;
        LayoutParams layoutParams2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i7 = bottom - top;
        int i8 = (right - left) - paddingRight;
        int size = this.f5409a.size();
        for (int i9 = 0; i9 < size; i9++) {
            a aVar = this.f5409a.get(i9);
            if (h(i9)) {
                int i10 = this.T;
                paddingLeft += i10;
                i8 -= i10;
            }
            int i11 = this.M;
            char c3 = 4;
            boolean z2 = true;
            if (i11 != 0) {
                if (i11 == 1) {
                    int i12 = aVar.e;
                    f = (i7 - i12) + paddingBottom;
                    i = i12 - paddingTop;
                } else if (i11 == 2) {
                    int i13 = aVar.e;
                    f2 = (i7 - paddingBottom) - ((i7 - i13) / 2.0f);
                    f = paddingTop + ((i7 - i13) / 2.0f);
                    f3 = 0.0f;
                } else if (i11 == 3) {
                    f = paddingTop;
                    int iD = aVar.d();
                    f3 = (i7 - aVar.e) / (iD != 1 ? iD - 1 : 1.0f);
                    f2 = i7 - paddingBottom;
                } else if (i11 == 4) {
                    int iD2 = aVar.d();
                    f3 = iD2 != 0 ? (i7 - aVar.e) / iD2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i7 - paddingBottom) - f8;
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.M);
                    }
                    int iD3 = aVar.d();
                    f3 = iD3 != 0 ? (i7 - aVar.e) / (iD3 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i7 - paddingBottom) - f3;
                }
                fMax = Math.max(f3, 0.0f);
                i2 = 0;
                while (i2 < aVar.h) {
                    i3 = aVar.l + i2;
                    reorderedChildAt = getReorderedChildAt(i3);
                    if (reorderedChildAt != null) {
                        i4 = i2;
                        z = z2;
                        c = c3;
                    } else if (reorderedChildAt.getVisibility() == 8) {
                        i4 = i2;
                        z = true;
                        c = 4;
                    } else {
                        layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (g(i3, i2)) {
                            int i14 = this.S;
                            float f9 = i14;
                            f6 = f4 + f9;
                            i5 = i14;
                            f7 = f5 - f9;
                        } else {
                            f6 = f4;
                            f7 = f5;
                            i5 = 0;
                        }
                        if (i2 == aVar.h - 1) {
                            c2 = 4;
                            i6 = (this.Q & 4) > 0 ? this.S : 0;
                            if (isRtl) {
                                i4 = i2;
                                z = true;
                                layoutParams2 = layoutParams;
                                c = c2;
                                if (fromBottomToTop) {
                                    this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                                } else {
                                    this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f6), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                                }
                            } else if (fromBottomToTop) {
                                i4 = i2;
                                z = true;
                                layoutParams2 = layoutParams;
                                c = c2;
                                this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i8, Math.round(f7));
                            } else {
                                i4 = i2;
                                z = true;
                                layoutParams2 = layoutParams;
                                c = c2;
                                this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i8, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                            }
                            LayoutParams layoutParams3 = layoutParams2;
                            float measuredHeight = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                            float measuredHeight2 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                            if (fromBottomToTop) {
                                aVar.h(reorderedChildAt, 0, i6, 0, i5);
                            } else {
                                aVar.h(reorderedChildAt, 0, i5, 0, i6);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        } else {
                            c2 = 4;
                        }
                        if (isRtl) {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            if (fromBottomToTop) {
                                this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f6), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (fromBottomToTop) {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i8, Math.round(f7));
                        } else {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i8, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                        }
                        LayoutParams layoutParams4 = layoutParams2;
                        float measuredHeight3 = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
                        float measuredHeight4 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin);
                        if (fromBottomToTop) {
                            aVar.h(reorderedChildAt, 0, i6, 0, i5);
                        } else {
                            aVar.h(reorderedChildAt, 0, i5, 0, i6);
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight4;
                    }
                    i2 = i4 + 1;
                    z2 = z;
                    c3 = c;
                }
                int i15 = aVar.g;
                paddingLeft += i15;
                i8 -= i15;
            } else {
                f = paddingTop;
                i = i7 - paddingBottom;
            }
            f2 = i;
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i2 = 0;
            while (i2 < aVar.h) {
                i3 = aVar.l + i2;
                reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null) {
                    i4 = i2;
                    z = z2;
                    c = c3;
                } else if (reorderedChildAt.getVisibility() == 8) {
                    i4 = i2;
                    z = true;
                    c = 4;
                } else {
                    layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (g(i3, i2)) {
                        int i16 = this.S;
                        float f10 = i16;
                        f6 = f4 + f10;
                        i5 = i16;
                        f7 = f5 - f10;
                    } else {
                        f6 = f4;
                        f7 = f5;
                        i5 = 0;
                    }
                    if (i2 == aVar.h - 1) {
                        c2 = 4;
                        if ((this.Q & 4) > 0) {
                        }
                        if (isRtl) {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            if (fromBottomToTop) {
                                this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f6), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (fromBottomToTop) {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i8, Math.round(f7));
                        } else {
                            i4 = i2;
                            z = true;
                            layoutParams2 = layoutParams;
                            c = c2;
                            this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i8, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                        }
                        LayoutParams layoutParams5 = layoutParams2;
                        float measuredHeight5 = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                        float measuredHeight6 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin);
                        if (fromBottomToTop) {
                            aVar.h(reorderedChildAt, 0, i6, 0, i5);
                        } else {
                            aVar.h(reorderedChildAt, 0, i5, 0, i6);
                        }
                        f = measuredHeight5;
                        f2 = measuredHeight6;
                    } else {
                        c2 = 4;
                    }
                    if (isRtl) {
                        i4 = i2;
                        z = true;
                        layoutParams2 = layoutParams;
                        c = c2;
                        if (fromBottomToTop) {
                            this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                        } else {
                            this.f5408a.R(reorderedChildAt, aVar, false, paddingLeft, Math.round(f6), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                        }
                    } else if (fromBottomToTop) {
                        i4 = i2;
                        z = true;
                        layoutParams2 = layoutParams;
                        c = c2;
                        this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i8, Math.round(f7));
                    } else {
                        i4 = i2;
                        z = true;
                        layoutParams2 = layoutParams;
                        c = c2;
                        this.f5408a.R(reorderedChildAt, aVar, true, i8 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i8, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                    }
                    LayoutParams layoutParams6 = layoutParams2;
                    float measuredHeight7 = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                    float measuredHeight8 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin);
                    if (fromBottomToTop) {
                        aVar.h(reorderedChildAt, 0, i6, 0, i5);
                    } else {
                        aVar.h(reorderedChildAt, 0, i5, 0, i6);
                    }
                    f = measuredHeight7;
                    f2 = measuredHeight8;
                }
                i2 = i4 + 1;
                z2 = z;
                c3 = c;
            }
            int i17 = aVar.g;
            paddingLeft += i17;
            i8 -= i17;
        }
    }

    public final void l(int widthMeasureSpec, int heightMeasureSpec) {
        this.f5409a.clear();
        this.f5407a.a();
        this.f5408a.c(this.f5407a, widthMeasureSpec, heightMeasureSpec);
        this.f5409a = this.f5407a.f5443a;
        this.f5408a.p(widthMeasureSpec, heightMeasureSpec);
        if (this.N == 3) {
            for (a aVar : this.f5409a) {
                int iMax = Integer.MIN_VALUE;
                for (int i = 0; i < aVar.h; i++) {
                    View reorderedChildAt = getReorderedChildAt(aVar.l + i);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        iMax = this.L != 2 ? Math.max(iMax, reorderedChildAt.getMeasuredHeight() + Math.max(aVar.j - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((aVar.j - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                aVar.g = iMax;
            }
        }
        this.f5408a.o(widthMeasureSpec, heightMeasureSpec, getPaddingTop() + getPaddingBottom());
        this.f5408a.X();
        n(this.K, widthMeasureSpec, heightMeasureSpec, this.f5407a.f31203a);
    }

    public final void m(int widthMeasureSpec, int heightMeasureSpec) {
        this.f5409a.clear();
        this.f5407a.a();
        this.f5408a.f(this.f5407a, widthMeasureSpec, heightMeasureSpec);
        this.f5409a = this.f5407a.f5443a;
        this.f5408a.p(widthMeasureSpec, heightMeasureSpec);
        this.f5408a.o(widthMeasureSpec, heightMeasureSpec, getPaddingLeft() + getPaddingRight());
        this.f5408a.X();
        n(this.K, widthMeasureSpec, heightMeasureSpec, this.f5407a.f31203a);
    }

    public final void n(int flexDirection, int widthMeasureSpec, int heightMeasureSpec, int childState) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (flexDirection == 0 || flexDirection == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, widthMeasureSpec, childState);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, heightMeasureSpec, childState);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public final void o() {
        if (this.f31197a == null && this.b == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.b == null && this.f31197a == null) {
            return;
        }
        if (this.Q == 0 && this.R == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.K;
        if (i == 0) {
            c(canvas, layoutDirection == 1, this.L == 2);
            return;
        }
        if (i == 1) {
            c(canvas, layoutDirection != 1, this.L == 2);
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            if (this.L == 2) {
                z = !z;
            }
            d(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = layoutDirection == 1;
        if (this.L == 2) {
            z2 = !z2;
        }
        d(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.K;
        if (i == 0) {
            j(layoutDirection == 1, left, top, right, bottom);
            return;
        }
        if (i == 1) {
            j(layoutDirection != 1, left, top, right, bottom);
            return;
        }
        if (i == 2) {
            z = layoutDirection == 1;
            k(this.L == 2 ? !z : z, false, left, top, right, bottom);
        } else if (i == 3) {
            z = layoutDirection == 1;
            k(this.L == 2 ? !z : z, true, left, top, right, bottom);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.K);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f5406a == null) {
            this.f5406a = new SparseIntArray(getChildCount());
        }
        if (this.f5408a.O(this.f5406a)) {
            this.f5410a = this.f5408a.m(this.f5406a);
        }
        int i = this.K;
        if (i == 0 || i == 1) {
            l(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (i == 2 || i == 3) {
            m(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.K);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, a flexLine) {
        if (g(index, indexInFlexLine)) {
            if (isMainAxisDirectionHorizontal()) {
                int i = flexLine.e;
                int i2 = this.T;
                flexLine.e = i + i2;
                flexLine.f += i2;
                return;
            }
            int i3 = flexLine.e;
            int i4 = this.S;
            flexLine.e = i3 + i4;
            flexLine.f += i4;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(a flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.R & 4) > 0) {
                int i = flexLine.e;
                int i2 = this.T;
                flexLine.e = i + i2;
                flexLine.f += i2;
                return;
            }
            return;
        }
        if ((this.Q & 4) > 0) {
            int i3 = flexLine.e;
            int i4 = this.S;
            flexLine.e = i3 + i4;
            flexLine.f += i4;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int alignContent) {
        if (this.O != alignContent) {
            this.O = alignContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int alignItems) {
        if (this.N != alignItems) {
            this.N = alignItems;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable divider) {
        setDividerDrawableHorizontal(divider);
        setDividerDrawableVertical(divider);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable divider) {
        if (divider == this.f31197a) {
            return;
        }
        this.f31197a = divider;
        if (divider != null) {
            this.S = divider.getIntrinsicHeight();
        } else {
            this.S = 0;
        }
        o();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable divider) {
        if (divider == this.b) {
            return;
        }
        this.b = divider;
        if (divider != null) {
            this.T = divider.getIntrinsicWidth();
        } else {
            this.T = 0;
        }
        o();
        requestLayout();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int flexDirection) {
        if (this.K != flexDirection) {
            this.K = flexDirection;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<a> flexLines) {
        this.f5409a = flexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int flexWrap) {
        if (this.L != flexWrap) {
            this.L = flexWrap;
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
        if (this.P != maxLine) {
            this.P = maxLine;
            requestLayout();
        }
    }

    public void setShowDivider(int dividerMode) {
        setShowDividerVertical(dividerMode);
        setShowDividerHorizontal(dividerMode);
    }

    public void setShowDividerHorizontal(int dividerMode) {
        if (dividerMode != this.Q) {
            this.Q = dividerMode;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int dividerMode) {
        if (dividerMode != this.R) {
            this.R = dividerMode;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int position, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public FlexboxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.P = -1;
        this.f5408a = new b(this);
        this.f5409a = new ArrayList();
        this.f5407a = new b.C0706b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout, defStyleAttr, 0);
        this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.L = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.M = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.N = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.O = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.P = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i != 0) {
            this.R = i;
            this.Q = i;
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i2 != 0) {
            this.R = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i3 != 0) {
            this.Q = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) lp);
        }
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
        }
        return new LayoutParams(lp);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
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

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout_Layout);
            this.mOrder = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = typedArrayObtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
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
            return this.mOrder;
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
            this.mOrder = order;
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
            parcel.writeInt(this.mOrder);
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

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = source.mOrder;
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

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(new ViewGroup.LayoutParams(width, height));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Parcel in) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = in.readInt();
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
}
