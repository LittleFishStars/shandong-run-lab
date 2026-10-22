package com.huachenjie.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.common.webview.WebViewVM;
import com.zj.adlib.vk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ActivityWebviewBindingImpl extends ActivityWebviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8596a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f8595a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33746a = sparseIntArray;
        sparseIntArray.put(R.id.webView, 2);
        sparseIntArray.put(R.id.webView_progressbar, 3);
    }

    public ActivityWebviewBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f8595a, f33746a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8596a;
            this.f8596a = 0L;
        }
        WebViewVM webViewVM = ((ActivityWebviewBinding) this).f8594a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataH = webViewVM != null ? webViewVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            }
        }
        if (j2 != 0) {
            ((ActivityWebviewBinding) this).f8592a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ActivityWebviewBinding) this).f8592a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8596a != 0) {
                return true;
            }
            return ((ActivityWebviewBinding) this).f8592a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8596a = 8L;
        }
        ((ActivityWebviewBinding) this).f8592a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.common.databinding.ActivityWebviewBinding
    public void k(@Nullable WebViewVM Vm) {
        ((ActivityWebviewBinding) this).f8594a = Vm;
        synchronized (this) {
            this.f8596a |= 4;
        }
        notifyPropertyChanged(vk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != vk0.f45372a) {
            return false;
        }
        synchronized (this) {
            this.f8596a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != vk0.f45372a) {
            return false;
        }
        synchronized (this) {
            this.f8596a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ActivityWebviewBinding) this).f8592a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (vk0.p0 != variableId) {
            return false;
        }
        k((WebViewVM) variable);
        return true;
    }

    public ActivityWebviewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RelativeLayout) bindings[0], (LayoutToolbarBindingBinding) bindings[1], (MyWebView) bindings[2], (ProgressBar) bindings[3]);
        this.f8596a = -1L;
        ((ActivityWebviewBinding) this).f8591a.setTag(null);
        setContainedBinding(((ActivityWebviewBinding) this).f8592a);
        setRootTag(root);
        invalidateAll();
    }
}
