package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPubWorkAddMediaBindingImpl extends WorksItemPubWorkAddMediaBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37048a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14634a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f14637a;

    public WorksItemPubWorkAddMediaBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14634a, f37048a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String string;
        synchronized (this) {
            j = this.f14635a;
            this.f14635a = 0L;
        }
        SelectGridMediaAdapter selectGridMediaAdapter = ((WorksItemPubWorkAddMediaBinding) this).f37047a;
        long j2 = j & 3;
        if (j2 != 0) {
            boolean z = (selectGridMediaAdapter != null ? selectGridMediaAdapter.getType() : 0) == 1;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
            string = this.f14636a.getResources().getString(z ? R.string.works_publish_work_pic : R.string.works_publish_work_video);
        } else {
            string = null;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f14636a, string);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14635a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14635a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPubWorkAddMediaBinding
    public void k(@Nullable SelectGridMediaAdapter Adapter) {
        ((WorksItemPubWorkAddMediaBinding) this).f37047a = Adapter;
        synchronized (this) {
            this.f14635a |= 1;
        }
        notifyPropertyChanged(qk0.b);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.b != variableId) {
            return false;
        }
        k((SelectGridMediaAdapter) variable);
        return true;
    }

    public WorksItemPubWorkAddMediaBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14635a = -1L;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) bindings[0];
        this.f14637a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f14636a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
