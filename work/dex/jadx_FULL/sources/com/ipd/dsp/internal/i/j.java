package com.ipd.dsp.internal.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f38333a = new a();
    public static final j b = new b();
    public static final j c = new c();
    public static final j d = new d();
    public static final j e = new e();

    public class a extends j {
        @Override // com.ipd.dsp.internal.i.j
        public boolean a() {
            return true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(com.ipd.dsp.internal.f.a aVar) {
            return aVar == com.ipd.dsp.internal.f.a.REMOTE;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean b() {
            return true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar) {
            return (aVar == com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE || aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE) ? false : true;
        }
    }

    public class b extends j {
        @Override // com.ipd.dsp.internal.i.j
        public boolean a() {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(com.ipd.dsp.internal.f.a aVar) {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar) {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean b() {
            return false;
        }
    }

    public class c extends j {
        @Override // com.ipd.dsp.internal.i.j
        public boolean a() {
            return true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(com.ipd.dsp.internal.f.a aVar) {
            return (aVar == com.ipd.dsp.internal.f.a.DATA_DISK_CACHE || aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar) {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean b() {
            return false;
        }
    }

    public class d extends j {
        @Override // com.ipd.dsp.internal.i.j
        public boolean a() {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(com.ipd.dsp.internal.f.a aVar) {
            return false;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar) {
            return (aVar == com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE || aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean b() {
            return true;
        }
    }

    public class e extends j {
        @Override // com.ipd.dsp.internal.i.j
        public boolean a() {
            return true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(com.ipd.dsp.internal.f.a aVar) {
            return aVar == com.ipd.dsp.internal.f.a.REMOTE;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean b() {
            return true;
        }

        @Override // com.ipd.dsp.internal.i.j
        public boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar) {
            return ((z && aVar == com.ipd.dsp.internal.f.a.DATA_DISK_CACHE) || aVar == com.ipd.dsp.internal.f.a.LOCAL) && cVar == com.ipd.dsp.internal.f.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(com.ipd.dsp.internal.f.a aVar);

    public abstract boolean a(boolean z, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.c cVar);

    public abstract boolean b();
}
