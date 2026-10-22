package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentSportTestChooseTimeBindingImpl extends FragmentSportTestChooseTimeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13511a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13513a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36485a = sparseIntArray;
        sparseIntArray.put(R.id.rv_date, 1);
        sparseIntArray.put(R.id.v_divider, 2);
        sparseIntArray.put(R.id.rv_time, 3);
    }

    public FragmentSportTestChooseTimeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13511a, f36485a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13512a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13512a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13512a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentSportTestChooseTimeBinding
    public void k(@Nullable SportTestChooseTimeVM sportTestChooseTimeVM) {
        ((FragmentSportTestChooseTimeBinding) this).f13510a = sportTestChooseTimeVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((SportTestChooseTimeVM) obj);
        return true;
    }

    public FragmentSportTestChooseTimeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[1], (RecyclerView) objArr[3], (View) objArr[2]);
        this.f13512a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13513a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
