package com.zj.adlib;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.drawee.controller.ControllerListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class bl3<INFO> implements ControllerListener<INFO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40774a = "FdingControllerListener";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<ControllerListener<? super INFO>> f15564a = new ArrayList(2);

    public static <INFO> bl3<INFO> i() {
        return new bl3<>();
    }

    public static <INFO> bl3<INFO> j(ControllerListener<? super INFO> controllerListener) {
        bl3<INFO> bl3VarI = i();
        bl3VarI.g(controllerListener);
        return bl3VarI;
    }

    public static <INFO> bl3<INFO> k(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        bl3<INFO> bl3VarI = i();
        bl3VarI.g(controllerListener);
        bl3VarI.g(controllerListener2);
        return bl3VarI;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void a(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).a(str, info, animatable);
            } catch (Exception e) {
                l("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void b(String str, Object obj) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).b(str, obj);
            } catch (Exception e) {
                l("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void c(String str) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).c(str);
            } catch (Exception e) {
                l("InternalListener exception in onRelease", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void d(String str, Throwable th) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).d(str, th);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void e(String str, Throwable th) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).e(str, th);
            } catch (Exception e) {
                l("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void f(String str, @Nullable INFO info) {
        int size = this.f15564a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f15564a.get(i).f(str, info);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    public synchronized void g(ControllerListener<? super INFO> controllerListener) {
        this.f15564a.add(controllerListener);
    }

    public synchronized void h() {
        this.f15564a.clear();
    }

    public final synchronized void l(String str, Throwable th) {
        Log.e(f40774a, str, th);
    }

    public synchronized void m(ControllerListener<? super INFO> controllerListener) {
        this.f15564a.remove(controllerListener);
    }
}
