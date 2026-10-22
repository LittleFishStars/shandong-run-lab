package com.huachenjie.social_contact.adapter;

import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.social_contact.R;
import com.zj.adlib.tg9;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/adapter/ReceiveSysGiftAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/GiftBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "layoutResId", "", "(I)V", "convert", "", "holder", "item", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReceiveSysGiftAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveSysGiftAdapter.kt\ncom/huachenjie/social_contact/adapter/ReceiveSysGiftAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public final class ReceiveSysGiftAdapter extends BaseQuickAdapter<GiftBean, BaseViewHolder> {
    /* JADX WARN: Illegal instructions before constructor call */
    public ReceiveSysGiftAdapter(@LayoutRes int i) {
        List list = null;
        super(i, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull GiftBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView imageView = (ImageView) holder.getView(R.id.ivIcon);
        Glide.with(imageView).load(item.getGiftImg()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        if (item.getGiftType() == 1) {
            Integer numB = tg9.f44915a.b(item.getGeneType());
            if (numB != null) {
                holder.setImageResource(R.id.ivGeneType, numB.intValue());
            }
            holder.setGone(R.id.ivGeneType, false);
        } else if (item.getGiftType() == 2) {
            int iA = tg9.f44915a.a(item.getGeneType());
            int i = R.id.ivGeneType;
            holder.setImageResource(i, iA);
            holder.setGone(i, false);
        } else {
            holder.setGone(R.id.ivGeneType, true);
        }
        int giftType = item.getGiftType();
        if (giftType == 3) {
            item.setGiftName("世界水晶");
        } else if (giftType == 4) {
            item.setGiftName("闪动力");
        }
        holder.setText(R.id.tv_gift_name, item.getGiftName());
        int i2 = R.id.tv_gift_count;
        StringBuilder sb = new StringBuilder();
        sb.append('X');
        sb.append(item.getGiftCount());
        holder.setText(i2, sb.toString());
    }
}
