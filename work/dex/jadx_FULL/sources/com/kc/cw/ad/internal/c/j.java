package com.kc.cw.ad.internal.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap<b, String> f38949a = new HashMap<>();
    c b;

    @Keep
    public class a extends AsyncTask<Void, Void, Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<j> f38950a;
        WeakReference<b> b;
        String c;
        final j d;

        public a(j jVar, b bVar, String str, j jVar2) {
            this.d = jVar;
            this.f38950a = new WeakReference<>(jVar2);
            this.b = new WeakReference<>(bVar);
            this.c = str;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            if (isCancelled()) {
                return null;
            }
            try {
                URLConnection uRLConnectionOpenConnection = new URL(this.c).openConnection();
                uRLConnectionOpenConnection.setReadTimeout(10000);
                InputStream inputStream = (InputStream) uRLConnectionOpenConnection.getContent();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return bitmapDecodeStream;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            b bVar = this.b.get();
            j jVar = this.f38950a.get();
            if (bVar != null) {
                if (bitmap == null) {
                    bVar.a();
                } else {
                    bVar.a(bitmap);
                }
            }
            if (jVar != null) {
                jVar.a(bVar);
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.b.clear();
            this.f38950a.clear();
        }
    }

    @Keep
    public interface b {
        void a();

        void a(Bitmap bitmap);
    }

    @Keep
    public interface c {
        void e();
    }

    private void b() {
        this.f38949a = null;
        this.b = null;
    }

    public void a() {
        if (this.b == null) {
            b();
            return;
        }
        HashMap<b, String> map = this.f38949a;
        if (map == null || map.isEmpty()) {
            this.b.e();
            b();
            return;
        }
        for (Map.Entry<b, String> entry : this.f38949a.entrySet()) {
            a aVar = new a(this, entry.getKey(), entry.getValue(), this);
            f.b(f.f38946a, "Downloading image failFrom url: " + ((Object) entry.getValue()));
            aVar.execute(new Void[0]);
        }
    }

    public void a(b bVar) {
        HashMap<b, String> map = this.f38949a;
        if (map == null || !map.containsKey(bVar)) {
            return;
        }
        this.f38949a.remove(bVar);
        if (this.f38949a.size() == 0) {
            this.b.e();
            f.b(f.f38946a, "Images downloading finished.");
            b();
        }
    }

    public void a(b bVar, String str) {
        if (p.a(str) || bVar == null) {
            return;
        }
        this.f38949a.put(bVar, str);
    }

    public void a(c cVar) {
        this.b = cVar;
    }
}
