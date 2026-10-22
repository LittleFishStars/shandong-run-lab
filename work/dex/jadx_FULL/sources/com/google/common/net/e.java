package com.google.common.net;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.aliyun.vod.common.utils.IOUtils;
import com.fl.saas.common.util.FileTypeUtils;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.i;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.zj.adlib.dv9;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f6410d = "charset";

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f6411e = "application";

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f6412f = "audio";

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f6413g = "image";

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f6414h = "text";

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f6415i = "video";

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final String f6417k = "*";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @LazyInit
    public int f6418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    @LazyInit
    public Optional<Charset> f6419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableListMultimap<String, String> f6420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6421a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f6422b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @CheckForNull
    @LazyInit
    public String f6423c;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ImmutableListMultimap<String, String> f6407b = ImmutableListMultimap.of("charset", com.google.common.base.a.g(com.google.common.base.b.c.name()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharMatcher f32228a = CharMatcher.f().b(CharMatcher.v().F()).b(CharMatcher.s(' ')).b(CharMatcher.H("()<>@,;:\\\"/[]?="));
    public static final CharMatcher b = CharMatcher.f().b(CharMatcher.H("\"\\\r"));
    public static final CharMatcher c = CharMatcher.d(" \t\r\n");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<e, e> f6406a = Maps.Y();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final e f6405a = j("*", "*");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final e f6408b = j("text", "*");

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final e f6409c = j("image", "*");
    public static final e d = j("audio", "*");
    public static final e e = j("video", "*");
    public static final e f = j("application", "*");

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f6416j = "font";
    public static final e g = j(f6416j, "*");
    public static final e h = k("text", "cache-manifest");
    public static final e i = k("text", "css");
    public static final e j = k("text", "csv");
    public static final e k = k("text", "html");
    public static final e l = k("text", "calendar");
    public static final e m = k("text", "plain");
    public static final e n = k("text", "javascript");
    public static final e o = k("text", "tab-separated-values");
    public static final e p = k("text", "vcard");
    public static final e q = k("text", "vnd.wap.wml");
    public static final e r = k("text", AliyunVodHttpCommon.Format.FORMAT_XML);
    public static final e s = k("text", "vtt");
    public static final e t = j("image", FileTypeUtils.FILE_TYPE_BMP);
    public static final e u = j("image", "x-canon-crw");
    public static final e v = j("image", FileTypeUtils.FILE_TYPE_GIF);
    public static final e w = j("image", "vnd.microsoft.icon");
    public static final e x = j("image", AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG);
    public static final e y = j("image", "png");
    public static final e z = j("image", "vnd.adobe.photoshop");
    public static final e A = k("image", "svg+xml");
    public static final e B = j("image", "tiff");
    public static final e C = j("image", "webp");
    public static final e D = j("image", "heif");
    public static final e E = j("image", "jp2");
    public static final e F = j("audio", "mp4");
    public static final e G = j("audio", "mpeg");
    public static final e H = j("audio", "ogg");
    public static final e I = j("audio", MatroskaExtractor.c);
    public static final e J = j("audio", "l16");
    public static final e K = j("audio", "l24");
    public static final e L = j("audio", "basic");
    public static final e M = j("audio", "aac");
    public static final e N = j("audio", "vorbis");
    public static final e O = j("audio", "x-ms-wma");
    public static final e P = j("audio", "x-ms-wax");
    public static final e Q = j("audio", "vnd.rn-realaudio");
    public static final e R = j("audio", "vnd.wave");
    public static final e S = j("video", "mp4");
    public static final e T = j("video", "mpeg");
    public static final e U = j("video", "ogg");
    public static final e V = j("video", "quicktime");
    public static final e W = j("video", MatroskaExtractor.c);
    public static final e X = j("video", "x-ms-wmv");
    public static final e Y = j("video", "x-flv");
    public static final e Z = j("video", "3gpp");
    public static final e a0 = j("video", "3gpp2");
    public static final e b0 = k("application", AliyunVodHttpCommon.Format.FORMAT_XML);
    public static final e c0 = k("application", "atom+xml");
    public static final e d0 = j("application", "x-bzip2");
    public static final e e0 = k("application", "dart");
    public static final e f0 = j("application", "vnd.apple.pkpass");
    public static final e g0 = j("application", "vnd.ms-fontobject");
    public static final e h0 = j("application", "epub+zip");
    public static final e i0 = j("application", "x-www-form-urlencoded");
    public static final e j0 = j("application", "pkcs12");
    public static final e k0 = j("application", "binary");
    public static final e l0 = j("application", "geo+json");
    public static final e m0 = j("application", "x-gzip");
    public static final e n0 = j("application", "hal+json");
    public static final e o0 = k("application", "javascript");
    public static final e p0 = j("application", "jose");
    public static final e q0 = j("application", "jose+json");
    public static final e r0 = k("application", "json");
    public static final e s0 = k("application", "manifest+json");
    public static final e t0 = j("application", "vnd.google-earth.kml+xml");
    public static final e u0 = j("application", "vnd.google-earth.kmz");
    public static final e v0 = j("application", "mbox");
    public static final e w0 = j("application", "x-apple-aspen-config");
    public static final e x0 = j("application", "vnd.ms-excel");
    public static final e y0 = j("application", "vnd.ms-outlook");
    public static final e z0 = j("application", "vnd.ms-powerpoint");
    public static final e A0 = j("application", "msword");
    public static final e B0 = j("application", "dash+xml");
    public static final e C0 = j("application", "wasm");
    public static final e D0 = j("application", "x-nacl");
    public static final e E0 = j("application", "x-pnacl");
    public static final e F0 = j("application", "octet-stream");
    public static final e G0 = j("application", "ogg");
    public static final e H0 = j("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final e I0 = j("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final e J0 = j("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final e K0 = j("application", "vnd.oasis.opendocument.graphics");
    public static final e L0 = j("application", "vnd.oasis.opendocument.presentation");
    public static final e M0 = j("application", "vnd.oasis.opendocument.spreadsheet");
    public static final e N0 = j("application", "vnd.oasis.opendocument.text");
    public static final e O0 = k("application", "opensearchdescription+xml");
    public static final e P0 = j("application", "pdf");
    public static final e Q0 = j("application", "postscript");
    public static final e R0 = j("application", "protobuf");
    public static final e S0 = k("application", "rdf+xml");
    public static final e T0 = k("application", "rtf");
    public static final e U0 = j("application", "font-sfnt");
    public static final e V0 = j("application", "x-shockwave-flash");
    public static final e W0 = j("application", "vnd.sketchup.skp");
    public static final e X0 = k("application", "soap+xml");
    public static final e Y0 = j("application", "x-tar");
    public static final e Z0 = j("application", "font-woff");
    public static final e a1 = j("application", "font-woff2");
    public static final e b1 = k("application", "xhtml+xml");
    public static final e c1 = k("application", "xrd+xml");
    public static final e d1 = j("application", "zip");
    public static final e e1 = j(f6416j, "collection");
    public static final e f1 = j(f6416j, "otf");
    public static final e g1 = j(f6416j, "sfnt");
    public static final e h1 = j(f6416j, "ttf");
    public static final e i1 = j(f6416j, "woff");
    public static final e j1 = j(f6416j, "woff2");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final com.google.common.base.d.C0712d f6404a = com.google.common.base.d.p("; ").u("=");

    public class a implements Function<Collection<String>, ImmutableMultiset<String>> {
        public a(e eVar) {
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableMultiset<String> apply(Collection<String> collection) {
            return ImmutableMultiset.copyOf(collection);
        }
    }

    public class b implements Function<String, String> {
        public b(e eVar) {
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return (!e.f32228a.C(str) || str.isEmpty()) ? e.p(str) : str;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32229a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f6424a;

        public c(String str) {
            this.f6424a = str;
        }

        public char a(char c) {
            i.g0(e());
            i.g0(f() == c);
            this.f32229a++;
            return c;
        }

        public char b(CharMatcher charMatcher) {
            i.g0(e());
            char cF = f();
            i.g0(charMatcher.B(cF));
            this.f32229a++;
            return cF;
        }

        public String c(CharMatcher charMatcher) {
            int i = this.f32229a;
            String strD = d(charMatcher);
            i.g0(this.f32229a != i);
            return strD;
        }

        public String d(CharMatcher charMatcher) {
            i.g0(e());
            int i = this.f32229a;
            this.f32229a = charMatcher.F().o(this.f6424a, i);
            return e() ? this.f6424a.substring(i, this.f32229a) : this.f6424a.substring(i);
        }

        public boolean e() {
            int i = this.f32229a;
            return i >= 0 && i < this.f6424a.length();
        }

        public char f() {
            i.g0(e());
            return this.f6424a.charAt(this.f32229a);
        }
    }

    public e(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.f6421a = str;
        this.f6422b = str2;
        this.f6420a = immutableListMultimap;
    }

    public static e c(e eVar) {
        f6406a.put(eVar, eVar);
        return eVar;
    }

    public static e f(String str, String str2) {
        e eVarG = g(str, str2, ImmutableListMultimap.of());
        eVarG.f6419a = Optional.absent();
        return eVarG;
    }

    public static e g(String str, String str2, Multimap<String, String> multimap) {
        i.E(str);
        i.E(str2);
        i.E(multimap);
        String strT = t(str);
        String strT2 = t(str2);
        i.e(!"*".equals(strT) || "*".equals(strT2), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.a aVarBuilder = ImmutableListMultimap.builder();
        for (Map.Entry<String, String> entry : multimap.entries()) {
            String strT3 = t(entry.getKey());
            aVarBuilder.f(strT3, s(strT3, entry.getValue()));
        }
        e eVar = new e(strT, strT2, aVarBuilder.a());
        return (e) com.google.common.base.e.a(f6406a.get(eVar), eVar);
    }

    public static e h(String str) {
        return f("application", str);
    }

    public static e i(String str) {
        return f("audio", str);
    }

    public static e j(String str, String str2) {
        e eVarC = c(new e(str, str2, ImmutableListMultimap.of()));
        eVarC.f6419a = Optional.absent();
        return eVarC;
    }

    public static e k(String str, String str2) {
        e eVarC = c(new e(str, str2, f6407b));
        eVarC.f6419a = Optional.of(com.google.common.base.b.c);
        return eVarC;
    }

    public static e l(String str) {
        return f(f6416j, str);
    }

    public static e m(String str) {
        return f("image", str);
    }

    public static e n(String str) {
        return f("text", str);
    }

    public static e o(String str) {
        return f("video", str);
    }

    public static String p(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String s(String str, String str2) {
        i.E(str2);
        i.u(CharMatcher.f().C(str2), "parameter values must be ASCII: %s", str2);
        return "charset".equals(str) ? com.google.common.base.a.g(str2) : str2;
    }

    public static String t(String str) {
        i.d(f32228a.C(str));
        i.d(!str.isEmpty());
        return com.google.common.base.a.g(str);
    }

    public static e w(String str) {
        String strC;
        i.E(str);
        c cVar = new c(str);
        try {
            CharMatcher charMatcher = f32228a;
            String strC2 = cVar.c(charMatcher);
            cVar.a('/');
            String strC3 = cVar.c(charMatcher);
            ImmutableListMultimap.a aVarBuilder = ImmutableListMultimap.builder();
            while (cVar.e()) {
                CharMatcher charMatcher2 = c;
                cVar.d(charMatcher2);
                cVar.a(dv9.e);
                cVar.d(charMatcher2);
                CharMatcher charMatcher3 = f32228a;
                String strC4 = cVar.c(charMatcher3);
                cVar.a(com.alipay.sdk.m.p.a.h);
                if ('\"' == cVar.f()) {
                    cVar.a('\"');
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != cVar.f()) {
                        if ('\\' == cVar.f()) {
                            cVar.a(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append(cVar.b(CharMatcher.f()));
                        } else {
                            sb.append(cVar.c(b));
                        }
                    }
                    strC = sb.toString();
                    cVar.a('\"');
                } else {
                    strC = cVar.c(charMatcher3);
                }
                aVarBuilder.f(strC4, strC);
            }
            return g(strC2, strC3, aVarBuilder.a());
        } catch (IllegalStateException e2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 18);
            sb2.append("Could not parse '");
            sb2.append(str);
            sb2.append("'");
            throw new IllegalArgumentException(sb2.toString(), e2);
        }
    }

    public e A(String str, String str2) {
        return C(str, ImmutableSet.of(str2));
    }

    public e B(Multimap<String, String> multimap) {
        return g(this.f6421a, this.f6422b, multimap);
    }

    public e C(String str, Iterable<String> iterable) {
        i.E(str);
        i.E(iterable);
        String strT = t(str);
        ImmutableListMultimap.a aVarBuilder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.f6420a.entries().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!strT.equals(key)) {
                aVarBuilder.f(key, next.getValue());
            }
        }
        Iterator<String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            aVarBuilder.f(strT, s(strT, it2.next()));
        }
        e eVar = new e(this.f6421a, this.f6422b, aVarBuilder.a());
        if (!strT.equals("charset")) {
            eVar.f6419a = this.f6419a;
        }
        return (e) com.google.common.base.e.a(f6406a.get(eVar), eVar);
    }

    public e D() {
        return this.f6420a.isEmpty() ? this : f(this.f6421a, this.f6422b);
    }

    public Optional<Charset> d() {
        Optional<Charset> optionalAbsent = this.f6419a;
        if (optionalAbsent == null) {
            optionalAbsent = Optional.absent();
            UnmodifiableIterator<String> it = this.f6420a.get("charset").iterator();
            String str = null;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optionalAbsent = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    StringBuilder sb = new StringBuilder(str.length() + 35 + String.valueOf(next).length());
                    sb.append("Multiple charset values defined: ");
                    sb.append(str);
                    sb.append(", ");
                    sb.append(next);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.f6419a = optionalAbsent;
        }
        return optionalAbsent;
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6421a);
        sb.append('/');
        sb.append(this.f6422b);
        if (!this.f6420a.isEmpty()) {
            sb.append("; ");
            f6404a.d(sb, Multimaps.E(this.f6420a, new b(this)).entries());
        }
        return sb.toString();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6421a.equals(eVar.f6421a) && this.f6422b.equals(eVar.f6422b) && v().equals(eVar.v());
    }

    public int hashCode() {
        int i2 = this.f6418a;
        if (i2 != 0) {
            return i2;
        }
        int iB = com.google.common.base.g.b(this.f6421a, this.f6422b, v());
        this.f6418a = iB;
        return iB;
    }

    public boolean q() {
        return "*".equals(this.f6421a) || "*".equals(this.f6422b);
    }

    public boolean r(e eVar) {
        return (eVar.f6421a.equals("*") || eVar.f6421a.equals(this.f6421a)) && (eVar.f6422b.equals("*") || eVar.f6422b.equals(this.f6422b)) && this.f6420a.entries().containsAll(eVar.f6420a.entries());
    }

    public String toString() {
        String str = this.f6423c;
        if (str != null) {
            return str;
        }
        String strE = e();
        this.f6423c = strE;
        return strE;
    }

    public ImmutableListMultimap<String, String> u() {
        return this.f6420a;
    }

    public final Map<String, ImmutableMultiset<String>> v() {
        return Maps.B0(this.f6420a.asMap(), new a(this));
    }

    public String x() {
        return this.f6422b;
    }

    public String y() {
        return this.f6421a;
    }

    public e z(Charset charset) {
        i.E(charset);
        e eVarA = A("charset", charset.name());
        eVarA.f6419a = Optional.of(charset);
        return eVarA;
    }
}
