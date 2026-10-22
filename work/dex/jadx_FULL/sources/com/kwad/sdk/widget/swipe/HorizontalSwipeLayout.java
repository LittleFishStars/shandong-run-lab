package com.kwad.sdk.widget.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class HorizontalSwipeLayout extends FrameLayout {
    private int ahL;
    private com.kwad.sdk.widget.swipe.a btN;
    private List<a> btO;
    private float hQ;
    private float hR;
    private int mTouchSlop;

    public interface a {
        void sh();

        void si();
    }

    public HorizontalSwipeLayout(@NonNull Context context) {
        super(context);
        this.ahL = 0;
        this.btO = new CopyOnWriteArrayList();
        init(context);
    }

    private synchronized void XP() {
        Iterator<a> it = this.btO.iterator();
        while (it.hasNext()) {
            it.next().si();
        }
    }

    private synchronized void XQ() {
        Iterator<a> it = this.btO.iterator();
        while (it.hasNext()) {
            it.next().sh();
        }
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    private boolean k(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.hQ = motionEvent.getX();
            this.hR = motionEvent.getY();
            this.ahL = 0;
            c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_DOWN mInitialMotionX=" + this.hQ);
        } else if (action == 1) {
            this.ahL = 0;
            c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_UP");
        } else if (action == 2) {
            float x = motionEvent.getX() - this.hQ;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(motionEvent.getY() - this.hR);
            if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                if (x > 0.0f) {
                    this.ahL = 1;
                } else {
                    this.ahL = 2;
                }
            }
            c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_MOVE mDragState=" + this.ahL + "--dx=" + x);
        } else if (action == 3) {
            this.ahL = 0;
        }
        return this.ahL != 0;
    }

    private boolean l(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_DOWN mInitialMotionX=" + this.hQ);
        } else if (action == 1) {
            c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_UP mDragState=" + this.ahL);
            List<a> list = this.btO;
            if (list != null && !list.isEmpty() && (i = this.ahL) != 0) {
                if (i == 1) {
                    XQ();
                } else if (i == 2) {
                    XP();
                }
            }
            this.ahL = 0;
        } else if (action == 2) {
            float x = motionEvent.getX() - this.hQ;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(motionEvent.getY() - this.hR);
            if (this.ahL == 0 && fAbs > this.mTouchSlop && fAbs > fAbs2) {
                if (x > 0.0f) {
                    this.ahL = 1;
                } else {
                    this.ahL = 2;
                }
            }
            c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_MOVE mDragState=" + this.ahL + "--dx=" + x);
        } else if (action == 3) {
            this.ahL = 0;
        }
        return this.ahL != 0;
    }

    public final synchronized void a(@NonNull a aVar) {
        this.btO.add(aVar);
    }

    public final synchronized void b(a aVar) {
        this.btO.remove(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        List<a> list = this.btO;
        if (list != null && !list.isEmpty()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public synchronized List<a> getOnSwipedListeners() {
        return this.btO;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.btN;
        if (aVar != null && aVar.b(this, motionEvent)) {
            c.d("HorizontalSwipeLayout", "onInterceptTouchEvent true");
            return true;
        }
        List<a> list = this.btO;
        if (list == null || list.isEmpty() || !k(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.btN;
        if (aVar != null && aVar.c(this, motionEvent)) {
            c.d("HorizontalSwipeLayout", "handlerTouchEvent true");
            return true;
        }
        List<a> list = this.btO;
        if (list == null || list.isEmpty() || !l(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setTouchDetector(com.kwad.sdk.widget.swipe.a aVar) {
        this.btN = aVar;
    }

    public HorizontalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahL = 0;
        this.btO = new CopyOnWriteArrayList();
        init(context);
    }

    public HorizontalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahL = 0;
        this.btO = new CopyOnWriteArrayList();
        init(context);
    }
}
