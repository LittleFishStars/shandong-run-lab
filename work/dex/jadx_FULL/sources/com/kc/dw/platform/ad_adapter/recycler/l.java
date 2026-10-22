package com.kc.dw.platform.ad_adapter.recycler;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.view.TouchAdContainer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TouchAdContainer f39510a;
    public final i b;

    @Keep
    public class a extends com.kc.dw.platform.ad_adapter.recycler.a {
        public final l k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, View view, int i) {
            super(view, i);
            this.k = lVar;
        }

        @Override // com.kc.dw.platform.ad_adapter.recycler.a
        public void a(float f, float f2, long j, float f3, float f4, int i) {
            l lVar = this.k;
            i.a(lVar.b, lVar.f39510a, f, f2, j, f3, f4, i);
        }
    }

    @Keep
    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f39511a;

        public b(l lVar) {
            this.f39511a = lVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f39511a.b.c();
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                this.f39511a.b.getClass();
                float f = this.f39511a.b.s.getContext().getResources().getDisplayMetrics().density;
                float fMax = Math.max(Math.abs(this.f39511a.b.o - motionEvent.getRawX()), Math.abs(this.f39511a.b.p - motionEvent.getRawY()));
                if (fMax > this.f39511a.b.r) {
                    LogUtil.dev("i", "use rawXY");
                }
                i iVar = this.f39511a.b;
                iVar.r = (int) Math.max(iVar.r, fMax);
                l lVar = this.f39511a;
                i iVar2 = lVar.b;
                if (iVar2.r / f <= i.G) {
                    return false;
                }
                float f2 = iVar2.m;
                if (f2 <= 0.0f) {
                    return false;
                }
                float f3 = iVar2.n;
                if (f3 <= 0.0f) {
                    return false;
                }
                i.a(iVar2, lVar.f39510a, f2, f3, iVar2.t, motionEvent.getX(), motionEvent.getY(), this.f39511a.b.r);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public l(i iVar, TouchAdContainer touchAdContainer) {
        this.b = iVar;
        this.f39510a = touchAdContainer;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        View view;
        try {
            TouchAdContainer touchAdContainer = this.f39510a;
            if (touchAdContainer == null) {
                view = null;
                break;
            }
            try {
                view = (View) touchAdContainer.getParent();
                int i = 0;
                while (true) {
                    if (view != null && i < 10) {
                        if ((view instanceof RecyclerView) || (view instanceof ListView) || (view instanceof ScrollView) || (view instanceof NestedScrollView)) {
                            break;
                        } else if (view.getParent() instanceof View) {
                            view = (View) view.getParent();
                            i++;
                        }
                        e.printStackTrace();
                    }
                    view = null;
                    break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (view != null) {
                view.setOnTouchListener(new b(this));
                return;
            }
            try {
                this.b.s.setOnTouchListener(new a(this, this.f39510a.getChildAt(0), i.G));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
