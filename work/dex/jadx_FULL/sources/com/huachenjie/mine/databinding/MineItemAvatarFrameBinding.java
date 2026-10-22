package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.mine.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class MineItemAvatarFrameBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f11321a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11322b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public MineItemAvatarFrameBinding(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull BLConstraintLayout bLConstraintLayout2, @NonNull BLImageView bLImageView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11320a = bLConstraintLayout;
        this.f11322b = bLConstraintLayout2;
        this.f11321a = bLImageView;
        this.f35344a = imageView;
        this.f11319a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    @NonNull
    public static MineItemAvatarFrameBinding a(@NonNull View view) {
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) view;
        int i = R.id.ivIcon;
        BLImageView bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLImageViewFindChildViewById != null) {
            i = R.id.iv_unlock_Mode;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tvDesc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvUnlock;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tvWear;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new MineItemAvatarFrameBinding(bLConstraintLayout, bLConstraintLayout, bLImageViewFindChildViewById, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static MineItemAvatarFrameBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MineItemAvatarFrameBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mine_item_avatar_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f11320a;
    }
}
