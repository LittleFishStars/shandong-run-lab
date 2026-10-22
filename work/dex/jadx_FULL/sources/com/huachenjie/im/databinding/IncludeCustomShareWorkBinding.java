package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeCustomShareWorkBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f9782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9784a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9785b;

    @NonNull
    public final TextView c;

    public IncludeCustomShareWorkBinding(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull BLTextView bLTextView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull AvatarView avatarView, @NonNull RoundImageView roundImageView) {
        this.f34454a = view;
        this.f9779a = frameLayout;
        this.f9780a = imageView;
        this.b = imageView2;
        this.f9781a = textView;
        this.f9784a = bLTextView;
        this.f9785b = textView2;
        this.c = textView3;
        this.f9783a = avatarView;
        this.f9782a = roundImageView;
    }

    @NonNull
    public static IncludeCustomShareWorkBinding a(@NonNull View view) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.flLevel;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.ivHot;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ivVideoIcon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.tvHot;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.tvLevel))) != null) {
                        i = R.id.tvNickname;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tvTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.workAvatar;
                                AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
                                if (avatarView != null) {
                                    i = R.id.workImage;
                                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, i);
                                    if (roundImageView != null) {
                                        return new IncludeCustomShareWorkBinding(view, frameLayout, imageView, imageView2, textView, bLTextViewFindChildViewById, textView2, textView3, avatarView, roundImageView);
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
    public static IncludeCustomShareWorkBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.include_custom_share_work, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f34454a;
    }
}
