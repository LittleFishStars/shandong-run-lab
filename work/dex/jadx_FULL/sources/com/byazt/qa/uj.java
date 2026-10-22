package com.byazt.qa;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.byazt.cd.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 598, 15})
public class uj {
    public static final /* synthetic */ boolean ve = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f28965a;
    public int[] c;
    public boolean[] n;
    public long[] tt;
    public final com.byazt.qa.c uj;

    @com.byazt.zqa.c(c = {0, 1, 598, 123})
    public static class c {
        public List<ve> c;
        public int tt;

        public void c() {
            this.c = null;
            this.tt = 0;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 598, 153})
    public static class tt implements Comparable<tt> {
        public int c;
        public int tt;

        private tt() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(tt ttVar) {
            int i = this.tt;
            int i2 = ttVar.tt;
            return i != i2 ? i - i2 : this.c - ttVar.c;
        }

        public String toString() {
            return "Order{order=" + this.tt + ", index=" + this.c + '}';
        }
    }

    public uj(com.byazt.qa.c cVar) {
        this.uj = cVar;
    }

    private int a(com.byazt.qa.tt ttVar, boolean z) {
        return z ? ttVar.m() : ttVar.z();
    }

    private int n(com.byazt.qa.tt ttVar, boolean z) {
        return z ? ttVar.yp() : ttVar.u();
    }

    private List<tt> tt(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.byazt.qa.tt ttVar = (com.byazt.qa.tt) this.uj.c(i2).getLayoutParams();
            tt ttVar2 = new tt();
            ttVar2.tt = ttVar.ve();
            ttVar2.c = i2;
            arrayList.add(ttVar2);
        }
        return arrayList;
    }

    private int uj(boolean z) {
        return z ? this.uj.getPaddingBottom() : this.uj.getPaddingEnd();
    }

    private int ve(boolean z) {
        return z ? this.uj.getPaddingTop() : this.uj.getPaddingStart();
    }

    public int c(long j) {
        return (int) j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] c(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.uj.getFlexItemCount();
        List<tt> listTt = tt(flexItemCount);
        tt ttVar = new tt();
        if (view == null || !(layoutParams instanceof com.byazt.qa.tt)) {
            ttVar.tt = 1;
        } else {
            ttVar.tt = ((com.byazt.qa.tt) layoutParams).ve();
        }
        if (i == -1 || i == flexItemCount || i >= this.uj.getFlexItemCount()) {
            ttVar.c = flexItemCount;
        } else {
            ttVar.c = i;
            while (i < flexItemCount) {
                listTt.get(i).c++;
                i++;
            }
        }
        listTt.add(ttVar);
        return c(flexItemCount + 1, listTt, sparseIntArray);
    }

    public int tt(long j) {
        return (int) (j >> 32);
    }

    public long tt(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    private int uj(com.byazt.qa.tt ttVar, boolean z) {
        if (z) {
            return ttVar.z();
        }
        return ttVar.m();
    }

    private int ve(com.byazt.qa.tt ttVar, boolean z) {
        if (z) {
            return ttVar.u();
        }
        return ttVar.yp();
    }

    private void ve(int i) {
        boolean[] zArr = this.n;
        if (zArr == null) {
            this.n = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.n = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public boolean tt(SparseIntArray sparseIntArray) {
        int flexItemCount = this.uj.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewC = this.uj.c(i);
            if (viewC != null && ((com.byazt.qa.tt) viewC.getLayoutParams()).ve() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void tt(c cVar, int i, int i2) {
        c(cVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<ve>) null);
    }

    private int tt(boolean z) {
        if (z) {
            return this.uj.getPaddingEnd();
        }
        return this.uj.getPaddingBottom();
    }

    public int[] c(SparseIntArray sparseIntArray) {
        int flexItemCount = this.uj.getFlexItemCount();
        return c(flexItemCount, tt(flexItemCount), sparseIntArray);
    }

    private int tt(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] c(int i, List<tt> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (tt ttVar : list) {
            int i3 = ttVar.c;
            iArr[i2] = i3;
            sparseIntArray.append(i3, ttVar.tt);
            i2++;
        }
        return iArr;
    }

    private int tt(com.byazt.qa.tt ttVar, boolean z) {
        if (z) {
            return ttVar.tt();
        }
        return ttVar.c();
    }

    private void tt(int i, int i2, ve veVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        int i7 = veVar.n;
        float f = veVar.sl;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f;
        veVar.n = i4 + veVar.f28966a;
        if (!z) {
            veVar.sp = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < veVar.x) {
            int i10 = veVar.z + i8;
            View viewTt = this.uj.tt(i10);
            if (viewTt == null || viewTt.getVisibility() == 8) {
                i5 = i7;
                i6 = i8;
            } else {
                com.byazt.qa.tt ttVar = (com.byazt.qa.tt) viewTt.getLayoutParams();
                int flexDirection = this.uj.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewTt.getMeasuredHeight();
                    long[] jArr = this.f28965a;
                    if (jArr != null) {
                        measuredHeight = tt(jArr[i10]);
                    }
                    int measuredWidth = viewTt.getMeasuredWidth();
                    long[] jArr2 = this.f28965a;
                    if (jArr2 != null) {
                        measuredWidth = c(jArr2[i10]);
                    }
                    if (this.n[i10] || ttVar.n() <= f2) {
                        i5 = i7;
                        i6 = i8;
                    } else {
                        float fN = measuredHeight - (ttVar.n() * f3);
                        if (i8 == veVar.x - 1) {
                            fN += f4;
                            f4 = f2;
                        }
                        int iRound = Math.round(fN);
                        if (iRound < ttVar.x()) {
                            iRound = ttVar.x();
                            this.n[i10] = true;
                            veVar.sl -= ttVar.n();
                            i5 = i7;
                            i6 = i8;
                            z2 = true;
                        } else {
                            f4 += fN - iRound;
                            i5 = i7;
                            i6 = i8;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iC = c(i, ttVar, veVar.u);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewTt.measure(iC, iMakeMeasureSpec);
                        measuredWidth = viewTt.getMeasuredWidth();
                        int measuredHeight2 = viewTt.getMeasuredHeight();
                        c(i10, iC, iMakeMeasureSpec, viewTt);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i9, measuredWidth + ttVar.u() + ttVar.z() + this.uj.c(viewTt));
                    veVar.n += measuredHeight + ttVar.yp() + ttVar.m();
                } else {
                    i5 = i7;
                    int i11 = i8;
                    int measuredWidth2 = viewTt.getMeasuredWidth();
                    long[] jArr3 = this.f28965a;
                    if (jArr3 != null) {
                        measuredWidth2 = c(jArr3[i10]);
                    }
                    int measuredHeight3 = viewTt.getMeasuredHeight();
                    long[] jArr4 = this.f28965a;
                    if (jArr4 != null) {
                        measuredHeight3 = tt(jArr4[i10]);
                    }
                    if (this.n[i10] || ttVar.n() <= 0.0f) {
                        i6 = i11;
                    } else {
                        float fN2 = measuredWidth2 - (ttVar.n() * f3);
                        if (i6 == veVar.x - 1) {
                            i6 = i11;
                            fN2 += f4;
                            f4 = 0.0f;
                        }
                        i6 = i11;
                        int iRound2 = Math.round(fN2);
                        if (iRound2 < ttVar.sp()) {
                            iRound2 = ttVar.sp();
                            this.n[i10] = true;
                            veVar.sl -= ttVar.n();
                            z2 = true;
                        } else {
                            f4 += fN2 - iRound2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        int iTt = tt(i2, ttVar, veVar.u);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewTt.measure(iMakeMeasureSpec2, iTt);
                        int measuredWidth3 = viewTt.getMeasuredWidth();
                        int measuredHeight4 = viewTt.getMeasuredHeight();
                        c(i10, iMakeMeasureSpec2, iTt, viewTt);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i9, measuredHeight3 + ttVar.yp() + ttVar.m() + this.uj.c(viewTt));
                    veVar.n += measuredWidth2 + ttVar.u() + ttVar.z();
                    iMax = iMax2;
                }
                veVar.sp = Math.max(veVar.sp, iMax);
                i9 = iMax;
            }
            i8 = i6 + 1;
            i7 = i5;
            f2 = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == veVar.n) {
            return;
        }
        tt(i, i2, veVar, i3, i4, true);
    }

    public void c(c cVar, int i, int i2) {
        c(cVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<ve>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(c cVar, int i, int i2, int i3, int i4, int i5, List<ve> list) {
        int i6;
        int i7;
        List<ve> list2;
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
        boolean zC = this.uj.c();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<ve> arrayList = list == null ? new ArrayList() : list;
        cVar.c = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int iC = c(zC);
        int iTt = tt(zC);
        int iVe = ve(zC);
        int iUj = uj(zC);
        ve veVar = new ve();
        int i18 = i4;
        veVar.z = i18;
        int i19 = iTt + iC;
        veVar.n = i19;
        int flexItemCount = this.uj.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View viewTt = this.uj.tt(i18);
            if (viewTt == null) {
                if (c(i18, flexItemCount, veVar)) {
                    c(arrayList, veVar, i18, i22);
                }
            } else {
                if (viewTt.getVisibility() == 8) {
                    veVar.i++;
                    veVar.x++;
                    if (c(i18, flexItemCount, veVar)) {
                        c(arrayList, veVar, i18, i22);
                    }
                } else {
                    if (viewTt instanceof CompoundButton) {
                        c((CompoundButton) viewTt);
                    }
                    com.byazt.qa.tt ttVar = (com.byazt.qa.tt) viewTt.getLayoutParams();
                    int i24 = flexItemCount;
                    if (ttVar.a() == 4) {
                        veVar.yp.add(Integer.valueOf(i18));
                    }
                    int iC2 = c(ttVar, zC);
                    if (ttVar.t() != -1.0f && mode == 1073741824) {
                        iC2 = Math.round(size * ttVar.t());
                    }
                    if (zC) {
                        int iC3 = this.uj.c(i, i19 + ve(ttVar, true) + uj(ttVar, true), iC2);
                        int iTt2 = this.uj.tt(i15, iVe + iUj + n(ttVar, true) + a(ttVar, true) + i22, tt(ttVar, true));
                        viewTt.measure(iC3, iTt2);
                        c(i18, iC3, iTt2, viewTt);
                        i7 = iC3;
                    } else {
                        int iC4 = this.uj.c(i15, iVe + iUj + n(ttVar, false) + a(ttVar, false) + i22, tt(ttVar, false));
                        int iTt3 = this.uj.tt(i, ve(ttVar, false) + i19 + uj(ttVar, false), iC2);
                        viewTt.measure(iC4, iTt3);
                        c(i18, iC4, iTt3, viewTt);
                        i7 = iTt3;
                    }
                    c(viewTt, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewTt.getMeasuredState());
                    int i25 = veVar.n;
                    int i26 = i22;
                    int i27 = i19;
                    ve veVar2 = veVar;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (c(viewTt, mode, i28, i25, uj(ttVar, zC) + c(viewTt, zC) + ve(ttVar, zC), ttVar, i29, i23, arrayList.size())) {
                        if (veVar2.tt() > 0) {
                            c(list2, veVar2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = veVar2.sp + i26;
                        } else {
                            i22 = i26;
                        }
                        if (zC) {
                            if (ttVar.tt() == -1) {
                                com.byazt.qa.c cVar2 = this.uj;
                                i8 = i2;
                                i18 = i29;
                                view = viewTt;
                                view.measure(i30, cVar2.tt(i8, cVar2.getPaddingTop() + this.uj.getPaddingBottom() + ttVar.yp() + ttVar.m() + i22, ttVar.tt()));
                                c(view, i18);
                            } else {
                                i8 = i2;
                                view = viewTt;
                                i18 = i29;
                            }
                        } else {
                            i8 = i2;
                            view = viewTt;
                            i18 = i29;
                            if (ttVar.c() == -1) {
                                com.byazt.qa.c cVar3 = this.uj;
                                view.measure(cVar3.c(i8, cVar3.getPaddingLeft() + this.uj.getPaddingRight() + ttVar.u() + ttVar.z() + i22, ttVar.c()), i30);
                                c(view, i18);
                            }
                        }
                        veVar = new ve();
                        i10 = 1;
                        veVar.x = 1;
                        i9 = i27;
                        veVar.n = i9;
                        veVar.z = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = viewTt;
                        i18 = i29;
                        veVar = veVar2;
                        i9 = i27;
                        i10 = 1;
                        veVar.x++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    veVar.nu = (veVar.nu ? 1 : 0) | (ttVar.uj() != 0.0f ? i10 : 0);
                    veVar.rh = (veVar.rh ? 1 : 0) | (ttVar.n() != 0.0f ? i10 : 0);
                    int[] iArr = this.c;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    veVar.n += c(view, zC) + ve(ttVar, zC) + uj(ttVar, zC);
                    veVar.da += ttVar.uj();
                    veVar.sl += ttVar.n();
                    this.uj.c(view, i18, i11, veVar);
                    int iMax = Math.max(i12, tt(view, zC) + n(ttVar, zC) + a(ttVar, zC) + this.uj.c(view));
                    veVar.sp = Math.max(veVar.sp, iMax);
                    if (zC) {
                        if (this.uj.getFlexWrap() != 2) {
                            veVar.t = Math.max(veVar.t, view.getBaseline() + ttVar.yp());
                        } else {
                            veVar.t = Math.max(veVar.t, (view.getMeasuredHeight() - view.getBaseline()) + ttVar.m());
                        }
                    }
                    i13 = i24;
                    if (c(i18, i13, veVar)) {
                        c(list2, veVar, i18, i22);
                        i22 += veVar.sp;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).m >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -veVar.c();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        cVar.tt = i6;
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
        cVar.tt = i6;
    }

    private int tt(int i, com.byazt.qa.tt ttVar, int i2) {
        com.byazt.qa.c cVar = this.uj;
        int iTt = cVar.tt(i, cVar.getPaddingTop() + this.uj.getPaddingBottom() + ttVar.yp() + ttVar.m() + i2, ttVar.tt());
        int size = View.MeasureSpec.getSize(iTt);
        if (size > ttVar.da()) {
            return View.MeasureSpec.makeMeasureSpec(ttVar.da(), View.MeasureSpec.getMode(iTt));
        }
        return size < ttVar.x() ? View.MeasureSpec.makeMeasureSpec(ttVar.x(), View.MeasureSpec.getMode(iTt)) : iTt;
    }

    public void tt(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.uj.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        }
        List<ve> flexLinesInternal = this.uj.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.uj.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).sp = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.uj.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    ve veVar = new ve();
                    veVar.sp = i5;
                    flexLinesInternal.add(0, veVar);
                    return;
                }
                if (alignContent == 2) {
                    this.uj.setFlexLines(c(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                ve veVar2 = new ve();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    veVar2.sp = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    veVar2.sp = Math.round(size3);
                                }
                                int i6 = veVar2.sp;
                                f += size3 - i6;
                                if (f > 1.0f) {
                                    veVar2.sp = i6 + 1;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    veVar2.sp = i6 - 1;
                                    f += 1.0f;
                                }
                                arrayList.add(veVar2);
                            }
                            i4++;
                        }
                        this.uj.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.uj.setFlexLines(c(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    ve veVar3 = new ve();
                    veVar3.sp = size5;
                    for (ve veVar4 : flexLinesInternal) {
                        arrayList2.add(veVar3);
                        arrayList2.add(veVar4);
                        arrayList2.add(veVar3);
                    }
                    this.uj.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        ve veVar5 = flexLinesInternal.get(i4);
                        float f3 = veVar5.sp + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
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
                        veVar5.sp = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private void c(CompoundButton compoundButton) {
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) compoundButton.getLayoutParams();
        int iSp = ttVar.sp();
        int iX = ttVar.x();
        Drawable drawableC = com.byazt.cd.n.c(compoundButton);
        int minimumWidth = drawableC == null ? 0 : drawableC.getMinimumWidth();
        int minimumHeight = drawableC != null ? drawableC.getMinimumHeight() : 0;
        if (iSp == -1) {
            iSp = minimumWidth;
        }
        ttVar.c(iSp);
        if (iX == -1) {
            iX = minimumHeight;
        }
        ttVar.tt(iX);
    }

    private int c(boolean z) {
        if (z) {
            return this.uj.getPaddingStart();
        }
        return this.uj.getPaddingTop();
    }

    private int c(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private void tt(View view, int i, int i2) {
        int measuredHeight;
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - ttVar.u()) - ttVar.z()) - this.uj.c(view), ttVar.sp()), ttVar.i());
        long[] jArr = this.f28965a;
        if (jArr != null) {
            measuredHeight = tt(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        c(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    private int c(com.byazt.qa.tt ttVar, boolean z) {
        if (z) {
            return ttVar.c();
        }
        return ttVar.tt();
    }

    private boolean c(View view, int i, int i2, int i3, int i4, com.byazt.qa.tt ttVar, int i5, int i6, int i7) {
        if (this.uj.getFlexWrap() == 0) {
            return false;
        }
        if (ttVar.sl()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.uj.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iC = this.uj.c(view, i5, i6);
        if (iC > 0) {
            i4 += iC;
        }
        return i2 < i3 + i4;
    }

    private boolean c(int i, int i2, ve veVar) {
        return i == i2 - 1 && veVar.tt() != 0;
    }

    private void c(List<ve> list, ve veVar, int i, int i2) {
        veVar.u = i2;
        this.uj.c(veVar);
        veVar.m = i;
        list.add(veVar);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void c(View view, int i) {
        boolean z;
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < ttVar.sp()) {
            measuredWidth = ttVar.sp();
        } else {
            if (measuredWidth > ttVar.i()) {
                measuredWidth = ttVar.i();
            } else {
                z = false;
            }
            if (measuredHeight < ttVar.x()) {
                measuredHeight = ttVar.x();
            } else if (measuredHeight > ttVar.da()) {
                measuredHeight = ttVar.da();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                c(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            }
        }
        z = true;
        if (measuredHeight < ttVar.x()) {
            measuredHeight = ttVar.x();
        } else if (measuredHeight > ttVar.da()) {
            measuredHeight = ttVar.da();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            c(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
        }
    }

    public void c(int i, int i2) {
        c(i, i2, 0);
    }

    public void c(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        ve(this.uj.getFlexItemCount());
        if (i3 >= this.uj.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.uj.getFlexDirection();
        int flexDirection2 = this.uj.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = this.uj.getLargestMainSize();
            }
            paddingLeft = this.uj.getPaddingTop();
            paddingRight = this.uj.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.uj.getLargestMainSize();
            if (mode2 != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.uj.getPaddingLeft();
            paddingRight = this.uj.getPaddingRight();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.c;
        List<ve> flexLinesInternal = this.uj.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            ve veVar = flexLinesInternal.get(i5);
            int i6 = veVar.n;
            if (i6 < size && veVar.nu) {
                c(i, i2, veVar, size, i4, false);
            } else if (i6 > size && veVar.rh) {
                tt(i, i2, veVar, size, i4, false);
            }
        }
    }

    private void c(int i, int i2, ve veVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = veVar.da;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = veVar.n)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        veVar.n = i4 + veVar.f28966a;
        if (!z) {
            veVar.sp = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < veVar.x) {
            int i10 = veVar.z + i8;
            View viewTt = this.uj.tt(i10);
            if (viewTt == null || viewTt.getVisibility() == 8) {
                i6 = i5;
            } else {
                com.byazt.qa.tt ttVar = (com.byazt.qa.tt) viewTt.getLayoutParams();
                int flexDirection = this.uj.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewTt.getMeasuredHeight();
                    long[] jArr = this.f28965a;
                    if (jArr != null) {
                        measuredHeight = tt(jArr[i10]);
                    }
                    int measuredWidth = viewTt.getMeasuredWidth();
                    long[] jArr2 = this.f28965a;
                    if (jArr2 != null) {
                        measuredWidth = c(jArr2[i10]);
                    }
                    if (this.n[i10] || ttVar.uj() <= f2) {
                        i7 = i5;
                    } else {
                        float fUj = measuredHeight + (ttVar.uj() * f3);
                        if (i8 == veVar.x - 1) {
                            fUj += f4;
                            f4 = f2;
                        }
                        int iRound = Math.round(fUj);
                        if (iRound > ttVar.da()) {
                            iRound = ttVar.da();
                            this.n[i10] = true;
                            veVar.da -= ttVar.uj();
                            i7 = i5;
                            z2 = true;
                        } else {
                            f4 += fUj - iRound;
                            i7 = i5;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                iRound++;
                                d2 = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d2 = d3 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int iC = c(i, ttVar, veVar.u);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewTt.measure(iC, iMakeMeasureSpec);
                        measuredWidth = viewTt.getMeasuredWidth();
                        int measuredHeight2 = viewTt.getMeasuredHeight();
                        c(i10, iC, iMakeMeasureSpec, viewTt);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i9, measuredWidth + ttVar.u() + ttVar.z() + this.uj.c(viewTt));
                    veVar.n += measuredHeight + ttVar.yp() + ttVar.m();
                    i6 = i7;
                } else {
                    int i11 = i5;
                    int measuredWidth2 = viewTt.getMeasuredWidth();
                    long[] jArr3 = this.f28965a;
                    if (jArr3 != null) {
                        measuredWidth2 = c(jArr3[i10]);
                    }
                    int measuredHeight3 = viewTt.getMeasuredHeight();
                    long[] jArr4 = this.f28965a;
                    i6 = i11;
                    if (jArr4 != null) {
                        measuredHeight3 = tt(jArr4[i10]);
                    }
                    if (!this.n[i10] && ttVar.uj() > 0.0f) {
                        float fUj2 = measuredWidth2 + (ttVar.uj() * f3);
                        if (i8 == veVar.x - 1) {
                            fUj2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fUj2);
                        if (iRound2 > ttVar.i()) {
                            iRound2 = ttVar.i();
                            this.n[i10] = true;
                            veVar.da -= ttVar.uj();
                            z2 = true;
                        } else {
                            f4 += fUj2 - iRound2;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d = d4 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int iTt = tt(i2, ttVar, veVar.u);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewTt.measure(iMakeMeasureSpec2, iTt);
                        int measuredWidth3 = viewTt.getMeasuredWidth();
                        int measuredHeight4 = viewTt.getMeasuredHeight();
                        c(i10, iMakeMeasureSpec2, iTt, viewTt);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i9, measuredHeight3 + ttVar.yp() + ttVar.m() + this.uj.c(viewTt));
                    veVar.n += measuredWidth2 + ttVar.u() + ttVar.z();
                    iMax = iMax2;
                }
                veVar.sp = Math.max(veVar.sp, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z2 || i12 == veVar.n) {
            return;
        }
        c(i, i2, veVar, i3, i4, true);
    }

    private int c(int i, com.byazt.qa.tt ttVar, int i2) {
        com.byazt.qa.c cVar = this.uj;
        int iC = cVar.c(i, cVar.getPaddingLeft() + this.uj.getPaddingRight() + ttVar.u() + ttVar.z() + i2, ttVar.c());
        int size = View.MeasureSpec.getSize(iC);
        if (size > ttVar.i()) {
            return View.MeasureSpec.makeMeasureSpec(ttVar.i(), View.MeasureSpec.getMode(iC));
        }
        return size < ttVar.sp() ? View.MeasureSpec.makeMeasureSpec(ttVar.sp(), View.MeasureSpec.getMode(iC)) : iC;
    }

    private List<ve> c(List<ve> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        ve veVar = new ve();
        veVar.sp = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(veVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(veVar);
            }
        }
        return arrayList;
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        View viewTt;
        if (i >= this.uj.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.uj.getFlexDirection();
        if (this.uj.getAlignItems() == 4) {
            int[] iArr = this.c;
            List<ve> flexLinesInternal = this.uj.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                ve veVar = flexLinesInternal.get(i2);
                int i3 = veVar.x;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = veVar.z + i4;
                    if (i4 < this.uj.getFlexItemCount() && (viewTt = this.uj.tt(i5)) != null && viewTt.getVisibility() != 8) {
                        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) viewTt.getLayoutParams();
                        if (ttVar.a() == -1 || ttVar.a() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                                tt(viewTt, veVar.sp, i5);
                            } else {
                                c(viewTt, veVar.sp, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (ve veVar2 : this.uj.getFlexLinesInternal()) {
            for (Integer num : veVar2.yp) {
                View viewTt2 = this.uj.tt(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                    }
                    tt(viewTt2, veVar2.sp, num.intValue());
                } else {
                    c(viewTt2, veVar2.sp, num.intValue());
                }
            }
        }
    }

    private void c(View view, int i, int i2) {
        int measuredWidth;
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - ttVar.yp()) - ttVar.m()) - this.uj.c(view), ttVar.x()), ttVar.da());
        long[] jArr = this.f28965a;
        if (jArr != null) {
            measuredWidth = c(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        c(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    public void c(View view, ve veVar, int i, int i2, int i3, int i4) {
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) view.getLayoutParams();
        int alignItems = this.uj.getAlignItems();
        if (ttVar.a() != -1) {
            alignItems = ttVar.a();
        }
        int i5 = veVar.sp;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.uj.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - ttVar.m(), i3, i6 - ttVar.m());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + ttVar.yp(), i3, (i4 - i5) + view.getMeasuredHeight() + ttVar.yp());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + ttVar.yp()) - ttVar.m()) / 2;
                if (this.uj.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.uj.getFlexWrap() != 2) {
                    int iMax = Math.max(veVar.t - view.getBaseline(), ttVar.yp());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((veVar.t - view.getMeasuredHeight()) + view.getBaseline(), ttVar.m());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.uj.getFlexWrap() != 2) {
            view.layout(i, i2 + ttVar.yp(), i3, i4 + ttVar.yp());
        } else {
            view.layout(i, i2 - ttVar.m(), i3, i4 - ttVar.m());
        }
    }

    public void c(View view, ve veVar, boolean z, int i, int i2, int i3, int i4) {
        com.byazt.qa.tt ttVar = (com.byazt.qa.tt) view.getLayoutParams();
        int alignItems = this.uj.getAlignItems();
        if (ttVar.a() != -1) {
            alignItems = ttVar.a();
        }
        int i5 = veVar.sp;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - ttVar.z(), i2, ((i3 + i5) - view.getMeasuredWidth()) - ttVar.z(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + ttVar.u(), i2, (i3 - i5) + view.getMeasuredWidth() + ttVar.u(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + a.c(marginLayoutParams)) - a.tt(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + ttVar.u(), i2, i3 + ttVar.u(), i4);
        } else {
            view.layout(i - ttVar.z(), i2, i3 - ttVar.z(), i4);
        }
    }

    private void c(int i, int i2, int i3, View view) {
        long[] jArr = this.tt;
        if (jArr != null) {
            jArr[i] = tt(i2, i3);
        }
        long[] jArr2 = this.f28965a;
        if (jArr2 != null) {
            jArr2[i] = tt(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
