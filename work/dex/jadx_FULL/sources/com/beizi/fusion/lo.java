package com.beizi.fusion;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class lo {
    public static void a(fg fgVar, og ogVar) {
        ep.t.a(ogVar, fgVar);
    }

    public static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f27524a;
        private final C0315a b = new C0315a();

        /* JADX INFO: renamed from: com.beizi.fusion.lo$a$a, reason: collision with other inner class name */
        public static class C0315a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private char[] f27525a;
            private String b;

            private C0315a() {
            }

            public void a(char[] cArr) {
                this.f27525a = cArr;
                this.b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f27525a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f27525a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f27525a, i, i2 - i);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.b == null) {
                    this.b = new String(this.f27525a);
                }
                return this.b;
            }
        }

        public a(Appendable appendable) {
            this.f27524a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a(cArr);
            this.f27524a.append(this.b, i, i2 + i);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f27524a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f27524a.append((char) i);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
            this.f27524a.append(charSequence, i, i2);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) throws IOException {
            Objects.requireNonNull(str);
            this.f27524a.append(str, i, i2 + i);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
