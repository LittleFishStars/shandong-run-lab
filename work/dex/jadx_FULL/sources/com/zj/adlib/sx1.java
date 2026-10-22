package com.zj.adlib;

import android.view.View;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/zj/adlib/sx1;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "b", "Lkotlin/Function1;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", "Lkotlin/jvm/functions/Function1;", "onAdd", "I", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class sx1 extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int itemViewType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final Function1<MyChannelTopicGroup, Unit> onAdd;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int layoutId;

    /* JADX WARN: Illegal instructions before constructor call */
    public sx1() {
        Function1 function1 = null;
        this(function1, 1, function1);
    }

    public /* synthetic */ sx1(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.chad.library.adapter.base.BaseNodeAdapter, com.chad.library.adapter.base.BaseQuickAdapter] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        int iFindParentNode;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        ?? adapter2 = getAdapter2();
        if (adapter2 == 0 || (iFindParentNode = adapter2.findParentNode(position)) < 0) {
            return;
        }
        Object item = adapter2.getItem(iFindParentNode);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup");
        MyChannelTopicGroup myChannelTopicGroup = (MyChannelTopicGroup) item;
        Function1<MyChannelTopicGroup, Unit> function1 = this.onAdd;
        if (function1 != null) {
            function1.invoke(myChannelTopicGroup);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return this.itemViewType;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return this.layoutId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public sx1(@Nullable Function1<? super MyChannelTopicGroup, Unit> function1) {
        this.onAdd = function1;
        this.itemViewType = 2;
        this.layoutId = R.layout.channel_item_manage_create_topic;
    }
}
