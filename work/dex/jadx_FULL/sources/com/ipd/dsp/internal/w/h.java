package com.ipd.dsp.internal.w;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.internal.q.z;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(26)
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Activity> f38581a = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean b;

    public class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f38582a;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.w.h$a$a, reason: collision with other inner class name */
        public class RunnableC0925a implements Runnable {
            public final /* synthetic */ ViewTreeObserver.OnDrawListener f;

            public RunnableC0925a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.f = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                z.c().g();
                h.this.b = true;
                h.a(a.this.f38582a, this.f);
                h.this.f38581a.clear();
            }
        }

        public a(View view) {
            this.f38582a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            com.ipd.dsp.internal.d0.o.a(new RunnableC0925a(this));
        }
    }

    @Override // com.ipd.dsp.internal.w.i
    public void a(Activity activity) {
        if (!this.b && this.f38581a.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
        }
    }

    public static void a(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }
}
