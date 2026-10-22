package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.q13;
import com.zj.adlib.qq0;
import com.zj.adlib.ze3;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends BaseNetworkFetcher<ze3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30026a = 3;
    public static final int b = 5;
    public static final int c = 307;
    public static final int d = 308;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f1698a;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.a$a, reason: collision with other inner class name */
    public class RunnableC0638a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkFetcher.Callback f30027a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ze3 f1700a;

        public RunnableC0638a(ze3 ze3Var, NetworkFetcher.Callback callback) {
            this.f1700a = ze3Var;
            this.f30027a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h(this.f1700a, this.f30027a);
        }
    }

    public class b extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkFetcher.Callback f30028a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Future f1702a;

        public b(Future future, NetworkFetcher.Callback callback) {
            this.f1702a = future;
            this.f30028a = callback;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            if (this.f1702a.cancel(false)) {
                this.f30028a.a();
            }
        }
    }

    public a() {
        this(Executors.newFixedThreadPool(3));
    }

    public static String g(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static boolean i(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public static boolean j(int i) {
        return i >= 200 && i < 300;
    }

    @VisibleForTesting
    public static HttpURLConnection k(Uri uri) throws IOException {
        return (HttpURLConnection) new URL(uri.toString()).openConnection();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public ze3 a(Consumer<q13> consumer, ProducerContext producerContext) {
        return new ze3(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void b(ze3 ze3Var, NetworkFetcher.Callback callback) {
        ze3Var.getContext().g(new b(this.f1698a.submit(new RunnableC0638a(ze3Var, callback)), callback));
    }

    public final HttpURLConnection f(Uri uri, int i) throws IOException {
        HttpURLConnection httpURLConnectionK = k(uri);
        int responseCode = httpURLConnectionK.getResponseCode();
        if (j(responseCode)) {
            return httpURLConnectionK;
        }
        if (!i(responseCode)) {
            httpURLConnectionK.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        String headerField = httpURLConnectionK.getHeaderField("Location");
        httpURLConnectionK.disconnect();
        Uri uri2 = headerField == null ? null : Uri.parse(headerField);
        String scheme = uri.getScheme();
        if (i <= 0 || uri2 == null || uri2.getScheme().equals(scheme)) {
            throw new IOException(i == 0 ? g("URL %s follows too many redirects", uri.toString()) : g("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        return f(uri2, i - 1);
    }

    @VisibleForTesting
    public void h(ze3 ze3Var, NetworkFetcher.Callback callback) {
        HttpURLConnection httpURLConnectionF = null;
        try {
            httpURLConnectionF = f(ze3Var.e(), 5);
            if (httpURLConnectionF != null) {
                callback.b(httpURLConnectionF.getInputStream(), -1);
            }
        } catch (IOException e) {
            callback.onFailure(e);
        } finally {
            if (httpURLConnectionF != null) {
                httpURLConnectionF.disconnect();
            }
        }
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        this.f1698a = executorService;
    }
}
