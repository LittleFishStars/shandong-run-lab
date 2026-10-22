package com.ipd.dsp.internal.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h<T> {
    public static final b<Object> e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f38295a;
    public final b<T> b;
    public final String c;
    public volatile byte[] d;

    public class a implements b<Object> {
        @Override // com.ipd.dsp.internal.f.h.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public h(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.c = com.ipd.dsp.internal.d0.m.a(str);
        this.f38295a = t;
        this.b = (b) com.ipd.dsp.internal.d0.m.a(bVar);
    }

    @NonNull
    public static <T> h<T> a(@NonNull String str) {
        return new h<>(str, null, a());
    }

    @Nullable
    public T b() {
        return this.f38295a;
    }

    @NonNull
    public final byte[] c() {
        if (this.d == null) {
            this.d = this.c.getBytes(f.b);
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.c.equals(((h) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + "'}";
    }

    @NonNull
    public static <T> h<T> a(@NonNull String str, @NonNull T t) {
        return new h<>(str, t, a());
    }

    @NonNull
    public static <T> h<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new h<>(str, null, bVar);
    }

    @NonNull
    public static <T> h<T> a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new h<>(str, t, bVar);
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.b.a(c(), t, messageDigest);
    }

    @NonNull
    public static <T> b<T> a() {
        return (b<T>) e;
    }
}
