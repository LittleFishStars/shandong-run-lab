package com.bwt.top.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bwt.top.R;
import com.bwt.top.util.DisplayUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SlideLRLayout extends FrameLayout {
    private String TAG;
    private View child;
    private int childFirstLeft;
    private int childFirstRight;
    private float downX;
    private float downY;
    private Handler handler;
    private ImageView img1;
    private ImageView img2;
    private boolean isMove;
    private float lastX;
    private float lastY;
    private float slideDistance;
    private akdsd stampCallback;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SlideLRLayout.this.img1 == null && SlideLRLayout.this.img2 == null) {
                SlideLRLayout slideLRLayout = SlideLRLayout.this;
                slideLRLayout.img1 = new ImageView(slideLRLayout.getContext());
                SlideLRLayout.this.img1.setEnabled(true);
                ImageView imageView = SlideLRLayout.this.img1;
                int i = R.drawable.slide_lr_layout_select;
                imageView.setBackgroundResource(i);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dp2px(8), DisplayUtil.dp2px(8));
                layoutParams.gravity = 81;
                layoutParams.leftMargin = DisplayUtil.dp2px(10);
                layoutParams.bottomMargin = DisplayUtil.dp2px(10);
                SlideLRLayout slideLRLayout2 = SlideLRLayout.this;
                slideLRLayout2.addView(slideLRLayout2.img1, layoutParams);
                SlideLRLayout slideLRLayout3 = SlideLRLayout.this;
                slideLRLayout3.img2 = new ImageView(slideLRLayout3.getContext());
                SlideLRLayout.this.img2.setEnabled(false);
                SlideLRLayout.this.img2.setBackgroundResource(i);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DisplayUtil.dp2px(8), DisplayUtil.dp2px(8));
                layoutParams2.gravity = 81;
                layoutParams2.leftMargin = DisplayUtil.dp2px(20);
                layoutParams2.bottomMargin = DisplayUtil.dp2px(10);
                SlideLRLayout slideLRLayout4 = SlideLRLayout.this;
                slideLRLayout4.addView(slideLRLayout4.img2, layoutParams2);
            }
        }
    }

    public interface akdsd {
        void a();
    }

    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 0) {
                return false;
            }
            SlideLRLayout.this.hideChild();
            return false;
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Log.d(SlideLRLayout.this.TAG, "child onViewAttachedToWindow");
            SlideLRLayout.this.initIndicatorView();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Log.d(SlideLRLayout.this.TAG, "child onViewDetachedFromWindow");
            SlideLRLayout.this.release();
        }
    }

    public SlideLRLayout(Context context) {
        this(context, null);
    }

    public SlideLRLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideLRLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "SlideLRLayout--";
        this.childFirstLeft = -1;
        this.childFirstRight = -1;
        this.slideDistance = 50.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initIndicatorView() {
        Log.d(this.TAG, "initIndicatorView");
        postDelayed(new a(), 600L);
    }

    private void recoverChild() {
        Log.d(this.TAG, "recoverChild");
        View view = this.child;
        if (view != null) {
            view.setLeft(this.childFirstLeft);
            this.child.setRight(this.childFirstRight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.child = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Log.d(this.TAG, "ACTION_DOWN");
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.childFirstLeft != 0) {
                this.childFirstLeft = this.child.getLeft();
                this.childFirstRight = this.child.getRight();
            }
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.isMove = false;
        } else if (motionEvent.getAction() == 2) {
            Log.d(this.TAG, "ACTION_MOVE");
            int x = (int) (motionEvent.getX() - this.downX);
            if (Math.abs(x) <= ((double) Math.abs((int) (motionEvent.getY() - this.downY))) * 1.2d || this.child == null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
                int width = this.child.getWidth() + x;
                this.child.setLeft(x);
                this.child.setRight(width);
                this.isMove = true;
            }
        } else {
            if (motionEvent.getAction() == 3) {
                Log.d(this.TAG, "ACTION_CANCEL");
            } else if (motionEvent.getAction() == 1) {
                Log.d(this.TAG, "ACTION_UP");
                if (this.isMove && Math.abs(motionEvent.getX() - this.downX) > this.slideDistance) {
                    hideChild();
                }
            }
            recoverChild();
        }
        this.lastX = motionEvent.getX();
        this.lastY = motionEvent.getY();
        return super.dispatchTouchEvent(motionEvent);
    }

    public void hideChild() {
        try {
            Log.d(this.TAG, "hideChild");
            ImageView imageView = this.img1;
            if (imageView != null) {
                imageView.setVisibility(8);
                removeView(this.img1);
            }
            ImageView imageView2 = this.img2;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                removeView(this.img2);
            }
            View view = this.child;
            if (view != null) {
                view.setVisibility(8);
                this.child.setLeft(this.childFirstLeft);
                this.child.setRight(this.childFirstRight);
                removeView(this.child);
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            akdsd akdsdVar = this.stampCallback;
            if (akdsdVar != null) {
                akdsdVar.a();
                this.stampCallback = null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View childAt = getChildAt(0);
        this.child = childAt;
        if (childAt != null) {
            childAt.addOnAttachStateChangeListener(new c());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(this.TAG, "onDetachedFromWindow");
        release();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setSlideDistance(float f) {
        if (f < 70.0f || f >= ((double) getWidth()) * 0.6d) {
            return;
        }
        this.slideDistance = f;
    }

    public void setStampCallback(akdsd akdsdVar) {
        this.stampCallback = akdsdVar;
    }

    public void showTime(int i) {
        if (this.handler != null || i <= 2) {
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper(), new b());
        this.handler = handler;
        handler.sendEmptyMessageDelayed(0, i * 1000);
    }
}
