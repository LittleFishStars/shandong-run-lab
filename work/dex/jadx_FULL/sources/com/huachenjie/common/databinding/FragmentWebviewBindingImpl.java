package com.huachenjie.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.common.webview.WebViewFragment;
import com.zj.adlib.vk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class FragmentWebviewBindingImpl extends FragmentWebviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8640a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8643a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WebViewFragment.a f33761a;

        public a a(WebViewFragment.a value) {
            this.f33761a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33761a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33760a = sparseIntArray;
        sparseIntArray.put(R.id.webView, 2);
    }

    public FragmentWebviewBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f8640a, f33760a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f8641a;
            this.f8641a = 0L;
        }
        WebViewFragment.a aVar = ((FragmentWebviewBinding) this).f8639a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8643a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8643a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((FragmentWebviewBinding) this).f33759a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8641a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8641a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.common.databinding.FragmentWebviewBinding
    public void k(@Nullable WebViewFragment.a Click) {
        ((FragmentWebviewBinding) this).f8639a = Click;
        synchronized (this) {
            this.f8641a |= 1;
        }
        notifyPropertyChanged(vk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (vk0.k != variableId) {
            return false;
        }
        k((WebViewFragment.a) variable);
        return true;
    }

    public FragmentWebviewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (MyWebView) bindings[2]);
        this.f8641a = -1L;
        ((FragmentWebviewBinding) this).f33759a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f8642a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
