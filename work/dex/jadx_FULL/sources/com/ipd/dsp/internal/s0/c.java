package com.ipd.dsp.internal.s0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    public static final /* synthetic */ boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f38535a;
    public final b b;
    public Bundle c;

    public c(AppCompatActivity appCompatActivity) {
        String simpleName;
        int i;
        this.f38535a = appCompatActivity;
        Intent intent = appCompatActivity.getIntent();
        if (intent != null) {
            this.c = intent.getExtras();
        }
        try {
            Bundle bundle = this.c;
            if (bundle != null && (i = bundle.getInt("TB", -1)) > 0) {
                appCompatActivity.setTheme(i);
            }
        } catch (Throwable th) {
            Log.w("Dsp", th);
        }
        try {
            boolean z = d;
            if (!z && intent == null) {
                throw new AssertionError();
            }
            String stringExtra = intent.getStringExtra(b.b);
            if (!z && stringExtra == null) {
                throw new AssertionError();
            }
            Object objNewInstance = Class.forName(stringExtra).newInstance();
            if (objNewInstance instanceof b) {
                b bVar = (b) objNewInstance;
                this.b = bVar;
                bVar.a(this);
            } else {
                simpleName = "instanceof not matched";
                throw new RuntimeException("start activity error: " + simpleName);
            }
        } catch (ClassNotFoundException unused) {
            simpleName = "class not found";
        } catch (IllegalAccessException | InstantiationException unused2) {
            simpleName = "newInstance error";
        } catch (Throwable th2) {
            simpleName = th2.getClass().getSimpleName();
        }
    }

    public Activity a() {
        return this.f38535a;
    }

    public void b() {
        this.b.a(this.c);
    }

    public void c() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void d() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void e() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void f() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void g() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void h() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void i() {
        try {
            ActionBar supportActionBar = this.f38535a.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeButtonEnabled(true);
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(int i, int i2, Intent intent) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, i2, intent);
        }
    }

    public boolean a(MenuItem menuItem) {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.a(menuItem);
        }
        return false;
    }

    public boolean a(int i) {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.a(i);
        }
        return false;
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, strArr, iArr);
        }
    }

    public void a(Throwable th) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(th);
        }
    }
}
