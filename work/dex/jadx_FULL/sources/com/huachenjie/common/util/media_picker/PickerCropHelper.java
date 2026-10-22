package com.huachenjie.common.util.media_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.yalantis.ucrop.UCropImageEngine;
import com.zj.adlib.fq6;
import com.zj.adlib.y6b;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/common/util/media_picker/PickerCropHelper;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "d", "sourceUri", "destinationUri", "Lcom/huachenjie/common/util/media_picker/a;", "cropConfig", "Landroid/content/Intent;", "c", "Lcom/yalantis/ucrop/UCropImageEngine;", "e", "", y6b.f, "a", "Lkotlin/Lazy;", "f", "()Lcom/yalantis/ucrop/UCropImageEngine;", "imageEngine", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class PickerCropHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PickerCropHelper f33928a = new PickerCropHelper();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy imageEngine = LazyKt.lazy(new Function0<UCropImageEngine>() { // from class: com.huachenjie.common.util.media_picker.PickerCropHelper$imageEngine$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UCropImageEngine m364invoke() {
            return PickerCropHelper.f33928a.e();
        }
    });

    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J6\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0012"}, d2 = {"com/huachenjie/common/util/media_picker/PickerCropHelper$a", "Lcom/yalantis/ucrop/UCropImageEngine;", "Landroid/content/Context;", "context", "", "url", "Landroid/widget/ImageView;", "imageView", "", "a", "Landroid/net/Uri;", "", "maxWidth", "maxHeight", "Lcom/yalantis/ucrop/UCropImageEngine$OnCallbackListener;", "Landroid/graphics/Bitmap;", "call", "b", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UCropImageEngine {

        /* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.PickerCropHelper$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/common/util/media_picker/PickerCropHelper$a$a", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "onResourceReady", "Landroid/graphics/drawable/Drawable;", "placeholder", "onLoadCleared", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0796a extends CustomTarget<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UCropImageEngine.OnCallbackListener<Bitmap> f33929a;

            public C0796a(UCropImageEngine.OnCallbackListener<Bitmap> onCallbackListener) {
                this.f33929a = onCallbackListener;
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable placeholder) {
                this.f33929a.a((Object) null);
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(@NotNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                this.f33929a.a(resource);
            }
        }

        public void a(@NotNull Context context, @NotNull String url, @NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            if (PickerCropHelper.f33928a.g(context)) {
                Glide.with(context).load(url).override(240, 240).into(imageView);
            }
        }

        public void b(@NotNull Context context, @NotNull Uri url, int maxWidth, int maxHeight, @NotNull UCropImageEngine.OnCallbackListener<Bitmap> call) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(call, "call");
            if (PickerCropHelper.f33928a.g(context)) {
                Glide.with(context).asBitmap().load(url).override(maxWidth, maxHeight).into(new C0796a(call));
            }
        }
    }

    @NotNull
    public final Intent c(@NotNull Context context, @NotNull Uri sourceUri, @NotNull Uri destinationUri, @NotNull ImageCropConfig cropConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter(destinationUri, "destinationUri");
        Intrinsics.checkNotNullParameter(cropConfig, "cropConfig");
        com.yalantis.ucrop.a.a aVar = new com.yalantis.ucrop.a.a();
        aVar.A(true);
        aVar.H(true);
        aVar.I(true);
        aVar.S(cropConfig.j(), cropConfig.k());
        com.yalantis.ucrop.a aVarK = com.yalantis.ucrop.a.k(sourceUri, destinationUri);
        aVarK.v(aVar);
        aVarK.m(f());
        Intent intentD = aVarK.d(context);
        Intrinsics.checkNotNullExpressionValue(intentD, "uCrop.getIntent(context)");
        return intentD;
    }

    @Nullable
    public final Uri d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File fileB = fq6.f41732a.b(context, "crop", "IMG_" + System.currentTimeMillis() + "_crop.jpg");
        if (fileB == null) {
            return null;
        }
        return Uri.fromFile(fileB);
    }

    public final UCropImageEngine e() {
        return new a();
    }

    public final UCropImageEngine f() {
        return (UCropImageEngine) imageEngine.getValue();
    }

    public final boolean g(Context context) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return true;
        }
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
