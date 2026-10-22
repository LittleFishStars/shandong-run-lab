package cj.mobile.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cj.mobile.ad.supply.Bean;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22206a;
    public Context b;
    public Bean c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public cj.mobile.f.b i;
    public TextView j;
    public Runnable k;
    public Handler l;

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22208a;
        public final /* synthetic */ a b;

        public b(a aVar, Context context) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22209a;
        public final /* synthetic */ a b;

        public c(a aVar, Context context) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22210a;

        public d(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22211a;

        public e(a aVar) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22212a;

        public f(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22213a;

        public g(a aVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public static /* synthetic */ int k(a aVar) {
    }

    /* JADX INFO: renamed from: cj.mobile.f.a$a, reason: collision with other inner class name */
    public class C0074a implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22207a;
        public final /* synthetic */ cj.mobile.f.b b;
        public final /* synthetic */ a c;

        public C0074a(a aVar, Context context, cj.mobile.f.b bVar) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public void a(Context context, String str, String str2, cj.mobile.f.b bVar) {
    }

    public final void a(Context context, String str, cj.mobile.f.b bVar) throws Exception {
    }

    public void a(Context context) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public final void a(String str) {
    }
}
