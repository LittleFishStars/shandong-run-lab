package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.zj.adlib.gj9;
import com.zj.adlib.rh9;
import com.zj.adlib.sb0;
import com.zj.adlib.z99;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements FilterableManifest<a> {
    public static final int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final C0693a f4501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b[] f4503a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f4504b;
    public final int c;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    public static class C0693a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f30999a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f4505a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final z99[] f4506a;

        public C0693a(UUID uuid, byte[] bArr, z99[] z99VarArr) {
            this.f30999a = uuid;
            this.f4505a = bArr;
            this.f4506a = z99VarArr;
        }
    }

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, @Nullable C0693a c0693a, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : gj9.o1(j2, 1000000L, j), j3 != 0 ? gj9.o1(j3, 1000000L, j) : -9223372036854775807L, i3, z, c0693a, bVarArr);
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a copy(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i = 0;
        while (i < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i);
            b bVar2 = this.f4503a[streamKey.groupIndex];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((d[]) arrayList3.toArray(new d[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f4511a[streamKey.streamIndex]);
            i++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((d[]) arrayList3.toArray(new d[0])));
        }
        return new a(this.f30998a, this.b, this.f4500a, this.f4504b, this.c, this.f4502a, this.f4501a, (b[]) arrayList2.toArray(new b[0]));
    }

    public static class b {
        public static final String f = "{start time}";
        public static final String g = "{start_time}";
        public static final String h = "{bitrate}";
        public static final String i = "{Bitrate}";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31000a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f4507a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4508a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<Long> f4509a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f4510a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d[] f4511a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long f4512b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final String f4513b;
        public final int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public final String f4514c;
        public final int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public final String f4515d;
        public final int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public final String f4516e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public final int f4517f;

        public b(String str, String str2, int i2, String str3, long j, String str4, int i3, int i4, int i5, int i6, @Nullable String str5, d[] dVarArr, List<Long> list, long j2) {
            this(str, str2, i2, str3, j, str4, i3, i4, i5, i6, str5, dVarArr, list, gj9.p1(list, 1000000L, j), gj9.o1(j2, 1000000L, j));
        }

        public Uri a(int i2, int i3) {
            sb0.i(this.f4511a != null);
            sb0.i(this.f4509a != null);
            sb0.i(i3 < this.f4509a.size());
            String string = Integer.toString(this.f4511a[i2].O);
            String string2 = this.f4509a.get(i3).toString();
            return rh9.f(this.f4515d, this.f4516e.replace(h, string).replace(i, string).replace(f, string2).replace(g, string2));
        }

        public b b(d[] dVarArr) {
            return new b(this.f4515d, this.f4516e, this.f31000a, this.f4508a, this.f4507a, this.f4513b, this.b, this.c, this.d, this.e, this.f4514c, dVarArr, this.f4509a, this.f4510a, this.f4512b);
        }

        public long c(int i2) {
            if (i2 == this.f4517f - 1) {
                return this.f4512b;
            }
            long[] jArr = this.f4510a;
            return jArr[i2 + 1] - jArr[i2];
        }

        public int d(long j) {
            return gj9.j(this.f4510a, j, true, true);
        }

        public long e(int i2) {
            return this.f4510a[i2];
        }

        public b(String str, String str2, int i2, String str3, long j, String str4, int i3, int i4, int i5, int i6, @Nullable String str5, d[] dVarArr, List<Long> list, long[] jArr, long j2) {
            this.f4515d = str;
            this.f4516e = str2;
            this.f31000a = i2;
            this.f4508a = str3;
            this.f4507a = j;
            this.f4513b = str4;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f4514c = str5;
            this.f4511a = dVarArr;
            this.f4509a = list;
            this.f4510a = jArr;
            this.f4512b = j2;
            this.f4517f = list.size();
        }
    }

    public a(int i, int i2, long j, long j2, int i3, boolean z, @Nullable C0693a c0693a, b[] bVarArr) {
        this.f30998a = i;
        this.b = i2;
        this.f4500a = j;
        this.f4504b = j2;
        this.c = i3;
        this.f4502a = z;
        this.f4501a = c0693a;
        this.f4503a = bVarArr;
    }
}
