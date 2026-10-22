package cj.mobile.wm.appsdkdex.utils;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VisibilityUtils {
    public static final String TAG = dexc.dexa("WjtjcjmjuzVujmt");
    public static VisibilityUtils visibilityUtils;

    public class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public GlobalLayoutListener(View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                        if (viewVisibilityChangeListener != null) {
                            viewVisibilityChangeListener.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                    if (viewVisibilityChangeListener2 != null) {
                        viewVisibilityChangeListener2.invisible();
                    }
                }
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.release_w(dexc.dexa("WjtjcjmjuzVujmt"), dexc.dexa("poHmpcbmMbzpvu!gbjm-") + stackTraceString);
            }
        }
    }

    public class ScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public ScrollChangedListener(View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                        if (viewVisibilityChangeListener != null) {
                            viewVisibilityChangeListener.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                    if (viewVisibilityChangeListener2 != null) {
                        viewVisibilityChangeListener2.invisible();
                    }
                }
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.release_w(dexc.dexa("WjtjcjmjuzVujmt"), dexc.dexa("poTdspmmDibohfe!gbjm-") + stackTraceString);
            }
        }
    }

    public interface ViewVisibilityChangeListener {
        void invisible();

        void visible();
    }

    public class WindowFocusChangeListener implements ViewTreeObserver.OnWindowFocusChangeListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public WindowFocusChangeListener(View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            try {
                if (!z) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                    if (viewVisibilityChangeListener != null) {
                        viewVisibilityChangeListener.invisible();
                    }
                } else if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                        if (viewVisibilityChangeListener2 != null) {
                            viewVisibilityChangeListener2.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener3 = this.listener;
                    if (viewVisibilityChangeListener3 != null) {
                        viewVisibilityChangeListener3.invisible();
                    }
                }
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.release_w(dexc.dexa("WjtjcjmjuzVujmt"), dexc.dexa("poXjoepxGpdvtDibohfe!gbjm-") + stackTraceString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewVisibility(View view) {
        try {
            if (!view.hasWindowFocus() || !isAttachedToWindow(view) || !unCover(view)) {
                return false;
            }
            while (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                if (((ViewGroup) view.getParent()).getVisibility() != 0) {
                    return false;
                }
                view = (View) view.getParent();
            }
            return true;
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.release_w(TAG, dexc.dexa("difdlWjfxWjtjcjmjuz!gbjm-") + stackTraceString);
            return true;
        }
    }

    public static VisibilityUtils getInstance() {
        if (visibilityUtils == null) {
            synchronized (VisibilityUtils.class) {
                if (visibilityUtils == null) {
                    visibilityUtils = new VisibilityUtils();
                }
            }
        }
        return visibilityUtils;
    }

    private boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    private boolean unCover(View view) {
        boolean localVisibleRect = true;
        try {
            Rect rect = new Rect();
            localVisibleRect = view.getLocalVisibleRect(rect);
            if (!localVisibleRect) {
                return localVisibleRect;
            }
            if (rect.width() < view.getMeasuredWidth() / 2 || rect.height() < view.getMeasuredHeight() / 2) {
                return false;
            }
            return localVisibleRect;
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.release_w(TAG, dexc.dexa("voDpwfs!gbjm-") + stackTraceString);
            return localVisibleRect;
        }
    }

    public void addVisibleChangedListener(final View view, ViewVisibilityChangeListener viewVisibilityChangeListener) {
        if (view == null || viewVisibilityChangeListener == null) {
            DebugLog.W(TAG, dexc.dexa("Wjfx!ps!Mjtufofs!jt!ovmm"));
            return;
        }
        try {
            final GlobalLayoutListener globalLayoutListener = new GlobalLayoutListener(view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
            final ScrollChangedListener scrollChangedListener = new ScrollChangedListener(view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnScrollChangedListener(scrollChangedListener);
            final WindowFocusChangeListener windowFocusChangeListener = new WindowFocusChangeListener(view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(windowFocusChangeListener);
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cj.mobile.wm.appsdkdex.utils.VisibilityUtils.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    try {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
                        view.getViewTreeObserver().removeOnScrollChangedListener(scrollChangedListener);
                        view.getViewTreeObserver().removeOnWindowFocusChangeListener(windowFocusChangeListener);
                        view.removeOnAttachStateChangeListener(this);
                    } catch (Throwable th) {
                        DebugLog.release_w(dexc.dexa("WjtjcjmjuzVujmt"), dexc.dexa("poWjfxEfubdifeGspnXjoepx!gbjm-") + th);
                    }
                }
            });
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("beeWjfxWjtjcmfMjtufofs!gbjm-") + th);
        }
    }

    public void addWindowFocusListener(final View view, ViewVisibilityChangeListener viewVisibilityChangeListener) {
        if (view == null || viewVisibilityChangeListener == null) {
            DebugLog.W(TAG, dexc.dexa("Wjfx!ps!Mjtufofs!jt!ovmm"));
            return;
        }
        try {
            final WindowFocusChangeListener windowFocusChangeListener = new WindowFocusChangeListener(view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(windowFocusChangeListener);
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cj.mobile.wm.appsdkdex.utils.VisibilityUtils.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    try {
                        view.getViewTreeObserver().removeOnWindowFocusChangeListener(windowFocusChangeListener);
                        view.removeOnAttachStateChangeListener(this);
                    } catch (Throwable th) {
                        DebugLog.release_w(dexc.dexa("WjtjcjmjuzVujmt"), dexc.dexa("poWjfxEfubdifeGspnXjoepx!gbjm-") + th);
                    }
                }
            });
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("beeXjoepxGpdvtMjtufofs!gbjm-") + th);
        }
    }
}
