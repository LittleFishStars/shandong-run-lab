package android.taobao.windvane.base;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f21200a;
    protected android.taobao.windvane.d.b b;

    public interface a {
        void a(Object obj);

        void a(String str, String str2);

        void b(Object obj);
    }

    public void a(Context context, android.taobao.windvane.d.b bVar) {
        this.f21200a = context;
        this.b = bVar;
    }

    public abstract void a(b bVar, a aVar);

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21201a;
        public String b;
        public int c;
        public String d;
        public String e;
        public String f;
        public JSONObject g;
        public String h;
        public String i;
        public String j;
        public int k;
        public boolean l;
        public boolean m;
        public boolean n;
        public JSONArray o;
        public boolean p;

        public b() {
            this.h = "";
            this.i = "both";
            this.j = "0";
            this.k = 9;
            this.l = true;
            this.m = true;
            this.n = false;
            this.o = null;
            this.p = false;
        }

        public b(b bVar) {
            this.h = "";
            this.i = "both";
            this.j = "0";
            this.k = 9;
            this.l = true;
            this.m = true;
            this.n = false;
            this.o = null;
            this.p = false;
            this.f21201a = bVar.f21201a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.o = bVar.o;
            this.m = bVar.m;
            this.n = bVar.n;
            this.p = bVar.p;
        }
    }
}
