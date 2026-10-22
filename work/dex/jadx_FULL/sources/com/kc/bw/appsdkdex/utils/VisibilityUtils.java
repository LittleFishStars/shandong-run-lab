package com.kc.bw.appsdkdex.utils;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class VisibilityUtils {
    public static final String TAG = dexg.dexa("WjtjcjmjuzVujmt");
    public static VisibilityUtils visibilityUtils;

    @Keep
    public class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final VisibilityUtils this$0;
        public final View view;

        public GlobalLayoutListener(VisibilityUtils visibilityUtils, View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.this$0 = visibilityUtils;
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                if (this.this$0.checkViewVisibility(this.view)) {
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
                DebugLog.release_w(dexg.dexa("WjtjcjmjuzVujmt"), dexg.dexa("poHmpcbmMbzpvu!gbjm-") + stackTraceString);
            }
        }
    }

    @Keep
    public class ScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final VisibilityUtils this$0;
        public final View view;

        public ScrollChangedListener(VisibilityUtils visibilityUtils, View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.this$0 = visibilityUtils;
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (this.this$0.checkViewVisibility(this.view)) {
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
                DebugLog.release_w(dexg.dexa("WjtjcjmjuzVujmt"), dexg.dexa("poTdspmmDibohfe!gbjm-") + stackTraceString);
            }
        }
    }

    @Keep
    public interface ViewVisibilityChangeListener {
        void invisible();

        void visible();
    }

    @Keep
    public class WindowFocusChangeListener implements ViewTreeObserver.OnWindowFocusChangeListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final VisibilityUtils this$0;
        public final View view;

        public WindowFocusChangeListener(VisibilityUtils visibilityUtils, View view, boolean z, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.this$0 = visibilityUtils;
            this.view = view;
            this.isVisible = z;
            this.listener = viewVisibilityChangeListener;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0026 A[Catch: all -> 0x0031, PHI: r4
          0x0026: PHI (r4v5 com.kc.bw.appsdkdex.utils.VisibilityUtils$ViewVisibilityChangeListener) = 
          (r4v4 com.kc.bw.appsdkdex.utils.VisibilityUtils$ViewVisibilityChangeListener)
          (r4v9 com.kc.bw.appsdkdex.utils.VisibilityUtils$ViewVisibilityChangeListener)
         binds: [B:17:0x002e, B:14:0x0024] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0011, B:10:0x0018, B:11:0x001c, B:13:0x0020, B:15:0x0026, B:16:0x002a), top: B:23:0x0001 }] */
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            ViewVisibilityChangeListener viewVisibilityChangeListener;
            try {
                if (!z) {
                    this.isVisible = false;
                    viewVisibilityChangeListener = this.listener;
                    if (viewVisibilityChangeListener != null) {
                        viewVisibilityChangeListener.invisible();
                    }
                } else if (this.this$0.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                        if (viewVisibilityChangeListener2 != null) {
                            viewVisibilityChangeListener2.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    viewVisibilityChangeListener = this.listener;
                    if (viewVisibilityChangeListener != null) {
                        viewVisibilityChangeListener.invisible();
                    }
                }
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.release_w(dexg.dexa("WjtjcjmjuzVujmt"), dexg.dexa("poXjoepxGpdvtDibohfe!gbjm-") + stackTraceString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewVisibility(View view) {
        try {
            if (!isAttachedToWindow(view) || !unCover(view)) {
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
            DebugLog.release_w(TAG, dexg.dexa("difdlWjfxWjtjcjmjuz!gbjm-") + stackTraceString);
            return true;
        }
    }

    public static VisibilityUtils getInstance() {
        if (visibilityUtils == null) {
            synchronized (VisibilityUtils.class) {
                try {
                    if (visibilityUtils == null) {
                        visibilityUtils = new VisibilityUtils();
                    }
                } catch (Throwable th) {
                    throw th;
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
            DebugLog.release_w(TAG, dexg.dexa("voDpwfs!gbjm-") + stackTraceString);
            return localVisibleRect;
        }
    }

    public void addVisibleChangedListener(View view, ViewVisibilityChangeListener viewVisibilityChangeListener) {
        if (view == null || viewVisibilityChangeListener == null) {
            DebugLog.W(TAG, dexg.dexa("Wjfx!ps!Mjtufofs!jt!ovmm"));
            return;
        }
        try {
            GlobalLayoutListener globalLayoutListener = new GlobalLayoutListener(this, view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
            ScrollChangedListener scrollChangedListener = new ScrollChangedListener(this, view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnScrollChangedListener(scrollChangedListener);
            WindowFocusChangeListener windowFocusChangeListener = new WindowFocusChangeListener(this, view, false, viewVisibilityChangeListener);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(windowFocusChangeListener);
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this, view, globalLayoutListener, scrollChangedListener, windowFocusChangeListener) { // from class: com.kc.bw.appsdkdex.utils.VisibilityUtils.1
                public final VisibilityUtils this$0;
                public final GlobalLayoutListener val$globalLayoutListener;
                public final ScrollChangedListener val$scrollChangedListener;
                public final View val$view;
                public final WindowFocusChangeListener val$windowFocusChangeListener;

                {
                    this.this$0 = this;
                    this.val$view = view;
                    this.val$globalLayoutListener = globalLayoutListener;
                    this.val$scrollChangedListener = scrollChangedListener;
                    this.val$windowFocusChangeListener = windowFocusChangeListener;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    try {
                        this.val$view.getViewTreeObserver().removeOnGlobalLayoutListener(this.val$globalLayoutListener);
                        this.val$view.getViewTreeObserver().removeOnScrollChangedListener(this.val$scrollChangedListener);
                        this.val$view.getViewTreeObserver().removeOnWindowFocusChangeListener(this.val$windowFocusChangeListener);
                        this.val$view.removeOnAttachStateChangeListener(this);
                    } catch (Throwable th) {
                        DebugLog.release_w(dexg.dexa("WjtjcjmjuzVujmt"), dexg.dexa("poWjfxEfubdifeGspnXjoepx!gbjm-") + th);
                    }
                }
            });
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexg.dexa("beeWjfxWjtjcmfMjtufofs!gbjm-") + th);
        }
    }
}
