package com.huachenjie.channel.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coroutines.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.channel.R;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ar6;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u0002\u001d8B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u00106J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J.\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J \u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J-\u0010\u0017\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002R#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u001c*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R#\u0010(\u001a\n \u001c*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b'\u0010%R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010*R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010,R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.¨\u00069"}, d2 = {"Lcom/huachenjie/channel/widget/UploadPictureButton;", "Landroid/widget/FrameLayout;", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", "cameraMessage", "", "imageMaxWidth", "imageMaxSize", "", "initPicker", "Landroidx/fragment/app/Fragment;", "fragment", "c", "Lkotlin/Function1;", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "register", "d", "url", "radius", "Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;", "onUrlChanged", y6b.f, "(Ljava/lang/String;Ljava/lang/Integer;Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;)V", "e", "f", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getTvAddPic", "()Landroid/widget/TextView;", "tvAddPic", "Landroid/widget/ImageView;", "b", "getIvPic", "()Landroid/widget/ImageView;", "ivPic", "getIvDel", "ivDel", "Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "mediaPickerLauncher", "Ljava/lang/String;", "K", "I", "L", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnUrlChangedListener", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class UploadPictureButton extends FrameLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String g = "为了能够正常拍摄照片并上传，我们需要访问您终端设备的相机权限";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int imageMaxWidth;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int imageMaxSize;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public OnUrlChangedListener onUrlChanged;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MediaPickerLauncher mediaPickerLauncher;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy tvAddPic;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy ivPic;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy ivDel;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String cameraMessage;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;", "", "", "url", "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public interface OnUrlChangedListener {
        void a(@NotNull String url);
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.widget.UploadPictureButton$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/widget/UploadPictureButton$a;", "", "Landroid/view/View;", "view", "", "url", "", "radius", "Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;", "onUrlChanged", "", "hideDel", "", "a", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Integer;Lcom/huachenjie/channel/widget/UploadPictureButton$OnUrlChangedListener;Z)V", "DEFAULT_CAMERA_MESSAGE", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @BindingAdapter(requireAll = false, value = {"upb_url", "upb_radius", "upb_on_url_changed", "upd_hide_del"})
        @JvmStatic
        public final void a(@NotNull View view, @Nullable String url, @Nullable Integer radius, @Nullable OnUrlChangedListener onUrlChanged, boolean hideDel) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof UploadPictureButton) {
                UploadPictureButton uploadPictureButton = (UploadPictureButton) view;
                uploadPictureButton.g(url, radius, onUrlChanged);
                if (hideDel) {
                    uploadPictureButton.getIvDel().setVisibility(8);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/channel/widget/UploadPictureButton$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nUploadPictureButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadPictureButton.kt\ncom/huachenjie/channel/widget/UploadPictureButton$bindMediaPicker$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,179:1\n1#2:180\n*E\n"})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            OnUrlChangedListener onUrlChangedListener;
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
            if (str == null || (onUrlChangedListener = UploadPictureButton.this.onUrlChanged) == null) {
                return;
            }
            onUrlChangedListener.a(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UploadPictureButton(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UploadPictureButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ UploadPictureButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void b(UploadPictureButton uploadPictureButton, View view) {
        Intrinsics.checkNotNullParameter(uploadPictureButton, "this$0");
        uploadPictureButton.f();
    }

    @BindingAdapter(requireAll = false, value = {"upb_url", "upb_radius", "upb_on_url_changed", "upd_hide_del"})
    @JvmStatic
    public static final void createBindingAdapter(@NotNull View view, @Nullable String str, @Nullable Integer num, @Nullable OnUrlChangedListener onUrlChangedListener, boolean z) {
        INSTANCE.a(view, str, num, onUrlChangedListener, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getIvDel() {
        return (ImageView) this.ivDel.getValue();
    }

    private final ImageView getIvPic() {
        return (ImageView) this.ivPic.getValue();
    }

    private final TextView getTvAddPic() {
        return (TextView) this.tvAddPic.getValue();
    }

    public static /* synthetic */ void initPicker$default(UploadPictureButton uploadPictureButton, FragmentActivity fragmentActivity, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = g;
        }
        if ((i3 & 4) != 0) {
            i = 1080;
        }
        if ((i3 & 8) != 0) {
            i2 = 1024;
        }
        uploadPictureButton.initPicker(fragmentActivity, str, i, i2);
    }

    public final void c(String cameraMessage, int imageMaxWidth, int imageMaxSize) {
        this.cameraMessage = cameraMessage;
        this.imageMaxWidth = imageMaxWidth;
        this.imageMaxSize = imageMaxSize;
    }

    public final void d(Function1<? super MediaPickerListener, MediaPickerLauncher> register) {
        if (this.mediaPickerLauncher != null) {
            return;
        }
        this.mediaPickerLauncher = (MediaPickerLauncher) register.invoke(new b());
    }

    public final void e() {
        OnUrlChangedListener onUrlChangedListener = this.onUrlChanged;
        if (onUrlChangedListener != null) {
            onUrlChangedListener.a("");
        }
    }

    public final void f() {
        if (getIvPic().getVisibility() == 0 && getIvDel().getVisibility() == 0) {
            return;
        }
        MediaPickerLauncher mediaPickerLauncher = this.mediaPickerLauncher;
        if (mediaPickerLauncher == null) {
            fv5.b("图片选择器未初始化");
        } else {
            MediaPickerLauncher.Y(mediaPickerLauncher, this.cameraMessage, 0, this.imageMaxWidth, this.imageMaxSize, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, null);
        }
    }

    public final void g(String url, Integer radius, OnUrlChangedListener onUrlChanged) {
        if (TextUtils.isEmpty(url)) {
            setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(radius != null ? radius.intValue() : 8.0f)).setSolidColor(ar6.E).build());
            getTvAddPic().setVisibility(0);
            getIvPic().setVisibility(8);
            getIvDel().setVisibility(8);
        } else {
            setBackground(null);
            getTvAddPic().setVisibility(8);
            getIvPic().setVisibility(0);
            getIvDel().setVisibility(0);
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(getContext()).load(url);
            RequestOptions requestOptionsDiskCacheStrategy = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Transformation<Bitmap>[] transformationArr = new Transformation[2];
            transformationArr[0] = new CenterCrop();
            transformationArr[1] = new RoundedCorners(SizeUtils.b(radius != null ? radius.intValue() : 8.0f));
            requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsDiskCacheStrategy.transforms(transformationArr)).into(getIvPic());
        }
        this.onUrlChanged = onUrlChanged;
    }

    @JvmOverloads
    public final void initPicker(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        initPicker$default(this, fragment, (String) null, 0, 0, 14, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        initPicker$default(this, fragment, str, 0, 0, 12, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull Fragment fragment, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        initPicker$default(this, fragment, str, i, 0, 8, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, TTDownloadField.TT_ACTIVITY);
        initPicker$default(this, fragmentActivity, (String) null, 0, 0, 14, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull FragmentActivity fragmentActivity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        initPicker$default(this, fragmentActivity, str, 0, 0, 12, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull FragmentActivity fragmentActivity, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(fragmentActivity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        initPicker$default(this, fragmentActivity, str, i, 0, 8, (Object) null);
    }

    @JvmOverloads
    public final void initPicker(@NotNull final FragmentActivity activity, @NotNull String cameraMessage, int imageMaxWidth, int imageMaxSize) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(cameraMessage, "cameraMessage");
        c(cameraMessage, imageMaxWidth, imageMaxSize);
        d(new Function1<MediaPickerListener, MediaPickerLauncher>() { // from class: com.huachenjie.channel.widget.UploadPictureButton.initPicker.1
            {
                super(1);
            }

            @NotNull
            public final MediaPickerLauncher invoke(@NotNull MediaPickerListener mediaPickerListener) {
                Intrinsics.checkNotNullParameter(mediaPickerListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
                return MediaPicker.w(activity, mediaPickerListener);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UploadPictureButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tvAddPic = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.channel.widget.UploadPictureButton$tvAddPic$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m326invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_add_pic);
            }
        });
        this.ivPic = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.channel.widget.UploadPictureButton$ivPic$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m325invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_pic);
            }
        });
        this.ivDel = LazyKt.lazy(new UploadPictureButton$ivDel$2(this));
        this.cameraMessage = g;
        this.imageMaxWidth = 1080;
        this.imageMaxSize = 1024;
        LayoutInflater.from(context).inflate(R.layout.channel_view_upload_picture_button, this);
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.fh9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadPictureButton.b(this.f41676a, view);
            }
        });
        g(null, null, null);
    }

    public static /* synthetic */ void initPicker$default(UploadPictureButton uploadPictureButton, Fragment fragment, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = g;
        }
        if ((i3 & 4) != 0) {
            i = 1080;
        }
        if ((i3 & 8) != 0) {
            i2 = 1024;
        }
        uploadPictureButton.initPicker(fragment, str, i, i2);
    }

    @JvmOverloads
    public final void initPicker(@NotNull final Fragment fragment, @NotNull String cameraMessage, int imageMaxWidth, int imageMaxSize) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cameraMessage, "cameraMessage");
        c(cameraMessage, imageMaxWidth, imageMaxSize);
        d(new Function1<MediaPickerListener, MediaPickerLauncher>() { // from class: com.huachenjie.channel.widget.UploadPictureButton.initPicker.2
            {
                super(1);
            }

            @NotNull
            public final MediaPickerLauncher invoke(@NotNull MediaPickerListener mediaPickerListener) {
                Intrinsics.checkNotNullParameter(mediaPickerListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
                return MediaPicker.v(fragment, mediaPickerListener);
            }
        });
    }
}
