package com.huachenjie.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.R;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.zj.adlib.ju3;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u00104\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u0002J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010!\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010#\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u0002H\u0002R\u0018\u0010&\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010,R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00102¨\u00067"}, d2 = {"Lcom/huachenjie/base/widget/AvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "setBackgroundDrawable", "", "select", "setSelect", "resId", "setSelectDrawable", "", AvatarFragment.AVATAR_URL, "Lcom/bumptech/glide/request/RequestOptions;", "requestOptions", "loadAvatar", "loadAvatarFrame", "avatarFrameUrl", "loadImageSync", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "b", "initView", "Landroid/widget/ImageView;", "view", "url", "d", "resourceId", "c", "a", "Landroid/widget/ImageView;", "avatar", "Landroid/view/View;", "Landroid/view/View;", "avatarSelect", "avatarFrame", "", "F", "avatarWidth", "avatarHeight", "N", "I", "avatarStroke", "Z", "avatarSelected", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAvatarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AvatarView.kt\ncom/huachenjie/base/widget/AvatarView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,211:1\n1#2:212\n*E\n"})
public final class AvatarView extends ConstraintLayout {

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public int avatarStroke;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float avatarWidth;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public View avatarSelect;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ImageView avatar;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float avatarHeight;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ImageView avatarFrame;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean avatarSelected;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AvatarView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AvatarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void b(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AvatarView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…,\n            0\n        )");
        this.avatarWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.AvatarView_av_width, 0.0f);
        this.avatarHeight = typedArrayObtainStyledAttributes.getDimension(R.styleable.AvatarView_av_height, 0.0f);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AvatarView_av_stroke, 0);
        this.avatarStroke = resourceId;
        this.avatarSelected = resourceId != 0;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void c(ImageView view, RequestOptions requestOptions, int resourceId) {
        if (view != null) {
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(view).load(Integer.valueOf(resourceId));
            Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "with(it).load(resourceId)");
            if (requestOptions != null) {
                requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptions);
                Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "load.apply(requestOptions)");
            }
            requestBuilderLoad.into(view);
        }
    }

    public final void d(ImageView view, RequestOptions requestOptions, String url) {
        if (view != null) {
            RequestManager requestManagerWith = Glide.with(view);
            if (url == null) {
                url = "";
            }
            RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load(url);
            Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "with(it).load(url ?: \"\")");
            if (requestOptions != null) {
                requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptions);
                Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "load.apply(requestOptions)");
            }
            requestBuilderLoad.into(view);
        }
    }

    public final void initView(Context context) {
        View.inflate(context, R.layout.view_avatar, this);
        this.avatar = (ImageView) findViewById(R.id.avatar_icon);
        View viewFindViewById = findViewById(R.id.avatar_select);
        this.avatarSelect = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(this.avatarStroke);
        }
        View view = this.avatarSelect;
        if (view != null) {
            view.setVisibility(this.avatarSelected ? 0 : 8);
        }
        this.avatarFrame = (ImageView) findViewById(R.id.avatar_frame_icon);
    }

    public final void loadAvatar(@Nullable String avatarUrl, @Nullable RequestOptions requestOptions) {
        d(this.avatar, requestOptions, avatarUrl);
    }

    public final void loadAvatarFrame(@Nullable String avatarUrl, @Nullable RequestOptions requestOptions) {
        if (TextUtils.isEmpty(avatarUrl)) {
            ImageView imageView = this.avatar;
            if (imageView != null) {
                imageView.setScaleX(1.0f);
            }
            ImageView imageView2 = this.avatar;
            if (imageView2 != null) {
                imageView2.setScaleY(1.0f);
            }
            View view = this.avatarSelect;
            if (view != null) {
                view.setScaleX(1.0f);
            }
            View view2 = this.avatarSelect;
            if (view2 != null) {
                view2.setScaleY(1.0f);
            }
        } else {
            ImageView imageView3 = this.avatar;
            if (imageView3 != null) {
                imageView3.setScaleX(0.834f);
            }
            ImageView imageView4 = this.avatar;
            if (imageView4 != null) {
                imageView4.setScaleY(0.834f);
            }
            View view3 = this.avatarSelect;
            if (view3 != null) {
                view3.setScaleX(0.834f);
            }
            View view4 = this.avatarSelect;
            if (view4 != null) {
                view4.setScaleY(0.834f);
            }
        }
        d(this.avatarFrame, requestOptions, avatarUrl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadImageSync(@NotNull String avatarUrl, @NotNull String avatarFrameUrl) {
        Bitmap bitmap;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
        Intrinsics.checkNotNullParameter(avatarFrameUrl, "avatarFrameUrl");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("This method can only be called in child threads！！！");
        }
        Bitmap bitmap2 = null;
        if (!TextUtils.isEmpty(avatarUrl)) {
            try {
                bitmap = (Bitmap) Glide.with(getContext()).asBitmap().apply((BaseRequestOptions<?>) ju3.b).load(avatarUrl).diskCacheStrategy(DiskCacheStrategy.ALL).submit().get();
            } catch (Exception unused) {
                bitmap = null;
            }
            if (bitmap != null && (imageView = this.avatar) != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
        if (TextUtils.isEmpty(avatarFrameUrl)) {
            ImageView imageView2 = this.avatar;
            if (imageView2 != null) {
                imageView2.setScaleX(1.0f);
            }
            ImageView imageView3 = this.avatar;
            if (imageView3 != null) {
                imageView3.setScaleY(1.0f);
            }
            View view = this.avatarSelect;
            if (view != null) {
                view.setScaleX(1.0f);
            }
            View view2 = this.avatarSelect;
            if (view2 == null) {
                return;
            }
            view2.setScaleY(1.0f);
            return;
        }
        try {
            bitmap2 = (Bitmap) Glide.with(getContext()).asBitmap().apply((BaseRequestOptions<?>) ju3.c).load(avatarFrameUrl).diskCacheStrategy(DiskCacheStrategy.ALL).submit().get();
        } catch (Exception unused2) {
        }
        if (bitmap2 != null) {
            ImageView imageView4 = this.avatar;
            if (imageView4 != null) {
                imageView4.setScaleX(0.834f);
            }
            ImageView imageView5 = this.avatar;
            if (imageView5 != null) {
                imageView5.setScaleY(0.834f);
            }
            View view3 = this.avatarSelect;
            if (view3 != null) {
                view3.setScaleX(0.834f);
            }
            View view4 = this.avatarSelect;
            if (view4 != null) {
                view4.setScaleY(0.834f);
            }
            ImageView imageView6 = this.avatarFrame;
            if (imageView6 != null) {
                imageView6.setImageBitmap(bitmap2);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f = this.avatarWidth;
        if (f > 0.0f) {
            float f2 = this.avatarHeight;
            if (f2 > 0.0f) {
                int i = (int) (f * 1.2f);
                int i2 = (int) (f2 * 1.2f);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                if (View.MeasureSpec.getMode(iMakeMeasureSpec) == 1073741824 && View.MeasureSpec.getMode(iMakeMeasureSpec2) == 1073741824 && View.MeasureSpec.getSize(iMakeMeasureSpec) == i && View.MeasureSpec.getSize(iMakeMeasureSpec2) == i2) {
                    super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    return;
                } else {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    return;
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable background) {
        ImageView imageView = this.avatar;
        if (imageView == null) {
            return;
        }
        imageView.setBackground(background);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@NotNull Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        ImageView imageView = this.avatar;
        if (imageView != null) {
            imageView.setBackgroundDrawable(background);
        }
    }

    public final void setSelect(boolean select) {
        this.avatarSelected = select;
        View view = this.avatarSelect;
        if (view == null) {
            return;
        }
        view.setVisibility(select ? 0 : 8);
    }

    public final void setSelectDrawable(int resId) {
        View view = this.avatarSelect;
        if (view != null) {
            view.setBackgroundResource(resId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context, attributeSet);
        initView(context);
    }

    public final void loadAvatar(@DrawableRes int avatarUrl, @Nullable RequestOptions requestOptions) {
        c(this.avatar, requestOptions, avatarUrl);
    }

    public final void loadAvatar(@Nullable String avatarUrl) {
        loadAvatar(avatarUrl, ju3.b);
    }

    public final void loadAvatar(@DrawableRes int avatarUrl) {
        loadAvatar(avatarUrl, (RequestOptions) null);
    }

    public final void loadAvatarFrame(@Nullable String avatarFrameUrl) {
        loadAvatarFrame(avatarFrameUrl, ju3.c);
    }
}
