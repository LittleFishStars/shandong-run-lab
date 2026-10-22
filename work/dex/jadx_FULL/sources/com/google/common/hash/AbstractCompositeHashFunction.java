package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32118a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashFunction[] f6297a;

    public class a implements Hasher {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Hasher[] f6298a;

        public a(Hasher[] hasherArr) {
            this.f6298a = hasherArr;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: A */
        public Hasher m(short s) {
            for (Hasher hasher : this.f6298a) {
                hasher.m(s);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: B */
        public Hasher a(CharSequence charSequence) {
            for (Hasher hasher : this.f6298a) {
                hasher.a(charSequence);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: n */
        public Hasher b(boolean z) {
            for (Hasher hasher : this.f6298a) {
                hasher.b(z);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public <T> Hasher o(@ParametricNullness T t, Funnel<? super T> funnel) {
            for (Hasher hasher : this.f6298a) {
                hasher.o(t, funnel);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public HashCode p() {
            return AbstractCompositeHashFunction.this.b(this.f6298a);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: q */
        public Hasher h(byte[] bArr, int i, int i2) {
            for (Hasher hasher : this.f6298a) {
                hasher.h(bArr, i, i2);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: r */
        public Hasher g(byte b) {
            for (Hasher hasher : this.f6298a) {
                hasher.g(b);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: s */
        public Hasher d(char c) {
            for (Hasher hasher : this.f6298a) {
                hasher.d(c);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: t */
        public Hasher c(byte[] bArr) {
            for (Hasher hasher : this.f6298a) {
                hasher.c(bArr);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: u */
        public Hasher i(long j) {
            for (Hasher hasher : this.f6298a) {
                hasher.i(j);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: v */
        public Hasher f(double d) {
            for (Hasher hasher : this.f6298a) {
                hasher.f(d);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: w */
        public Hasher l(float f) {
            for (Hasher hasher : this.f6298a) {
                hasher.l(f);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: x */
        public Hasher j(int i) {
            for (Hasher hasher : this.f6298a) {
                hasher.j(i);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: y */
        public Hasher k(ByteBuffer byteBuffer) {
            int iPosition = byteBuffer.position();
            for (Hasher hasher : this.f6298a) {
                e.d(byteBuffer, iPosition);
                hasher.k(byteBuffer);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* JADX INFO: renamed from: z */
        public Hasher e(CharSequence charSequence, Charset charset) {
            for (Hasher hasher : this.f6298a) {
                hasher.e(charSequence, charset);
            }
            return this;
        }
    }

    public AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction hashFunction : hashFunctionArr) {
            i.E(hashFunction);
        }
        this.f6297a = hashFunctionArr;
    }

    public final Hasher a(Hasher[] hasherArr) {
        return new a(hasherArr);
    }

    public abstract HashCode b(Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.f6297a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i = 0; i < length; i++) {
            hasherArr[i] = this.f6297a[i].newHasher();
        }
        return a(hasherArr);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        i.d(i >= 0);
        int length = this.f6297a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = this.f6297a[i2].newHasher(i);
        }
        return a(hasherArr);
    }
}
