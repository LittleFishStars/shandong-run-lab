package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPublishWorkPicBindingImpl extends WorksItemPublishWorkPicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14661a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14663a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37059a = sparseIntArray;
        sparseIntArray.put(R.id.iv_del, 2);
    }

    public WorksItemPublishWorkPicBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14661a, f37059a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f14662a;
            this.f14662a = 0L;
        }
        PubWorkMediaData pubWorkMediaData = ((WorksItemPublishWorkPicBinding) this).f14659a;
        long j2 = j & 6;
        String picPath = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (pubWorkMediaData != null) {
                picPath = pubWorkMediaData.getPicPath();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.b, picPath, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14662a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14662a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPublishWorkPicBinding
    public void l(@Nullable SelectGridMediaAdapter Adapter) {
        ((WorksItemPublishWorkPicBinding) this).f14660a = Adapter;
    }

    @Override // com.huachenjie.works.databinding.WorksItemPublishWorkPicBinding
    public void m(@Nullable PubWorkMediaData Data) {
        ((WorksItemPublishWorkPicBinding) this).f14659a = Data;
        synchronized (this) {
            this.f14662a |= 2;
        }
        notifyPropertyChanged(qk0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.b == variableId) {
            l((SelectGridMediaAdapter) variable);
        } else {
            if (qk0.o != variableId) {
                return false;
            }
            m((PubWorkMediaData) variable);
        }
        return true;
    }

    public WorksItemPublishWorkPicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[2], (ImageView) bindings[1]);
        this.f14662a = -1L;
        this.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14663a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
