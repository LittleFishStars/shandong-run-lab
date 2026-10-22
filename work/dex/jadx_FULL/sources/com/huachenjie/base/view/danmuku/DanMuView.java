package com.huachenjie.base.view.danmuku;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huachenjie.base.view.danmuku.control.speed.SpeedController;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;
import com.huachenjie.base.view.danmuku.view.OnDanMuParentViewTouchCallBackListener;
import com.huachenjie.base.view.danmuku.view.OnDanMuViewTouchListener;
import com.zj.adlib.w52;
import com.zj.adlib.y52;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DanMuView extends View implements IDanMuParent {
    private w52 danMuController;
    private boolean drawFinished;
    private Object lock;
    private OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener;
    private volatile ArrayList<OnDanMuViewTouchListener> onDanMuViewTouchListeners;
    public OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener;

    public interface OnDetectHasCanTouchedDanMusListener {
        void a(boolean hasDanMus);
    }

    public DanMuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.drawFinished = false;
        this.lock = new Object();
        init(context);
    }

    private void addDanMuView(final y52 danMuView) {
        if (danMuView == null || this.danMuController == null) {
            return;
        }
        if (danMuView.e()) {
            this.onDanMuViewTouchListeners.add(danMuView);
        }
        this.danMuController.a(-1, danMuView);
    }

    private void init(Context context) {
        this.onDanMuViewTouchListeners = new ArrayList<>();
        if (this.danMuController == null) {
            this.danMuController = new w52(this);
        }
    }

    private void unLockDraw() {
        synchronized (this.lock) {
            this.drawFinished = true;
            this.lock.notifyAll();
        }
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void add(y52 danMuView) {
        danMuView.c(true);
        addDanMuView(danMuView);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void addAllTouchListener(List<y52> onDanMuTouchCallBackListeners) {
        this.onDanMuViewTouchListeners.addAll(onDanMuTouchCallBackListeners);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void clear() {
        this.onDanMuViewTouchListeners.clear();
    }

    public void detectHasCanTouchedDanMus() {
        int i = 0;
        while (i < this.onDanMuViewTouchListeners.size()) {
            if (!((y52) this.onDanMuViewTouchListeners.get(i)).o()) {
                this.onDanMuViewTouchListeners.remove(i);
                i--;
            }
            i++;
        }
        if (this.onDanMuViewTouchListeners.size() == 0) {
            OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener = this.onDetectHasCanTouchedDanMusListener;
            if (onDetectHasCanTouchedDanMusListener != null) {
                onDetectHasCanTouchedDanMusListener.a(false);
                return;
            }
            return;
        }
        OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener2 = this.onDetectHasCanTouchedDanMusListener;
        if (onDetectHasCanTouchedDanMusListener2 != null) {
            onDetectHasCanTouchedDanMusListener2.a(true);
        }
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void forceSleep() {
        this.danMuController.d();
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void forceWake() {
        this.danMuController.e();
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public boolean hasCanTouchDanMus() {
        return this.onDanMuViewTouchListeners.size() > 0;
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void hideAllDanMuView(boolean hideAll) {
        this.danMuController.g(hideAll);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void hideNormalDanMuView(boolean hide) {
        this.danMuController.f(hide);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void jumpQueue(List<y52> danMuViews) {
        this.danMuController.j(danMuViews);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void lockDraw() {
        if (this.danMuController.i()) {
            synchronized (this.lock) {
                postInvalidateOnAnimation();
                if (!this.drawFinished) {
                    try {
                        this.lock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.drawFinished = false;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        detectHasCanTouchedDanMus();
        w52 w52Var = this.danMuController;
        if (w52Var != null) {
            w52Var.h(canvas);
            this.danMuController.c(canvas);
        }
        unLockDraw();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (hasCanTouchDanMus()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if ((event.getAction() & 255) == 1) {
            int size = this.onDanMuViewTouchListeners.size();
            for (int i = 0; i < size; i++) {
                OnDanMuViewTouchListener onDanMuViewTouchListener = this.onDanMuViewTouchListeners.get(i);
                boolean zA = onDanMuViewTouchListener.a(event.getX(), event.getY());
                y52 y52Var = (y52) onDanMuViewTouchListener;
                if (y52Var.i() != null && zA) {
                    y52Var.i().a(y52Var);
                    return true;
                }
            }
            if (hasCanTouchDanMus()) {
                OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener = this.onDanMuParentViewTouchCallBackListener;
                if (onDanMuParentViewTouchCallBackListener != null) {
                    onDanMuParentViewTouchCallBackListener.b();
                }
            } else {
                OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener2 = this.onDanMuParentViewTouchCallBackListener;
                if (onDanMuParentViewTouchCallBackListener2 != null) {
                    onDanMuParentViewTouchCallBackListener2.a();
                }
            }
        }
        return true;
    }

    public void prepare() {
        prepare(null);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void release() {
        this.onDetectHasCanTouchedDanMusListener = null;
        this.onDanMuParentViewTouchCallBackListener = null;
        clear();
        w52 w52Var = this.danMuController;
        if (w52Var != null) {
            w52Var.l();
        }
        this.danMuController = null;
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void remove(y52 danMuView) {
        this.onDanMuViewTouchListeners.remove(danMuView);
    }

    public void setOnDanMuExistListener(OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener) {
        this.onDetectHasCanTouchedDanMusListener = onDetectHasCanTouchedDanMusListener;
    }

    public void setOnDanMuParentViewTouchCallBackListener(OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener) {
        this.onDanMuParentViewTouchCallBackListener = onDanMuParentViewTouchCallBackListener;
    }

    public void prepare(SpeedController speedController) {
        w52 w52Var = this.danMuController;
        if (w52Var != null) {
            w52Var.m(speedController);
            this.danMuController.k();
        }
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void add(int index, y52 danMuView) {
        this.danMuController.a(index, danMuView);
    }

    public DanMuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.drawFinished = false;
        this.lock = new Object();
        init(context);
    }
}
