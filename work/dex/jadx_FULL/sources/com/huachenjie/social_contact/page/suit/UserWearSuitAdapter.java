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
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.SuitBean;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/SuitBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", y6b.f, y6b.g, "f", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUserWearSuitAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserWearSuitAdapter.kt\ncom/huachenjie/social_contact/page/suit/UserWearSuitAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1#2:122\n*E\n"})
public final class UserWearSuitAdapter extends BaseQuickAdapter<SuitBean, BaseViewHolder> {
    public UserWearSuitAdapter() {
        super(R.layout.item_user_wear_suit, null, 2, null);
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
        } while (!((SuitBean) next).getCheckedFlag());
        SuitBean suitBean = (SuitBean) next;
        if (suitBean != null) {
            suitBean.setCheckedFlag(false);
            notifyItemChanged(getData().indexOf(suitBean));
        }
    }

    public final void g(@NotNull SuitBean item) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((SuitBean) next).getCheckedFlag());
        SuitBean suitBean = (SuitBean) next;
        if (suitBean != null) {
            suitBean.setCheckedFlag(false);
            notifyItemChanged(getData().indexOf(suitBean));
        }
        item.setCheckedFlag(true);
        item.setHaveFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    public final void h(@NotNull SuitBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.setHaveFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull SuitBean item) {
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
            holder.setGone(R.id.llUnlock, true);
        } else {
            cornersRadius.setSolidColor(-14803923);
            holder.setTextColor(R.id.tvName, -1);
            int i2 = R.id.tvWear;
            holder.setText(i2, "试穿");
            holder.setGone(i2, false);
            int i3 = R.id.tvUnlockBySuperBox;
            holder.setGone(i3, true);
            int i4 = R.id.llUnlock;
            holder.setGone(i4, false);
            int freeFlag = item.getFreeFlag();
            if (freeFlag == 1) {
                holder.setGone(R.id.iv_star_drill, true);
                holder.setGone(R.id.iv_crystal, true);
                holder.setGone(R.id.iv_skin_coupon, true);
                holder.setGone(R.id.tv_star_drill, true);
                holder.setGone(R.id.tv_crystal, true);
                holder.setGone(R.id.tv_skin_coupon, true);
                holder.setText(R.id.tvUnlock, "免费");
            } else if (freeFlag != 3) {
                holder.setGone(R.id.iv_star_drill, item.getStarDrill() <= 0);
                holder.setGone(R.id.iv_crystal, item.getCrystalValue() <= 0);
                holder.setGone(R.id.iv_skin_coupon, item.getSkinVoucher() <= 0);
                int i5 = R.id.tv_star_drill;
                holder.setGone(i5, item.getStarDrill() <= 0);
                int i6 = R.id.tv_crystal;
                holder.setGone(i6, item.getCrystalValue() <= 0);
                int i7 = R.id.tv_skin_coupon;
                holder.setGone(i7, item.getSkinVoucher() <= 0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.getStarDrill())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                holder.setText(i5, str);
                String str2 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.getCrystalValue())}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                holder.setText(i6, str2);
                String str3 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.getSkinVoucher())}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                holder.setText(i7, str3);
                holder.setText(R.id.tvUnlock, "解锁");
            } else {
                holder.setGone(i4, true);
                holder.setGone(i3, false);
                holder.setText(i3, item.getSellingRemak());
            }
        }
        view.setBackground(cornersRadius.build());
        imageView.setBackground(strokeColor != null ? strokeColor.build() : new ColorDrawable(0));
        holder.setText(R.id.tvName, item.getPartName());
        holder.setText(R.id.tvDesc, item.getPartDescription());
    }
}
