package com.zj.adlib;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.bumptech.glide.Glide;
import com.huachenjie.common.glide.SizeCallback;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class mu3 {

    public class a extends DefaultObserver<Size> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SizeCallback f43382a;

        public a(final SizeCallback val$callback) {
            this.f43382a = val$callback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Size size) {
            SizeCallback sizeCallback = this.f43382a;
            if (sizeCallback != null) {
                sizeCallback.a(size);
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable e) {
            SizeCallback sizeCallback = this.f43382a;
            if (sizeCallback != null) {
                sizeCallback.onFailed();
            }
        }
    }

    public class b implements ObservableOnSubscribe<Size> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f43383a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f18304a;

        public b(final Context val$context, final String val$url) {
            this.f43383a = val$context;
            this.f18304a = val$url;
        }

        public void subscribe(ObservableEmitter<Size> emitter) throws Exception {
            try {
                String path = Glide.with(this.f43383a).downloadOnly().load(this.f18304a).submit().get().getPath();
                if (new File(path).exists()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(path, options);
                    emitter.onNext(new Size(options.outWidth, options.outHeight));
                } else {
                    emitter.onError(new Throwable("file is not exists"));
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
                emitter.onComplete();
            }
        }
    }

    public static void a(Context context, String url, SizeCallback callback) {
        Observable.create(new b(context, url)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(callback));
    }
}
