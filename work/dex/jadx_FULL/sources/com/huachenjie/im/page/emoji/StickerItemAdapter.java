package com.huachenjie.im.page.emoji;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiItemData;
import com.huachenjie.im.databinding.ItemStickerIconBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/im/bean/EmojiItemData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/im/databinding/ItemStickerIconBinding;", "holder", "item", "", "convert", "", "position", "e", "K", "I", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class StickerItemAdapter extends BaseQuickAdapter<EmojiItemData, BaseDataBindingHolder<ItemStickerIconBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int position;

    public StickerItemAdapter() {
        super(R.layout.item_sticker_icon, null, 2, null);
    }

    public final void e(int position) {
        int i = this.position;
        if (i == position) {
            return;
        }
        this.position = position;
        notifyItemChanged(i);
        notifyItemChanged(position);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemStickerIconBinding> holder, @NotNull EmojiItemData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemStickerIconBinding itemStickerIconBinding = (ItemStickerIconBinding) holder.getDataBinding();
        if (itemStickerIconBinding != null) {
            item.setSelected(this.position == getData().indexOf(item));
            itemStickerIconBinding.k(item);
            itemStickerIconBinding.executePendingBindings();
        }
    }
}
