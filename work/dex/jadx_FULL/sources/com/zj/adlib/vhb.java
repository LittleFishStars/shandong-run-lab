package com.zj.adlib;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vhb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<CharsetDecoder> f45354a = new a();
    public static final ThreadLocal<Charset> b = new b();
    public static final ThreadLocal<CharBuffer> c = new ThreadLocal<>();

    public static class a extends ThreadLocal<CharsetDecoder> {
        public static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    public static class b extends ThreadLocal<Charset> {
        public static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Charset initialValue() {
            return a();
        }
    }
}
