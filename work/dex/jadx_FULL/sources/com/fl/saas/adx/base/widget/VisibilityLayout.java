package com.fl.saas.adx.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.B;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class VisibilityLayout extends FrameLayout {
    private Runnable checkAreaRatioRunnable;
    private Runnable checkValidAreaRunnable;
    private B mVisibilityChanged;
    private B mVisibilityRatioChanged;
    private int maxRatio;
    private OnViewWindowChangedListener onViewWindowChangedListener;

    public interface OnViewWindowChangedListener {
        void onDetachedFromWindow();

        void onViewWindowVisibility(boolean z);
    }

    public VisibilityLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAreaRatio() {
        if (this.mVisibilityRatioChanged == null) {
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        int areaEffectiveRatio = getAreaEffectiveRatio(rect);
        if (areaEffectiveRatio > this.maxRatio) {
            this.maxRatio = areaEffectiveRatio;
            B b = this.mVisibilityRatioChanged;
            if (b != null) {
                b.a(Integer.valueOf(areaEffectiveRatio));
            }
        }
        if (areaEffectiveRatio > 95) {
            unOnVisibilityRatioChanged();
            return;
        }
        if (this.checkAreaRatioRunnable == null) {
            this.checkAreaRatioRunnable = new Runnable() { // from class: com.zj.adlib.ps9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44052a.checkAreaRatio();
                }
            };
        }
        DeviceUtil.removePostUI(this.checkAreaRatioRunnable);
        DeviceUtil.postUIDelayed(300L, this.checkAreaRatioRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidArea() {
        Runnable runnable;
        long j;
        if (this.mVisibilityChanged == null) {
            return;
        }
        if (this.checkValidAreaRunnable == null) {
            this.checkValidAreaRunnable = new Runnable() { // from class: com.zj.adlib.ns9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43601a.checkValidArea();
                }
            };
        }
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            DeviceUtil.removePostUI(this.checkValidAreaRunnable);
            runnable = this.checkValidAreaRunnable;
            j = 50;
        } else {
            try {
                Rect rect = new Rect();
                boolean globalVisibleRect = getGlobalVisibleRect(rect);
                int areaEffectiveRatio = getAreaEffectiveRatio(rect);
                LogcatUtil.d("w=" + width + ", h=" + height + ", rect=" + rect + ", ratio=" + areaEffectiveRatio + ", isVisible=" + globalVisibleRect);
                if (areaEffectiveRatio > this.maxRatio) {
                    this.maxRatio = areaEffectiveRatio;
                    B b = this.mVisibilityRatioChanged;
                    if (b != null) {
                        b.a(Integer.valueOf(areaEffectiveRatio));
                    }
                }
                B b2 = this.mVisibilityChanged;
                if (b2 != null) {
                    b2.a(Boolean.valueOf(globalVisibleRect && areaEffectiveRatio > 50));
                }
                if (areaEffectiveRatio > 95) {
                    unOnVisibilityRatioChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogcatUtil.d("checkValidArea" + e.getMessage());
            }
            DeviceUtil.removePostUI(this.checkValidAreaRunnable);
            runnable = this.checkValidAreaRunnable;
            j = 200;
        }
        DeviceUtil.postUIDelayed(j, runnable);
    }

    private void clearRunnable() {
        Runnable runnable = this.checkValidAreaRunnable;
        if (runnable != null) {
            DeviceUtil.removePostUI(runnable);
            this.checkValidAreaRunnable = null;
        }
        Runnable runnable2 = this.checkAreaRatioRunnable;
        if (runnable2 != null) {
            DeviceUtil.removePostUI(runnable2);
            this.checkAreaRatioRunnable = null;
        }
    }

    private int getAreaEffectiveRatio(Rect rect) {
        float scaleY;
        float scaleX = 1.0f;
        try {
            Object parent = getParent();
            scaleY = 1.0f;
            while (parent instanceof View) {
                try {
                    View view = (View) parent;
                    scaleX *= view.getScaleX();
                    scaleY *= view.getScaleY();
                    parent = view.getParent();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e = e2;
            scaleY = 1.0f;
        }
        int width = (int) (getWidth() * scaleX);
        int height = (int) (getHeight() * scaleY);
        if (width <= 0 || height <= 0) {
            return 0;
        }
        return ((rect.width() * rect.height()) * 100) / (width * height);
    }

    public void detachedView() {
        this.mVisibilityChanged = null;
        this.mVisibilityRatioChanged = null;
        OnViewWindowChangedListener onViewWindowChangedListener = this.onViewWindowChangedListener;
        if (onViewWindowChangedListener != null) {
            onViewWindowChangedListener.onDetachedFromWindow();
            this.onViewWindowChangedListener = null;
        }
        clearRunnable();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mVisibilityChanged != null) {
            checkValidArea();
        }
        if (this.mVisibilityRatioChanged != null) {
            checkAreaRatio();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        detachedView();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            clearRunnable();
        }
        checkValidArea();
        checkAreaRatio();
        OnViewWindowChangedListener onViewWindowChangedListener = this.onViewWindowChangedListener;
        if (onViewWindowChangedListener != null) {
            onViewWindowChangedListener.onViewWindowVisibility(i == 0);
        }
    }

    public void setOnViewWindowChangedListener(OnViewWindowChangedListener onViewWindowChangedListener) {
        this.onViewWindowChangedListener = onViewWindowChangedListener;
    }

    public void setOnVisibilityChanged(B b) {
        this.mVisibilityChanged = b;
        checkValidArea();
    }

    public void setVisibilityRatioChanged(B b) {
        this.mVisibilityRatioChanged = b;
        checkAreaRatio();
    }

    public void unOnVisibilityChanged() {
        this.mVisibilityChanged = null;
        Runnable runnable = this.checkValidAreaRunnable;
        if (runnable != null) {
            DeviceUtil.removePostUI(runnable);
            this.checkValidAreaRunnable = null;
        }
    }

    public void unOnVisibilityRatioChanged() {
        this.mVisibilityRatioChanged = null;
        Runnable runnable = this.checkAreaRatioRunnable;
        if (runnable != null) {
            DeviceUtil.removePostUI(runnable);
            this.checkAreaRatioRunnable = null;
        }
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
