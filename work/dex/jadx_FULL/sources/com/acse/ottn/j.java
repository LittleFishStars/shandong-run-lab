package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f23063a = null;

    public interface a {
        void a(j jVar);

        void b(j jVar);

        void c(j jVar);

        void d(j jVar);
    }

    public abstract j a(long j);

    public abstract void a(Interpolator interpolator);

    public void a(a aVar) {
        if (this.f23063a == null) {
            this.f23063a = new ArrayList<>();
        }
        this.f23063a.add(aVar);
    }

    public void a(Object obj) {
    }

    public void b() {
    }

    public abstract void b(long j);

    public void b(a aVar) {
        ArrayList<a> arrayList = this.f23063a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
        if (this.f23063a.size() == 0) {
            this.f23063a = null;
        }
    }

    public abstract long c();

    public void cancel() {
    }

    public ArrayList<a> d() {
        return this.f23063a;
    }

    public abstract long e();

    public abstract boolean f();

    public boolean g() {
        return f();
    }

    public void h() {
        ArrayList<a> arrayList = this.f23063a;
        if (arrayList != null) {
            arrayList.clear();
            this.f23063a = null;
        }
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    @Override // 
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j clone() {
        try {
            j jVar = (j) super.clone();
            ArrayList<a> arrayList = this.f23063a;
            if (arrayList != null) {
                jVar.f23063a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    jVar.f23063a.add(arrayList.get(i));
                }
            }
            return jVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
