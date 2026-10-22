package com.huachenjie.social_contact.page.suit;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.IPBean;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.cr2;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearIPAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/IPBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "e", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUserWearIPAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserWearIPAdapter.kt\ncom/huachenjie/social_contact/page/suit/UserWearIPAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class UserWearIPAdapter extends BaseQuickAdapter<IPBean, BaseViewHolder> {
    public UserWearIPAdapter() {
        super(R.layout.item_user_wear_ip, null, 2, null);
    }

    public final void e(@NotNull IPBean item) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((IPBean) next).getCheckedFlag());
        IPBean iPBean = (IPBean) next;
        if (iPBean != null) {
            iPBean.setCheckedFlag(false);
            notifyItemChanged(getData().indexOf(iPBean));
        }
        item.setCheckedFlag(true);
        item.setHaveFlag(true);
        if (item.getNewFlag()) {
            item.setNewFlag(false);
        }
        notifyItemChanged(getData().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull IPBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        BLConstraintLayout view = holder.getView(R.id.clRoot);
        DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 20.0f));
        ImageView imageView = (ImageView) holder.getView(R.id.ivIcon);
        Glide.with(imageView).load(item.getImg()).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).transforms(new RoundedCorners(SizeUtils.b(13.0f)))).into(imageView);
        DrawableCreator.Builder strokeColor = null;
        if (item.getHaveFlag()) {
            if (item.getCheckedFlag()) {
                cornersRadius.setSolidColor(-1184275);
                strokeColor = new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 13.0f)).setStrokeWidth(cr2.c(getContext(), 2.0f)).setStrokeColor(-35281);
                int i = R.id.tvWear;
                holder.setText(i, "已穿戴");
                holder.setGone(i, false);
            } else {
                cornersRadius.setSolidColor(-1).setStrokeWidth(cr2.c(getContext(), 1.0f)).setStrokeColor(-1118482);
                holder.setGone(R.id.tvWear, true);
            }
            holder.setTextColor(R.id.tvName, -13877680);
            holder.setGone(R.id.tvUnlockBySuperBox, true);
        } else {
            cornersRadius.setSolidColor(-14803923);
            holder.setTextColor(R.id.tvName, -1);
            int i2 = R.id.tvWear;
            holder.setText(i2, "试穿");
            holder.setGone(i2, false);
            int i3 = R.id.tvUnlockBySuperBox;
            holder.setGone(i3, false);
            int freeFlag = item.getFreeFlag();
            if (freeFlag == 1) {
                holder.setText(i3, "免费");
            } else if (freeFlag != 3) {
                holder.setText(i3, "");
            } else {
                holder.setText(i3, item.getComponentSellingRemak());
            }
        }
        view.setBackground(cornersRadius.build());
        imageView.setBackground(strokeColor != null ? strokeColor.build() : new ColorDrawable(0));
        holder.setText(R.id.tvName, item.getIpName());
        holder.setText(R.id.tvDesc, item.getIpDescription());
        holder.setGone(R.id.tag_new, !item.getNewFlag());
    }
}
