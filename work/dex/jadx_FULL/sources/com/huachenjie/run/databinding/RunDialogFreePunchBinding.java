package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogFreePunchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11715a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11716b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11717b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunDialogFreePunchBinding(@NonNull BLConstraintLayout rootView, @NonNull BLTextView btnGet, @NonNull ImageView ivClose, @NonNull ImageView ivHeader, @NonNull TextView tvDesc, @NonNull TextView tvNum, @NonNull TextView tvTipContent, @NonNull TextView tvTipTitle, @NonNull BLTextView tvUse) {
        this.f11714a = rootView;
        this.f11715a = btnGet;
        this.f35534a = ivClose;
        this.b = ivHeader;
        this.f11713a = tvDesc;
        this.f11716b = tvNum;
        this.c = tvTipContent;
        this.d = tvTipTitle;
        this.f11717b = tvUse;
    }

    @NonNull
    public static RunDialogFreePunchBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.btnGet;
        BLTextView bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, i);
        if (bLTextViewFindChildViewById2 != null) {
            i = R.id.ivClose;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.ivHeader;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.tvDesc;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tvNum;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tvTipContent;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tvTipTitle;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvUse))) != null) {
                                    return new RunDialogFreePunchBinding((BLConstraintLayout) rootView, bLTextViewFindChildViewById2, imageView, imageView2, textView, textView2, textView3, textView4, bLTextViewFindChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogFreePunchBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogFreePunchBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_free_punch, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f11714a;
    }
}
