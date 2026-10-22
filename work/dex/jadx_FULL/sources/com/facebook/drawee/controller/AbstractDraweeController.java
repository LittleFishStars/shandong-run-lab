package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.zj.adlib.ad3;
import com.zj.adlib.ax6;
import com.zj.adlib.bl3;
import com.zj.adlib.ch7;
import com.zj.adlib.h76;
import com.zj.adlib.un0;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f29966a = AbstractDraweeController.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Drawable f1580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataSource<T> f1581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DeferredReleaser f1582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DraweeEventTracker f1583a = new DraweeEventTracker();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ControllerListener<INFO> f1584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public GestureDetector f1585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SettableDraweeHierarchy f1586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ch7 f1587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f1590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1591a;

    @Nullable
    public Drawable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public T f1592b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1593b;
    public boolean c;
    public boolean d;

    public class a extends BaseDataSubscriber<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f1594a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1595a;

        public a(String str, boolean z) {
            this.f1594a = str;
            this.f1595a = z;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void b(DataSource<T> dataSource) {
            boolean zIsFinished = dataSource.isFinished();
            AbstractDraweeController.this.r(this.f1594a, dataSource, dataSource.getProgress(), zIsFinished);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<T> dataSource) {
            AbstractDraweeController.this.p(this.f1594a, dataSource, dataSource.c(), true);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<T> dataSource) {
            boolean zIsFinished = dataSource.isFinished();
            float progress = dataSource.getProgress();
            T result = dataSource.getResult();
            if (result != null) {
                AbstractDraweeController.this.q(this.f1594a, dataSource, result, progress, zIsFinished, this.f1595a);
            } else if (zIsFinished) {
                AbstractDraweeController.this.p(this.f1594a, dataSource, new NullPointerException(), true);
            }
        }
    }

    public static class b<INFO> extends bl3<INFO> {
        public static <INFO> b<INFO> n(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
            b<INFO> bVar = new b<>();
            bVar.g(controllerListener);
            bVar.g(controllerListener2);
            return bVar;
        }
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.f1582a = deferredReleaser;
        this.f1590a = executor;
        l(str, obj, true);
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void a() {
        if (ad3.R(2)) {
            ad3.X(f29966a, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f1589a, this.f1593b ? "request already submitted" : "request needs submit");
        }
        this.f1583a.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        ax6.i(this.f1586a);
        this.f1582a.c(this);
        this.f1591a = true;
        if (this.f1593b) {
            return;
        }
        submitRequest();
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean b() {
        if (ad3.R(2)) {
            ad3.W(f29966a, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f1589a);
        }
        if (!u()) {
            return false;
        }
        this.f1587a.d();
        this.f1586a.reset();
        submitRequest();
        return true;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public DraweeHierarchy c() {
        return this.f1586a;
    }

    public abstract Drawable createDrawable(T t);

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public Animatable d() {
        Object obj = this.b;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void e(@Nullable DraweeHierarchy draweeHierarchy) {
        if (ad3.R(2)) {
            ad3.X(f29966a, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f1589a, draweeHierarchy);
        }
        this.f1583a.a(draweeHierarchy != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.f1593b) {
            this.f1582a.c(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f1586a;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.f(null);
            this.f1586a = null;
        }
        if (draweeHierarchy != null) {
            ax6.d(draweeHierarchy instanceof SettableDraweeHierarchy);
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.f1586a = settableDraweeHierarchy2;
            settableDraweeHierarchy2.f(this.f1580a);
        }
    }

    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.f1584a;
        return controllerListener == null ? un0.g() : controllerListener;
    }

    @Nullable
    public Drawable getControllerOverlay() {
        return this.f1580a;
    }

    public abstract DataSource<T> getDataSource();

    @Nullable
    public GestureDetector getGestureDetector() {
        return this.f1585a;
    }

    public String getImageClass(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    public int getImageHash(@Nullable T t) {
        return System.identityHashCode(t);
    }

    @Nullable
    public abstract INFO getImageInfo(T t);

    @Nullable
    public ch7 getRetryManager() {
        return this.f1587a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i(ControllerListener<? super INFO> controllerListener) {
        ax6.i(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f1584a;
        if (controllerListener2 instanceof b) {
            ((b) controllerListener2).g(controllerListener);
        } else if (controllerListener2 != null) {
            this.f1584a = b.n(controllerListener2, controllerListener);
        } else {
            this.f1584a = controllerListener;
        }
    }

    public void initialize(String str, Object obj) {
        l(str, obj, false);
    }

    public Object j() {
        return this.f1588a;
    }

    public String k() {
        return this.f1589a;
    }

    public final void l(String str, Object obj, boolean z) {
        DeferredReleaser deferredReleaser;
        this.f1583a.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!z && (deferredReleaser = this.f1582a) != null) {
            deferredReleaser.c(this);
        }
        this.f1591a = false;
        s();
        this.d = false;
        ch7 ch7Var = this.f1587a;
        if (ch7Var != null) {
            ch7Var.a();
        }
        GestureDetector gestureDetector = this.f1585a;
        if (gestureDetector != null) {
            gestureDetector.a();
            this.f1585a.f(this);
        }
        ControllerListener<INFO> controllerListener = this.f1584a;
        if (controllerListener instanceof b) {
            ((b) controllerListener).h();
        } else {
            this.f1584a = null;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f1586a;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.f1586a.f(null);
            this.f1586a = null;
        }
        this.f1580a = null;
        if (ad3.R(2)) {
            ad3.X(f29966a, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f1589a, str);
        }
        this.f1589a = str;
        this.f1588a = obj;
    }

    public final boolean m(String str, DataSource<T> dataSource) {
        return str.equals(this.f1589a) && dataSource == this.f1581a && this.f1593b;
    }

    public final void n(String str, Throwable th) {
        if (ad3.R(2)) {
            ad3.Y(f29966a, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f1589a, str, th);
        }
    }

    public final void o(String str, T t) {
        if (ad3.R(2)) {
            ad3.a0(f29966a, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.f1589a, str, getImageClass(t), Integer.valueOf(getImageHash(t)));
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        if (ad3.R(2)) {
            ad3.W(f29966a, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f1589a);
        }
        this.f1583a.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.f1591a = false;
        this.f1582a.f(this);
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ad3.R(2)) {
            ad3.X(f29966a, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f1589a, motionEvent);
        }
        GestureDetector gestureDetector = this.f1585a;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.b() && !shouldHandleGesture()) {
            return false;
        }
        this.f1585a.d(motionEvent);
        return true;
    }

    public final void p(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        if (!m(str, dataSource)) {
            n("ignore_old_datasource @ onFailure", th);
            dataSource.a();
            return;
        }
        this.f1583a.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (!z) {
            n("intermediate_failed @ onFailure", th);
            getControllerListener().d(this.f1589a, th);
            return;
        }
        n("final_failed @ onFailure", th);
        this.f1581a = null;
        this.c = true;
        if (this.d && (drawable = this.b) != null) {
            this.f1586a.c(drawable, 1.0f, true);
        } else if (u()) {
            this.f1586a.e(th);
        } else {
            this.f1586a.b(th);
        }
        getControllerListener().e(this.f1589a, th);
    }

    public final void q(String str, DataSource<T> dataSource, @Nullable T t, float f, boolean z, boolean z2) {
        if (!m(str, dataSource)) {
            o("ignore_old_datasource @ onNewResult", t);
            releaseImage(t);
            dataSource.a();
            return;
        }
        this.f1583a.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable drawableCreateDrawable = createDrawable(t);
            T t2 = this.f1592b;
            Drawable drawable = this.b;
            this.f1592b = t;
            this.b = drawableCreateDrawable;
            try {
                if (z) {
                    o("set_final_result @ onNewResult", t);
                    this.f1581a = null;
                    this.f1586a.c(drawableCreateDrawable, 1.0f, z2);
                    getControllerListener().a(str, getImageInfo(t), d());
                } else {
                    o("set_intermediate_result @ onNewResult", t);
                    this.f1586a.c(drawableCreateDrawable, f, z2);
                    getControllerListener().f(str, getImageInfo(t));
                }
                if (drawable != null && drawable != drawableCreateDrawable) {
                    releaseDrawable(drawable);
                }
                if (t2 == null || t2 == t) {
                    return;
                }
                o("release_previous_result @ onNewResult", t2);
                releaseImage(t2);
            } catch (Throwable th) {
                if (drawable != null && drawable != drawableCreateDrawable) {
                    releaseDrawable(drawable);
                }
                if (t2 != null && t2 != t) {
                    o("release_previous_result @ onNewResult", t2);
                    releaseImage(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            o("drawable_failed @ onNewResult", t);
            releaseImage(t);
            p(str, dataSource, e, z);
        }
    }

    public final void r(String str, DataSource<T> dataSource, float f, boolean z) {
        if (!m(str, dataSource)) {
            n("ignore_old_datasource @ onProgress", null);
            dataSource.a();
        } else {
            if (z) {
                return;
            }
            this.f1586a.d(f, false);
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.f1583a.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        ch7 ch7Var = this.f1587a;
        if (ch7Var != null) {
            ch7Var.e();
        }
        GestureDetector gestureDetector = this.f1585a;
        if (gestureDetector != null) {
            gestureDetector.e();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f1586a;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        s();
    }

    public abstract void releaseDrawable(@Nullable Drawable drawable);

    public abstract void releaseImage(@Nullable T t);

    public final void s() {
        boolean z = this.f1593b;
        this.f1593b = false;
        this.c = false;
        DataSource<T> dataSource = this.f1581a;
        if (dataSource != null) {
            dataSource.a();
            this.f1581a = null;
        }
        Drawable drawable = this.b;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        this.b = null;
        T t = this.f1592b;
        if (t != null) {
            o("release", t);
            releaseImage(this.f1592b);
            this.f1592b = null;
        }
        if (z) {
            getControllerListener().c(this.f1589a);
        }
    }

    public void setControllerOverlay(@Nullable Drawable drawable) {
        this.f1580a = drawable;
        SettableDraweeHierarchy settableDraweeHierarchy = this.f1586a;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.f(drawable);
        }
    }

    public void setGestureDetector(@Nullable GestureDetector gestureDetector) {
        this.f1585a = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.f(this);
        }
    }

    public void setRetainImageOnFailure(boolean z) {
        this.d = z;
    }

    public void setRetryManager(@Nullable ch7 ch7Var) {
        this.f1587a = ch7Var;
    }

    public boolean shouldHandleGesture() {
        return u();
    }

    public void submitRequest() {
        this.f1583a.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        getControllerListener().b(this.f1589a, this.f1588a);
        this.f1586a.d(0.0f, true);
        this.f1593b = true;
        this.c = false;
        this.f1581a = getDataSource();
        if (ad3.R(2)) {
            ad3.X(f29966a, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f1589a, Integer.valueOf(System.identityHashCode(this.f1581a)));
        }
        this.f1581a.e(new a(this.f1589a, this.f1581a.b()), this.f1590a);
    }

    public void t(ControllerListener<? super INFO> controllerListener) {
        ax6.i(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f1584a;
        if (controllerListener2 instanceof b) {
            ((b) controllerListener2).m(controllerListener);
        } else if (controllerListener2 == controllerListener) {
            this.f1584a = null;
        }
    }

    public String toString() {
        return h76.f(this).g("isAttached", this.f1591a).g("isRequestSubmitted", this.f1593b).g("hasFetchFailed", this.c).d("fetchedImage", getImageHash(this.f1592b)).f("events", this.f1583a.toString()).toString();
    }

    public final boolean u() {
        ch7 ch7Var;
        return this.c && (ch7Var = this.f1587a) != null && ch7Var.g();
    }
}
