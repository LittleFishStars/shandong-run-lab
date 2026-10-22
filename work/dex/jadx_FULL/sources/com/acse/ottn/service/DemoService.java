package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.acse.ottn.h2;
import com.acse.ottn.i;
import com.acse.ottn.io.reactivex.ObservableEmitter;
import com.acse.ottn.io.reactivex.ObservableOnSubscribe;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.o;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DemoService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23197a = "DemoService";

    public class a implements Consumer<String> {
        public a() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o.c().a(DemoService.this, str);
            DemoService.this.stopSelf();
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class c implements ObservableOnSubscribe<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23200a;

        public c(String str) {
            this.f23200a = str;
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            String string;
            try {
                string = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f23200a).build()).execute().body().string()).getString("content");
                h2.a("samon-->code1", string);
            } catch (Exception e) {
                e.printStackTrace();
                h2.a("samon-->code11", "shortcode is null");
                h2.a(DemoService.f23197a, e.getMessage());
                string = "";
            }
            observableEmitter.onNext(string);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tkl_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    a(stringExtra);
                } catch (Exception unused) {
                    h2.b(f23197a, "request code fail ");
                }
            }
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void a(String str) {
        Observable.h1(new c(str)).u5(Schedulers.newThread()).G3(i.a()).s5(new a(), new b());
    }
}
