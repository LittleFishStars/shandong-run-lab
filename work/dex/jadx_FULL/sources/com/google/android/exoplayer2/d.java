package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.zj.adlib.a51;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.tn1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements Bundleable {
    public static final int A0 = 23;
    public static final int B0 = 24;
    public static final int C0 = 25;
    public static final int D0 = 26;
    public static final int E0 = 27;
    public static final int F0 = 28;
    public static final int G0 = 29;
    public static final long b = Long.MAX_VALUE;
    public static final int c0 = -1;
    public static final int d0 = 0;
    public static final int e0 = 1;
    public static final int f0 = 2;
    public static final int g0 = 3;
    public static final int h0 = 4;
    public static final int i0 = 5;
    public static final int j0 = 6;
    public static final int k0 = 7;
    public static final int l0 = 8;
    public static final int m0 = 9;
    public static final int n0 = 10;
    public static final int o0 = 11;
    public static final int p0 = 12;
    public static final int q0 = 13;
    public static final int r0 = 14;
    public static final int s0 = 15;
    public static final int t0 = 16;
    public static final int u0 = 17;
    public static final int v0 = 18;
    public static final int w0 = 19;
    public static final int x0 = 20;
    public static final int y0 = 21;
    public static final int z0 = 22;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public final int W;
    public final int X;
    public final int Y;
    public final int Z;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f2564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DrmInitData f2566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Metadata f2567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final tn1 f2568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<byte[]> f2569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f2570a;
    public final int a0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float f2571b;
    public int b0;

    @Nullable
    public final String f;

    @Nullable
    public final String g;

    @Nullable
    public final String h;

    @Nullable
    public final String i;

    @Nullable
    public final String j;

    @Nullable
    public final String k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final d f2563a = new b().E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<d> f30574a = new Bundleable.Creator() { // from class: com.zj.adlib.xk3
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return d.u(bundle);
        }
    };

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30575a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f2572a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2573a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public DrmInitData f2574a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Metadata f2575a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public tn1 f2576a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f2577a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public List<byte[]> f2578a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public byte[] f2579a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f2580b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public String f2581b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public String f2582c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        @Nullable
        public String f2583d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        @Nullable
        public String f2584e;
        public int f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        @Nullable
        public String f2585f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;

        public d E() {
            return new d(this);
        }

        public b F(int i) {
            this.o = i;
            return this;
        }

        public b G(int i) {
            this.c = i;
            return this;
        }

        public b H(int i) {
            this.j = i;
            return this;
        }

        public b I(@Nullable String str) {
            this.f2583d = str;
            return this;
        }

        public b J(@Nullable tn1 tn1Var) {
            this.f2576a = tn1Var;
            return this;
        }

        public b K(@Nullable String str) {
            this.f2584e = str;
            return this;
        }

        public b L(int i) {
            this.p = i;
            return this;
        }

        public b M(@Nullable DrmInitData drmInitData) {
            this.f2574a = drmInitData;
            return this;
        }

        public b N(int i) {
            this.m = i;
            return this;
        }

        public b O(int i) {
            this.n = i;
            return this;
        }

        public b P(float f) {
            this.f30575a = f;
            return this;
        }

        public b Q(int i) {
            this.g = i;
            return this;
        }

        public b R(int i) {
            this.f2577a = Integer.toString(i);
            return this;
        }

        public b S(@Nullable String str) {
            this.f2577a = str;
            return this;
        }

        public b T(@Nullable List<byte[]> list) {
            this.f2578a = list;
            return this;
        }

        public b U(@Nullable String str) {
            this.f2581b = str;
            return this;
        }

        public b V(@Nullable String str) {
            this.f2582c = str;
            return this;
        }

        public b W(int i) {
            this.e = i;
            return this;
        }

        public b X(@Nullable Metadata metadata) {
            this.f2575a = metadata;
            return this;
        }

        public b Y(int i) {
            this.l = i;
            return this;
        }

        public b Z(int i) {
            this.d = i;
            return this;
        }

        public b a0(float f) {
            this.b = f;
            return this;
        }

        public b b0(@Nullable byte[] bArr) {
            this.f2579a = bArr;
            return this;
        }

        public b c0(int i) {
            this.f2580b = i;
            return this;
        }

        public b d0(int i) {
            this.h = i;
            return this;
        }

        public b e0(@Nullable String str) {
            this.f2585f = str;
            return this;
        }

        public b f0(int i) {
            this.k = i;
            return this;
        }

        public b g0(int i) {
            this.f2572a = i;
            return this;
        }

        public b h0(int i) {
            this.i = i;
            return this;
        }

        public b i0(long j) {
            this.f2573a = j;
            return this;
        }

        public b j0(int i) {
            this.f = i;
            return this;
        }

        public b() {
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f2573a = Long.MAX_VALUE;
            this.f = -1;
            this.g = -1;
            this.f30575a = -1.0f;
            this.b = 1.0f;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.o = -1;
            this.p = 0;
        }

        public b(d dVar) {
            this.f2577a = dVar.f;
            this.f2581b = dVar.g;
            this.f2582c = dVar.h;
            this.f2572a = dVar.K;
            this.f2580b = dVar.L;
            this.c = dVar.M;
            this.d = dVar.N;
            this.f2583d = dVar.i;
            this.f2575a = dVar.f2567a;
            this.f2584e = dVar.j;
            this.f2585f = dVar.k;
            this.e = dVar.P;
            this.f2578a = dVar.f2569a;
            this.f2574a = dVar.f2566a;
            this.f2573a = dVar.f2565a;
            this.f = dVar.Q;
            this.g = dVar.R;
            this.f30575a = dVar.f2564a;
            this.h = dVar.S;
            this.b = dVar.f2571b;
            this.f2579a = dVar.f2570a;
            this.i = dVar.T;
            this.f2576a = dVar.f2568a;
            this.j = dVar.U;
            this.k = dVar.V;
            this.l = dVar.W;
            this.m = dVar.X;
            this.n = dVar.Y;
            this.o = dVar.Z;
            this.p = dVar.a0;
        }
    }

    @Deprecated
    public static d n(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, int i5, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData, int i6, @Nullable String str4) {
        return new b().S(str).V(str4).g0(i6).G(i).Z(i).I(str3).e0(str2).W(i2).T(list).M(drmInitData).H(i3).f0(i4).Y(i5).E();
    }

    @Deprecated
    public static d o(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData, int i5, @Nullable String str4) {
        return new b().S(str).V(str4).g0(i5).G(i).Z(i).I(str3).e0(str2).W(i2).T(list).M(drmInitData).H(i3).f0(i4).E();
    }

    @Deprecated
    public static d p(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, int i2, int i3, @Nullable String str6) {
        return new b().S(str).U(str2).V(str6).g0(i2).c0(i3).G(i).Z(i).I(str5).K(str3).e0(str4).E();
    }

    @Deprecated
    public static d q(@Nullable String str, @Nullable String str2) {
        return new b().S(str).e0(str2).E();
    }

    @Deprecated
    public static d r(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, int i5, float f2, @Nullable DrmInitData drmInitData) {
        return new b().S(str).G(i).Z(i).I(str3).e0(str2).W(i2).T(list).M(drmInitData).j0(i3).Q(i4).P(f).d0(i5).a0(f2).E();
    }

    @Deprecated
    public static d s(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData) {
        return new b().S(str).G(i).Z(i).I(str3).e0(str2).W(i2).T(list).M(drmInitData).j0(i3).Q(i4).P(f).E();
    }

    @Nullable
    public static <T> T t(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    public static d u(Bundle bundle) {
        b bVar = new b();
        a51.a(bundle);
        int i = 0;
        String string = bundle.getString(x(0));
        d dVar = f2563a;
        bVar.S((String) t(string, dVar.f)).U((String) t(bundle.getString(x(1)), dVar.g)).V((String) t(bundle.getString(x(2)), dVar.h)).g0(bundle.getInt(x(3), dVar.K)).c0(bundle.getInt(x(4), dVar.L)).G(bundle.getInt(x(5), dVar.M)).Z(bundle.getInt(x(6), dVar.N)).I((String) t(bundle.getString(x(7)), dVar.i)).X((Metadata) t((Metadata) bundle.getParcelable(x(8)), dVar.f2567a)).K((String) t(bundle.getString(x(9)), dVar.j)).e0((String) t(bundle.getString(x(10)), dVar.k)).W(bundle.getInt(x(11), dVar.P));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(y(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        b bVarM = bVar.T(arrayList).M((DrmInitData) bundle.getParcelable(x(13)));
        String strX = x(14);
        d dVar2 = f2563a;
        bVarM.i0(bundle.getLong(strX, dVar2.f2565a)).j0(bundle.getInt(x(15), dVar2.Q)).Q(bundle.getInt(x(16), dVar2.R)).P(bundle.getFloat(x(17), dVar2.f2564a)).d0(bundle.getInt(x(18), dVar2.S)).a0(bundle.getFloat(x(19), dVar2.f2571b)).b0(bundle.getByteArray(x(20))).h0(bundle.getInt(x(21), dVar2.T));
        Bundle bundle2 = bundle.getBundle(x(22));
        if (bundle2 != null) {
            bVar.J((tn1) tn1.f44960a.a(bundle2));
        }
        bVar.H(bundle.getInt(x(23), dVar2.U)).f0(bundle.getInt(x(24), dVar2.V)).Y(bundle.getInt(x(25), dVar2.W)).N(bundle.getInt(x(26), dVar2.X)).O(bundle.getInt(x(27), dVar2.Y)).F(bundle.getInt(x(28), dVar2.Z)).L(bundle.getInt(x(29), dVar2.a0));
        return bVar.E();
    }

    public static String x(int i) {
        return Integer.toString(i, 36);
    }

    public static String y(int i) {
        return x(12) + LoginConstants.UNDER_LINE + Integer.toString(i, 36);
    }

    public static String z(@Nullable d dVar) {
        if (dVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(dVar.f);
        sb.append(", mimeType=");
        sb.append(dVar.k);
        if (dVar.O != -1) {
            sb.append(", bitrate=");
            sb.append(dVar.O);
        }
        if (dVar.i != null) {
            sb.append(", codecs=");
            sb.append(dVar.i);
        }
        if (dVar.f2566a != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                DrmInitData drmInitData = dVar.f2566a;
                if (i >= drmInitData.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData.get(i).uuid;
                if (uuid.equals(C.f1999b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.f2002c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.f2008e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.f2005d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.f1996a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i++;
            }
            sb.append(", drm=[");
            com.google.common.base.d.o(',').f(sb, linkedHashSet);
            sb.append(']');
        }
        if (dVar.Q != -1 && dVar.R != -1) {
            sb.append(", res=");
            sb.append(dVar.Q);
            sb.append("x");
            sb.append(dVar.R);
        }
        if (dVar.f2564a != -1.0f) {
            sb.append(", fps=");
            sb.append(dVar.f2564a);
        }
        if (dVar.U != -1) {
            sb.append(", channels=");
            sb.append(dVar.U);
        }
        if (dVar.V != -1) {
            sb.append(", sample_rate=");
            sb.append(dVar.V);
        }
        if (dVar.h != null) {
            sb.append(", language=");
            sb.append(dVar.h);
        }
        if (dVar.g != null) {
            sb.append(", label=");
            sb.append(dVar.g);
        }
        if (dVar.K != 0) {
            ArrayList arrayList = new ArrayList();
            if ((dVar.K & 4) != 0) {
                arrayList.add("auto");
            }
            if ((dVar.K & 1) != 0) {
                arrayList.add("default");
            }
            if ((dVar.K & 2) != 0) {
                arrayList.add("forced");
            }
            sb.append(", selectionFlags=[");
            com.google.common.base.d.o(',').f(sb, arrayList);
            sb.append("]");
        }
        if (dVar.L != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((dVar.L & 1) != 0) {
                arrayList2.add("main");
            }
            if ((dVar.L & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((dVar.L & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((dVar.L & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((dVar.L & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((dVar.L & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((dVar.L & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((dVar.L & 128) != 0) {
                arrayList2.add(MediaFormat.KEY_SUBTITLE);
            }
            if ((dVar.L & 256) != 0) {
                arrayList2.add(UserTrackConstant.SIGN);
            }
            if ((dVar.L & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((dVar.L & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((dVar.L & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((dVar.L & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((dVar.L & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((dVar.L & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            com.google.common.base.d.o(',').f(sb, arrayList2);
            sb.append("]");
        }
        return sb.toString();
    }

    public d A(d dVar) {
        String str;
        if (this == dVar) {
            return this;
        }
        int iL = bp5.l(this.k);
        String str2 = dVar.f;
        String str3 = dVar.g;
        if (str3 == null) {
            str3 = this.g;
        }
        String str4 = this.h;
        if ((iL == 3 || iL == 1) && (str = dVar.h) != null) {
            str4 = str;
        }
        int i = this.M;
        if (i == -1) {
            i = dVar.M;
        }
        int i2 = this.N;
        if (i2 == -1) {
            i2 = dVar.N;
        }
        String str5 = this.i;
        if (str5 == null) {
            String strT = gj9.T(dVar.i, iL);
            if (gj9.w1(strT).length == 1) {
                str5 = strT;
            }
        }
        Metadata metadata = this.f2567a;
        Metadata metadataCopyWithAppendedEntriesFrom = metadata == null ? dVar.f2567a : metadata.copyWithAppendedEntriesFrom(dVar.f2567a);
        float f = this.f2564a;
        if (f == -1.0f && iL == 2) {
            f = dVar.f2564a;
        }
        return b().S(str2).U(str3).V(str4).g0(this.K | dVar.K).c0(this.L | dVar.L).G(i).Z(i2).I(str5).X(metadataCopyWithAppendedEntriesFrom).M(DrmInitData.createSessionCreationData(dVar.f2566a, this.f2566a)).P(f).E();
    }

    public b b() {
        return new b();
    }

    @Deprecated
    public d c(int i) {
        return b().G(i).Z(i).E();
    }

    public d d(int i) {
        return b().L(i).E();
    }

    @Deprecated
    public d e(@Nullable DrmInitData drmInitData) {
        return b().M(drmInitData).E();
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        int i2 = this.b0;
        if (i2 == 0 || (i = dVar.b0) == 0 || i2 == i) {
            return this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.P == dVar.P && this.f2565a == dVar.f2565a && this.Q == dVar.Q && this.R == dVar.R && this.S == dVar.S && this.T == dVar.T && this.U == dVar.U && this.V == dVar.V && this.W == dVar.W && this.X == dVar.X && this.Y == dVar.Y && this.Z == dVar.Z && this.a0 == dVar.a0 && Float.compare(this.f2564a, dVar.f2564a) == 0 && Float.compare(this.f2571b, dVar.f2571b) == 0 && gj9.c(this.f, dVar.f) && gj9.c(this.g, dVar.g) && gj9.c(this.i, dVar.i) && gj9.c(this.j, dVar.j) && gj9.c(this.k, dVar.k) && gj9.c(this.h, dVar.h) && Arrays.equals(this.f2570a, dVar.f2570a) && gj9.c(this.f2567a, dVar.f2567a) && gj9.c(this.f2568a, dVar.f2568a) && gj9.c(this.f2566a, dVar.f2566a) && w(dVar);
        }
        return false;
    }

    @Deprecated
    public d f(float f) {
        return b().P(f).E();
    }

    @Deprecated
    public d g(int i, int i2) {
        return b().N(i).O(i2).E();
    }

    @Deprecated
    public d h(@Nullable String str) {
        return b().U(str).E();
    }

    public int hashCode() {
        if (this.b0 == 0) {
            String str = this.f;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.g;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.h;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31;
            String str4 = this.i;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f2567a;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.j;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.k;
            this.b0 = ((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.P) * 31) + ((int) this.f2565a)) * 31) + this.Q) * 31) + this.R) * 31) + Float.floatToIntBits(this.f2564a)) * 31) + this.S) * 31) + Float.floatToIntBits(this.f2571b)) * 31) + this.T) * 31) + this.U) * 31) + this.V) * 31) + this.W) * 31) + this.X) * 31) + this.Y) * 31) + this.Z) * 31) + this.a0;
        }
        return this.b0;
    }

    @Deprecated
    public d i(d dVar) {
        return A(dVar);
    }

    @Deprecated
    public d j(int i) {
        return b().W(i).E();
    }

    @Deprecated
    public d k(@Nullable Metadata metadata) {
        return b().X(metadata).E();
    }

    @Deprecated
    public d l(long j) {
        return b().i0(j).E();
    }

    @Deprecated
    public d m(int i, int i2) {
        return b().j0(i).Q(i2).E();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(x(0), this.f);
        bundle.putString(x(1), this.g);
        bundle.putString(x(2), this.h);
        bundle.putInt(x(3), this.K);
        bundle.putInt(x(4), this.L);
        bundle.putInt(x(5), this.M);
        bundle.putInt(x(6), this.N);
        bundle.putString(x(7), this.i);
        bundle.putParcelable(x(8), this.f2567a);
        bundle.putString(x(9), this.j);
        bundle.putString(x(10), this.k);
        bundle.putInt(x(11), this.P);
        for (int i = 0; i < this.f2569a.size(); i++) {
            bundle.putByteArray(y(i), this.f2569a.get(i));
        }
        bundle.putParcelable(x(13), this.f2566a);
        bundle.putLong(x(14), this.f2565a);
        bundle.putInt(x(15), this.Q);
        bundle.putInt(x(16), this.R);
        bundle.putFloat(x(17), this.f2564a);
        bundle.putInt(x(18), this.S);
        bundle.putFloat(x(19), this.f2571b);
        bundle.putByteArray(x(20), this.f2570a);
        bundle.putInt(x(21), this.T);
        if (this.f2568a != null) {
            bundle.putBundle(x(22), this.f2568a.toBundle());
        }
        bundle.putInt(x(23), this.U);
        bundle.putInt(x(24), this.V);
        bundle.putInt(x(25), this.W);
        bundle.putInt(x(26), this.X);
        bundle.putInt(x(27), this.Y);
        bundle.putInt(x(28), this.Z);
        bundle.putInt(x(29), this.a0);
        return bundle;
    }

    public String toString() {
        return "Format(" + this.f + ", " + this.g + ", " + this.j + ", " + this.k + ", " + this.i + ", " + this.O + ", " + this.h + ", [" + this.Q + ", " + this.R + ", " + this.f2564a + "], [" + this.U + ", " + this.V + "])";
    }

    public int v() {
        int i;
        int i2 = this.Q;
        if (i2 == -1 || (i = this.R) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public boolean w(d dVar) {
        if (this.f2569a.size() != dVar.f2569a.size()) {
            return false;
        }
        for (int i = 0; i < this.f2569a.size(); i++) {
            if (!Arrays.equals(this.f2569a.get(i), dVar.f2569a.get(i))) {
                return false;
            }
        }
        return true;
    }

    public d(b bVar) {
        this.f = bVar.f2577a;
        this.g = bVar.f2581b;
        this.h = gj9.b1(bVar.f2582c);
        this.K = bVar.f2572a;
        this.L = bVar.f2580b;
        int i = bVar.c;
        this.M = i;
        int i2 = bVar.d;
        this.N = i2;
        this.O = i2 != -1 ? i2 : i;
        this.i = bVar.f2583d;
        this.f2567a = bVar.f2575a;
        this.j = bVar.f2584e;
        this.k = bVar.f2585f;
        this.P = bVar.e;
        this.f2569a = bVar.f2578a == null ? Collections.emptyList() : bVar.f2578a;
        DrmInitData drmInitData = bVar.f2574a;
        this.f2566a = drmInitData;
        this.f2565a = bVar.f2573a;
        this.Q = bVar.f;
        this.R = bVar.g;
        this.f2564a = bVar.f30575a;
        this.S = bVar.h == -1 ? 0 : bVar.h;
        this.f2571b = bVar.b == -1.0f ? 1.0f : bVar.b;
        this.f2570a = bVar.f2579a;
        this.T = bVar.i;
        this.f2568a = bVar.f2576a;
        this.U = bVar.j;
        this.V = bVar.k;
        this.W = bVar.l;
        this.X = bVar.m == -1 ? 0 : bVar.m;
        this.Y = bVar.n != -1 ? bVar.n : 0;
        this.Z = bVar.o;
        if (bVar.p != 0 || drmInitData == null) {
            this.a0 = bVar.p;
        } else {
            this.a0 = 1;
        }
    }
}
