package com.byazt.g;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.byazt.w.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 954, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f28548a;
    public Application c;
    public WeakReference<Activity> n;
    public volatile boolean sp;
    public ve tt;
    public int uj;
    public final List<InterfaceC0409c> ve;
    public final Application.ActivityLifecycleCallbacks x;

    /* JADX INFO: renamed from: com.byazt.g.c$c, reason: collision with other inner class name */
    public interface InterfaceC0409c {
        @MainThread
        void tt();

        @MainThread
        void ve();
    }

    @com.byazt.zqa.c(c = {0, 1, 954, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public static final c c = new c();
    }

    public interface ve {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f28548a = 0;
        Object[] objArrUj = uj();
        if (objArrUj != null) {
            for (Object obj : objArrUj) {
                ((InterfaceC0409c) obj).ve();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f28548a = 1;
        Object[] objArrUj = uj();
        if (objArrUj != null) {
            for (Object obj : objArrUj) {
                ((InterfaceC0409c) obj).tt();
            }
        }
    }

    private boolean sp() {
        try {
            Application application = this.c;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), a.uj(application));
        } catch (Throwable th) {
            m.c(th);
            return false;
        }
    }

    private Object[] uj() {
        Object[] array;
        synchronized (this.ve) {
            array = this.ve.size() > 0 ? this.ve.toArray() : null;
        }
        return array;
    }

    private c() {
        this.ve = new ArrayList();
        this.f28548a = -1;
        this.sp = false;
        this.x = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.g.c.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                c.this.sp = true;
                if (c.this.uj != 0 || activity == null) {
                    return;
                }
                c.this.uj = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = c.this.uj;
                c.this.sp = false;
                c.this.uj = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    c.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                c.this.n = new WeakReference(activity);
                int i = c.this.uj;
                c.this.uj = activity != null ? activity.hashCode() : i;
                c.this.sp = false;
                if (i == 0) {
                    c.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == c.this.uj) {
                    c.this.uj = 0;
                    c.this.a();
                }
                c.this.sp = false;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean tt() {
        int i = this.f28548a;
        ?? r0 = i;
        if (i == -1) {
            ?? Sp = sp();
            this.f28548a = Sp;
            r0 = Sp;
        }
        return r0 == 1;
    }

    public boolean ve() {
        return tt() && !this.sp;
    }

    public static c c() {
        return tt.c;
    }

    public void tt(InterfaceC0409c interfaceC0409c) {
        synchronized (this.ve) {
            this.ve.remove(interfaceC0409c);
        }
    }

    public void c(Context context) {
        if (this.c == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.c == null) {
                    Application application = (Application) context;
                    this.c = application;
                    application.registerActivityLifecycleCallbacks(this.x);
                }
            }
        }
    }

    public void c(ve veVar) {
        this.tt = veVar;
    }

    public void c(InterfaceC0409c interfaceC0409c) {
        if (interfaceC0409c == null) {
            return;
        }
        synchronized (this.ve) {
            if (!this.ve.contains(interfaceC0409c)) {
                this.ve.add(interfaceC0409c);
            }
        }
    }
}
