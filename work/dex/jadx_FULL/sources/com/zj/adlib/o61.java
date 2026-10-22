package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o61 implements EncodedDestination {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o61 f43676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Set<f33> f18568a;
    public static final o61 b;
    public static final String c = "cct";
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g = "1$";
    public static final String h = "\\";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final String f18569a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final String f18570b;

    static {
        String strA = ss8.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        d = strA;
        String strA2 = ss8.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        e = strA2;
        String strA3 = ss8.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f = strA3;
        f18568a = Collections.unmodifiableSet(new HashSet(Arrays.asList(f33.b("proto"), f33.b("json"))));
        f43676a = new o61(strA, null);
        b = new o61(strA2, strA3);
    }

    public o61(@NonNull String str, @Nullable String str2) {
        this.f18569a = str;
        this.f18570b = str2;
    }

    @NonNull
    public static String d(@NonNull byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    @NonNull
    public static byte[] e(@NonNull String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    @NonNull
    public static o61 f(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith(g)) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote(h), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new o61(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public Set<f33> a() {
        return f18568a;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    @Nullable
    public byte[] b() {
        return c();
    }

    @Nullable
    public byte[] c() {
        String str = this.f18570b;
        if (str == null && this.f18569a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = g;
        objArr[1] = this.f18569a;
        objArr[2] = h;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String g() {
        return this.f18570b;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    @NonNull
    public String getName() {
        return "cct";
    }

    @NonNull
    public String h() {
        return this.f18569a;
    }
}
