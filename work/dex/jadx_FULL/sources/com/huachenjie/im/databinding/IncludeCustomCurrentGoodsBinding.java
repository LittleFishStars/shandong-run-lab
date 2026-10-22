package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.im.R;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeCustomCurrentGoodsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f9761a;

    public IncludeCustomCurrentGoodsBinding(@NonNull View view, @NonNull BLImageView bLImageView, @NonNull TextView textView) {
        this.f34446a = view;
        this.f9761a = bLImageView;
        this.f9760a = textView;
    }

    @NonNull
    public static IncludeCustomCurrentGoodsBinding a(@NonNull View view) {
        int i = R.id.iv_current_goods;
        BLImageView bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLImageViewFindChildViewById != null) {
            i = R.id.tv_current_goods_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new IncludeCustomCurrentGoodsBinding(view, bLImageViewFindChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static IncludeCustomCurrentGoodsBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.include_custom_current_goods, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f34446a;
    }
}
