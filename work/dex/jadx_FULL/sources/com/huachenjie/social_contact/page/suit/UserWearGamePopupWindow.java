package com.huachenjie.social_contact.page.suit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.AttributeBean;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.tg9;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0003R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow;", "Landroid/widget/PopupWindow;", "Landroid/view/View;", "tagView", "", "Lcom/huachenjie/social_contact/bean/AttributeBean;", "attributeList", "", "b", "Landroid/content/Context;", "context", "a", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mIvTopArrow", "mIvBottomArrow", "Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow$UserWearGamePopupWindowAdapter;", "Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow$UserWearGamePopupWindowAdapter;", "mAdapter", "<init>", "(Landroid/content/Context;)V", "UserWearGamePopupWindowAdapter", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearGamePopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ImageView mIvTopArrow;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public UserWearGamePopupWindowAdapter mAdapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public ImageView mIvBottomArrow;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow$UserWearGamePopupWindowAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/AttributeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UserWearGamePopupWindowAdapter extends BaseQuickAdapter<AttributeBean, BaseViewHolder> {
        public UserWearGamePopupWindowAdapter() {
            super(R.layout.item_user_wear_game_pop, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(@NotNull BaseViewHolder holder, @NotNull AttributeBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            int i = R.id.tvName;
            tg9 tg9Var = tg9.f44915a;
            holder.setText(i, tg9Var.c(item.getAttributeCode()));
            holder.setText(R.id.tvNum, tg9Var.d(item.getAttributeCode(), item.getAttributeValue()));
            holder.setGone(R.id.ivHeart, item.getAttributeCode() != 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserWearGamePopupWindow(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    @SuppressLint({"InflateParams"})
    public final void a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.pop_user_wear_game, (ViewGroup) null);
        setContentView(viewInflate);
        this.mIvTopArrow = (ImageView) viewInflate.findViewById(R.id.ivTopArrow);
        this.mIvBottomArrow = (ImageView) viewInflate.findViewById(R.id.ivBottomArrow);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        UserWearGamePopupWindowAdapter userWearGamePopupWindowAdapter = new UserWearGamePopupWindowAdapter();
        this.mAdapter = userWearGamePopupWindowAdapter;
        recyclerView.setAdapter(userWearGamePopupWindowAdapter);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(jj8.a(280.0f));
        setHeight(-2);
        setOutsideTouchable(true);
        setTouchable(true);
    }

    public final void b(@NotNull View tagView, @NotNull List<AttributeBean> attributeList) {
        int iA;
        Intrinsics.checkNotNullParameter(tagView, "tagView");
        Intrinsics.checkNotNullParameter(attributeList, "attributeList");
        if (isShowing()) {
            return;
        }
        UserWearGamePopupWindowAdapter userWearGamePopupWindowAdapter = this.mAdapter;
        if (userWearGamePopupWindowAdapter != null) {
            userWearGamePopupWindowAdapter.setList(attributeList);
        }
        int height = tagView.getHeight();
        int[] iArr = new int[2];
        tagView.getLocationInWindow(iArr);
        int iC = (fx7.c() - iArr[1]) - height;
        getContentView().measure(0, 0);
        int measuredHeight = getContentView().getMeasuredHeight();
        if (iC >= measuredHeight) {
            ImageView imageView = this.mIvTopArrow;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mIvBottomArrow;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            iA = jj8.a(5.0f);
        } else {
            ImageView imageView3 = this.mIvTopArrow;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mIvBottomArrow;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            iA = -(height + measuredHeight + jj8.a(5.0f));
        }
        showAsDropDown(tagView, -jj8.a(228.0f), iA);
    }
}
