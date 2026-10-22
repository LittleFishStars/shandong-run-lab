package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.bean.AttachmentBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.bean.WorksPromotionInfo;
import com.huachenjie.works.page.details.picture.PicturePromotionFragment;
import com.huachenjie.works.page.details.picture.PicturePromotionModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentPicturePromotionBindingImpl extends WorksFragmentPicturePromotionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f14245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14247a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PicturePromotionFragment.a f36926a;

        public a a(PicturePromotionFragment.a value) {
            this.f36926a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36926a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f14241a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        f36925a = null;
    }

    public WorksFragmentPicturePromotionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14241a, f36925a));
    }

    /* JADX WARN: Code duplicated, block: B:43:0x009e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        BindingTitleBean value;
        String str;
        CharSequence charSequence;
        a aVarA;
        boolean z3;
        boolean z4;
        CharSequence textContent;
        String title;
        AttachmentBean attachmentInfo;
        WorksPromotionInfo worksPromotionInfo;
        String content;
        synchronized (this) {
            j = this.f14242a;
            this.f14242a = 0L;
        }
        PicturePromotionModel picturePromotionModel = ((WorksFragmentPicturePromotionBinding) this).f14240a;
        PicturePromotionFragment.a aVar = ((WorksFragmentPicturePromotionBinding) this).f14239a;
        boolean z5 = false;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<WorkDetailBean> mutableLiveDataL = picturePromotionModel != null ? picturePromotionModel.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                WorkDetailBean value2 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value2 != null) {
                    worksPromotionInfo = value2.getWorksPromotionInfo();
                    textContent = value2.getTextContent();
                    content = value2.getContent();
                    title = value2.getTitle();
                    attachmentInfo = value2.getAttachmentInfo();
                } else {
                    attachmentInfo = null;
                    worksPromotionInfo = null;
                    textContent = null;
                    content = null;
                    title = null;
                }
                boolean z6 = worksPromotionInfo != null;
                boolean zIsEmpty = TextUtils.isEmpty(content);
                List<WorkImageBean> imageList = attachmentInfo != null ? attachmentInfo.getImageList() : null;
                z4 = !zIsEmpty;
                z3 = (imageList != null ? imageList.size() : 0) > 0;
                z5 = z6;
            } else {
                z3 = false;
                z4 = false;
                textContent = null;
                title = null;
            }
            if ((j & 22) == 0) {
                z2 = z3;
                charSequence = textContent;
                z = z4;
                str = title;
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = picturePromotionModel != null ? picturePromotionModel.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    z2 = z3;
                    charSequence = textContent;
                    z = z4;
                    str = title;
                } else {
                    z2 = z3;
                    charSequence = textContent;
                    z = z4;
                    str = title;
                    value = null;
                }
            }
        } else {
            z = false;
            z2 = false;
            value = null;
            str = null;
            charSequence = null;
        }
        long j2 = j & 24;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14246a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14246a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((21 & j) != 0) {
            CommonBindingAdapter.l0(((WorksFragmentPicturePromotionBinding) this).f14238a, z2);
            TextViewBindingAdapter.setText(this.b, str);
            CommonBindingAdapter.l0(this.f14244a, z5);
            CommonBindingAdapter.l0(((WorksFragmentPicturePromotionBinding) this).f36924a, z);
            zv9.h(((WorksFragmentPicturePromotionBinding) this).f36924a, charSequence, true);
        }
        if ((j & 22) != 0) {
            this.f14245a.k(value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14247a, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f14245a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14242a != 0) {
                return true;
            }
            return this.f14245a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14242a = 16L;
        }
        this.f14245a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPicturePromotionBinding
    public void l(@Nullable PicturePromotionFragment.a Click) {
        ((WorksFragmentPicturePromotionBinding) this).f14239a = Click;
        synchronized (this) {
            this.f14242a |= 8;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPicturePromotionBinding
    public void m(@Nullable PicturePromotionModel Vm) {
        ((WorksFragmentPicturePromotionBinding) this).f14240a = Vm;
        synchronized (this) {
            this.f14242a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14242a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<WorkDetailBean> VmWorksDetailBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14242a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f14245a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PicturePromotionModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PicturePromotionFragment.a) variable);
        }
        return true;
    }

    public WorksFragmentPicturePromotionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (CommonBanner) bindings[1], (TextView) bindings[3]);
        this.f14242a = -1L;
        ((WorksFragmentPicturePromotionBinding) this).f14238a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[6];
        this.f14245a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14243a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.b = textView;
        textView.setTag(null);
        CardView cardView = (CardView) bindings[4];
        this.f14244a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[5];
        this.f14247a = bLTextView;
        bLTextView.setTag(null);
        ((WorksFragmentPicturePromotionBinding) this).f36924a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
