package cj.mobile.c;

import android.content.Context;
import android.widget.ImageView;
import cj.mobile.ad.supply.Bean;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Boolean> f22093a = new HashMap();

    public class a implements cj.mobile.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bean f22094a;
        public final /* synthetic */ Context b;

        public a(Bean bean, Context context) {
        }

        @Override // cj.mobile.c.a
        public void a() {
        }

        @Override // cj.mobile.c.a
        public void a(int i) {
        }

        @Override // cj.mobile.c.a
        public void onSuccess() {
        }
    }

    public class b implements cj.mobile.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bean f22095a;
        public final /* synthetic */ Context b;

        public b(Bean bean, Context context) {
        }

        @Override // cj.mobile.c.a
        public void a() {
        }

        @Override // cj.mobile.c.a
        public void a(int i) {
        }

        @Override // cj.mobile.c.a
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.c.c$c, reason: collision with other inner class name */
    public class C0069c implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.c.a f22096a;
        public final /* synthetic */ File b;

        public C0069c(cj.mobile.c.a aVar, File file) {
        }

        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
        }
    }

    public static void a(Context context, ImageView imageView, String str) {
    }

    public static boolean a(int i) {
    }

    public static void b(Context context, String str) {
    }

    public static void c(Context context, String str) {
    }

    public static void a(Context context, Bean bean) {
    }

    public static void a(Context context, String str, String str2, cj.mobile.c.a aVar) {
    }

    public static boolean a(Context context, String str) {
    }
}
