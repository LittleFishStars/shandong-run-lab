package com.flyco.tablayout;

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
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.flyco.tablayout.listener.OnTabInterceptListener;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.transition.ITabScaleTransformer;
import com.flyco.tablayout.widget.MsgView;
import com.zj.adlib.oz8;
import com.zj.adlib.zg9;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SlidingTabLayoutBase extends HorizontalScrollView {
    public static final int W = 0;
    public static final int X = 1;
    public static final int Y = 2;
    public static final int Z = 0;
    public static final int a0 = 1;
    public static final int b0 = 2;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f1810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f1811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<Boolean> f1814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinearLayout f1815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTabInterceptListener f1816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTabSelectListener f1817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1818a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f1819b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f1820b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1821b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f1822c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1823c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Paint f1824d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1825d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1826e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    protected float mCurrentPositionOffset;
    protected int mCurrentTab;
    protected int mTabCount;
    protected ArrayList<String> mTitles;
    public float n;
    public float o;
    ITabScaleTransformer tabScaleTransformer;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIndexOfChild = SlidingTabLayoutBase.this.f1815a.indexOfChild(view);
            if (iIndexOfChild != -1) {
                if (SlidingTabLayoutBase.this.f1816a == null || SlidingTabLayoutBase.this.f1816a.a(iIndexOfChild)) {
                    if (SlidingTabLayoutBase.this.getCurrentItem() == iIndexOfChild) {
                        if (SlidingTabLayoutBase.this.f1817a != null) {
                            SlidingTabLayoutBase.this.f1817a.a(iIndexOfChild);
                        }
                    } else {
                        if (SlidingTabLayoutBase.this.f1826e) {
                            SlidingTabLayoutBase.this.setCurrentItem(iIndexOfChild, false);
                        } else {
                            SlidingTabLayoutBase.this.setCurrentItem(iIndexOfChild);
                        }
                        if (SlidingTabLayoutBase.this.f1817a != null) {
                            SlidingTabLayoutBase.this.f1817a.b(iIndexOfChild);
                        }
                    }
                }
            }
        }
    }

    public SlidingTabLayoutBase(Context context) {
        this(context, null, 0);
    }

    public void addNewTab(String str) {
        View viewInflate = View.inflate(this.f1809a, R.layout.layout_tab, null);
        ArrayList<String> arrayList = this.mTitles;
        if (arrayList != null) {
            arrayList.add(str);
        }
        ArrayList<String> arrayList2 = this.mTitles;
        e(this.mTabCount, (arrayList2 == null ? "" : arrayList2.get(this.mTabCount)).toString(), viewInflate);
        ArrayList<String> arrayList3 = this.mTitles;
        this.mTabCount = arrayList3 == null ? getPageCount() : arrayList3.size();
        updateTabStyles();
    }

    public int dp2px(float f) {
        return (int) ((f * this.f1809a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void e(int i, String str, View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_placehold_scale);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        if (textView2 != null) {
            textView2.setTextSize(0, this.n);
        }
        view.requestLayout();
        view.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = this.f1818a ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.b > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.b, -1);
        }
        this.f1815a.addView(view, i, layoutParams);
    }

    public final void f() {
        View childAt = this.f1815a.getChildAt(this.mCurrentTab);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.K == 0 && this.f1821b) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.f1824d.setTextSize(this.m);
            float fMeasureText = this.f1824d.measureText(textView.getText().toString());
            if (this.f1823c) {
                fMeasureText = Math.max(fMeasureText, textView.getWidth());
            }
            this.o = ((right - left) - fMeasureText) / 2.0f;
        }
        int i = this.mCurrentTab;
        if (i < this.mTabCount - 1) {
            View childAt2 = this.f1815a.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.mCurrentPositionOffset;
            left += (left2 - left) * f;
            right += f * (right2 - right);
            if (this.K == 0 && this.f1821b) {
                TextView textView2 = (TextView) childAt2.findViewById(R.id.tv_tab_title);
                this.f1824d.setTextSize(this.m);
                float fMeasureText2 = this.f1824d.measureText(textView2.getText().toString());
                if (this.f1823c) {
                    fMeasureText2 = Math.max(fMeasureText2, textView2.getWidth());
                }
                float f2 = this.o;
                this.o = f2 + (this.mCurrentPositionOffset * ((((right2 - left2) - fMeasureText2) / 2.0f) - f2));
            }
        }
        Rect rect = this.f1812a;
        int i2 = (int) left;
        rect.left = i2;
        int i3 = (int) right;
        rect.right = i3;
        if (this.K == 0 && this.f1821b) {
            float f3 = this.o;
            rect.left = (int) ((left + f3) - 1.0f);
            rect.right = (int) ((right - f3) - 1.0f);
        }
        Rect rect2 = this.f1820b;
        rect2.left = i2;
        rect2.right = i3;
        if (this.d < 0.0f) {
            return;
        }
        float left3 = childAt.getLeft() + ((childAt.getWidth() - this.d) / 2.0f);
        int i4 = this.mCurrentTab;
        if (i4 < this.mTabCount - 1) {
            left3 += this.mCurrentPositionOffset * ((childAt.getWidth() / 2) + (this.f1815a.getChildAt(i4 + 1).getWidth() / 2));
        }
        Rect rect3 = this.f1812a;
        int i5 = (int) left3;
        rect3.left = i5;
        rect3.right = (int) (i5 + this.d);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        float f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.K = i;
        this.M = typedArrayObtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_indicator_color, Color.parseColor(i == 2 ? "#4B6A87" : "#ffffff"));
        int i2 = R.styleable.SlidingTabLayout_tl_indicator_height;
        int i3 = this.K;
        if (i3 == 1) {
            f = 4.0f;
        } else {
            f = i3 == 2 ? -1 : 2;
        }
        this.c = typedArrayObtainStyledAttributes.getDimension(i2, dp2px(f));
        this.d = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_width, dp2px(this.K == 1 ? 10.0f : -1.0f));
        this.e = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_corner_radius, dp2px(this.K == 2 ? -1.0f : 0.0f));
        this.f = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, dp2px(0.0f));
        this.g = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_top, dp2px(this.K == 2 ? 7.0f : 0.0f));
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, dp2px(0.0f));
        this.i = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_bottom, dp2px(this.K != 2 ? 0.0f : 7.0f));
        this.N = typedArrayObtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.f1821b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.f1823c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title_width, false);
        this.O = typedArrayObtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.j = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, dp2px(0.0f));
        this.P = typedArrayObtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.Q = typedArrayObtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, dp2px(0.0f));
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, dp2px(12.0f));
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_textsize, sp2px(14.0f));
        this.m = dimension;
        this.n = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_selectTextSize, dimension);
        this.R = typedArrayObtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.S = typedArrayObtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.T = typedArrayObtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_textBold, 0);
        this.f1825d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.f1818a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, dp2px(-1.0f));
        this.b = dimension2;
        this.f30231a = typedArrayObtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_padding, (this.f1818a || dimension2 > 0.0f) ? dp2px(0.0f) : dp2px(20.0f));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SlidingTabLayout_tl_indicator_resources, 0);
        this.L = resourceId;
        if (resourceId != 0) {
            this.f1813a = context.getResources().getDrawable(this.L);
        } else {
            this.f1813a = new GradientDrawable();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract int getCurrentItem();

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public int getDividerColor() {
        return this.Q;
    }

    public float getDividerPadding() {
        return this.l;
    }

    public float getDividerWidth() {
        return this.k;
    }

    public int getIndicatorColor() {
        return this.M;
    }

    public float getIndicatorCornerRadius() {
        return this.e;
    }

    public Drawable getIndicatorDrawable() {
        return this.f1813a;
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
        return this.K;
    }

    public float getIndicatorWidth() {
        return this.d;
    }

    public MsgView getMsgView(int i) {
        int i2 = this.mTabCount;
        if (i >= i2) {
            i = i2 - 1;
        }
        return (MsgView) this.f1815a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
    }

    public abstract int getPageCount();

    public float getSelectTextSize() {
        return this.n;
    }

    public int getTabCount() {
        return this.mTabCount;
    }

    public float getTabPadding() {
        return this.f30231a;
    }

    public TextView getTabTitleView(int i) {
        return (TextView) this.f1815a.getChildAt(i).findViewById(R.id.tv_tab_title);
    }

    @Nullable
    public View getTabView(int i) {
        return this.f1815a.getChildAt(i);
    }

    public float getTabWidth() {
        return this.b;
    }

    public int getTextBold() {
        return this.T;
    }

    public int getTextSelectColor() {
        return this.R;
    }

    public int getTextUnselectColor() {
        return this.S;
    }

    public float getTextsize() {
        return this.m;
    }

    public TextView getTitleView(int i) {
        return (TextView) this.f1815a.getChildAt(i).findViewById(R.id.tv_tab_title);
    }

    public int getUnderlineColor() {
        return this.O;
    }

    public float getUnderlineHeight() {
        return this.j;
    }

    public void hideMsg(int i) {
        int i2 = this.mTabCount;
        if (i >= i2) {
            i = i2 - 1;
        }
        MsgView msgView = (MsgView) this.f1815a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public boolean isTabSpaceEqual() {
        return this.f1818a;
    }

    public boolean isTextAllCaps() {
        return this.f1825d;
    }

    public void notifyDataSetChanged() {
        this.f1815a.removeAllViews();
        ArrayList<String> arrayList = this.mTitles;
        this.mTabCount = arrayList == null ? getPageCount() : arrayList.size();
        for (int i = 0; i < this.mTabCount; i++) {
            View viewInflate = View.inflate(this.f1809a, R.layout.layout_tab, null);
            ArrayList<String> arrayList2 = this.mTitles;
            e(i, (arrayList2 == null ? "" : arrayList2.get(i)).toString(), viewInflate);
        }
        updateTabStyles();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount <= 0) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        float f = this.k;
        if (f > 0.0f) {
            this.f1819b.setStrokeWidth(f);
            this.f1819b.setColor(this.Q);
            for (int i = 0; i < this.mTabCount - 1; i++) {
                View childAt = this.f1815a.getChildAt(i);
                canvas.drawLine(childAt.getRight() + paddingLeft, this.l, childAt.getRight() + paddingLeft, height - this.l, this.f1819b);
            }
        }
        if (this.j > 0.0f) {
            this.f1810a.setColor(this.O);
            if (this.P == 80) {
                float f2 = height;
                canvas.drawRect(paddingLeft, f2 - this.j, this.f1815a.getWidth() + paddingLeft, f2, this.f1810a);
            } else {
                canvas.drawRect(paddingLeft, 0.0f, this.f1815a.getWidth() + paddingLeft, this.j, this.f1810a);
            }
        }
        f();
        int i2 = this.K;
        if (i2 == 1) {
            if (this.c > 0.0f) {
                this.f1822c.setColor(this.M);
                this.f1811a.reset();
                float f3 = height;
                this.f1811a.moveTo(this.f1812a.left + paddingLeft, f3);
                Path path = this.f1811a;
                Rect rect = this.f1812a;
                path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f3 - this.c);
                this.f1811a.lineTo(paddingLeft + this.f1812a.right, f3);
                this.f1811a.close();
                canvas.drawPath(this.f1811a, this.f1822c);
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
                Drawable drawable = this.f1813a;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(this.M);
                }
                Drawable drawable2 = this.f1813a;
                int i3 = ((int) this.f) + paddingLeft;
                Rect rect2 = this.f1812a;
                int i4 = i3 + rect2.left;
                float f6 = this.g;
                drawable2.setBounds(i4, (int) f6, (int) ((paddingLeft + rect2.right) - this.h), (int) (f6 + this.c));
                Drawable drawable3 = this.f1813a;
                if (drawable3 instanceof GradientDrawable) {
                    ((GradientDrawable) drawable3).setCornerRadius(this.e);
                }
                this.f1813a.draw(canvas);
                return;
            }
            return;
        }
        if (this.c > 0.0f) {
            Drawable drawable4 = this.f1813a;
            if (drawable4 instanceof GradientDrawable) {
                ((GradientDrawable) drawable4).setColor(this.M);
            }
            if (this.N == 80) {
                Drawable drawable5 = this.f1813a;
                int i5 = ((int) this.f) + paddingLeft;
                Rect rect3 = this.f1812a;
                int i6 = i5 + rect3.left;
                int i7 = height - ((int) this.c);
                float f7 = this.i;
                drawable5.setBounds(i6, i7 - ((int) f7), (paddingLeft + rect3.right) - ((int) this.h), height - ((int) f7));
            } else {
                Drawable drawable6 = this.f1813a;
                int i8 = ((int) this.f) + paddingLeft;
                Rect rect4 = this.f1812a;
                int i9 = i8 + rect4.left;
                float f8 = this.g;
                drawable6.setBounds(i9, (int) f8, (paddingLeft + rect4.right) - ((int) this.h), ((int) this.c) + ((int) f8));
            }
            Drawable drawable7 = this.f1813a;
            if (drawable7 instanceof GradientDrawable) {
                ((GradientDrawable) drawable7).setCornerRadius(this.e);
            }
            this.f1813a.draw(canvas);
        }
    }

    @CallSuper
    public void onPageScrolled(int i, float f, int i2) {
        this.mCurrentTab = i;
        this.mCurrentPositionOffset = f;
        if (this.n != this.m) {
            this.tabScaleTransformer.onPageScrolled(i, f, i2);
        }
        scrollToCurrentTab();
        invalidate();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.f1815a.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
                scrollToCurrentTab();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    public void scrollToCurrentTab() {
        if (this.mTabCount <= 0) {
            return;
        }
        int width = (int) (this.mCurrentPositionOffset * this.f1815a.getChildAt(this.mCurrentTab).getWidth());
        int left = this.f1815a.getChildAt(this.mCurrentTab).getLeft() + width;
        if (this.mCurrentTab > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            f();
            Rect rect = this.f1820b;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.U) {
            this.U = left;
            scrollTo(left, 0);
        }
    }

    public abstract void setCurrentItem(int i);

    public abstract void setCurrentItem(int i, boolean z);

    public void setCurrentTab(int i, boolean z) {
        this.mCurrentTab = i;
        setCurrentItem(i, z);
    }

    public void setDividerColor(int i) {
        this.Q = i;
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

    public void setIndicatorColor(int i) {
        this.M = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.e = dp2px(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.N = i;
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
        this.K = i;
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.d = dp2px(f);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        this.f1821b = z;
        invalidate();
    }

    public void setIndicatorWidthEqualTitleWidth(boolean z) {
        this.f1823c = z;
        invalidate();
    }

    public void setMsgMargin(int i, float f, float f2) {
        float f3;
        int iDp2px;
        int i2 = this.mTabCount;
        if (i >= i2) {
            i = i2 - 1;
        }
        View childAt = this.f1815a.getChildAt(i);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.f1824d.setTextSize(this.m);
            float fMeasureText = this.f1824d.measureText(textView.getText().toString());
            float fDescent = this.f1824d.descent() - this.f1824d.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            float f4 = this.b;
            if (f4 >= 0.0f) {
                f3 = (f4 / 2.0f) + (fMeasureText / 2.0f);
                iDp2px = dp2px(f);
            } else {
                f3 = this.f30231a + fMeasureText;
                iDp2px = dp2px(f);
            }
            marginLayoutParams.leftMargin = (int) (f3 + iDp2px);
            int i3 = this.V;
            marginLayoutParams.topMargin = i3 > 0 ? (((int) (i3 - fDescent)) / 2) - dp2px(f2) : 0;
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnTabInterceptListener(OnTabInterceptListener onTabInterceptListener) {
        this.f1816a = onTabInterceptListener;
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.f1817a = onTabSelectListener;
    }

    public void setSelectTextSize(float f) {
        this.n = f;
        updateTabStyles();
    }

    public void setSnapOnTabClick(boolean z) {
        this.f1826e = z;
    }

    public void setTabPadding(float f) {
        this.f30231a = dp2px(f);
        updateTabStyles();
    }

    public void setTabSpaceEqual(boolean z) {
        this.f1818a = z;
        updateTabStyles();
    }

    public void setTabWidth(float f) {
        this.b = dp2px(f);
        updateTabStyles();
    }

    public void setTextAllCaps(boolean z) {
        this.f1825d = z;
        updateTabStyles();
    }

    public void setTextBold(int i) {
        this.T = i;
        updateTabStyles();
    }

    public void setTextColorValue(int i, int i2) {
        this.R = i;
        this.S = i2;
    }

    public void setTextSelectColor(int i) {
        this.R = i;
        updateTabStyles();
    }

    public void setTextUnselectColor(int i) {
        this.S = i;
        updateTabStyles();
    }

    public void setTextsize(float f) {
        this.m = sp2px(f);
        updateTabStyles();
    }

    public void setUnderlineColor(int i) {
        this.O = i;
        invalidate();
    }

    public void setUnderlineGravity(int i) {
        this.P = i;
        invalidate();
    }

    public void setUnderlineHeight(float f) {
        this.j = dp2px(f);
        invalidate();
    }

    public void showDot(int i) {
        int i2 = this.mTabCount;
        if (i >= i2) {
            i = i2 - 1;
        }
        showMsg(i, 0);
    }

    public void showMsg(int i, int i2) {
        int i3 = this.mTabCount;
        if (i >= i3) {
            i = i3 - 1;
        }
        MsgView msgView = (MsgView) this.f1815a.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            zg9.b(msgView, i2);
            if (this.f1814a.get(i) == null || !this.f1814a.get(i).booleanValue()) {
                setMsgMargin(i, 4.0f, 2.0f);
                this.f1814a.put(i, Boolean.TRUE);
            }
        }
    }

    public int sp2px(float f) {
        return (int) ((f * this.f1809a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public void updateTabSelection(int i) {
        Log.e("123", "updateTabSelection: " + i);
        int i2 = 0;
        while (i2 < this.mTabCount) {
            View childAt = this.f1815a.getChildAt(i2);
            ?? r5 = i2 == i ? 1 : 0;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != 0) {
                textView.setTextColor(r5 != 0 ? this.R : this.S);
                if (this.T == 1) {
                    Log.e("123", "setFakeBoldText: " + ((boolean) r5));
                    textView.setTypeface(null, r5);
                }
            }
            i2++;
        }
    }

    public void updateTabStyles() {
        int i = 0;
        while (i < this.mTabCount) {
            View childAt = this.f1815a.getChildAt(i);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            TextView textView2 = (TextView) childAt.findViewById(R.id.tv_placehold_scale);
            if (textView2 != null) {
                textView2.setTextSize(0, this.n);
                float f = this.f30231a;
                textView2.setPadding((int) f, 0, (int) f, 0);
            }
            if (textView != null) {
                textView.setTextColor(i == this.mCurrentTab ? this.R : this.S);
                textView.setTextSize(0, this.m);
                float f2 = this.f30231a;
                textView.setPadding((int) f2, 0, (int) f2, 0);
                if (this.f1825d) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i2 = this.T;
                if (i2 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i2 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
            i++;
        }
    }

    public SlidingTabLayoutBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayoutBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1812a = new Rect();
        this.f1820b = new Rect();
        this.f1810a = new Paint(1);
        this.f1819b = new Paint(1);
        this.f1822c = new Paint(1);
        this.f1811a = new Path();
        this.f1824d = new Paint(1);
        this.f1814a = new SparseArray<>();
        this.K = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f1809a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f1815a = linearLayout;
        addView(linearLayout);
        g(context, attributeSet);
        this.tabScaleTransformer = new oz8(this, this.n, this.m);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (attributeValue.equals("-1") || attributeValue.equals("-2")) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
        this.V = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        setCurrentItem(i);
    }
}
