package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemSearchHotSpotBindingImpl extends WorksItemSearchHotSpotBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37068a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14680a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14683a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public WorksItemSearchHotSpotBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14680a, f37068a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String popularityValue;
        String indexFormat;
        synchronized (this) {
            j = this.f14681a;
            this.f14681a = 0L;
        }
        SearchHotSpotItemBean searchHotSpotItemBean = ((WorksItemSearchHotSpotBinding) this).f37067a;
        long j2 = j & 3;
        String subjectName = null;
        if (j2 != 0) {
            if (searchHotSpotItemBean != null) {
                subjectName = searchHotSpotItemBean.getSubjectName();
                indexFormat = searchHotSpotItemBean.getIndexFormat();
                popularityValue = searchHotSpotItemBean.getPopularityValue();
            } else {
                indexFormat = null;
                popularityValue = null;
            }
            String str2 = indexFormat;
            str = String.format("#%s", subjectName);
            subjectName = str2;
        } else {
            str = null;
            popularityValue = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14682a, subjectName);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.c, popularityValue);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14681a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14681a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemSearchHotSpotBinding
    public void k(@Nullable SearchHotSpotItemBean Bean) {
        ((WorksItemSearchHotSpotBinding) this).f37067a = Bean;
        synchronized (this) {
            this.f14681a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((SearchHotSpotItemBean) variable);
        return true;
    }

    public WorksItemSearchHotSpotBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14681a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14683a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f14682a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.c = textView3;
        textView3.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
