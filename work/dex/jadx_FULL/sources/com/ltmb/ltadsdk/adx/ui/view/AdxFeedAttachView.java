package com.ltmb.ltadsdk.adx.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.core.download.SYDownloadListenerInner;
import com.ltmb.ltadsdk.core.download.SYDownloadTask;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.s7;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001d\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B%\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0015\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/view/AdxFeedAttachView;", "Landroid/widget/RelativeLayout;", "", "Lcom/ltmb/ltadsdk/pkg/e;", "ads", "", "setData", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getOnClickCallback", "()Lkotlin/jvm/functions/Function0;", "setOnClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "onClickCallback", "f", "getOnCloseCallback", "setOnCloseCallback", "onCloseCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxFeedAttachView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f40312a;
    public TextView b;
    public AdxClickButton c;
    public ImageView d;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onClickCallback;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onCloseCallback;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> onCloseCallback = AdxFeedAttachView.this.getOnCloseCallback();
            if (onCloseCallback != null) {
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        public Object invoke() {
            Function0<Unit> onClickCallback = AdxFeedAttachView.this.getOnClickCallback();
            if (onClickCallback != null) {
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c implements SYDownloadListenerInner {
        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadCompleted(@NotNull SYDownloadTask sYDownloadTask) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadFailed(@NotNull SYDownloadTask sYDownloadTask, int i, @Nullable String str) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadPaused(@NotNull SYDownloadTask sYDownloadTask) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadStart(@NotNull SYDownloadTask sYDownloadTask) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadUpdate(@NotNull SYDownloadTask sYDownloadTask, long j, long j2) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onInstallStart(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onInstalled(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
        }
    }

    public AdxFeedAttachView(@Nullable Context context) {
        this(context, null);
    }

    public final void a() {
        this.c.setOnClickCallback(new b());
        this.c.setDownloadListener(new c());
    }

    @Nullable
    public final Function0<Unit> getOnClickCallback() {
        return this.onClickCallback;
    }

    @Nullable
    public final Function0<Unit> getOnCloseCallback() {
        return this.onCloseCallback;
    }

    public final void setData(@NotNull e ads) {
        Intrinsics.checkNotNullParameter(ads, "ads");
        try {
            this.b.setText(ads.g());
            this.b.setVisibility(TextUtils.isEmpty(ads.g()) ? 8 : 0);
            this.c.setAdsBean(ads);
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final void setOnClickCallback(@Nullable Function0<Unit> function0) {
        this.onClickCallback = function0;
    }

    public final void setOnCloseCallback(@Nullable Function0<Unit> function0) {
        this.onCloseCallback = function0;
    }

    public AdxFeedAttachView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdxFeedAttachView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ImageView imageView = new ImageView(context);
        this.f40312a = imageView;
        imageView.setImageResource(R.mipmap.ltad_icon_ad);
        this.f40312a.setId(View.generateViewId());
        s7 s7Var = s7.a;
        addView(this.f40312a, new RelativeLayout.LayoutParams(s7Var.a(16), s7Var.a(16)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextSize(12.0f);
        this.b.setId(View.generateViewId());
        this.b.setTextColor(getResources().getColor(R.color.ltad_color_gray));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, this.f40312a.getId());
        layoutParams.leftMargin = s7Var.a(5);
        addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.d = imageView2;
        imageView2.setImageResource(R.mipmap.ltad_icon_close);
        this.d.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(s7Var.a(16), s7Var.a(16));
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        this.d.setOnClickListener(new a());
        addView(this.d, layoutParams2);
        AdxClickButton adxClickButton = new AdxClickButton(context);
        this.c = adxClickButton;
        adxClickButton.setTextSize(12.0f);
        this.c.setId(View.generateViewId());
        this.c.setTextColor(getResources().getColor(R.color.ltad_color_white));
        this.c.setBackgroundResource(R.drawable.ltad_bg_feed_attach_button);
        this.c.setPadding(s7Var.a(10), s7Var.a(3), s7Var.a(10), s7Var.a(3));
        this.c.setMinWidth(s7Var.a(60));
        this.c.setGravity(17);
        a();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(0, this.d.getId());
        layoutParams3.rightMargin = s7Var.a(10);
        addView(this.c, layoutParams3);
    }
}
