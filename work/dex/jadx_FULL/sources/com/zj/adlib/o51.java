package com.zj.adlib;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.odml.image.MlImage;
import com.google.android.odml.image.f;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class o51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f18565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteBuffer f18566a;
    public final int b;
    public final int c;
    public int d = 0;

    public o51(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3) {
        this.f18566a = byteBuffer;
        this.f43673a = i;
        this.b = i2;
        this.c = i3;
        this.f18565a = new Rect(0, 0, i, i2);
    }

    @NonNull
    public MlImage a() {
        return new MlImage(new f(this.f18566a, this.c), this.d, this.f18565a, 0L, this.f43673a, this.b);
    }

    @NonNull
    public o51 b(int i) {
        MlImage.m(i);
        this.d = i;
        return this;
    }
}
