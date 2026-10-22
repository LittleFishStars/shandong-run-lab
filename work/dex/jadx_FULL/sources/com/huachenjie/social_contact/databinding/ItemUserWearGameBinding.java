package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.social_contact.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class ItemUserWearGameBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f12999a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13000b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13001b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13002c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13003d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public ItemUserWearGameBinding(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull BLConstraintLayout bLConstraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull BLImageView bLImageView, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9) {
        this.f12998a = bLConstraintLayout;
        this.f13001b = bLConstraintLayout2;
        this.f36193a = imageView;
        this.b = imageView2;
        this.f12999a = bLImageView;
        this.c = imageView3;
        this.d = imageView4;
        this.f12996a = linearLayout;
        this.f12997a = textView;
        this.f13000b = textView2;
        this.f13002c = textView3;
        this.f13003d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
    }

    @NonNull
    public static ItemUserWearGameBinding a(@NonNull View view) {
        BLImageView bLImageViewFindChildViewById;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) view;
        int i = R.id.ivAttributeInfo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_crystal;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.ivIcon))) != null) {
                i = R.id.iv_skin_coupon;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_star_drill;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.llUnlock;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.tvAttribute;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_crystal;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tvDesc;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tvName;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_skin_coupon;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.tv_star_drill;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.tvUnlock;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.tvUnlockBySuperBox;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.tvWear;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                return new ItemUserWearGameBinding(bLConstraintLayout, bLConstraintLayout, imageView, imageView2, bLImageViewFindChildViewById, imageView3, imageView4, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemUserWearGameBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemUserWearGameBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_user_wear_game, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f12998a;
    }
}
