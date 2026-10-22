package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemAttentionWorksVideoBindingImpl extends WorksItemAttentionWorksVideoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14466a;

    @NonNull
    public final LinearLayout b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f14463a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"works_item_attention_works_header", "works_item_attention_works_bottom"}, new int[]{5, 6}, new int[]{R.layout.works_item_attention_works_header, R.layout.works_item_attention_works_bottom});
        f37004a = null;
    }

    public WorksItemAttentionWorksVideoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14463a, f37004a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String violationText;
        int i;
        synchronized (this) {
            j = this.f14464a;
            this.f14464a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemAttentionWorksVideoBinding) this).f14460a;
        long j2 = j & 12;
        boolean z2 = false;
        if (j2 != 0) {
            if (workDetailBean != null) {
                int violationIcon = workDetailBean.formatViolationIcon();
                boolean zShowVideoViolation = workDetailBean.showVideoViolation();
                violationText = workDetailBean.formatViolationText();
                i = violationIcon;
                z2 = zShowVideoViolation;
            } else {
                violationText = null;
                i = 0;
            }
            z = !z2;
        } else {
            z = false;
            violationText = null;
            i = 0;
        }
        if (j2 != 0) {
            ((WorksItemAttentionWorksVideoBinding) this).f14461a.k(workDetailBean);
            ((WorksItemAttentionWorksVideoBinding) this).f14462a.k(workDetailBean);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksVideoBinding) this).f14459a, z2);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksVideoBinding) this).f37003a, z);
            DrawablesBindingAdapter.e(this.f14465a, i);
            TextViewBindingAdapter.setText(this.f14466a, violationText);
        }
        ViewDataBinding.executeBindingsOn(((WorksItemAttentionWorksVideoBinding) this).f14462a);
        ViewDataBinding.executeBindingsOn(((WorksItemAttentionWorksVideoBinding) this).f14461a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14464a != 0) {
                return true;
            }
            return ((WorksItemAttentionWorksVideoBinding) this).f14462a.hasPendingBindings() || ((WorksItemAttentionWorksVideoBinding) this).f14461a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14464a = 8L;
        }
        ((WorksItemAttentionWorksVideoBinding) this).f14462a.invalidateAll();
        ((WorksItemAttentionWorksVideoBinding) this).f14461a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemAttentionWorksVideoBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemAttentionWorksVideoBinding) this).f14460a = Vm;
        synchronized (this) {
            this.f14464a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(WorksItemAttentionWorksBottomBinding AttentionWorksBottom, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14464a |= 2;
        }
        return true;
    }

    public final boolean m(WorksItemAttentionWorksHeaderBinding AttentionWorksHeader, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14464a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((WorksItemAttentionWorksHeaderBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return l((WorksItemAttentionWorksBottomBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksItemAttentionWorksVideoBinding) this).f14462a.setLifecycleOwner(lifecycleOwner);
        ((WorksItemAttentionWorksVideoBinding) this).f14461a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemAttentionWorksVideoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (WorksItemAttentionWorksBottomBinding) bindings[6], (WorksItemAttentionWorksHeaderBinding) bindings[5], (LinearLayout) bindings[2], (FrameLayout) bindings[1]);
        this.f14464a = -1L;
        setContainedBinding(((WorksItemAttentionWorksVideoBinding) this).f14461a);
        setContainedBinding(((WorksItemAttentionWorksVideoBinding) this).f14462a);
        ((WorksItemAttentionWorksVideoBinding) this).f14459a.setTag(null);
        ((WorksItemAttentionWorksVideoBinding) this).f37003a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.f14465a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.f14466a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
