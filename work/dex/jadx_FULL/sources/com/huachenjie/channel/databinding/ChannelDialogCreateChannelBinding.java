package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.channel.R;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelDialogCreateChannelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f33144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7727a;

    @NonNull
    public final BLLinearLayout b;

    @NonNull
    public final BLLinearLayout c;

    public ChannelDialogCreateChannelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BLLinearLayout bLLinearLayout, @NonNull BLLinearLayout bLLinearLayout2, @NonNull BLLinearLayout bLLinearLayout3) {
        this.f33144a = constraintLayout;
        this.f7727a = bLLinearLayout;
        this.b = bLLinearLayout2;
        this.c = bLLinearLayout3;
    }

    @NonNull
    public static ChannelDialogCreateChannelBinding a(@NonNull View view) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        BLLinearLayout bLLinearLayoutFindChildViewById2;
        int i = R.id.llChatChannel;
        BLLinearLayout bLLinearLayoutFindChildViewById3 = ViewBindings.findChildViewById(view, i);
        if (bLLinearLayoutFindChildViewById3 == null || (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.llChatTeam))) == null || (bLLinearLayoutFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.llCreteBt))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new ChannelDialogCreateChannelBinding((ConstraintLayout) view, bLLinearLayoutFindChildViewById3, bLLinearLayoutFindChildViewById, bLLinearLayoutFindChildViewById2);
    }

    @NonNull
    public static ChannelDialogCreateChannelBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelDialogCreateChannelBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_dialog_create_channel, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f33144a;
    }
}
