package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.im.R;
import com.huachenjie.im.page.TeamChatFragment;
import com.huachenjie.im.vm.TeamChatVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f9676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f9677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TeamChatFragment.e f9678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TeamChatVM f9679a;

    public FragmentChatTeamBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        super(obj, view, i);
        this.f34415a = frameLayout;
        this.f9675a = recyclerView;
        this.f9677a = swipeRefreshLayout;
    }

    public static FragmentChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChatTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentChatTeamBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_chat_team);
    }

    @NonNull
    public static FragmentChatTeamBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentChatTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentChatTeamBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_chat_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentChatTeamBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_chat_team, null, false, obj);
    }

    @Nullable
    public TeamChatFragment.e f() {
        return this.f9678a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f9676a;
    }

    @Nullable
    public TeamChatVM h() {
        return this.f9679a;
    }

    public abstract void m(@Nullable TeamChatFragment.e eVar);

    public abstract void n(@Nullable TeamChatVM teamChatVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
