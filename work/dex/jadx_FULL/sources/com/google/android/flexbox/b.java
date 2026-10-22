package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31202a = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f5437a = 4294967295L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final /* synthetic */ boolean f5438a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FlexContainer f5439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public int[] f5440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public long[] f5441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f5442a;

    @Nullable
    public long[] b;

    /* JADX INFO: renamed from: com.google.android.flexbox.b$b, reason: collision with other inner class name */
    public static class C0706b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31203a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<com.google.android.flexbox.a> f5443a;

        public void a() {
            this.f5443a = null;
            this.f31203a = 0;
        }
    }

    public static class c implements Comparable<c> {
        public int K;
        public int L;

        public c() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull c another) {
            int i = this.L;
            int i2 = another.L;
            return i != i2 ? i - i2 : this.K - another.K;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.L + ", index=" + this.K + '}';
        }
    }

    public b(FlexContainer flexContainer) {
        this.f5439a = flexContainer;
    }

    public final int A(int widthMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.f5439a;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(widthMeasureSpec, flexContainer.getPaddingLeft() + this.f5439a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    public final int B(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int C(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int D(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int E(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int F(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f5439a.getPaddingBottom() : this.f5439a.getPaddingEnd();
    }

    public final int I(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f5439a.getPaddingEnd() : this.f5439a.getPaddingBottom();
    }

    public final int J(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f5439a.getPaddingTop() : this.f5439a.getPaddingStart();
    }

    public final int K(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f5439a.getPaddingStart() : this.f5439a.getPaddingTop();
    }

    public final int L(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int childIndex, int childCount, com.google.android.flexbox.a flexLine) {
        return childIndex == childCount - 1 && flexLine.d() != 0;
    }

    public boolean O(SparseIntArray orderCache) {
        int flexItemCount = this.f5439a.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.f5439a.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != orderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.f5439a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.f5439a.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f5439a.getDecorationLengthMainAxis(view, index, indexInFlexLine);
        if (decorationLengthMainAxis > 0) {
            childLength += decorationLengthMainAxis;
        }
        return maxSize < currentLength + childLength;
    }

    public void Q(View view, com.google.android.flexbox.a flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f5439a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f5439a.getFlexWrap() == 2) {
                    view.layout(left, (top - i) + view.getMeasuredHeight() + flexItem.getMarginTop(), right, (bottom - i) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i2 = top + i;
                    view.layout(left, (i2 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), right, i2 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f5439a.getFlexWrap() != 2) {
                    int i3 = top + measuredHeight;
                    view.layout(left, i3, right, view.getMeasuredHeight() + i3);
                    return;
                } else {
                    int i4 = top - measuredHeight;
                    view.layout(left, i4, right, view.getMeasuredHeight() + i4);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f5439a.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.j - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(left, top + iMax, right, bottom + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((flexLine.j - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(left, top - iMax2, right, bottom - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f5439a.getFlexWrap() != 2) {
            view.layout(left, top + flexItem.getMarginTop(), right, bottom + flexItem.getMarginTop());
        } else {
            view.layout(left, top - flexItem.getMarginBottom(), right, bottom - flexItem.getMarginBottom());
        }
    }

    public void R(View view, com.google.android.flexbox.a flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f5439a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (isRtl) {
                    view.layout((left - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), top, (right - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), bottom);
                    return;
                } else {
                    view.layout(((left + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), top, ((right + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), bottom);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (isRtl) {
                    view.layout(left - measuredWidth, top, right - measuredWidth, bottom);
                    return;
                } else {
                    view.layout(left + measuredWidth, top, right + measuredWidth, bottom);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (isRtl) {
            view.layout(left - flexItem.getMarginRight(), top, right - flexItem.getMarginRight(), bottom);
        } else {
            view.layout(left + flexItem.getMarginLeft(), top, right + flexItem.getMarginLeft(), bottom);
        }
    }

    @VisibleForTesting
    public long S(int widthMeasureSpec, int heightMeasureSpec) {
        return (((long) widthMeasureSpec) & 4294967295L) | (((long) heightMeasureSpec) << 32);
    }

    public final void T(int widthMeasureSpec, int heightMeasureSpec, com.google.android.flexbox.a flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int i2;
        int iMax;
        int i3 = flexLine.e;
        float f = flexLine.b;
        float f2 = 0.0f;
        if (f <= 0.0f || maxMainSize > i3) {
            return;
        }
        float f3 = (i3 - maxMainSize) / f;
        flexLine.e = paddingAlongMainAxis + flexLine.f;
        if (!calledRecursively) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        float f4 = 0.0f;
        while (i4 < flexLine.h) {
            int i6 = flexLine.l + i4;
            View reorderedFlexItemAt = this.f5439a.getReorderedFlexItemAt(i6);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i = i3;
                i2 = i4;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f5439a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i = i3;
                    int i7 = i4;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.b;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i6]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.b;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i6]);
                    }
                    if (this.f5442a[i6] || flexItem.getFlexShrink() <= 0.0f) {
                        i2 = i7;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f3);
                        if (i2 == flexLine.h - 1) {
                            i2 = i7;
                            flexShrink += f4;
                            f4 = 0.0f;
                        }
                        i2 = i7;
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.f5442a[i6] = true;
                            flexLine.b -= flexItem.getFlexShrink();
                            z = true;
                        } else {
                            f4 += flexShrink - iRound;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iZ = z(heightMeasureSpec, flexItem, flexLine.k);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i6, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f5439a.updateViewCache(i6, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i5, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f5439a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.b;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i6]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.b;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i6]);
                    }
                    if (this.f5442a[i6] || flexItem.getFlexShrink() <= f2) {
                        i = i3;
                        i2 = i4;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f3);
                        if (i4 == flexLine.h - 1) {
                            flexShrink2 += f4;
                            f4 = f2;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.f5442a[i6] = true;
                            flexLine.b -= flexItem.getFlexShrink();
                            i = i3;
                            i2 = i4;
                            z = true;
                        } else {
                            f4 += flexShrink2 - iRound2;
                            i = i3;
                            i2 = i4;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        int iA = A(widthMeasureSpec, flexItem, flexLine.k);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i6, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f5439a.updateViewCache(i6, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i5, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f5439a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                flexLine.g = Math.max(flexLine.g, iMax);
                i5 = iMax;
            }
            i4 = i2 + 1;
            i3 = i;
            f2 = 0.0f;
        }
        int i8 = i3;
        if (!z || i8 == flexLine.e) {
            return;
        }
        T(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public final int[] U(int childCount, List<c> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i = 0;
        for (c cVar : orders) {
            int i2 = cVar.K;
            iArr[i] = i2;
            orderCache.append(i2, cVar.L);
            i++;
        }
        return iArr;
    }

    public final void V(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f5439a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.b;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[index]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(index, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f5439a.updateViewCache(index, view);
    }

    public final void W(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f5439a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.b;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[index]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(index, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f5439a.updateViewCache(index, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int fromIndex) {
        View reorderedFlexItemAt;
        if (fromIndex >= this.f5439a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f5439a.getFlexDirection();
        if (this.f5439a.getAlignItems() != 4) {
            for (com.google.android.flexbox.a aVar : this.f5439a.getFlexLinesInternal()) {
                for (Integer num : aVar.f5433a) {
                    View reorderedFlexItemAt2 = this.f5439a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, aVar.g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, aVar.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f5440a;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f5439a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i = iArr != null ? iArr[fromIndex] : 0; i < size; i++) {
            com.google.android.flexbox.a aVar2 = flexLinesInternal.get(i);
            int i2 = aVar2.h;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = aVar2.l + i3;
                if (i3 < this.f5439a.getFlexItemCount() && (reorderedFlexItemAt = this.f5439a.getReorderedFlexItemAt(i4)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, aVar2.g, i4);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, aVar2.g, i4);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.f5441a;
        if (jArr != null) {
            jArr[index] = S(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.b;
        if (jArr2 != null) {
            jArr2[index] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<com.google.android.flexbox.a> flexLines, com.google.android.flexbox.a flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.k = usedCrossSizeSoFar;
        this.f5439a.onNewFlexLineAdded(flexLine);
        flexLine.m = viewIndex;
        flexLines.add(flexLine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(C0706b c0706b, int i, int i2, int i3, int i4, int i5, @Nullable List<com.google.android.flexbox.a> list) {
        int i6;
        int i7;
        List<com.google.android.flexbox.a> list2;
        int i8;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i2;
        int i16 = i5;
        boolean zIsMainAxisDirectionHorizontal = this.f5439a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<com.google.android.flexbox.a> arrayList = list == null ? new ArrayList() : list;
        c0706b.f5443a = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int iK = K(zIsMainAxisDirectionHorizontal);
        int I = I(zIsMainAxisDirectionHorizontal);
        int iJ = J(zIsMainAxisDirectionHorizontal);
        int iH = H(zIsMainAxisDirectionHorizontal);
        com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
        int i18 = i4;
        aVar.l = i18;
        int i19 = I + iK;
        aVar.e = i19;
        int flexItemCount = this.f5439a.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View reorderedFlexItemAt = this.f5439a.getReorderedFlexItemAt(i18);
            if (reorderedFlexItemAt != null) {
                if (reorderedFlexItemAt.getVisibility() == 8) {
                    aVar.i++;
                    aVar.h++;
                    if (N(i18, flexItemCount, aVar)) {
                        a(arrayList, aVar, i18, i22);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        v((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i24 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        aVar.f5433a.add(Integer.valueOf(i18));
                    }
                    int iG = G(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        iG = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.f5439a.getChildWidthMeasureSpec(i, i19 + E(flexItem, true) + C(flexItem, true), iG);
                        int childHeightMeasureSpec = this.f5439a.getChildHeightMeasureSpec(i15, iJ + iH + D(flexItem, true) + B(flexItem, true) + i22, F(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        Z(i18, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i7 = childWidthMeasureSpec;
                    } else {
                        int childWidthMeasureSpec2 = this.f5439a.getChildWidthMeasureSpec(i15, iJ + iH + D(flexItem, false) + B(flexItem, false) + i22, F(flexItem, false));
                        int childHeightMeasureSpec2 = this.f5439a.getChildHeightMeasureSpec(i, E(flexItem, false) + i19 + C(flexItem, false), iG);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        Z(i18, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i7 = childHeightMeasureSpec2;
                    }
                    this.f5439a.updateViewCache(i18, reorderedFlexItemAt);
                    i(reorderedFlexItemAt, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i25 = aVar.e;
                    int i26 = i22;
                    int i27 = i19;
                    com.google.android.flexbox.a aVar2 = aVar;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (P(reorderedFlexItemAt, mode, i28, i25, C(flexItem, zIsMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i29, i23, arrayList.size())) {
                        if (aVar2.d() > 0) {
                            a(list2, aVar2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = aVar2.g + i26;
                        } else {
                            i22 = i26;
                        }
                        if (!zIsMainAxisDirectionHorizontal) {
                            i8 = i2;
                            view = reorderedFlexItemAt;
                            i18 = i29;
                            if (flexItem.getWidth() == -1) {
                                FlexContainer flexContainer = this.f5439a;
                                view.measure(flexContainer.getChildWidthMeasureSpec(i8, flexContainer.getPaddingLeft() + this.f5439a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i22, flexItem.getWidth()), i30);
                                i(view, i18);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            FlexContainer flexContainer2 = this.f5439a;
                            i8 = i2;
                            i18 = i29;
                            view = reorderedFlexItemAt;
                            view.measure(i30, flexContainer2.getChildHeightMeasureSpec(i8, flexContainer2.getPaddingTop() + this.f5439a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i22, flexItem.getHeight()));
                            i(view, i18);
                        } else {
                            i8 = i2;
                            view = reorderedFlexItemAt;
                            i18 = i29;
                        }
                        aVar = new com.google.android.flexbox.a();
                        i10 = 1;
                        aVar.h = 1;
                        i9 = i27;
                        aVar.e = i9;
                        aVar.l = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = reorderedFlexItemAt;
                        i18 = i29;
                        aVar = aVar2;
                        i9 = i27;
                        i10 = 1;
                        aVar.h++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    aVar.f5434a = (aVar.f5434a ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? i10 : 0);
                    aVar.f5436b = (aVar.f5436b ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? i10 : 0);
                    int[] iArr = this.f5440a;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    aVar.e += M(view, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal) + C(flexItem, zIsMainAxisDirectionHorizontal);
                    aVar.f31201a += flexItem.getFlexGrow();
                    aVar.b += flexItem.getFlexShrink();
                    this.f5439a.onNewFlexItemAdded(view, i18, i11, aVar);
                    int iMax = Math.max(i12, L(view, zIsMainAxisDirectionHorizontal) + D(flexItem, zIsMainAxisDirectionHorizontal) + B(flexItem, zIsMainAxisDirectionHorizontal) + this.f5439a.getDecorationLengthCrossAxis(view));
                    aVar.g = Math.max(aVar.g, iMax);
                    if (zIsMainAxisDirectionHorizontal) {
                        if (this.f5439a.getFlexWrap() != 2) {
                            aVar.j = Math.max(aVar.j, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            aVar.j = Math.max(aVar.j, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i13 = i24;
                    if (N(i18, i13, aVar)) {
                        a(list2, aVar, i18, i22);
                        i22 += aVar.g;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).m >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -aVar.a();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        c0706b.f31203a = i6;
                    } else {
                        i23 = i11;
                        i21 = iMax;
                    }
                }
                i18++;
                flexItemCount = i13;
                i15 = i8;
                i19 = i9;
                arrayList = list2;
                size = size;
                i16 = i14;
                mode = mode;
            } else if (N(i18, flexItemCount, aVar)) {
                a(arrayList, aVar, i18, i22);
            }
            size = size;
            mode = mode;
            i8 = i15;
            i14 = i16;
            list2 = arrayList;
            i9 = i19;
            i13 = flexItemCount;
            i18++;
            flexItemCount = i13;
            i15 = i8;
            i19 = i9;
            arrayList = list2;
            size = size;
            i16 = i14;
            mode = mode;
        }
        i6 = iCombineMeasuredStates;
        c0706b.f31203a = i6;
    }

    public void c(C0706b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(C0706b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<com.google.android.flexbox.a> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void e(C0706b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<com.google.android.flexbox.a> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    public void f(C0706b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(C0706b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<com.google.android.flexbox.a> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void h(C0706b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<com.google.android.flexbox.a> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void i(View view, int index) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth >= flexItem.getMinWidth()) {
            if (measuredWidth > flexItem.getMaxWidth()) {
                measuredWidth = flexItem.getMaxWidth();
            } else {
                z = false;
            }
            if (measuredHeight < flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                Z(index, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f5439a.updateViewCache(index, view);
            }
        }
        measuredWidth = flexItem.getMinWidth();
        z = true;
        if (measuredHeight < flexItem.getMinHeight()) {
            measuredHeight = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            measuredHeight = flexItem.getMaxHeight();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            Z(index, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.f5439a.updateViewCache(index, view);
        }
    }

    public void j(List<com.google.android.flexbox.a> flexLines, int fromFlexItem) {
        int i = this.f5440a[fromFlexItem];
        if (i == -1) {
            i = 0;
        }
        if (flexLines.size() > i) {
            flexLines.subList(i, flexLines.size()).clear();
        }
        int[] iArr = this.f5440a;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.f5441a;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    public final List<com.google.android.flexbox.a> k(List<com.google.android.flexbox.a> flexLines, int size, int totalCrossSize) {
        int i = (size - totalCrossSize) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
        aVar.g = i;
        int size2 = flexLines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 == 0) {
                arrayList.add(aVar);
            }
            arrayList.add(flexLines.get(i2));
            if (i2 == flexLines.size() - 1) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<c> l(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            FlexItem flexItem = (FlexItem) this.f5439a.getFlexItemAt(i).getLayoutParams();
            c cVar = new c();
            cVar.L = flexItem.getOrder();
            cVar.K = i;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray orderCache) {
        int flexItemCount = this.f5439a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), orderCache);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.f5439a.getFlexItemCount();
        List<c> listL = l(flexItemCount);
        c cVar = new c();
        if (viewBeforeAdded == null || !(paramsForViewBeforeAdded instanceof FlexItem)) {
            cVar.L = 1;
        } else {
            cVar.L = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        }
        if (indexForViewBeforeAdded == -1 || indexForViewBeforeAdded == flexItemCount || indexForViewBeforeAdded >= this.f5439a.getFlexItemCount()) {
            cVar.K = flexItemCount;
        } else {
            cVar.K = indexForViewBeforeAdded;
            while (indexForViewBeforeAdded < flexItemCount) {
                listL.get(indexForViewBeforeAdded).K++;
                indexForViewBeforeAdded++;
            }
        }
        listL.add(cVar);
        return U(flexItemCount + 1, listL, orderCache);
    }

    public void o(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int mode;
        int size;
        int flexDirection = this.f5439a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        List<com.google.android.flexbox.a> flexLinesInternal = this.f5439a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f5439a.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = size - paddingAlongCrossAxis;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f5439a.getAlignContent();
                if (alignContent == 1) {
                    int i2 = size - sumOfCrossSize;
                    com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
                    aVar.g = i2;
                    flexLinesInternal.add(0, aVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f5439a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i < size4) {
                        arrayList.add(flexLinesInternal.get(i));
                        if (i != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.a aVar2 = new com.google.android.flexbox.a();
                            if (i == flexLinesInternal.size() - 2) {
                                aVar2.g = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                aVar2.g = Math.round(size3);
                            }
                            int i3 = aVar2.g;
                            f += size3 - i3;
                            if (f > 1.0f) {
                                aVar2.g = i3 + 1;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                aVar2.g = i3 - 1;
                                f += 1.0f;
                            }
                            arrayList.add(aVar2);
                        }
                        i++;
                    }
                    this.f5439a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f5439a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.a aVar3 = new com.google.android.flexbox.a();
                    aVar3.g = size5;
                    for (com.google.android.flexbox.a aVar4 : flexLinesInternal) {
                        arrayList2.add(aVar3);
                        arrayList2.add(aVar4);
                        arrayList2.add(aVar3);
                    }
                    this.f5439a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i < size7) {
                        com.google.android.flexbox.a aVar5 = flexLinesInternal.get(i);
                        float f3 = aVar5.g + size6;
                        if (i == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        aVar5.g = iRound;
                        i++;
                    }
                }
            }
        }
    }

    public void p(int widthMeasureSpec, int heightMeasureSpec) {
        q(widthMeasureSpec, heightMeasureSpec, 0);
    }

    public void q(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f5439a.getFlexItemCount());
        if (fromIndex >= this.f5439a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f5439a.getFlexDirection();
        int flexDirection2 = this.f5439a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.f5439a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f5439a.getPaddingLeft();
            paddingRight = this.f5439a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode2 != 1073741824) {
                size = this.f5439a.getLargestMainSize();
            }
            paddingLeft = this.f5439a.getPaddingTop();
            paddingRight = this.f5439a.getPaddingBottom();
        }
        int i = paddingLeft + paddingRight;
        int[] iArr = this.f5440a;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f5439a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[fromIndex] : 0; i2 < size2; i2++) {
            com.google.android.flexbox.a aVar = flexLinesInternal.get(i2);
            int i3 = aVar.e;
            if (i3 < size && aVar.f5434a) {
                w(widthMeasureSpec, heightMeasureSpec, aVar, size, i, false);
            } else if (i3 > size && aVar.f5436b) {
                T(widthMeasureSpec, heightMeasureSpec, aVar, size, i, false);
            }
        }
    }

    public final void r(int size) {
        boolean[] zArr = this.f5442a;
        if (zArr == null) {
            this.f5442a = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.f5442a = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int size) {
        int[] iArr = this.f5440a;
        if (iArr == null) {
            this.f5440a = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.f5440a = Arrays.copyOf(this.f5440a, Math.max(iArr.length * 2, size));
        }
    }

    public void t(int size) {
        long[] jArr = this.f5441a;
        if (jArr == null) {
            this.f5441a = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.f5441a = Arrays.copyOf(this.f5441a, Math.max(jArr.length * 2, size));
        }
    }

    public void u(int size) {
        long[] jArr = this.b;
        if (jArr == null) {
            this.b = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.b = Arrays.copyOf(this.b, Math.max(jArr.length * 2, size));
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void w(int widthMeasureSpec, int heightMeasureSpec, com.google.android.flexbox.a flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int i2;
        int iMax;
        double d;
        int i3;
        double d2;
        float f = flexLine.f31201a;
        float f2 = 0.0f;
        if (f <= 0.0f || maxMainSize < (i = flexLine.e)) {
            return;
        }
        float f3 = (maxMainSize - i) / f;
        flexLine.e = paddingAlongMainAxis + flexLine.f;
        if (!calledRecursively) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        float f4 = 0.0f;
        while (i4 < flexLine.h) {
            int i6 = flexLine.l + i4;
            View reorderedFlexItemAt = this.f5439a.getReorderedFlexItemAt(i6);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i2 = i;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f5439a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i7 = i;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.b;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i6]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.b;
                    i2 = i7;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i6]);
                    }
                    if (!this.f5442a[i6] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f3);
                        if (i4 == flexLine.h - 1) {
                            flexGrow += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.f5442a[i6] = true;
                            flexLine.f31201a -= flexItem.getFlexGrow();
                            z = true;
                        } else {
                            f4 += flexGrow - iRound;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int iZ = z(heightMeasureSpec, flexItem, flexLine.k);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i6, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f5439a.updateViewCache(i6, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i5, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f5439a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.b;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i6]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.b;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i6]);
                    }
                    if (this.f5442a[i6] || flexItem.getFlexGrow() <= f2) {
                        i3 = i;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f3);
                        if (i4 == flexLine.h - 1) {
                            flexGrow2 += f4;
                            f4 = f2;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.f5442a[i6] = true;
                            flexLine.f31201a -= flexItem.getFlexGrow();
                            i3 = i;
                            z = true;
                        } else {
                            f4 += flexGrow2 - iRound2;
                            i3 = i;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int iA = A(widthMeasureSpec, flexItem, flexLine.k);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i6, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f5439a.updateViewCache(i6, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i5, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f5439a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i2 = i3;
                }
                flexLine.g = Math.max(flexLine.g, iMax);
                i5 = iMax;
            }
            i4++;
            i = i2;
            f2 = 0.0f;
        }
        int i8 = i;
        if (!z || i8 == flexLine.e) {
            return;
        }
        w(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public int x(long longValue) {
        return (int) (longValue >> 32);
    }

    public int y(long longValue) {
        return (int) longValue;
    }

    public final int z(int heightMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.f5439a;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(heightMeasureSpec, flexContainer.getPaddingTop() + this.f5439a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }
}
