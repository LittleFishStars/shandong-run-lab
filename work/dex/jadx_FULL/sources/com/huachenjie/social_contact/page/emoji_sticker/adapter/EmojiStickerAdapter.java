package com.huachenjie.social_contact.page.emoji_sticker.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.bean.EmojiStickerTitleBean;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerBinding;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerTitleBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u00032\u00020\u0006B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\n\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/adapter/EmojiStickerAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Q", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;Lcom/chad/library/adapter/base/entity/MultiItemEntity;)V", y6b.g, y6b.f, "Landroid/view/View;", "f", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEmojiStickerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmojiStickerAdapter.kt\ncom/huachenjie/social_contact/page/emoji_sticker/adapter/EmojiStickerAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n1#2:83\n*E\n"})
public final class EmojiStickerAdapter<Q extends MultiItemEntity> extends BaseMultiItemQuickAdapter<Q, BaseDataBindingHolder<? extends ViewDataBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public EmojiStickerAdapter() {
        super(null, 1, null);
        addItemType(1, R.layout.item_emoji_sticker_title);
        addItemType(2, R.layout.item_emoji_sticker);
    }

    public final View f() {
        if (this.mEmptyView == null) {
            this.mEmptyView = LayoutInflater.from(getContext()).inflate(R.layout.layout_emiji_sticker_empty, (ViewGroup) null);
        }
        return this.mEmptyView;
    }

    public final void g() {
        removeEmptyView();
    }

    public final void h() {
        View viewF;
        if (hasEmptyView() || (viewF = f()) == null) {
            return;
        }
        setEmptyView(viewF);
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
        if (postType == 1) {
            ItemEmojiStickerTitleBinding itemEmojiStickerTitleBinding = (ItemEmojiStickerTitleBinding) dataBinding;
            EmojiStickerTitleBean emojiStickerTitleBean = (EmojiStickerTitleBean) item;
            emojiStickerTitleBean.setPaddingTop(TextUtils.equals(emojiStickerTitleBean.getItemTitle(), "人气表情包住户") ? 0 : 8);
            itemEmojiStickerTitleBinding.k(emojiStickerTitleBean);
        } else if (postType == 2) {
            ((ItemEmojiStickerBinding) dataBinding).k((EmojiStickerBean) item);
        }
        dataBinding.executePendingBindings();
    }
}
