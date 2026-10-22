package com.acse.ottn;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b2 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f22880a;
    public Class b;
    public Interpolator c = null;
    public boolean d = false;

    public static class a extends b2 {
        public float e;

        public a(float f, float f2) {
            this.f22880a = f;
            this.e = f2;
            this.b = Float.TYPE;
            this.d = true;
        }

        @Override // com.acse.ottn.b2
        public Object e() {
            return Float.valueOf(this.e);
        }

        @Override // com.acse.ottn.b2
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a(b(), this.e);
            aVar.a(c());
            return aVar;
        }

        public float h() {
            return this.e;
        }

        @Override // com.acse.ottn.b2
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.e = ((Float) obj).floatValue();
            this.d = true;
        }

        public a(float f) {
            this.f22880a = f;
            this.b = Float.TYPE;
        }
    }

    public static class b extends b2 {
        public int e;

        public b(float f, int i) {
            this.f22880a = f;
            this.e = i;
            this.b = Integer.TYPE;
            this.d = true;
        }

        @Override // com.acse.ottn.b2
        public Object e() {
            return Integer.valueOf(this.e);
        }

        @Override // com.acse.ottn.b2
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = new b(b(), this.e);
            bVar.a(c());
            return bVar;
        }

        public int h() {
            return this.e;
        }

        @Override // com.acse.ottn.b2
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.e = ((Integer) obj).intValue();
            this.d = true;
        }

        public b(float f) {
            this.f22880a = f;
            this.b = Integer.TYPE;
        }
    }

    public static class c extends b2 {
        public Object e;

        public c(float f, Object obj) {
            this.f22880a = f;
            this.e = obj;
            boolean z = obj != null;
            this.d = z;
            this.b = z ? obj.getClass() : Object.class;
        }

        @Override // com.acse.ottn.b2
        public Object e() {
            return this.e;
        }

        @Override // com.acse.ottn.b2
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public c clone() {
            c cVar = new c(b(), this.e);
            cVar.a(c());
            return cVar;
        }

        @Override // com.acse.ottn.b2
        public void a(Object obj) {
            this.e = obj;
            this.d = obj != null;
        }
    }

    public static b2 a(float f, int i) {
        return new b(f, i);
    }

    public static b2 b(float f) {
        return new b(f);
    }

    public static b2 c(float f) {
        return new c(f, null);
    }

    @Override // 
    /* JADX INFO: renamed from: a */
    public abstract b2 clone();

    public abstract void a(Object obj);

    public void d(float f) {
        this.f22880a = f;
    }

    public abstract Object e();

    public boolean f() {
        return this.d;
    }

    public static b2 a(float f, float f2) {
        return new a(f, f2);
    }

    public float b() {
        return this.f22880a;
    }

    public Interpolator c() {
        return this.c;
    }

    public Class d() {
        return this.b;
    }

    public static b2 a(float f) {
        return new a(f);
    }

    public static b2 a(float f, Object obj) {
        return new c(f, obj);
    }

    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }
}
