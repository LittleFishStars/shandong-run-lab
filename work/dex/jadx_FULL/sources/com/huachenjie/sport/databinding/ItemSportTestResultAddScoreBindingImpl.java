package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AddPointItem;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSportTestResultAddScoreBindingImpl extends ItemSportTestResultAddScoreBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13652a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13654a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36533a = sparseIntArray;
        sparseIntArray.put(R.id.tv_project, 3);
    }

    public ItemSportTestResultAddScoreBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13652a, f36533a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String testResult;
        String extraScore;
        synchronized (this) {
            j = this.f13653a;
            this.f13653a = 0L;
        }
        AddPointItem addPointItem = ((ItemSportTestResultAddScoreBinding) this).f13651a;
        long j2 = j & 3;
        if (j2 == 0 || addPointItem == null) {
            testResult = null;
            extraScore = null;
        } else {
            testResult = addPointItem.getTestResult();
            extraScore = addPointItem.getExtraScore();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.b, testResult);
            TextViewBindingAdapter.setText(this.c, extraScore);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13653a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13653a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestResultAddScoreBinding
    public void k(@Nullable AddPointItem addPointItem) {
        ((ItemSportTestResultAddScoreBinding) this).f13651a = addPointItem;
        synchronized (this) {
            this.f13653a |= 1;
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
        k((AddPointItem) obj);
        return true;
    }

    public ItemSportTestResultAddScoreBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3]);
        this.f13653a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13654a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.c = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
