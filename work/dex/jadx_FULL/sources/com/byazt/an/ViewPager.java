package com.byazt.an;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.byazt.nr.m;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1270, 1877})
public class ViewPager extends ViewGroup {
    public int aw;
    public uj b;
    public boolean bm;
    public VelocityTracker bx;
    public int c;
    public float cu;
    public int d;
    public int da;
    public int eo;
    public boolean gr;
    public float gt;
    public int gu;
    public boolean h;
    public int hd;
    public final Rect i;
    public int ic;
    public n kk;
    public uj kp;
    public EdgeEffect l;
    public boolean lo;
    public EdgeEffect lr;
    public boolean lt;
    public int m;
    public boolean md;
    public int my;
    public float nb;
    public Drawable nu;
    public float or;
    public ArrayList<View> os;
    public int p;
    public int pf;
    public boolean pu;
    public List<Object> q;
    public float qp;
    public int qy;
    public final Runnable r;
    public int rh;
    public float rl;
    public int s;
    public Parcelable sl;
    public final ArrayList<tt> sp;
    public int sv;
    public ClassLoader t;
    public List<uj> tk;
    public int to;
    public int tx;
    public Scroller u;
    public int uj;
    public int v;
    public com.byazt.an.tt ve;
    public final tt x;
    public boolean yp;
    public boolean yv;
    public a z;
    public int zb;
    public boolean zm;
    public static final int[] tt = {R.attr.layout_gravity};
    public static final Comparator<tt> n = new Comparator<tt>() { // from class: com.byazt.an.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(tt ttVar, tt ttVar2) {
            return ttVar.tt - ttVar2.tt;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f28288a = new Interpolator() { // from class: com.byazt.an.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final x oz = new x();

    @com.byazt.zqa.c(c = {0, 1, 1270, 1283})
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.tt();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.tt();
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
    }

    public interface n {
        void c(View view, float f);
    }

    @com.byazt.zqa.c(c = {0, 1, 1270, 1393})
    public static class sp extends com.byazt.an.c {
        public static final Parcelable.Creator<sp> CREATOR = new Parcelable.ClassLoaderCreator<sp>() { // from class: com.byazt.an.ViewPager.sp.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public sp createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new sp(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public sp createFromParcel(Parcel parcel) {
                return new sp(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public sp[] newArray(int i) {
                return new sp[i];
            }
        };
        public int tt;
        public ClassLoader uj;
        public Parcelable ve;

        public sp(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.tt + "}";
        }

        @Override // com.byazt.an.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.tt);
            parcel.writeParcelable(this.ve, i);
        }

        public sp(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.tt = parcel.readInt();
            this.ve = parcel.readParcelable(classLoader);
            this.uj = classLoader;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1270, 1386})
    public static class tt {
        public Object c;
        public float n;
        public int tt;
        public float uj;
        public boolean ve;
    }

    public interface uj {
        void c(int i, float f, int i2);

        void t(int i);

        void u(int i);
    }

    @com.byazt.zqa.c(c = {0, 1, 1270, 1286})
    public static class x implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            ve veVar = (ve) view.getLayoutParams();
            ve veVar2 = (ve) view2.getLayoutParams();
            boolean z = veVar.c;
            if (z != veVar2.c) {
                return z ? 1 : -1;
            }
            return veVar.n - veVar2.n;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.sp = new ArrayList<>();
        this.x = new tt();
        this.i = new Rect();
        this.da = -1;
        this.sl = null;
        this.t = null;
        this.gt = -3.4028235E38f;
        this.rl = Float.MAX_VALUE;
        this.p = 1;
        this.pf = -1;
        this.lo = true;
        this.pu = false;
        this.r = new Runnable() { // from class: com.byazt.an.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.ve();
            }
        };
        this.s = 0;
        c();
    }

    private void a() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((ve) getChildAt(i).getLayoutParams()).c) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void da() {
        this.md = false;
        this.h = false;
        VelocityTracker velocityTracker = this.bx;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.bx = null;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private tt i() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        tt ttVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.sp.size()) {
            tt ttVar2 = this.sp.get(i2);
            if (!z && ttVar2.tt != (i = i3 + 1)) {
                ttVar2 = this.x;
                ttVar2.n = f + f3 + f2;
                ttVar2.tt = i;
                ttVar2.uj = this.ve.c(i);
                i2--;
            }
            tt ttVar3 = ttVar2;
            f = ttVar3.n;
            float f4 = ttVar3.uj + f + f2;
            if (!z && scrollX < f) {
                return ttVar;
            }
            if (scrollX < f4 || i2 == this.sp.size() - 1) {
                return ttVar3;
            }
            int i4 = ttVar3.tt;
            float f5 = ttVar3.uj;
            i2++;
            z = false;
            i3 = i4;
            f3 = f5;
            ttVar = ttVar3;
        }
        return ttVar;
    }

    private void n(int i) {
        uj ujVar = this.kp;
        if (ujVar != null) {
            ujVar.t(i);
        }
        List<uj> list = this.tk;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                uj ujVar2 = this.tk.get(i2);
                if (ujVar2 != null) {
                    ujVar2.t(i);
                }
            }
        }
        uj ujVar3 = this.b;
        if (ujVar3 != null) {
            ujVar3.t(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.zm != z) {
            this.zm = z;
        }
    }

    private void sp() {
        if (this.v != 0) {
            ArrayList<View> arrayList = this.os;
            if (arrayList == null) {
                this.os = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.os.add(getChildAt(i));
            }
            Collections.sort(this.os, oz);
        }
    }

    private boolean uj(int i) {
        if (this.sp.size() == 0) {
            if (this.lo) {
                return false;
            }
            this.lt = false;
            c(0, 0.0f, 0);
            if (this.lt) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        tt ttVarI = i();
        int clientWidth = getClientWidth();
        int i2 = this.m;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = ttVarI.tt;
        float f2 = ((i / f) - ttVarI.n) / (ttVarI.uj + (i2 / f));
        this.lt = false;
        c(i4, f2, (int) (i3 * f2));
        if (this.lt) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean x() {
        this.pf = -1;
        da();
        this.lr.onRelease();
        this.l.onRelease();
        return this.lr.isFinished() || this.l.isFinished();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        tt ttVarC;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (ttVarC = c(childAt)) != null && ttVarC.tt == this.uj) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        tt ttVarC;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ttVarC = c(childAt)) != null && ttVarC.tt == this.uj) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        ve veVar = (ve) layoutParams;
        boolean zVe = veVar.c | ve(view);
        veVar.c = zVe;
        if (!this.gr) {
            super.addView(view, i, layoutParams);
        } else {
            if (zVe) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            veVar.uj = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    public void c() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.u = new Scroller(context, f28288a);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.zb = viewConfiguration.getScaledPagingTouchSlop();
        this.sv = (int) (400.0f * f);
        this.aw = viewConfiguration.getScaledMaximumFlingVelocity();
        this.lr = new EdgeEffect(context);
        this.l = new EdgeEffect(context);
        this.ic = (int) (25.0f * f);
        this.hd = (int) (2.0f * f);
        this.d = (int) (f * 16.0f);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.ve == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.gt));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.rl));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ve) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.yp = true;
        if (this.u.isFinished() || !this.u.computeScrollOffset()) {
            c(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.u.getCurrX();
        int currY = this.u.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!uj(currX)) {
                this.u.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || c(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        tt ttVarC;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ttVarC = c(childAt)) != null && ttVarC.tt == this.uj && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.byazt.an.tt ttVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (ttVar = this.ve) != null && ttVar.c() > 1)) {
            if (!this.lr.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.gt * width);
                this.lr.setSize(height, width);
                zDraw = false | this.lr.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.l.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.rl + 1.0f)) * width2);
                this.l.setSize(height2, width2);
                zDraw |= this.l.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.lr.finish();
            this.l.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.nu;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ve();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.byazt.an.tt getAdapter() {
        return this.ve;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.v == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ve) this.os.get(i2).getLayoutParams()).f28289a;
    }

    public int getCurrentItem() {
        return this.uj;
    }

    public int getOffscreenPageLimit() {
        return this.p;
    }

    public int getPageMargin() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lo = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.r);
        Scroller scroller = this.u;
        if (scroller != null && !scroller.isFinished()) {
            this.u.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        super.onDraw(canvas);
        if (this.m <= 0 || this.nu == null || this.sp.size() <= 0 || this.ve == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f2 = width;
        float f3 = this.m / f2;
        int i2 = 0;
        tt ttVar = this.sp.get(0);
        float f4 = ttVar.n;
        int size = this.sp.size();
        int i3 = ttVar.tt;
        int i4 = this.sp.get(size - 1).tt;
        while (i3 < i4) {
            while (true) {
                i = ttVar.tt;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                ttVar = this.sp.get(i2);
            }
            if (i3 == i) {
                float f5 = ttVar.n;
                float f6 = ttVar.uj;
                f = (f5 + f6) * f2;
                f4 = f5 + f6 + f3;
            } else {
                float fC = this.ve.c(i3);
                f = (f4 + fC) * f2;
                f4 += fC + f3;
            }
            if (this.m + f > scrollX) {
                this.nu.setBounds(Math.round(f), this.rh, Math.round(this.m + f), this.my);
                this.nu.draw(canvas);
            }
            if (f > scrollX + width) {
                return;
            }
            i3++;
            f3 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            x();
            return false;
        }
        if (action != 0) {
            if (this.md) {
                return true;
            }
            if (this.h) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.qp = x2;
            this.or = x2;
            float y = motionEvent.getY();
            this.nb = y;
            this.cu = y;
            this.pf = motionEvent.getPointerId(0);
            this.h = false;
            this.yp = true;
            this.u.computeScrollOffset();
            if (this.s != 2 || Math.abs(this.u.getFinalX() - this.u.getCurrX()) <= this.hd) {
                c(false);
                this.md = false;
            } else {
                this.u.abortAnimation();
                this.yv = false;
                ve();
                this.md = true;
                ve(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.pf;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f = x3 - this.or;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.nb);
                if (f != 0.0f && !c(this.or, f) && c(this, false, (int) f, (int) x3, (int) y2)) {
                    this.or = x3;
                    this.cu = y2;
                    this.h = true;
                    return false;
                }
                int i2 = this.zb;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.md = true;
                    ve(true);
                    setScrollState(1);
                    this.or = f > 0.0f ? this.qp + this.zb : this.qp - this.zb;
                    this.cu = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.h = true;
                }
                if (this.md && tt(x3)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            c(motionEvent);
        }
        if (this.bx == null) {
            this.bx = VelocityTracker.obtain();
        }
        this.bx.addMovement(motionEvent);
        return this.md;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        tt ttVarC;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ve veVar = (ve) childAt.getLayoutParams();
                if (veVar.c) {
                    int i9 = veVar.tt;
                    int i10 = i9 & 7;
                    int i11 = i9 & 112;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i11 != 16) {
                            if (i11 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i11 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i12 = paddingLeft + scrollX;
                            childAt.layout(i12, paddingTop, childAt.getMeasuredWidth() + i12, paddingTop + childAt.getMeasuredHeight());
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i13 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i13;
                        int i14 = paddingLeft + scrollX;
                        childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i15;
                    if (i11 != 16) {
                        if (i11 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i16 = paddingLeft + scrollX;
                        childAt.layout(i16, paddingTop, childAt.getMeasuredWidth() + i16, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i17 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i17;
                    int i18 = paddingLeft + scrollX;
                    childAt.layout(i18, paddingTop, childAt.getMeasuredWidth() + i18, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i19 = (i5 - paddingLeft) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                ve veVar2 = (ve) childAt2.getLayoutParams();
                if (!veVar2.c && (ttVarC = c(childAt2)) != null) {
                    float f = i19;
                    int i21 = ((int) (ttVarC.n * f)) + paddingLeft;
                    if (veVar2.uj) {
                        veVar2.uj = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * veVar2.ve), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i21, paddingTop, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.rh = paddingTop;
        this.my = i6 - paddingBottom;
        this.to = i7;
        if (this.lo) {
            z2 = false;
            c(this.uj, false, 0, false);
        } else {
            z2 = false;
        }
        this.lo = z2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        ve veVar;
        ve veVar2;
        int i3;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.eo = Math.min(measuredWidth / 10, this.d);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && (veVar2 = (ve) childAt.getLayoutParams()) != null && veVar2.c) {
                int i6 = veVar2.tt;
                int i7 = i6 & 7;
                int i8 = i6 & 112;
                boolean z2 = i8 == 48 || i8 == 80;
                if (i7 != 3 && i7 != 5) {
                    z = false;
                }
                int i9 = Integer.MIN_VALUE;
                if (z2) {
                    i3 = Integer.MIN_VALUE;
                    i9 = 1073741824;
                } else {
                    i3 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i10 = ((ViewGroup.LayoutParams) veVar2).width;
                if (i10 != -2) {
                    if (i10 == -1) {
                        i10 = paddingLeft;
                    }
                    i9 = 1073741824;
                } else {
                    i10 = paddingLeft;
                }
                int i11 = ((ViewGroup.LayoutParams) veVar2).height;
                if (i11 == -2) {
                    i11 = measuredHeight;
                    i5 = i3;
                } else if (i11 == -1) {
                    i11 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec(i11, i5));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        this.qy = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.gu = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.gr = true;
        ve();
        this.gr = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((veVar = (ve) childAt2.getLayoutParams()) == null || !veVar.c)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * veVar.ve), 1073741824), this.gu);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        tt ttVarC;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (ttVarC = c(childAt)) != null && ttVarC.tt == this.uj && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof sp)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        sp spVar = (sp) parcelable;
        super.onRestoreInstanceState(spVar.c());
        if (this.ve != null) {
            c(spVar.tt, false, true);
            return;
        }
        this.da = spVar.tt;
        this.sl = spVar.ve;
        this.t = spVar.uj;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        sp spVar = new sp(super.onSaveInstanceState());
        spVar.tt = this.uj;
        com.byazt.an.tt ttVar = this.ve;
        if (ttVar != null) {
            spVar.ve = ttVar.tt();
        }
        return spVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.m;
            c(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.byazt.an.tt ttVar;
        int iFindPointerIndex;
        if (this.bm) {
            return true;
        }
        boolean zX = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (ttVar = this.ve) == null || ttVar.c() == 0) {
            return false;
        }
        if (this.bx == null) {
            this.bx = VelocityTracker.obtain();
        }
        this.bx.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.u.abortAnimation();
            this.yv = false;
            ve();
            float x2 = motionEvent.getX();
            this.qp = x2;
            this.or = x2;
            float y = motionEvent.getY();
            this.nb = y;
            this.cu = y;
            this.pf = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.or = motionEvent.getX(actionIndex);
                            this.pf = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        c(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.pf);
                        if (iFindPointerIndex2 != -1) {
                            this.or = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.md) {
                    c(this.uj, true, 0, false);
                    zX = x();
                }
            } else if (!this.md) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.pf);
                if (iFindPointerIndex3 == -1) {
                    zX = x();
                } else {
                    float x3 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x3 - this.or);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.cu);
                    if (fAbs > this.zb && fAbs > fAbs2) {
                        this.md = true;
                        ve(true);
                        float f = this.qp;
                        this.or = x3 - f > 0.0f ? f + this.zb : f - this.zb;
                        this.cu = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.md) {
                        zX = false | tt(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.md && (iFindPointerIndex = motionEvent.findPointerIndex(this.pf)) != -1) {
                zX = false | tt(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.md) {
            VelocityTracker velocityTracker = this.bx;
            velocityTracker.computeCurrentVelocity(1000, this.aw);
            int xVelocity = (int) velocityTracker.getXVelocity(this.pf);
            this.yv = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            tt ttVarI = i();
            float f2 = clientWidth;
            float f3 = this.m / f2;
            int i = ttVarI.tt;
            float f4 = ((scrollX / f2) - ttVarI.n) / (ttVarI.uj + f3);
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.pf);
            if (iFindPointerIndex4 != -1) {
                c(c(i, f4, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.qp)), true, true, xVelocity);
                zX = x();
            }
        }
        if (zX) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.gr) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.byazt.an.tt ttVar) {
        com.byazt.an.tt ttVar2 = this.ve;
        if (ttVar2 != null) {
            ttVar2.c((DataSetObserver) null);
            for (int i = 0; i < this.sp.size(); i++) {
                tt ttVar3 = this.sp.get(i);
                this.ve.c((ViewGroup) this, ttVar3.tt, ttVar3.c);
            }
            this.sp.clear();
            a();
            this.uj = 0;
            scrollTo(0, 0);
        }
        this.ve = ttVar;
        this.c = 0;
        if (ttVar != null) {
            if (this.z == null) {
                this.z = new a();
            }
            this.ve.c((DataSetObserver) this.z);
            this.yv = false;
            boolean z = this.lo;
            this.lo = true;
            this.c = this.ve.c();
            int i2 = this.da;
            if (i2 >= 0) {
                c(i2, false, true);
                this.da = -1;
                this.sl = null;
                this.t = null;
            } else if (z) {
                requestLayout();
            } else {
                ve();
            }
        }
        List<Object> list = this.q;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.q.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.q.get(i3);
        }
    }

    public void setCurrentItem(int i) {
        this.yv = false;
        c(i, !this.lo, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            m.tt("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.p) {
            this.p = i;
            ve();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(uj ujVar) {
        this.kp = ujVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.m;
        this.m = i;
        int width = getWidth();
        c(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.nu = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.s == i) {
            return;
        }
        this.s = i;
        if (this.kk != null) {
            tt(i != 0);
        }
        a(i);
    }

    public void setScroller(Scroller scroller) {
        this.u = scroller;
    }

    public void tt() {
        int iC = this.ve.c();
        this.c = iC;
        boolean z = this.sp.size() < (this.p * 2) + 1 && this.sp.size() < iC;
        int iMax = this.uj;
        int i = 0;
        while (i < this.sp.size()) {
            tt ttVar = this.sp.get(i);
            int iC2 = this.ve.c(ttVar.c);
            if (iC2 != -1) {
                if (iC2 == -2) {
                    this.sp.remove(i);
                    i--;
                    this.ve.c((ViewGroup) this, ttVar.tt, ttVar.c);
                    int i2 = this.uj;
                    if (i2 == ttVar.tt) {
                        iMax = Math.max(0, Math.min(i2, iC - 1));
                    }
                } else {
                    int i3 = ttVar.tt;
                    if (i3 != iC2) {
                        if (i3 == this.uj) {
                            iMax = iC2;
                        }
                        ttVar.tt = iC2;
                    }
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.sp, n);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                ve veVar = (ve) getChildAt(i4).getLayoutParams();
                if (!veVar.c) {
                    veVar.ve = 0.0f;
                }
            }
            c(iMax, false, true);
            requestLayout();
        }
    }

    public void ve() {
        c(this.uj);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.nu;
    }

    @com.byazt.zqa.c(c = {0, 1, 1270, 1438})
    public static class ve extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28289a;
        public boolean c;
        public int n;
        public int tt;
        public boolean uj;
        public float ve;

        public ve() {
            super(-1, -1);
            this.ve = 0.0f;
        }

        public ve(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.ve = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.tt);
            this.tt = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static boolean ve(View view) {
        return view.getClass().getAnnotation(c.class) != null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ve(getContext(), attributeSet);
    }

    private void ve(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    private void a(int i) {
        uj ujVar = this.kp;
        if (ujVar != null) {
            ujVar.u(i);
        }
        List<uj> list = this.tk;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                uj ujVar2 = this.tk.get(i2);
                if (ujVar2 != null) {
                    ujVar2.u(i);
                }
            }
        }
        uj ujVar3 = this.b;
        if (ujVar3 != null) {
            ujVar3.u(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bb  */
    public boolean ve(int i) {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zUj = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                m.uj("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i == 17 || i == 1) {
                zUj = uj();
            } else if (i == 66 || i == 2) {
                zUj = n();
            }
        } else if (i == 17) {
            int i2 = c(this.i, viewFindNextFocus).left;
            int i3 = c(this.i, viewFindFocus).left;
            if (viewFindFocus != null && i2 >= i3) {
                zUj = uj();
            } else {
                zUj = viewFindNextFocus.requestFocus();
            }
        } else if (i == 66) {
            int i4 = c(this.i, viewFindNextFocus).left;
            int i5 = c(this.i, viewFindFocus).left;
            if (viewFindFocus == null || i4 > i5) {
                zUj = viewFindNextFocus.requestFocus();
            } else {
                zUj = n();
            }
        }
        if (zUj) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zUj;
    }

    public boolean n() {
        com.byazt.an.tt ttVar = this.ve;
        if (ttVar == null || this.uj >= ttVar.c() - 1) {
            return false;
        }
        c(this.uj + 1, true);
        return true;
    }

    public void c(int i, boolean z) {
        this.yv = false;
        c(i, z, false);
    }

    public boolean uj() {
        int i = this.uj;
        if (i <= 0) {
            return false;
        }
        c(i - 1, true);
        return true;
    }

    public void c(int i, boolean z, boolean z2) {
        c(i, z, z2, 0);
    }

    public void c(int i, boolean z, boolean z2, int i2) {
        com.byazt.an.tt ttVar = this.ve;
        if (ttVar != null && ttVar.c() > 0) {
            if (!z2 && this.uj == i && this.sp.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.ve.c()) {
                i = this.ve.c() - 1;
            }
            int i3 = this.p;
            int i4 = this.uj;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.sp.size(); i5++) {
                    this.sp.get(i5).ve = true;
                }
            }
            boolean z3 = this.uj != i;
            if (this.lo) {
                this.uj = i;
                if (z3) {
                    n(i);
                }
                requestLayout();
                return;
            }
            c(i);
            c(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public tt tt(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return c(view);
            }
        }
    }

    public tt tt(int i) {
        for (int i2 = 0; i2 < this.sp.size(); i2++) {
            tt ttVar = this.sp.get(i2);
            if (ttVar.tt == i) {
                return ttVar;
            }
        }
        return null;
    }

    private void tt(int i, float f, int i2) {
        uj ujVar = this.kp;
        if (ujVar != null) {
            ujVar.c(i, f, i2);
        }
        List<uj> list = this.tk;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                uj ujVar2 = this.tk.get(i3);
                if (ujVar2 != null) {
                    ujVar2.c(i, f, i2);
                }
            }
        }
        uj ujVar3 = this.b;
        if (ujVar3 != null) {
            ujVar3.c(i, f, i2);
        }
    }

    private void c(int i, boolean z, int i2, boolean z2) {
        tt ttVarTt = tt(i);
        int clientWidth = ttVarTt != null ? (int) (getClientWidth() * Math.max(this.gt, Math.min(ttVarTt.n, this.rl))) : 0;
        if (z) {
            c(clientWidth, 0, i2);
            if (z2) {
                n(i);
                return;
            }
            return;
        }
        if (z2) {
            n(i);
        }
        c(false);
        scrollTo(clientWidth, 0);
        uj(clientWidth);
    }

    private void tt(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.tx : 0, null);
        }
    }

    private boolean tt(float f) {
        boolean z;
        boolean z2;
        float f2 = this.or - f;
        this.or = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.gt * clientWidth;
        float f4 = this.rl * clientWidth;
        boolean z3 = false;
        tt ttVar = this.sp.get(0);
        ArrayList<tt> arrayList = this.sp;
        tt ttVar2 = arrayList.get(arrayList.size() - 1);
        if (ttVar.tt != 0) {
            f3 = ttVar.n * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (ttVar2.tt != this.ve.c() - 1) {
            f4 = ttVar2.n * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.lr.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.l.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.or += scrollX - i;
        scrollTo(i, getScrollY());
        uj(i);
        return z3;
    }

    public void c(uj ujVar) {
        if (this.tk == null) {
            this.tk = new ArrayList();
        }
        this.tk.add(ujVar);
    }

    public void c(boolean z, n nVar) {
        c(z, nVar, 2);
    }

    public void c(boolean z, n nVar, int i) {
        boolean z2 = nVar != null;
        boolean z3 = z2 != (this.kk != null);
        this.kk = nVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.v = z ? 2 : 1;
            this.tx = i;
        } else {
            this.v = 0;
        }
        if (z3) {
            ve();
        }
    }

    public float c(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void c(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.u;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.yp ? this.u.getCurrX() : this.u.getStartX();
            this.u.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            c(false);
            ve();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fC = f2 + (c(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fC / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.ve.c(this.uj)) + this.m)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.yp = false;
        this.u.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    public tt c(int i, int i2) {
        tt ttVar = new tt();
        ttVar.tt = i;
        ttVar.c = this.ve.c((ViewGroup) this, i);
        ttVar.uj = this.ve.c(i);
        if (i2 >= 0 && i2 < this.sp.size()) {
            this.sp.add(i2, ttVar);
        } else {
            this.sp.add(ttVar);
        }
        return ttVar;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00f1 A[PHI: r7 r10 r15
      0x00f1: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    public void c(int i) {
        tt ttVarTt;
        String hexString;
        tt ttVarC;
        tt ttVarC2;
        tt ttVar;
        int i2 = this.uj;
        if (i2 != i) {
            ttVarTt = tt(i2);
            this.uj = i;
        } else {
            ttVarTt = null;
        }
        if (this.ve == null) {
            sp();
            return;
        }
        if (this.yv) {
            sp();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.p;
        int iMax = Math.max(0, this.uj - i3);
        int iC = this.ve.c();
        int iMin = Math.min(iC - 1, this.uj + i3);
        if (iC == this.c) {
            int i4 = 0;
            while (true) {
                if (i4 < this.sp.size()) {
                    ttVarC = this.sp.get(i4);
                    int i5 = ttVarC.tt;
                    int i6 = this.uj;
                    if (i5 >= i6) {
                        if (i5 != i6) {
                            break;
                        } else {
                            break;
                        }
                    }
                    i4++;
                }
                ttVarC = null;
                break;
            }
            if (ttVarC == null && iC > 0) {
                ttVarC = c(this.uj, i4);
            }
            if (ttVarC != null) {
                int i7 = i4 - 1;
                tt ttVar2 = i7 >= 0 ? this.sp.get(i7) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - ttVarC.uj) + (getPaddingLeft() / clientWidth);
                float f = 0.0f;
                for (int i8 = this.uj - 1; i8 >= 0; i8--) {
                    if (f >= paddingLeft && i8 < iMax) {
                        if (ttVar2 == null) {
                            break;
                        }
                        if (i8 == ttVar2.tt && !ttVar2.ve) {
                            this.sp.remove(i7);
                            this.ve.c((ViewGroup) this, i8, ttVar2.c);
                            i7--;
                            i4--;
                            if (i7 >= 0) {
                                ttVar = this.sp.get(i7);
                            } else {
                                ttVar = null;
                            }
                            ttVar2 = ttVar;
                        }
                    } else {
                        if (ttVar2 != null && i8 == ttVar2.tt) {
                            f += ttVar2.uj;
                            i7--;
                            if (i7 >= 0) {
                                ttVar = this.sp.get(i7);
                            } else {
                                ttVar = null;
                            }
                        } else {
                            f += c(i8, i7 + 1).uj;
                            i4++;
                            if (i7 >= 0) {
                                ttVar = this.sp.get(i7);
                            } else {
                                ttVar = null;
                            }
                        }
                        ttVar2 = ttVar;
                    }
                }
                float f2 = ttVarC.uj;
                int i9 = i4 + 1;
                if (f2 < 2.0f) {
                    tt ttVar3 = i9 < this.sp.size() ? this.sp.get(i9) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    int i10 = this.uj;
                    while (true) {
                        i10++;
                        if (i10 >= iC) {
                            break;
                        }
                        if (f2 >= paddingRight && i10 > iMin) {
                            if (ttVar3 == null) {
                                break;
                            }
                            if (i10 == ttVar3.tt && !ttVar3.ve) {
                                this.sp.remove(i9);
                                this.ve.c((ViewGroup) this, i10, ttVar3.c);
                                if (i9 < this.sp.size()) {
                                    ttVar3 = this.sp.get(i9);
                                }
                            }
                        } else if (ttVar3 != null && i10 == ttVar3.tt) {
                            f2 += ttVar3.uj;
                            i9++;
                            if (i9 < this.sp.size()) {
                                ttVar3 = this.sp.get(i9);
                            }
                        } else {
                            tt ttVarC3 = c(i10, i9);
                            i9++;
                            f2 += ttVarC3.uj;
                            ttVar3 = i9 < this.sp.size() ? this.sp.get(i9) : null;
                        }
                    }
                }
                c(ttVarC, i4, ttVarTt);
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                ve veVar = (ve) childAt.getLayoutParams();
                veVar.f28289a = i11;
                if (!veVar.c && veVar.ve == 0.0f && (ttVarC2 = c(childAt)) != null) {
                    veVar.ve = ttVarC2.uj;
                    veVar.n = ttVarC2.tt;
                }
            }
            sp();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                tt ttVarTt2 = viewFindFocus != null ? tt(viewFindFocus) : null;
                if (ttVarTt2 == null || ttVarTt2.tt != this.uj) {
                    for (int i12 = 0; i12 < getChildCount(); i12++) {
                        View childAt2 = getChildAt(i12);
                        tt ttVarC4 = c(childAt2);
                        if (ttVarC4 != null && ttVarC4.tt == this.uj && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.c + ", found: " + iC + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.ve.getClass());
    }

    private void c(tt ttVar, int i, tt ttVar2) {
        int i2;
        int i3;
        tt ttVar3;
        tt ttVar4;
        int iC = this.ve.c();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        if (ttVar2 != null) {
            int i4 = ttVar2.tt;
            int i5 = ttVar.tt;
            if (i4 < i5) {
                float fC = ttVar2.n + ttVar2.uj + f;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= ttVar.tt && i7 < this.sp.size()) {
                    tt ttVar5 = this.sp.get(i7);
                    while (true) {
                        ttVar4 = ttVar5;
                        if (i6 <= ttVar4.tt || i7 >= this.sp.size() - 1) {
                            break;
                        }
                        i7++;
                        ttVar5 = this.sp.get(i7);
                    }
                    while (i6 < ttVar4.tt) {
                        fC += this.ve.c(i6) + f;
                        i6++;
                    }
                    ttVar4.n = fC;
                    fC += ttVar4.uj + f;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.sp.size() - 1;
                float fC2 = ttVar2.n;
                while (true) {
                    i4--;
                    if (i4 < ttVar.tt || size < 0) {
                        break;
                    }
                    tt ttVar6 = this.sp.get(size);
                    while (true) {
                        ttVar3 = ttVar6;
                        if (i4 >= ttVar3.tt || size <= 0) {
                            break;
                        }
                        size--;
                        ttVar6 = this.sp.get(size);
                    }
                    while (i4 > ttVar3.tt) {
                        fC2 -= this.ve.c(i4) + f;
                        i4--;
                    }
                    fC2 -= ttVar3.uj + f;
                    ttVar3.n = fC2;
                }
            }
        }
        int size2 = this.sp.size();
        float fC3 = ttVar.n;
        int i8 = ttVar.tt;
        int i9 = i8 - 1;
        this.gt = i8 == 0 ? fC3 : -3.4028235E38f;
        int i10 = iC - 1;
        this.rl = i8 == i10 ? (ttVar.uj + fC3) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            tt ttVar7 = this.sp.get(i11);
            while (true) {
                i3 = ttVar7.tt;
                if (i9 <= i3) {
                    break;
                }
                fC3 -= this.ve.c(i9) + f;
                i9--;
            }
            fC3 -= ttVar7.uj + f;
            ttVar7.n = fC3;
            if (i3 == 0) {
                this.gt = fC3;
            }
            i11--;
            i9--;
        }
        float fC4 = ttVar.n + ttVar.uj + f;
        int i12 = ttVar.tt + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            tt ttVar8 = this.sp.get(i13);
            while (true) {
                i2 = ttVar8.tt;
                if (i12 >= i2) {
                    break;
                }
                fC4 += this.ve.c(i12) + f;
                i12++;
            }
            if (i2 == i10) {
                this.rl = (ttVar8.uj + fC4) - 1.0f;
            }
            ttVar8.n = fC4;
            fC4 += ttVar8.uj + f;
            i13++;
            i12++;
        }
        this.pu = false;
    }

    public tt c(View view) {
        for (int i = 0; i < this.sp.size(); i++) {
            tt ttVar = this.sp.get(i);
            if (this.ve.c(view, ttVar.c)) {
                return ttVar;
            }
        }
        return null;
    }

    private void c(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.sp.isEmpty()) {
            if (!this.u.isFinished()) {
                this.u.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        tt ttVarTt = tt(this.uj);
        int iMin = (int) ((ttVarTt != null ? Math.min(ttVarTt.n, this.rl) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            c(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    public void c(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.to > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ve veVar = (ve) childAt.getLayoutParams();
                if (veVar.c) {
                    int i4 = veVar.tt & 7;
                    if (i4 == 1) {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        tt(i, f, i2);
        if (this.kk != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((ve) childAt2.getLayoutParams()).c) {
                    this.kk.c(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.lt = true;
    }

    private void c(boolean z) {
        boolean z2 = this.s == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.u.isFinished()) {
                this.u.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.u.getCurrX();
                int currY = this.u.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        uj(currX);
                    }
                }
            }
        }
        this.yv = false;
        for (int i = 0; i < this.sp.size(); i++) {
            tt ttVar = this.sp.get(i);
            if (ttVar.ve) {
                ttVar.ve = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.r);
            } else {
                this.r.run();
            }
        }
    }

    private boolean c(float f, float f2) {
        if (f >= this.eo || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.eo)) && f2 < 0.0f;
        }
        return true;
    }

    private int c(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.ic || Math.abs(i2) <= this.sv) {
            i += (int) (f + (i >= this.uj ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.sp.size() <= 0) {
            return i;
        }
        tt ttVar = this.sp.get(0);
        ArrayList<tt> arrayList = this.sp;
        return Math.max(ttVar.tt, Math.min(i, arrayList.get(arrayList.size() - 1).tt));
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.pf) {
            int i = actionIndex == 0 ? 1 : 0;
            this.or = motionEvent.getX(i);
            this.pf = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.bx;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean c(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && c(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public boolean c(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return uj();
                }
                return ve(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return n();
                }
                return ve(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return ve(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return ve(1);
                }
            }
        }
        return false;
    }

    private Rect c(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
