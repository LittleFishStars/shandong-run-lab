package com.ipd.dsp.open;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.a0.f;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.components.glide.a;
import com.ipd.dsp.internal.f.g;
import com.ipd.dsp.internal.q.h0;
import com.ipd.dsp.internal.q.j;
import com.ipd.dsp.internal.q.m;
import com.ipd.dsp.internal.q.n;
import com.ipd.dsp.internal.q.o;
import com.ipd.dsp.internal.q.q;
import com.ipd.dsp.internal.q.x;
import com.ipd.dsp.internal.q.y;
import com.ipd.dsp.internal.z.h;
import com.ipd.dsp.internal.z.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class IPDGlideHelper {

    @Keep
    public interface RequestListener {
        void onLoadFailed(Exception exc);

        void onResourceReady();
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransformType {
        public static final int BLUR = 32;
        public static final int BLUR_SCALE = 16;
        public static final int CENTER_CROP = 1;
        public static final int CENTER_INSIDE = 4;
        public static final int CIRCLE_CROP = 8;
        public static final int FIT_CENTER = 2;
        public static final int ROUNDED_CORNER = 64;
    }

    private static i baseOptions() {
        return i.b(q.b).f();
    }

    @Keep
    public static <T extends View> void loadCustomRoundedCornersBlur(Context context, T t, Drawable drawable, int i, @IntRange(from = 1, to = 25) int i2) {
        if (t == null) {
            return;
        }
        try {
            a.a(t).a(drawable).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new j(i2, false), new h0((int) s.a(t.getContext(), i)))).b(new f<T, Drawable>(t) { // from class: com.ipd.dsp.open.IPDGlideHelper.2
                @Override // com.ipd.dsp.internal.a0.p
                public void onLoadFailed(@Nullable Drawable drawable2) {
                    this.view.setBackground(drawable2);
                }

                @Override // com.ipd.dsp.internal.a0.f
                public void onResourceCleared(@Nullable Drawable drawable2) {
                    this.view.setBackground(drawable2);
                }

                @Override // com.ipd.dsp.internal.a0.p
                public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable com.ipd.dsp.internal.b0.f fVar) {
                    onResourceReady((Drawable) obj, (com.ipd.dsp.internal.b0.f<? super Drawable>) fVar);
                }

                public void onResourceReady(@NonNull Drawable drawable2, @Nullable com.ipd.dsp.internal.b0.f<? super Drawable> fVar) {
                    this.view.setBackground(drawable2);
                }
            });
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImage(Context context, ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions()).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageCenterCrop(Context context, ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions().b()).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageCenterCropBlur(Context context, ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new j(15))).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageRoundedCorners(Context context, ImageView imageView, String str, int i) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new h0((int) s.a(imageView.getContext(), i)))).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageWithTransform(Context context, ImageView imageView, String str, int i) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) parseTransform(i, 0)).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    private static i parseTransform(int i, int... iArr) {
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            arrayList.add(new m());
        } else if ((i & 2) != 0) {
            arrayList.add(new x());
        } else if ((i & 4) != 0) {
            arrayList.add(new n());
        }
        if ((i & 8) != 0) {
            arrayList.add(new o());
        }
        if ((i & 16) != 0) {
            arrayList.add(new j(15));
        }
        if ((i & 32) != 0) {
            arrayList.add(new j(15, false));
        }
        if ((i & 64) != 0) {
            if (iArr.length >= 4) {
                arrayList.add(new y(iArr[0], iArr[1], iArr[2], iArr[3]));
            } else if (iArr.length >= 1 && iArr[0] != 0) {
                arrayList.add(new h0(iArr[0]));
            }
        }
        i iVarBaseOptions = baseOptions();
        return !arrayList.isEmpty() ? iVarBaseOptions.b((com.ipd.dsp.internal.f.m<Bitmap>) new g(arrayList)) : iVarBaseOptions;
    }

    @Keep
    public static void preload(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a.e(context.getApplicationContext()).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions()).X();
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImage(Context context, ImageView imageView, String str, int i) {
        if (imageView == null) {
            return;
        }
        try {
            i iVarBaseOptions = baseOptions();
            if (i > 0) {
                iVarBaseOptions = iVarBaseOptions.f(i).b(i);
            }
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) iVarBaseOptions).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageCenterCrop(Context context, ImageView imageView, String str, int i) {
        if (imageView == null) {
            return;
        }
        try {
            i iVarB = baseOptions().b();
            if (i > 0) {
                iVarB = iVarB.f(i).b(i);
            }
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) iVarB).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageWithTransform(Context context, ImageView imageView, String str, int i, int i2) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) parseTransform(i, i2)).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageWithTransform(Context context, ImageView imageView, String str, int i, int[] iArr) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) parseTransform(i, iArr)).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageCenterCropBlur(Context context, ImageView imageView, Bitmap bitmap) {
        if (imageView == null) {
            return;
        }
        try {
            a.a(imageView).a(bitmap).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new j(15))).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImage(Context context, ImageView imageView, String str, byte[] bArr) {
        if (imageView == null) {
            return;
        }
        try {
            com.ipd.dsp.internal.b.g<Drawable> gVarC = a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions());
            if (bArr != null && bArr.length > 0) {
                gVarC.c(a.a(imageView).a(bArr).c((com.ipd.dsp.internal.z.a<?>) baseOptions())).a(imageView);
            } else {
                gVarC.a(imageView);
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageRoundedCorners(Context context, ImageView imageView, String str, float f, float f2, float f3, float f4) {
        if (imageView == null) {
            return;
        }
        try {
            Context context2 = imageView.getContext();
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new y(s.a(context2, f), s.a(context2, f2), s.a(context2, f3), s.a(context2, f4)))).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImage(Context context, ImageView imageView, String str, final RequestListener requestListener) {
        try {
            a.a(imageView).a(str).c((com.ipd.dsp.internal.z.a<?>) baseOptions()).b(new h<Drawable>() { // from class: com.ipd.dsp.open.IPDGlideHelper.1
                @Override // com.ipd.dsp.internal.z.h
                public boolean onLoadFailed(@Nullable com.ipd.dsp.internal.i.q qVar, Object obj, @NonNull p<Drawable> pVar, boolean z) {
                    RequestListener requestListener2 = requestListener;
                    if (requestListener2 == null) {
                        return false;
                    }
                    requestListener2.onLoadFailed(qVar);
                    return false;
                }

                @Override // com.ipd.dsp.internal.z.h
                public boolean onResourceReady(@NonNull Drawable drawable, @NonNull Object obj, p<Drawable> pVar, @NonNull com.ipd.dsp.internal.f.a aVar, boolean z) {
                    RequestListener requestListener2 = requestListener;
                    if (requestListener2 == null) {
                        return false;
                    }
                    requestListener2.onResourceReady();
                    return false;
                }
            }).f().a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Keep
    public static void loadImageRoundedCorners(Context context, ImageView imageView, Bitmap bitmap, float f, float f2, float f3, float f4) {
        if (imageView == null) {
            return;
        }
        try {
            Context context2 = imageView.getContext();
            a.a(imageView).a(bitmap).c((com.ipd.dsp.internal.z.a<?>) baseOptions().a(new m(), new y(s.a(context2, f), s.a(context2, f2), s.a(context2, f3), s.a(context2, f4)))).a(imageView);
        } catch (Throwable th) {
            r.a(th);
        }
    }
}
