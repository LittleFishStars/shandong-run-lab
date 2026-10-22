package cj.mobile.p;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences.Editor f22643a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22644a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Context context, String str, String str2) {
            this.f22644a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f22644a;
            if (context == null) {
                return;
            }
            SharedPreferences.Editor editorB = j.b(context);
            editorB.putString(this.b, this.c);
            editorB.apply();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22645a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public b(Context context, String str, int i) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22646a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public c(Context context, String str, int i) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22647a;

        public d(Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static SharedPreferences.Editor b(Context context) {
        if (f22643a == null) {
            f22643a = context.getSharedPreferences("cj_sp" + context.getPackageName(), 0).edit();
        }
        return f22643a;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getSharedPreferences("cj_sp" + context.getPackageName(), 0).getInt("gdt-reward" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()), 0);
    }

    public static void d(Context context) {
        cj.mobile.p.b.f22637a.execute(new d(context));
    }

    public static void a(Context context, String str, String str2) {
        cj.mobile.p.b.f22637a.execute(new a(context, str, str2));
    }

    public static void a(Context context, String str, int i) {
        cj.mobile.p.b.f22637a.execute(new c(context, str, i));
    }

    public static int a(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getSharedPreferences("cj_sp" + context.getPackageName(), 0).getInt(str + "index", 0);
    }

    public static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences("cj_sp" + context.getPackageName(), 0).getString(str, "");
    }

    public static void b(Context context, String str, int i) {
        cj.mobile.p.b.f22637a.execute(new b(context, str, i));
    }
}
