package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.o;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DrmInitData f4165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f4166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Uri, c> f4167a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f4168b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<d> f4169b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f4170b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f4171c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<b> f4172c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f4173c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f4174d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f4175d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final long f4176e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final boolean f4177e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final long f4178f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final boolean f4179f;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class b extends e {
        public final boolean b;
        public final boolean c;

        public b(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, dVar, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.b = z2;
            this.c = z3;
        }

        public b b(long j, int i) {
            return new b(this.f, ((e) this).f4183a, ((e) this).f30926a, i, j, ((e) this).f4182a, this.g, this.h, super.c, this.d, ((e) this).f4184a, this.b, this.c);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30924a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f4180a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri f4181a;

        public c(Uri uri, long j, int i) {
            this.f4181a = uri;
            this.f4180a = j;
            this.f30924a = i;
        }
    }

    public static class e implements Comparable<Long> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30926a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final DrmInitData f4182a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final d f4183a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4184a;
        public final long b;
        public final long c;
        public final long d;
        public final String f;

        @Nullable
        public final String g;

        @Nullable
        public final String h;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l) {
            if (this.b > l.longValue()) {
                return 1;
            }
            return this.b < l.longValue() ? -1 : 0;
        }

        public e(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z) {
            this.f = str;
            this.f4183a = dVar;
            this.f30926a = j;
            this.K = i;
            this.b = j2;
            this.f4182a = drmInitData;
            this.g = str2;
            this.h = str3;
            this.c = j3;
            this.d = j4;
            this.f4184a = z;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30927a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4185a;
        public final long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f4186b;
        public final long c;

        public f(long j, boolean z, long j2, long j3, boolean z2) {
            this.f30927a = j;
            this.f4185a = z;
            this.b = j2;
            this.c = j3;
            this.f4186b = z2;
        }
    }

    public HlsMediaPlaylist(int i, String str, List<String> list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, @Nullable DrmInitData drmInitData, List<d> list2, List<b> list3, f fVar, Map<Uri, c> map) {
        super(str, list, z3);
        this.f30923a = i;
        this.f4168b = j2;
        this.f4173c = z;
        this.f4175d = z2;
        this.b = i2;
        this.f4171c = j3;
        this.c = i3;
        this.f4174d = j4;
        this.f4176e = j5;
        this.f4177e = z4;
        this.f4179f = z5;
        this.f4165a = drmInitData;
        this.f4169b = ImmutableList.copyOf((Collection) list2);
        this.f4172c = ImmutableList.copyOf((Collection) list3);
        this.f4167a = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            b bVar = (b) o.w(list3);
            this.f4178f = ((e) bVar).b + ((e) bVar).f30926a;
        } else if (list2.isEmpty()) {
            this.f4178f = 0L;
        } else {
            d dVar = (d) o.w(list2);
            this.f4178f = dVar.b + ((e) dVar).f30926a;
        }
        this.f4164a = j != -9223372036854775807L ? j >= 0 ? Math.min(this.f4178f, j) : Math.max(0L, this.f4178f + j) : -9223372036854775807L;
        this.f4170b = j >= 0;
        this.f4166a = fVar;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HlsMediaPlaylist copy(List<StreamKey> list) {
        return this;
    }

    public HlsMediaPlaylist b(long j, int i) {
        return new HlsMediaPlaylist(this.f30923a, ((HlsPlaylist) this).f30928a, ((HlsPlaylist) this).f4187a, this.f4164a, this.f4173c, j, true, i, this.f4171c, this.c, this.f4174d, this.f4176e, ((HlsPlaylist) this).f4188a, this.f4177e, this.f4179f, this.f4165a, this.f4169b, this.f4172c, this.f4166a, this.f4167a);
    }

    public HlsMediaPlaylist c() {
        return this.f4177e ? this : new HlsMediaPlaylist(this.f30923a, ((HlsPlaylist) this).f30928a, ((HlsPlaylist) this).f4187a, this.f4164a, this.f4173c, this.f4168b, this.f4175d, this.b, this.f4171c, this.c, this.f4174d, this.f4176e, ((HlsPlaylist) this).f4188a, true, this.f4179f, this.f4165a, this.f4169b, this.f4172c, this.f4166a, this.f4167a);
    }

    public long d() {
        return this.f4168b + this.f4178f;
    }

    public boolean e(@Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j = this.f4171c;
        long j2 = hlsMediaPlaylist.f4171c;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.f4169b.size() - hlsMediaPlaylist.f4169b.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f4172c.size();
        int size3 = hlsMediaPlaylist.f4172c.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f4177e && !hlsMediaPlaylist.f4177e;
        }
        return true;
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f30925a;
        public final String i;

        public d(String str, long j, long j2, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, ImmutableList.of());
        }

        public d b(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.f30925a.size(); i2++) {
                b bVar = this.f30925a.get(i2);
                arrayList.add(bVar.b(j2, i));
                j2 += ((e) bVar).f30926a;
            }
            return new d(this.f, ((e) this).f4183a, this.i, ((e) this).f30926a, i, j, ((e) this).f4182a, this.g, this.h, this.c, this.d, ((e) this).f4184a, arrayList);
        }

        public d(String str, @Nullable d dVar, String str2, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j3, long j4, boolean z, List<b> list) {
            super(str, dVar, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.i = str2;
            this.f30925a = ImmutableList.copyOf((Collection) list);
        }
    }
}
