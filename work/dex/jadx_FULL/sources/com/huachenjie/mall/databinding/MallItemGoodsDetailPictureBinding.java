package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class MallItemGoodsDetailPictureBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10808a;

    public MallItemGoodsDetailPictureBinding(@NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView) {
        this.f35003a = frameLayout;
        this.f10808a = roundImageView;
    }

    @NonNull
    public static MallItemGoodsDetailPictureBinding a(@NonNull View view) {
        int i = R.id.iv_pic;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, i);
        if (roundImageView != null) {
            return new MallItemGoodsDetailPictureBinding((FrameLayout) view, roundImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static MallItemGoodsDetailPictureBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MallItemGoodsDetailPictureBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mall_item_goods_detail_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f35003a;
    }
}
