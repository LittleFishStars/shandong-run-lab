package com.kc.dw.core.utils;

import android.os.Looper;
import com.kc.dw.core.domain.HttpResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a0 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f39345a;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f39346a;

        public a(a0 a0Var, IOException iOException) {
            this.f39346a = a0Var;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39346a.f39345a.getClass();
            Integer num = com.kc.dw.core.exception.b.f39252a;
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpResponse f39347a;
        public final a0 b;

        public b(a0 a0Var, HttpResponse httpResponse) {
            this.b = a0Var;
            this.f39347a = httpResponse;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                j jVar = this.b.f39345a;
                HttpResponse httpResponse = this.f39347a;
                jVar.getClass();
                LogUtil.d("DefaultHttpGetWithNoHandlerCallback", "onResponse: " + httpResponse.getErrorCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a0(j jVar) {
        this.f39345a = jVar;
    }

    public void onFailure(Call call, IOException iOException) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z.c.post(new a(this, iOException));
        }
    }

    public void onResponse(Call call, Response response) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        if (response.isSuccessful()) {
            httpResponse.setSuccessful(true);
            response.body();
        } else {
            httpResponse.setSuccessful(false);
            httpResponse.setErrorCode(response.code());
            httpResponse.setErrorDescription(response.message());
        }
        response.close();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z.c.post(new b(this, httpResponse));
            return;
        }
        try {
            this.f39345a.getClass();
            LogUtil.d("DefaultHttpGetWithNoHandlerCallback", "onResponse: " + httpResponse.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
