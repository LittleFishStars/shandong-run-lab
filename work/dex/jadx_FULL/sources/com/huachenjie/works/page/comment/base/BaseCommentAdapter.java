package com.huachenjie.works.page.comment.base;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.page.comment.base.provider.CommentProvider;
import com.huachenjie.works.page.comment.base.provider.CommentReplyProvider;
import com.zj.adlib.ur5;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/page/comment/base/BaseCommentAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "Lcom/huachenjie/works/page/comment/base/provider/CommentProvider;", "commentProvider", "Lcom/huachenjie/works/page/comment/base/provider/CommentReplyProvider;", "commentReplyProvider", "Lcom/zj/adlib/ur5;", "moreProvider", "<init>", "(Lcom/huachenjie/works/page/comment/base/provider/CommentProvider;Lcom/huachenjie/works/page/comment/base/provider/CommentReplyProvider;Lcom/zj/adlib/ur5;)V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BaseCommentAdapter extends BaseNodeAdapter implements LoadMoreModule {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCommentAdapter(@NotNull CommentProvider commentProvider, @NotNull CommentReplyProvider commentReplyProvider, @NotNull ur5 ur5Var) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(commentProvider, "commentProvider");
        Intrinsics.checkNotNullParameter(commentReplyProvider, "commentReplyProvider");
        Intrinsics.checkNotNullParameter(ur5Var, "moreProvider");
        addNodeProvider(commentProvider);
        addNodeProvider(commentReplyProvider);
        addNodeProvider(ur5Var);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseNode baseNode = data.get(position);
        if (baseNode instanceof CommentBean) {
            return 0;
        }
        return baseNode instanceof CommentReplyBean ? 1 : 2;
    }
}
