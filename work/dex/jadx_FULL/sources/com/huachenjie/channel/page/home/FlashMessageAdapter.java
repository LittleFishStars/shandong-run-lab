package com.huachenjie.channel.page.home;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;
import com.huachenjie.channel.bean.FlashMessageItem;
import com.huachenjie.channel.bean.FlashMessageSingleChatItem;
import com.zj.adlib.tk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/home/FlashMessageAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/channel/bean/FlashMessageItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlashMessageAdapter extends BaseMultiItemQuickAdapter<FlashMessageItem, BaseDataBindingHolder<ViewDataBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public FlashMessageAdapter() {
        List list = null;
        super(list, 1, list);
        addItemType(1, R.layout.channel_item_flash_message);
        addItemType(2, R.layout.channel_item_flash_message_single_chat);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull FlashMessageItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (item instanceof FlashMessageBuddyChatBean) {
                dataBinding.setVariable(tk0.g, item);
            } else if (item instanceof FlashMessageSingleChatItem) {
                dataBinding.setVariable(tk0.o, ((FlashMessageSingleChatItem) item).getContact());
            }
            dataBinding.executePendingBindings();
        }
    }
}
