package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity;
import com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityCreateTopicChatBindingImpl extends ChannelActivityCreateTopicChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f7515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7526a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ChannelActivityCreateTopicChatBindingImpl.this.f7515a);
            CreateTopicChatVM createTopicChatVM = ((ChannelActivityCreateTopicChatBinding) ChannelActivityCreateTopicChatBindingImpl.this).f7512a;
            if (createTopicChatVM != null) {
                MutableLiveData<String> mutableLiveDataM = createTopicChatVM.m();
                if (mutableLiveDataM != null) {
                    mutableLiveDataM.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicChatActivity.ClickProxy f33070a;

        public b a(CreateTopicChatActivity.ClickProxy clickProxy) {
            this.f33070a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33070a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicChatActivity.ClickProxy f33071a;

        public c a(CreateTopicChatActivity.ClickProxy clickProxy) {
            this.f33071a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33071a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicChatActivity.ClickProxy f33072a;

        public d a(CreateTopicChatActivity.ClickProxy clickProxy) {
            this.f33072a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33072a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f7513a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        f33068a = null;
    }

    public ChannelActivityCreateTopicChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f7513a, f33068a));
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00af  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        BindingTitleBean value;
        MutableLiveData<String> mutableLiveDataK;
        String value2;
        boolean zIsEmpty;
        String value3;
        int i;
        int i2;
        c cVarA;
        d dVarA;
        b bVarA;
        String str;
        boolean zIsEmpty2;
        boolean z2;
        Long l;
        long j2;
        long j3;
        int iSafeUnbox;
        int i3;
        MutableLiveData<BindingTitleBean> mutableLiveDataI;
        BaseViewModel.b bVarE;
        MutableLiveData<Integer> mutableLiveDataA;
        Integer value4;
        boolean z3;
        long j4;
        synchronized (this) {
            j = this.f7514a;
            this.f7514a = 0L;
        }
        CreateTopicChatVM createTopicChatVM = ((ChannelActivityCreateTopicChatBinding) this).f7512a;
        CreateTopicChatActivity.ClickProxy clickProxy = ((ChannelActivityCreateTopicChatBinding) this).f33067a;
        if ((95 & j) != 0) {
            long j5 = j & 83;
            if (j5 != 0) {
                MutableLiveData<String> mutableLiveDataM = createTopicChatVM != null ? createTopicChatVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                value2 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value2);
                if (j5 != 0) {
                    j = zIsEmpty ? j | 256 : j | 128;
                }
                z = (j & 81) != 0 ? !zIsEmpty : false;
            } else {
                z = false;
                zIsEmpty = false;
                value2 = null;
            }
            if ((j & 82) != 0) {
                mutableLiveDataK = createTopicChatVM != null ? createTopicChatVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                    j2 = 88;
                }
                j3 = j & j2;
                if (j3 != 0) {
                    if (createTopicChatVM != null) {
                        bVarE = createTopicChatVM.e();
                    } else {
                        bVarE = null;
                    }
                    if (bVarE != null) {
                        mutableLiveDataA = bVarE.a();
                    } else {
                        mutableLiveDataA = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveDataA);
                    if (mutableLiveDataA != null) {
                        value4 = mutableLiveDataA.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value4);
                    if (iSafeUnbox > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (j3 != 0) {
                        if (z3) {
                            j4 = 1024;
                        } else {
                            j4 = 512;
                        }
                        j |= j4;
                    }
                    if (z3) {
                        i3 = 12;
                    } else {
                        i3 = 30;
                    }
                } else {
                    iSafeUnbox = 0;
                    i3 = 0;
                }
                if ((j & 84) == 0) {
                    i = iSafeUnbox;
                    i2 = i3;
                    value = null;
                } else {
                    if (createTopicChatVM != null) {
                        mutableLiveDataI = createTopicChatVM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value = mutableLiveDataI.getValue();
                        i = iSafeUnbox;
                        i2 = i3;
                    } else {
                        i = iSafeUnbox;
                        i2 = i3;
                        value = null;
                    }
                }
            } else {
                mutableLiveDataK = null;
            }
            j2 = 88;
            value3 = null;
            j3 = j & j2;
            if (j3 != 0) {
                if (createTopicChatVM != null) {
                    bVarE = createTopicChatVM.e();
                } else {
                    bVarE = null;
                }
                if (bVarE != null) {
                    mutableLiveDataA = bVarE.a();
                } else {
                    mutableLiveDataA = null;
                }
                updateLiveDataRegistration(3, mutableLiveDataA);
                if (mutableLiveDataA != null) {
                    value4 = mutableLiveDataA.getValue();
                } else {
                    value4 = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(value4);
                if (iSafeUnbox > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (j3 != 0) {
                    if (z3) {
                        j4 = 1024;
                    } else {
                        j4 = 512;
                    }
                    j |= j4;
                }
                if (z3) {
                    i3 = 12;
                } else {
                    i3 = 30;
                }
            } else {
                iSafeUnbox = 0;
                i3 = 0;
            }
            if ((j & 84) == 0) {
                i = iSafeUnbox;
                i2 = i3;
                value = null;
            } else {
                if (createTopicChatVM != null) {
                    mutableLiveDataI = createTopicChatVM.i();
                } else {
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    i = iSafeUnbox;
                    i2 = i3;
                } else {
                    i = iSafeUnbox;
                    i2 = i3;
                    value = null;
                }
            }
        } else {
            z = false;
            value = null;
            mutableLiveDataK = null;
            value2 = null;
            zIsEmpty = false;
            value3 = null;
            i = 0;
            i2 = 0;
        }
        if ((j & 96) == 0 || clickProxy == null) {
            cVarA = null;
            dVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f7522a;
            if (dVar == null) {
                dVar = new d();
                this.f7522a = dVar;
            }
            dVarA = dVar.a(clickProxy);
            b bVar = this.f7520a;
            if (bVar == null) {
                bVar = new b();
                this.f7520a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            c cVar = this.f7521a;
            if (cVar == null) {
                cVar = new c();
                this.f7521a = cVar;
            }
            cVarA = cVar.a(clickProxy);
        }
        if ((j & 128) != 0) {
            if (createTopicChatVM != null) {
                mutableLiveDataK = createTopicChatVM.k();
            }
            updateLiveDataRegistration(1, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value3 = mutableLiveDataK.getValue();
            }
            zIsEmpty2 = TextUtils.isEmpty(value3);
            str = value3;
        } else {
            str = value3;
            zIsEmpty2 = false;
        }
        long j6 = j & 83;
        if (j6 != 0) {
            if (zIsEmpty) {
                zIsEmpty2 = true;
            }
            if (j6 != 0) {
                j |= zIsEmpty2 ? 4096L : 2048L;
            }
            z2 = !zIsEmpty2;
        } else {
            z2 = false;
        }
        if ((84 & j) != 0) {
            this.f7523a.k(value);
        }
        if ((81 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7515a, value2);
            CommonBindingAdapter.l0(this.f7516a, z);
        }
        if ((64 & j) != 0) {
            l = null;
            TextViewBindingAdapter.setTextWatcher(this.f7515a, null, null, null, this.f7519a);
        } else {
            l = null;
        }
        if ((96 & j) != 0) {
            CommonBindingAdapter.q(this.f7516a, bVarA, l);
            CommonBindingAdapter.q(this.f7526a, cVarA, l);
            CommonBindingAdapter.q(this.f7525a, dVarA, l);
        }
        if ((82 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7518a, str);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.O(this.f7524a, 0, 0, 0, i, null);
            CommonBindingAdapter.I(this.f7525a, 0, 20, 0, i2, null);
        }
        if ((j & 83) != 0) {
            CommonBindingAdapter.e0(this.f7525a, z2);
        }
        ViewDataBinding.executeBindingsOn(this.f7523a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7514a != 0) {
                return true;
            }
            return this.f7523a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7514a = 64L;
        }
        this.f7523a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicChatBinding
    public void l(@Nullable CreateTopicChatActivity.ClickProxy clickProxy) {
        ((ChannelActivityCreateTopicChatBinding) this).f33067a = clickProxy;
        synchronized (this) {
            this.f7514a |= 32;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicChatBinding
    public void m(@Nullable CreateTopicChatVM createTopicChatVM) {
        ((ChannelActivityCreateTopicChatBinding) this).f7512a = createTopicChatVM;
        synchronized (this) {
            this.f7514a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7514a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
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
            this.f7514a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7514a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7514a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7523a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((CreateTopicChatVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((CreateTopicChatActivity.ClickProxy) obj);
        }
        return true;
    }

    public ChannelActivityCreateTopicChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4);
        this.f7519a = new a();
        this.f7514a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f7523a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7517a = linearLayout;
        linearLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.f7515a = editText;
        editText.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f7516a = imageView;
        imageView.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[3];
        this.f7526a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f7518a = textView;
        textView.setTag(null);
        ShadowConstraintLayout shadowConstraintLayout = (ShadowConstraintLayout) objArr[5];
        this.f7524a = shadowConstraintLayout;
        shadowConstraintLayout.setTag(null);
        BLButton bLButton = (BLButton) objArr[6];
        this.f7525a = bLButton;
        bLButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
