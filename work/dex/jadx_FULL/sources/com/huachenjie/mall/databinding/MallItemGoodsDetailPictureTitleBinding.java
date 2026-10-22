package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.mall.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class MallItemGoodsDetailPictureTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLTextView f35004a;

    public MallItemGoodsDetailPictureTitleBinding(@NonNull BLTextView bLTextView) {
        this.f35004a = bLTextView;
    }

    @NonNull
    public static MallItemGoodsDetailPictureTitleBinding a(@NonNull View view) {
        if (view != null) {
            return new MallItemGoodsDetailPictureTitleBinding((BLTextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MallItemGoodsDetailPictureTitleBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MallItemGoodsDetailPictureTitleBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mall_item_goods_detail_picture_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLTextView getRoot() {
        return this.f35004a;
    }
}
