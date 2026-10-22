package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.social_contact.R;
import com.noober.background.view.BLFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class PopUserWearGameBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f13041a;

    @NonNull
    public final ImageView b;

    public PopUserWearGameBinding(@NonNull RelativeLayout relativeLayout, @NonNull BLFrameLayout bLFrameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RecyclerView recyclerView) {
        this.f13039a = relativeLayout;
        this.f13041a = bLFrameLayout;
        this.f36202a = imageView;
        this.b = imageView2;
        this.f13040a = recyclerView;
    }

    @NonNull
    public static PopUserWearGameBinding a(@NonNull View view) {
        int i = R.id.flContent;
        BLFrameLayout bLFrameLayoutFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLFrameLayoutFindChildViewById != null) {
            i = R.id.ivBottomArrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ivTopArrow;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        return new PopUserWearGameBinding((RelativeLayout) view, bLFrameLayoutFindChildViewById, imageView, imageView2, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static PopUserWearGameBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopUserWearGameBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pop_user_wear_game, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f13039a;
    }
}
