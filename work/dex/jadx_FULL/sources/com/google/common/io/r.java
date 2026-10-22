package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class r {

    public class a implements LineProcessor<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f32199a = Lists.q();

        @Override // com.google.common.io.LineProcessor
        public boolean a(String str) {
            this.f32199a.add(str);
            return true;
        }

        @Override // com.google.common.io.LineProcessor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<String> getResult() {
            return this.f32199a;
        }
    }

    public static final class b extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f32200a;

        public /* synthetic */ b(URL url, a aVar) {
            this(url);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return this.f32200a.openStream();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32200a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("Resources.asByteSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public b(URL url) {
            this.f32200a = (URL) com.google.common.base.i.E(url);
        }
    }

    public static ByteSource a(URL url) {
        return new b(url, null);
    }

    public static CharSource b(URL url, Charset charset) {
        return a(url).a(charset);
    }

    public static void c(URL url, OutputStream outputStream) throws Throwable {
        a(url).g(outputStream);
    }

    @CanIgnoreReturnValue
    public static URL d(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        com.google.common.base.i.y(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }

    @CanIgnoreReturnValue
    public static URL e(String str) {
        URL resource = ((ClassLoader) com.google.common.base.e.a(Thread.currentThread().getContextClassLoader(), r.class.getClassLoader())).getResource(str);
        com.google.common.base.i.u(resource != null, "resource %s not found.", str);
        return resource;
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T f(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) b(url, charset).q(lineProcessor);
    }

    public static List<String> g(URL url, Charset charset) throws IOException {
        return (List) f(url, charset, new a());
    }

    public static byte[] h(URL url) throws IOException {
        return a(url).o();
    }

    public static String i(URL url, Charset charset) throws IOException {
        return b(url, charset).n();
    }
}
