package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.ba;
import com.beizi.fusion.df;
import com.beizi.fusion.fc;
import com.beizi.fusion.gc;
import com.beizi.fusion.gf;
import com.beizi.fusion.he;
import com.beizi.fusion.hf;
import com.beizi.fusion.ob;
import com.beizi.fusion.re;
import com.beizi.fusion.ub;
import com.beizi.fusion.va;
import com.beizi.fusion.xa;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeExpressContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fc f27039a;
    private final hf b;
    private final e c;
    private final ViewTreeObserver.OnGlobalLayoutListener d;
    private final ViewTreeObserver.OnScrollChangedListener e;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScopeExpressContainer.this.b();
        }
    }

    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ScopeExpressContainer.this.b();
        }
    }

    public class c implements gc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final gc f27042a;

        private c(gc gcVar) {
            this.f27042a = gcVar;
        }

        @Override // com.beizi.fusion.gc
        public void b(xa xaVar, View view) {
            e eVar;
            gc gcVar = this.f27042a;
            if (gcVar == null || (eVar = ScopeExpressContainer.this.c) == null) {
                return;
            }
            ScopeVideoView scopeVideoView = eVar.d;
            if (scopeVideoView == null) {
                gcVar.b(xaVar, view);
            } else if (scopeVideoView.alreadyPlay()) {
                this.f27042a.b(xaVar, view);
            }
        }

        @Override // com.beizi.fusion.gc
        public void c(xa xaVar, View view) {
            ScopeExpressContainer.this.d(true);
            gc gcVar = this.f27042a;
            if (gcVar != null) {
                gcVar.c(xaVar, view);
            }
        }

        @Override // com.beizi.fusion.ya
        public void a(fc fcVar) {
            this.f27042a.a(fcVar);
        }

        @Override // com.beizi.fusion.gc
        public void a(View view) {
            ScopeExpressContainer.this.c(true);
            gc gcVar = this.f27042a;
            if (gcVar != null) {
                gcVar.a(view);
            }
        }

        @Override // com.beizi.fusion.gc
        public void b(View view) {
            gc gcVar = this.f27042a;
            if (gcVar != null) {
                gcVar.b(view);
            }
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup f27043a;
        private ub b;
        private String c;
        private ScopeVideoView d;
        private ob e;
        private final List f;
        private final List g;

        private e() {
            this.f = new ArrayList();
            this.g = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.c = "";
            this.d = null;
            this.e = null;
            this.f27043a = null;
            this.f.clear();
            this.g.clear();
        }
    }

    public ScopeExpressContainer(@NonNull Context context) {
        super(context.getApplicationContext());
        this.d = new a();
        this.e = new b();
        this.f27039a = new fc(this);
        this.b = hf.a.a();
        a();
        this.c = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z = false;
        if (!isShown()) {
            b(false);
            return;
        }
        Rect rect = new Rect();
        if (getLocalVisibleRect(rect) && rect.width() > 0 && rect.height() > 0) {
            z = true;
        }
        b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewPause(z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewResume(z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hf getViewRecorder() {
        return this.b;
    }

    public void a(ReportModel3 reportModel3, gc gcVar, gf gfVar) {
        this.f27039a.a(reportModel3);
        this.f27039a.a((gc) new c(gcVar));
        ScopeVideoView scopeVideoView = this.c.d;
        if (scopeVideoView != null) {
            scopeVideoView.registerVideoObserver(gfVar);
        }
        ob obVar = this.c.e;
        if (obVar != null) {
            obVar.registerAsVideoObserver(gfVar);
        }
    }

    public va getMonitor() {
        return this.f27039a;
    }

    public void onActivityPause() {
        this.f27039a.b();
        c(false);
    }

    public void onActivityResume() {
        this.f27039a.a();
        d(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f27039a.a();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnScrollChangedListener(this.e);
        viewTreeObserver.addOnGlobalLayoutListener(this.d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f27039a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.removeOnScrollChangedListener(this.e);
        viewTreeObserver.removeOnGlobalLayoutListener(this.d);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.b.a(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onViewDestroy() {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt instanceof he) {
                    ((he) childAt).onViewDestroy();
                }
            }
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void removeFromParent() {
        d.a((View) this);
    }

    public <C extends ba> void setVideoConfig(C c2) {
        ScopeVideoView scopeVideoView = this.c.d;
        if (scopeVideoView == null || c2 == null) {
            return;
        }
        scopeVideoView.setMediaConfig(c2.e());
    }

    public static final class d {
        public static void a(View view) {
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            }
        }

        public static ub b(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return null;
            }
            return eVar.b;
        }

        public static List c(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            return (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) ? new ArrayList() : eVar.f;
        }

        public static List d(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            return (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) ? new ArrayList() : eVar.g;
        }

        public static ScopeVideoView e(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return null;
            }
            return eVar.d;
        }

        public static hf f(ScopeExpressContainer scopeExpressContainer) {
            return scopeExpressContainer.getViewRecorder();
        }

        public static ViewGroup g(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return null;
            }
            return eVar.f27043a;
        }

        public static void h(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            ob obVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || (obVar = eVar.e) == null) {
                return;
            }
            obVar.pauseCarousel();
        }

        public static void i(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            ob obVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || (obVar = eVar.e) == null) {
                return;
            }
            obVar.startCarousel();
        }

        public static void j(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            ob obVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || (obVar = eVar.e) == null) {
                return;
            }
            obVar.nextCarousel();
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, ReportModel3 reportModel3, gc gcVar, gf gfVar) {
            if (scopeExpressContainer != null) {
                scopeExpressContainer.a(reportModel3, gcVar, gfVar);
            }
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, ScopeVideoView scopeVideoView) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || scopeVideoView == null) {
                return;
            }
            eVar.d = scopeVideoView;
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, ob obVar) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || obVar == null) {
                return;
            }
            eVar.e = obVar;
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, ViewGroup viewGroup) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null || viewGroup == null) {
                return;
            }
            eVar.f27043a = viewGroup;
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, String str) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return;
            }
            eVar.c = str;
        }

        public static String a(ScopeExpressContainer scopeExpressContainer) {
            e eVar;
            return (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) ? "" : eVar.c;
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, View view) {
            if (scopeExpressContainer == null || scopeExpressContainer.c == null) {
                return;
            }
            scopeExpressContainer.a(view);
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, ub ubVar) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return;
            }
            eVar.b = ubVar;
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, re reVar) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return;
            }
            eVar.f.add(reVar);
        }

        public static void a(ScopeExpressContainer scopeExpressContainer, df dfVar) {
            e eVar;
            if (scopeExpressContainer == null || (eVar = scopeExpressContainer.c) == null) {
                return;
            }
            eVar.g.add(dfVar);
        }
    }

    private void a() {
        getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.zj.adlib.rw7
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f44556a.a(z);
            }
        });
    }

    private void b(boolean z) {
        if (z) {
            d(true);
            this.f27039a.a();
        } else {
            c(true);
        }
    }

    public ScopeExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.d = new a();
        this.e = new b();
        this.f27039a = new fc(this);
        this.b = hf.a.a();
        a();
        this.c = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            onActivityResume();
        } else {
            onActivityPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        ob obVar = this.c.e;
        if (obVar != null) {
            obVar.addCarouseItemView(view);
        }
    }

    public ScopeExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        this.d = new a();
        this.e = new b();
        this.f27039a = new fc(this);
        this.b = hf.a.a();
        a();
        this.c = new e();
    }

    public ScopeExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context.getApplicationContext(), attributeSet, i, i2);
        this.d = new a();
        this.e = new b();
        this.f27039a = new fc(this);
        this.b = hf.a.a();
        a();
        this.c = new e();
    }
}
