package com.byazt.ab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.nr.z;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 757, 2005})
public class PlayableVideoContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f28280a;
    public final Paint c;
    public View n;
    public long sp;
    public float tt;
    public FrameLayout uj;
    public float ve;
    public View.OnClickListener x;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.c = new Paint();
        this.sp = 0L;
        tt();
    }

    private void a() {
        int height;
        final int height2;
        final int width;
        int width2;
        int iUj = pf.uj(getContext());
        int iN = pf.n(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = iUj - getRight();
        int top2 = getTop();
        int bottom = iN - getBottom();
        int iVe = pf.ve(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 == iMin) {
            getWidth();
            int top3 = getTop();
            int bottom2 = getBottom();
            if (top3 < 0) {
                bottom2 = iVe + getHeight();
                top3 = iVe;
            }
            height2 = bottom2 > iN ? (iN - iVe) - getHeight() : top3;
            width = iVe;
        } else if (right == iMin) {
            width2 = (iUj - iVe) - getWidth();
            int top4 = getTop();
            int bottom3 = getBottom();
            if (top4 < 0) {
                bottom3 = iVe + getHeight();
                top4 = iVe;
            }
            if (bottom3 > iN) {
                height = (iN - iVe) - getHeight();
                width = width2;
                height2 = height;
            } else {
                width = width2;
                height2 = top4;
            }
        } else if (top2 == iMin) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = iVe + getWidth();
                left3 = iVe;
            }
            width = right2 > iUj ? (iUj - iVe) - getWidth() : left3;
            height2 = iVe;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (iN - iVe) - getHeight();
            if (left4 < 0) {
                right3 = iVe + getWidth();
                left4 = iVe;
            }
            if (right3 > iUj) {
                width2 = (iUj - iVe) - getWidth();
                width = width2;
                height2 = height;
            } else {
                height2 = height;
                width = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ab.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = left;
                int i2 = (int) (i + ((width - i) * animatedFraction));
                int i3 = top;
                int i4 = (int) (i3 + ((height2 - i3) * animatedFraction));
                PlayableVideoContainer.this.c(i2, i4, PlayableVideoContainer.this.getWidth() + i2, PlayableVideoContainer.this.getHeight() + i4);
            }
        });
        duration.start();
    }

    private void n() {
        View.OnClickListener onClickListener = this.x;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void tt() {
        int iVe = pf.ve(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iVe, iVe, iVe, iVe);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.uj = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.n = ve();
        frameLayout.addView(this.n, new ViewGroup.MarginLayoutParams(-1, -1));
        this.f28280a = uj();
        frameLayout.addView(this.f28280a, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.ab.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), pf.ve(gt.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    private View uj() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View ve() {
        int iVe = pf.ve(getContext(), 8.0f);
        int iVe2 = pf.ve(getContext(), 7.0f);
        int iVe3 = pf.ve(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        z.c(getContext(), "tt_arrow_up", imageView, 320);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iVe2, iVe3);
        layoutParams2.setMargins(iVe, iVe, iVe, iVe);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        z.c(getContext(), "tt_arrow_down", imageView2, 320);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iVe2, iVe3);
        layoutParams3.setMargins(iVe, iVe, iVe, iVe);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        z.c(getContext(), "tt_arrow_left", imageView3, 320);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iVe3, iVe2);
        layoutParams4.setMargins(iVe, iVe, iVe, iVe);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        z.c(getContext(), "tt_arrow_right", imageView4, 320);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iVe3, iVe2);
        layoutParams5.setMargins(iVe, iVe, iVe, iVe);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public void c() {
        post(new Runnable() { // from class: com.byazt.ab.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = pf.ve(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = pf.ve(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        this.c.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.c.setColor(-65536);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(pf.ve(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), pf.ve(getContext(), 12.0f), pf.ve(getContext(), 12.0f), this.c);
        return zDrawChild;
    }

    public FrameLayout getVideoContainer() {
        return this.uj;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                float fAbs = Math.abs(motionEvent.getX() - this.tt);
                float fAbs2 = Math.abs(motionEvent.getY() - this.ve);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.sp;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    n();
                    return true;
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.tt;
                float y = motionEvent.getY() - this.ve;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int width = getWidth() + left;
                    int top = (int) (getTop() + y);
                    c(left, top, width, getHeight() + top);
                }
            } else if (action == 3) {
            }
            a();
            setPressed(false);
        } else {
            this.tt = motionEvent.getX();
            this.ve = motionEvent.getY();
            this.sp = SystemClock.elapsedRealtime();
        }
        return true;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void c(boolean z) {
        if (!z) {
            pf.c(this.f28280a, 8);
        } else {
            pf.c(this.f28280a, 0);
            pf.c(this.n, 8);
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    public void tt(boolean z) {
        if (z) {
            pf.c(this.n, 0);
            pf.c(this.f28280a, 8);
        } else {
            pf.c(this.n, 8);
        }
    }
}
