package com.huachenjie.works.external.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.databinding.WorksItemCommentOnMeBinding;
import com.huachenjie.works.external.adapter.CommentOnMeAdapter;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.noober.background.view.BLCheckBox;
import com.zj.adlib.n0a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u001e\u0010\n\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/external/adapter/CommentOnMeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemCommentOnMeBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", t.d, "j", "n", "", "K", "I", "type", "<init>", "(I)V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentOnMeAdapter extends BaseQuickAdapter<CommentOnMeBean, BaseDataBindingHolder<WorksItemCommentOnMeBinding>> implements LoadMoreModule {
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int type;

    public CommentOnMeAdapter() {
        this(0, 1, null);
    }

    public /* synthetic */ CommentOnMeAdapter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public static final void i(CommentOnMeBean commentOnMeBean, View view) {
        String path;
        Intrinsics.checkNotNullParameter(commentOnMeBean, "$item");
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        CommentImageBean image = commentOnMeBean.getImage();
        if (image == null || (path = image.getPath()) == null) {
            path = "";
        }
        PicturePreviewUtil.i(view, path);
    }

    public static final void k(CommentOnMeBean commentOnMeBean, CommentOnMeAdapter commentOnMeAdapter, BaseDataBindingHolder baseDataBindingHolder, View view) {
        Intrinsics.checkNotNullParameter(commentOnMeBean, "$item");
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseDataBindingHolder, "$holder");
        commentOnMeBean.setLiked(!commentOnMeBean.getLiked());
        if (commentOnMeBean.getLiked()) {
            n0a.f43422a.t(commentOnMeBean.getQuoteNo(), commentOnMeBean.getQuoteUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        } else {
            n0a.f43422a.A(commentOnMeBean.getQuoteNo(), commentOnMeBean.getQuoteUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        }
        commentOnMeAdapter.notifyItemChanged(baseDataBindingHolder.getBindingAdapterPosition());
    }

    public static final void m(CommentOnMeBean commentOnMeBean, View view) {
        Intrinsics.checkNotNullParameter(commentOnMeBean, "$item");
        commentOnMeBean.setLiked(!commentOnMeBean.getLiked());
        if (commentOnMeBean.getLiked()) {
            n0a.f43422a.u(commentOnMeBean.getWorksNo(), commentOnMeBean.getWorksUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        } else {
            n0a.f43422a.B(commentOnMeBean.getWorksNo(), commentOnMeBean.getWorksUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        }
    }

    public static final void o(CommentOnMeBean commentOnMeBean, CommentOnMeAdapter commentOnMeAdapter, BaseDataBindingHolder baseDataBindingHolder, View view) {
        Intrinsics.checkNotNullParameter(commentOnMeBean, "$item");
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseDataBindingHolder, "$holder");
        commentOnMeBean.setLiked(!commentOnMeBean.getLiked());
        if (commentOnMeBean.getLiked()) {
            n0a.f43422a.w(commentOnMeBean.getPostNo(), commentOnMeBean.getWorksUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        } else {
            n0a.f43422a.D(commentOnMeBean.getPostNo(), commentOnMeBean.getWorksUserCode(), commentOnMeBean.getCommentNo(), commentOnMeBean.getCommentUserCode(), 2);
        }
        commentOnMeAdapter.notifyItemChanged(baseDataBindingHolder.getBindingAdapterPosition());
    }

    public final void j(final BaseDataBindingHolder<WorksItemCommentOnMeBinding> holder, final CommentOnMeBean item) {
        BLCheckBox bLCheckBox;
        WorksItemCommentOnMeBinding worksItemCommentOnMeBinding = (WorksItemCommentOnMeBinding) holder.getDataBinding();
        if (worksItemCommentOnMeBinding != null && (bLCheckBox = worksItemCommentOnMeBinding.f14537a) != null) {
            bLCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.cp1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentOnMeAdapter.k(item, this, holder, view);
                }
            });
        }
        item.setLiked(n0a.f43422a.m(item.getQuoteNo(), item.getCommentNo(), item.getLiked()));
    }

    public final void l(BaseDataBindingHolder<WorksItemCommentOnMeBinding> holder, final CommentOnMeBean item) {
        BLCheckBox bLCheckBox;
        WorksItemCommentOnMeBinding worksItemCommentOnMeBinding = (WorksItemCommentOnMeBinding) holder.getDataBinding();
        if (worksItemCommentOnMeBinding != null && (bLCheckBox = worksItemCommentOnMeBinding.f14537a) != null) {
            bLCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dp1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentOnMeAdapter.m(item, view);
                }
            });
        }
        item.setLiked(n0a.f43422a.o(item.getWorksNo(), item.getCommentNo(), item.getLiked()));
    }

    public final void n(final BaseDataBindingHolder<WorksItemCommentOnMeBinding> holder, final CommentOnMeBean item) {
        BLCheckBox bLCheckBox;
        WorksItemCommentOnMeBinding worksItemCommentOnMeBinding = (WorksItemCommentOnMeBinding) holder.getDataBinding();
        if (worksItemCommentOnMeBinding != null && (bLCheckBox = worksItemCommentOnMeBinding.f14537a) != null) {
            bLCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ap1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentOnMeAdapter.o(item, this, holder, view);
                }
            });
        }
        item.setLiked(n0a.f43422a.p(item.getPostNo(), item.getCommentNo(), item.getLiked()));
    }

    public CommentOnMeAdapter(int i) {
        super(R.layout.works_item_comment_on_me, null, 2, null);
        this.type = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemCommentOnMeBinding> holder, @NotNull final CommentOnMeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemCommentOnMeBinding worksItemCommentOnMeBinding = (WorksItemCommentOnMeBinding) holder.getDataBinding();
        if (worksItemCommentOnMeBinding != null) {
            int i = this.type;
            if (i == 0) {
                l(holder, item);
            } else if (i == 1) {
                j(holder, item);
            } else if (i != 2) {
                l(holder, item);
            } else {
                n(holder, item);
            }
            worksItemCommentOnMeBinding.f37021a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bp1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentOnMeAdapter.i(item, view);
                }
            });
            worksItemCommentOnMeBinding.k(item);
            worksItemCommentOnMeBinding.executePendingBindings();
        }
    }
}
