package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.channel.R;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelItemManageAdminAddSubBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLImageView f33256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8009a;

    public ChannelItemManageAdminAddSubBinding(@NonNull BLRelativeLayout bLRelativeLayout, @NonNull BLImageView bLImageView) {
        this.f8009a = bLRelativeLayout;
        this.f33256a = bLImageView;
    }

    @NonNull
    public static ChannelItemManageAdminAddSubBinding a(@NonNull View view) {
        int i = R.id.iv_add;
        BLImageView bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLImageViewFindChildViewById != null) {
            return new ChannelItemManageAdminAddSubBinding((BLRelativeLayout) view, bLImageViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ChannelItemManageAdminAddSubBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelItemManageAdminAddSubBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_item_manage_admin_add_sub, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLRelativeLayout getRoot() {
        return this.f8009a;
    }
}
