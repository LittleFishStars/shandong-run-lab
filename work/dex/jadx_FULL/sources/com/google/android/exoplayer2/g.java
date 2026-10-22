package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.InlineMe;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements Bundleable {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final String g = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaMetadata f3323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f3324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Deprecated
    public final e f3325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final C0682g f3326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final h f3327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @Deprecated
    public final i f3328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j f3329a;
    public final String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final g f3322a = new c().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<g> f30740a = new Bundleable.Creator() { // from class: com.zj.adlib.hh5
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return g.c(bundle);
        }
    };

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f30741a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Object f3330a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Uri f30742a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public Object f3331a;

            public a(Uri uri) {
                this.f30742a = uri;
            }

            public b c() {
                return new b(this);
            }

            public a d(Uri uri) {
                this.f30742a = uri;
                return this;
            }

            public a e(@Nullable Object obj) {
                this.f3331a = obj;
                return this;
            }
        }

        public a a() {
            return new a(this.f30741a).e(this.f3330a);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f30741a.equals(bVar.f30741a) && gj9.c(this.f3330a, bVar.f3330a);
        }

        public int hashCode() {
            int iHashCode = this.f30741a.hashCode() * 31;
            Object obj = this.f3330a;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }

        public b(a aVar) {
            this.f30741a = aVar.f30742a;
            this.f3330a = aVar.f3331a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f30743a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public MediaMetadata f3332a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public b f3333a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d.a f3334a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public f.a f3335a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public C0682g.a f3336a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public j f3337a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImmutableList<l> f3338a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f3339a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f3340a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<StreamKey> f3341a;

        @Nullable
        public String b;

        @Nullable
        public String c;

        @Deprecated
        public c A(long j) {
            this.f3336a.i(j);
            return this;
        }

        @Deprecated
        public c B(float f) {
            this.f3336a.j(f);
            return this;
        }

        @Deprecated
        public c C(long j) {
            this.f3336a.k(j);
            return this;
        }

        public c D(String str) {
            this.f3340a = (String) sb0.g(str);
            return this;
        }

        public c E(MediaMetadata mediaMetadata) {
            this.f3332a = mediaMetadata;
            return this;
        }

        public c F(@Nullable String str) {
            this.b = str;
            return this;
        }

        public c G(j jVar) {
            this.f3337a = jVar;
            return this;
        }

        public c H(@Nullable List<StreamKey> list) {
            this.f3341a = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c I(List<l> list) {
            this.f3338a = ImmutableList.copyOf((Collection) list);
            return this;
        }

        @Deprecated
        public c J(@Nullable List<k> list) {
            this.f3338a = list != null ? ImmutableList.copyOf((Collection) list) : ImmutableList.of();
            return this;
        }

        public c K(@Nullable Object obj) {
            this.f3339a = obj;
            return this;
        }

        public c L(@Nullable Uri uri) {
            this.f30743a = uri;
            return this;
        }

        public c M(@Nullable String str) {
            return L(str == null ? null : Uri.parse(str));
        }

        public g a() {
            i iVar;
            sb0.i(this.f3335a.f30748a == null || this.f3335a.f3358a != null);
            Uri uri = this.f30743a;
            if (uri != null) {
                iVar = new i(uri, this.b, this.f3335a.f3358a != null ? this.f3335a.j() : null, this.f3333a, this.f3341a, this.c, this.f3338a, this.f3339a);
            } else {
                iVar = null;
            }
            String str = this.f3340a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.f3334a.g();
            C0682g c0682gF = this.f3336a.f();
            MediaMetadata mediaMetadata = this.f3332a;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.f2102a;
            }
            return new g(str2, eVarG, iVar, c0682gF, mediaMetadata, this.f3337a);
        }

        @Deprecated
        public c b(@Nullable Uri uri) {
            return c(uri, null);
        }

        @Deprecated
        public c c(@Nullable Uri uri, @Nullable Object obj) {
            this.f3333a = uri != null ? new b.a(uri).e(obj).c() : null;
            return this;
        }

        @Deprecated
        public c d(@Nullable String str) {
            return b(str != null ? Uri.parse(str) : null);
        }

        public c e(@Nullable b bVar) {
            this.f3333a = bVar;
            return this;
        }

        @Deprecated
        public c f(long j) {
            this.f3334a.h(j);
            return this;
        }

        @Deprecated
        public c g(boolean z) {
            this.f3334a.i(z);
            return this;
        }

        @Deprecated
        public c h(boolean z) {
            this.f3334a.j(z);
            return this;
        }

        @Deprecated
        public c i(@IntRange(from = 0) long j) {
            this.f3334a.k(j);
            return this;
        }

        @Deprecated
        public c j(boolean z) {
            this.f3334a.l(z);
            return this;
        }

        public c k(d dVar) {
            this.f3334a = dVar.b();
            return this;
        }

        public c l(@Nullable String str) {
            this.c = str;
            return this;
        }

        public c m(@Nullable f fVar) {
            this.f3335a = fVar != null ? fVar.b() : new f.a();
            return this;
        }

        @Deprecated
        public c n(boolean z) {
            this.f3335a.l(z);
            return this;
        }

        @Deprecated
        public c o(@Nullable byte[] bArr) {
            this.f3335a.o(bArr);
            return this;
        }

        @Deprecated
        public c p(@Nullable Map<String, String> map) {
            f.a aVar = this.f3335a;
            if (map == null) {
                map = ImmutableMap.of();
            }
            aVar.p(map);
            return this;
        }

        @Deprecated
        public c q(@Nullable Uri uri) {
            this.f3335a.q(uri);
            return this;
        }

        @Deprecated
        public c r(@Nullable String str) {
            this.f3335a.r(str);
            return this;
        }

        @Deprecated
        public c s(boolean z) {
            this.f3335a.s(z);
            return this;
        }

        @Deprecated
        public c t(boolean z) {
            this.f3335a.u(z);
            return this;
        }

        @Deprecated
        public c u(boolean z) {
            this.f3335a.m(z);
            return this;
        }

        @Deprecated
        public c v(@Nullable List<Integer> list) {
            f.a aVar = this.f3335a;
            if (list == null) {
                list = ImmutableList.of();
            }
            aVar.n(list);
            return this;
        }

        @Deprecated
        public c w(@Nullable UUID uuid) {
            this.f3335a.t(uuid);
            return this;
        }

        public c x(C0682g c0682g) {
            this.f3336a = c0682g.b();
            return this;
        }

        @Deprecated
        public c y(long j) {
            this.f3336a.g(j);
            return this;
        }

        @Deprecated
        public c z(float f) {
            this.f3336a.h(f);
            return this;
        }

        public c() {
            this.f3334a = new d.a();
            this.f3335a = new f.a();
            this.f3341a = Collections.emptyList();
            this.f3338a = ImmutableList.of();
            this.f3336a = new C0682g.a();
            this.f3337a = j.f3374a;
        }

        public c(g gVar) {
            f.a aVar;
            this();
            this.f3334a = gVar.f3324a.b();
            this.f3340a = gVar.f;
            this.f3332a = gVar.f3323a;
            this.f3336a = gVar.f3326a.b();
            this.f3337a = gVar.f3329a;
            h hVar = gVar.f3327a;
            if (hVar != null) {
                this.c = hVar.b;
                this.b = hVar.f3371a;
                this.f30743a = hVar.f30751a;
                this.f3341a = hVar.f3372a;
                this.f3338a = hVar.f3369a;
                this.f3339a = hVar.f3370a;
                f fVar = hVar.f3368a;
                if (fVar != null) {
                    aVar = fVar.b();
                } else {
                    aVar = new f.a();
                }
                this.f3335a = aVar;
                this.f3333a = hVar.f3367a;
            }
        }
    }

    public static class d implements Bundleable {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public static final int O = 4;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @IntRange(from = 0)
        public final long f3343a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3344a;
        public final long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f3345b;
        public final boolean c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final d f3342a = new a().f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<e> f30744a = new Bundleable.Creator() { // from class: com.zj.adlib.jh5
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return g.d.d(bundle);
            }
        };

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f30745a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f3346a;
            public long b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            public boolean f3347b;
            public boolean c;

            public d f() {
                return g();
            }

            @Deprecated
            public e g() {
                return new e(this);
            }

            public a h(long j) {
                sb0.a(j == Long.MIN_VALUE || j >= 0);
                this.b = j;
                return this;
            }

            public a i(boolean z) {
                this.f3347b = z;
                return this;
            }

            public a j(boolean z) {
                this.f3346a = z;
                return this;
            }

            public a k(@IntRange(from = 0) long j) {
                sb0.a(j >= 0);
                this.f30745a = j;
                return this;
            }

            public a l(boolean z) {
                this.c = z;
                return this;
            }

            public a() {
                this.b = Long.MIN_VALUE;
            }

            public a(d dVar) {
                this.f30745a = dVar.f3343a;
                this.b = dVar.b;
                this.f3346a = dVar.f3344a;
                this.f3347b = dVar.f3345b;
                this.c = dVar.c;
            }
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public static /* synthetic */ e d(Bundle bundle) {
            return new a().k(bundle.getLong(c(0), 0L)).h(bundle.getLong(c(1), Long.MIN_VALUE)).j(bundle.getBoolean(c(2), false)).i(bundle.getBoolean(c(3), false)).l(bundle.getBoolean(c(4), false)).g();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f3343a == dVar.f3343a && this.b == dVar.b && this.f3344a == dVar.f3344a && this.f3345b == dVar.f3345b && this.c == dVar.c;
        }

        public int hashCode() {
            long j = this.f3343a;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.b;
            return ((((((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.f3344a ? 1 : 0)) * 31) + (this.f3345b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f3343a);
            bundle.putLong(c(1), this.b);
            bundle.putBoolean(c(2), this.f3344a);
            bundle.putBoolean(c(3), this.f3345b);
            bundle.putBoolean(c(4), this.c);
            return bundle;
        }

        public d(a aVar) {
            this.f3343a = aVar.f30745a;
            this.b = aVar.b;
            this.f3344a = aVar.f3346a;
            this.f3345b = aVar.f3347b;
            this.c = aVar.c;
        }
    }

    @Deprecated
    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f30746a = new d.a().g();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f30747a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Deprecated
        public final ImmutableList<Integer> f3348a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Deprecated
        public final ImmutableMap<String, String> f3349a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final UUID f3350a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3351a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final byte[] f3352a;
        public final ImmutableList<Integer> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final ImmutableMap<String, String> f3353b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Deprecated
        public final UUID f3354b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f3355b;
        public final boolean c;

        public a b() {
            return new a();
        }

        @Nullable
        public byte[] c() {
            byte[] bArr = this.f3352a;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f3350a.equals(fVar.f3350a) && gj9.c(this.f30747a, fVar.f30747a) && gj9.c(this.f3353b, fVar.f3353b) && this.f3351a == fVar.f3351a && this.c == fVar.c && this.f3355b == fVar.f3355b && this.b.equals(fVar.b) && Arrays.equals(this.f3352a, fVar.f3352a);
        }

        public int hashCode() {
            int iHashCode = this.f3350a.hashCode() * 31;
            Uri uri = this.f30747a;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f3353b.hashCode()) * 31) + (this.f3351a ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f3355b ? 1 : 0)) * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.f3352a);
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Uri f30748a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public ImmutableList<Integer> f3356a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public ImmutableMap<String, String> f3357a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public UUID f3358a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f3359a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public byte[] f3360a;
            public boolean b;
            public boolean c;

            public f j() {
                return new f(this);
            }

            @InlineMe(replacement = "this.setForceSessionsForAudioAndVideoTracks(forceSessionsForAudioAndVideoTracks)")
            @Deprecated
            public a k(boolean z) {
                return m(z);
            }

            public a l(boolean z) {
                this.c = z;
                return this;
            }

            public a m(boolean z) {
                n(z ? ImmutableList.of(2, 1) : ImmutableList.of());
                return this;
            }

            public a n(List<Integer> list) {
                this.f3356a = ImmutableList.copyOf((Collection) list);
                return this;
            }

            public a o(@Nullable byte[] bArr) {
                this.f3360a = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            public a p(Map<String, String> map) {
                this.f3357a = ImmutableMap.copyOf((Map) map);
                return this;
            }

            public a q(@Nullable Uri uri) {
                this.f30748a = uri;
                return this;
            }

            public a r(@Nullable String str) {
                this.f30748a = str == null ? null : Uri.parse(str);
                return this;
            }

            public a s(boolean z) {
                this.f3359a = z;
                return this;
            }

            @Deprecated
            public final a t(@Nullable UUID uuid) {
                this.f3358a = uuid;
                return this;
            }

            public a u(boolean z) {
                this.b = z;
                return this;
            }

            public a v(UUID uuid) {
                this.f3358a = uuid;
                return this;
            }

            public a(UUID uuid) {
                this.f3358a = uuid;
                this.f3357a = ImmutableMap.of();
                this.f3356a = ImmutableList.of();
            }

            @Deprecated
            public a() {
                this.f3357a = ImmutableMap.of();
                this.f3356a = ImmutableList.of();
            }

            public a(f fVar) {
                this.f3358a = fVar.f3350a;
                this.f30748a = fVar.f30747a;
                this.f3357a = fVar.f3353b;
                this.f3359a = fVar.f3351a;
                this.b = fVar.f3355b;
                this.c = fVar.c;
                this.f3356a = fVar.b;
                this.f3360a = fVar.f3352a;
            }
        }

        public f(a aVar) {
            sb0.i((aVar.c && aVar.f30748a == null) ? false : true);
            UUID uuid = (UUID) sb0.g(aVar.f3358a);
            this.f3350a = uuid;
            this.f3354b = uuid;
            this.f30747a = aVar.f30748a;
            this.f3349a = aVar.f3357a;
            this.f3353b = aVar.f3357a;
            this.f3351a = aVar.f3359a;
            this.c = aVar.c;
            this.f3355b = aVar.b;
            this.f3348a = aVar.f3356a;
            this.b = aVar.f3356a;
            this.f3352a = aVar.f3360a != null ? Arrays.copyOf(aVar.f3360a, aVar.f3360a.length) : null;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.g$g, reason: collision with other inner class name */
    public static final class C0682g implements Bundleable {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public static final int O = 4;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float f3362a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3363a;
        public final float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long f3364b;
        public final long c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final C0682g f3361a = new a().f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<C0682g> f30749a = new Bundleable.Creator() { // from class: com.zj.adlib.lh5
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return g.C0682g.d(bundle);
            }
        };

        /* JADX INFO: renamed from: com.google.android.exoplayer2.g$g$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public float f30750a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public long f3365a;
            public float b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            public long f3366b;
            public long c;

            public C0682g f() {
                return new C0682g(this);
            }

            public a g(long j) {
                this.c = j;
                return this;
            }

            public a h(float f) {
                this.b = f;
                return this;
            }

            public a i(long j) {
                this.f3366b = j;
                return this;
            }

            public a j(float f) {
                this.f30750a = f;
                return this;
            }

            public a k(long j) {
                this.f3365a = j;
                return this;
            }

            public a() {
                this.f3365a = -9223372036854775807L;
                this.f3366b = -9223372036854775807L;
                this.c = -9223372036854775807L;
                this.f30750a = -3.4028235E38f;
                this.b = -3.4028235E38f;
            }

            public a(C0682g c0682g) {
                this.f3365a = c0682g.f3363a;
                this.f3366b = c0682g.f3364b;
                this.c = c0682g.c;
                this.f30750a = c0682g.f3362a;
                this.b = c0682g.b;
            }
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public static /* synthetic */ C0682g d(Bundle bundle) {
            return new C0682g(bundle.getLong(c(0), -9223372036854775807L), bundle.getLong(c(1), -9223372036854775807L), bundle.getLong(c(2), -9223372036854775807L), bundle.getFloat(c(3), -3.4028235E38f), bundle.getFloat(c(4), -3.4028235E38f));
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0682g)) {
                return false;
            }
            C0682g c0682g = (C0682g) obj;
            return this.f3363a == c0682g.f3363a && this.f3364b == c0682g.f3364b && this.c == c0682g.c && this.f3362a == c0682g.f3362a && this.b == c0682g.b;
        }

        public int hashCode() {
            long j = this.f3363a;
            long j2 = this.f3364b;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.c;
            int i2 = (i + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.f3362a;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.b;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f3363a);
            bundle.putLong(c(1), this.f3364b);
            bundle.putLong(c(2), this.c);
            bundle.putFloat(c(3), this.f3362a);
            bundle.putFloat(c(4), this.b);
            return bundle;
        }

        public C0682g(a aVar) {
            this(aVar.f3365a, aVar.f3366b, aVar.c, aVar.f30750a, aVar.b);
        }

        @Deprecated
        public C0682g(long j, long j2, long j3, float f, float f2) {
            this.f3363a = j;
            this.f3364b = j2;
            this.c = j3;
            this.f3362a = f;
            this.b = f2;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f30751a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final b f3367a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final f f3368a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ImmutableList<l> f3369a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Object f3370a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f3371a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<StreamKey> f3372a;

        @Nullable
        public final String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Deprecated
        public final List<k> f3373b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f30751a.equals(hVar.f30751a) && gj9.c(this.f3371a, hVar.f3371a) && gj9.c(this.f3368a, hVar.f3368a) && gj9.c(this.f3367a, hVar.f3367a) && this.f3372a.equals(hVar.f3372a) && gj9.c(this.b, hVar.b) && this.f3369a.equals(hVar.f3369a) && gj9.c(this.f3370a, hVar.f3370a);
        }

        public int hashCode() {
            int iHashCode = this.f30751a.hashCode() * 31;
            String str = this.f3371a;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f3368a;
            int iHashCode3 = (iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
            b bVar = this.f3367a;
            int iHashCode4 = (((iHashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f3372a.hashCode()) * 31;
            String str2 = this.b;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f3369a.hashCode()) * 31;
            Object obj = this.f3370a;
            return iHashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        public h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<l> immutableList, @Nullable Object obj) {
            this.f30751a = uri;
            this.f3371a = str;
            this.f3368a = fVar;
            this.f3367a = bVar;
            this.f3372a = list;
            this.b = str2;
            this.f3369a = immutableList;
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i = 0; i < immutableList.size(); i++) {
                aVarBuilder.a(immutableList.get(i).a().j());
            }
            this.f3373b = aVarBuilder.e();
            this.f3370a = obj;
        }
    }

    @Deprecated
    public static final class i extends h {
        public i(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<l> immutableList, @Nullable Object obj) {
            super(uri, str, fVar, bVar, list, str2, immutableList, obj);
        }
    }

    public static final class j implements Bundleable {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Uri f3375a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Bundle f3376a;

        @Nullable
        public final String f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final j f3374a = new a().d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<j> f30752a = new Bundleable.Creator() { // from class: com.zj.adlib.nh5
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return g.j.d(bundle);
            }
        };

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Uri f30753a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public Bundle f3377a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public String f3378a;

            public j d() {
                return new j(this);
            }

            public a e(@Nullable Bundle bundle) {
                this.f3377a = bundle;
                return this;
            }

            public a f(@Nullable Uri uri) {
                this.f30753a = uri;
                return this;
            }

            public a g(@Nullable String str) {
                this.f3378a = str;
                return this;
            }

            public a() {
            }

            public a(j jVar) {
                this.f30753a = jVar.f3375a;
                this.f3378a = jVar.f;
                this.f3377a = jVar.f3376a;
            }
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public static /* synthetic */ j d(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(c(0))).g(bundle.getString(c(1))).e(bundle.getBundle(c(2))).d();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return gj9.c(this.f3375a, jVar.f3375a) && gj9.c(this.f, jVar.f);
        }

        public int hashCode() {
            Uri uri = this.f3375a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.f3375a != null) {
                bundle.putParcelable(c(0), this.f3375a);
            }
            if (this.f != null) {
                bundle.putString(c(1), this.f);
            }
            if (this.f3376a != null) {
                bundle.putBundle(c(2), this.f3376a);
            }
            return bundle;
        }

        public j(a aVar) {
            this.f3375a = aVar.f30753a;
            this.f = aVar.f3378a;
            this.f3376a = aVar.f3377a;
        }
    }

    @Deprecated
    public static final class k extends l {
        @Deprecated
        public k(Uri uri, String str, @Nullable String str2) {
            this(uri, str, str2, 0);
        }

        @Deprecated
        public k(Uri uri, String str, @Nullable String str2, int i) {
            this(uri, str, str2, i, 0, null);
        }

        @Deprecated
        public k(Uri uri, String str, @Nullable String str2, int i, int i2, @Nullable String str3) {
            super(uri, str, str2, i, i2, str3, null);
        }

        public k(l.a aVar) {
            super(aVar);
        }
    }

    public static g c(Bundle bundle) {
        String str = (String) sb0.g(bundle.getString(f(0), ""));
        Bundle bundle2 = bundle.getBundle(f(1));
        C0682g c0682g = bundle2 == null ? C0682g.f3361a : (C0682g) C0682g.f30749a.a(bundle2);
        Bundle bundle3 = bundle.getBundle(f(2));
        MediaMetadata mediaMetadata = bundle3 == null ? MediaMetadata.f2102a : (MediaMetadata) MediaMetadata.f30491a.a(bundle3);
        Bundle bundle4 = bundle.getBundle(f(3));
        e eVar = bundle4 == null ? e.f30746a : (e) d.f30744a.a(bundle4);
        Bundle bundle5 = bundle.getBundle(f(4));
        return new g(str, eVar, null, c0682g, mediaMetadata, bundle5 == null ? j.f3374a : (j) j.f30752a.a(bundle5));
    }

    public static g d(Uri uri) {
        return new c().L(uri).a();
    }

    public static g e(String str) {
        return new c().M(str).a();
    }

    public static String f(int i2) {
        return Integer.toString(i2, 36);
    }

    public c b() {
        return new c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gj9.c(this.f, gVar.f) && this.f3324a.equals(gVar.f3324a) && gj9.c(this.f3327a, gVar.f3327a) && gj9.c(this.f3326a, gVar.f3326a) && gj9.c(this.f3323a, gVar.f3323a) && gj9.c(this.f3329a, gVar.f3329a);
    }

    public int hashCode() {
        int iHashCode = this.f.hashCode() * 31;
        h hVar = this.f3327a;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f3326a.hashCode()) * 31) + this.f3324a.hashCode()) * 31) + this.f3323a.hashCode()) * 31) + this.f3329a.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(f(0), this.f);
        bundle.putBundle(f(1), this.f3326a.toBundle());
        bundle.putBundle(f(2), this.f3323a.toBundle());
        bundle.putBundle(f(3), this.f3324a.toBundle());
        bundle.putBundle(f(4), this.f3329a.toBundle());
        return bundle;
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30754a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri f3379a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f3380a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final String f3381b;

        @Nullable
        public final String c;

        @Nullable
        public final String d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f30755a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public Uri f3382a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public String f3383a;
            public int b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            @Nullable
            public String f3384b;

            @Nullable
            public String c;

            @Nullable
            public String d;

            public l i() {
                return new l(this);
            }

            public final k j() {
                return new k(this);
            }

            public a k(@Nullable String str) {
                this.d = str;
                return this;
            }

            public a l(@Nullable String str) {
                this.c = str;
                return this;
            }

            public a m(@Nullable String str) {
                this.f3384b = str;
                return this;
            }

            public a n(@Nullable String str) {
                this.f3383a = str;
                return this;
            }

            public a o(int i) {
                this.b = i;
                return this;
            }

            public a p(int i) {
                this.f30755a = i;
                return this;
            }

            public a q(Uri uri) {
                this.f3382a = uri;
                return this;
            }

            public a(Uri uri) {
                this.f3382a = uri;
            }

            public a(l lVar) {
                this.f3382a = lVar.f3379a;
                this.f3383a = lVar.f3380a;
                this.f3384b = lVar.f3381b;
                this.f30755a = lVar.f30754a;
                this.b = lVar.b;
                this.c = lVar.c;
                this.d = lVar.d;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.f3379a.equals(lVar.f3379a) && gj9.c(this.f3380a, lVar.f3380a) && gj9.c(this.f3381b, lVar.f3381b) && this.f30754a == lVar.f30754a && this.b == lVar.b && gj9.c(this.c, lVar.c) && gj9.c(this.d, lVar.d);
        }

        public int hashCode() {
            int iHashCode = this.f3379a.hashCode() * 31;
            String str = this.f3380a;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f3381b;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f30754a) * 31) + this.b) * 31;
            String str3 = this.c;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.d;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public l(Uri uri, String str, @Nullable String str2, int i, int i2, @Nullable String str3, @Nullable String str4) {
            this.f3379a = uri;
            this.f3380a = str;
            this.f3381b = str2;
            this.f30754a = i;
            this.b = i2;
            this.c = str3;
            this.d = str4;
        }

        public l(a aVar) {
            this.f3379a = aVar.f3382a;
            this.f3380a = aVar.f3383a;
            this.f3381b = aVar.f3384b;
            this.f30754a = aVar.f30755a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
        }
    }

    public g(String str, e eVar, @Nullable i iVar, C0682g c0682g, MediaMetadata mediaMetadata, j jVar) {
        this.f = str;
        this.f3327a = iVar;
        this.f3328a = iVar;
        this.f3326a = c0682g;
        this.f3323a = mediaMetadata;
        this.f3324a = eVar;
        this.f3325a = eVar;
        this.f3329a = jVar;
    }
}
