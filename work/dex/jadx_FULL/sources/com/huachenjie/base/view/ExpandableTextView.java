package com.huachenjie.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ExpandableTextView extends AppCompatTextView {
    public int K;
    public int L;
    public int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnExpandChangeListener f32971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f7275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7276a;
    public CharSequence b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f7277b;
    public boolean c;

    public interface OnExpandChangeListener {
        void a(boolean expand);
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public final void b(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_etv_text_close_line, 3);
        this.L = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_etv_text_expand_line, 2147483646);
        this.M = typedArrayObtainStyledAttributes.getColor(R.styleable.ExpandableTextView_etv_text_button_color, -1);
        this.f7277b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_etv_text_close_new_line, true);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_etv_text_expand_icon, 0);
        this.c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_etv_show_expand_text, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void close() {
        this.f7276a = false;
        f();
        setText(this.f7275a);
    }

    public int dp2px(float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, getContext().getResources().getDisplayMetrics());
    }

    public final void e() {
        setMovementMethod(new LinkMovementMethod());
        setHighlightColor(0);
    }

    public void expand() {
        this.f7276a = true;
        f();
        setText(this.b);
    }

    public final void f() {
        OnExpandChangeListener onExpandChangeListener = this.f32971a;
        if (onExpandChangeListener != null) {
            onExpandChangeListener.a(this.f7276a);
        }
    }

    public int getButtonTextColor() {
        return this.M;
    }

    public boolean getCloseInNewLine() {
        return this.f7277b;
    }

    public int getExpandableIcon() {
        return this.N;
    }

    public boolean getShowExpandText() {
        return this.c;
    }

    public int getTextMaxLine() {
        return this.L;
    }

    public int getTextMinLine() {
        return this.K;
    }

    public void setExpandText(CharSequence closeText, CharSequence expandText) {
        this.f7275a = closeText;
        this.b = expandText;
    }

    public void setOnExpandChangeListener(OnExpandChangeListener expandChangeListener) {
        this.f32971a = expandChangeListener;
    }

    public int sp2px(float dpVal) {
        return (int) TypedValue.applyDimension(2, dpVal, getContext().getResources().getDisplayMetrics());
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.K = 3;
        this.L = 2147483646;
        this.f7276a = false;
        this.M = -1;
        this.f7277b = true;
        this.N = 0;
        this.c = true;
        b(context, attrs);
        e();
    }
}
