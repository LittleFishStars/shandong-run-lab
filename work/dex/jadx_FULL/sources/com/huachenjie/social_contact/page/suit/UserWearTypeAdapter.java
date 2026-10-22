package com.huachenjie.social_contact.page.suit;

import android.widget.CheckBox;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.ModelListBean;
import com.zj.adlib.ju3;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearTypeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/ModelListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "position", y6b.f, "K", "I", "f", "()I", y6b.g, "(I)V", "selectedPosition", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearTypeAdapter extends BaseQuickAdapter<ModelListBean, BaseViewHolder> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selectedPosition;

    public UserWearTypeAdapter() {
        super(R.layout.item_user_wear_type, null, 2, null);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void g(int position) {
        int i = this.selectedPosition;
        if (i == position) {
            return;
        }
        this.selectedPosition = position;
        notifyItemChanged(i);
        notifyItemChanged(this.selectedPosition);
    }

    public final void h(int i) {
        this.selectedPosition = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull ModelListBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int iIndexOf = getData().indexOf(item);
        ImageView imageView = (ImageView) holder.getView(R.id.iv_model_icon);
        Glide.with(imageView).load(item.getModelImg()).apply((BaseRequestOptions<?>) ju3.d).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        int i = R.id.cb_model_name;
        holder.setText(i, item.getModelName());
        int i2 = iIndexOf % 4;
        if (i2 == 0) {
            ((CheckBox) holder.getView(i)).setTextColor(getContext().getResources().getColorStateList(R.color.color_selector_wear_girl));
            holder.setBackgroundResource(R.id.cb_model_selected, R.drawable.bg_selector_wear_girl);
        } else if (i2 == 1) {
            ((CheckBox) holder.getView(i)).setTextColor(getContext().getResources().getColorStateList(R.color.color_selector_wear_boy));
            holder.setBackgroundResource(R.id.cb_model_selected, R.drawable.bg_selector_wear_boy);
        } else if (i2 == 2) {
            ((CheckBox) holder.getView(i)).setTextColor(getContext().getResources().getColorStateList(R.color.color_selector_wear_ip));
            holder.setBackgroundResource(R.id.cb_model_selected, R.drawable.bg_selector_wear_ip);
        } else if (i2 == 3) {
            ((CheckBox) holder.getView(i)).setTextColor(getContext().getResources().getColorStateList(R.color.color_selector_wear_game));
            holder.setBackgroundResource(R.id.cb_model_selected, R.drawable.bg_selector_wear_game);
        }
        ((CheckBox) holder.getView(i)).setChecked(this.selectedPosition == iIndexOf);
        ((CheckBox) holder.getView(R.id.cb_model_selected)).setChecked(this.selectedPosition == iIndexOf);
    }
}
