package cj.mobile.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import cj.mobile.ad.supply.Bean;
import cj.mobile.p.d;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22203a;
    public String b;
    public cj.mobile.e.b c;
    public String d;
    public Bean e;
    public boolean f;
    public Handler g;

    /* JADX INFO: renamed from: cj.mobile.e.a$a, reason: collision with other inner class name */
    public class C0073a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22204a;
        public final /* synthetic */ cj.mobile.e.b b;
        public final /* synthetic */ a c;

        public C0073a(a aVar, Context context, cj.mobile.e.b bVar) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22205a;

        public b(a aVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public void a(int i) {
    }

    public final void b(Context context, String str, cj.mobile.e.b bVar) throws Exception {
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(Context context, String str, String str2, cj.mobile.e.b bVar) {
    }

    public void a(Context context, cj.mobile.e.b bVar) {
    }

    public void a(Context context, String str, cj.mobile.e.b bVar) {
    }

    public void a(Activity activity) {
    }
}
