package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class f extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f32553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<OnNavigationBarListener> f6827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6828a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f32554a = new f();
    }

    public static f a() {
        return b.f32554a;
    }

    public void addOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener == null) {
            return;
        }
        if (this.f6827a == null) {
            this.f6827a = new ArrayList<>();
        }
        if (this.f6827a.contains(onNavigationBarListener)) {
            return;
        }
        this.f6827a.add(onNavigationBarListener);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    public void b(Application application) {
        Uri uriFor;
        Uri uriFor2;
        this.f32553a = application;
        if (application == null || application.getContentResolver() == null || this.f6828a) {
            return;
        }
        Uri uriFor3 = null;
        if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
            if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                uriFor = Settings.Global.getUriFor(com.gyf.immersionbar.b.f6806e);
                uriFor2 = null;
                uriFor3 = Settings.Global.getUriFor(com.gyf.immersionbar.b.f6807f);
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                uriFor = Settings.Secure.getUriFor(com.gyf.immersionbar.b.f6809h);
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                uriFor = Settings.Secure.getUriFor(com.gyf.immersionbar.b.i);
            } else if (!OSUtils.isSamsung()) {
                uriFor = Settings.Secure.getUriFor(com.gyf.immersionbar.b.n);
            } else if (Settings.Global.getInt(this.f32553a.getContentResolver(), com.gyf.immersionbar.b.m, -1) == -1) {
                uriFor = Settings.Global.getUriFor(com.gyf.immersionbar.b.j);
                uriFor3 = Settings.Global.getUriFor(com.gyf.immersionbar.b.k);
                uriFor2 = Settings.Global.getUriFor(com.gyf.immersionbar.b.l);
            } else {
                uriFor = Settings.Global.getUriFor(com.gyf.immersionbar.b.m);
            }
            if (uriFor != null) {
                this.f32553a.getContentResolver().registerContentObserver(uriFor, true, this);
                this.f6828a = true;
            }
            if (uriFor3 != null) {
                this.f32553a.getContentResolver().registerContentObserver(uriFor3, true, this);
            }
            if (uriFor2 != null) {
                this.f32553a.getContentResolver().registerContentObserver(uriFor2, true, this);
            }
        }
        uriFor = !OSUtils.isEMUI3_x() ? Settings.Global.getUriFor(com.gyf.immersionbar.b.f6808g) : Settings.System.getUriFor(com.gyf.immersionbar.b.f6808g);
        uriFor2 = null;
        if (uriFor != null) {
            this.f32553a.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f6828a = true;
        }
        if (uriFor3 != null) {
            this.f32553a.getContentResolver().registerContentObserver(uriFor3, true, this);
        }
        if (uriFor2 != null) {
            this.f32553a.getContentResolver().registerContentObserver(uriFor2, true, this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        ArrayList<OnNavigationBarListener> arrayList = this.f6827a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        d.a aVarA = d.a(this.f32553a);
        boolean z2 = true;
        if (aVarA.f6812a && (!aVarA.b || com.gyf.immersionbar.a.f(this.f32553a) <= 0)) {
            z2 = false;
        }
        Iterator<OnNavigationBarListener> it = this.f6827a.iterator();
        while (it.hasNext()) {
            it.next().a(z2, aVarA.f32549a);
        }
    }

    public void removeOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        ArrayList<OnNavigationBarListener> arrayList;
        if (onNavigationBarListener == null || (arrayList = this.f6827a) == null) {
            return;
        }
        arrayList.remove(onNavigationBarListener);
    }

    public f() {
        super(new Handler(Looper.getMainLooper()));
        this.f6828a = false;
    }
}
