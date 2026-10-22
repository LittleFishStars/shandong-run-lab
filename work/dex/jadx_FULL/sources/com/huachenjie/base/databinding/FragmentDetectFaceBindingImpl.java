package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.aliyun.detect_face.DetectFaceVM;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceBindingImpl extends FragmentDetectFaceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32838a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7053a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7054a;

    public FragmentDetectFaceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f7053a, f32838a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f7054a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7054a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7054a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceBinding
    public void k(@Nullable DetectFaceVM Vm) {
        ((FragmentDetectFaceBinding) this).f7052a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 != variableId) {
            return false;
        }
        k((DetectFaceVM) variable);
        return true;
    }

    public FragmentDetectFaceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FrameLayout) bindings[0]);
        this.f7054a = -1L;
        ((FragmentDetectFaceBinding) this).f32837a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
