package com.flyco.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.zj.adlib.ll3;
import com.zj.adlib.zg9;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    public static final int Z = 0;
    public static final int a0 = 1;
    public static final int b0 = 2;
    public static final int c0 = 0;
    public static final int d0 = 1;
    public static final int e0 = 2;
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
    public int V;
    public int W;
    public int X;
    public int Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueAnimator f1762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f1764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f1765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f1767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<Boolean> f1768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OvershootInterpolator f1769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinearLayout f1770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f1771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTabSelectListener f1772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ll3 f1773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<CustomTabEntity> f1774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1775a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f1776b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final b f1777b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1778b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f1779c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1780c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Paint f1781d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1782d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1783e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f1784f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            if (CommonTabLayout.this.K == iIntValue) {
                if (CommonTabLayout.this.f1772a != null) {
                    CommonTabLayout.this.f1772a.a(iIntValue);
                }
            } else {
                CommonTabLayout.this.setCurrentTab(iIntValue);
                if (CommonTabLayout.this.f1772a != null) {
                    CommonTabLayout.this.f1772a.b(iIntValue);
                }
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30217a;
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
            float f2 = bVar.f30217a;
            float f3 = f2 + ((bVar2.f30217a - f2) * f);
            float f4 = bVar.b;
            float f5 = f4 + (f * (bVar2.b - f4));
            b bVar3 = CommonTabLayout.this.new b();
            bVar3.f30217a = f3;
            bVar3.b = f5;
            return bVar3;
        }
    }

    public CommonTabLayout(Context context) {
        this(context, null, 0);
    }

    public final void c(int i, View view) {
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.f1774a.get(i).getTitle());
        ((ImageView) view.findViewById(R.id.iv_tab_icon)).setImageResource(this.f1774a.get(i).getTabUnselectedIcon());
        view.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = this.f1775a ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.b > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.b, -1);
        }
        this.f1770a.addView(view, i, layoutParams);
    }

    public final void d() {
        View childAt = this.f1770a.getChildAt(this.K);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.f1766a;
        rect.left = (int) left;
        rect.right = (int) right;
        if (this.d < 0.0f) {
            return;
        }
        float left2 = childAt.getLeft();
        float width = childAt.getWidth();
        float f = this.d;
        float f2 = left2 + ((width - f) / 2.0f);
        Rect rect2 = this.f1766a;
        int i = (int) f2;
        rect2.left = i;
        rect2.right = (int) (i + f);
    }

    public int dp2px(float f) {
        return (int) ((f * this.f1763a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void e() {
        View childAt = this.f1770a.getChildAt(this.K);
        this.f1771a.f30217a = childAt.getLeft();
        this.f1771a.b = childAt.getRight();
        View childAt2 = this.f1770a.getChildAt(this.L);
        this.f1777b.f30217a = childAt2.getLeft();
        this.f1777b.b = childAt2.getRight();
        b bVar = this.f1777b;
        float f = bVar.f30217a;
        b bVar2 = this.f1771a;
        if (f == bVar2.f30217a && bVar.b == bVar2.b) {
            invalidate();
            return;
        }
        this.f1762a.setObjectValues(bVar, bVar2);
        if (this.f1780c) {
            this.f1762a.setInterpolator(this.f1769a);
        }
        if (this.f1761a < 0) {
            this.f1761a = this.f1780c ? 500L : 250L;
        }
        this.f1762a.setDuration(this.f1761a);
        this.f1762a.start();
    }

    public final void f(Context context, AttributeSet attributeSet) {
        float f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTabLayout);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_style, 0);
        this.N = i;
        this.P = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_indicator_color, Color.parseColor(i == 2 ? "#4B6A87" : "#ffffff"));
        int i2 = R.styleable.CommonTabLayout_tl_indicator_height;
        int i3 = this.N;
        if (i3 == 1) {
            f = 4.0f;
        } else {
            f = i3 == 2 ? -1 : 2;
        }
        this.c = typedArrayObtainStyledAttributes.getDimension(i2, dp2px(f));
        this.d = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_width, dp2px(this.N == 1 ? 10.0f : -1.0f));
        this.e = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_corner_radius, dp2px(this.N == 2 ? -1.0f : 0.0f));
        this.f = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_left, dp2px(0.0f));
        this.g = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_top, dp2px(this.N == 2 ? 7.0f : 0.0f));
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_right, dp2px(0.0f));
        this.i = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_bottom, dp2px(this.N != 2 ? 0.0f : 7.0f));
        this.f1778b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_anim_enable, true);
        this.f1780c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_bounce_enable, true);
        this.f1761a = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_anim_duration, -1);
        this.Q = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_gravity, 80);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CommonTabLayout_tl_indicator_resources, 0);
        this.R = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.j = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_underline_height, dp2px(0.0f));
        this.S = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_underline_gravity, 80);
        this.T = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_width, dp2px(0.0f));
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_padding, dp2px(12.0f));
        this.m = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_textsize, sp2px(13.0f));
        this.U = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.V = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.W = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_textBold, 0);
        this.f1782d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_textAllCaps, false);
        this.f1783e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_iconVisible, true);
        this.X = typedArrayObtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_iconGravity, 48);
        this.n = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconWidth, dp2px(0.0f));
        this.o = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconHeight, dp2px(0.0f));
        this.p = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconMargin, dp2px(2.5f));
        this.f1775a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_tab_space_equal, true);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_tab_width, dp2px(-1.0f));
        this.b = dimension;
        this.f30215a = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_tab_padding, (this.f1775a || dimension > 0.0f) ? dp2px(0.0f) : dp2px(10.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g(int i) {
        int i2 = 0;
        while (i2 < this.M) {
            View childAt = this.f1770a.getChildAt(i2);
            boolean z = i2 == i;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(z ? this.U : this.V);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            CustomTabEntity customTabEntity = this.f1774a.get(i2);
            imageView.setImageResource(z ? customTabEntity.getTabSelectedIcon() : customTabEntity.getTabUnselectedIcon());
            if (this.W == 1) {
                textView.getPaint().setFakeBoldText(z);
            }
            i2++;
        }
    }

    public int getCurrentTab() {
        return this.K;
    }

    public int getDividerColor() {
        return this.T;
    }

    public float getDividerPadding() {
        return this.l;
    }

    public float getDividerWidth() {
        return this.k;
    }

    public int getIconGravity() {
        return this.X;
    }

    public float getIconHeight() {
        return this.o;
    }

    public float getIconMargin() {
        return this.p;
    }

    public ImageView getIconView(int i) {
        return (ImageView) this.f1770a.getChildAt(i).findViewById(R.id.iv_tab_icon);
    }

    public float getIconWidth() {
        return this.n;
    }

    public long getIndicatorAnimDuration() {
        return this.f1761a;
    }

    public int getIndicatorColor() {
        return this.P;
    }

    public float getIndicatorCornerRadius() {
        return this.e;
    }

    public float getIndicatorHeight() {
        return this.c;
    }

    public float getIndicatorMarginBottom() {
        return this.i;
    }

    public float getIndicatorMarginLeft() {
        return this.f;
    }

    public float getIndicatorMarginRight() {
        return this.h;
    }

    public float getIndicatorMarginTop() {
        return this.g;
    }

    public int getIndicatorStyle() {
        return this.N;
    }

    public float getIndicatorWidth() {
        return this.d;
    }

    public MsgView getMsgView(int i) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        return (MsgView) this.f1770a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
    }

    public int getTabCount() {
        return this.M;
    }

    public float getTabPadding() {
        return this.f30215a;
    }

    public float getTabWidth() {
        return this.b;
    }

    public int getTextBold() {
        return this.W;
    }

    public int getTextSelectColor() {
        return this.U;
    }

    public int getTextUnselectColor() {
        return this.V;
    }

    public float getTextsize() {
        return this.m;
    }

    public TextView getTitleView(int i) {
        return (TextView) this.f1770a.getChildAt(i).findViewById(R.id.tv_tab_title);
    }

    public int getUnderlineColor() {
        return this.R;
    }

    public float getUnderlineHeight() {
        return this.j;
    }

    public final void h() {
        int i = 0;
        while (i < this.M) {
            View childAt = this.f1770a.getChildAt(i);
            float f = this.f30215a;
            childAt.setPadding((int) f, 0, (int) f, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(i == this.K ? this.U : this.V);
            textView.setTextSize(0, this.m);
            if (this.f1782d) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i2 = this.W;
            if (i2 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i2 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            if (this.f1783e) {
                imageView.setVisibility(0);
                CustomTabEntity customTabEntity = this.f1774a.get(i);
                imageView.setImageResource(i == this.K ? customTabEntity.getTabSelectedIcon() : customTabEntity.getTabUnselectedIcon());
                float f2 = this.n;
                int i3 = f2 <= 0.0f ? -2 : (int) f2;
                float f3 = this.o;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, f3 > 0.0f ? (int) f3 : -2);
                int i4 = this.X;
                if (i4 == 3) {
                    layoutParams.rightMargin = (int) this.p;
                } else if (i4 == 5) {
                    layoutParams.leftMargin = (int) this.p;
                } else if (i4 == 80) {
                    layoutParams.topMargin = (int) this.p;
                } else {
                    layoutParams.bottomMargin = (int) this.p;
                }
                imageView.setLayoutParams(layoutParams);
            } else {
                imageView.setVisibility(8);
            }
            i++;
        }
    }

    public void hideMsg(int i) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        MsgView msgView = (MsgView) this.f1770a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public boolean isIconVisible() {
        return this.f1783e;
    }

    public boolean isIndicatorAnimEnable() {
        return this.f1778b;
    }

    public boolean isIndicatorBounceEnable() {
        return this.f1780c;
    }

    public boolean isTabSpaceEqual() {
        return this.f1775a;
    }

    public boolean isTextAllCaps() {
        return this.f1782d;
    }

    public void notifyDataSetChanged() {
        View viewInflate;
        this.f1770a.removeAllViews();
        this.M = this.f1774a.size();
        for (int i = 0; i < this.M; i++) {
            int i2 = this.X;
            if (i2 == 3) {
                viewInflate = View.inflate(this.f1763a, R.layout.layout_tab_left, null);
            } else if (i2 == 5) {
                viewInflate = View.inflate(this.f1763a, R.layout.layout_tab_right, null);
            } else {
                viewInflate = i2 == 80 ? View.inflate(this.f1763a, R.layout.layout_tab_bottom, null) : View.inflate(this.f1763a, R.layout.layout_tab_top, null);
            }
            viewInflate.setTag(Integer.valueOf(i));
            c(i, viewInflate);
        }
        h();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.f1770a.getChildAt(this.K);
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.f1766a;
        float f = bVar.f30217a;
        rect.left = (int) f;
        rect.right = (int) bVar.b;
        if (this.d >= 0.0f) {
            float width = childAt.getWidth();
            float f2 = this.d;
            float f3 = f + ((width - f2) / 2.0f);
            Rect rect2 = this.f1766a;
            int i = (int) f3;
            rect2.left = i;
            rect2.right = (int) (i + f2);
        }
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
        float f = this.k;
        if (f > 0.0f) {
            this.f1776b.setStrokeWidth(f);
            this.f1776b.setColor(this.T);
            for (int i = 0; i < this.M - 1; i++) {
                View childAt = this.f1770a.getChildAt(i);
                canvas.drawLine(childAt.getRight() + paddingLeft, this.l, childAt.getRight() + paddingLeft, height - this.l, this.f1776b);
            }
        }
        if (this.j > 0.0f) {
            this.f1764a.setColor(this.R);
            if (this.S == 80) {
                float f2 = height;
                canvas.drawRect(paddingLeft, f2 - this.j, this.f1770a.getWidth() + paddingLeft, f2, this.f1764a);
            } else {
                canvas.drawRect(paddingLeft, 0.0f, this.f1770a.getWidth() + paddingLeft, this.j, this.f1764a);
            }
        }
        if (!this.f1778b) {
            d();
        } else if (this.f1784f) {
            this.f1784f = false;
            d();
        }
        int i2 = this.N;
        if (i2 == 1) {
            if (this.c > 0.0f) {
                this.f1779c.setColor(this.P);
                this.f1765a.reset();
                float f3 = height;
                this.f1765a.moveTo(this.f1766a.left + paddingLeft, f3);
                Path path = this.f1765a;
                Rect rect = this.f1766a;
                path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f3 - this.c);
                this.f1765a.lineTo(paddingLeft + this.f1766a.right, f3);
                this.f1765a.close();
                canvas.drawPath(this.f1765a, this.f1779c);
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (this.c < 0.0f) {
                this.c = (height - this.g) - this.i;
            }
            float f4 = this.c;
            if (f4 > 0.0f) {
                float f5 = this.e;
                if (f5 < 0.0f || f5 > f4 / 2.0f) {
                    this.e = f4 / 2.0f;
                }
                Drawable drawable = this.f1767a;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(this.P);
                }
                Drawable drawable2 = this.f1767a;
                int i3 = ((int) this.f) + paddingLeft;
                Rect rect2 = this.f1766a;
                int i4 = i3 + rect2.left;
                float f6 = this.g;
                drawable2.setBounds(i4, (int) f6, (int) ((paddingLeft + rect2.right) - this.h), (int) (f6 + this.c));
                Drawable drawable3 = this.f1767a;
                if (drawable3 instanceof GradientDrawable) {
                    ((GradientDrawable) drawable3).setCornerRadius(this.e);
                }
                this.f1767a.draw(canvas);
                return;
            }
            return;
        }
        if (this.c > 0.0f) {
            Drawable drawable4 = this.f1767a;
            if (drawable4 instanceof GradientDrawable) {
                ((GradientDrawable) drawable4).setColor(this.P);
            }
            if (this.Q == 80) {
                Drawable drawable5 = this.f1767a;
                int i5 = ((int) this.f) + paddingLeft;
                Rect rect3 = this.f1766a;
                int i6 = i5 + rect3.left;
                int i7 = height - ((int) this.c);
                float f7 = this.i;
                drawable5.setBounds(i6, i7 - ((int) f7), (paddingLeft + rect3.right) - ((int) this.h), height - ((int) f7));
            } else {
                Drawable drawable6 = this.f1767a;
                int i8 = ((int) this.f) + paddingLeft;
                Rect rect4 = this.f1766a;
                int i9 = i8 + rect4.left;
                float f8 = this.g;
                drawable6.setBounds(i9, (int) f8, (paddingLeft + rect4.right) - ((int) this.h), ((int) this.c) + ((int) f8));
            }
            Drawable drawable7 = this.f1767a;
            if (drawable7 instanceof GradientDrawable) {
                ((GradientDrawable) drawable7).setCornerRadius(this.e);
            }
            this.f1767a.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.K = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.K != 0 && this.f1770a.getChildCount() > 0) {
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
        ll3 ll3Var = this.f1773a;
        if (ll3Var != null) {
            ll3Var.d(i);
        }
        if (this.f1778b) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        this.T = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.l = dp2px(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.k = dp2px(f);
        invalidate();
    }

    public void setIconGravity(int i) {
        this.X = i;
        notifyDataSetChanged();
    }

    public void setIconHeight(float f) {
        this.o = dp2px(f);
        h();
    }

    public void setIconMargin(float f) {
        this.p = dp2px(f);
        h();
    }

    public void setIconVisible(boolean z) {
        this.f1783e = z;
        h();
    }

    public void setIconWidth(float f) {
        this.n = dp2px(f);
        h();
    }

    public void setIndicatorAnimDuration(long j) {
        this.f1761a = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.f1778b = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.f1780c = z;
    }

    public void setIndicatorColor(int i) {
        this.P = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.e = dp2px(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.Q = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.c = dp2px(f);
        invalidate();
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        this.f = dp2px(f);
        this.g = dp2px(f2);
        this.h = dp2px(f3);
        this.i = dp2px(f4);
        invalidate();
    }

    public void setIndicatorStyle(int i) {
        this.N = i;
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.d = dp2px(f);
        invalidate();
    }

    public void setMsgMargin(int i, float f, float f2) {
        int i2 = this.M;
        if (i >= i2) {
            i = i2 - 1;
        }
        View childAt = this.f1770a.getChildAt(i);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.f1781d.setTextSize(this.m);
            this.f1781d.measureText(textView.getText().toString());
            float fDescent = this.f1781d.descent() - this.f1781d.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            float intrinsicHeight = this.o;
            float f3 = 0.0f;
            if (this.f1783e) {
                if (intrinsicHeight <= 0.0f) {
                    intrinsicHeight = this.f1763a.getResources().getDrawable(this.f1774a.get(i).getTabSelectedIcon()).getIntrinsicHeight();
                }
                f3 = this.p;
            }
            int i3 = this.X;
            if (i3 == 48 || i3 == 80) {
                marginLayoutParams.leftMargin = dp2px(f);
                int i4 = this.Y;
                marginLayoutParams.topMargin = i4 > 0 ? (((int) (((i4 - fDescent) - intrinsicHeight) - f3)) / 2) - dp2px(f2) : dp2px(f2);
            } else {
                marginLayoutParams.leftMargin = dp2px(f);
                int i5 = this.Y;
                marginLayoutParams.topMargin = i5 > 0 ? (((int) (i5 - Math.max(fDescent, intrinsicHeight))) / 2) - dp2px(f2) : dp2px(f2);
            }
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.f1772a = onTabSelectListener;
    }

    public void setTabData(ArrayList<CustomTabEntity> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
        }
        this.f1774a.clear();
        this.f1774a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void setTabPadding(float f) {
        this.f30215a = dp2px(f);
        h();
    }

    public void setTabSpaceEqual(boolean z) {
        this.f1775a = z;
        h();
    }

    public void setTabWidth(float f) {
        this.b = dp2px(f);
        h();
    }

    public void setTextAllCaps(boolean z) {
        this.f1782d = z;
        h();
    }

    public void setTextBold(int i) {
        this.W = i;
        h();
    }

    public void setTextSelectColor(int i) {
        this.U = i;
        h();
    }

    public void setTextUnselectColor(int i) {
        this.V = i;
        h();
    }

    public void setTextsize(float f) {
        this.m = sp2px(f);
        h();
    }

    public void setUnderlineColor(int i) {
        this.R = i;
        invalidate();
    }

    public void setUnderlineGravity(int i) {
        this.S = i;
        invalidate();
    }

    public void setUnderlineHeight(float f) {
        this.j = dp2px(f);
        invalidate();
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
        MsgView msgView = (MsgView) this.f1770a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            zg9.b(msgView, i2);
            if (this.f1768a.get(i) == null || !this.f1768a.get(i).booleanValue()) {
                if (this.f1783e) {
                    int i4 = this.X;
                    setMsgMargin(i, 0.0f, (i4 == 3 || i4 == 5) ? 4.0f : 0.0f);
                } else {
                    setMsgMargin(i, 2.0f, 2.0f);
                }
                this.f1768a.put(i, Boolean.TRUE);
            }
        }
    }

    public int sp2px(float f) {
        return (int) ((f * this.f1763a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1774a = new ArrayList<>();
        this.f1766a = new Rect();
        this.f1764a = new Paint(1);
        this.f1776b = new Paint(1);
        this.f1779c = new Paint(1);
        this.f1765a = new Path();
        this.f1769a = new OvershootInterpolator(1.5f);
        this.f1781d = new Paint(1);
        this.f1768a = new SparseArray<>();
        b bVar = new b();
        this.f1771a = bVar;
        b bVar2 = new b();
        this.f1777b = bVar2;
        this.N = 0;
        this.f1784f = true;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f1763a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f1770a = linearLayout;
        addView(linearLayout);
        f(context, attributeSet);
        if (this.O != 0) {
            this.f1767a = context.getResources().getDrawable(this.O);
        } else {
            this.f1767a = new GradientDrawable();
        }
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
            this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -2);
            typedArrayObtainStyledAttributes.recycle();
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new c(), bVar2, bVar);
        this.f1762a = valueAnimatorOfObject;
        valueAnimatorOfObject.addUpdateListener(this);
    }

    public void setTabData(ArrayList<CustomTabEntity> arrayList, FragmentActivity fragmentActivity, int i, ArrayList<Fragment> arrayList2) {
        this.f1773a = new ll3(fragmentActivity.getSupportFragmentManager(), i, arrayList2);
        setTabData(arrayList);
    }
}
