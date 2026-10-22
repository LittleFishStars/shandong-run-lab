package com.huachenjie.mall.page.goods_detail.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.mall.page.goods_detail.preview.PhotoLayout;
import com.lxj.xpopup.photoview.PhotoView;
import com.zj.adlib.ju3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ4\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\bH\u0002R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/PhotoLayout;", "Landroid/widget/FrameLayout;", "", "url", "", "zoomable", "Lkotlin/Function1;", "", "", "onItemClickListener", "position", "bindData", "b", "a", "Lkotlin/jvm/functions/Function1;", "K", "I", "Lcom/lxj/xpopup/photoview/PhotoView;", "Lkotlin/Lazy;", "getImageView", "()Lcom/lxj/xpopup/photoview/PhotoView;", "imageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PhotoLayout extends FrameLayout {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int position;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy imageView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> onItemClickListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PhotoLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void c(PhotoLayout photoLayout, View view) {
        Intrinsics.checkNotNullParameter(photoLayout, "this$0");
        Function1<? super Integer, Unit> function1 = photoLayout.onItemClickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(photoLayout.position));
        }
    }

    private final PhotoView getImageView() {
        return (PhotoView) this.imageView.getValue();
    }

    public final void b() {
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.eq6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoLayout.c(this.f41498a, view);
            }
        });
    }

    public final void bindData(@NotNull String url, boolean zoomable, @Nullable Function1<? super Integer, Unit> onItemClickListener, int position) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.onItemClickListener = onItemClickListener;
        this.position = position;
        getImageView().setZoomable(zoomable);
        getImageView().setScaleType(zoomable ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.CENTER_CROP);
        Glide.with((View) getImageView()).load(url).apply((BaseRequestOptions<?>) ju3.h).into((ImageView) getImageView());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = -1;
        this.imageView = LazyKt.lazy(new Function0<PhotoView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.PhotoLayout$imageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PhotoView m544invoke() {
                View photoView = new PhotoView(context);
                this.addView(photoView, new FrameLayout.LayoutParams(-1, -1));
                return photoView;
            }
        });
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(-16777216);
        getImageView();
        b();
    }
}
