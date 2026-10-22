package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.history.HistoryRecordActivity;
import com.huachenjie.mine.page.history.HistoryRecordViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineActivityHistoryRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f11192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f11193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HistoryRecordActivity.a f11194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HistoryRecordViewModel f11195a;

    public MineActivityHistoryRecordBinding(Object obj, View view, int i, FrameLayout frameLayout, SelectBoldTabLayout selectBoldTabLayout, ImageView imageView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f35293a = frameLayout;
        this.f11193a = selectBoldTabLayout;
        this.f11191a = imageView;
        this.f11192a = viewPager2;
    }

    public static MineActivityHistoryRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineActivityHistoryRecordBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineActivityHistoryRecordBinding) ViewDataBinding.bind(obj, view, R.layout.mine_activity_history_record);
    }

    @NonNull
    public static MineActivityHistoryRecordBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineActivityHistoryRecordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineActivityHistoryRecordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineActivityHistoryRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_history_record, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineActivityHistoryRecordBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineActivityHistoryRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_history_record, null, false, obj);
    }

    @Nullable
    public HistoryRecordActivity.a f() {
        return this.f11194a;
    }

    @Nullable
    public HistoryRecordViewModel g() {
        return this.f11195a;
    }

    public abstract void l(@Nullable HistoryRecordActivity.a aVar);

    public abstract void m(@Nullable HistoryRecordViewModel historyRecordViewModel);
}
