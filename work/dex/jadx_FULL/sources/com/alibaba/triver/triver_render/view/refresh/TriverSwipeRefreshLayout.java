package com.alibaba.triver.triver_render.view.refresh;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.igexin.assist.util.AssistUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@SuppressLint({"ClickableViewAccessibility"})
public class TriverSwipeRefreshLayout extends ViewGroup {
    private static final String l = "TriverSwipeRefres";
    private static final int m = 72;
    private static final int n = 50;
    private static final int o = 100;
    private static final float p = 2.0f;
    private static final int q = -1;
    private static final float r = 1.0f;
    private static final int s = 300;
    private static final int t = 300;
    private static final int u = 300;
    private static final int v = 20;
    private int A;
    private a B;
    private b C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private float N;
    private int O;
    private int P;
    private float Q;
    private boolean R;
    private int S;
    private int T;
    private DecelerateInterpolator U;
    private long V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f25248a;
    private float aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private volatile List<WMLAScrollerInfo> aj;
    private Animator.AnimatorListener ak;
    private int al;
    private c am;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected float j;
    protected DisplayMetrics k;
    private View w;
    private RefreshHeader x;
    private LoadMoreFooter y;
    private int z;

    public class WMLAScrollerInfo implements Serializable {
        float bottom;
        float left;
        float right;
        float top;

        public WMLAScrollerInfo() {
        }

        public String toString() {
            return "WMLAScrollerInfo{top=" + this.top + ", left=" + this.left + ", bottom=" + this.bottom + ", right=" + this.right + '}';
        }
    }

    public interface a {
        void a();

        void a(int i);

        void a(RefreshHeader.RefreshState refreshState, RefreshHeader.RefreshState refreshState2);
    }

    public interface b {
        void a();

        void a(int i);

        void a(LoadMoreFooter.LoadMoreState loadMoreState, LoadMoreFooter.LoadMoreState loadMoreState2);
    }

    public interface c {
        boolean a();

        void b();

        void c();
    }

    public TriverSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = this.z;
        if (i6 < 0 && this.A < 0) {
            return i2;
        }
        if (i2 == i - 2 && i6 < i) {
            return i6;
        }
        if (i2 == i - 1 && (i5 = this.A) < i) {
            return i5;
        }
        int i7 = this.A;
        int i8 = i7 > i6 ? i7 : i6;
        if (i7 < i6) {
            i6 = i7;
        }
        if (i2 < i6 || i2 >= i8 - 1 || (i4 = i2 + 1) >= i) {
            return ((i2 >= i8 || i2 == i8 + (-1)) && (i3 = i2 + 2) < i) ? i3 : i2;
        }
        return i4;
    }

    public float getDistanceToRefresh() {
        return this.O;
    }

    public float getDistanceToSecondFloor() {
        return this.P;
    }

    public int getFooterViewHeight() {
        return this.d;
    }

    public int getHeaderViewHeight() {
        return this.c;
    }

    public LoadMoreFooter getLoadMoreFooter() {
        return this.y;
    }

    public RefreshHeader getRefresHeader() {
        return this.x;
    }

    public int getRefreshOffset() {
        return this.i;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e1  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object obj;
        e();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean zA = this.D ? a(motionEvent) : false;
        if (!zA && this.x.getCurrentState() != RefreshHeader.RefreshState.NONE) {
            zA = true;
        }
        boolean zB = this.E ? b(motionEvent) : false;
        if (!zB && this.y.getCurrentState() != LoadMoreFooter.LoadMoreState.NONE) {
            zB = true;
        }
        if (!zA && !zB) {
            return false;
        }
        if (actionMasked == 0) {
            this.ab = (int) motionEvent.getY();
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (this.L == -1) {
                this.L = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.aa = motionEvent.getY();
                this.ag = this.L;
            }
            this.K = false;
            float fA = a(motionEvent, this.L);
            if (fA == -1.0f) {
                return false;
            }
            this.Q = fA;
            this.x.getCurrentState();
            RefreshHeader.RefreshState refreshState = RefreshHeader.RefreshState.REFRESHING;
            if (this.y.getCurrentState() == LoadMoreFooter.LoadMoreState.LOADING) {
                setLoadMore(false);
            }
        } else if (actionMasked == 1) {
            if (this.K) {
                onTouchEvent(motionEvent);
                this.K = false;
            }
            obj = this.w;
            if (obj instanceof WMLTRWebView) {
                ((WMLTRWebView) obj).d = false;
            }
            this.L = -1;
        } else if (actionMasked == 2) {
            int i = this.L;
            if (i == -1) {
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                RVLogger.e(l, "Got ACTION_MOVE event but don't have an active pointer id.");
                this.L = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                this.aa = motionEvent.getY();
                this.ag = this.L;
                this.ab = (int) motionEvent.getY();
                float fA2 = a(motionEvent, this.L);
                if (fA2 == -1.0f) {
                    return false;
                }
                this.Q = fA2;
                return false;
            }
            float fA3 = a(motionEvent, i);
            if (fA3 == -1.0f) {
                return false;
            }
            if (b(motionEvent)) {
                if (this.Q - fA3 > this.g && !this.K) {
                    this.K = true;
                }
            } else if (a(motionEvent)) {
                float f = fA3 - this.Q;
                if (f > this.g && !this.K) {
                    this.K = true;
                } else if (f < 0.0f && this.x.getCurrentState() == RefreshHeader.RefreshState.REFRESHING) {
                    setRefreshing(false);
                }
            }
        } else if (actionMasked == 3) {
            if (this.K) {
                onTouchEvent(motionEvent);
                this.K = false;
            }
            obj = this.w;
            if (obj instanceof WMLTRWebView) {
                ((WMLTRWebView) obj).d = false;
            }
            this.L = -1;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (this.K) {
            RVLogger.d(l, "onInterceptTouchEvent: mIsBeingDragged");
            onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.w == null) {
            e();
        }
        if (this.w == null) {
            return;
        }
        int measuredHeight2 = this.e + this.x.getMeasuredHeight();
        if (!this.H) {
            measuredHeight2 = 0;
        }
        View view = this.w;
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + measuredHeight2) - this.S;
        view.layout(paddingLeft, this.R ? paddingTop : paddingTop - this.i, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, (paddingTop + ((measuredHeight - getPaddingTop()) - getPaddingBottom())) - this.i);
        RefreshHeader refreshHeader = this.x;
        int i5 = this.e;
        refreshHeader.layout(0, i5, this.f25248a, this.k.heightPixels + i5);
        if (!this.F && this.x.getSecondFloorView() != null) {
            this.x.getSecondFloorView().setVisibility(8);
        }
        LoadMoreFooter loadMoreFooter = this.y;
        int i6 = this.S;
        loadMoreFooter.layout(0, measuredHeight - i6, this.b, (measuredHeight + this.T) - i6);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (this.w == null) {
            e();
        }
        View view = this.w;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.x.measure(View.MeasureSpec.makeMeasureSpec(this.f25248a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.k.heightPixels, 1073741824));
        this.y.measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.T, 1073741824));
        if (AssistUtils.BRAND_HW.equalsIgnoreCase(Build.BRAND) && (i3 = this.ai) != -1 && this.k.heightPixels != i3 && this.e == (-i3)) {
            int i4 = (-this.x.getMeasuredHeight()) + this.i;
            this.h = i4;
            this.e = i4;
            this.ai = this.k.heightPixels;
        }
        if (!this.M) {
            this.M = true;
            int i5 = (-this.x.getMeasuredHeight()) + this.i;
            this.h = i5;
            this.e = i5;
            g();
        }
        this.z = -1;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (getChildAt(i6) == this.x) {
                this.z = i6;
                break;
            }
        }
        this.A = -1;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (getChildAt(i7) == this.y) {
                this.A = i7;
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean zA = this.D ? a(motionEvent) : false;
        if (!zA && this.x.getCurrentState() != RefreshHeader.RefreshState.NONE) {
            zA = true;
        }
        if (this.x.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_START || this.x.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_END) {
            zA = false;
        }
        boolean zB = this.E ? b(motionEvent) : false;
        boolean z = (zB || this.y.getCurrentState() == LoadMoreFooter.LoadMoreState.NONE) ? zB : true;
        if (zA || z) {
            if (zA) {
                return b(motionEvent, actionMasked);
            }
            if (z) {
                return c(motionEvent, actionMasked);
            }
            return false;
        }
        RVLogger.d(l, "onTouchEvent: " + zA);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        RVLogger.d(l, "removeView() called with: view = [" + view + "]");
        super.removeView(view);
    }

    public void setAutoRefreshing(boolean z) {
        this.G = z;
        e();
        this.I = true;
        this.x.a(RefreshHeader.RefreshState.REFRESHING);
        a(this.e, new Animator.AnimatorListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TriverSwipeRefreshLayout.this.ak.onAnimationEnd(animator);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TriverSwipeRefreshLayout.this.setRefreshing(false);
                    }
                }, TriverSwipeRefreshLayout.this.V);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void setAutoRefreshingDuration(long j) {
        if (j > 0) {
            this.V = j;
        }
    }

    public void setCurrentTargetOffsetTop(int i) {
        this.e = i;
    }

    public void setDistanceToRefresh(int i) {
        float f = i;
        float f2 = this.j;
        if (((int) (f * f2)) < this.c) {
            return;
        }
        int i2 = (int) (f * f2);
        this.O = i2;
        if (this.P - i2 < f2 * 20.0f) {
            this.P = (int) (i2 + (f2 * 20.0f));
        }
    }

    public void setDistanceToSecondFloor(int i) {
        float f = i;
        float f2 = this.j;
        if (((int) (f * f2)) - this.O < 20.0f * f2) {
            RVLogger.e(l, "Distance to second floor must be more than 50dp longer than distance to refresh");
        } else {
            this.P = (int) (f * f2);
        }
    }

    public void setDragRate(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            RVLogger.e(l, "Drag rate must be larger than 0 and smaller than 1!");
        } else {
            this.N = f;
        }
    }

    public void setFooterView(LoadMoreFooter loadMoreFooter) {
        if (loadMoreFooter != null) {
            int iIndexOfChild = indexOfChild(this.y);
            LoadMoreFooter loadMoreFooter2 = this.y;
            if (loadMoreFooter2 != null && iIndexOfChild != -1) {
                removeView(loadMoreFooter2);
            }
            this.y = loadMoreFooter;
            loadMoreFooter.setPushLoadMoreListener(this.C);
            addView(this.y, iIndexOfChild, new ViewGroup.LayoutParams(-1, this.d));
        }
    }

    public void setFooterViewHeight(int i) {
        float f = i;
        float f2 = this.j;
        if (((int) (f * f2)) > this.T) {
            this.T = (int) (f * f2);
        }
        this.d = (int) (f * f2);
    }

    public void setHeaderView(RefreshHeader refreshHeader) {
        if (refreshHeader != null) {
            int iIndexOfChild = indexOfChild(this.x);
            RefreshHeader refreshHeader2 = this.x;
            if (refreshHeader2 != null && iIndexOfChild != -1) {
                removeView(refreshHeader2);
            }
            this.x = refreshHeader;
            refreshHeader.setPullRefreshListener(this.B);
            addView(this.x, iIndexOfChild, new ViewGroup.LayoutParams(-1, this.c));
        }
    }

    public void setHeaderViewHeight(int i) {
        float f = i;
        float f2 = this.j;
        if (((int) (f * f2)) < this.i) {
            RVLogger.d(l, "HeaderView height cannot be smaller than refresh offset.");
            return;
        }
        int i2 = (int) (f * f2);
        this.c = i2;
        if (this.O < i2) {
            this.O = i2;
        }
        int i3 = this.P;
        int i4 = this.O;
        if (i3 < i4) {
            this.P = (int) (i4 + (f2 * 20.0f));
        }
    }

    public void setLoadMore(boolean z) {
        if (z || !this.J) {
            return;
        }
        a(this.d, 0);
    }

    public void setMaxPushDistance(int i) {
        float f = i;
        float f2 = this.j;
        if (((int) (f * f2)) < this.d) {
            RVLogger.e(l, "Max push distance must be larger than footer view height!");
        } else {
            this.T = (int) (f * f2);
        }
    }

    public void setOnPullRefreshListener(a aVar) {
        this.B = aVar;
        RefreshHeader refreshHeader = this.x;
        if (refreshHeader != null) {
            refreshHeader.setPullRefreshListener(aVar);
        }
    }

    public void setOnPushLoadMoreListener(b bVar) {
        this.C = bVar;
        LoadMoreFooter loadMoreFooter = this.y;
        if (loadMoreFooter != null) {
            loadMoreFooter.setPushLoadMoreListener(bVar);
        }
    }

    public void setPullRefreshDistance(int i) {
        this.al = (int) (i * this.j);
    }

    public void setReachDistanceRefreshListener(c cVar) {
        this.am = cVar;
    }

    public void setRefreshOffset(int i) {
        int i2 = this.c;
        float f = i;
        float f2 = this.j;
        if (i2 < ((int) (f * f2))) {
            RVLogger.e(l, "Refresh offset cannot be larger than header view height.");
        } else {
            this.i = (int) (f * f2);
        }
    }

    public void setRefreshing(boolean z) {
        if (!z || this.I == z) {
            b(z, false);
            return;
        }
        this.I = z;
        a((this.c + this.h) - this.e);
        this.G = false;
        a(this.ak);
    }

    public void setTargetScrollWithLayout(boolean z) {
        this.H = z;
    }

    public TriverSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = -1;
        this.A = -1;
        this.H = true;
        this.L = -1;
        this.N = 1.0f;
        this.O = -1;
        this.P = -1;
        this.R = true;
        this.S = 0;
        this.V = 2000L;
        this.W = false;
        this.ae = 0;
        this.af = 0;
        this.ag = -1;
        this.ah = 0;
        this.ai = -1;
        this.aj = new ArrayList();
        this.ak = new Animator.AnimatorListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TriverSwipeRefreshLayout.this.I) {
                    if (TriverSwipeRefreshLayout.this.G) {
                        if (TriverSwipeRefreshLayout.this.B != null) {
                            TriverSwipeRefreshLayout.this.B.a();
                        }
                        if (TriverSwipeRefreshLayout.this.am != null) {
                            TriverSwipeRefreshLayout.this.am.c();
                        }
                    }
                    TriverSwipeRefreshLayout.this.x.a(RefreshHeader.RefreshState.REFRESHING);
                } else {
                    TriverSwipeRefreshLayout triverSwipeRefreshLayout = TriverSwipeRefreshLayout.this;
                    triverSwipeRefreshLayout.a(triverSwipeRefreshLayout.h - triverSwipeRefreshLayout.e);
                }
                TriverSwipeRefreshLayout triverSwipeRefreshLayout2 = TriverSwipeRefreshLayout.this;
                triverSwipeRefreshLayout2.e = triverSwipeRefreshLayout2.x.getTop();
                TriverSwipeRefreshLayout.this.g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        };
        this.al = 0;
        setWillNotDraw(false);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.k = displayMetrics;
        float f = displayMetrics.density;
        this.j = f;
        this.D = false;
        this.E = false;
        this.F = false;
        int i = displayMetrics.widthPixels;
        this.f25248a = i;
        this.c = (int) (f * 72.0f);
        this.b = i;
        this.d = (int) (f * 50.0f);
        this.U = new DecelerateInterpolator(2.0f);
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        c();
        d();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.i = 0;
        float f2 = this.j;
        int i2 = (int) (72.0f * f2);
        this.O = i2;
        this.P = (int) (i2 + (20.0f * f2));
        this.T = (int) (f2 * 100.0f);
        this.ai = this.k.heightPixels;
    }

    private boolean b(MotionEvent motionEvent, int i) {
        int i2;
        c cVar;
        if (i != 1) {
            if (i == 2) {
                if (this.L == -1) {
                    this.L = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    this.aa = motionEvent.getY();
                    this.ag = this.L;
                }
                try {
                    int y = (int) MotionEventCompat.getY(motionEvent, d(motionEvent, this.L));
                    if (this.W) {
                        int i3 = this.ag;
                        int i4 = this.L;
                        if (i3 == i4) {
                            float f = this.ac;
                            float f2 = y;
                            float f3 = this.aa;
                            i2 = (int) (f + (f2 - f3));
                            int i5 = (int) (this.ae + (f2 - f3));
                            this.ad = i2;
                            this.af = i5;
                        } else {
                            int i6 = this.ad;
                            int i7 = (int) (i6 + (y - this.aa));
                            int i8 = this.af;
                            this.ag = i4;
                            this.ac = i6;
                            this.ae = i8;
                            i2 = i7;
                        }
                    } else {
                        i2 = y - this.ab;
                        this.ac = i2;
                        this.ad = i2;
                        this.ae = y;
                        this.af = y;
                    }
                    if (this.K) {
                        int i9 = (int) (i2 * this.N);
                        int measuredHeight = this.w.getMeasuredHeight();
                        double dAbs = ((((double) (measuredHeight - Math.abs(this.w.getY()))) / 1.0d) / ((double) measuredHeight)) * 0.4000000059604645d;
                        if (dAbs <= 0.01d) {
                            dAbs = 0.01d;
                        }
                        int iMin = Math.min(this.k.heightPixels, (int) (((double) i9) * dAbs));
                        if (iMin >= this.al && (cVar = this.am) != null) {
                            cVar.a();
                        }
                        float f4 = (iMin * 1.0f) / this.O;
                        if (f4 < 0.0f) {
                            return false;
                        }
                        float fMin = Math.min(1.0f, Math.abs(f4));
                        if (iMin < this.O) {
                            this.x.a(RefreshHeader.RefreshState.PULL_TO_REFRESH);
                        } else if (!this.F || iMin <= this.P) {
                            this.x.a(RefreshHeader.RefreshState.RELEASE_TO_REFRESH);
                        } else {
                            this.x.a(RefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR);
                        }
                        this.x.setProgress(fMin);
                        a(iMin - (this.e - this.h));
                    }
                } catch (IllegalArgumentException e) {
                    RVLogger.w(Log.getStackTraceString(e));
                }
            } else if (i != 3) {
                if (i == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.aa = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.L = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.W = true;
                } else if (i == 6) {
                    c(motionEvent);
                }
            }
            return true;
        }
        c cVar2 = this.am;
        if (cVar2 != null) {
            cVar2.b();
        }
        if (this.L == -1) {
            if (i == 1) {
                RVLogger.e(l, "Got ACTION_UP event but don't have an active pointer id.");
            }
            return false;
        }
        this.K = false;
        if (this.x.getCurrentState() == RefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR && this.F) {
            this.x.a(RefreshHeader.RefreshState.SECOND_FLOOR_START);
            c(this.e, new Animator.AnimatorListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TriverSwipeRefreshLayout.this.x.a(RefreshHeader.RefreshState.SECOND_FLOOR_END);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        } else if (this.x.getCurrentState() == RefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            b(true, true);
        } else {
            this.I = false;
            this.x.a(RefreshHeader.RefreshState.NONE);
            b(this.e, (Animator.AnimatorListener) null);
        }
        this.L = -1;
        this.W = false;
        this.ac = 0;
        this.ae = 0;
        return false;
    }

    private void c() {
        e eVar = new e(getContext());
        this.x = eVar;
        a aVar = this.B;
        if (aVar != null) {
            eVar.setPullRefreshListener(aVar);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(this.x, layoutParams);
    }

    private void d() {
        com.alibaba.triver.triver_render.view.refresh.c cVar = new com.alibaba.triver.triver_render.view.refresh.c(getContext());
        this.y = cVar;
        b bVar = this.C;
        if (bVar != null) {
            cVar.setPushLoadMoreListener(bVar);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.d);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        addView(this.y, layoutParams);
    }

    private void e() {
        if (this.w == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.x) && !childAt.equals(this.y)) {
                    this.w = childAt;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.y.setVisibility(0);
        this.y.bringToFront();
        this.y.offsetTopAndBottom(-this.S);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i = this.e - this.h;
        a aVar = this.B;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private void h() {
        b bVar = this.C;
        if (bVar != null) {
            bVar.a(this.S);
        }
    }

    private float a(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (iFindPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, iFindPointerIndex);
    }

    public boolean a(MotionEvent motionEvent) {
        return !a(this.w, motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(View view, MotionEvent motionEvent) {
        if (view instanceof WebView) {
            return view.getScrollY() != 0;
        }
        if (view instanceof com.uc.webview.export.WebView) {
            com.uc.webview.export.WebView webView = (com.uc.webview.export.WebView) view;
            if (webView.isDestroied()) {
                return true;
            }
            if (!(view instanceof WMLTRWebView)) {
                return webView.getCoreView().getScrollY() != 0;
            }
            boolean z = webView.getCoreView().getScrollY() != 0;
            return z ? z : !((WMLTRWebView) view).d;
        }
        if (!(view instanceof ViewGroup)) {
            return ViewCompat.canScrollVertically(view, -1);
        }
        int i = 0;
        boolean z2 = false;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                break;
            }
            z2 = z2 || a(viewGroup.getChildAt(i), motionEvent);
            if (z2) {
                break;
            }
            i++;
        }
        return z2;
    }

    private boolean c(MotionEvent motionEvent, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.L);
                    if (iFindPointerIndex < 0) {
                        RVLogger.e(l, "Got ACTION_MOVE event but have an invalid active pointer id. " + this.L);
                        return false;
                    }
                    float y = (this.Q - MotionEventCompat.getY(motionEvent, iFindPointerIndex)) * this.N;
                    if (this.K) {
                        this.S = Math.min((int) y, this.T);
                        f();
                        if (this.C != null) {
                            if (this.S >= this.d) {
                                this.y.a(LoadMoreFooter.LoadMoreState.RELEASE_TO_LOAD);
                            } else {
                                this.y.a(LoadMoreFooter.LoadMoreState.PUSH_TO_LOAD);
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 5) {
                        this.L = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (i == 6) {
                        c(motionEvent);
                    }
                }
            }
            int i2 = this.L;
            if (i2 == -1) {
                if (i == 1) {
                    RVLogger.e(l, "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            int iFindPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            float fMin = Math.min((this.Q - MotionEventCompat.getY(motionEvent, iFindPointerIndex2)) * this.N, this.T);
            this.K = false;
            this.L = -1;
            int i3 = this.d;
            if (fMin >= i3 && this.C != null) {
                this.S = i3;
            } else {
                this.S = 0;
            }
            a((int) fMin, this.S);
            return false;
        }
        this.L = MotionEventCompat.getPointerId(motionEvent, 0);
        this.K = false;
        return true;
    }

    public void d(boolean z) {
        this.R = z;
    }

    private int d(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (iFindPointerIndex == -1) {
            this.L = -1;
        }
        return iFindPointerIndex;
    }

    public void a(boolean z, boolean z2) {
        if (z && this.I != z) {
            this.I = z;
            a((this.c + this.h) - this.e);
            this.G = z2;
            a(this.ak);
            return;
        }
        b(z, false);
    }

    private void a(Animator.AnimatorListener animatorListener) {
        this.x.setVisibility(0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(getResources().getInteger(R.integer.config_mediumAnimTime));
        if (animatorListener != null) {
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.start();
    }

    public boolean a() {
        return getRefresHeader().getCurrentState() != RefreshHeader.RefreshState.NONE;
    }

    @TargetApi(11)
    private void a(int i, final int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(150L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TriverSwipeRefreshLayout.this.S = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                TriverSwipeRefreshLayout.this.f();
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i2 <= 0 || TriverSwipeRefreshLayout.this.C == null) {
                    TriverSwipeRefreshLayout.this.J = false;
                    TriverSwipeRefreshLayout.this.y.a(LoadMoreFooter.LoadMoreState.NONE);
                } else {
                    TriverSwipeRefreshLayout.this.J = true;
                    TriverSwipeRefreshLayout.this.y.a(LoadMoreFooter.LoadMoreState.LOADING);
                    TriverSwipeRefreshLayout.this.C.a();
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(this.U);
        valueAnimatorOfInt.start();
    }

    private void c(int i, Animator.AnimatorListener animatorListener) {
        this.f = i;
        new ValueAnimator();
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f, 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TriverSwipeRefreshLayout.this.a(((Integer) valueAnimatorOfInt.getAnimatedValue()).intValue() - TriverSwipeRefreshLayout.this.x.getTop());
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(this.U);
        if (animatorListener != null) {
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.start();
    }

    private void a(int i, Animator.AnimatorListener animatorListener) {
        int iAbs;
        int iAbs2;
        this.f = i;
        if (this.R) {
            iAbs = this.c - Math.abs(this.h);
            iAbs2 = this.i;
        } else {
            iAbs = this.c;
            iAbs2 = Math.abs(this.h);
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f, iAbs - iAbs2);
        if (animatorListener != null) {
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TriverSwipeRefreshLayout.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue() - TriverSwipeRefreshLayout.this.x.getTop());
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(this.U);
        valueAnimatorOfInt.start();
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.L) {
            int i = actionIndex == 0 ? 1 : 0;
            this.aa = MotionEventCompat.getY(motionEvent, i);
            this.L = MotionEventCompat.getPointerId(motionEvent, i);
        }
        int iD = d(motionEvent, this.L);
        if (this.L == -1) {
            return;
        }
        this.aa = MotionEventCompat.getY(motionEvent, iD);
    }

    public void a(int i) {
        this.x.bringToFront();
        this.x.offsetTopAndBottom(i);
        this.w.offsetTopAndBottom(i);
        this.e = this.x.getTop();
        g();
    }

    public void c(boolean z) {
        this.F = z;
    }

    public void a(boolean z) {
        this.D = z;
    }

    public boolean b(MotionEvent motionEvent) {
        int lastVisiblePosition;
        if (a(motionEvent)) {
            return false;
        }
        View view = this.w;
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int itemCount = recyclerView.getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] iArr = new int[2];
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(iArr);
                if (Math.max(iArr[0], iArr[1]) == itemCount - 1) {
                    return true;
                }
            }
            return false;
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            int count = ((ListAdapter) absListView.getAdapter()).getCount();
            return (absListView.getFirstVisiblePosition() != 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) && (lastVisiblePosition = absListView.getLastVisiblePosition()) > 0 && count > 0 && lastVisiblePosition == count - 1;
        }
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            View childAt = scrollView.getChildAt(scrollView.getChildCount() - 1);
            if (childAt != null && childAt.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()) == 0) {
                return true;
            }
        } else if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            View childAt2 = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
            if (childAt2 != null && childAt2.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()) == 0) {
                return true;
            }
        }
        return false;
    }

    private void b(boolean z, boolean z2) {
        if (this.I != z) {
            this.G = z2;
            e();
            this.I = z;
            if (z) {
                this.x.a(RefreshHeader.RefreshState.REFRESHING);
                a(this.e, this.ak);
                return;
            } else {
                this.x.a(RefreshHeader.RefreshState.NONE);
                b(this.e, this.ak);
                return;
            }
        }
        if (this.x.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_END) {
            this.I = false;
            this.x.a(RefreshHeader.RefreshState.NONE);
            b(this.e, this.ak);
        } else if (z) {
            this.G = z2;
            e();
            this.I = z;
            if (z) {
                this.x.a(RefreshHeader.RefreshState.REFRESHING);
                a(this.e, this.ak);
            } else {
                this.x.a(RefreshHeader.RefreshState.NONE);
                b(this.e, this.ak);
            }
        }
    }

    private void b(int i, Animator.AnimatorListener animatorListener) {
        this.f = i;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, this.h);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RefreshHeader refreshHeader = TriverSwipeRefreshLayout.this.x;
                TriverSwipeRefreshLayout triverSwipeRefreshLayout = TriverSwipeRefreshLayout.this;
                int i2 = triverSwipeRefreshLayout.f;
                refreshHeader.setProgress((iIntValue - i2) / ((triverSwipeRefreshLayout.h - i2) * 1.0f));
                TriverSwipeRefreshLayout triverSwipeRefreshLayout2 = TriverSwipeRefreshLayout.this;
                triverSwipeRefreshLayout2.a(iIntValue - triverSwipeRefreshLayout2.x.getTop());
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(this.U);
        if (animatorListener != null) {
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.start();
    }

    public boolean b() {
        return this.H;
    }

    public void b(boolean z) {
        this.E = z;
    }
}
