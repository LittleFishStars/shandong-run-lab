package com.acse.ottn;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k3<View, Float> f23066a = new f("alpha");
    public static k3<View, Float> b = new g("pivotX");
    public static k3<View, Float> c = new h("pivotY");
    public static k3<View, Float> d = new i("translationX");
    public static k3<View, Float> e = new j("translationY");
    public static k3<View, Float> f = new k(Key.ROTATION);
    public static k3<View, Float> g = new l("rotationX");
    public static k3<View, Float> h = new m("rotationY");
    public static k3<View, Float> i = new n("scaleX");
    public static k3<View, Float> j = new a("scaleY");
    public static k3<View, Integer> k = new b("scrollX");
    public static k3<View, Integer> l = new c("scrollY");
    public static k3<View, Float> m = new d("x");
    public static k3<View, Float> n = new e("y");

    public class a extends k1<View> {
        public a(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).h(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).h());
        }
    }

    public class b extends z1<View> {
        public b(String str) {
            super(str);
        }

        @Override // com.acse.ottn.z1
        public void a(View view, int i) {
            com.acse.ottn.m.a(view).a(i);
        }

        @Override // com.acse.ottn.k3
        public Integer a(View view) {
            return Integer.valueOf(com.acse.ottn.m.a(view).i());
        }
    }

    public class c extends z1<View> {
        public c(String str) {
            super(str);
        }

        @Override // com.acse.ottn.z1
        public void a(View view, int i) {
            com.acse.ottn.m.a(view).b(i);
        }

        @Override // com.acse.ottn.k3
        public Integer a(View view) {
            return Integer.valueOf(com.acse.ottn.m.a(view).j());
        }
    }

    public class d extends k1<View> {
        public d(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).k(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).m());
        }
    }

    public class e extends k1<View> {
        public e(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).l(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).n());
        }
    }

    public class f extends k1<View> {
        public f(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).a(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).a());
        }
    }

    public class g extends k1<View> {
        public g(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).b(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).b());
        }
    }

    public class h extends k1<View> {
        public h(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).c(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).c());
        }
    }

    public class i extends k1<View> {
        public i(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).i(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).k());
        }
    }

    public class j extends k1<View> {
        public j(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).j(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).l());
        }
    }

    public class k extends k1<View> {
        public k(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).d(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).d());
        }
    }

    public class l extends k1<View> {
        public l(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).e(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).e());
        }
    }

    public class m extends k1<View> {
        public m(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).f(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).f());
        }
    }

    public class n extends k1<View> {
        public n(String str) {
            super(str);
        }

        @Override // com.acse.ottn.k1
        public void a(View view, float f) {
            com.acse.ottn.m.a(view).g(f);
        }

        @Override // com.acse.ottn.k3
        public Float a(View view) {
            return Float.valueOf(com.acse.ottn.m.a(view).g());
        }
    }
}
