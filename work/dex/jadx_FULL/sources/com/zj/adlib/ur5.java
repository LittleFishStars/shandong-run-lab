package com.zj.adlib;

import android.view.View;
import androidx.coroutines.DataBindingUtil;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.huachenjie.works.databinding.WorksItemCommentMoreBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/zj/adlib/ur5;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "b", "Lkotlin/Function2;", "Lcom/huachenjie/works/bean/comment/CommentBean;", "Lcom/huachenjie/works/bean/comment/CommentMoreBean;", "Lkotlin/jvm/functions/Function2;", "onClickMore", "I", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ur5 extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int itemViewType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Function2<CommentBean, CommentMoreBean, Unit> onClickMore;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int layoutId;

    /* JADX WARN: Multi-variable type inference failed */
    public ur5(@NotNull Function2<? super CommentBean, ? super CommentMoreBean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onClickMore");
        this.onClickMore = function2;
        this.itemViewType = 2;
        this.layoutId = R.layout.works_item_comment_more;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemCommentMoreBinding worksItemCommentMoreBinding = (WorksItemCommentMoreBinding) DataBindingUtil.bind(helper.itemView);
        if (worksItemCommentMoreBinding != null) {
            worksItemCommentMoreBinding.setVariable(qk0.g, item);
            worksItemCommentMoreBinding.executePendingBindings();
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.chad.library.adapter.base.BaseNodeAdapter, com.chad.library.adapter.base.BaseQuickAdapter] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        ?? adapter2;
        int iFindParentNode;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        CommentMoreBean commentMoreBean = (CommentMoreBean) data;
        if (commentMoreBean.isLoading() || (adapter2 = getAdapter2()) == 0 || (iFindParentNode = adapter2.findParentNode(position)) < 0) {
            return;
        }
        BaseNode baseNode = (BaseNode) adapter2.getItem(iFindParentNode);
        commentMoreBean.setLoading(true);
        adapter2.notifyItemChanged(position + adapter2.getHeaderLayoutCount());
        Function2<CommentBean, CommentMoreBean, Unit> function2 = this.onClickMore;
        Intrinsics.checkNotNull(baseNode, "null cannot be cast to non-null type com.huachenjie.works.bean.comment.CommentBean");
        function2.invoke((CommentBean) baseNode, data);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return this.itemViewType;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return this.layoutId;
    }
}
