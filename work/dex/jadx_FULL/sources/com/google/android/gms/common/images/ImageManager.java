package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.base.zam;
import com.zj.adlib.g0c;
import com.zj.adlib.m5c;
import com.zj.adlib.n3c;
import com.zj.adlib.o5c;
import com.zj.adlib.rt1;
import com.zj.adlib.tb0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ImageManager f31280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5640a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HashSet f5641a = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5643a = new o5c(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f5646a = m5c.a().b(4, 2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zam f5644a = new zam();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5645a = new HashMap();
    public final Map b = new HashMap();
    public final Map c = new HashMap();

    @KeepName
    public final class ImageReceiver extends ResultReceiver {
        private final Uri zab;
        private final ArrayList zac;

        public ImageReceiver(Uri uri) {
            super(new o5c(Looper.getMainLooper()));
            this.zab = uri;
            this.zac = new ArrayList();
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.f5646a.execute(new g0c(imageManager, this.zab, parcelFileDescriptor));
        }

        public final void zab(zag zagVar) {
            tb0.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zac.add(zagVar);
        }

        public final void zac(zag zagVar) {
            tb0.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zac.remove(zagVar);
        }

        public final void zad() {
            Intent intent = new Intent(rt1.c);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(rt1.d, this.zab);
            intent.putExtra(rt1.e, this);
            intent.putExtra(rt1.f, 3);
            ImageManager.this.f5642a.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void a(@NonNull Uri uri, @Nullable Drawable drawable, boolean z);
    }

    public ImageManager(Context context, boolean z) {
        this.f5642a = context.getApplicationContext();
    }

    @NonNull
    public static ImageManager a(@NonNull Context context) {
        if (f31280a == null) {
            f31280a = new ImageManager(context, false);
        }
        return f31280a;
    }

    public void b(@NonNull ImageView imageView, int i) {
        p(new n3c(imageView, i));
    }

    public void c(@NonNull ImageView imageView, @NonNull Uri uri) {
        p(new n3c(imageView, uri));
    }

    public void d(@NonNull ImageView imageView, @NonNull Uri uri, int i) {
        n3c n3cVar = new n3c(imageView, uri);
        ((zag) n3cVar).f31284a = i;
        p(n3cVar);
    }

    public void e(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri) {
        p(new c(onImageLoadedListener, uri));
    }

    public void f(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri, int i) {
        c cVar = new c(onImageLoadedListener, uri);
        ((zag) cVar).f31284a = i;
        p(cVar);
    }

    public final void p(zag zagVar) {
        tb0.a("ImageManager.loadImage() must be called in the main thread");
        new a(this, zagVar).run();
    }
}
