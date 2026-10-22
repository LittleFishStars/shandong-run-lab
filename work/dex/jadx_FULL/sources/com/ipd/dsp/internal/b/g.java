package com.ipd.dsp.internal.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.a0.r;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.i.j;
import com.ipd.dsp.internal.z.k;
import com.ipd.dsp.internal.z.l;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g<TranscodeType> extends com.ipd.dsp.internal.z.a<g<TranscodeType>> implements Cloneable, d<g<TranscodeType>> {
    public static final com.ipd.dsp.internal.z.i o0 = new com.ipd.dsp.internal.z.i().a(j.c).a(e.LOW).b(true);
    public final Context a0;
    public final h b0;
    public final Class<TranscodeType> c0;
    public final com.ipd.dsp.internal.components.glide.a d0;
    public final com.ipd.dsp.internal.components.glide.c e0;

    @NonNull
    public i<?, ? super TranscodeType> f0;

    @Nullable
    public Object g0;

    @Nullable
    public List<com.ipd.dsp.internal.z.h<TranscodeType>> h0;

    @Nullable
    public g<TranscodeType> i0;

    @Nullable
    public g<TranscodeType> j0;

    @Nullable
    public Float k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38192a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[e.values().length];
            b = iArr;
            try {
                iArr[e.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[e.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[e.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[e.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f38192a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38192a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38192a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38192a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38192a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38192a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38192a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38192a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public g(@NonNull com.ipd.dsp.internal.components.glide.a aVar, h hVar, Class<TranscodeType> cls, Context context) {
        this.l0 = true;
        this.d0 = aVar;
        this.b0 = hVar;
        this.c0 = cls;
        this.a0 = context;
        this.f0 = hVar.b((Class) cls);
        this.e0 = aVar.h();
        a(hVar.h());
        c((com.ipd.dsp.internal.z.a<?>) hVar.i());
    }

    public final g<TranscodeType> T() {
        return mo997clone().b((g) null).c((g) null);
    }

    @NonNull
    @CheckResult
    public g<File> U() {
        return new g(File.class, this).c((com.ipd.dsp.internal.z.a<?>) o0);
    }

    public Object V() {
        return this.g0;
    }

    public h W() {
        return this.b0;
    }

    @NonNull
    public p<TranscodeType> X() {
        return e(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public com.ipd.dsp.internal.z.d<TranscodeType> Y() {
        return f(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.ipd.dsp.internal.z.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.ipd.dsp.internal.z.a a(@NonNull com.ipd.dsp.internal.z.a aVar) {
        return c((com.ipd.dsp.internal.z.a<?>) aVar);
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> b(@Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar) {
        if (B()) {
            return mo997clone().b((com.ipd.dsp.internal.z.h) hVar);
        }
        this.h0 = null;
        return a((com.ipd.dsp.internal.z.h) hVar);
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> c(@NonNull com.ipd.dsp.internal.z.a<?> aVar) {
        m.a(aVar);
        return (g) super.a(aVar);
    }

    @NonNull
    public final g<TranscodeType> d(@Nullable Object obj) {
        if (B()) {
            return mo997clone().d(obj);
        }
        this.g0 = obj;
        this.m0 = true;
        return S();
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable Drawable drawable) {
        return d((Object) drawable).c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.b(j.b));
    }

    @Override // com.ipd.dsp.internal.z.a
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (super.equals(gVar) && Objects.equals(this.c0, gVar.c0) && this.f0.equals(gVar.f0) && Objects.equals(this.g0, gVar.g0) && Objects.equals(this.h0, gVar.h0) && Objects.equals(this.i0, gVar.i0) && Objects.equals(this.j0, gVar.j0) && Objects.equals(this.k0, gVar.k0) && this.l0 == gVar.l0 && this.m0 == gVar.m0) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public com.ipd.dsp.internal.z.d<TranscodeType> f(int i, int i2) {
        com.ipd.dsp.internal.z.g gVar = new com.ipd.dsp.internal.z.g(i, i2);
        return (com.ipd.dsp.internal.z.d) a(gVar, gVar, com.ipd.dsp.internal.d0.f.a());
    }

    @Override // com.ipd.dsp.internal.z.a
    public int hashCode() {
        return o.a(this.m0, o.a(this.l0, o.a(this.k0, o.a(this.j0, o.a(this.i0, o.a(this.h0, o.a(this.g0, o.a(this.f0, o.a(this.c0, super.hashCode())))))))));
    }

    @NonNull
    public p<TranscodeType> e(int i, int i2) {
        return b(com.ipd.dsp.internal.a0.m.a(this.b0, i, i2));
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> c(@Nullable g<TranscodeType> gVar) {
        if (B()) {
            return mo997clone().c((g) gVar);
        }
        this.i0 = gVar;
        return S();
    }

    @Override // com.ipd.dsp.internal.z.a
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public g<TranscodeType> mo997clone() {
        g<TranscodeType> gVar = (g) super.mo997clone();
        gVar.f0 = gVar.f0.m998clone();
        if (gVar.h0 != null) {
            gVar.h0 = new ArrayList(gVar.h0);
        }
        g<TranscodeType> gVar2 = gVar.i0;
        if (gVar2 != null) {
            gVar.i0 = gVar2.mo997clone();
        }
        g<TranscodeType> gVar3 = gVar.j0;
        if (gVar3 != null) {
            gVar.j0 = gVar3.mo997clone();
        }
        return gVar;
    }

    @NonNull
    public g<TranscodeType> b(@Nullable g<TranscodeType> gVar) {
        if (B()) {
            return mo997clone().b((g) gVar);
        }
        this.j0 = gVar;
        return S();
    }

    @Deprecated
    public com.ipd.dsp.internal.z.d<TranscodeType> d(int i, int i2) {
        return f(i, i2);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable Object obj) {
        return d(obj);
    }

    @CheckResult
    @Deprecated
    public com.ipd.dsp.internal.z.d<File> c(int i, int i2) {
        return U().f(i, i2);
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> b(Object obj) {
        if (obj == null) {
            return b((g) null);
        }
        return b((g) T().a(obj));
    }

    @SuppressLint({"CheckResult"})
    public g(Class<TranscodeType> cls, g<?> gVar) {
        this(gVar.d0, gVar.b0, cls, gVar.a0);
        this.g0 = gVar.g0;
        this.m0 = gVar.m0;
        c((com.ipd.dsp.internal.z.a<?>) gVar);
    }

    @SuppressLint({"CheckResult"})
    public final void a(List<com.ipd.dsp.internal.z.h<Object>> list) {
        Iterator<com.ipd.dsp.internal.z.h<Object>> it = list.iterator();
        while (it.hasNext()) {
            a((com.ipd.dsp.internal.z.h) it.next());
        }
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> b(@Nullable List<g<TranscodeType>> list) {
        g<TranscodeType> gVarC = null;
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                g<TranscodeType> gVar = list.get(size);
                if (gVar != null) {
                    gVarC = gVarC == null ? gVar : gVar.c((g) gVarC);
                }
            }
            return c((g) gVarC);
        }
        return c((g) null);
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> a(@NonNull i<?, ? super TranscodeType> iVar) {
        if (B()) {
            return mo997clone().a((i) iVar);
        }
        this.f0 = (i) m.a(iVar);
        this.l0 = false;
        return S();
    }

    @NonNull
    @CheckResult
    @Deprecated
    public g<TranscodeType> b(float f) {
        if (B()) {
            return mo997clone().b(f);
        }
        if (f >= 0.0f && f <= 1.0f) {
            this.k0 = Float.valueOf(f);
            return S();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> a(@Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar) {
        if (B()) {
            return mo997clone().a((com.ipd.dsp.internal.z.h) hVar);
        }
        if (hVar != null) {
            if (this.h0 == null) {
                this.h0 = new ArrayList();
            }
            this.h0.add(hVar);
        }
        return S();
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable Bitmap bitmap) {
        return d(bitmap).c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.b(j.b));
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable String str) {
        return d(str);
    }

    @NonNull
    @CheckResult
    public g<TranscodeType> a(@Nullable g<TranscodeType>... gVarArr) {
        if (gVarArr != null && gVarArr.length != 0) {
            return b((List) Arrays.asList(gVarArr));
        }
        return c((g) null);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable Uri uri) {
        return a(uri, d(uri));
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable File file) {
        return d(file);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable @DrawableRes @RawRes Integer num) {
        return a((g) d(num));
    }

    public final g<TranscodeType> a(@Nullable Uri uri, g<TranscodeType> gVar) {
        return (uri == null || !com.google.android.exoplayer2.upstream.c.h.equals(uri.getScheme())) ? gVar : a((g) gVar);
    }

    @Override // com.ipd.dsp.internal.b.d
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable URL url) {
        return d(url);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TranscodeType> a(@Nullable byte[] bArr) {
        g<TranscodeType> gVarD = d(bArr);
        if (!gVarD.C()) {
            gVarD = gVarD.c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.b(j.b));
        }
        return !gVarD.H() ? gVarD.c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.e(true)) : gVarD;
    }

    public final g<TranscodeType> a(g<TranscodeType> gVar) {
        return gVar.a(this.a0.getTheme()).a(com.ipd.dsp.internal.c0.a.a(this.a0));
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y a(@NonNull Y y, @Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar, Executor executor) {
        return (Y) b(y, hVar, this, executor);
    }

    public final boolean a(com.ipd.dsp.internal.z.a<?> aVar, com.ipd.dsp.internal.z.e eVar) {
        return !aVar.E() && eVar.e();
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y b(@NonNull Y y) {
        return (Y) a(y, (com.ipd.dsp.internal.z.h) null, com.ipd.dsp.internal.d0.f.b());
    }

    @NonNull
    public r<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        com.ipd.dsp.internal.z.a aVarN;
        o.b();
        m.a(imageView);
        if (!K() && I() && imageView.getScaleType() != null) {
            switch (a.f38192a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarN = mo997clone().N();
                    break;
                case 2:
                    aVarN = mo997clone().O();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarN = mo997clone().Q();
                    break;
                case 6:
                    aVarN = mo997clone().O();
                    break;
                default:
                    aVarN = this;
                    break;
            }
        } else {
            aVarN = this;
        }
        return (r) b(this.e0.a(imageView, this.c0), null, aVarN, com.ipd.dsp.internal.d0.f.b());
    }

    public final <Y extends p<TranscodeType>> Y b(@NonNull Y y, @Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar, com.ipd.dsp.internal.z.a<?> aVar, Executor executor) {
        m.a(y);
        if (this.m0) {
            com.ipd.dsp.internal.z.e eVarA = a(y, hVar, aVar, executor);
            com.ipd.dsp.internal.z.e request = y.getRequest();
            if (eVarA.c(request) && !a(aVar, request)) {
                if (!((com.ipd.dsp.internal.z.e) m.a(request)).isRunning()) {
                    request.d();
                }
                return y;
            }
            this.b0.a((p<?>) y);
            y.setRequest(eVarA);
            this.b0.a(y, eVarA);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public final e b(@NonNull e eVar) {
        int i = a.b[eVar.ordinal()];
        if (i == 1) {
            return e.NORMAL;
        }
        if (i == 2) {
            return e.HIGH;
        }
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException("unknown priority: " + t());
        }
        return e.IMMEDIATE;
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y a(@NonNull Y y) {
        return (Y) U().b(y);
    }

    public final com.ipd.dsp.internal.z.e a(p<TranscodeType> pVar, @Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar, com.ipd.dsp.internal.z.a<?> aVar, Executor executor) {
        return a(new Object(), pVar, hVar, (com.ipd.dsp.internal.z.f) null, this.f0, aVar.t(), aVar.q(), aVar.p(), aVar, executor);
    }

    public final com.ipd.dsp.internal.z.e b(Object obj, p<TranscodeType> pVar, com.ipd.dsp.internal.z.h<TranscodeType> hVar, @Nullable com.ipd.dsp.internal.z.f fVar, i<?, ? super TranscodeType> iVar, e eVar, int i, int i2, com.ipd.dsp.internal.z.a<?> aVar, Executor executor) {
        e eVarB;
        g<TranscodeType> gVar = this.i0;
        if (gVar != null) {
            if (!this.n0) {
                i<?, ? super TranscodeType> iVar2 = gVar.l0 ? iVar : gVar.f0;
                if (gVar.F()) {
                    eVarB = this.i0.t();
                } else {
                    eVarB = b(eVar);
                }
                e eVar2 = eVarB;
                int iQ = this.i0.q();
                int iP = this.i0.p();
                if (o.b(i, i2) && !this.i0.L()) {
                    iQ = aVar.q();
                    iP = aVar.p();
                }
                l lVar = new l(obj, fVar);
                com.ipd.dsp.internal.z.e eVarA = a(obj, pVar, hVar, aVar, lVar, iVar, eVar, i, i2, executor);
                this.n0 = true;
                g<TranscodeType> gVar2 = this.i0;
                com.ipd.dsp.internal.z.e eVarA2 = gVar2.a(obj, pVar, hVar, lVar, iVar2, eVar2, iQ, iP, gVar2, executor);
                this.n0 = false;
                lVar.a(eVarA, eVarA2);
                return lVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.k0 != null) {
            l lVar2 = new l(obj, fVar);
            lVar2.a(a(obj, pVar, hVar, aVar, lVar2, iVar, eVar, i, i2, executor), a(obj, pVar, hVar, aVar.mo997clone().a(this.k0.floatValue()), lVar2, iVar, b(eVar), i, i2, executor));
            return lVar2;
        }
        return a(obj, pVar, hVar, aVar, fVar, iVar, eVar, i, i2, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.ipd.dsp.internal.z.e a(Object obj, p<TranscodeType> pVar, @Nullable com.ipd.dsp.internal.z.h<TranscodeType> hVar, @Nullable com.ipd.dsp.internal.z.f fVar, i<?, ? super TranscodeType> iVar, e eVar, int i, int i2, com.ipd.dsp.internal.z.a<?> aVar, Executor executor) {
        com.ipd.dsp.internal.z.f fVar2;
        com.ipd.dsp.internal.z.f bVar;
        if (this.j0 != null) {
            bVar = new com.ipd.dsp.internal.z.b(obj, fVar);
            fVar2 = bVar;
        } else {
            fVar2 = null;
            bVar = fVar;
        }
        com.ipd.dsp.internal.z.e eVarB = b(obj, pVar, hVar, bVar, iVar, eVar, i, i2, aVar, executor);
        if (fVar2 == null) {
            return eVarB;
        }
        int iQ = this.j0.q();
        int iP = this.j0.p();
        if (o.b(i, i2) && !this.j0.L()) {
            iQ = aVar.q();
            iP = aVar.p();
        }
        g<TranscodeType> gVar = this.j0;
        com.ipd.dsp.internal.z.b bVar2 = fVar2;
        bVar2.a(eVarB, gVar.a(obj, pVar, hVar, bVar2, gVar.f0, gVar.t(), iQ, iP, this.j0, executor));
        return bVar2;
    }

    public final com.ipd.dsp.internal.z.e a(Object obj, p<TranscodeType> pVar, com.ipd.dsp.internal.z.h<TranscodeType> hVar, com.ipd.dsp.internal.z.a<?> aVar, com.ipd.dsp.internal.z.f fVar, i<?, ? super TranscodeType> iVar, e eVar, int i, int i2, Executor executor) {
        Context context = this.a0;
        com.ipd.dsp.internal.components.glide.c cVar = this.e0;
        return k.a(context, cVar, obj, this.g0, this.c0, aVar, i, i2, eVar, pVar, hVar, this.h0, fVar, cVar.d(), iVar.b(), executor);
    }
}
