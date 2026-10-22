package cj.mobile.p;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c {

    public class a implements Runnable {
        public a(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            cj.mobile.p.b.b("245DC3B3-A2D8-0993-9ECD-269B5F19B5BA");
        }
    }

    public class b implements Runnable {
        public b(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public void a() {
        cj.mobile.p.b.f22637a.execute(new b(this));
    }

    public void b() {
        cj.mobile.p.b.f22637a.execute(new a(this));
    }
}
