package com.beizi.fusion;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f27098a;
    protected final int b;
    protected final float[] c;
    protected final long d;
    protected final d e;
    protected final lm f;
    private final List g;
    private final ScopeVideoView.d h;
    private final Map i;

    public static class a implements ScopeVideoView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27099a;
        private final boolean b;
        private final int c;
        private final boolean d;

        private a(c cVar) {
            this.f27099a = cVar.i;
            this.b = cVar.h;
            this.c = cVar.g;
            this.d = cVar.j;
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.d
        public boolean a() {
            return this.f27099a;
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.d
        public boolean b() {
            return this.d;
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.d
        public boolean c() {
            return this.b;
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.d
        public int d() {
            return this.c;
        }
    }

    public enum b {
        ALWAYS(0),
        WIFI_ONLY(1),
        NEVER(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27100a;

        b(int i) {
            this.f27100a = i;
        }

        public int b() {
            return this.f27100a;
        }
    }

    public ba(c cVar) {
        this.f27098a = cVar.f27101a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.a();
        this.g = cVar.f;
        if (cVar.k != null) {
            this.i = new HashMap(cVar.k);
        } else {
            this.i = new HashMap();
        }
        if (TextUtils.isEmpty(cVar.e)) {
            this.f = null;
        } else {
            this.f = new lm(cVar.e);
        }
        this.h = new a(cVar);
    }

    public int a() {
        int i = this.b;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public d b() {
        return this.e;
    }

    public Map c() {
        return this.i;
    }

    public float[] d() {
        return this.c;
    }

    public ScopeVideoView.d e() {
        return this.h;
    }

    public lm f() {
        return this.f;
    }

    public String g() {
        return this.f27098a;
    }

    public long h() {
        return this.d;
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27101a;
        private int b;
        private long d;
        private String e;
        private List f;
        private Map k;
        private float[] c = {0.0f, 0.0f};
        private int g = b.ALWAYS.b();
        private boolean h = false;
        private boolean i = true;
        private boolean j = true;

        public abstract ba a(c cVar);

        public ba a(String str) {
            this.f27101a = str;
            return a(this);
        }

        public abstract d a();

        public c b(String str) {
            this.e = str;
            return this;
        }

        public c a(int i) {
            this.b = i;
            return this;
        }

        public c a(float f, float f2) {
            this.c = new float[]{f, f2};
            return this;
        }

        public c a(long j) {
            this.d = j;
            return this;
        }

        public c a(List list) {
            this.f = list;
            return this;
        }

        public c a(Map map) {
            this.k = map;
            return this;
        }
    }
}
