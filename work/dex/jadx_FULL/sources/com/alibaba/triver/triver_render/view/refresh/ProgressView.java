package com.alibaba.triver.triver_render.view.refresh;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.triver_render.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProgressView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25243a = "ProgressView";
    private static final int b = 10086;
    private ArrayList<View> c;
    private View d;
    private int e;
    private int f;
    private int g;
    private a h;
    private boolean i;

    public class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AnimatorSet animatorSet = new AnimatorSet();
            if (ProgressView.this.d != null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(ProgressView.this.d, "alpha", 0.2f, 0.5f);
                objectAnimatorOfFloat.setDuration(400L);
                animatorSet.play(objectAnimatorOfFloat);
            }
            ProgressView.this.d();
            View view = (View) ProgressView.this.c.get(ProgressView.this.e);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 0.2f);
            objectAnimatorOfFloat2.setDuration(400L);
            animatorSet.play(objectAnimatorOfFloat2);
            animatorSet.start();
            ProgressView.this.d = view;
            ProgressView.this.e();
        }
    }

    public ProgressView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.removeMessages(b);
            this.h.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.i) {
            if (i == 0 && view.getVisibility() == 0) {
                e();
            } else {
                a aVar = this.h;
                if (aVar != null) {
                    aVar.removeMessages(b);
                }
            }
        }
        super.onVisibilityChanged(view, i);
    }

    public void setAutoPlay(boolean z) {
        this.i = z;
    }

    public void setDotsBackground(@DrawableRes int i) {
        ArrayList<View> arrayList = this.c;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBackgroundResource(i);
            }
        }
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i;
        int i2 = this.e;
        if (i2 >= 2) {
            i = 0;
        } else {
            i = i2 + 1;
            this.e = i;
        }
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.sendEmptyMessageDelayed(b, 400L);
        }
    }

    public void b() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.removeMessages(b);
            this.h.removeCallbacksAndMessages(null);
        }
        ArrayList<View> arrayList = this.c;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.2f);
            }
        }
    }

    public void c() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.removeMessages(b);
            this.h.removeCallbacksAndMessages(null);
        }
        e();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.c = new ArrayList<>();
        this.e = 0;
        this.h = new a();
        this.i = true;
        this.f = CommonUtils.dip2px(context, 8.0f);
        this.g = CommonUtils.dip2px(context, 6.0f);
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressView, i, 0)) != null) {
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressView_progress_dot_size, this.g);
            this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressView_progress_dot_margin, this.f);
            typedArrayObtainStyledAttributes.recycle();
        }
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.triver_view_progress_dot, this);
        View viewFindViewById = findViewById(R.id.progress_dot1);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
        int i = this.g;
        marginLayoutParams.height = i;
        marginLayoutParams.width = i;
        marginLayoutParams.setMargins(0, 0, this.f, 0);
        viewFindViewById.setAlpha(0.5f);
        viewFindViewById.setLayoutParams(marginLayoutParams);
        this.c.add(viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.progress_dot2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewFindViewById2.getLayoutParams();
        int i2 = this.g;
        marginLayoutParams2.height = i2;
        marginLayoutParams2.width = i2;
        marginLayoutParams2.setMargins(0, 0, this.f, 0);
        viewFindViewById2.setAlpha(0.5f);
        viewFindViewById2.setLayoutParams(marginLayoutParams2);
        this.c.add(viewFindViewById2);
        View viewFindViewById3 = findViewById(R.id.progress_dot3);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) viewFindViewById3.getLayoutParams();
        int i3 = this.g;
        marginLayoutParams3.height = i3;
        marginLayoutParams3.width = i3;
        viewFindViewById3.setAlpha(0.5f);
        viewFindViewById3.setLayoutParams(marginLayoutParams3);
        viewFindViewById3.setAlpha(0.5f);
        this.c.add(viewFindViewById3);
    }

    public void a() {
        this.h.removeMessages(b);
        this.h.removeCallbacksAndMessages(null);
        this.h = null;
    }
}
