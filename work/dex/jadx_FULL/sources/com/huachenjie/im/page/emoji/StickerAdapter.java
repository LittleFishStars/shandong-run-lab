package com.huachenjie.im.page.emoji;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiBean;
import com.huachenjie.im.databinding.ItemStickerBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/im/bean/EmojiBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/im/databinding/ItemStickerBinding;", "()V", "convert", "", "holder", "item", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StickerAdapter extends BaseQuickAdapter<EmojiBean, BaseDataBindingHolder<ItemStickerBinding>> {
    public StickerAdapter() {
        super(R.layout.item_sticker, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemStickerBinding> holder, @NotNull EmojiBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemStickerBinding itemStickerBinding = (ItemStickerBinding) holder.getDataBinding();
        if (itemStickerBinding != null) {
            itemStickerBinding.k(item);
            itemStickerBinding.executePendingBindings();
        }
    }
}
