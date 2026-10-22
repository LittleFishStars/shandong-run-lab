package com.huachenjie.channel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelItemJoinChannelBinding;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.external.bean.ChannelBean;
import com.zj.adlib.y6b;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/channel/adapter/JoinChannelAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/external/bean/ChannelBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemJoinChannelBinding;", "holder", "item", "", "convert", "", GoodsSpecificationPreviewActivity.z, "setList", y6b.g, y6b.f, "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "f", "()Landroid/view/View;", "emptyView", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class JoinChannelAdapter extends BaseQuickAdapter<ChannelBean, BaseDataBindingHolder<ChannelItemJoinChannelBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy emptyView;

    /* JADX WARN: Illegal instructions before constructor call */
    public JoinChannelAdapter() {
        List list = null;
        super(R.layout.channel_item_join_channel, list, 2, list);
        this.emptyView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.channel.adapter.JoinChannelAdapter$emptyView$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m241invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) this.this$0.getRecyclerView(), false);
                ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText(viewInflate.getContext().getString(R.string.channel_join_channel_none));
                ViewGroup.LayoutParams layoutParams = ((ImageView) viewInflate.findViewById(R.id.emptyView)).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.4f;
                return viewInflate;
            }
        });
    }

    public final View f() {
        return (View) this.emptyView.getValue();
    }

    public final void g() {
        removeEmptyView();
    }

    public final void h() {
        if (hasEmptyView()) {
            return;
        }
        View viewF = f();
        Intrinsics.checkNotNullExpressionValue(viewF, "emptyView");
        setEmptyView(viewF);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@Nullable Collection<? extends ChannelBean> list) {
        super.setList(list);
        if (getRecyclerViewOrNull() == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            h();
        } else {
            g();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemJoinChannelBinding> holder, @NotNull ChannelBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemJoinChannelBinding channelItemJoinChannelBinding = (ChannelItemJoinChannelBinding) holder.getDataBinding();
        if (channelItemJoinChannelBinding != null) {
            channelItemJoinChannelBinding.k(item);
            channelItemJoinChannelBinding.executePendingBindings();
        }
    }
}
