package com.byazt.qa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.cd.sp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 598, 1529})
public class FlexboxLayout extends ViewGroup implements com.byazt.qa.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28963a;
    public int c;
    public int da;
    public int i;
    public List<ve> m;
    public int n;
    public com.byazt.sa.uj nu;
    public uj.c rh;
    public int sl;
    public Drawable sp;
    public int t;
    public int tt;
    public int[] u;
    public int uj;
    public int ve;
    public Drawable x;
    public SparseIntArray yp;
    public uj z;

    @com.byazt.zqa.c(c = {0, 1, 598, 1712})
    public static class c extends ViewGroup.MarginLayoutParams implements tt {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.byazt.qa.FlexboxLayout.c.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28964a;
        public int c;
        public boolean da;
        public int i;
        public float n;
        public int sp;
        public float tt;
        public int uj;
        public float ve;
        public int x;

        public c(c cVar) {
            super((ViewGroup.MarginLayoutParams) cVar);
            this.c = 1;
            this.tt = 0.0f;
            this.ve = 0.0f;
            this.uj = -1;
            this.n = -1.0f;
            this.f28964a = -1;
            this.sp = -1;
            this.x = 16777215;
            this.i = 16777215;
            this.c = cVar.c;
            this.tt = cVar.tt;
            this.ve = cVar.ve;
            this.uj = cVar.uj;
            this.n = cVar.n;
            this.f28964a = cVar.f28964a;
            this.sp = cVar.sp;
            this.x = cVar.x;
            this.i = cVar.i;
            this.da = cVar.da;
        }

        @Override // com.byazt.qa.tt
        public int a() {
            return this.uj;
        }

        @Override // com.byazt.qa.tt
        public int c() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.byazt.qa.tt
        public int da() {
            return this.i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.byazt.qa.tt
        public int i() {
            return this.x;
        }

        @Override // com.byazt.qa.tt
        public int m() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.byazt.qa.tt
        public float n() {
            return this.ve;
        }

        @Override // com.byazt.qa.tt
        public boolean sl() {
            return this.da;
        }

        @Override // com.byazt.qa.tt
        public int sp() {
            return this.f28964a;
        }

        @Override // com.byazt.qa.tt
        public float t() {
            return this.n;
        }

        @Override // com.byazt.qa.tt
        public int tt() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.byazt.qa.tt
        public int u() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.byazt.qa.tt
        public float uj() {
            return this.tt;
        }

        @Override // com.byazt.qa.tt
        public int ve() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.c);
            parcel.writeFloat(this.tt);
            parcel.writeFloat(this.ve);
            parcel.writeInt(this.uj);
            parcel.writeFloat(this.n);
            parcel.writeInt(this.f28964a);
            parcel.writeInt(this.sp);
            parcel.writeInt(this.x);
            parcel.writeInt(this.i);
            parcel.writeByte(this.da ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.byazt.qa.tt
        public int x() {
            return this.sp;
        }

        @Override // com.byazt.qa.tt
        public int yp() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.byazt.qa.tt
        public int z() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        public void c(float f) {
            this.tt = f;
        }

        public void tt(float f) {
            this.ve = f;
        }

        public void uj(int i) {
            this.uj = i;
        }

        public void ve(int i) {
            this.c = i;
        }

        @Override // com.byazt.qa.tt
        public void c(int i) {
            this.f28964a = i;
        }

        @Override // com.byazt.qa.tt
        public void tt(int i) {
            this.sp = i;
        }

        public void ve(float f) {
            this.n = f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.c = 1;
            this.tt = 0.0f;
            this.ve = 0.0f;
            this.uj = -1;
            this.n = -1.0f;
            this.f28964a = -1;
            this.sp = -1;
            this.x = 16777215;
            this.i = 16777215;
        }

        public c(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.c = 1;
            this.tt = 0.0f;
            this.ve = 0.0f;
            this.uj = -1;
            this.n = -1.0f;
            this.f28964a = -1;
            this.sp = -1;
            this.x = 16777215;
            this.i = 16777215;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.c = 1;
            this.tt = 0.0f;
            this.ve = 0.0f;
            this.uj = -1;
            this.n = -1.0f;
            this.f28964a = -1;
            this.sp = -1;
            this.x = 16777215;
            this.i = 16777215;
        }

        public c(Parcel parcel) {
            super(0, 0);
            this.c = 1;
            this.tt = 0.0f;
            this.ve = 0.0f;
            this.uj = -1;
            this.n = -1.0f;
            this.f28964a = -1;
            this.sp = -1;
            this.x = 16777215;
            this.i = 16777215;
            this.c = parcel.readInt();
            this.tt = parcel.readFloat();
            this.ve = parcel.readFloat();
            this.uj = parcel.readInt();
            this.n = parcel.readFloat();
            this.f28964a = parcel.readInt();
            this.sp = parcel.readInt();
            this.x = parcel.readInt();
            this.i = parcel.readInt();
            this.da = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.f28963a = -1;
        this.z = new uj(this);
        this.m = new ArrayList();
        this.rh = new uj.c();
    }

    private boolean a(int i) {
        if (i >= 0 && i < this.m.size()) {
            for (int i2 = i + 1; i2 < this.m.size(); i2++) {
                if (this.m.get(i2).tt() > 0) {
                    return false;
                }
            }
            if (c()) {
                return (this.i & 4) != 0;
            }
            if ((this.da & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    private void c(int i, int i2) {
        if (this.yp == null) {
            this.yp = new SparseIntArray(getChildCount());
        }
        if (this.z.tt(this.yp)) {
            this.u = this.z.c(this.yp);
        }
        int i3 = this.c;
        if (i3 == 0 || i3 == 1) {
            tt(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            ve(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.c);
        }
    }

    private boolean n(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewVe = ve(i - i3);
            if (viewVe != null && viewVe.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean uj(int i, int i2) {
        if (n(i, i2)) {
            if (c()) {
                return (this.da & 1) != 0;
            }
            return (this.i & 1) != 0;
        }
        if (c()) {
            return (this.da & 2) != 0;
        }
        return (this.i & 2) != 0;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.yp == null) {
            this.yp = new SparseIntArray(getChildCount());
        }
        this.u = this.z.c(view, i, layoutParams, this.yp);
        super.addView(view, i, layoutParams);
    }

    @Override // com.byazt.qa.c
    public int c(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof c) {
            return new c((c) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // com.byazt.qa.c
    public int getAlignContent() {
        return this.n;
    }

    @Override // com.byazt.qa.c
    public int getAlignItems() {
        return this.uj;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.sp;
    }

    public Drawable getDividerDrawableVertical() {
        return this.x;
    }

    @Override // com.byazt.qa.c
    public int getFlexDirection() {
        return this.c;
    }

    @Override // com.byazt.qa.c
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<ve> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.m.size());
        for (ve veVar : this.m) {
            if (veVar.tt() != 0) {
                arrayList.add(veVar);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.qa.c
    public List<ve> getFlexLinesInternal() {
        return this.m;
    }

    @Override // com.byazt.qa.c
    public int getFlexWrap() {
        return this.tt;
    }

    public int getJustifyContent() {
        return this.ve;
    }

    @Override // com.byazt.qa.c
    public int getLargestMainSize() {
        Iterator<ve> it = this.m.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().n);
        }
        return iMax;
    }

    @Override // com.byazt.qa.c
    public int getMaxLine() {
        return this.f28963a;
    }

    public int getShowDividerHorizontal() {
        return this.i;
    }

    public int getShowDividerVertical() {
        return this.da;
    }

    @Override // com.byazt.qa.c
    public int getSumOfCrossSize() {
        int size = this.m.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ve veVar = this.m.get(i2);
            if (uj(i2)) {
                i += c() ? this.sl : this.t;
            }
            if (a(i2)) {
                i += c() ? this.sl : this.t;
            }
            i += veVar.sp;
        }
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.x == null && this.sp == null) {
            return;
        }
        if (this.i == 0 && this.da == 0) {
            return;
        }
        int iC = sp.c(this);
        int i = this.c;
        if (i == 0) {
            c(canvas, iC == 1, this.tt == 2);
            return;
        }
        if (i == 1) {
            c(canvas, iC != 1, this.tt == 2);
            return;
        }
        if (i == 2) {
            boolean z = iC == 1;
            if (this.tt == 2) {
                z = !z;
            }
            tt(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iC == 1;
        if (this.tt == 2) {
            z2 = !z2;
        }
        tt(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            ujVar.uj();
        }
        int iC = sp.c(this);
        int i5 = this.c;
        if (i5 == 0) {
            c(iC == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            c(iC != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iC == 1;
            c(this.tt == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else {
            if (i5 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.c);
            }
            z2 = iC == 1;
            c(this.tt == 2 ? !z2 : z2, true, i, i2, i3, i4);
        }
        com.byazt.sa.uj ujVar2 = this.nu;
        if (ujVar2 != null) {
            ujVar2.c(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            c(iArrC[0], iArrC[1]);
        } else {
            c(i, i2);
        }
        com.byazt.sa.uj ujVar2 = this.nu;
        if (ujVar2 != null) {
            ujVar2.ve();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.sa.uj ujVar = this.nu;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    public void setAlignContent(int i) {
        if (this.n != i) {
            this.n = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.uj != i) {
            this.uj = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.sp) {
            return;
        }
        this.sp = drawable;
        if (drawable != null) {
            this.sl = drawable.getIntrinsicHeight();
        } else {
            this.sl = 0;
        }
        tt();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.x) {
            return;
        }
        this.x = drawable;
        if (drawable != null) {
            this.t = drawable.getIntrinsicWidth();
        } else {
            this.t = 0;
        }
        tt();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    @Override // com.byazt.qa.c
    public void setFlexLines(List<ve> list) {
        this.m = list;
    }

    public void setFlexWrap(int i) {
        if (this.tt != i) {
            this.tt = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.ve != i) {
            this.ve = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.f28963a != i) {
            this.f28963a = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.da) {
            this.da = i;
            requestLayout();
        }
    }

    @Override // com.byazt.qa.c
    public View tt(int i) {
        return ve(i);
    }

    public View ve(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.u;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    private void tt(int i, int i2) {
        this.m.clear();
        this.rh.c();
        this.z.c(this.rh, i, i2);
        this.m = this.rh.c;
        this.z.c(i, i2);
        if (this.uj == 3) {
            for (ve veVar : this.m) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < veVar.x; i3++) {
                    View viewVe = ve(veVar.z + i3);
                    if (viewVe != null && viewVe.getVisibility() != 8) {
                        c cVar = (c) viewVe.getLayoutParams();
                        iMax = this.tt != 2 ? Math.max(iMax, viewVe.getMeasuredHeight() + Math.max(veVar.t - viewVe.getBaseline(), ((ViewGroup.MarginLayoutParams) cVar).topMargin) + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin) : Math.max(iMax, viewVe.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar).topMargin + Math.max((veVar.t - viewVe.getMeasuredHeight()) + viewVe.getBaseline(), ((ViewGroup.MarginLayoutParams) cVar).bottomMargin));
                    }
                }
                veVar.sp = iMax;
            }
        }
        this.z.tt(i, i2, getPaddingTop() + getPaddingBottom());
        this.z.c();
        c(this.c, i, i2, this.rh.tt);
    }

    private boolean n(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.m.get(i2).tt() > 0) {
                return false;
            }
        }
        return true;
    }

    private void ve(int i, int i2) {
        this.m.clear();
        this.rh.c();
        this.z.tt(this.rh, i, i2);
        this.m = this.rh.c;
        this.z.c(i, i2);
        this.z.tt(i, i2, getPaddingLeft() + getPaddingRight());
        this.z.c();
        c(this.c, i, i2, this.rh.tt);
    }

    private boolean uj(int i) {
        if (i >= 0 && i < this.m.size()) {
            if (n(i)) {
                if (c()) {
                    return (this.i & 1) != 0;
                }
                return (this.da & 1) != 0;
            }
            if (c()) {
                return (this.i & 2) != 0;
            }
            if ((this.da & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.qa.c
    public View c(int i) {
        return getChildAt(i);
    }

    private void c(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void tt(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.m.size();
        for (int i3 = 0; i3 < size; i3++) {
            ve veVar = this.m.get(i3);
            for (int i4 = 0; i4 < veVar.x; i4++) {
                int i5 = veVar.z + i4;
                View viewVe = ve(i5);
                if (viewVe != null && viewVe.getVisibility() != 8) {
                    c cVar = (c) viewVe.getLayoutParams();
                    if (uj(i5, i4)) {
                        if (z2) {
                            top = viewVe.getBottom() + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                        } else {
                            top = (viewVe.getTop() - ((ViewGroup.MarginLayoutParams) cVar).topMargin) - this.sl;
                        }
                        tt(canvas, veVar.c, top, veVar.sp);
                    }
                    if (i4 == veVar.x - 1 && (this.i & 4) > 0) {
                        if (z2) {
                            bottom = (viewVe.getTop() - ((ViewGroup.MarginLayoutParams) cVar).topMargin) - this.sl;
                        } else {
                            bottom = viewVe.getBottom() + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                        }
                        tt(canvas, veVar.c, bottom, veVar.sp);
                    }
                }
            }
            if (uj(i3)) {
                if (z) {
                    i2 = veVar.ve;
                } else {
                    i2 = veVar.c - this.t;
                }
                c(canvas, i2, paddingTop, iMax);
            }
            if (a(i3) && (this.da & 4) > 0) {
                if (z) {
                    i = veVar.c - this.t;
                } else {
                    i = veVar.ve;
                }
                c(canvas, i, paddingTop, iMax);
            }
        }
    }

    @Override // com.byazt.qa.c
    public boolean c() {
        int i = this.c;
        return i == 0 || i == 1;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00da  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:48:0x0101  */
    /* JADX WARN: Code duplicated, block: B:51:0x010a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0112  */
    /* JADX WARN: Code duplicated, block: B:54:0x0117  */
    /* JADX WARN: Code duplicated, block: B:58:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0122  */
    /* JADX WARN: Code duplicated, block: B:60:0x0153  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:63:0x018a  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:71:0x0207  */
    private void c(boolean z, int i, int i2, int i3, int i4) {
        float measuredWidth;
        float f;
        float f2;
        float fMax;
        int i5;
        int i6;
        View viewVe;
        int i7;
        int i8;
        int i9;
        char c2;
        c cVar;
        float f3;
        float f4;
        float f5;
        int i10;
        char c3;
        int i11;
        c cVar2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i12 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.m.size();
        int i13 = 0;
        while (i13 < size) {
            ve veVar = this.m.get(i13);
            if (uj(i13)) {
                int i14 = this.sl;
                paddingBottom -= i14;
                paddingTop += i14;
            }
            int i15 = this.ve;
            char c4 = 4;
            int i16 = 1;
            if (i15 == 0) {
                measuredWidth = paddingLeft;
                f = i12 - paddingRight;
            } else if (i15 == 1) {
                int i17 = veVar.n;
                f = i17 - paddingLeft;
                measuredWidth = (i12 - i17) + paddingRight;
            } else {
                if (i15 == 2) {
                    int i18 = veVar.n;
                    measuredWidth = paddingLeft + ((i12 - i18) / 2.0f);
                    f = (i12 - paddingRight) - ((i12 - i18) / 2.0f);
                } else if (i15 == 3) {
                    measuredWidth = paddingLeft;
                    int iTt = veVar.tt();
                    f2 = (i12 - veVar.n) / (iTt != 1 ? iTt - 1 : 1.0f);
                    f = i12 - paddingRight;
                } else if (i15 == 4) {
                    int iTt2 = veVar.tt();
                    f2 = iTt2 != 0 ? (i12 - veVar.n) / iTt2 : 0.0f;
                    float f6 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f6;
                    f = (i12 - paddingRight) - f6;
                } else if (i15 == 5) {
                    int iTt3 = veVar.tt();
                    f2 = iTt3 != 0 ? (i12 - veVar.n) / (iTt3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i12 - paddingRight) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.ve);
                }
                fMax = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < veVar.x) {
                    i6 = veVar.z + i5;
                    viewVe = ve(i6);
                    if (viewVe != null) {
                        i7 = paddingLeft;
                        i8 = i16;
                        i9 = i5;
                        c2 = c4;
                    } else if (viewVe.getVisibility() != 8) {
                        cVar = (c) viewVe.getLayoutParams();
                        f3 = measuredWidth + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        f4 = f - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        if (uj(i6, i5)) {
                            int i19 = this.t;
                            float f7 = i19;
                            f3 += f7;
                            i10 = i19;
                            f5 = f4 - f7;
                        } else {
                            f5 = f4;
                            i10 = 0;
                        }
                        if (i5 == veVar.x - i16) {
                            c3 = 4;
                            i11 = (this.da & 4) > 0 ? this.t : 0;
                            if (this.tt == 2) {
                                i7 = paddingLeft;
                                i8 = i16;
                                i9 = i5;
                                cVar2 = cVar;
                                c2 = c3;
                                if (z) {
                                    this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewVe.getMeasuredHeight());
                                } else {
                                    this.z.c(viewVe, veVar, Math.round(f3), paddingTop, Math.round(f3) + viewVe.getMeasuredWidth(), paddingTop + viewVe.getMeasuredHeight());
                                }
                            } else if (z) {
                                i8 = i16;
                                i9 = i5;
                                i7 = paddingLeft;
                                cVar2 = cVar;
                                c2 = c3;
                                this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                i7 = paddingLeft;
                                i8 = i16;
                                i9 = i5;
                                cVar2 = cVar;
                                c2 = c3;
                                this.z.c(viewVe, veVar, Math.round(f3), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f3) + viewVe.getMeasuredWidth(), paddingBottom);
                            }
                            measuredWidth = f3 + viewVe.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                            float measuredWidth2 = f5 - ((viewVe.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin);
                            if (z) {
                                veVar.c(viewVe, i11, 0, i10, 0);
                            } else {
                                veVar.c(viewVe, i10, 0, i11, 0);
                            }
                            f = measuredWidth2;
                        } else {
                            c3 = 4;
                        }
                        if (this.tt == 2) {
                            i7 = paddingLeft;
                            i8 = i16;
                            i9 = i5;
                            cVar2 = cVar;
                            c2 = c3;
                            if (z) {
                                this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewVe.getMeasuredHeight());
                            } else {
                                this.z.c(viewVe, veVar, Math.round(f3), paddingTop, Math.round(f3) + viewVe.getMeasuredWidth(), paddingTop + viewVe.getMeasuredHeight());
                            }
                        } else if (z) {
                            i8 = i16;
                            i9 = i5;
                            i7 = paddingLeft;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i7 = paddingLeft;
                            i8 = i16;
                            i9 = i5;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, Math.round(f3), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f3) + viewVe.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewVe.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                        float measuredWidth3 = f5 - ((viewVe.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin);
                        if (z) {
                            veVar.c(viewVe, i11, 0, i10, 0);
                        } else {
                            veVar.c(viewVe, i10, 0, i11, 0);
                        }
                        f = measuredWidth3;
                    } else {
                        i7 = paddingLeft;
                        i8 = i16;
                        i9 = i5;
                        c2 = 4;
                    }
                    i5 = i9 + 1;
                    paddingLeft = i7;
                    i16 = i8;
                    c4 = c2;
                }
                int i20 = paddingLeft;
                int i21 = veVar.sp;
                paddingTop += i21;
                paddingBottom -= i21;
                i13++;
                paddingLeft = i20;
            }
            f2 = 0.0f;
            fMax = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < veVar.x) {
                i6 = veVar.z + i5;
                viewVe = ve(i6);
                if (viewVe != null) {
                    i7 = paddingLeft;
                    i8 = i16;
                    i9 = i5;
                    c2 = c4;
                } else if (viewVe.getVisibility() != 8) {
                    cVar = (c) viewVe.getLayoutParams();
                    f3 = measuredWidth + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                    f4 = f - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    if (uj(i6, i5)) {
                        int i110 = this.t;
                        float f8 = i110;
                        f3 += f8;
                        i10 = i110;
                        f5 = f4 - f8;
                    } else {
                        f5 = f4;
                        i10 = 0;
                    }
                    if (i5 == veVar.x - i16) {
                        c3 = 4;
                        if ((this.da & 4) > 0) {
                        }
                        if (this.tt == 2) {
                            i7 = paddingLeft;
                            i8 = i16;
                            i9 = i5;
                            cVar2 = cVar;
                            c2 = c3;
                            if (z) {
                                this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewVe.getMeasuredHeight());
                            } else {
                                this.z.c(viewVe, veVar, Math.round(f3), paddingTop, Math.round(f3) + viewVe.getMeasuredWidth(), paddingTop + viewVe.getMeasuredHeight());
                            }
                        } else if (z) {
                            i8 = i16;
                            i9 = i5;
                            i7 = paddingLeft;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i7 = paddingLeft;
                            i8 = i16;
                            i9 = i5;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, Math.round(f3), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f3) + viewVe.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewVe.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                        float measuredWidth4 = f5 - ((viewVe.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin);
                        if (z) {
                            veVar.c(viewVe, i11, 0, i10, 0);
                        } else {
                            veVar.c(viewVe, i10, 0, i11, 0);
                        }
                        f = measuredWidth4;
                    } else {
                        c3 = 4;
                    }
                    if (this.tt == 2) {
                        i7 = paddingLeft;
                        i8 = i16;
                        i9 = i5;
                        cVar2 = cVar;
                        c2 = c3;
                        if (z) {
                            this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewVe.getMeasuredHeight());
                        } else {
                            this.z.c(viewVe, veVar, Math.round(f3), paddingTop, Math.round(f3) + viewVe.getMeasuredWidth(), paddingTop + viewVe.getMeasuredHeight());
                        }
                    } else if (z) {
                        i8 = i16;
                        i9 = i5;
                        i7 = paddingLeft;
                        cVar2 = cVar;
                        c2 = c3;
                        this.z.c(viewVe, veVar, Math.round(f5) - viewVe.getMeasuredWidth(), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f5), paddingBottom);
                    } else {
                        i7 = paddingLeft;
                        i8 = i16;
                        i9 = i5;
                        cVar2 = cVar;
                        c2 = c3;
                        this.z.c(viewVe, veVar, Math.round(f3), paddingBottom - viewVe.getMeasuredHeight(), Math.round(f3) + viewVe.getMeasuredWidth(), paddingBottom);
                    }
                    measuredWidth = f3 + viewVe.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    float measuredWidth5 = f5 - ((viewVe.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin);
                    if (z) {
                        veVar.c(viewVe, i11, 0, i10, 0);
                    } else {
                        veVar.c(viewVe, i10, 0, i11, 0);
                    }
                    f = measuredWidth5;
                } else {
                    i7 = paddingLeft;
                    i8 = i16;
                    i9 = i5;
                    c2 = 4;
                }
                i5 = i9 + 1;
                paddingLeft = i7;
                i16 = i8;
                c4 = c2;
            }
            int i22 = paddingLeft;
            int i23 = veVar.sp;
            paddingTop += i23;
            paddingBottom -= i23;
            i13++;
            paddingLeft = i22;
        }
    }

    private void tt(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.sp;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.sl + i2);
        this.sp.draw(canvas);
    }

    @Override // com.byazt.qa.c
    public int tt(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    private void tt() {
        if (this.sp == null && this.x == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:49:0x0101  */
    /* JADX WARN: Code duplicated, block: B:52:0x010d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:55:0x011a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0122  */
    /* JADX WARN: Code duplicated, block: B:60:0x0151  */
    /* JADX WARN: Code duplicated, block: B:61:0x0179  */
    /* JADX WARN: Code duplicated, block: B:63:0x0183  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:71:0x0201  */
    private void c(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float fMax;
        int i6;
        int i7;
        View viewVe;
        int i8;
        boolean z3;
        char c2;
        c cVar;
        float f4;
        float f5;
        float f6;
        float f7;
        int i9;
        char c3;
        int i10;
        c cVar2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int i12 = (i3 - i) - paddingRight;
        int size = this.m.size();
        for (int i13 = 0; i13 < size; i13++) {
            ve veVar = this.m.get(i13);
            if (uj(i13)) {
                int i14 = this.t;
                paddingLeft += i14;
                i12 -= i14;
            }
            int i15 = this.ve;
            char c4 = 4;
            boolean z4 = true;
            if (i15 != 0) {
                if (i15 == 1) {
                    int i16 = veVar.n;
                    f = (i11 - i16) + paddingBottom;
                    i5 = i16 - paddingTop;
                } else if (i15 == 2) {
                    int i17 = veVar.n;
                    f2 = (i11 - paddingBottom) - ((i11 - i17) / 2.0f);
                    f = paddingTop + ((i11 - i17) / 2.0f);
                    f3 = 0.0f;
                } else if (i15 == 3) {
                    f = paddingTop;
                    int iTt = veVar.tt();
                    f3 = (i11 - veVar.n) / (iTt != 1 ? iTt - 1 : 1.0f);
                    f2 = i11 - paddingBottom;
                } else if (i15 == 4) {
                    int iTt2 = veVar.tt();
                    f3 = iTt2 != 0 ? (i11 - veVar.n) / iTt2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i11 - paddingBottom) - f8;
                } else if (i15 == 5) {
                    int iTt3 = veVar.tt();
                    f3 = iTt3 != 0 ? (i11 - veVar.n) / (iTt3 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i11 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.ve);
                }
                fMax = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < veVar.x) {
                    i7 = veVar.z + i6;
                    viewVe = ve(i7);
                    if (viewVe != null) {
                        i8 = i6;
                        z3 = z4;
                        c2 = c4;
                    } else if (viewVe.getVisibility() != 8) {
                        cVar = (c) viewVe.getLayoutParams();
                        f4 = f + ((ViewGroup.MarginLayoutParams) cVar).topMargin;
                        f5 = f2 - ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                        if (uj(i7, i6)) {
                            int i18 = this.sl;
                            float f9 = i18;
                            f6 = f4 + f9;
                            i9 = i18;
                            f7 = f5 - f9;
                        } else {
                            f6 = f4;
                            f7 = f5;
                            i9 = 0;
                        }
                        if (i6 == veVar.x - 1) {
                            c3 = 4;
                            i10 = (this.i & 4) > 0 ? this.sl : 0;
                            if (z) {
                                i8 = i6;
                                z3 = true;
                                cVar2 = cVar;
                                c2 = c3;
                                if (z2) {
                                    this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f7) - viewVe.getMeasuredHeight(), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f7));
                                } else {
                                    this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f6), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f6) + viewVe.getMeasuredHeight());
                                }
                            } else if (z2) {
                                i8 = i6;
                                z3 = true;
                                cVar2 = cVar;
                                c2 = c3;
                                this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f7) - viewVe.getMeasuredHeight(), i12, Math.round(f7));
                            } else {
                                i8 = i6;
                                z3 = true;
                                cVar2 = cVar;
                                c2 = c3;
                                this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewVe.getMeasuredHeight());
                            }
                            c cVar3 = cVar2;
                            float measuredHeight = f6 + viewVe.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) cVar3).bottomMargin;
                            float measuredHeight2 = f7 - ((viewVe.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) cVar3).topMargin);
                            if (z2) {
                                veVar.c(viewVe, 0, i10, 0, i9);
                            } else {
                                veVar.c(viewVe, 0, i9, 0, i10);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        } else {
                            c3 = 4;
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            if (z2) {
                                this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f7) - viewVe.getMeasuredHeight(), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f6), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f6) + viewVe.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f7) - viewVe.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewVe.getMeasuredHeight());
                        }
                        c cVar4 = cVar2;
                        float measuredHeight3 = f6 + viewVe.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) cVar4).bottomMargin;
                        float measuredHeight4 = f7 - ((viewVe.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) cVar4).topMargin);
                        if (z2) {
                            veVar.c(viewVe, 0, i10, 0, i9);
                        } else {
                            veVar.c(viewVe, 0, i9, 0, i10);
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight4;
                    } else {
                        i8 = i6;
                        z3 = true;
                        c2 = 4;
                    }
                    i6 = i8 + 1;
                    z4 = z3;
                    c4 = c2;
                }
                int i19 = veVar.sp;
                paddingLeft += i19;
                i12 -= i19;
            } else {
                f = paddingTop;
                i5 = i11 - paddingBottom;
            }
            f2 = i5;
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < veVar.x) {
                i7 = veVar.z + i6;
                viewVe = ve(i7);
                if (viewVe != null) {
                    i8 = i6;
                    z3 = z4;
                    c2 = c4;
                } else if (viewVe.getVisibility() != 8) {
                    cVar = (c) viewVe.getLayoutParams();
                    f4 = f + ((ViewGroup.MarginLayoutParams) cVar).topMargin;
                    f5 = f2 - ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                    if (uj(i7, i6)) {
                        int i110 = this.sl;
                        float f10 = i110;
                        f6 = f4 + f10;
                        i9 = i110;
                        f7 = f5 - f10;
                    } else {
                        f6 = f4;
                        f7 = f5;
                        i9 = 0;
                    }
                    if (i6 == veVar.x - 1) {
                        c3 = 4;
                        if ((this.i & 4) > 0) {
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            if (z2) {
                                this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f7) - viewVe.getMeasuredHeight(), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f6), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f6) + viewVe.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f7) - viewVe.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            cVar2 = cVar;
                            c2 = c3;
                            this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewVe.getMeasuredHeight());
                        }
                        c cVar5 = cVar2;
                        float measuredHeight5 = f6 + viewVe.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) cVar5).bottomMargin;
                        float measuredHeight6 = f7 - ((viewVe.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) cVar5).topMargin);
                        if (z2) {
                            veVar.c(viewVe, 0, i10, 0, i9);
                        } else {
                            veVar.c(viewVe, 0, i9, 0, i10);
                        }
                        f = measuredHeight5;
                        f2 = measuredHeight6;
                    } else {
                        c3 = 4;
                    }
                    if (z) {
                        i8 = i6;
                        z3 = true;
                        cVar2 = cVar;
                        c2 = c3;
                        if (z2) {
                            this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f7) - viewVe.getMeasuredHeight(), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f7));
                        } else {
                            this.z.c(viewVe, veVar, false, paddingLeft, Math.round(f6), paddingLeft + viewVe.getMeasuredWidth(), Math.round(f6) + viewVe.getMeasuredHeight());
                        }
                    } else if (z2) {
                        i8 = i6;
                        z3 = true;
                        cVar2 = cVar;
                        c2 = c3;
                        this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f7) - viewVe.getMeasuredHeight(), i12, Math.round(f7));
                    } else {
                        i8 = i6;
                        z3 = true;
                        cVar2 = cVar;
                        c2 = c3;
                        this.z.c(viewVe, veVar, true, i12 - viewVe.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewVe.getMeasuredHeight());
                    }
                    c cVar6 = cVar2;
                    float measuredHeight7 = f6 + viewVe.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) cVar6).bottomMargin;
                    float measuredHeight8 = f7 - ((viewVe.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) cVar6).topMargin);
                    if (z2) {
                        veVar.c(viewVe, 0, i10, 0, i9);
                    } else {
                        veVar.c(viewVe, 0, i9, 0, i10);
                    }
                    f = measuredHeight7;
                    f2 = measuredHeight8;
                } else {
                    i8 = i6;
                    z3 = true;
                    c2 = 4;
                }
                i6 = i8 + 1;
                z4 = z3;
                c4 = c2;
            }
            int i111 = veVar.sp;
            paddingLeft += i111;
            i12 -= i111;
        }
    }

    private void c(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.m.size();
        for (int i3 = 0; i3 < size; i3++) {
            ve veVar = this.m.get(i3);
            for (int i4 = 0; i4 < veVar.x; i4++) {
                int i5 = veVar.z + i4;
                View viewVe = ve(i5);
                if (viewVe != null && viewVe.getVisibility() != 8) {
                    c cVar = (c) viewVe.getLayoutParams();
                    if (uj(i5, i4)) {
                        if (z) {
                            left = viewVe.getRight() + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        } else {
                            left = (viewVe.getLeft() - ((ViewGroup.MarginLayoutParams) cVar).leftMargin) - this.t;
                        }
                        c(canvas, left, veVar.tt, veVar.sp);
                    }
                    if (i4 == veVar.x - 1 && (this.da & 4) > 0) {
                        if (z) {
                            right = (viewVe.getLeft() - ((ViewGroup.MarginLayoutParams) cVar).leftMargin) - this.t;
                        } else {
                            right = viewVe.getRight() + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        }
                        c(canvas, right, veVar.tt, veVar.sp);
                    }
                }
            }
            if (uj(i3)) {
                if (z2) {
                    i2 = veVar.uj;
                } else {
                    i2 = veVar.tt - this.sl;
                }
                tt(canvas, paddingLeft, i2, iMax);
            }
            if (a(i3) && (this.i & 4) > 0) {
                if (z2) {
                    i = veVar.tt - this.sl;
                } else {
                    i = veVar.uj;
                }
                tt(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void c(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.x;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.t + i, i3 + i2);
        this.x.draw(canvas);
    }

    @Override // com.byazt.qa.c
    public int c(View view, int i, int i2) {
        int i3;
        int i4;
        if (c()) {
            i3 = uj(i, i2) ? 0 + this.t : 0;
            if ((this.da & 4) <= 0) {
                return i3;
            }
            i4 = this.t;
        } else {
            i3 = uj(i, i2) ? 0 + this.sl : 0;
            if ((this.i & 4) <= 0) {
                return i3;
            }
            i4 = this.sl;
        }
        return i3 + i4;
    }

    @Override // com.byazt.qa.c
    public void c(ve veVar) {
        if (c()) {
            if ((this.da & 4) > 0) {
                int i = veVar.n;
                int i2 = this.t;
                veVar.n = i + i2;
                veVar.f28966a += i2;
                return;
            }
            return;
        }
        if ((this.i & 4) > 0) {
            int i3 = veVar.n;
            int i4 = this.sl;
            veVar.n = i3 + i4;
            veVar.f28966a += i4;
        }
    }

    @Override // com.byazt.qa.c
    public int c(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.byazt.qa.c
    public void c(View view, int i, int i2, ve veVar) {
        if (uj(i, i2)) {
            if (c()) {
                int i3 = veVar.n;
                int i4 = this.t;
                veVar.n = i3 + i4;
                veVar.f28966a += i4;
                return;
            }
            int i5 = veVar.n;
            int i6 = this.sl;
            veVar.n = i5 + i6;
            veVar.f28966a += i6;
        }
    }

    public void c(com.byazt.xj.ve veVar) {
        this.nu = veVar;
    }
}
