package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5950a = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PatternCompiler f31602a = f();

    public static final class b implements PatternCompiler {
        public b() {
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean a() {
            return true;
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern b(String str) {
            return new JdkPattern(Pattern.compile(str));
        }
    }

    public static void a() {
    }

    public static CommonPattern b(String str) {
        i.E(str);
        return f31602a.b(str);
    }

    @CheckForNull
    public static String c(@CheckForNull String str) {
        if (k(str)) {
            return null;
        }
        return str;
    }

    public static String d(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    public static <T extends Enum<T>> Optional<T> e(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static PatternCompiler f() {
        return new b();
    }

    public static void g(ServiceConfigurationError serviceConfigurationError) {
        f5950a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    public static String h(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    public static boolean i() {
        return f31602a.a();
    }

    public static CharMatcher j(CharMatcher charMatcher) {
        return charMatcher.K();
    }

    public static boolean k(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }

    public static long l() {
        return System.nanoTime();
    }
}
