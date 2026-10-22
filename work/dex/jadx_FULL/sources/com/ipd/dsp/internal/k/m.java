package com.ipd.dsp.internal.k;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.aliyun.openapiutil.Client;
import com.ipd.dsp.internal.d0.o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.d0.j<com.ipd.dsp.internal.f.f, String> f38383a = new com.ipd.dsp.internal.d0.j<>(1000);
    public final Pools.Pool<b> b = com.ipd.dsp.internal.e0.a.b(10, new a());

    public class a implements com.ipd.dsp.internal.e0.a.d<b> {
        public a() {
        }

        @Override // com.ipd.dsp.internal.e0.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance(Client.HASH_SHA256));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final class b implements com.ipd.dsp.internal.e0.a.f {
        public final MessageDigest f;
        public final com.ipd.dsp.internal.e0.c g = com.ipd.dsp.internal.e0.c.a();

        public b(MessageDigest messageDigest) {
            this.f = messageDigest;
        }

        @Override // com.ipd.dsp.internal.e0.a.f
        @NonNull
        public com.ipd.dsp.internal.e0.c b() {
            return this.g;
        }
    }

    public final String a(com.ipd.dsp.internal.f.f fVar) {
        b bVar = (b) com.ipd.dsp.internal.d0.m.a(this.b.acquire());
        try {
            fVar.a(bVar.f);
            return o.a(bVar.f.digest());
        } finally {
            this.b.release(bVar);
        }
    }

    public String b(com.ipd.dsp.internal.f.f fVar) {
        String strB;
        synchronized (this.f38383a) {
            strB = this.f38383a.b(fVar);
        }
        if (strB == null) {
            strB = a(fVar);
        }
        synchronized (this.f38383a) {
            this.f38383a.b(fVar, strB);
        }
        return strB;
    }
}
