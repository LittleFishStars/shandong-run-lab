package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityEmojiStickerCreateBindingImpl extends ActivityEmojiStickerCreateBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f12698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f12700a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityEmojiStickerCreateBinding) ActivityEmojiStickerCreateBindingImpl.this).f36074a);
            CreateEmojiStickerVM createEmojiStickerVM = ((ActivityEmojiStickerCreateBinding) ActivityEmojiStickerCreateBindingImpl.this).f12694a;
            if (createEmojiStickerVM != null) {
                MutableLiveData<String> mutableLiveDataN = createEmojiStickerVM.n();
                if (mutableLiveDataN != null) {
                    mutableLiveDataN.setValue(textString);
                }
            }
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f12695a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36075a = null;
    }

    public ActivityEmojiStickerCreateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12695a, f36075a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CreateEmojiStickerAdapter<MultiItemEntity> value;
        BindingTitleBean value2;
        String value3;
        synchronized (this) {
            j = this.f12696a;
            this.f12696a = 0L;
        }
        CreateEmojiStickerVM createEmojiStickerVM = ((ActivityEmojiStickerCreateBinding) this).f12694a;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataO = createEmojiStickerVM != null ? createEmojiStickerVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 26) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = createEmojiStickerVM != null ? createEmojiStickerVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value3 = mutableLiveDataN.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 28) == 0) {
                value = null;
            } else {
                MutableLiveData<CreateEmojiStickerAdapter<MultiItemEntity>> mutableLiveDataK = createEmojiStickerVM != null ? createEmojiStickerVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
        }
        if ((26 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityEmojiStickerCreateBinding) this).f36074a, value3);
        }
        if ((16 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityEmojiStickerCreateBinding) this).f36074a, null, null, null, this.f12698a);
        }
        if ((25 & j) != 0) {
            this.f12700a.k(value2);
        }
        if ((j & 28) != 0) {
            CommonBindingAdapter.g(this.f12699a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f12700a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12696a != 0) {
                return true;
            }
            return this.f12700a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12696a = 16L;
        }
        this.f12700a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerCreateBinding
    public void k(@Nullable CreateEmojiStickerVM createEmojiStickerVM) {
        ((ActivityEmojiStickerCreateBinding) this).f12694a = createEmojiStickerVM;
        synchronized (this) {
            this.f12696a |= 8;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<CreateEmojiStickerAdapter<MultiItemEntity>> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12696a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12696a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12696a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12700a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((CreateEmojiStickerVM) obj);
        return true;
    }

    public ActivityEmojiStickerCreateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[1]);
        this.f12698a = new a();
        this.f12696a = -1L;
        ((ActivityEmojiStickerCreateBinding) this).f36074a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f12700a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12697a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f12699a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
