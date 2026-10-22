package cj.mobile.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import cj.mobile.ad.supply.Bean;
import cj.mobile.ad.supply.interstitial.InterstitialDialog;
import cj.mobile.p.d;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialDialog f22200a;
    public Context b;
    public Bean c;
    public String d;
    public String e;
    public cj.mobile.d.b f;
    public String g;
    public String h;
    public Handler i;

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22202a;

        public b(a aVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.d.a$a, reason: collision with other inner class name */
    public class C0072a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22201a;
        public final /* synthetic */ cj.mobile.d.b b;
        public final /* synthetic */ a c;

        public C0072a(a aVar, Context context, cj.mobile.d.b bVar) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public void a(Context context, String str, String str2, cj.mobile.d.b bVar) {
    }

    public final void a(Context context, String str, cj.mobile.d.b bVar) throws Exception {
    }

    public final void a(Context context) {
    }

    public void a(Activity activity) {
    }
}
