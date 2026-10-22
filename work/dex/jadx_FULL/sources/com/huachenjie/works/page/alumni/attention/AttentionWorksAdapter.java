package com.huachenjie.works.page.alumni.attention;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.databinding.WorksItemAttentionWorksBottomBinding;
import com.huachenjie.works.databinding.WorksItemAttentionWorksHeaderBinding;
import com.huachenjie.works.databinding.WorksItemAttentionWorksPictureBinding;
import com.huachenjie.works.databinding.WorksItemAttentionWorksVideoBinding;
import com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.fx7;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 !2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005:\u0001!B\u000f\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b2\u00103J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002R\u0017\u0010%\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u001b\u0010/\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u0018\u00101\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00100¨\u00064"}, d2 = {"Lcom/huachenjie/works/page/alumni/attention/AttentionWorksAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/works/bean/WorkDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "", j.b, "u", "t", "Lcom/huachenjie/works/databinding/WorksItemAttentionWorksHeaderBinding;", "attentionWorksHeader", "position", "j", "Lcom/huachenjie/works/databinding/WorksItemAttentionWorksBottomBinding;", "attentionWorksBottom", "i", "Lcom/huachenjie/common/widget/CommonBanner;", MediationConstant.RIT_TYPE_BANNER, "k", "Landroid/widget/FrameLayout;", "container", "m", "", "aspectRatio", y6b.g, "Landroid/view/View;", "p", "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "q", "()Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Lazy;", "n", "()I", "appScreenWidth", "b", "r", "maxContainerHeight", "c", "s", "minContainerHeight", "Landroid/view/View;", "mEmptyView", "<init>", "(Landroidx/fragment/app/Fragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttentionWorksAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttentionWorksAdapter.kt\ncom/huachenjie/works/page/alumni/attention/AttentionWorksAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,236:1\n1549#2:237\n1620#2,3:238\n*S KotlinDebug\n*F\n+ 1 AttentionWorksAdapter.kt\ncom/huachenjie/works/page/alumni/attention/AttentionWorksAdapter\n*L\n149#1:237\n149#1:238,3\n*E\n"})
public final class AttentionWorksAdapter extends BaseMultiItemQuickAdapter<WorkDetailBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {

    @NotNull
    public static final String f = "coverTag";

    @NotNull
    public static final String g = "playButtonTag";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Fragment fragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy appScreenWidth;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy maxContainerHeight;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy minContainerHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionWorksAdapter(@NotNull Fragment fragment) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.appScreenWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter$appScreenWidth$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m843invoke() {
                return Integer.valueOf(fx7.e());
            }
        });
        this.maxContainerHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter$maxContainerHeight$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m844invoke() {
                return Integer.valueOf(SizeUtils.b(500.0f));
            }
        });
        this.minContainerHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter$minContainerHeight$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m845invoke() {
                return Integer.valueOf(SizeUtils.b(160.0f));
            }
        });
        addItemType(1, R.layout.works_item_attention_works_picture);
        addItemType(2, R.layout.works_item_attention_works_video);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.kd0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AttentionWorksAdapter.g(this.f42789a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void g(AttentionWorksAdapter attentionWorksAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(attentionWorksAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, ((WorkDetailBean) attentionWorksAdapter.getData().get(i)).getWorksNo()).withBoolean(yj7.g.WORKS_LOAD_MORE, true).navigation();
    }

    public static final void l(WorkDetailBean workDetailBean, CommonBannerBean commonBannerBean, int i) {
        Intrinsics.checkNotNullParameter(workDetailBean, "$item");
        ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, workDetailBean.getWorksNo()).navigation();
    }

    public final void h(FrameLayout container, float aspectRatio) {
        float fN = (aspectRatio > 0.0f ? 1 : (aspectRatio == 0.0f ? 0 : -1)) == 0 ? n() : n() / aspectRatio;
        if (fN > r()) {
            fN = r();
        }
        if (fN < s()) {
            fN = s();
        }
        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(0, 0);
        }
        layoutParams.height = MathKt.roundToInt(fN);
        container.setLayoutParams(layoutParams);
    }

    public final void i(WorksItemAttentionWorksBottomBinding attentionWorksBottom, final WorkDetailBean item) {
        attentionWorksBottom.f14436a.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter$dealBottom$1$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, int i) {
                item.setCollected(z, i);
            }
        });
        attentionWorksBottom.f14439b.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter$dealBottom$1$2
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, int i) {
                item.setLiked(z, i);
            }
        });
    }

    public final void j(WorksItemAttentionWorksHeaderBinding attentionWorksHeader, int position) {
        attentionWorksHeader.f36999a.setVisibility(position == 0 ? 8 : 0);
    }

    public final void k(CommonBanner banner, final WorkDetailBean item) {
        banner.isAutoLoop(false);
        banner.setStartPosition(item.getStartPosition());
        Fragment fragment = this.fragment;
        List<WorkImageBean> imageList = item.formatImageList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageList, 10));
        for (WorkImageBean workImageBean : imageList) {
            arrayList.add(new CommonBannerBean(workImageBean.getPath(), workImageBean.getWidth(), workImageBean.getHeight(), workImageBean.getDelFlag(), 0.0f, 16, null));
        }
        CommonBannerConfig commonBannerConfig = new CommonBannerConfig();
        commonBannerConfig.setBannerWidth(n());
        commonBannerConfig.setMinHeightDp(160);
        commonBannerConfig.setMaxHeightDp(500);
        Unit unit = Unit.INSTANCE;
        banner.setImageList(fragment, arrayList, commonBannerConfig);
        banner.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.ld0
            public final void OnBannerClick(Object obj, int i) {
                AttentionWorksAdapter.l(item, (CommonBannerBean) obj, i);
            }
        });
    }

    public final void m(FrameLayout container, WorkDetailBean item) {
        container.removeAllViews();
        container.setBackgroundColor(-16777216);
        ImageView imageView = new ImageView(getContext());
        imageView.setTag(f);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Glide.with(imageView).load(item.formatCoverBean().getPath()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.ic_empty_large_placeholder).error(R.mipmap.ic_empty_large)).into(imageView);
        container.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setTag(g);
        imageView2.setImageResource(R.drawable.ic_ali_video_play);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(SizeUtils.b(80.0f), SizeUtils.b(80.0f));
        layoutParams.gravity = 17;
        container.addView(imageView2, layoutParams);
        Size videoSize = item.formatVideoSize();
        h(container, videoSize.getWidth() / (videoSize.getHeight() <= 0 ? 1 : videoSize.getHeight()));
    }

    public final int n() {
        return ((Number) this.appScreenWidth.getValue()).intValue();
    }

    public final int o() {
        return R.layout.layout_empty_work;
    }

    public final View p() {
        if (this.mEmptyView == null) {
            this.mEmptyView = LayoutInflater.from(getContext()).inflate(o(), (ViewGroup) null);
        }
        return this.mEmptyView;
    }

    @NotNull
    /* JADX INFO: renamed from: q, reason: from getter */
    public final Fragment getFragment() {
        return this.fragment;
    }

    public final int r() {
        return ((Number) this.maxContainerHeight.getValue()).intValue();
    }

    public final int s() {
        return ((Number) this.minContainerHeight.getValue()).intValue();
    }

    public final void t() {
        removeEmptyView();
    }

    public final void u() {
        if (hasEmptyView() || p() == null) {
            return;
        }
        View viewP = p();
        Intrinsics.checkNotNull(viewP);
        setEmptyView(viewP);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull WorkDetailBean item) {
        TextView textView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int absoluteAdapterPosition = holder.getAbsoluteAdapterPosition();
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int postType = item.getPostType();
            if (postType == 1) {
                WorksItemAttentionWorksPictureBinding worksItemAttentionWorksPictureBinding = (WorksItemAttentionWorksPictureBinding) dataBinding;
                WorksItemAttentionWorksHeaderBinding worksItemAttentionWorksHeaderBinding = worksItemAttentionWorksPictureBinding.f14455a;
                Intrinsics.checkNotNullExpressionValue(worksItemAttentionWorksHeaderBinding, "attentionWorksHeader");
                j(worksItemAttentionWorksHeaderBinding, absoluteAdapterPosition);
                WorksItemAttentionWorksBottomBinding worksItemAttentionWorksBottomBinding = worksItemAttentionWorksPictureBinding.f14454a;
                Intrinsics.checkNotNullExpressionValue(worksItemAttentionWorksBottomBinding, "attentionWorksBottom");
                i(worksItemAttentionWorksBottomBinding, item);
                CommonBanner commonBanner = worksItemAttentionWorksPictureBinding.f37001a;
                Intrinsics.checkNotNullExpressionValue(commonBanner, "worksBanner");
                k(commonBanner, item);
                worksItemAttentionWorksPictureBinding.k(item);
                textView = worksItemAttentionWorksPictureBinding.f14455a.f14444a;
            } else if (postType != 2) {
                textView = null;
            } else {
                WorksItemAttentionWorksVideoBinding worksItemAttentionWorksVideoBinding = (WorksItemAttentionWorksVideoBinding) dataBinding;
                WorksItemAttentionWorksHeaderBinding worksItemAttentionWorksHeaderBinding2 = worksItemAttentionWorksVideoBinding.f14462a;
                Intrinsics.checkNotNullExpressionValue(worksItemAttentionWorksHeaderBinding2, "attentionWorksHeader");
                j(worksItemAttentionWorksHeaderBinding2, absoluteAdapterPosition);
                WorksItemAttentionWorksBottomBinding worksItemAttentionWorksBottomBinding2 = worksItemAttentionWorksVideoBinding.f14461a;
                Intrinsics.checkNotNullExpressionValue(worksItemAttentionWorksBottomBinding2, "attentionWorksBottom");
                i(worksItemAttentionWorksBottomBinding2, item);
                FrameLayout frameLayout = worksItemAttentionWorksVideoBinding.f37003a;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "flWorksContainer");
                m(frameLayout, item);
                worksItemAttentionWorksVideoBinding.k(item);
                textView = worksItemAttentionWorksVideoBinding.f14462a.f14444a;
            }
            dataBinding.executePendingBindings();
            item.setTextContent(textView != null ? textView.getText() : null);
        }
    }
}
