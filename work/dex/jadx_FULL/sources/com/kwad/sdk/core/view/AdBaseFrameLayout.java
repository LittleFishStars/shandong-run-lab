package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.widget.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public class AdBaseFrameLayout extends FrameLayout implements e, g {
    private static final al.a baL = new al.a();
    private List<View.OnTouchListener> baJ;
    private d baK;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.baJ = new ArrayList();
        this.baK = new d();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.baJ.contains(onTouchListener)) {
            return;
        }
        this.baJ.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            com.kwad.sdk.service.d.gatherException(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.baJ.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.baJ.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            al.a aVar = baL;
            aVar.H(getWidth(), getHeight());
            aVar.j(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            baL.k(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.g
    @MainThread
    public al.a getTouchCoords() {
        return baL;
    }

    @Override // com.kwad.sdk.core.view.e
    @NonNull
    public d getWindowFocusChangeHelper() {
        return this.baK;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z);
        this.baK.j(this, z);
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baJ = new ArrayList();
        this.baK = new d();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baJ = new ArrayList();
        this.baK = new d();
    }
}
