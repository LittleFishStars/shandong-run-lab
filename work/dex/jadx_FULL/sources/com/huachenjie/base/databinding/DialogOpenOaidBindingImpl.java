package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.dialog.open_oaid.OpenOaidDialog;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DialogOpenOaidBindingImpl extends DialogOpenOaidBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32828a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7028a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7036a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OpenOaidDialog.a f32829a;

        public a a(OpenOaidDialog.a value) {
            this.f32829a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32829a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OpenOaidDialog.a f32830a;

        public b a(OpenOaidDialog.a value) {
            this.f32830a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32830a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OpenOaidDialog.a f32831a;

        public c a(OpenOaidDialog.a value) {
            this.f32831a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32831a.b(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OpenOaidDialog.a f32832a;

        public d a(OpenOaidDialog.a value) {
            this.f32832a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32832a.d(arg0);
        }
    }

    public DialogOpenOaidBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f7028a, f32828a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        d dVarA;
        a aVarA;
        c cVarA;
        b bVarA;
        synchronized (this) {
            j = this.f7029a;
            this.f7029a = 0L;
        }
        OpenOaidDialog.a aVar = ((DialogOpenOaidBinding) this).f7025a;
        long j2 = j & 6;
        if (j2 == 0 || aVar == null) {
            dVarA = null;
            aVarA = null;
            cVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f7035a;
            if (dVar == null) {
                dVar = new d();
                this.f7035a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f7032a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7032a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f7033a;
            if (bVar == null) {
                bVar = new b();
                this.f7033a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f7034a;
            if (cVar == null) {
                cVar = new c();
                this.f7034a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((DialogOpenOaidBinding) this).f7027a, cVarA, null);
            CommonBindingAdapter.q(((DialogOpenOaidBinding) this).f32827a, bVarA, null);
            CommonBindingAdapter.q(this.f7031a, cVarA, null);
            CommonBindingAdapter.q(this.f7030a, bVarA, null);
            CommonBindingAdapter.q(this.f7036a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(this.c, dVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7029a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7029a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogOpenOaidBinding
    public void l(@Nullable OpenOaidDialog.a Click) {
        ((DialogOpenOaidBinding) this).f7025a = Click;
        synchronized (this) {
            this.f7029a |= 2;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogOpenOaidBinding
    public void m(@Nullable BaseVM Vm) {
        ((DialogOpenOaidBinding) this).f7026a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((BaseVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((OpenOaidDialog.a) variable);
        }
        return true;
    }

    public DialogOpenOaidBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLFrameLayout) bindings[1], (ImageView) bindings[2]);
        this.f7029a = -1L;
        ((DialogOpenOaidBinding) this).f7027a.setTag(null);
        ((DialogOpenOaidBinding) this).f32827a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f7031a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f7030a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.f7036a = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView = (ImageView) bindings[5];
        this.b = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[6];
        this.c = imageView2;
        imageView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
