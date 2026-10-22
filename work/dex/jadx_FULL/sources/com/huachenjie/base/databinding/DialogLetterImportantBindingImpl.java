package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.letter.ImportantLettersDialog;
import com.huachenjie.base.dialog.letter.ImportantLettersVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DialogLetterImportantBindingImpl extends DialogLetterImportantBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7016a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7019a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImportantLettersDialog.a f32824a;

        public a a(ImportantLettersDialog.a value) {
            this.f32824a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32824a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32823a = sparseIntArray;
        sparseIntArray.put(R.id.ll_container, 2);
        sparseIntArray.put(R.id.tv_index, 3);
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.tv_time, 5);
        sparseIntArray.put(R.id.scroll_view, 6);
        sparseIntArray.put(R.id.tv_des, 7);
        sparseIntArray.put(R.id.web_html, 8);
    }

    public DialogLetterImportantBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f7016a, f32823a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f7017a;
            this.f7017a = 0L;
        }
        ImportantLettersDialog.a aVar = ((DialogLetterImportantBinding) this).f7012a;
        long j2 = j & 6;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7019a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7019a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((DialogLetterImportantBinding) this).f7015a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7017a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7017a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogLetterImportantBinding
    public void l(@Nullable ImportantLettersDialog.a Click) {
        ((DialogLetterImportantBinding) this).f7012a = Click;
        synchronized (this) {
            this.f7017a |= 2;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogLetterImportantBinding
    public void m(@Nullable ImportantLettersVM Vm) {
        ((DialogLetterImportantBinding) this).f7013a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((ImportantLettersVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((ImportantLettersDialog.a) variable);
        }
        return true;
    }

    public DialogLetterImportantBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLLinearLayout) bindings[2], (NestedScrollView) bindings[6], (BLTextView) bindings[1], (TextView) bindings[7], (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[4], (WebView) bindings[8]);
        this.f7017a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f7018a = constraintLayout;
        constraintLayout.setTag(null);
        ((DialogLetterImportantBinding) this).f7015a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
