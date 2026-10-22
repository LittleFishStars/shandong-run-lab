package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.share.RunShareDialog;
import com.noober.background.view.BLTextView;
import com.shizhefei.view.largeimage.LargeImageView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogShareBindingImpl extends RunDialogShareBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11786a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11784a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_share_action_panel"}, new int[]{1}, new int[]{R.layout.run_layout_share_action_panel});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35560a = sparseIntArray;
        sparseIntArray.put(R.id.img_screenshot, 2);
        sparseIntArray.put(R.id.tv_slide_tip, 3);
    }

    public RunDialogShareBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11784a, f35560a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11785a;
            this.f11785a = 0L;
        }
        BaseViewModel baseViewModel = ((RunDialogShareBinding) this).f35559a;
        RunShareDialog.a aVar = ((RunDialogShareBinding) this).f11781a;
        long j2 = 10 & j;
        if ((j & 12) != 0) {
            ((RunDialogShareBinding) this).f11780a.l(aVar);
        }
        if (j2 != 0) {
            ((RunDialogShareBinding) this).f11780a.m(baseViewModel);
        }
        ViewDataBinding.executeBindingsOn(((RunDialogShareBinding) this).f11780a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11785a != 0) {
                return true;
            }
            return ((RunDialogShareBinding) this).f11780a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11785a = 8L;
        }
        ((RunDialogShareBinding) this).f11780a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogShareBinding
    public void l(@Nullable RunShareDialog.a Click) {
        ((RunDialogShareBinding) this).f11781a = Click;
        synchronized (this) {
            this.f11785a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogShareBinding
    public void m(@Nullable BaseViewModel Vm) {
        ((RunDialogShareBinding) this).f35559a = Vm;
        synchronized (this) {
            this.f11785a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(RunLayoutShareActionPanelBinding LlAction, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11785a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((RunLayoutShareActionPanelBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunDialogShareBinding) this).f11780a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((BaseViewModel) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunShareDialog.a) variable);
        }
        return true;
    }

    public RunDialogShareBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LargeImageView) bindings[2], (RunLayoutShareActionPanelBinding) bindings[1], (BLTextView) bindings[3]);
        this.f11785a = -1L;
        setContainedBinding(((RunDialogShareBinding) this).f11780a);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11786a = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
