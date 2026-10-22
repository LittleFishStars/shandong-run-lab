package com.huachenjie.channel.page.manage_channel.admin;

import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.zj.adlib.tk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageAdminAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;

    public ManageAdminAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.channel_item_manage_admin_title);
        addItemType(1, R.layout.channel_item_manage_admin_user);
        addItemType(2, R.layout.channel_item_manage_admin_sub_title);
        addItemType(3, R.layout.channel_item_manage_admin_add_sub);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull MultiItemEntity item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemViewType = holder.getItemViewType();
        ViewDataBinding viewDataBindingBind = (itemViewType == 1 || itemViewType == 2) ? DataBindingUtil.bind(holder.itemView) : null;
        if (viewDataBindingBind != null) {
            viewDataBindingBind.setVariable(tk0.g, item);
            viewDataBindingBind.executePendingBindings();
        }
    }
}
