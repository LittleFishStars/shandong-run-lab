package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutSunshineRunGuideBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12246a;

    @NonNull
    public final BLLinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12247b;

    public RunLayoutSunshineRunGuideBinding(@NonNull View rootView, @NonNull BLTextView btnNext, @NonNull FrameLayout cardGroup, @NonNull BLLinearLayout contentCard, @NonNull BLLinearLayout headerCard, @NonNull ImageView ivMascot, @NonNull TextView tvContent, @NonNull BLTextView tvStepIndex) {
        this.f35728a = rootView;
        this.f12246a = btnNext;
        this.f12242a = cardGroup;
        this.f12245a = contentCard;
        this.b = headerCard;
        this.f12243a = ivMascot;
        this.f12244a = tvContent;
        this.f12247b = tvStepIndex;
    }

    @NonNull
    public static RunLayoutSunshineRunGuideBinding a(@NonNull View rootView) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        BLLinearLayout bLLinearLayoutFindChildViewById2;
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.btnNext;
        BLTextView bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, i);
        if (bLTextViewFindChildViewById2 != null) {
            i = R.id.cardGroup;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout != null && (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.contentCard))) != null && (bLLinearLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.headerCard))) != null) {
                i = R.id.ivMascot;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.tvContent;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvStepIndex))) != null) {
                        return new RunLayoutSunshineRunGuideBinding(rootView, bLTextViewFindChildViewById2, frameLayout, bLLinearLayoutFindChildViewById, bLLinearLayoutFindChildViewById2, imageView, textView, bLTextViewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutSunshineRunGuideBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_sunshine_run_guide, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35728a;
    }
}
