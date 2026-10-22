package com.huachenjie.social_contact.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.social_contact.page.SearchFriendIdActivity;
import com.huachenjie.social_contact.vm.SearchFriendIdVM;
import com.zj.adlib.aw9;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySearchFriendIdBindingImpl extends ActivitySearchFriendIdBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f12792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f12793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12795a;

    @NonNull
    public final EditText b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12796b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public InverseBindingListener f12797b;

    @NonNull
    public final TextView c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivitySearchFriendIdBinding) ActivitySearchFriendIdBindingImpl.this).f36106a);
            SearchFriendIdVM searchFriendIdVM = ((ActivitySearchFriendIdBinding) ActivitySearchFriendIdBindingImpl.this).f12788a;
            if (searchFriendIdVM != null) {
                MutableLiveData<String> mutableLiveData = searchFriendIdVM.q;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivitySearchFriendIdBindingImpl.this.b);
            SearchFriendIdVM searchFriendIdVM = ((ActivitySearchFriendIdBinding) ActivitySearchFriendIdBindingImpl.this).f12788a;
            if (searchFriendIdVM != null) {
                MutableLiveData<String> mutableLiveData = searchFriendIdVM.r;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchFriendIdActivity.a f36110a;

        public c a(SearchFriendIdActivity.a aVar) {
            this.f36110a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36110a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchFriendIdActivity.a f36111a;

        public d a(SearchFriendIdActivity.a aVar) {
            this.f36111a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36111a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f12789a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36107a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.social_contact.R.id.llSearchBox, 9);
        sparseIntArray.put(com.huachenjie.social_contact.R.id.ivSearch, 10);
    }

    public ActivitySearchFriendIdBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f12789a, f36107a));
    }

    /* JADX WARN: Code duplicated, block: B:109:0x013c A[PHI: r2
      0x013c: PHI (r2v6 long) = (r2v5 long), (r2v12 long) binds: [B:92:0x0112, B:106:0x0136] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x016f A[PHI: r2
      0x016f: PHI (r2v8 long) = (r2v7 long), (r2v10 long) binds: [B:111:0x0145, B:125:0x016d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:135:0x018c  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef A[PHI: r2
      0x00ef: PHI (r2v4 long) = (r2v3 long), (r2v14 long) binds: [B:64:0x00c3, B:78:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x010b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        int i;
        String value2;
        String str;
        String value3;
        String value4;
        String value5;
        int i2;
        BindingTitleBean value6;
        int i3;
        c cVarA;
        d dVar;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f12790a;
            this.f12790a = 0L;
        }
        SearchFriendIdVM searchFriendIdVM = ((ActivitySearchFriendIdBinding) this).f12788a;
        SearchFriendIdActivity.a aVar = ((ActivitySearchFriendIdBinding) this).f12787a;
        if ((6143 & j) != 0) {
            if ((j & 5121) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveData = searchFriendIdVM != null ? searchFriendIdVM.r : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value2 = mutableLiveData.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 5122;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveData2 = searchFriendIdVM != null ? searchFriendIdVM.p : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? mutableLiveData2.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox ? 1048576L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                str = zSafeUnbox ? "已发送" : "发送申请";
            } else {
                str = null;
            }
            if ((j & 5124) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveData3 = searchFriendIdVM != null ? searchFriendIdVM.l : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    value3 = mutableLiveData3.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 5128) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveData4 = searchFriendIdVM != null ? searchFriendIdVM.q : null;
                updateLiveDataRegistration(3, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    value4 = mutableLiveData4.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 5136) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveData5 = searchFriendIdVM != null ? searchFriendIdVM.j : null;
                updateLiveDataRegistration(4, mutableLiveData5);
                if (mutableLiveData5 != null) {
                    value5 = mutableLiveData5.getValue();
                } else {
                    value5 = null;
                }
            }
            long j3 = j & 5152;
            if (j3 == 0) {
                i2 = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveData6 = searchFriendIdVM != null ? searchFriendIdVM.n : null;
                updateLiveDataRegistration(5, mutableLiveData6);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveData6 != null ? mutableLiveData6.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox2 ? 262144L : 131072L;
                }
                if (zSafeUnbox2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
            }
            if ((j & 5184) == 0) {
                value6 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData7 = searchFriendIdVM != null ? searchFriendIdVM.i : null;
                updateLiveDataRegistration(6, mutableLiveData7);
                if (mutableLiveData7 != null) {
                    value6 = mutableLiveData7.getValue();
                } else {
                    value6 = null;
                }
            }
            long j4 = j & 5248;
            if (j4 == 0) {
                i = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveData8 = searchFriendIdVM != null ? searchFriendIdVM.m : null;
                updateLiveDataRegistration(7, mutableLiveData8);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveData8 != null ? mutableLiveData8.getValue() : null);
                if (j4 != 0) {
                    j |= zSafeUnbox3 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
                if (zSafeUnbox3) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            long j5 = j & 5376;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveData9 = searchFriendIdVM != null ? searchFriendIdVM.o : null;
                updateLiveDataRegistration(8, mutableLiveData9);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveData9 != null ? mutableLiveData9.getValue() : null);
                if (j5 != 0) {
                    j |= zSafeUnbox4 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                i3 = zSafeUnbox4 ? 0 : 8;
            }
            if ((j & 5632) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveData10 = searchFriendIdVM != null ? searchFriendIdVM.k : null;
                updateLiveDataRegistration(9, mutableLiveData10);
                if (mutableLiveData10 != null) {
                    value = mutableLiveData10.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            i = 0;
            value2 = null;
            str = null;
            value3 = null;
            value4 = null;
            value5 = null;
            i2 = 0;
            value6 = null;
            i3 = 0;
        }
        long j6 = j & 6144;
        if (j6 == 0 || aVar == null) {
            cVarA = null;
            dVar = null;
        } else {
            d dVar2 = this.f12795a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f12795a = dVar2;
            }
            d dVarA = dVar2.a(aVar);
            c cVar = this.f12794a;
            if (cVar == null) {
                cVar = new c();
                this.f12794a = cVar;
            }
            cVarA = cVar.a(aVar);
            dVar = dVarA;
        }
        if ((j & 5128) != 0) {
            TextViewBindingAdapter.setText(((ActivitySearchFriendIdBinding) this).f36106a, value4);
        }
        if ((j & 4096) != 0) {
            requestOptions = null;
            TextViewBindingAdapter.setTextWatcher(((ActivitySearchFriendIdBinding) this).f36106a, null, null, null, this.f12792a);
            TextViewBindingAdapter.setTextWatcher(this.b, null, null, null, this.f12797b);
        } else {
            requestOptions = null;
        }
        if ((j & 5136) != 0) {
            aw9.d(((ActivitySearchFriendIdBinding) this).f12785a, value5, false, requestOptions);
        }
        if ((j & 5632) != 0) {
            aw9.c(((ActivitySearchFriendIdBinding) this).f12785a, value, requestOptions);
        }
        if ((5184 & j) != 0) {
            this.f12793a.k(value6);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(this.f12796b, dVar, null);
            CommonBindingAdapter.q(((ActivitySearchFriendIdBinding) this).f12784a, cVarA, null);
        }
        if ((j & 5124) != 0) {
            TextViewBindingAdapter.setText(this.c, value3);
        }
        if ((5152 & j) != 0) {
            this.b.setVisibility(i2);
        }
        if ((j & 5121) != 0) {
            TextViewBindingAdapter.setText(this.b, value2);
        }
        if ((5248 & j) != 0) {
            ((ActivitySearchFriendIdBinding) this).f12786a.setVisibility(i);
        }
        if ((5376 & j) != 0) {
            ((ActivitySearchFriendIdBinding) this).f12784a.setVisibility(i3);
        }
        if ((j & 5122) != 0) {
            TextViewBindingAdapter.setText(((ActivitySearchFriendIdBinding) this).f12784a, str);
        }
        ViewDataBinding.executeBindingsOn(this.f12793a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12790a != 0) {
                return true;
            }
            return this.f12793a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12790a = 4096L;
        }
        this.f12793a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivitySearchFriendIdBinding
    public void l(@Nullable SearchFriendIdActivity.a aVar) {
        ((ActivitySearchFriendIdBinding) this).f12787a = aVar;
        synchronized (this) {
            this.f12790a |= 2048;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivitySearchFriendIdBinding
    public void m(@Nullable SearchFriendIdVM searchFriendIdVM) {
        ((ActivitySearchFriendIdBinding) this).f12788a = searchFriendIdVM;
        synchronized (this) {
            this.f12790a |= 1024;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 512;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return s((MutableLiveData) obj, i2);
            case 1:
                return q((MutableLiveData) obj, i2);
            case 2:
                return r((MutableLiveData) obj, i2);
            case 3:
                return t((MutableLiveData) obj, i2);
            case 4:
                return p((MutableLiveData) obj, i2);
            case 5:
                return u((MutableLiveData) obj, i2);
            case 6:
                return x((MutableLiveData) obj, i2);
            case 7:
                return v((MutableLiveData) obj, i2);
            case 8:
                return w((MutableLiveData) obj, i2);
            case 9:
                return o((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 4;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12793a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((SearchFriendIdVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((SearchFriendIdActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 8;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 32;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 128;
        }
        return true;
    }

    public final boolean w(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 256;
        }
        return true;
    }

    public final boolean x(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12790a |= 64;
        }
        return true;
    }

    public ActivitySearchFriendIdBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (EditText) objArr[1], (ImageView) objArr[10], (AvatarView) objArr[4], (LinearLayout) objArr[9], (ShadowConstraintLayout) objArr[3], (TextView) objArr[7]);
        this.f12792a = new a();
        this.f12797b = new b();
        this.f12790a = -1L;
        ((ActivitySearchFriendIdBinding) this).f36106a.setTag(null);
        ((ActivitySearchFriendIdBinding) this).f12785a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[8];
        this.f12793a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12791a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12796b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.c = textView2;
        textView2.setTag(null);
        EditText editText = (EditText) objArr[6];
        this.b = editText;
        editText.setTag(null);
        ((ActivitySearchFriendIdBinding) this).f12786a.setTag(null);
        ((ActivitySearchFriendIdBinding) this).f12784a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
