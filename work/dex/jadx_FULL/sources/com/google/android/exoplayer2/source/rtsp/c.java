package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.zj.adlib.gj9;
import com.zj.adlib.u15;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {
    public static final int b = 1;
    public static final int c = 2;
    public static final String d = "Basic %s";
    public static final String e = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"";
    public static final String f = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"";
    public static final String g = "MD5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4397a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f4398b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f4399c;

    public c(int i, String str, String str2, String str3) {
        this.f30970a = i;
        this.f4397a = str;
        this.f4398b = str2;
        this.f4399c = str3;
    }

    public String a(g.a aVar, Uri uri, int i) throws ParserException {
        int i2 = this.f30970a;
        if (i2 == 1) {
            return b(aVar);
        }
        if (i2 == 2) {
            return c(aVar, uri, i);
        }
        throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
    }

    public final String b(g.a aVar) {
        return gj9.H(d, Base64.encodeToString(g.d(aVar.f30976a + u15.f19942b + aVar.b), 0));
    }

    public final String c(g.a aVar, Uri uri, int i) throws ParserException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String strT = g.t(i);
            String strC1 = gj9.C1(messageDigest.digest(g.d(aVar.f30976a + u15.f19942b + this.f4397a + u15.f19942b + aVar.b)));
            StringBuilder sb = new StringBuilder();
            sb.append(strT);
            sb.append(u15.f19942b);
            sb.append(uri);
            String strC2 = gj9.C1(messageDigest.digest(g.d(strC1 + u15.f19942b + this.f4398b + u15.f19942b + gj9.C1(messageDigest.digest(g.d(sb.toString()))))));
            return this.f4399c.isEmpty() ? gj9.H(e, aVar.f30976a, this.f4397a, this.f4398b, uri, strC2) : gj9.H(f, aVar.f30976a, this.f4397a, this.f4398b, uri, strC2, this.f4399c);
        } catch (NoSuchAlgorithmException e2) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, e2);
        }
    }
}
