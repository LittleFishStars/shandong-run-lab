package com.huachenjie.base.view.danmuku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;
import com.huachenjie.base.view.danmuku.view.OnDanMuParentViewTouchCallBackListener;
import com.huachenjie.base.view.danmuku.view.OnDanMuViewTouchListener;
import com.zj.adlib.w52;
import com.zj.adlib.y52;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DanMuSurfaceView extends SurfaceView implements IDanMuParent, SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f32976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SurfaceHolder f7295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnDanMuParentViewTouchCallBackListener f7296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public w52 f7297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<OnDanMuViewTouchListener> f7298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7299a;
    public OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener;

    public interface OnDetectHasCanTouchedDanMusListener {
        void a(boolean hasDanMus);
    }

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (DanMuSurfaceView.this.f7298a.size() > 0) {
                    DanMuSurfaceView.this.detectHasCanTouchedDanMus();
                    DanMuSurfaceView.this.f32976a.sendEmptyMessageDelayed(1, 100L);
                } else {
                    OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener = DanMuSurfaceView.this.onDetectHasCanTouchedDanMusListener;
                    if (onDetectHasCanTouchedDanMusListener != null) {
                        onDetectHasCanTouchedDanMusListener.a(false);
                    }
                }
            }
            return false;
        }
    }

    public DanMuSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7298a = new ArrayList<>();
        this.f7299a = false;
        this.f32976a = new Handler(new a());
        d();
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void add(y52 danMuView) {
        c(-1, danMuView);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void addAllTouchListener(List<y52> danMuViews) {
        this.f7298a.addAll(danMuViews);
    }

    public void addPainter(com.huachenjie.base.view.danmuku.model.painter.a danMuPainter, int key) {
        w52 w52Var = this.f7297a;
        if (w52Var != null) {
            w52Var.b(danMuPainter, key);
        }
    }

    public final void c(int index, final y52 danMuView) {
        if (danMuView == null || this.f7297a == null) {
            return;
        }
        if (danMuView.e()) {
            this.f7298a.add(danMuView);
        }
        this.f7297a.a(index, danMuView);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void clear() {
        this.f7298a.clear();
    }

    public final void d() {
        this.f7297a = new w52(this);
        SurfaceHolder holder = getHolder();
        this.f7295a = holder;
        holder.addCallback(this);
    }

    public void detectHasCanTouchedDanMus() {
        int i = 0;
        while (i < this.f7298a.size()) {
            if (!((y52) this.f7298a.get(i)).o()) {
                this.f7298a.remove(i);
                i--;
            }
            i++;
        }
        if (this.f7298a.size() == 0) {
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

    public final void e(Canvas canvas) {
        this.f7297a.k();
        this.f7298a = new ArrayList<>();
        this.f7297a.h(canvas);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void forceSleep() {
        this.f7297a.d();
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void forceWake() {
        this.f7297a.e();
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public boolean hasCanTouchDanMus() {
        return this.f7298a.size() > 0;
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void hideAllDanMuView(boolean hideAll) {
        this.f7297a.g(hideAll);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void hideNormalDanMuView(boolean hide) {
        this.f7297a.f(hide);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void jumpQueue(List<y52> danMuViews) {
        this.f7297a.j(danMuViews);
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void lockDraw() {
        Canvas canvasLockCanvas;
        if (this.f7299a && (canvasLockCanvas = this.f7295a.lockCanvas()) != null) {
            canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            w52 w52Var = this.f7297a;
            if (w52Var != null) {
                w52Var.c(canvasLockCanvas);
            }
            if (this.f7299a) {
                this.f7295a.unlockCanvasAndPost(canvasLockCanvas);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if ((event.getAction() & 255) == 1) {
            this.f32976a.removeMessages(1);
            this.f32976a.sendEmptyMessage(1);
            int size = this.f7298a.size();
            for (int i = 0; i < size; i++) {
                OnDanMuViewTouchListener onDanMuViewTouchListener = this.f7298a.get(i);
                boolean zA = onDanMuViewTouchListener.a(event.getX(), event.getY());
                y52 y52Var = (y52) onDanMuViewTouchListener;
                if (y52Var.i() != null && zA) {
                    y52Var.i().a(y52Var);
                    return true;
                }
            }
            if (hasCanTouchDanMus()) {
                OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener = this.f7296a;
                if (onDanMuParentViewTouchCallBackListener != null) {
                    onDanMuParentViewTouchCallBackListener.b();
                }
            } else {
                OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener2 = this.f7296a;
                if (onDanMuParentViewTouchCallBackListener2 != null) {
                    onDanMuParentViewTouchCallBackListener2.a();
                }
            }
        }
        return true;
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void release() {
        this.onDetectHasCanTouchedDanMusListener = null;
        this.f7296a = null;
        clear();
        this.f7297a.l();
        this.f7297a = null;
        SurfaceHolder surfaceHolder = this.f7295a;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this);
        }
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void remove(y52 danMuView) {
        this.f7298a.remove(danMuView);
    }

    public void setOnDanMuExistListener(OnDetectHasCanTouchedDanMusListener onDetectHasCanTouchedDanMusListener) {
        this.onDetectHasCanTouchedDanMusListener = onDetectHasCanTouchedDanMusListener;
    }

    public void setOnDanMuParentViewTouchCallBackListener(OnDanMuParentViewTouchCallBackListener onDanMuParentViewTouchCallBackListener) {
        this.f7296a = onDanMuParentViewTouchCallBackListener;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        this.f7299a = true;
        Canvas canvasLockCanvas = this.f7295a.lockCanvas();
        e(canvasLockCanvas);
        this.f7295a.unlockCanvasAndPost(canvasLockCanvas);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.f7299a = false;
    }

    @Override // com.huachenjie.base.view.danmuku.view.IDanMuParent
    public void add(int index, y52 danMuView) {
        c(index, danMuView);
    }
}
