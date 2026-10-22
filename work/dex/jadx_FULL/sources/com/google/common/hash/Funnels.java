package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.i;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class Funnels {

    public enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.c(bArr);
        }
    }

    public enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.j(num.intValue());
        }
    }

    public enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.i(l.longValue());
        }
    }

    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) i.E(funnel);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.elementFunnel);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
            sb.append("Funnels.sequentialFunnel(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), primitiveSink);
            }
        }
    }

    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        public static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            public SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.f(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset charset) {
            this.charset = (Charset) i.E(charset);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            String strName = this.charset.name();
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 22);
            sb.append("Funnels.stringFunnel(");
            sb.append(strName);
            sb.append(")");
            return sb.toString();
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.e(charSequence, this.charset);
        }
    }

    public enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.a(charSequence);
        }
    }

    public static class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrimitiveSink f32124a;

        public a(PrimitiveSink primitiveSink) {
            this.f32124a = (PrimitiveSink) i.E(primitiveSink);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32124a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("Funnels.asOutputStream(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f32124a.g((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f32124a.c(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f32124a.h(bArr, i, i2);
        }
    }

    public static OutputStream a(PrimitiveSink primitiveSink) {
        return new a(primitiveSink);
    }

    public static Funnel<byte[]> b() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<Integer> c() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> d() {
        return LongFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> e(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    public static Funnel<CharSequence> f(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    public static Funnel<CharSequence> g() {
        return UnencodedCharsFunnel.INSTANCE;
    }
}
