package com.zj.adlib;

import android.view.View;
import androidx.coroutines.DataBindingUtil;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import com.huachenjie.channel.databinding.ChannelItemManageTopicGroupBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BC\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R(\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R(\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/a99;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "b", "c", "Lkotlin/Function2;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", "Lkotlin/jvm/functions/Function2;", "onEdit", "onDelete", "I", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class a99 extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int itemViewType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final Function2<MyChannelTopicGroup, Integer, Unit> onEdit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int layoutId;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final Function2<MyChannelTopicGroup, Integer, Unit> onDelete;

    /* JADX WARN: Illegal instructions before constructor call */
    public a99() {
        Function2 function2 = null;
        this(function2, function2, 3, function2);
    }

    public /* synthetic */ a99(Function2 function2, Function2 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function2, (i & 2) != 0 ? null : function3);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemManageTopicGroupBinding channelItemManageTopicGroupBinding = (ChannelItemManageTopicGroupBinding) DataBindingUtil.bind(helper.itemView);
        if (channelItemManageTopicGroupBinding != null) {
            channelItemManageTopicGroupBinding.setVariable(tk0.g, item);
            channelItemManageTopicGroupBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onChildClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Function2<MyChannelTopicGroup, Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        MyChannelTopicGroup myChannelTopicGroup = (MyChannelTopicGroup) data;
        int id = view.getId();
        if (id == R.id.tv_edit) {
            Function2<MyChannelTopicGroup, Integer, Unit> function3 = this.onEdit;
            if (function3 != null) {
                function3.invoke(myChannelTopicGroup, Integer.valueOf(position));
                return;
            }
            return;
        }
        if (id != R.id.tv_delete || (function2 = this.onDelete) == null) {
            return;
        }
        function2.invoke(myChannelTopicGroup, Integer.valueOf(position));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        ?? adapter2 = getAdapter2();
        if (adapter2 != 0) {
            BaseNodeAdapter.expandOrCollapse$default(adapter2, position, false, false, null, 14, null);
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
    public a99(@Nullable Function2<? super MyChannelTopicGroup, ? super Integer, Unit> function2, @Nullable Function2<? super MyChannelTopicGroup, ? super Integer, Unit> function3) {
        this.onEdit = function2;
        this.onDelete = function3;
        addChildClickViewIds(R.id.tv_edit, R.id.tv_delete);
        this.layoutId = R.layout.channel_item_manage_topic_group;
    }
}
