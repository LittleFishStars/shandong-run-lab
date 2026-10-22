package com.huachenjie.im.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.im.R;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.view.PublishAudioView;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import com.zj.adlib.f64;
import com.zj.adlib.m55;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\b\b\u0002\u0010/\u001a\u00020\u0005¢\u0006\u0004\b0\u00101JH\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007J\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\b\u0010\u0011\u001a\u00020\fH\u0014J\"\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0007J:\u0010\u0012\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0003J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010(¨\u00062"}, d2 = {"Lcom/huachenjie/im/view/PublishAudioView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "path", "bgPath", "", "duration", "", "showDelete", "canClick", "centerInParent", "isDefault", "", "setData", "Lkotlin/Function0;", RenderCallContext.TYPE_CALLBACK, "setDeleteCallback", "onDetachedFromWindow", "D", "H", "C", "I", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "mContainer", "b", "mIvIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTvDuration", "d", "mIvDelete", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "mJsonAudio", "f", "Ljava/lang/String;", "mPath", "Lkotlin/jvm/functions/Function0;", "mDeleteCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class PublishAudioView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ImageView mContainer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final LottieAnimationView mJsonAudio;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function0<Unit> mDeleteCallback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ImageView mIvIcon;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final ImageView mIvDelete;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final TextView mTvDuration;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String mPath;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/im/view/PublishAudioView$a", "Lcom/huachenjie/im/audio/ImAudioPlayCallback;", "", "uuid", "", "b", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements ImAudioPlayCallback {
        public a() {
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            PublishAudioView.this.mJsonAudio.cancelAnimation();
            PublishAudioView.this.mJsonAudio.setProgress(0.0f);
            PublishAudioView.this.mIvIcon.setImageResource(R.drawable.ic_publish_audio_play_stop);
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            PublishAudioView.this.mJsonAudio.playAnimation();
            PublishAudioView.this.mIvIcon.setImageResource(R.drawable.ic_publish_audio_play_start);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishAudioView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishAudioView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishAudioView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PublishAudioView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void E(PublishAudioView publishAudioView, View view) {
        Intrinsics.checkNotNullParameter(publishAudioView, "this$0");
        if (f64.b().f(m55.c(publishAudioView.mPath))) {
            publishAudioView.I();
        } else {
            publishAudioView.H();
        }
    }

    public static final void F(PublishAudioView publishAudioView, View view) {
        Intrinsics.checkNotNullParameter(publishAudioView, "this$0");
        publishAudioView.C();
    }

    public static final void G(PublishAudioView publishAudioView, String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(publishAudioView, "this$0");
        float width = ((publishAudioView.getWidth() - publishAudioView.getPaddingLeft()) - publishAudioView.getPaddingRight()) / 375.0f;
        float f = 300.0f * width;
        int i = TextUtils.isEmpty(str) ? 40 : 60;
        ViewGroup.LayoutParams layoutParams = publishAudioView.mContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) f;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((i * f) / 220.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = z ? (int) (width * 37.5f) : 0;
        publishAudioView.mContainer.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = publishAudioView.mIvIcon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        int i2 = (int) (0.12727273f * f);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) (((TextUtils.isEmpty(str) || z2) ? 0.045454547f : 0.24545455f) * f);
        publishAudioView.mIvIcon.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = publishAudioView.mJsonAudio.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (0.22727273f * f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (f * 0.1f);
        publishAudioView.mJsonAudio.setLayoutParams(layoutParams6);
    }

    public final void C() {
        I();
        Function0<Unit> function0 = this.mDeleteCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void D(final String bgPath, int duration, boolean showDelete, boolean canClick, final boolean centerInParent, final boolean isDefault) {
        TextView textView = this.mTvDuration;
        StringBuilder sb = new StringBuilder();
        sb.append(duration);
        sb.append('s');
        textView.setText(sb.toString());
        this.mIvDelete.setVisibility(showDelete ? 0 : 8);
        if (TextUtils.isEmpty(bgPath)) {
            this.mContainer.setBackground(new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 40.0f)).setGradientColor(Color.parseColor("#FFFF4C4C"), Color.parseColor("#FF6B1EFF")).setGradientAngle(0).build());
            this.mContainer.setImageDrawable(null);
        } else {
            this.mContainer.setBackground(null);
            Glide.with(this.mContainer).load(bgPath).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.mContainer);
        }
        if (canClick) {
            this.mContainer.setClickable(true);
            this.mContainer.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.i37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishAudioView.E(this.f42269a, view);
                }
            });
            this.mIvDelete.setClickable(true);
            this.mIvDelete.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.j37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishAudioView.F(this.f42499a, view);
                }
            });
        } else {
            this.mContainer.setOnClickListener(null);
            this.mContainer.setClickable(false);
            this.mIvDelete.setOnClickListener(null);
            this.mIvDelete.setClickable(false);
        }
        post(new Runnable() { // from class: com.zj.adlib.k37
            @Override // java.lang.Runnable
            public final void run() {
                PublishAudioView.G(this.f42737a, bgPath, centerInParent, isDefault);
            }
        });
    }

    public final void H() {
        f64 f64VarB = f64.b();
        Context context = getContext();
        String str = this.mPath;
        f64VarB.i(context, str, m55.c(str), new a());
    }

    public final void I() {
        this.mJsonAudio.cancelAnimation();
        this.mJsonAudio.setProgress(0.0f);
        this.mIvIcon.setImageResource(R.drawable.ic_publish_audio_play_stop);
        f64.b().k(m55.c(this.mPath));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        f64.b().a();
        super.onDetachedFromWindow();
    }

    public final void setData(@NotNull String path, @Nullable String bgPath, int duration, boolean showDelete, boolean canClick, boolean centerInParent, boolean isDefault) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.mPath = path;
        D(bgPath, duration, showDelete, canClick, centerInParent, isDefault);
    }

    public final void setDeleteCallback(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        this.mDeleteCallback = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishAudioView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_publish_audio, this);
        View viewFindViewById = findViewById(R.id.bg_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.bg_container)");
        this.mContainer = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.ivIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.ivIcon)");
        this.mIvIcon = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tvDuration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.tvDuration)");
        this.mTvDuration = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.ivDelete);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.ivDelete)");
        this.mIvDelete = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.jsonAudio);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.jsonAudio)");
        this.mJsonAudio = (LottieAnimationView) viewFindViewById5;
    }

    public static /* synthetic */ void setData$default(PublishAudioView publishAudioView, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        publishAudioView.setData(str, i, z);
    }

    public final void setData(@Nullable String bgPath, int duration, boolean isDefault) {
        TextView textView = this.mTvDuration;
        StringBuilder sb = new StringBuilder();
        sb.append(duration);
        sb.append('s');
        textView.setText(sb.toString());
        this.mIvDelete.setVisibility(8);
        if (TextUtils.isEmpty(bgPath)) {
            this.mContainer.setBackground(new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 40.0f)).setGradientColor(Color.parseColor("#FFFF4C4C"), Color.parseColor("#FF6B1EFF")).setGradientAngle(0).build());
            this.mContainer.setImageDrawable(null);
        } else {
            this.mContainer.setBackground(null);
            Glide.with(this.mContainer).load(bgPath).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.mContainer);
        }
        ViewGroup.LayoutParams layoutParams = this.mIvIcon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (TextUtils.isEmpty(bgPath) || isDefault) ? 10 : 54;
        this.mIvIcon.setLayoutParams(layoutParams2);
    }
}
