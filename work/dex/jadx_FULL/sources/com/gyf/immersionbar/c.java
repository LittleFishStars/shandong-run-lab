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
public final class c extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f32547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f6810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ImmersionCallback> f6811a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32548a = new c();
    }

    public static c b() {
        return b.f32548a;
    }

    public void a(ImmersionCallback immersionCallback) {
        if (immersionCallback == null) {
            return;
        }
        if (this.f6811a == null) {
            this.f6811a = new ArrayList<>();
        }
        if (this.f6811a.contains(immersionCallback)) {
            return;
        }
        this.f6811a.add(immersionCallback);
    }

    public void c(Application application) {
        Uri uriFor;
        this.f32547a = application;
        if (application == null || application.getContentResolver() == null || this.f6810a.booleanValue() || (uriFor = Settings.System.getUriFor(com.gyf.immersionbar.b.f6808g)) == null) {
            return;
        }
        this.f32547a.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f6810a = Boolean.TRUE;
    }

    public void d(ImmersionCallback immersionCallback) {
        ArrayList<ImmersionCallback> arrayList;
        if (immersionCallback == null || (arrayList = this.f6811a) == null) {
            return;
        }
        arrayList.remove(immersionCallback);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ArrayList<ImmersionCallback> arrayList;
        super.onChange(z);
        Application application = this.f32547a;
        if (application == null || application.getContentResolver() == null || (arrayList = this.f6811a) == null || arrayList.isEmpty()) {
            return;
        }
        int i = Settings.System.getInt(this.f32547a.getContentResolver(), com.gyf.immersionbar.b.f6808g, 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator<ImmersionCallback> it = this.f6811a.iterator();
        while (it.hasNext()) {
            it.next().a(i == 0, navigationBarType);
        }
    }

    public c() {
        super(new Handler(Looper.getMainLooper()));
        this.f6810a = Boolean.FALSE;
    }
}
