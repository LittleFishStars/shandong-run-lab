package com.zj.adlib;

import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.a;
import com.facebook.imagepipeline.memory.b;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class mu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayPool f43386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PooledByteBufferFactory f18306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f18307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b98 f18308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bj3 f18309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lu6 f18310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nw0 f18311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qu6 f18312a;

    public mu6(lu6 lu6Var) {
        this.f18310a = (lu6) ax6.i(lu6Var);
    }

    public nw0 a() {
        if (this.f18311a == null) {
            this.f18311a = new nw0(this.f18310a.d(), this.f18310a.a(), this.f18310a.b());
        }
        return this.f18311a;
    }

    public bj3 b() {
        if (this.f18309a == null) {
            this.f18309a = new bj3(this.f18310a.d(), this.f18310a.c());
        }
        return this.f18309a;
    }

    public int c() {
        return this.f18310a.c().e;
    }

    public b d() {
        if (this.f18307a == null) {
            this.f18307a = new b(this.f18310a.d(), this.f18310a.e(), this.f18310a.f());
        }
        return this.f18307a;
    }

    public PooledByteBufferFactory e() {
        if (this.f18306a == null) {
            this.f18306a = new gx5(d(), f());
        }
        return this.f18306a;
    }

    public qu6 f() {
        if (this.f18312a == null) {
            this.f18312a = new qu6(h());
        }
        return this.f18312a;
    }

    public b98 g() {
        if (this.f18308a == null) {
            this.f18308a = new b98(this.f18310a.d(), this.f18310a.c());
        }
        return this.f18308a;
    }

    public ByteArrayPool h() {
        if (this.f43386a == null) {
            this.f43386a = new a(this.f18310a.d(), this.f18310a.g(), this.f18310a.h());
        }
        return this.f43386a;
    }
}
