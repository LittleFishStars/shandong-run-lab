package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.NestedEditTextView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityPublishOrgMessageBindingImpl extends ChannelActivityPublishOrgMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f7685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedEditTextView f7692a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public InverseBindingListener f7693b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ChannelActivityPublishOrgMessageBindingImpl.this.f7685a);
            PublishOrgMessageVM publishOrgMessageVM = ((ChannelActivityPublishOrgMessageBinding) ChannelActivityPublishOrgMessageBindingImpl.this).f7680a;
            if (publishOrgMessageVM != null) {
                MutableLiveData<String> mutableLiveDataL = publishOrgMessageVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ChannelActivityPublishOrgMessageBindingImpl.this.f7692a);
            PublishOrgMessageVM publishOrgMessageVM = ((ChannelActivityPublishOrgMessageBinding) ChannelActivityPublishOrgMessageBindingImpl.this).f7680a;
            if (publishOrgMessageVM != null) {
                MutableLiveData<String> mutableLiveDataK = publishOrgMessageVM.k();
                if (mutableLiveDataK != null) {
                    mutableLiveDataK.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishOrgMessageActivity.ClickProxy f33128a;

        public c a(PublishOrgMessageActivity.ClickProxy clickProxy) {
            this.f33128a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33128a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishOrgMessageActivity.ClickProxy f33129a;

        public d a(PublishOrgMessageActivity.ClickProxy clickProxy) {
            this.f33129a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33129a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f7683a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33125a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.image_picker, 7);
        sparseIntArray.put(com.huachenjie.channel.R.id.v_line, 8);
    }

    public ChannelActivityPublishOrgMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7683a, f33125a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String clubName;
        BindingTitleBean value;
        String value2;
        Drawable drawable;
        String value3;
        c cVarA;
        d dVarA;
        synchronized (this) {
            j = this.f7684a;
            this.f7684a = 0L;
        }
        PublishOrgMessageVM publishOrgMessageVM = ((ChannelActivityPublishOrgMessageBinding) this).f7680a;
        PublishOrgMessageActivity.ClickProxy clickProxy = ((ChannelActivityPublishOrgMessageBinding) this).f7679a;
        if ((95 & j) != 0) {
            if ((j & 81) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataO = publishOrgMessageVM != null ? publishOrgMessageVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value = mutableLiveDataO.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 82) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = publishOrgMessageVM != null ? publishOrgMessageVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 84) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = publishOrgMessageVM != null ? publishOrgMessageVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 88;
            if (j2 != 0) {
                MutableLiveData<OrganizeBean> mutableLiveDataN = publishOrgMessageVM != null ? publishOrgMessageVM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                OrganizeBean value4 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                boolean z = value4 == null;
                if (j2 != 0) {
                    j |= z ? 256L : 128L;
                }
                clubName = value4 != null ? value4.getClubName() : null;
                drawable = AppCompatResources.getDrawable(this.f7687a.getContext(), z ? com.huachenjie.channel.R.drawable.channel_ic_organization_tag : com.huachenjie.channel.R.drawable.channel_ic_organization_tag_sel);
            } else {
                clubName = null;
                drawable = null;
            }
        } else {
            clubName = null;
            value = null;
            value2 = null;
            drawable = null;
            value3 = null;
        }
        long j3 = j & 96;
        if (j3 == 0 || clickProxy == null) {
            cVarA = null;
            dVarA = null;
        } else {
            d dVar = this.f7690a;
            if (dVar == null) {
                dVar = new d();
                this.f7690a = dVar;
            }
            dVarA = dVar.a(clickProxy);
            c cVar = this.f7689a;
            if (cVar == null) {
                cVar = new c();
                this.f7689a = cVar;
            }
            cVarA = cVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelActivityPublishOrgMessageBinding) this).f7681a, dVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
        }
        if ((j & 81) != 0) {
            this.f7691a.k(value);
        }
        if ((84 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7685a, value2);
        }
        if ((64 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.f7685a, null, null, null, this.f7688a);
            TextViewBindingAdapter.setTextWatcher(this.f7692a, null, null, null, this.f7693b);
        }
        if ((82 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7692a, value3);
        }
        if ((j & 88) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.f7687a, drawable);
            TextViewBindingAdapter.setText(this.f7687a, clubName);
        }
        ViewDataBinding.executeBindingsOn(this.f7691a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7684a != 0) {
                return true;
            }
            return this.f7691a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7684a = 64L;
        }
        this.f7691a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityPublishOrgMessageBinding
    public void l(@Nullable PublishOrgMessageActivity.ClickProxy clickProxy) {
        ((ChannelActivityPublishOrgMessageBinding) this).f7679a = clickProxy;
        synchronized (this) {
            this.f7684a |= 32;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityPublishOrgMessageBinding
    public void m(@Nullable PublishOrgMessageVM publishOrgMessageVM) {
        ((ChannelActivityPublishOrgMessageBinding) this).f7680a = publishOrgMessageVM;
        synchronized (this) {
            this.f7684a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return r((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7684a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7684a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<OrganizeBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7684a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7684a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7691a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((PublishOrgMessageVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((PublishOrgMessageActivity.ClickProxy) obj);
        }
        return true;
    }

    public ChannelActivityPublishOrgMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BLTextView) objArr[5], (ImagePickView) objArr[7], (BLView) objArr[8]);
        this.f7688a = new a();
        this.f7693b = new b();
        this.f7684a = -1L;
        ((ChannelActivityPublishOrgMessageBinding) this).f7681a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[6];
        this.f7691a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7686a = linearLayout;
        linearLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.f7685a = editText;
        editText.setTag(null);
        NestedEditTextView nestedEditTextView = (NestedEditTextView) objArr[2];
        this.f7692a = nestedEditTextView;
        nestedEditTextView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[3];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f7687a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
