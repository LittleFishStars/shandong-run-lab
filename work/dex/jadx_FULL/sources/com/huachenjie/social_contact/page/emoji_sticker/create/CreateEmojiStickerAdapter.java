package com.huachenjie.social_contact.page.emoji_sticker.create;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerAddBean;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerAddBinding;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerCreateBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0012\u0004\u0012\u0002H\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u00032\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J%\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerAdapter;", "Q", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;Lcom/chad/library/adapter/base/entity/MultiItemEntity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CreateEmojiStickerAdapter<Q extends MultiItemEntity> extends BaseMultiItemQuickAdapter<Q, BaseDataBindingHolder<? extends ViewDataBinding>> implements LoadMoreModule {
    public CreateEmojiStickerAdapter() {
        super(null, 1, null);
        addItemType(3, R.layout.item_emoji_sticker_add);
        addItemType(2, R.layout.item_emoji_sticker_create);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull Q item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        int postType = item.getPostType();
        if (postType == 2) {
            ((ItemEmojiStickerCreateBinding) dataBinding).k((EmojiStickerImageBean) item);
        } else if (postType == 3) {
            ((ItemEmojiStickerAddBinding) dataBinding).k((EmojiStickerAddBean) item);
        }
        dataBinding.executePendingBindings();
    }
}
