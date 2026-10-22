package com.huachenjie.common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleEventObserver;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.widget.CommonBanner;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.fx7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003%&'B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 J*\u0010\u0018\u001a\u00020\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014J*\u0010\u0018\u001a\u00020\u001b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/huachenjie/common/widget/CommonBanner;", "Lcom/youth/banner/Banner;", "Lcom/huachenjie/common/bean/CommonBannerBean;", "Lcom/huachenjie/common/widget/CommonBanner$CommonBannerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animImageView", "Landroid/widget/ImageView;", "getAnimImageView", "()Landroid/widget/ImageView;", "animImageView$delegate", "Lkotlin/Lazy;", "config", "Lcom/huachenjie/common/widget/CommonBannerConfig;", "value", "", "imageList", "setImageList", "(Ljava/util/List;)V", "bindLifecycle", "", "initBanner", "setCurrentItemAndStart", "position", "smoothScroll", "", "fragment", "Landroidx/fragment/app/Fragment;", TTDownloadField.TT_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "BannerDefaultPageChangeListener", "CommonBannerAdapter", "DetailBannerHolder", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonBanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonBanner.kt\ncom/huachenjie/common/widget/CommonBanner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,354:1\n1855#2,2:355\n1940#2,14:357\n*S KotlinDebug\n*F\n+ 1 CommonBanner.kt\ncom/huachenjie/common/widget/CommonBanner\n*L\n41#1:355,2\n136#1:357,14\n*E\n"})
public final class CommonBanner extends Banner<CommonBannerBean, CommonBannerAdapter> {

    /* JADX INFO: renamed from: animImageView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy animImageView;
    private CommonBannerConfig config;

    @NotNull
    private List<CommonBannerBean> imageList;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/widget/CommonBanner$BannerDefaultPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "(Lcom/huachenjie/common/widget/CommonBanner;)V", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class BannerDefaultPageChangeListener implements ViewPager.OnPageChangeListener {
        public BannerDefaultPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0001B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J,\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00060\u0003R\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/widget/CommonBanner$CommonBannerAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/huachenjie/common/bean/CommonBannerBean;", "Lcom/huachenjie/common/widget/CommonBanner$DetailBannerHolder;", "Lcom/huachenjie/common/widget/CommonBanner;", "data", "", "(Lcom/huachenjie/common/widget/CommonBanner;Ljava/util/List;)V", "hasSetBannerListener", "", "onBindView", "", "holder", "position", "", "size", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnBannerListener", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/youth/banner/listener/OnBannerListener;", "setPreviewPictureListener", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCommonBanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonBanner.kt\ncom/huachenjie/common/widget/CommonBanner$CommonBannerAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,354:1\n1549#2:355\n1620#2,3:356\n*S KotlinDebug\n*F\n+ 1 CommonBanner.kt\ncom/huachenjie/common/widget/CommonBanner$CommonBannerAdapter\n*L\n212#1:355\n212#1:356,3\n*E\n"})
    public final class CommonBannerAdapter extends BannerAdapter<CommonBannerBean, DetailBannerHolder> {
        private boolean hasSetBannerListener;
        final /* synthetic */ CommonBanner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommonBannerAdapter(@NotNull CommonBanner commonBanner, List<CommonBannerBean> list) {
            super(list);
            Intrinsics.checkNotNullParameter(list, "data");
            this.this$0 = commonBanner;
        }

        private final void setPreviewPictureListener(DetailBannerHolder holder, final int position) {
            View view = holder.itemView;
            final CommonBanner commonBanner = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xp1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonBanner.CommonBannerAdapter.setPreviewPictureListener$lambda$2(commonBanner, position, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setPreviewPictureListener$lambda$2(final CommonBanner commonBanner, int i, View view) {
            Object fragment$common_release;
            Intrinsics.checkNotNullParameter(commonBanner, "this$0");
            CommonBannerConfig commonBannerConfig = commonBanner.config;
            CommonBannerConfig commonBannerConfig2 = null;
            if (commonBannerConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                commonBannerConfig = null;
            }
            if (commonBannerConfig.getActivity() != null) {
                CommonBannerConfig commonBannerConfig3 = commonBanner.config;
                if (commonBannerConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                } else {
                    commonBannerConfig2 = commonBannerConfig3;
                }
                fragment$common_release = commonBannerConfig2.getActivity();
                Intrinsics.checkNotNull(fragment$common_release);
            } else {
                CommonBannerConfig commonBannerConfig4 = commonBanner.config;
                if (commonBannerConfig4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                } else {
                    commonBannerConfig2 = commonBannerConfig4;
                }
                fragment$common_release = commonBannerConfig2.getFragment();
                Intrinsics.checkNotNull(fragment$common_release);
            }
            final Object obj = fragment$common_release;
            PicturePreviewUtil picturePreviewUtil = PicturePreviewUtil.f33906a;
            List list = commonBanner.imageList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CommonBannerBean) it.next()).getUrl());
            }
            picturePreviewUtil.k(obj, arrayList, i, new Function1<Integer, View>() { // from class: com.huachenjie.common.widget.CommonBanner$CommonBannerAdapter$setPreviewPictureListener$1$4
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }

                @Nullable
                public final View invoke(int i2) {
                    return commonBanner.getAnimImageView();
                }
            }, new Function3<Integer, String, ImageView, Unit>() { // from class: com.huachenjie.common.widget.CommonBanner$CommonBannerAdapter$setPreviewPictureListener$1$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    invoke(((Number) obj2).intValue(), (String) obj3, (ImageView) obj4);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, @NotNull String str, @NotNull ImageView imageView) {
                    RequestManager requestManagerWith;
                    Intrinsics.checkNotNullParameter(str, "url");
                    Intrinsics.checkNotNullParameter(imageView, "imageView");
                    Object obj2 = obj;
                    if (obj2 instanceof Activity) {
                        requestManagerWith = Glide.with((Activity) obj2);
                    } else {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                        requestManagerWith = Glide.with((Fragment) obj2);
                    }
                    requestManagerWith.load(str).into(imageView);
                }
            }, new BannerDefaultPageChangeListener() { // from class: com.huachenjie.common.widget.CommonBanner$CommonBannerAdapter$setPreviewPictureListener$1$2
                {
                    super();
                }

                @Override // com.huachenjie.common.widget.CommonBanner.BannerDefaultPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    this.this$0.setCurrentItem(position + 1, false);
                    this.this$0.setIndicatorPageChange();
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.yp1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CommonBanner.CommonBannerAdapter.setPreviewPictureListener$lambda$2$lambda$1(commonBanner, dialogInterface);
                }
            });
            commonBanner.stop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setPreviewPictureListener$lambda$2$lambda$1(CommonBanner commonBanner, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(commonBanner, "this$0");
            commonBanner.start();
        }

        public void setOnBannerListener(@Nullable OnBannerListener<CommonBannerBean> listener) {
            super.setOnBannerListener(listener);
            if (listener == null) {
                this.hasSetBannerListener = false;
            } else {
                this.hasSetBannerListener = true;
            }
        }

        public void onBindView(@NotNull DetailBannerHolder holder, @NotNull CommonBannerBean data, int position, int size) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(data, "data");
            holder.getIvBanner().getLayoutParams().height = this.this$0.getLayoutParams().height;
            ViewGroup.LayoutParams layoutParams = holder.getIvBanner().getLayoutParams();
            CommonBannerConfig commonBannerConfig = this.this$0.config;
            if (commonBannerConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                commonBannerConfig = null;
            }
            layoutParams.width = commonBannerConfig.getBannerWidth();
            if (data.getDelFlag()) {
                holder.itemView.setBackgroundColor(Color.parseColor("#C1C1C1"));
                holder.getIvBanner().setVisibility(8);
                holder.getTvDel().setVisibility(0);
                holder.getIvTag().setVisibility(0);
            } else {
                holder.getIvTag().setVisibility(8);
                holder.getTvDel().setVisibility(8);
                holder.getIvBanner().setVisibility(0);
                holder.itemView.setBackgroundDrawable(null);
                Glide.with(holder.itemView).load(data.getUrl()).centerCrop().placeholder(R.drawable.common_bg_banner_placeholder).into(holder.getIvBanner());
            }
            if (this.hasSetBannerListener) {
                return;
            }
            setPreviewPictureListener(holder, position);
        }

        @NotNull
        /* JADX INFO: renamed from: onCreateHolder, reason: merged with bridge method [inline-methods] */
        public DetailBannerHolder m366onCreateHolder(@Nullable ViewGroup parent, int viewType) {
            CommonBanner commonBanner = this.this$0;
            View viewInflate = LayoutInflater.from(parent != null ? parent.getContext() : null).inflate(R.layout.common_item_common_banner, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent?.context).in…  false\n                )");
            return new DetailBannerHolder(commonBanner, viewInflate);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/common/widget/CommonBanner$DetailBannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bannerView", "Landroid/view/View;", "(Lcom/huachenjie/common/widget/CommonBanner;Landroid/view/View;)V", "ivBanner", "Landroid/widget/ImageView;", "getIvBanner", "()Landroid/widget/ImageView;", "ivBanner$delegate", "Lkotlin/Lazy;", "ivTag", "getIvTag", "ivTag$delegate", "tvDel", "Landroid/widget/TextView;", "getTvDel", "()Landroid/widget/TextView;", "tvDel$delegate", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DetailBannerHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: ivBanner$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy ivBanner;

        /* JADX INFO: renamed from: ivTag$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy ivTag;
        final /* synthetic */ CommonBanner this$0;

        /* JADX INFO: renamed from: tvDel$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy tvDel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetailBannerHolder(@NotNull CommonBanner commonBanner, final View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "bannerView");
            this.this$0 = commonBanner;
            this.ivBanner = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.common.widget.CommonBanner$DetailBannerHolder$ivBanner$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final ImageView m367invoke() {
                    return (ImageView) view.findViewById(R.id.iv_banner);
                }
            });
            this.ivTag = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.common.widget.CommonBanner$DetailBannerHolder$ivTag$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final ImageView m368invoke() {
                    return (ImageView) view.findViewById(R.id.iv_tag);
                }
            });
            this.tvDel = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.common.widget.CommonBanner$DetailBannerHolder$tvDel$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final TextView m369invoke() {
                    return (TextView) view.findViewById(R.id.tv_del);
                }
            });
        }

        @NotNull
        public final ImageView getIvBanner() {
            Object value = this.ivBanner.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-ivBanner>(...)");
            return (ImageView) value;
        }

        @NotNull
        public final ImageView getIvTag() {
            Object value = this.ivTag.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-ivTag>(...)");
            return (ImageView) value;
        }

        @NotNull
        public final TextView getTvDel() {
            Object value = this.tvDel.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-tvDel>(...)");
            return (TextView) value;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CommonBanner(@Nullable Context context) {
        super(context);
        this.imageList = new ArrayList();
        this.animImageView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.common.widget.CommonBanner$animImageView$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m370invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new FrameLayout.LayoutParams(this.this$0.getLayoutParams().width, this.this$0.getLayoutParams().height));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.this$0.addView(imageView, 0);
                return imageView;
            }
        });
    }

    private final void bindLifecycle() {
        Lifecycle lifecycle;
        CommonBannerConfig commonBannerConfig = this.config;
        if (commonBannerConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig = null;
        }
        FragmentActivity activity$common_release = commonBannerConfig.getActivity();
        if (activity$common_release == null || (lifecycle = activity$common_release.getLifecycle()) == null) {
            CommonBannerConfig commonBannerConfig2 = this.config;
            if (commonBannerConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                commonBannerConfig2 = null;
            }
            Fragment fragment$common_release = commonBannerConfig2.getFragment();
            Lifecycle lifecycle2 = fragment$common_release != null ? fragment$common_release.getLifecycle() : null;
            if (lifecycle2 == null) {
                return;
            } else {
                lifecycle = lifecycle2;
            }
        }
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.zj.adlib.wp1
            @Override // androidx.p002lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                CommonBanner.bindLifecycle$lambda$1(this.f45652a, lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLifecycle$lambda$1(CommonBanner commonBanner, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(commonBanner, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            commonBanner.start();
        } else if (i == 2) {
            commonBanner.stop();
        } else {
            if (i != 3) {
                return;
            }
            commonBanner.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getAnimImageView() {
        return (ImageView) this.animImageView.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initBanner() {
        float ratio;
        CommonBannerConfig commonBannerConfig = this.config;
        CommonBannerConfig commonBannerConfig2 = null;
        if (commonBannerConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig = null;
        }
        if (this.imageList.isEmpty()) {
            ratio = 0.0f;
        } else {
            Iterator<T> it = this.imageList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                float ratio2 = ((CommonBannerBean) next).getRatio();
                do {
                    Object next2 = it.next();
                    float ratio3 = ((CommonBannerBean) next2).getRatio();
                    if (Float.compare(ratio2, ratio3) < 0) {
                        next = next2;
                        ratio2 = ratio3;
                    }
                } while (it.hasNext());
            }
            ratio = ((CommonBannerBean) next).getRatio();
        }
        commonBannerConfig.setMaxRatio$common_release(ratio);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        float fJ = fx7.j();
        CommonBannerConfig commonBannerConfig3 = this.config;
        if (commonBannerConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig3 = null;
        }
        int maxRatio$common_release = (int) (fJ * commonBannerConfig3.getMaxRatio());
        CommonBannerConfig commonBannerConfig4 = this.config;
        if (commonBannerConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig4 = null;
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(maxRatio$common_release, commonBannerConfig4.getMaxHeight$common_release());
        CommonBannerConfig commonBannerConfig5 = this.config;
        if (commonBannerConfig5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig5 = null;
        }
        layoutParams.height = RangesKt.coerceAtLeast(iCoerceAtMost, commonBannerConfig5.getMinHeight$common_release());
        if (getAdapter() != null) {
            setDatas(this.imageList);
        } else {
            setAdapter(new CommonBannerAdapter(this, this.imageList));
        }
        CommonBannerConfig commonBannerConfig6 = this.config;
        if (commonBannerConfig6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            commonBannerConfig6 = null;
        }
        CommonBannerConfig.BannerIndicatorStyle indicatorStyle = commonBannerConfig6.getIndicatorStyle();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CommonBannerConfig commonBannerConfig7 = this.config;
        if (commonBannerConfig7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        } else {
            commonBannerConfig2 = commonBannerConfig7;
        }
        indicatorStyle.setStyle(context, commonBannerConfig2, this);
        getAnimImageView();
    }

    public static /* synthetic */ void setCurrentItemAndStart$default(CommonBanner commonBanner, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        commonBanner.setCurrentItemAndStart(i, z);
    }

    private final void setImageList(List<CommonBannerBean> list) {
        this.imageList = list;
        for (CommonBannerBean commonBannerBean : list) {
            commonBannerBean.setRatio(commonBannerBean.getHeight() / ((((float) commonBannerBean.getWidth()) > 0.0f ? 1 : (((float) commonBannerBean.getWidth()) == 0.0f ? 0 : -1)) == 0 ? 1.0f : commonBannerBean.getWidth()));
        }
        initBanner();
    }

    public static /* synthetic */ void setImageList$default(CommonBanner commonBanner, Fragment fragment, List list, CommonBannerConfig commonBannerConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            fragment = null;
        }
        if ((i & 4) != 0) {
            commonBannerConfig = new CommonBannerConfig();
        }
        commonBanner.setImageList(fragment, (List<CommonBannerBean>) list, commonBannerConfig);
    }

    public final void setCurrentItemAndStart(int position, boolean smoothScroll) {
        setCurrentItem(position, smoothScroll);
        setIndicatorPageChange();
        isAutoLoop(true);
        start();
    }

    public static /* synthetic */ void setImageList$default(CommonBanner commonBanner, FragmentActivity fragmentActivity, List list, CommonBannerConfig commonBannerConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            fragmentActivity = null;
        }
        if ((i & 4) != 0) {
            commonBannerConfig = new CommonBannerConfig();
        }
        commonBanner.setImageList(fragmentActivity, (List<CommonBannerBean>) list, commonBannerConfig);
    }

    public CommonBanner(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imageList = new ArrayList();
        this.animImageView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.common.widget.CommonBanner$animImageView$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m370invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new FrameLayout.LayoutParams(this.this$0.getLayoutParams().width, this.this$0.getLayoutParams().height));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.this$0.addView(imageView, 0);
                return imageView;
            }
        });
    }

    public CommonBanner(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imageList = new ArrayList();
        this.animImageView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.common.widget.CommonBanner$animImageView$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m370invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new FrameLayout.LayoutParams(this.this$0.getLayoutParams().width, this.this$0.getLayoutParams().height));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.this$0.addView(imageView, 0);
                return imageView;
            }
        });
    }

    public final void setImageList(@Nullable Fragment fragment, @NotNull List<CommonBannerBean> imageList, @NotNull CommonBannerConfig config) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        if (config == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            config = null;
        }
        config.setFragment$common_release(fragment);
        setImageList(imageList);
        bindLifecycle();
    }

    public final void setImageList(@Nullable FragmentActivity activity, @NotNull List<CommonBannerBean> imageList, @NotNull CommonBannerConfig config) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        if (config == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            config = null;
        }
        config.setActivity$common_release(activity);
        setImageList(imageList);
        bindLifecycle();
    }
}
