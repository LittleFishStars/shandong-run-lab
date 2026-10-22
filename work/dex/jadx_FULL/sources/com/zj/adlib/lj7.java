package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014R\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/zj/adlib/lj7;", "Lcom/zj/adlib/uy0;", "Landroid/content/Context;", "context", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "pool", "Landroid/graphics/Bitmap;", "toTransform", "", "outWidth", "outHeight", "transform", "f", "I", "roundRadius", "radius", "sampling", "<init>", "(III)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class lj7 extends uy0 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int roundRadius;

    public lj7(int i, int i2, int i3) {
        super(i, i2);
        this.roundRadius = i3;
    }

    @NotNull
    public Bitmap transform(@NotNull Context context, @NotNull BitmapPool pool, @NotNull Bitmap toTransform, int outWidth, int outHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        try {
            Bitmap bitmapRoundedCorners = TransformationUtils.roundedCorners(pool, super.transform(context, pool, toTransform, outWidth, outHeight), this.roundRadius);
            Intrinsics.checkNotNullExpressionValue(bitmapRoundedCorners, "{\n            super.tran…)\n            }\n        }");
            return bitmapRoundedCorners;
        } catch (Exception unused) {
            Bitmap bitmapRoundedCorners2 = TransformationUtils.roundedCorners(pool, toTransform, this.roundRadius);
            Intrinsics.checkNotNullExpressionValue(bitmapRoundedCorners2, "{\n            Transforma…m, roundRadius)\n        }");
            return bitmapRoundedCorners2;
        }
    }
}
