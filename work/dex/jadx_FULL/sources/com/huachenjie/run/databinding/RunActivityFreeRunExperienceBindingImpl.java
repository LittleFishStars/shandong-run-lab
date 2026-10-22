package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.free_run.FreeRunExperienceActivity;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityFreeRunExperienceBindingImpl extends RunActivityFreeRunExperienceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35465a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11479a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11485a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FreeRunExperienceActivity.a f35466a;

        public a a(FreeRunExperienceActivity.a value) {
            this.f35466a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35466a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FreeRunExperienceActivity.a f35467a;

        public b a(FreeRunExperienceActivity.a value) {
            this.f35467a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35467a.b(arg0);
        }
    }

    public RunActivityFreeRunExperienceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11479a, f35465a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11480a;
            this.f11480a = 0L;
        }
        FreeRunExperienceActivity.a aVar = ((RunActivityFreeRunExperienceBinding) this).f35464a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11484a;
            if (bVar == null) {
                bVar = new b();
                this.f11484a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11483a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11483a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11481a, aVarA, null);
            CommonBindingAdapter.q(this.f11485a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11480a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11480a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityFreeRunExperienceBinding
    public void k(@Nullable FreeRunExperienceActivity.a Click) {
        ((RunActivityFreeRunExperienceBinding) this).f35464a = Click;
        synchronized (this) {
            this.f11480a |= 1;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.k != variableId) {
            return false;
        }
        k((FreeRunExperienceActivity.a) variable);
        return true;
    }

    public RunActivityFreeRunExperienceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f11480a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11482a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f11481a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f11485a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
