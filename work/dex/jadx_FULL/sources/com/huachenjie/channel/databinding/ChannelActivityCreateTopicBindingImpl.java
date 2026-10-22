package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.page.manage_channel.topic.CreateTopicActivity;
import com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityCreateTopicBindingImpl extends ChannelActivityCreateTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f7507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7511a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicActivity.a f33064a;

        public a a(CreateTopicActivity.a aVar) {
            this.f33064a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33064a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicActivity.a f33065a;

        public b a(CreateTopicActivity.a aVar) {
            this.f33065a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33065a.d(view);
        }
    }

    public static class c implements UploadPictureButton.OnUrlChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateTopicActivity.a f33066a;

        @Override // com.huachenjie.channel.widget.UploadPictureButton.OnUrlChangedListener
        public void a(String str) {
            this.f33066a.e(str);
        }

        public c b(CreateTopicActivity.a aVar) {
            this.f33066a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f7505a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33063a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_bg_title, 9);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_name_title, 10);
    }

    public ChannelActivityCreateTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f7505a, f33063a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0183  */
    /* JADX WARN: Code duplicated, block: B:102:0x018c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0197  */
    /* JADX WARN: Code duplicated, block: B:109:0x019e  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:113:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:116:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:119:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:122:0x0203  */
    /* JADX WARN: Code duplicated, block: B:124:0x020a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0211  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    /* JADX WARN: Code duplicated, block: B:77:0x011d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0144  */
    /* JADX WARN: Code duplicated, block: B:89:0x0148  */
    /* JADX WARN: Code duplicated, block: B:91:0x014c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0158  */
    /* JADX WARN: Code duplicated, block: B:94:0x015a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0167  */
    /* JADX WARN: Code duplicated, block: B:98:0x0178  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        int i2;
        String subjectName;
        String str;
        BindingTitleBean value;
        String subjectImg;
        long j2;
        long j3;
        c cVarB;
        b bVarA;
        a aVarA;
        long j4;
        boolean zSafeUnbox;
        boolean z2;
        long j5;
        boolean z3;
        c cVar;
        int i3;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f7506a;
            this.f7506a = 0L;
        }
        CreateTopicVM createTopicVM = ((ChannelActivityCreateTopicBinding) this).f7498a;
        String str2 = this.f;
        CreateTopicActivity.a aVar = ((ChannelActivityCreateTopicBinding) this).f7497a;
        Boolean bool = ((ChannelActivityCreateTopicBinding) this).f7504a;
        boolean zSafeUnbox2 = false;
        if ((349 & j) != 0) {
            long j6 = j & 273;
            if (j6 != 0) {
                BaseViewModel.b bVarE = createTopicVM != null ? createTopicVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                boolean z4 = iSafeUnbox > 0;
                if (j6 != 0) {
                    j |= z4 ? 1024L : 512L;
                }
                i3 = z4 ? 12 : 30;
            } else {
                i3 = 0;
                iSafeUnbox = 0;
            }
            if ((j & 276) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataQ = createTopicVM != null ? createTopicVM.q() : null;
                updateLiveDataRegistration(2, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value = mutableLiveDataQ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 344) != 0) {
                MutableLiveData<MyChannelTopic> mutableLiveDataR = createTopicVM != null ? createTopicVM.r() : null;
                updateLiveDataRegistration(3, mutableLiveDataR);
                MyChannelTopic value2 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                subjectImg = value2 != null ? value2.getSubjectImg() : null;
                long j7 = j & 280;
                if (j7 != 0) {
                    z = !TextUtils.isEmpty(subjectImg);
                    if (j7 != 0) {
                        j = z ? j | 4096 : j | 2048;
                    }
                } else {
                    z = false;
                }
                if ((j & 280) != 0) {
                    subjectName = value2 != null ? value2.getSubjectName() : null;
                    str = String.format("%d/30", Integer.valueOf(subjectName != null ? subjectName.length() : 0));
                    i = i3;
                    i2 = iSafeUnbox;
                } else {
                    i = i3;
                    i2 = iSafeUnbox;
                    subjectName = null;
                    str = null;
                }
            } else {
                i = i3;
                i2 = iSafeUnbox;
                z = false;
                subjectName = null;
                str = null;
            }
            j2 = 288 & j;
            j3 = 344 & j;
            if (j3 != 0) {
                if ((j & 320) != 0 || aVar == null) {
                    bVarA = null;
                    aVarA = null;
                } else {
                    b bVar = this.f7509a;
                    if (bVar == null) {
                        bVar = new b();
                        this.f7509a = bVar;
                    }
                    bVarA = bVar.a(aVar);
                    a aVar2 = this.f7508a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f7508a = aVar2;
                    }
                    aVarA = aVar2.a(aVar);
                }
                if (aVar != null) {
                    cVar = this.f7510a;
                    if (cVar == null) {
                        cVar = new c();
                        this.f7510a = cVar;
                    }
                    cVarB = cVar.b(aVar);
                } else {
                    cVarB = null;
                }
            } else {
                cVarB = null;
                bVarA = null;
                aVarA = null;
            }
            j4 = j & 384;
            if (j4 != 0) {
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
            } else {
                zSafeUnbox = false;
            }
            if ((j & 4096) != 0) {
                z2 = !TextUtils.isEmpty(subjectName);
            } else {
                z2 = false;
            }
            j5 = j & 280;
            if (j5 != 0) {
                if (!z) {
                    z2 = false;
                }
                z3 = z2;
            } else {
                z3 = false;
            }
            if (j4 != 0) {
                CommonBindingAdapter.e0(((ChannelActivityCreateTopicBinding) this).f7502a, zSafeUnbox2);
                CommonBindingAdapter.l0(this.c, zSafeUnbox);
                CommonBindingAdapter.l0(((ChannelActivityCreateTopicBinding) this).f7503a, zSafeUnbox2);
            }
            if (j5 != 0) {
                TextViewBindingAdapter.setText(((ChannelActivityCreateTopicBinding) this).f7502a, subjectName);
                TextViewBindingAdapter.setText(this.d, str);
                CommonBindingAdapter.e0(this.f7511a, z3);
            }
            if ((j & 320) != 0) {
                CommonBindingAdapter.q(this.c, aVarA, null);
                CommonBindingAdapter.q(this.f7511a, bVarA, null);
            }
            if ((j & 273) != 0) {
                CommonBindingAdapter.I(this.f7511a, 0, 20, 0, i, null);
                CommonBindingAdapter.O(((ChannelActivityCreateTopicBinding) this).f7501a, 0, 0, 0, i2, null);
            }
            if ((j & 276) != 0) {
                ((ChannelActivityCreateTopicBinding) this).f7500a.k(value);
            }
            if (j2 != 0) {
                TextViewBindingAdapter.setText(((ChannelActivityCreateTopicBinding) this).f7503a, str2);
            }
            if (j3 != 0) {
                UploadPictureButton.createBindingAdapter(((ChannelActivityCreateTopicBinding) this).f7499a, subjectImg, null, cVarB, false);
            }
            ViewDataBinding.executeBindingsOn(((ChannelActivityCreateTopicBinding) this).f7500a);
        }
        z = false;
        i = 0;
        i2 = 0;
        subjectName = null;
        str = null;
        value = null;
        subjectImg = null;
        j2 = 288 & j;
        j3 = 344 & j;
        if (j3 != 0) {
            if ((j & 320) != 0) {
                bVarA = null;
                aVarA = null;
            } else {
                bVarA = null;
                aVarA = null;
            }
            if (aVar != null) {
                cVar = this.f7510a;
                if (cVar == null) {
                    cVar = new c();
                    this.f7510a = cVar;
                }
                cVarB = cVar.b(aVar);
            } else {
                cVarB = null;
            }
        } else {
            cVarB = null;
            bVarA = null;
            aVarA = null;
        }
        j4 = j & 384;
        if (j4 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
        } else {
            zSafeUnbox = false;
        }
        if ((j & 4096) != 0) {
            z2 = !TextUtils.isEmpty(subjectName);
        } else {
            z2 = false;
        }
        j5 = j & 280;
        if (j5 != 0) {
            if (!z) {
                z2 = false;
            }
            z3 = z2;
        } else {
            z3 = false;
        }
        if (j4 != 0) {
            CommonBindingAdapter.e0(((ChannelActivityCreateTopicBinding) this).f7502a, zSafeUnbox2);
            CommonBindingAdapter.l0(this.c, zSafeUnbox);
            CommonBindingAdapter.l0(((ChannelActivityCreateTopicBinding) this).f7503a, zSafeUnbox2);
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityCreateTopicBinding) this).f7502a, subjectName);
            TextViewBindingAdapter.setText(this.d, str);
            CommonBindingAdapter.e0(this.f7511a, z3);
        }
        if ((j & 320) != 0) {
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.f7511a, bVarA, null);
        }
        if ((j & 273) != 0) {
            CommonBindingAdapter.I(this.f7511a, 0, 20, 0, i, null);
            CommonBindingAdapter.O(((ChannelActivityCreateTopicBinding) this).f7501a, 0, 0, 0, i2, null);
        }
        if ((j & 276) != 0) {
            ((ChannelActivityCreateTopicBinding) this).f7500a.k(value);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityCreateTopicBinding) this).f7503a, str2);
        }
        if (j3 != 0) {
            UploadPictureButton.createBindingAdapter(((ChannelActivityCreateTopicBinding) this).f7499a, subjectImg, null, cVarB, false);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityCreateTopicBinding) this).f7500a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7506a != 0) {
                return true;
            }
            return ((ChannelActivityCreateTopicBinding) this).f7500a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7506a = 256L;
        }
        ((ChannelActivityCreateTopicBinding) this).f7500a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicBinding
    public void o(@Nullable CreateTopicActivity.a aVar) {
        ((ChannelActivityCreateTopicBinding) this).f7497a = aVar;
        synchronized (this) {
            this.f7506a |= 64;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return v((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return s((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return t((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return u((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicBinding
    public void p(@Nullable Boolean bool) {
        ((ChannelActivityCreateTopicBinding) this).f7504a = bool;
        synchronized (this) {
            this.f7506a |= 128;
        }
        notifyPropertyChanged(tk0.z);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicBinding
    public void q(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f7506a |= 32;
        }
        notifyPropertyChanged(tk0.n0);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateTopicBinding
    public void r(@Nullable CreateTopicVM createTopicVM) {
        ((ChannelActivityCreateTopicBinding) this).f7498a = createTopicVM;
        synchronized (this) {
            this.f7506a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean s(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7506a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityCreateTopicBinding) this).f7500a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            r((CreateTopicVM) obj);
        } else if (tk0.n0 == i) {
            q((String) obj);
        } else if (tk0.k == i) {
            o((CreateTopicActivity.a) obj);
        } else {
            if (tk0.z != i) {
                return false;
            }
            p((Boolean) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7506a |= 4;
        }
        return true;
    }

    public final boolean u(MutableLiveData<MyChannelTopic> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7506a |= 8;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7506a |= 1;
        }
        return true;
    }

    public ChannelActivityCreateTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BLEditText) objArr[4], (ShadowConstraintLayout) objArr[6], (LayoutToolbarBindingBinding) objArr[8], (TextView) objArr[9], (BLTextView) objArr[2], (TextView) objArr[10], (UploadPictureButton) objArr[3]);
        this.f7506a = -1L;
        ((ChannelActivityCreateTopicBinding) this).f7502a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f7507a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.d = textView2;
        textView2.setTag(null);
        BLButton bLButton = (BLButton) objArr[7];
        this.f7511a = bLButton;
        bLButton.setTag(null);
        ((ChannelActivityCreateTopicBinding) this).f7501a.setTag(null);
        setContainedBinding(((ChannelActivityCreateTopicBinding) this).f7500a);
        ((ChannelActivityCreateTopicBinding) this).f7503a.setTag(null);
        ((ChannelActivityCreateTopicBinding) this).f7499a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
