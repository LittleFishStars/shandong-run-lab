package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksLocaleBindingImpl extends WorksItemWorksLocaleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14772a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14774a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37096a = sparseIntArray;
        sparseIntArray.put(R.id.ivWorkDelete, 5);
    }

    public WorksItemWorksLocaleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14772a, f37096a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        boolean zShowImage;
        boolean z;
        boolean z2;
        int i;
        int i2;
        Object obj;
        boolean z3;
        synchronized (this) {
            j = this.f14773a;
            this.f14773a = 0L;
        }
        WorkItemBean workItemBean = ((WorksItemWorksLocaleBinding) this).f14770a;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (workItemBean != null) {
                boolean zShowLocalVideoIcon = workItemBean.showLocalVideoIcon();
                Object coverUrl = workItemBean.formatCoverUrl();
                String title = workItemBean.getTitle();
                zShowImage = workItemBean.showImage();
                z3 = zShowLocalVideoIcon;
                str2 = title;
                obj = coverUrl;
            } else {
                obj = null;
                zShowImage = false;
                z3 = false;
            }
            if (j2 != 0) {
                j |= zShowImage ? 8L : 4L;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            int i3 = zShowImage ? 12 : 16;
            if ((j & 3) != 0) {
                j |= zIsEmpty ? 32L : 16L;
            }
            int i4 = zIsEmpty ? 13 : 8;
            z = !zIsEmpty;
            i = i3;
            i2 = i4;
            boolean z4 = z3;
            str = str2;
            str2 = obj;
            z2 = z4;
        } else {
            requestOptions = null;
            str = null;
            zShowImage = false;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.l0(((WorksItemWorksLocaleBinding) this).f37095a, zShowImage);
            CommonBindingAdapter.b0(((WorksItemWorksLocaleBinding) this).f37095a, str2, requestOptions, false);
            CommonBindingAdapter.l0(((WorksItemWorksLocaleBinding) this).b, z2);
            CommonBindingAdapter.I(((WorksItemWorksLocaleBinding) this).f14769a, 0, i2, 0, 0, null);
            CommonBindingAdapter.l0(((WorksItemWorksLocaleBinding) this).f14771b, z);
            TextViewBindingAdapter.setText(((WorksItemWorksLocaleBinding) this).f14771b, str);
            CommonBindingAdapter.I(((WorksItemWorksLocaleBinding) this).f14771b, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14773a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14773a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksLocaleBinding
    public void k(@Nullable WorkItemBean Bean) {
        ((WorksItemWorksLocaleBinding) this).f14770a = Bean;
        synchronized (this) {
            this.f14773a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((WorkItemBean) variable);
        return true;
    }

    public WorksItemWorksLocaleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (ImageView) bindings[2], (ImageView) bindings[5], (TextView) bindings[4], (TextView) bindings[3]);
        this.f14773a = -1L;
        ((WorksItemWorksLocaleBinding) this).f37095a.setTag(null);
        ((WorksItemWorksLocaleBinding) this).b.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14774a = cardView;
        cardView.setTag(null);
        ((WorksItemWorksLocaleBinding) this).f14769a.setTag(null);
        ((WorksItemWorksLocaleBinding) this).f14771b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
