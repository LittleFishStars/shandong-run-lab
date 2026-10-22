package com.huachenjie.mine.page.dressing_table.avatar_frame;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.bean.UnlockMode;
import com.huachenjie.mine.R;
import com.huachenjie.mine.bean.AvatarFrameBean;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0015J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mine/bean/AvatarFrameBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", y6b.g, y6b.f, "f", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAvatarFrameAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AvatarFrameAdapter.kt\ncom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public final class AvatarFrameAdapter extends BaseQuickAdapter<AvatarFrameBean, BaseViewHolder> {
    public AvatarFrameAdapter() {
        super(R.layout.mine_item_avatar_frame, null, 2, null);
    }

    public final void f() {
        Object next;
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((AvatarFrameBean) next).getWearFlag());
        AvatarFrameBean avatarFrameBean = (AvatarFrameBean) next;
        if (avatarFrameBean != null) {
            avatarFrameBean.setWearFlag(false);
            notifyItemChanged(getData().indexOf(avatarFrameBean));
        }
    }

    public final void g(@NotNull AvatarFrameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.setUnlockFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    public final void h(@NotNull AvatarFrameBean item) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((AvatarFrameBean) next).getWearFlag());
        AvatarFrameBean avatarFrameBean = (AvatarFrameBean) next;
        if (avatarFrameBean != null) {
            avatarFrameBean.setWearFlag(false);
            notifyItemChanged(getData().indexOf(avatarFrameBean));
        }
        item.setWearFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"CheckResult"})
    public void convert(@NotNull BaseViewHolder holder, @NotNull AvatarFrameBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        BLConstraintLayout view = holder.getView(R.id.clRoot);
        DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 20.0f));
        ImageView imageView = (ImageView) holder.getView(R.id.ivIcon);
        RequestManager requestManagerWith = Glide.with(imageView);
        Intrinsics.checkNotNullExpressionValue(requestManagerWith, "with(ivIcon)");
        RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load(item.getAvatarFrameImgUrl());
        Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "requestManager.load(item.avatarFrameImgUrl)");
        DrawableCreator.Builder strokeColor = null;
        if (StringsKt.endsWith$default(item.getAvatarFrameImgUrl(), ".webp", false, 2, (Object) null)) {
            requestBuilderLoad.optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new FitCenter()));
        } else {
            requestBuilderLoad.transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(13.0f)));
        }
        requestBuilderLoad.into(imageView);
        if (item.getUnlockFlag()) {
            if (item.getWearFlag()) {
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
            holder.setGone(R.id.iv_unlock_Mode, true);
            holder.setGone(R.id.tvUnlock, true);
        } else {
            cornersRadius.setSolidColor(-14803923);
            holder.setTextColor(R.id.tvName, -1);
            holder.setGone(R.id.tvWear, true);
            int freeFlag = item.getFreeFlag();
            if (freeFlag == 0) {
                int i2 = R.id.iv_unlock_Mode;
                holder.setGone(i2, false);
                int i3 = R.id.tvUnlock;
                holder.setGone(i3, false);
                if (item.getUnlockingModeDOS() != null) {
                    UnlockMode unlockingModeDOS = item.getUnlockingModeDOS();
                    Intrinsics.checkNotNull(unlockingModeDOS);
                    int type = unlockingModeDOS.getType();
                    UnlockMode unlockingModeDOS2 = item.getUnlockingModeDOS();
                    Intrinsics.checkNotNull(unlockingModeDOS2);
                    int value = unlockingModeDOS2.getValue();
                    int i4 = R.drawable.ic_coin_small;
                    if (type != 1) {
                        if (type == 2) {
                            i4 = R.drawable.ic_star_drill_small;
                        } else if (type == 3) {
                            i4 = R.drawable.ic_skin_coupon_small;
                        }
                    }
                    holder.setImageResource(i2, i4);
                    holder.setText(i3, value + "解锁");
                } else {
                    holder.setGone(i2, true);
                    holder.setGone(i3, true);
                }
            } else if (freeFlag == 1) {
                holder.setGone(R.id.iv_unlock_Mode, true);
                int i5 = R.id.tvUnlock;
                holder.setGone(i5, false);
                holder.setText(i5, "免费");
            } else if (freeFlag == 2) {
                holder.setGone(R.id.iv_unlock_Mode, true);
                int i6 = R.id.tvUnlock;
                holder.setGone(i6, false);
                holder.setText(i6, item.getSellingRemak());
            }
        }
        view.setBackground(cornersRadius.build());
        imageView.setBackground(strokeColor != null ? strokeColor.build() : new ColorDrawable(0));
        holder.setText(R.id.tvName, item.getFrameName());
        holder.setText(R.id.tvDesc, item.getFrameDescription());
    }
}
