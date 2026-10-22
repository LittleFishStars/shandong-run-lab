package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.v39;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class CharSource {

    public final class a extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Charset f6337a;

        public a(Charset charset) {
            this.f6337a = (Charset) com.google.common.base.i.E(charset);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource a(Charset charset) {
            return charset.equals(this.f6337a) ? CharSource.this : super.a(charset);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return new q(CharSource.this.m(), this.f6337a, 8192);
        }

        public String toString() {
            String string = CharSource.this.toString();
            String strValueOf = String.valueOf(this.f6337a);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 15 + strValueOf.length());
            sb.append(string);
            sb.append(".asByteSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b extends CharSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Splitter f32166a = Splitter.m("\r\n|\n|\r");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CharSequence f6338a;

        public class a extends AbstractIterator<String> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public Iterator<String> f6339a;

            public a() {
                this.f6339a = b.f32166a.n(b.this.f6338a).iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public String computeNext() {
                if (this.f6339a.hasNext()) {
                    String next = this.f6339a.next();
                    if (this.f6339a.hasNext() || !next.isEmpty()) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        public b(CharSequence charSequence) {
            this.f6338a = (CharSequence) com.google.common.base.i.E(charSequence);
        }

        @Override // com.google.common.io.CharSource
        public boolean i() {
            return this.f6338a.length() == 0;
        }

        @Override // com.google.common.io.CharSource
        public long j() {
            return this.f6338a.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> k() {
            return Optional.of(Long.valueOf(this.f6338a.length()));
        }

        @Override // com.google.common.io.CharSource
        public Reader m() {
            return new com.google.common.io.c(this.f6338a);
        }

        @Override // com.google.common.io.CharSource
        public String n() {
            return this.f6338a.toString();
        }

        @Override // com.google.common.io.CharSource
        @CheckForNull
        public String o() {
            Iterator<String> itT = t();
            if (itT.hasNext()) {
                return itT.next();
            }
            return null;
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> p() {
            return ImmutableList.copyOf(t());
        }

        @Override // com.google.common.io.CharSource
        @ParametricNullness
        public <T> T q(LineProcessor<T> lineProcessor) throws IOException {
            Iterator<String> itT = t();
            while (itT.hasNext() && lineProcessor.a(itT.next())) {
            }
            return lineProcessor.getResult();
        }

        public final Iterator<String> t() {
            return new a();
        }

        public String toString() {
            String strK = com.google.common.base.a.k(this.f6338a, 30, v39.CHARACTER_ELLIPSIZE);
            StringBuilder sb = new StringBuilder(String.valueOf(strK).length() + 17);
            sb.append("CharSource.wrap(");
            sb.append(strK);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c extends CharSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends CharSource> f32168a;

        public c(Iterable<? extends CharSource> iterable) {
            this.f32168a = (Iterable) com.google.common.base.i.E(iterable);
        }

        @Override // com.google.common.io.CharSource
        public boolean i() throws IOException {
            Iterator<? extends CharSource> it = this.f32168a.iterator();
            while (it.hasNext()) {
                if (!it.next().i()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long j() throws IOException {
            Iterator<? extends CharSource> it = this.f32168a.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().j();
            }
            return j;
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> k() {
            Iterator<? extends CharSource> it = this.f32168a.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                Optional<Long> optionalK = it.next().k();
                if (!optionalK.isPresent()) {
                    return Optional.absent();
                }
                jLongValue += optionalK.get().longValue();
            }
            return Optional.of(Long.valueOf(jLongValue));
        }

        @Override // com.google.common.io.CharSource
        public Reader m() throws IOException {
            return new o(this.f32168a.iterator());
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32168a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
            sb.append("CharSource.concat(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32169a = new d();

        public d() {
            super("");
        }

        @Override // com.google.common.io.CharSource.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static class e extends b {
        public e(String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource
        public long e(CharSink charSink) throws Throwable {
            com.google.common.base.i.E(charSink);
            Closer closerG = Closer.g();
            try {
                ((Writer) closerG.h(charSink.b())).write((String) this.f6338a);
                long length = this.f6338a.length();
                closerG.close();
                return length;
            } catch (Throwable th) {
                try {
                    throw closerG.j(th);
                } catch (Throwable th2) {
                    closerG.close();
                    throw th2;
                }
            }
        }

        @Override // com.google.common.io.CharSource
        public long f(Appendable appendable) throws IOException {
            appendable.append(this.f6338a);
            return this.f6338a.length();
        }

        @Override // com.google.common.io.CharSource.b, com.google.common.io.CharSource
        public Reader m() {
            return new StringReader((String) this.f6338a);
        }
    }

    public static CharSource b(Iterable<? extends CharSource> iterable) {
        return new c(iterable);
    }

    public static CharSource c(Iterator<? extends CharSource> it) {
        return b(ImmutableList.copyOf(it));
    }

    public static CharSource d(CharSource... charSourceArr) {
        return b(ImmutableList.copyOf(charSourceArr));
    }

    public static CharSource h() {
        return d.f32169a;
    }

    public static CharSource r(CharSequence charSequence) {
        return charSequence instanceof String ? new e((String) charSequence) : new b(charSequence);
    }

    @Beta
    public ByteSource a(Charset charset) {
        return new a(charset);
    }

    @CanIgnoreReturnValue
    public long e(CharSink charSink) throws Throwable {
        com.google.common.base.i.E(charSink);
        Closer closerG = Closer.g();
        try {
            long jB = com.google.common.io.d.b((Reader) closerG.h(m()), (Writer) closerG.h(charSink.b()));
            closerG.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @CanIgnoreReturnValue
    public long f(Appendable appendable) throws Throwable {
        com.google.common.base.i.E(appendable);
        Closer closerG = Closer.g();
        try {
            long jB = com.google.common.io.d.b((Reader) closerG.h(m()), appendable);
            closerG.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public final long g(Reader reader) throws IOException {
        long j = 0;
        while (true) {
            long jSkip = reader.skip(Long.MAX_VALUE);
            if (jSkip == 0) {
                return j;
            }
            j += jSkip;
        }
    }

    public boolean i() throws Throwable {
        Optional<Long> optionalK = k();
        if (optionalK.isPresent()) {
            return optionalK.get().longValue() == 0;
        }
        Closer closerG = Closer.g();
        try {
            boolean z = ((Reader) closerG.h(m())).read() == -1;
            closerG.close();
            return z;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @Beta
    public long j() throws Throwable {
        Optional<Long> optionalK = k();
        if (optionalK.isPresent()) {
            return optionalK.get().longValue();
        }
        Closer closerG = Closer.g();
        try {
            long jG = g((Reader) closerG.h(m()));
            closerG.close();
            return jG;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @Beta
    public Optional<Long> k() {
        return Optional.absent();
    }

    public BufferedReader l() throws IOException {
        Reader readerM = m();
        return readerM instanceof BufferedReader ? (BufferedReader) readerM : new BufferedReader(readerM);
    }

    public abstract Reader m() throws IOException;

    public String n() throws Throwable {
        Closer closerG = Closer.g();
        try {
            String strK = com.google.common.io.d.k((Reader) closerG.h(m()));
            closerG.close();
            return strK;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @CheckForNull
    public String o() throws Throwable {
        Closer closerG = Closer.g();
        try {
            String line = ((BufferedReader) closerG.h(l())).readLine();
            closerG.close();
            return line;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public ImmutableList<String> p() throws Throwable {
        Closer closerG = Closer.g();
        try {
            BufferedReader bufferedReader = (BufferedReader) closerG.h(l());
            ArrayList arrayListQ = Lists.q();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) arrayListQ);
                    closerG.close();
                    return immutableListCopyOf;
                }
                arrayListQ.add(line);
            }
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @Beta
    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T q(LineProcessor<T> lineProcessor) throws Throwable {
        com.google.common.base.i.E(lineProcessor);
        Closer closerG = Closer.g();
        try {
            T t = (T) com.google.common.io.d.h((Reader) closerG.h(m()), lineProcessor);
            closerG.close();
            return t;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }
}
