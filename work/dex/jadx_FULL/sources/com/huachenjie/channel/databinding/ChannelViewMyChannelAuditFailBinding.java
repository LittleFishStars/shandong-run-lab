package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.channel.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelViewMyChannelAuditFailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8238a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f8239b;

    public ChannelViewMyChannelAuditFailBinding(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull BLTextView bLTextView, @NonNull BLTextView bLTextView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f8237a = bLConstraintLayout;
        this.f8238a = bLTextView;
        this.f8239b = bLTextView2;
        this.f33340a = textView;
        this.b = textView2;
    }

    @NonNull
    public static ChannelViewMyChannelAuditFailBinding a(@NonNull View view) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.btn_cancel;
        BLTextView bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (bLTextViewFindChildViewById2 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.btn_update))) != null) {
            i = R.id.tv_audit_info;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ChannelViewMyChannelAuditFailBinding((BLConstraintLayout) view, bLTextViewFindChildViewById2, bLTextViewFindChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ChannelViewMyChannelAuditFailBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelViewMyChannelAuditFailBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_view_my_channel_audit_fail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f8237a;
    }
}
