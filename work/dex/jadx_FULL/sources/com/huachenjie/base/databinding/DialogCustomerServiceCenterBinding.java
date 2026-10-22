package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DialogCustomerServiceCenterBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f6991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f6992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f6993a;

    @NonNull
    public final BLLinearLayout b;

    public DialogCustomerServiceCenterBinding(@NonNull BLConstraintLayout rootView, @NonNull ImageView ivClose, @NonNull BLLinearLayout llBoy, @NonNull BLLinearLayout llGirl, @NonNull TextView tvTitle) {
        this.f6992a = rootView;
        this.f32815a = ivClose;
        this.f6993a = llBoy;
        this.b = llGirl;
        this.f6991a = tvTitle;
    }

    @NonNull
    public static DialogCustomerServiceCenterBinding a(@NonNull View rootView) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        BLLinearLayout bLLinearLayoutFindChildViewById2;
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.ll_boy))) != null && (bLLinearLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.ll_girl))) != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new DialogCustomerServiceCenterBinding((BLConstraintLayout) rootView, imageView, bLLinearLayoutFindChildViewById, bLLinearLayoutFindChildViewById2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogCustomerServiceCenterBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogCustomerServiceCenterBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_customer_service_center, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f6992a;
    }
}
