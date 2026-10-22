package com.google.mlkit.vision.barcode.common;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import com.zj.adlib.eq1;
import com.zj.adlib.yw6;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Barcode {
    public static final int A = 11;
    public static final int B = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32468a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    public static final int i = 64;
    public static final int j = 128;
    public static final int k = 256;
    public static final int l = 512;
    public static final int m = 1024;
    public static final int n = 2048;
    public static final int o = 4096;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 4;
    public static final int u = 5;
    public static final int v = 6;
    public static final int w = 7;
    public static final int x = 8;
    public static final int y = 9;
    public static final int z = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Rect f6670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BarcodeSource f6671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Point[] f6672a;

    public static class Address {
        public static final int b = 0;
        public static final int c = 1;
        public static final int d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32469a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f6673a;

        @Retention(RetentionPolicy.CLASS)
        public @interface AddressType {
        }

        @KeepForSdk
        public Address(int i, @NonNull String[] strArr) {
            this.f32469a = i;
            this.f6673a = strArr;
        }

        @NonNull
        public String[] a() {
            return this.f6673a;
        }

        @AddressType
        public int getType() {
            return this.f32469a;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeFormat {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeValueType {
    }

    public static class Email {
        public static final int b = 0;
        public static final int c = 1;
        public static final int d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32470a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6674a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final String f6675b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public final String f6676c;

        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        @KeepForSdk
        public Email(int i, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.f32470a = i;
            this.f6674a = str;
            this.f6675b = str2;
            this.f6676c = str3;
        }

        @Nullable
        public String a() {
            return this.f6674a;
        }

        @Nullable
        public String b() {
            return this.f6676c;
        }

        @Nullable
        public String c() {
            return this.f6675b;
        }

        @FormatType
        public int getType() {
            return this.f32470a;
        }
    }

    public static class Phone {
        public static final int b = 0;
        public static final int c = 1;
        public static final int d = 2;
        public static final int e = 3;
        public static final int f = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32471a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6677a;

        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        @KeepForSdk
        public Phone(@Nullable String str, int i) {
            this.f6677a = str;
            this.f32471a = i;
        }

        @Nullable
        public String a() {
            return this.f6677a;
        }

        @FormatType
        public int getType() {
            return this.f32471a;
        }
    }

    public static class WiFi {
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32472a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6678a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final String f6679b;

        @Retention(RetentionPolicy.CLASS)
        public @interface EncryptionType {
        }

        @KeepForSdk
        public WiFi(@Nullable String str, @Nullable String str2, int i) {
            this.f6678a = str;
            this.f6679b = str2;
            this.f32472a = i;
        }

        @EncryptionType
        public int a() {
            return this.f32472a;
        }

        @Nullable
        public String b() {
            return this.f6679b;
        }

        @Nullable
        public String c() {
            return this.f6678a;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32473a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6680a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f6681a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        @KeepForSdk
        public a(int i, int i2, int i3, int i4, int i5, int i6, boolean z, @Nullable String str) {
            this.f32473a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.f6681a = z;
            this.f6680a = str;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public int d() {
            return this.b;
        }

        @Nullable
        public String e() {
            return this.f6680a;
        }

        public int f() {
            return this.f;
        }

        public int g() {
            return this.f32473a;
        }

        public boolean h() {
            return this.f6681a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final a f32474a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6682a;

        @Nullable
        public final a b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final String f6683b;

        @Nullable
        public final String c;

        @Nullable
        public final String d;

        @Nullable
        public final String e;

        @KeepForSdk
        public b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable a aVar, @Nullable a aVar2) {
            this.f6682a = str;
            this.f6683b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f32474a = aVar;
            this.b = aVar2;
        }

        @Nullable
        public String a() {
            return this.f6683b;
        }

        @Nullable
        public a b() {
            return this.b;
        }

        @Nullable
        public String c() {
            return this.c;
        }

        @Nullable
        public String d() {
            return this.d;
        }

        @Nullable
        public a e() {
            return this.f32474a;
        }

        @Nullable
        public String f() {
            return this.e;
        }

        @Nullable
        public String g() {
            return this.f6682a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final f f32475a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6684a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List f6685a;

        @Nullable
        public final String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List f6686b;
        public final List c;
        public final List d;

        @KeepForSdk
        public c(@Nullable f fVar, @Nullable String str, @Nullable String str2, @NonNull List<Phone> list, @NonNull List<Email> list2, @NonNull List<String> list3, @NonNull List<Address> list4) {
            this.f32475a = fVar;
            this.f6684a = str;
            this.b = str2;
            this.f6685a = list;
            this.f6686b = list2;
            this.c = list3;
            this.d = list4;
        }

        @NonNull
        public List<Address> a() {
            return this.d;
        }

        @NonNull
        public List<Email> b() {
            return this.f6686b;
        }

        @Nullable
        public f c() {
            return this.f32475a;
        }

        @Nullable
        public String d() {
            return this.f6684a;
        }

        @NonNull
        public List<Phone> e() {
            return this.f6685a;
        }

        @Nullable
        public String f() {
            return this.b;
        }

        @NonNull
        public List<String> g() {
            return this.c;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f32476a;

        @Nullable
        public final String b;

        @Nullable
        public final String c;

        @Nullable
        public final String d;

        @Nullable
        public final String e;

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

        @Nullable
        public final String l;

        @Nullable
        public final String m;

        @Nullable
        public final String n;

        @KeepForSdk
        public d(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14) {
            this.f32476a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
            this.i = str9;
            this.j = str10;
            this.k = str11;
            this.l = str12;
            this.m = str13;
            this.n = str14;
        }

        @Nullable
        public String a() {
            return this.g;
        }

        @Nullable
        public String b() {
            return this.h;
        }

        @Nullable
        public String c() {
            return this.f;
        }

        @Nullable
        public String d() {
            return this.i;
        }

        @Nullable
        public String e() {
            return this.m;
        }

        @Nullable
        public String f() {
            return this.f32476a;
        }

        @Nullable
        public String g() {
            return this.l;
        }

        @Nullable
        public String h() {
            return this.b;
        }

        @Nullable
        public String i() {
            return this.e;
        }

        @Nullable
        public String j() {
            return this.k;
        }

        @Nullable
        public String k() {
            return this.n;
        }

        @Nullable
        public String l() {
            return this.d;
        }

        @Nullable
        public String m() {
            return this.j;
        }

        @Nullable
        public String n() {
            return this.c;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f32477a;
        public final double b;

        @KeepForSdk
        public e(double d, double d2) {
            this.f32477a = d;
            this.b = d2;
        }

        public double a() {
            return this.f32477a;
        }

        public double b() {
            return this.b;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f32478a;

        @Nullable
        public final String b;

        @Nullable
        public final String c;

        @Nullable
        public final String d;

        @Nullable
        public final String e;

        @Nullable
        public final String f;

        @Nullable
        public final String g;

        @KeepForSdk
        public f(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.f32478a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
        }

        @Nullable
        public String a() {
            return this.d;
        }

        @Nullable
        public String b() {
            return this.f32478a;
        }

        @Nullable
        public String c() {
            return this.f;
        }

        @Nullable
        public String d() {
            return this.e;
        }

        @Nullable
        public String e() {
            return this.c;
        }

        @Nullable
        public String f() {
            return this.b;
        }

        @Nullable
        public String g() {
            return this.g;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f32479a;

        @Nullable
        public final String b;

        @KeepForSdk
        public g(@Nullable String str, @Nullable String str2) {
            this.f32479a = str;
            this.b = str2;
        }

        @Nullable
        public String a() {
            return this.f32479a;
        }

        @Nullable
        public String b() {
            return this.b;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f32480a;

        @Nullable
        public final String b;

        @KeepForSdk
        public h(@Nullable String str, @Nullable String str2) {
            this.f32480a = str;
            this.b = str2;
        }

        @Nullable
        public String a() {
            return this.f32480a;
        }

        @Nullable
        public String b() {
            return this.b;
        }
    }

    @KeepForSdk
    public Barcode(@NonNull BarcodeSource barcodeSource) {
        this(barcodeSource, null);
    }

    @Nullable
    public Rect a() {
        return this.f6670a;
    }

    @Nullable
    public b b() {
        return this.f6671a.g();
    }

    @Nullable
    public c c() {
        return this.f6671a.h();
    }

    @Nullable
    public Point[] d() {
        return this.f6672a;
    }

    @Nullable
    public String e() {
        return this.f6671a.b();
    }

    @Nullable
    public d f() {
        return this.f6671a.n();
    }

    @Nullable
    public Email g() {
        return this.f6671a.k();
    }

    @BarcodeFormat
    public int h() {
        int format = this.f6671a.getFormat();
        if (format > 4096 || format == 0) {
            return -1;
        }
        return format;
    }

    @Nullable
    public e i() {
        return this.f6671a.f();
    }

    @Nullable
    public Phone j() {
        return this.f6671a.d();
    }

    @Nullable
    public byte[] k() {
        byte[] bArrE = this.f6671a.e();
        if (bArrE != null) {
            return Arrays.copyOf(bArrE, bArrE.length);
        }
        return null;
    }

    @Nullable
    public String l() {
        return this.f6671a.a();
    }

    @Nullable
    public g m() {
        return this.f6671a.m();
    }

    @Nullable
    public h n() {
        return this.f6671a.c();
    }

    @BarcodeValueType
    public int o() {
        return this.f6671a.l();
    }

    @Nullable
    public WiFi p() {
        return this.f6671a.j();
    }

    @KeepForSdk
    public Barcode(@NonNull BarcodeSource barcodeSource, @Nullable Matrix matrix) {
        this.f6671a = (BarcodeSource) yw6.l(barcodeSource);
        Rect rectI = barcodeSource.i();
        if (rectI != null && matrix != null) {
            eq1.g(rectI, matrix);
        }
        this.f6670a = rectI;
        Point[] pointArrO = barcodeSource.o();
        if (pointArrO != null && matrix != null) {
            eq1.d(pointArrO, matrix);
        }
        this.f6672a = pointArrO;
    }
}
