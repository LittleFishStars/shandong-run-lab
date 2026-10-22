package com.flyco.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.zj.adlib.ll3;
import com.zj.adlib.zg9;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SegmentTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
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
    public int U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f1787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f1789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f1790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GradientDrawable f1791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<Boolean> f1792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OvershootInterpolator f1793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f1794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f1795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTabSelectListener f1796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ll3 f1797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f1799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f1800a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f1801b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public GradientDrawable f1802b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public b f1803b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1804b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1805c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1806d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1807e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            if (SegmentTabLayout.this.K == iIntValue) {
                if (SegmentTabLayout.this.f1796a != null) {
                    SegmentTabLayout.this.f1796a.a(iIntValue);
                }
            } else {
                SegmentTabLayout.this.setCurrentTab(iIntValue);
                if (SegmentTabLayout.this.f1796a != null) {
                    SegmentTabLayout.this.f1796a.b(iIntValue);
                }
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30224a;
        public float b;

        public b() {
        }
    }

    public class c implements TypeEvaluator<b> {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b evaluate(float f, b bVar, b bVar2) {
            float f2 = bVar.f30224a;
            float f3 = f2 + ((bVar2.f30224a - f2) * f);
            float f4 = bVar.b;
            float f5 = f4 + (f * (bVar2.b - f4));
            b bVar3 = SegmentTabLayout.this.new b();
            bVar3.f30224a = f3;
            bVar3.b = f5;
            return bVar3;
        }
    }

    public SegmentTabLayout(Context context) {
        this(context, null, 0);
    }

    public final void c(int i, View view) {
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.f1800a[i]);
        view.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = this.f1798a ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.b > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.b, -1);
        }
        this.f1794a.addView(view, i, layoutParams);
    }

    public final void d() {
        View childAt = this.f1794a.getChildAt(this.K);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.f1790a;
        rect.left = (int) left;
        rect.right = (int) right;
        if (this.f1804b) {
            float[] fArr = this.f1799a;
            float f = this.d;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = f;
            fArr[3] = f;
            fArr[4] = f;
            fArr[5] = f;
            fArr[6] = f;
            fArr[7] = f;
            return;
        }
        int i = this.K;
        if (i == 0) {
            float[] fArr2 = this.f1799a;
            float f2 = this.d;
            fArr2[0] = f2;
            fArr2[1] = f2;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            fArr2[5] = 0.0f;
            fArr2[6] = f2;
            fArr2[7] = f2;
            return;
        }
        if (i != this.M - 1) {
            float[] fArr3 = this.f1799a;
            fArr3[0] = 0.0f;
            fArr3[1] = 0.0f;
            fArr3[2] = 0.0f;
            fArr3[3] = 0.0f;
            fArr3[4] = 0.0f;
            fArr3[5] = 0.0f;
            fArr3[6] = 0.0f;
            fArr3[7] = 0.0f;
            return;
        }
        float[] fArr4 = this.f1799a;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        float f3 = this.d;
        fArr4[2] = f3;
        fArr4[3] = f3;
        fArr4[4] = f3;
        fArr4[5] = f3;
        fArr4[6] = 0.0f;
        fArr4[7] = 0.0f;
    }

    public int dp2px(float f) {
        return (int) ((f * this.f1788a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void e() {
        View childAt = this.f1794a.getChildAt(this.K);
        this.f1795a.f30224a = childAt.getLeft();
        this.f1795a.b = childAt.getRight();
        View childAt2 = this.f1794a.getChildAt(this.L);
        this.f1803b.f30224a = childAt2.getLeft();
        this.f1803b.b = childAt2.getRight();
        b bVar = this.f1803b;
        float f = bVar.f30224a;
        b bVar2 = this.f1795a;
        if (f == bVar2.f30224a && bVar.b == bVar2.b) {
            invalidate();
            return;
        }
        this.f1787a.setObjectValues(bVar, bVar2);
        if (this.f1805c) {
            this.f1787a.setInterpolator(this.f1793a);
        }
        if (this.f1786a < 0) {
            this.f1786a = this.f1805c ? 500L : 250L;
        }
        this.f1787a.setDuration(this.f1786a);
        this.f1787a.start();
    }

    public final void f(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentTabLayout);
        this.N = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_indicator_color, Color.parseColor("#222831"));
        this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_height, -1.0f);
        this.d = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_corner_radius, -1.0f);
        this.e = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_left, dp2px(0.0f));
        this.f = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_top, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_right, dp2px(0.0f));
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_bottom, 0.0f);
        this.f1804b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_anim_enable, false);
        this.f1805c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_bounce_enable, true);
        this.f1786a = typedArrayObtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_indicator_anim_duration, -1);
        this.O = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_divider_color, this.N);
        this.i = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_width, dp2px(1.0f));
        this.j = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_padding, 0.0f);
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_textsize, sp2px(13.0f));
        this.P = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.Q = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textUnselectColor, this.N);
        this.R = typedArrayObtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_textBold, 0);
        this.f1806d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_textAllCaps, false);
        this.f1798a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_tab_space_equal, true);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_tab_width, dp2px(-1.0f));
        this.b = dimension;
        this.f30222a = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_tab_padding, (this.f1798a || dimension > 0.0f) ? dp2px(0.0f) : dp2px(10.0f));
        this.S = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_color, 0);
        this.T = typedArrayObtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_stroke_color, this.N);
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_bar_stroke_width, dp2px(1.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g(int i) {
        int i2 = 0;
        while (i2 < this.M) {
            View childAt = this.f1794a.getChildAt(i2);
            boolean z = i2 == i;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(z ? this.P : this.Q);
            if (this.R == 1) {
                textView.getPaint().setFakeBoldText(z);
            }
            i2++;
        }
    }

    public int getCurrentTab() {
        return this.K;
    }

    public int getDividerColor() {
        return this.O;
    }

    public float getDividerPadding() {
        return this.j;
    }

    public float getDividerWidth() {
        return this.i;
    }

    public long getIndicatorAnimDuration() {
        return this.f1786a;
    }

    public int getIndicatorColor() {
        return this.N;
    }

    public float getIndicatorCornerRadius() {
        return this.d;
    }

    public float getIndicatorHeight() {
        return this.c;
    }

    public float getIndicatorMarginBottom() {
        return this.h;
    }

    public float getIndicatorMarginLeft() {
        return this.e;
    }

    public float getIndicatorMarginRight() {
        return this.g;
    }

    public float getIndicatorMarginTop() {
        return this.f;
    }

    public MsgView getMsgView(int i) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        return (MsgView) this.f1794a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
    }

    public int getTabCount() {
        return this.M;
    }

    public float getTabPadding() {
        return this.f30222a;
    }

    public float getTabWidth() {
        return this.b;
    }

    public int getTextBold() {
        return this.R;
    }

    public int getTextSelectColor() {
        return this.P;
    }

    public int getTextUnselectColor() {
        return this.Q;
    }

    public float getTextsize() {
        return this.k;
    }

    public TextView getTitleView(int i) {
        return (TextView) this.f1794a.getChildAt(i).findViewById(R.id.tv_tab_title);
    }

    public final void h() {
        int i = 0;
        while (i < this.M) {
            View childAt = this.f1794a.getChildAt(i);
            float f = this.f30222a;
            childAt.setPadding((int) f, 0, (int) f, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(i == this.K ? this.P : this.Q);
            textView.setTextSize(0, this.k);
            if (this.f1806d) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i2 = this.R;
            if (i2 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i2 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            i++;
        }
    }

    public void hideMsg(int i) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        MsgView msgView = (MsgView) this.f1794a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public boolean isIndicatorAnimEnable() {
        return this.f1804b;
    }

    public boolean isIndicatorBounceEnable() {
        return this.f1805c;
    }

    public boolean isTabSpaceEqual() {
        return this.f1798a;
    }

    public boolean isTextAllCaps() {
        return this.f1806d;
    }

    public void notifyDataSetChanged() {
        this.f1794a.removeAllViews();
        this.M = this.f1800a.length;
        for (int i = 0; i < this.M; i++) {
            View viewInflate = View.inflate(this.f1788a, R.layout.layout_tab_segment, null);
            viewInflate.setTag(Integer.valueOf(i));
            c(i, viewInflate);
        }
        h();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.f1790a;
        rect.left = (int) bVar.f30224a;
        rect.right = (int) bVar.b;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.M <= 0) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        if (this.c < 0.0f) {
            this.c = (height - this.f) - this.h;
        }
        float f = this.d;
        if (f < 0.0f || f > this.c / 2.0f) {
            this.d = this.c / 2.0f;
        }
        this.f1802b.setColor(this.S);
        this.f1802b.setCornerRadius(this.d);
        this.f1802b.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f1802b.draw(canvas);
        if (!this.f1804b) {
            float f2 = this.i;
            if (f2 > 0.0f) {
                this.f1789a.setStrokeWidth(f2);
                this.f1789a.setColor(this.O);
                for (int i = 0; i < this.M - 1; i++) {
                    View childAt = this.f1794a.getChildAt(i);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.j, childAt.getRight() + paddingLeft, height - this.j, this.f1789a);
                }
            }
        }
        if (!this.f1804b) {
            d();
        } else if (this.f1807e) {
            this.f1807e = false;
            d();
        }
        this.f1791a.setColor(this.N);
        GradientDrawable gradientDrawable = this.f1791a;
        int i2 = ((int) this.e) + paddingLeft;
        Rect rect = this.f1790a;
        int i3 = i2 + rect.left;
        float f3 = this.f;
        gradientDrawable.setBounds(i3, (int) f3, (int) ((paddingLeft + rect.right) - this.g), (int) (f3 + this.c));
        this.f1791a.setCornerRadii(this.f1799a);
        this.f1791a.draw(canvas);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.K = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.K != 0 && this.f1794a.getChildCount() > 0) {
                g(this.K);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.K);
        return bundle;
    }

    public void setCurrentTab(int i) {
        this.L = this.K;
        this.K = i;
        g(i);
        ll3 ll3Var = this.f1797a;
        if (ll3Var != null) {
            ll3Var.d(i);
        }
        if (this.f1804b) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        this.O = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.j = dp2px(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.i = dp2px(f);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j) {
        this.f1786a = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.f1804b = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.f1805c = z;
    }

    public void setIndicatorColor(int i) {
        this.N = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.d = dp2px(f);
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.c = dp2px(f);
        invalidate();
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        this.e = dp2px(f);
        this.f = dp2px(f2);
        this.g = dp2px(f3);
        this.h = dp2px(f4);
        invalidate();
    }

    public void setMsgMargin(int i, float f, float f2) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        View childAt = this.f1794a.getChildAt(i);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.f1801b.setTextSize(this.k);
            this.f1801b.measureText(textView.getText().toString());
            float fDescent = this.f1801b.descent() - this.f1801b.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            marginLayoutParams.leftMargin = dp2px(f);
            int i3 = this.U;
            marginLayoutParams.topMargin = i3 > 0 ? (((int) (i3 - fDescent)) / 2) - dp2px(f2) : dp2px(f2);
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.f1796a = onTabSelectListener;
    }

    public void setTabData(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be NULL or EMPTY !");
        }
        this.f1800a = strArr;
        notifyDataSetChanged();
    }

    public void setTabPadding(float f) {
        this.f30222a = dp2px(f);
        h();
    }

    public void setTabSpaceEqual(boolean z) {
        this.f1798a = z;
        h();
    }

    public void setTabWidth(float f) {
        this.b = dp2px(f);
        h();
    }

    public void setTextAllCaps(boolean z) {
        this.f1806d = z;
        h();
    }

    public void setTextBold(int i) {
        this.R = i;
        h();
    }

    public void setTextSelectColor(int i) {
        this.P = i;
        h();
    }

    public void setTextUnselectColor(int i) {
        this.Q = i;
        h();
    }

    public void setTextsize(float f) {
        this.k = sp2px(f);
        h();
    }

    public void showDot(int i) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        showMsg(i, 0);
    }

    public void showMsg(int i, int i2) {
        int i3 = this.M;
        if (i >= i3) {
            i = i3 - 1;
        }
        MsgView msgView = (MsgView) this.f1794a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            zg9.b(msgView, i2);
            if (this.f1792a.get(i) == null || !this.f1792a.get(i).booleanValue()) {
                setMsgMargin(i, 2.0f, 2.0f);
                this.f1792a.put(i, Boolean.TRUE);
            }
        }
    }

    public int sp2px(float f) {
        return (int) ((f * this.f1788a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1790a = new Rect();
        this.f1791a = new GradientDrawable();
        this.f1802b = new GradientDrawable();
        this.f1789a = new Paint(1);
        this.f1793a = new OvershootInterpolator(0.8f);
        this.f1799a = new float[8];
        this.f1807e = true;
        this.f1801b = new Paint(1);
        this.f1792a = new SparseArray<>();
        this.f1795a = new b();
        this.f1803b = new b();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f1788a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f1794a = linearLayout;
        addView(linearLayout);
        f(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
            this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -2);
            typedArrayObtainStyledAttributes.recycle();
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new c(), this.f1803b, this.f1795a);
        this.f1787a = valueAnimatorOfObject;
        valueAnimatorOfObject.addUpdateListener(this);
    }

    public void setTabData(String[] strArr, FragmentActivity fragmentActivity, int i, ArrayList<Fragment> arrayList) {
        this.f1797a = new ll3(fragmentActivity.getSupportFragmentManager(), i, arrayList);
        setTabData(strArr);
    }
}
