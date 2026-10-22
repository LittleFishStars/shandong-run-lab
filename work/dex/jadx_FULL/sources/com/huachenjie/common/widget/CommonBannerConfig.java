package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Color;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.SizeUtils;
import com.byazt.hv.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.zj.adlib.fx7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0013\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\fR\u001b\u0010\u0016\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b&\u0010\fR\u001a\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b2\u0010\fR\u001a\u00104\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001b\u00107\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b8\u0010\f¨\u0006;"}, d2 = {"Lcom/huachenjie/common/widget/CommonBannerConfig;", "", "()V", TTDownloadField.TT_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "getActivity$common_release", "()Landroidx/fragment/app/FragmentActivity;", "setActivity$common_release", "(Landroidx/fragment/app/FragmentActivity;)V", "bannerWidth", "", "getBannerWidth", "()I", "setBannerWidth", "(I)V", "dp20", "getDp20$common_release", "dp20$delegate", "Lkotlin/Lazy;", "dp6", "getDp6$common_release", "dp6$delegate", "dp8", "getDp8$common_release", "dp8$delegate", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment$common_release", "()Landroidx/fragment/app/Fragment;", "setFragment$common_release", "(Landroidx/fragment/app/Fragment;)V", "indicatorStyle", "Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;", "getIndicatorStyle", "()Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;", "setIndicatorStyle", "(Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;)V", "maxHeight", "getMaxHeight$common_release", "maxHeight$delegate", "maxHeightDp", "getMaxHeightDp", "setMaxHeightDp", "maxRatio", "", "getMaxRatio$common_release", "()F", "setMaxRatio$common_release", "(F)V", "minHeight", "getMinHeight$common_release", "minHeight$delegate", "minHeightDp", "getMinHeightDp", "setMinHeightDp", "normalColor", "getNormalColor$common_release", "normalColor$delegate", "BannerIndicatorStyle", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonBannerConfig {

    @Nullable
    private FragmentActivity activity;

    @Nullable
    private Fragment fragment;
    private float maxRatio;
    private int minHeightDp = 160;
    private int maxHeightDp = 500;
    private int bannerWidth = fx7.e();

    @NotNull
    private BannerIndicatorStyle indicatorStyle = BannerIndicatorStyle.RectangleStyle.INSTANCE;

    /* JADX INFO: renamed from: minHeight$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy minHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$minHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m375invoke() {
            return Integer.valueOf(SizeUtils.b(this.this$0.getMinHeightDp()));
        }
    });

    /* JADX INFO: renamed from: maxHeight$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy maxHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$maxHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m374invoke() {
            return Integer.valueOf(SizeUtils.b(this.this$0.getMaxHeightDp()));
        }
    });

    /* JADX INFO: renamed from: normalColor$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy normalColor = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$normalColor$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m376invoke() {
            return Integer.valueOf(Color.parseColor("#4dffffff"));
        }
    });

    /* JADX INFO: renamed from: dp20$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dp20 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$dp20$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m371invoke() {
            return Integer.valueOf(SizeUtils.b(20.0f));
        }
    });

    /* JADX INFO: renamed from: dp8$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dp8 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$dp8$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m373invoke() {
            return Integer.valueOf(SizeUtils.b(8.0f));
        }
    });

    /* JADX INFO: renamed from: dp6$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dp6 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.common.widget.CommonBannerConfig$dp6$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m372invoke() {
            return Integer.valueOf(SizeUtils.b(6.0f));
        }
    });

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0016\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;", "", "()V", "setStyle", "", "context", "Landroid/content/Context;", "config", "Lcom/huachenjie/common/widget/CommonBannerConfig;", MediationConstant.RIT_TYPE_BANNER, "Lcom/youth/banner/Banner;", "CircleStyle", "RectangleStyle", "Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle$CircleStyle;", "Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle$RectangleStyle;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class BannerIndicatorStyle {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle$CircleStyle;", "Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;", "()V", "setStyle", "", "context", "Landroid/content/Context;", "config", "Lcom/huachenjie/common/widget/CommonBannerConfig;", MediationConstant.RIT_TYPE_BANNER, "Lcom/youth/banner/Banner;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CircleStyle extends BannerIndicatorStyle {

            @NotNull
            public static final CircleStyle INSTANCE = new CircleStyle();

            private CircleStyle() {
                super(null);
            }

            @Override // com.huachenjie.common.widget.CommonBannerConfig.BannerIndicatorStyle
            public void setStyle(@NotNull Context context, @NotNull CommonBannerConfig config, @NotNull Banner<?, ?> banner) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(banner, MediationConstant.RIT_TYPE_BANNER);
                banner.setIndicator(new CircleIndicator(context));
                banner.setIndicatorNormalColor(config.getNormalColor$common_release());
                banner.setIndicatorSelectedColor(-1);
                banner.setIndicatorNormalWidth(config.getDp6$common_release());
                banner.setIndicatorSelectedWidth(config.getDp6$common_release());
                banner.setIndicatorSpace(config.getDp8$common_release());
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle$RectangleStyle;", "Lcom/huachenjie/common/widget/CommonBannerConfig$BannerIndicatorStyle;", "()V", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RectangleStyle extends BannerIndicatorStyle {

            @NotNull
            public static final RectangleStyle INSTANCE = new RectangleStyle();

            private RectangleStyle() {
                super(null);
            }
        }

        private BannerIndicatorStyle() {
        }

        public /* synthetic */ BannerIndicatorStyle(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public void setStyle(@NotNull Context context, @NotNull CommonBannerConfig config, @NotNull Banner<?, ?> banner) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(banner, MediationConstant.RIT_TYPE_BANNER);
            banner.setIndicator(new RectangleIndicator(context));
            banner.setIndicatorNormalColor(config.getNormalColor$common_release());
            banner.setIndicatorSelectedColor(-1);
            banner.setIndicatorNormalWidth(config.getDp20$common_release());
            banner.setIndicatorSelectedWidth(config.getDp20$common_release());
            banner.setIndicatorSpace(config.getDp8$common_release());
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getActivity$common_release, reason: from getter */
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final int getBannerWidth() {
        return this.bannerWidth;
    }

    public final int getDp20$common_release() {
        return ((Number) this.dp20.getValue()).intValue();
    }

    public final int getDp6$common_release() {
        return ((Number) this.dp6.getValue()).intValue();
    }

    public final int getDp8$common_release() {
        return ((Number) this.dp8.getValue()).intValue();
    }

    @Nullable
    /* JADX INFO: renamed from: getFragment$common_release, reason: from getter */
    public final Fragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final BannerIndicatorStyle getIndicatorStyle() {
        return this.indicatorStyle;
    }

    public final int getMaxHeight$common_release() {
        return ((Number) this.maxHeight.getValue()).intValue();
    }

    public final int getMaxHeightDp() {
        return this.maxHeightDp;
    }

    /* JADX INFO: renamed from: getMaxRatio$common_release, reason: from getter */
    public final float getMaxRatio() {
        return this.maxRatio;
    }

    public final int getMinHeight$common_release() {
        return ((Number) this.minHeight.getValue()).intValue();
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getNormalColor$common_release() {
        return ((Number) this.normalColor.getValue()).intValue();
    }

    public final void setActivity$common_release(@Nullable FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public final void setBannerWidth(int i) {
        this.bannerWidth = i;
    }

    public final void setFragment$common_release(@Nullable Fragment fragment) {
        this.fragment = fragment;
    }

    public final void setIndicatorStyle(@NotNull BannerIndicatorStyle bannerIndicatorStyle) {
        Intrinsics.checkNotNullParameter(bannerIndicatorStyle, "<set-?>");
        this.indicatorStyle = bannerIndicatorStyle;
    }

    public final void setMaxHeightDp(int i) {
        this.maxHeightDp = i;
    }

    public final void setMaxRatio$common_release(float f) {
        this.maxRatio = f;
    }

    public final void setMinHeightDp(int i) {
        this.minHeightDp = i;
    }
}
