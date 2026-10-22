package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunItemDanmuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11925a;

    @NonNull
    public final BLLinearLayout b;

    public RunItemDanmuBinding(@NonNull BLLinearLayout rootView, @NonNull BLLinearLayout llRoot, @NonNull TextView tvContent, @NonNull BLTextView tvSend) {
        this.f11924a = rootView;
        this.b = llRoot;
        this.f35611a = tvContent;
        this.f11925a = tvSend;
    }

    @NonNull
    public static RunItemDanmuBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) rootView;
        int i = R.id.tv_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView == null || (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_send))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new RunItemDanmuBinding(bLLinearLayout, bLLinearLayout, textView, bLTextViewFindChildViewById);
    }

    @NonNull
    public static RunItemDanmuBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunItemDanmuBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_item_danmu, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.f11924a;
    }
}
