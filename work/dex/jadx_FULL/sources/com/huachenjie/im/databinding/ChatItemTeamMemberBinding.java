package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.TeamMemberBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ChatItemTeamMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public TeamMemberBean f34411a;

    public ChatItemTeamMemberBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChatItemTeamMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatItemTeamMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChatItemTeamMemberBinding) ViewDataBinding.bind(obj, view, R.layout.chat_item_team_member);
    }

    @NonNull
    public static ChatItemTeamMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatItemTeamMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatItemTeamMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatItemTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_item_team_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChatItemTeamMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatItemTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_item_team_member, null, false, obj);
    }

    @Nullable
    public TeamMemberBean f() {
        return this.f34411a;
    }

    public abstract void k(@Nullable TeamMemberBean teamMemberBean);
}
