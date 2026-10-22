package com.huachenjie.social_contact.adapter;

import android.widget.ImageView;
import androidx.annotation.IdRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.huachenjie.social_contact.databinding.ItemWorldLetterBinding;
import com.zj.adlib.tg9;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u001e\u0010\n\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J4\u0010\u000f\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/social_contact/adapter/WorldLetterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/NoticeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/social_contact/databinding/ItemWorldLetterBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "e", "Lcom/huachenjie/base/bean/GiftBean;", "", "iconId", "geneTypeId", "f", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWorldLetterAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorldLetterAdapter.kt\ncom/huachenjie/social_contact/adapter/WorldLetterAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class WorldLetterAdapter extends BaseQuickAdapter<NoticeBean, BaseDataBindingHolder<ItemWorldLetterBinding>> implements LoadMoreModule {
    public WorldLetterAdapter() {
        super(R.layout.item_world_letter, null, 2, null);
    }

    public final void e(BaseDataBindingHolder<ItemWorldLetterBinding> holder, NoticeBean item) {
        List<GiftBean> giftList = item.getGiftList();
        if (giftList == null) {
            giftList = new ArrayList<>();
        }
        int size = giftList.size();
        if (size > 0) {
            f(holder, giftList.get(0), R.id.ivIcon1, R.id.ivGeneType1);
        } else {
            f(holder, null, R.id.ivIcon1, R.id.ivGeneType1);
        }
        if (size > 1) {
            f(holder, giftList.get(1), R.id.ivIcon2, R.id.ivGeneType2);
        } else {
            f(holder, null, R.id.ivIcon2, R.id.ivGeneType2);
        }
        if (size > 2) {
            f(holder, giftList.get(2), R.id.ivIcon3, R.id.ivGeneType3);
        } else {
            f(holder, null, R.id.ivIcon3, R.id.ivGeneType3);
        }
        if (size > 3) {
            f(holder, giftList.get(3), R.id.ivIcon4, R.id.ivGeneType4);
        } else {
            f(holder, null, R.id.ivIcon4, R.id.ivGeneType4);
        }
    }

    public final void f(BaseDataBindingHolder<ItemWorldLetterBinding> holder, GiftBean item, @IdRes int iconId, @IdRes int geneTypeId) {
        if (item == null) {
            holder.setGone(iconId, true);
            holder.setGone(geneTypeId, true);
            return;
        }
        holder.setGone(iconId, false);
        holder.setGone(geneTypeId, false);
        ImageView imageView = (ImageView) holder.getView(iconId);
        Glide.with(imageView).load(item.getGiftImg()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        if (item.getGiftType() == 1) {
            Integer numB = tg9.f44915a.b(item.getGeneType());
            if (numB != null) {
                holder.setImageResource(geneTypeId, numB.intValue());
            }
            holder.setGone(geneTypeId, false);
            return;
        }
        if (item.getGiftType() != 2) {
            holder.setGone(geneTypeId, true);
        } else {
            holder.setImageResource(geneTypeId, tg9.f44915a.a(item.getGeneType()));
            holder.setGone(geneTypeId, false);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemWorldLetterBinding> holder, @NotNull NoticeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getMessageType() == 1) {
            e(holder, item);
        }
        ItemWorldLetterBinding itemWorldLetterBinding = (ItemWorldLetterBinding) holder.getDataBinding();
        if (itemWorldLetterBinding != null) {
            itemWorldLetterBinding.k(item);
            itemWorldLetterBinding.executePendingBindings();
        }
    }
}
