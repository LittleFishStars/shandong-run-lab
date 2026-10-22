package com.fl.saas.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class VisibilityLayout extends FrameLayout {
    private Runnable checkAreaRatioRunnable;
    private Runnable checkValidAreaRunnable;
    private Consumer<Boolean> mVisibilityChanged;
    private Consumer<Integer> mVisibilityRatioChanged;
    private int maxRatio;
    private OnViewWindowChangedListener onViewWindowChangedListener;

    public interface OnViewWindowChangedListener {
        void onDetachedFromWindow();

        void onViewWindowVisibility(boolean z);
    }

    public VisibilityLayout(Context context) {
        super(context);
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
            Consumer<Integer> consumer = this.mVisibilityRatioChanged;
            if (consumer != null) {
                consumer.accept(Integer.valueOf(areaEffectiveRatio));
            }
        }
        if (areaEffectiveRatio > 95) {
            unOnVisibilityRatioChanged();
            return;
        }
        if (this.checkAreaRatioRunnable == null) {
            this.checkAreaRatioRunnable = new Runnable() { // from class: com.zj.adlib.os9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43827a.checkAreaRatio();
                }
            };
        }
        DeviceUtil.removePostUI(this.checkAreaRatioRunnable);
        DeviceUtil.postUIDelayed(300L, this.checkAreaRatioRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidArea() {
        if (this.mVisibilityChanged == null) {
            return;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = getGlobalVisibleRect(rect);
        int areaEffectiveRatio = getAreaEffectiveRatio(rect);
        if (areaEffectiveRatio > this.maxRatio) {
            this.maxRatio = areaEffectiveRatio;
            Consumer<Integer> consumer = this.mVisibilityRatioChanged;
            if (consumer != null) {
                consumer.accept(Integer.valueOf(areaEffectiveRatio));
            }
        }
        if (areaEffectiveRatio > 95) {
            unOnVisibilityRatioChanged();
        }
        Consumer<Boolean> consumer2 = this.mVisibilityChanged;
        if (consumer2 != null) {
            consumer2.accept(Boolean.valueOf(globalVisibleRect && areaEffectiveRatio > 70));
        }
        if (this.checkValidAreaRunnable == null) {
            this.checkValidAreaRunnable = new Runnable() { // from class: com.zj.adlib.ms9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43375a.checkValidArea();
                }
            };
        }
        DeviceUtil.removePostUI(this.checkValidAreaRunnable);
        DeviceUtil.postUIDelayed(200L, this.checkValidAreaRunnable);
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
        int width = getWidth();
        int height = getHeight();
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

    public void setOnVisibilityChanged(Consumer<Boolean> consumer) {
        this.mVisibilityChanged = consumer;
        checkValidArea();
    }

    public void setVisibilityRatioChanged(Consumer<Integer> consumer) {
        this.mVisibilityRatioChanged = consumer;
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
}
