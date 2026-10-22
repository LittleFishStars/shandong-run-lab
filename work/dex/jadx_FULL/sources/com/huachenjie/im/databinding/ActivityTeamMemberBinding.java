package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.im.R;
import com.huachenjie.im.page.team_member.TeamMemberVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ActivityTeamMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CommonSearchView f34409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TeamMemberVM f9656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9657a;

    public ActivityTeamMemberBinding(Object obj, View view, int i, BLTextView bLTextView, CommonSearchView commonSearchView) {
        super(obj, view, i);
        this.f9657a = bLTextView;
        this.f34409a = commonSearchView;
    }

    public static ActivityTeamMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityTeamMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityTeamMemberBinding) ViewDataBinding.bind(obj, view, R.layout.activity_team_member);
    }

    @NonNull
    public static ActivityTeamMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityTeamMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityTeamMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_team_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityTeamMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_team_member, null, false, obj);
    }

    @Nullable
    public TeamMemberVM f() {
        return this.f9656a;
    }

    public abstract void k(@Nullable TeamMemberVM teamMemberVM);
}
