package com.huachenjie.common.reconfig.baseView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\u001a\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/huachenjie/common/reconfig/baseView/IBaseView;", "()V", "mHasLoadData", "", "getMHasLoadData", "()Z", "setMHasLoadData", "(Z)V", "mIsFirstResume", "mIsVisibleToUser", "getMIsVisibleToUser", "setMIsVisibleToUser", "mViewCreated", "changeIsVisibleToUser", "", "isVisibleToUser", "isAdd2ViewPager2", "lazyLoadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onFragmentPause", "onFragmentResume", "onHiddenChanged", "hidden", "onPause", "onResume", "onViewCreated", "view", "updateHasLoadData", "hasLoadData", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseFragment extends Fragment implements IBaseView {
    private boolean mHasLoadData;
    private boolean mIsFirstResume = true;
    private boolean mIsVisibleToUser;
    private boolean mViewCreated;

    private final void changeIsVisibleToUser(boolean isVisibleToUser) {
        if (this.mViewCreated) {
            this.mIsVisibleToUser = isVisibleToUser;
            if (!isVisibleToUser) {
                onFragmentPause();
                return;
            }
            onFragmentResume();
            if (this.mHasLoadData) {
                return;
            }
            this.mHasLoadData = true;
            lazyLoadData();
        }
    }

    public final boolean getMHasLoadData() {
        return this.mHasLoadData;
    }

    public final boolean getMIsVisibleToUser() {
        return this.mIsVisibleToUser;
    }

    public boolean isAdd2ViewPager2() {
        return false;
    }

    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getLayoutResID(), container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mViewCreated = false;
        this.mIsFirstResume = true;
        this.mIsVisibleToUser = false;
        this.mHasLoadData = false;
        super.onDestroyView();
    }

    public void onFragmentPause() {
    }

    public void onFragmentResume() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        changeIsVisibleToUser(!hidden);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mViewCreated && this.mIsVisibleToUser) {
            changeIsVisibleToUser(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mViewCreated) {
            if (this.mIsFirstResume || !isHidden() || isAdd2ViewPager2()) {
                this.mIsFirstResume = false;
                changeIsVisibleToUser(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        onViewCreated();
        this.mViewCreated = true;
    }

    public final void setMHasLoadData(boolean z) {
        this.mHasLoadData = z;
    }

    public final void setMIsVisibleToUser(boolean z) {
        this.mIsVisibleToUser = z;
    }

    public final void updateHasLoadData(boolean hasLoadData) {
        this.mHasLoadData = hasLoadData;
    }

    public void onViewCreated() {
        initView();
        initData();
    }
}
