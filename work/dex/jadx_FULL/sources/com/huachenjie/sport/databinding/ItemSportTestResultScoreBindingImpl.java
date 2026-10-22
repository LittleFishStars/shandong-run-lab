package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ScoringItem;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSportTestResultScoreBindingImpl extends ItemSportTestResultScoreBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13657a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13658a;

    @NonNull
    public final LinearLayoutCompat b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36535a = sparseIntArray;
        sparseIntArray.put(R.id.tv_project, 3);
        sparseIntArray.put(R.id.tv_result, 4);
        sparseIntArray.put(R.id.tv_result_unit, 5);
        sparseIntArray.put(R.id.ll_score, 6);
        sparseIntArray.put(R.id.tv_score, 7);
        sparseIntArray.put(R.id.tv_level, 8);
    }

    public ItemSportTestResultScoreBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13657a, f36535a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        boolean z;
        synchronized (this) {
            j = this.f13658a;
            this.f13658a = 0L;
        }
        ScoringItem scoringItem = ((ItemSportTestResultScoreBinding) this).f13656a;
        long j2 = j & 3;
        boolean z2 = false;
        if (j2 != 0) {
            iSafeUnbox = ViewDataBinding.safeUnbox(scoringItem != null ? scoringItem.getProjectType() : null);
            z = iSafeUnbox == 8;
            if (j2 != 0) {
                j = z ? j | 8 : j | 4;
            }
        } else {
            iSafeUnbox = 0;
            z = false;
        }
        boolean z3 = (j & 4) != 0 && iSafeUnbox == 9;
        long j3 = j & 3;
        if (j3 != 0) {
            z2 = z ? true : z3;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.d, z2);
            CommonBindingAdapter.l0(this.f, z2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13658a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13658a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestResultScoreBinding
    public void k(@Nullable ScoringItem scoringItem) {
        ((ItemSportTestResultScoreBinding) this).f13656a = scoringItem;
        synchronized (this) {
            this.f13658a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
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
        k((ScoringItem) obj);
        return true;
    }

    public ItemSportTestResultScoreBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayoutCompat) objArr[6], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[7]);
        this.f13658a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.b = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
