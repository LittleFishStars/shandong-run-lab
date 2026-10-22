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
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DialogShareBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f7038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7039a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public DialogShareBinding(@NonNull BLConstraintLayout rootView, @NonNull ImageView ivSaveToFriend, @NonNull ImageView ivShareToMoments, @NonNull ImageView ivShareToQq, @NonNull ImageView ivShareToSina, @NonNull ImageView ivShareToWechat, @NonNull BLTextView tvCancel, @NonNull TextView tvSaveToFriend) {
        this.f7038a = rootView;
        this.f32833a = ivSaveToFriend;
        this.b = ivShareToMoments;
        this.c = ivShareToQq;
        this.d = ivShareToSina;
        this.e = ivShareToWechat;
        this.f7039a = tvCancel;
        this.f7037a = tvSaveToFriend;
    }

    @NonNull
    public static DialogShareBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.iv_save_to_friend;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.iv_share_to_moments;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.iv_share_to_qq;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.iv_share_to_sina;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        i = R.id.iv_share_to_wechat;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView5 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_cancel))) != null) {
                            i = R.id.tv_save_to_friend;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                return new DialogShareBinding((BLConstraintLayout) rootView, imageView, imageView2, imageView3, imageView4, imageView5, bLTextViewFindChildViewById, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogShareBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogShareBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_share, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f7038a;
    }
}
