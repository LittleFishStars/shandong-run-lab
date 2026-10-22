package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28219a = "KEY_LOCALE";
    public static final String b = "VALUE_FOLLOW_SYSTEM";

    public class a implements Utils.Consumer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f28220a;

        public a(boolean z) {
            this.f28220a = z;
        }

        @Override // com.blankj.utilcode.util.Utils.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            if (bool.booleanValue()) {
                d.t(this.f28220a);
            } else {
                i.P0();
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Utils.Consumer f28221a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Locale f1425a;

        public b(Locale locale, int i, Utils.Consumer consumer) {
            this.f1425a = locale;
            this.K = i;
            this.f28221a = consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.s(this.f1425a, this.K + 1, this.f28221a);
        }
    }

    public d() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void b(Activity activity) {
        String strQ = i.c0().q(f28219a);
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        Locale localeL = b.equals(strQ) ? l(Resources.getSystem().getConfiguration()) : v(strQ);
        if (localeL == null) {
            return;
        }
        y(activity, localeL);
        y(Utils.a(), localeL);
    }

    public static void c(@NonNull Locale locale) {
        d(locale, false);
    }

    public static void d(@NonNull Locale locale, boolean z) {
        e(locale, z);
    }

    public static void e(Locale locale, boolean z) {
        if (locale == null) {
            i.c0().C(f28219a, b, true);
        } else {
            i.c0().C(f28219a, r(locale), true);
        }
        if (locale == null) {
            locale = l(Resources.getSystem().getConfiguration());
        }
        x(locale, new a(z));
    }

    public static void f() {
        g(false);
    }

    public static void g(boolean z) {
        e(null, z);
    }

    public static Context h(Context context) {
        Locale localeV;
        String strQ = i.c0().q(f28219a);
        if (TextUtils.isEmpty(strQ) || b.equals(strQ) || (localeV = v(strQ)) == null) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        u(configuration, localeV);
        return context.createConfigurationContext(configuration);
    }

    public static Locale i() {
        return k(Utils.a());
    }

    public static Locale j() {
        String strQ = i.c0().q(f28219a);
        if (TextUtils.isEmpty(strQ) || b.equals(strQ)) {
            return null;
        }
        return v(strQ);
    }

    public static Locale k(Context context) {
        return l(context.getResources().getConfiguration());
    }

    public static Locale l(Configuration configuration) {
        return configuration.getLocales().get(0);
    }

    public static Locale m() {
        return l(Resources.getSystem().getConfiguration());
    }

    public static boolean n() {
        return j() != null;
    }

    public static boolean o(@NonNull Locale locale) {
        Locale localeJ = j();
        if (localeJ == null) {
            return false;
        }
        return q(locale, localeJ);
    }

    public static boolean p(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '$') {
                if (i >= 1) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }

    public static boolean q(Locale locale, Locale locale2) {
        return i.z(locale2.getLanguage(), locale.getLanguage()) && i.z(locale2.getCountry(), locale.getCountry());
    }

    public static String r(Locale locale) {
        return locale.getLanguage() + "$" + locale.getCountry();
    }

    public static void s(Locale locale, int i, Utils.Consumer<Boolean> consumer) {
        Resources resources = Utils.a().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale localeL = l(configuration);
        u(configuration, locale);
        Utils.a().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (consumer == null) {
            return;
        }
        if (q(localeL, locale)) {
            consumer.accept(Boolean.TRUE);
        } else if (i < 20) {
            i.U0(new b(locale, i, consumer), 16L);
        } else {
            Log.e("LanguageUtils", "appLocal didn't update.");
            consumer.accept(Boolean.FALSE);
        }
    }

    public static void t(boolean z) {
        if (z) {
            i.P0();
            return;
        }
        Iterator<Activity> it = i.I().iterator();
        while (it.hasNext()) {
            it.next().recreate();
        }
    }

    public static void u(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    public static Locale v(String str) {
        Locale localeW = w(str);
        if (localeW == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            i.c0().H(f28219a);
        }
        return localeW;
    }

    public static Locale w(String str) {
        if (!p(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void x(@NonNull Locale locale, @Nullable Utils.Consumer<Boolean> consumer) {
        s(locale, 0, consumer);
    }

    public static void y(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        u(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
