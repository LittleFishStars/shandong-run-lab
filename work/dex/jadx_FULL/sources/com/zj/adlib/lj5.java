package com.zj.adlib;

import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.odml.image.MlImage;
import com.google.android.odml.image.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RequiresApi(19)
public class lj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43083a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f17976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Image f17977a;

    public lj5(@NonNull Image image) {
        this.f17977a = image;
        this.f17976a = new Rect(0, 0, image.getWidth(), image.getHeight());
    }

    @NonNull
    public MlImage a() {
        return new MlImage(new g(this.f17977a), this.f43083a, this.f17976a, 0L, this.f17977a.getWidth(), this.f17977a.getHeight());
    }

    @NonNull
    public lj5 b(int i) {
        MlImage.m(i);
        this.f43083a = i;
        return this;
    }
}
