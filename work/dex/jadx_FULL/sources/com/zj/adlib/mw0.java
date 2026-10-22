package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import com.google.android.odml.image.MlImage;
import com.google.android.odml.image.e;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class mw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bitmap f18321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f18322a;

    public mw0(@NonNull Context context, @NonNull Uri uri) throws IOException {
        this(MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri));
    }

    @NonNull
    public MlImage a() {
        return new MlImage(new e(this.f18321a), this.f43399a, this.f18322a, 0L, this.f18321a.getWidth(), this.f18321a.getHeight());
    }

    @NonNull
    public mw0 b(int i) {
        MlImage.m(i);
        this.f43399a = i;
        return this;
    }

    public mw0(@NonNull Bitmap bitmap) {
        this.f18321a = bitmap;
        this.f43399a = 0;
        this.f18322a = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }
}
