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
import com.huachenjie.social_contact.bean.AttributeBean;
import com.huachenjie.social_contact.bean.GameBean;
import com.ipd.dsp.internal.i.q;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.cr2;
import com.zj.adlib.tg9;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGameAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/GameBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "e", "f", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUserWearGameAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserWearGameAdapter.kt\ncom/huachenjie/social_contact/page/suit/UserWearGameAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
public final class UserWearGameAdapter extends BaseQuickAdapter<GameBean, BaseViewHolder> {
    public UserWearGameAdapter() {
        super(R.layout.item_user_wear_game, null, 2, null);
    }

    public final void e(@NotNull GameBean item) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((GameBean) next).getWearFlag());
        GameBean gameBean = (GameBean) next;
        if (gameBean != null) {
            gameBean.setWearFlag(false);
            notifyItemChanged(getData().indexOf(gameBean));
        }
        item.setWearFlag(true);
        item.setUnlockFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    public final void f(@NotNull GameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.setUnlockFlag(true);
        notifyItemChanged(getData().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull GameBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        BLConstraintLayout view = holder.getView(R.id.clRoot);
        DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 20.0f));
        ImageView imageView = (ImageView) holder.getView(R.id.ivIcon);
        Glide.with(imageView).load(item.getImgUrl()).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).transforms(new RoundedCorners(SizeUtils.b(13.0f)))).into(imageView);
        DrawableCreator.Builder strokeColor = null;
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
            holder.setGone(R.id.tvUnlockBySuperBox, true);
            holder.setGone(R.id.llUnlock, true);
            holder.setTextColor(R.id.tvAttribute, -10155284);
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
            holder.setTextColor(R.id.tvAttribute, -4814081);
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
                holder.setGone(R.id.iv_star_drill, item.starDrill() <= 0);
                holder.setGone(R.id.iv_crystal, item.crystalValue() <= 0);
                holder.setGone(R.id.iv_skin_coupon, item.skinVoucher() <= 0);
                int i5 = R.id.tv_star_drill;
                holder.setGone(i5, item.starDrill() <= 0);
                int i6 = R.id.tv_crystal;
                holder.setGone(i6, item.crystalValue() <= 0);
                int i7 = R.id.tv_skin_coupon;
                holder.setGone(i7, item.skinVoucher() <= 0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                CharSequence charSequence = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.starDrill())}, 1));
                Intrinsics.checkNotNullExpressionValue(charSequence, "format(format, *args)");
                holder.setText(i5, charSequence);
                CharSequence charSequence2 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.crystalValue())}, 1));
                Intrinsics.checkNotNullExpressionValue(charSequence2, "format(format, *args)");
                holder.setText(i6, charSequence2);
                CharSequence charSequence3 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(item.skinVoucher())}, 1));
                Intrinsics.checkNotNullExpressionValue(charSequence3, "format(format, *args)");
                holder.setText(i7, charSequence3);
                holder.setText(R.id.tvUnlock, "解锁");
            } else {
                holder.setGone(i4, true);
                holder.setGone(i3, false);
                holder.setText(i3, item.getUnlockRemark());
            }
        }
        view.setBackground(cornersRadius.build());
        imageView.setBackground(strokeColor != null ? strokeColor.build() : new ColorDrawable(0));
        holder.setText(R.id.tvName, item.getName());
        holder.setText(R.id.tvDesc, item.getDescription());
        List<AttributeBean> attributeList = item.getAttributeList();
        int size = attributeList != null ? attributeList.size() : 0;
        int i8 = R.id.tvAttribute;
        holder.setVisible(i8, size > 0);
        holder.setGone(R.id.ivAttributeInfo, size <= 2);
        String string = "";
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            tg9 tg9Var = tg9.f44915a;
            List<AttributeBean> attributeList2 = item.getAttributeList();
            Intrinsics.checkNotNull(attributeList2);
            sb.append(tg9Var.c(attributeList2.get(0).getAttributeCode()));
            sb.append(" ＋");
            sb.append(tg9Var.d(item.getAttributeList().get(0).getAttributeCode(), item.getAttributeList().get(0).getAttributeValue()));
            string = sb.toString();
        }
        if (size > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(q.a.i);
            tg9 tg9Var2 = tg9.f44915a;
            List<AttributeBean> attributeList3 = item.getAttributeList();
            Intrinsics.checkNotNull(attributeList3);
            sb2.append(tg9Var2.c(attributeList3.get(1).getAttributeCode()));
            sb2.append(" ＋");
            sb2.append(tg9Var2.d(item.getAttributeList().get(1).getAttributeCode(), item.getAttributeList().get(1).getAttributeValue()));
            string = sb2.toString();
        }
        if (size > 2) {
            string = string + (char) 8230;
        }
        holder.setText(i8, string);
    }
}
