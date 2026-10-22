package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.en1;
import com.zj.adlib.gj9;
import com.zj.adlib.kw5;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30974a = 352;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4402a = "profile-level-id";
    public static final int b = 288;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f4403b = "sprop-parameter-sets";
    public static final int c = 320;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f4404c = "octet-align";
    public static final int d = 240;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f4405d = "interleaving";
    public static final int e = 48000;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f4406e = "sprop-sps";
    public static final int f = 320;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f4407f = "sprop-pps";
    public static final int g = 240;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f4408g = "sprop-vps";
    public static final int h = 352;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f4409h = "sprop-max-don-diff";
    public static final int i = 288;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f4410i = "config";
    public static final String j = "mp4a.40.";
    public static final String k = "avc1.";
    public static final String l = "mp4v.";
    public static final String m = "*";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f4411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4412a;

    public f(MediaDescription mediaDescription, Uri uri) {
        sb0.a(mediaDescription.f4305a.containsKey(i.j));
        this.f4412a = b(mediaDescription);
        this.f4411a = a(uri, (String) gj9.k(mediaDescription.f4305a.get(i.j)));
    }

    public static Uri a(Uri uri, String str) {
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        return str.equals("*") ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }

    /* JADX WARN: switch over string: strings are not added: [[audio/ac3], [audio/g711-alaw], [audio/g711-mlaw]] */
    @VisibleForTesting
    public static b b(MediaDescription mediaDescription) {
        int iD;
        com.google.android.exoplayer2.d.b bVar = new com.google.android.exoplayer2.d.b();
        int i2 = mediaDescription.c;
        if (i2 > 0) {
            bVar.G(i2);
        }
        MediaDescription.c cVar = mediaDescription.f4304a;
        int i3 = cVar.f30948a;
        String str = cVar.f4316a;
        String strA = b.a(str);
        bVar.e0(strA);
        int i4 = mediaDescription.f4304a.b;
        if ("audio".equals(mediaDescription.f4306a)) {
            iD = d(mediaDescription.f4304a.c, strA);
            bVar.f0(i4).H(iD);
        } else {
            iD = -1;
        }
        ImmutableMap<String, String> immutableMapA = mediaDescription.a();
        switch (strA) {
            case "audio/mp4a-latm":
                sb0.a(iD != -1);
                sb0.a(!immutableMapA.isEmpty());
                e(bVar, immutableMapA, iD, i4);
                break;
            case "audio/3gpp":
            case "audio/amr-wb":
                sb0.b(iD == 1, "Multi channel AMR is not currently supported.");
                sb0.b(!immutableMapA.isEmpty(), "fmtp parameters must include octet-align.");
                sb0.b(immutableMapA.containsKey(f4404c), "Only octet aligned mode is currently supported.");
                sb0.b(!immutableMapA.containsKey(f4405d), "Interleaving mode is not currently supported.");
                break;
            case "audio/opus":
                sb0.a(iD != -1);
                sb0.b(i4 == 48000, "Invalid OPUS clock rate.");
                break;
            case "video/mp4v-es":
                sb0.a(!immutableMapA.isEmpty());
                h(bVar, immutableMapA);
                break;
            case "video/3gpp":
                bVar.j0(352).Q(288);
                break;
            case "video/avc":
                sb0.a(!immutableMapA.isEmpty());
                f(bVar, immutableMapA);
                break;
            case "video/hevc":
                sb0.a(!immutableMapA.isEmpty());
                g(bVar, immutableMapA);
                break;
            case "video/x-vnd.on2.vp8":
                bVar.j0(320).Q(240);
                break;
            case "video/x-vnd.on2.vp9":
                bVar.j0(320).Q(240);
                break;
            case "audio/raw":
                bVar.Y(b.b(str));
                break;
        }
        sb0.a(i4 > 0);
        return new b(bVar.E(), i3, i4, immutableMapA);
    }

    public static byte[] c(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        int length = bArrDecode.length;
        byte[] bArr = kw5.f17801a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecode, 0, bArr2, bArr.length, bArrDecode.length);
        return bArr2;
    }

    public static int d(int i2, String str) {
        if (i2 != -1) {
            return i2;
        }
        return str.equals("audio/ac3") ? 6 : 1;
    }

    public static void e(com.google.android.exoplayer2.d.b bVar, ImmutableMap<String, String> immutableMap, int i2, int i3) {
        sb0.a(immutableMap.containsKey(f4402a));
        bVar.I("mp4a.40." + ((String) sb0.g(immutableMap.get(f4402a))));
        bVar.T(ImmutableList.of(AacUtil.a(i3, i2)));
    }

    public static void f(com.google.android.exoplayer2.d.b bVar, ImmutableMap<String, String> immutableMap) {
        sb0.a(immutableMap.containsKey(f4403b));
        String[] strArrU1 = gj9.u1((String) sb0.g(immutableMap.get(f4403b)), ",");
        sb0.a(strArrU1.length == 2);
        ImmutableList immutableListOf = ImmutableList.of(c(strArrU1[0]), c(strArrU1[1]));
        bVar.T(immutableListOf);
        byte[] bArr = immutableListOf.get(0);
        kw5.c cVarL = kw5.l(bArr, kw5.f17801a.length, bArr.length);
        bVar.a0(cVarL.f42930a);
        bVar.Q(cVarL.g);
        bVar.j0(cVarL.f);
        String str = immutableMap.get(f4402a);
        if (str == null) {
            bVar.I(en1.a(cVarL.f17808a, cVarL.b, cVarL.c));
            return;
        }
        bVar.I(k + str);
    }

    public static void g(com.google.android.exoplayer2.d.b bVar, ImmutableMap<String, String> immutableMap) {
        if (immutableMap.containsKey(f4409h)) {
            int i2 = Integer.parseInt((String) sb0.g(immutableMap.get(f4409h)));
            sb0.b(i2 == 0, "non-zero sprop-max-don-diff " + i2 + " is not supported");
        }
        sb0.a(immutableMap.containsKey(f4408g));
        String str = (String) sb0.g(immutableMap.get(f4408g));
        sb0.a(immutableMap.containsKey(f4406e));
        String str2 = (String) sb0.g(immutableMap.get(f4406e));
        sb0.a(immutableMap.containsKey(f4407f));
        ImmutableList immutableListOf = ImmutableList.of(c(str), c(str2), c((String) sb0.g(immutableMap.get(f4407f))));
        bVar.T(immutableListOf);
        byte[] bArr = immutableListOf.get(1);
        kw5.a aVarH = kw5.h(bArr, kw5.f17801a.length, bArr.length);
        bVar.a0(aVarH.f42928a);
        bVar.Q(aVarH.g).j0(aVarH.f);
        bVar.I(en1.c(aVarH.f17804a, aVarH.f17805a, aVarH.b, aVarH.c, aVarH.f17806a, aVarH.d));
    }

    public static void h(com.google.android.exoplayer2.d.b bVar, ImmutableMap<String, String> immutableMap) {
        String str = immutableMap.get("config");
        if (str != null) {
            byte[] bArrR = gj9.R(str);
            bVar.T(ImmutableList.of(bArrR));
            Pair<Integer, Integer> pairF = en1.f(bArrR);
            bVar.j0(((Integer) pairF.first).intValue()).Q(((Integer) pairF.second).intValue());
        } else {
            bVar.j0(352).Q(288);
        }
        String str2 = immutableMap.get(f4402a);
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        if (str2 == null) {
            str2 = "1";
        }
        sb.append(str2);
        bVar.I(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f4412a.equals(fVar.f4412a) && this.f4411a.equals(fVar.f4411a);
    }

    public int hashCode() {
        return ((217 + this.f4412a.hashCode()) * 31) + this.f4411a.hashCode();
    }
}
