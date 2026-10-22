package com.huachenjie.mall.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class CommentStarView extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f35276a = {"", "非常差", "差", "一般", "好", "非常好"};
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f11161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f11162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnStarChangedCallback f11163a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public String f;

    public interface OnStarChangedCallback {
        void a(int i);
    }

    public CommentStarView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MallCommentStarView);
        this.f = typedArrayObtainStyledAttributes.getString(R.styleable.MallCommentStarView_mall_csv_star_des);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Context context) {
        setOrientation(0);
        View.inflate(context, R.layout.mall_view_comment_star, this);
        this.f11161a = (ImageView) findViewById(R.id.iv_star_one);
        this.b = (ImageView) findViewById(R.id.iv_star_two);
        this.c = (ImageView) findViewById(R.id.iv_star_three);
        this.d = (ImageView) findViewById(R.id.iv_star_four);
        this.e = (ImageView) findViewById(R.id.iv_star_five);
        this.f11162a = (TextView) findViewById(R.id.tv_star_level);
        TextView textView = (TextView) findViewById(R.id.tv_star_des);
        this.f11161a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(this.f);
        }
    }

    public final void c(int i) {
        if (this.K == i) {
            return;
        }
        d(i >= 1, this.f11161a, R.drawable.mall_ic_comment_star_one);
        d(i >= 2, this.b, R.drawable.mall_ic_comment_star_two);
        d(i >= 3, this.c, R.drawable.mall_ic_comment_star_three);
        d(i >= 4, this.d, R.drawable.mall_ic_comment_star_four);
        d(i >= 5, this.e, R.drawable.mall_ic_comment_star_five);
        this.f11162a.setText(f35276a[i]);
        OnStarChangedCallback onStarChangedCallback = this.f11163a;
        if (onStarChangedCallback != null) {
            onStarChangedCallback.a(i);
        }
    }

    public final void d(boolean z, ImageView imageView, int i) {
        if (!z) {
            i = R.drawable.mall_ic_comment_star_normal;
        }
        imageView.setImageResource(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_star_one) {
            c(1);
            return;
        }
        if (view.getId() == R.id.iv_star_two) {
            c(2);
            return;
        }
        if (view.getId() == R.id.iv_star_three) {
            c(3);
        } else if (view.getId() == R.id.iv_star_four) {
            c(4);
        } else if (view.getId() == R.id.iv_star_five) {
            c(5);
        }
    }

    public void setOnStarChangedCallback(OnStarChangedCallback onStarChangedCallback) {
        this.f11163a = onStarChangedCallback;
    }

    public CommentStarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.K = 0;
        this.f = "";
        a(context, attributeSet);
        b(context);
    }
}
