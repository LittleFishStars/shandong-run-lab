package com.huachenjie.works.page.share.choose_friend;

import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksItemChooseFriendBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendAdapter;", "Lcom/huachenjie/base/adapter/BaseRefreshAdapter;", "Lcom/huachenjie/im/bean/FriendUserInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemChooseFriendBinding;", "holder", "item", "", "convert", "", "f", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseFriendAdapter extends BaseRefreshAdapter<FriendUserInfo, BaseDataBindingHolder<WorksItemChooseFriendBinding>> {
    public ChooseFriendAdapter() {
        super(R.layout.works_item_choose_friend);
    }

    @Override // com.huachenjie.base.adapter.BaseRefreshAdapter
    public int f() {
        return R.layout.layout_empty_friend;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemChooseFriendBinding> holder, @NotNull FriendUserInfo item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemChooseFriendBinding worksItemChooseFriendBinding = (WorksItemChooseFriendBinding) holder.getDataBinding();
        if (worksItemChooseFriendBinding != null) {
            worksItemChooseFriendBinding.k(item);
            worksItemChooseFriendBinding.executePendingBindings();
        }
    }
}
