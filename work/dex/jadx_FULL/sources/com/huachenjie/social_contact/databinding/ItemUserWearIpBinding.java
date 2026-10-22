package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.social_contact.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class ItemUserWearIpBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f13007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13008a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13009b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ItemUserWearIpBinding(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull BLConstraintLayout bLConstraintLayout2, @NonNull BLImageView bLImageView, @NonNull BLTextView bLTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f13006a = bLConstraintLayout;
        this.f13009b = bLConstraintLayout2;
        this.f13007a = bLImageView;
        this.f13008a = bLTextView;
        this.f36195a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    @NonNull
    public static ItemUserWearIpBinding a(@NonNull View view) {
        BLTextView bLTextViewFindChildViewById;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) view;
        int i = R.id.ivIcon;
        BLImageView bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLImageViewFindChildViewById != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.tag_new))) != null) {
            i = R.id.tvDesc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tvUnlockBySuperBox;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tvWear;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            return new ItemUserWearIpBinding(bLConstraintLayout, bLConstraintLayout, bLImageViewFindChildViewById, bLTextViewFindChildViewById, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemUserWearIpBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemUserWearIpBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_user_wear_ip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f13006a;
    }
}
