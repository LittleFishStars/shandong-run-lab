package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class e {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0713b f31600a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f5945a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5946a;
        public C0713b b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5947b;

        public static final class a extends C0713b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: com.google.common.base.e$b$b, reason: collision with other inner class name */
        public static class C0713b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @CheckForNull
            public C0713b f31601a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @CheckForNull
            public Object f5948a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @CheckForNull
            public String f5949a;

            public C0713b() {
            }
        }

        public static boolean u(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof Optional) {
                return !((Optional) obj).isPresent();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        @CanIgnoreReturnValue
        public b a(String str, char c) {
            return m(str, String.valueOf(c));
        }

        @CanIgnoreReturnValue
        public b b(String str, double d) {
            return m(str, String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public b c(String str, float f) {
            return m(str, String.valueOf(f));
        }

        @CanIgnoreReturnValue
        public b d(String str, int i) {
            return m(str, String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public b e(String str, long j) {
            return m(str, String.valueOf(j));
        }

        @CanIgnoreReturnValue
        public b f(String str, @CheckForNull Object obj) {
            return j(str, obj);
        }

        @CanIgnoreReturnValue
        public b g(String str, boolean z) {
            return m(str, String.valueOf(z));
        }

        public final C0713b h() {
            C0713b c0713b = new C0713b();
            this.b.f31601a = c0713b;
            this.b = c0713b;
            return c0713b;
        }

        public final b i(@CheckForNull Object obj) {
            h().f5948a = obj;
            return this;
        }

        public final b j(String str, @CheckForNull Object obj) {
            C0713b c0713bH = h();
            c0713bH.f5948a = obj;
            c0713bH.f5949a = (String) i.E(str);
            return this;
        }

        public final a k() {
            a aVar = new a();
            this.b.f31601a = aVar;
            this.b = aVar;
            return aVar;
        }

        public final b l(Object obj) {
            ((C0713b) k()).f5948a = obj;
            return this;
        }

        public final b m(String str, Object obj) {
            a aVarK = k();
            ((C0713b) aVarK).f5948a = obj;
            ((C0713b) aVarK).f5949a = (String) i.E(str);
            return this;
        }

        @CanIgnoreReturnValue
        public b n(char c) {
            return l(String.valueOf(c));
        }

        @CanIgnoreReturnValue
        public b o(double d) {
            return l(String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public b p(float f) {
            return l(String.valueOf(f));
        }

        @CanIgnoreReturnValue
        public b q(int i) {
            return l(String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public b r(long j) {
            return l(String.valueOf(j));
        }

        @CanIgnoreReturnValue
        public b s(@CheckForNull Object obj) {
            return i(obj);
        }

        @CanIgnoreReturnValue
        public b t(boolean z) {
            return l(String.valueOf(z));
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0030  */
        /* JADX WARN: Code duplicated, block: B:14:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0041  */
        /* JADX WARN: Code duplicated, block: B:19:0x005e  */
        public String toString() {
            String str;
            boolean z = this.f5946a;
            boolean z2 = this.f5947b;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f5945a);
            sb.append('{');
            String str2 = "";
            for (C0713b c0713b = this.f31600a.f31601a; c0713b != null; c0713b = c0713b.f31601a) {
                Object obj = c0713b.f5948a;
                if (c0713b instanceof a) {
                    sb.append(str2);
                    str = c0713b.f5949a;
                    if (str != null) {
                        sb.append(str);
                        sb.append(com.alipay.sdk.m.p.a.h);
                    }
                    if (obj == null && obj.getClass().isArray()) {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str2 = ", ";
                } else if (obj == null) {
                    if (!z) {
                        sb.append(str2);
                        str = c0713b.f5949a;
                        if (str != null) {
                            sb.append(str);
                            sb.append(com.alipay.sdk.m.p.a.h);
                        }
                        if (obj == null) {
                            sb.append(obj);
                        } else {
                            sb.append(obj);
                        }
                        str2 = ", ";
                    }
                } else if (!z2 || !u(obj)) {
                    sb.append(str2);
                    str = c0713b.f5949a;
                    if (str != null) {
                        sb.append(str);
                        sb.append(com.alipay.sdk.m.p.a.h);
                    }
                    if (obj == null) {
                        sb.append(obj);
                    } else {
                        sb.append(obj);
                    }
                    str2 = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        @CanIgnoreReturnValue
        public b v() {
            this.f5946a = true;
            return this;
        }

        public b(String str) {
            C0713b c0713b = new C0713b();
            this.f31600a = c0713b;
            this.b = c0713b;
            this.f5946a = false;
            this.f5947b = false;
            this.f5945a = (String) i.E(str);
        }
    }

    public static <T> T a(@CheckForNull T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }

    public static b d(String str) {
        return new b(str);
    }
}
