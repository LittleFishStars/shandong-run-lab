package com.kc.dw.ad.view.scaleImage.decoder;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends T> f39211a;

    public a(Class<? extends T> cls) {
        this(cls, null);
    }

    public a(Class<? extends T> cls, Bitmap.Config config) {
        this.f39211a = cls;
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.b
    public T a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.f39211a.newInstance();
    }
}
