package com.getui.gtc.dyc.b;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.getui.gtc.dyc.b.b.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final b[] newArray(int i) {
            return new b[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30337a = "sdkconfig";
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private long i;
    private c j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30338a;
        private String b;
        private String c;
        private String e;
        private String f;
        private c h;
        private String d = b.f30337a;
        private long g = com.heytap.mcssdk.constant.a.g;

        public a a(String str) {
            this.f30338a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a e(String str) {
            this.d = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(long j) {
            this.g = j;
            return this;
        }

        public a h(c cVar) {
            this.h = cVar;
            return this;
        }

        public b i() {
            return new b(this);
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.h = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.e = parcel.readString();
        this.i = parcel.readLong();
    }

    private b(a aVar) {
        this.b = aVar.f30338a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.h = aVar.f;
        this.i = aVar.g;
        this.j = aVar.h;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String f() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public String g() {
        return this.h;
    }

    public void g(String str) {
        this.h = str;
    }

    public long h() {
        return this.i;
    }

    public void h(long j) {
        this.i = j;
    }

    public c i() {
        return this.j;
    }

    public void i(c cVar) {
        this.j = cVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.h);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.e);
        parcel.writeLong(this.i);
    }
}
