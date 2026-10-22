package com.zj.adlib;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h76 {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f42064a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f16940a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f16941a;
        public a b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f42065a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public Object f16942a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public String f16943a;

            public a() {
            }
        }

        public b a(String str, char c) {
            return j(str, String.valueOf(c));
        }

        public b b(String str, double d) {
            return j(str, String.valueOf(d));
        }

        public b c(String str, float f) {
            return j(str, String.valueOf(f));
        }

        public b d(String str, int i) {
            return j(str, String.valueOf(i));
        }

        public b e(String str, long j) {
            return j(str, String.valueOf(j));
        }

        public b f(String str, @Nullable Object obj) {
            return j(str, obj);
        }

        public b g(String str, boolean z) {
            return j(str, String.valueOf(z));
        }

        public final a h() {
            a aVar = new a();
            this.b.f42065a = aVar;
            this.b = aVar;
            return aVar;
        }

        public final b i(@Nullable Object obj) {
            h().f16942a = obj;
            return this;
        }

        public final b j(String str, @Nullable Object obj) {
            a aVarH = h();
            aVarH.f16942a = obj;
            aVarH.f16943a = (String) ax6.i(str);
            return this;
        }

        public b k(char c) {
            return i(String.valueOf(c));
        }

        public b l(double d) {
            return i(String.valueOf(d));
        }

        public b m(float f) {
            return i(String.valueOf(f));
        }

        public b n(int i) {
            return i(String.valueOf(i));
        }

        public b o(long j) {
            return i(String.valueOf(j));
        }

        public b p(@Nullable Object obj) {
            return i(obj);
        }

        public b q(boolean z) {
            return i(String.valueOf(z));
        }

        public b r() {
            this.f16941a = true;
            return this;
        }

        public String toString() {
            boolean z = this.f16941a;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f16940a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f42064a.f42065a; aVar != null; aVar = aVar.f42065a) {
                if (!z || aVar.f16942a != null) {
                    sb.append(str);
                    String str2 = aVar.f16943a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(com.alipay.sdk.m.p.a.h);
                    }
                    sb.append(aVar.f16942a);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public b(String str) {
            a aVar = new a();
            this.f42064a = aVar;
            this.b = aVar;
            this.f16941a = false;
            this.f16940a = (String) ax6.i(str);
        }
    }

    @CheckReturnValue
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : (T) ax6.i(t2);
    }

    public static int c(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static String d(Class<?> cls) {
        String strReplaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int iLastIndexOf = strReplaceAll.lastIndexOf(36);
        if (iLastIndexOf == -1) {
            iLastIndexOf = strReplaceAll.lastIndexOf(46);
        }
        return strReplaceAll.substring(iLastIndexOf + 1);
    }

    public static b e(Class<?> cls) {
        return new b(d(cls));
    }

    public static b f(Object obj) {
        return new b(d(obj.getClass()));
    }

    public static b g(String str) {
        return new b(str);
    }
}
