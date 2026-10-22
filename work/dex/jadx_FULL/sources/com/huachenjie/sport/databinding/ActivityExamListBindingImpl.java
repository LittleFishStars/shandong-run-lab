package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.ConvertInterface;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.sport.page.mine.exam.ExamListAdapter;
import com.huachenjie.sport.page.mine.exam.ExamListVM;
import com.zj.adlib.ok0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityExamListBindingImpl extends ActivityExamListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13238a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13235a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36400a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.search_view, 4);
    }

    public ActivityExamListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13235a, f36400a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        ConvertInterface convertInterface;
        ExamListAdapter value2;
        Integer value3;
        MutableLiveData<BindingTitleBean> mutableLiveData;
        MutableLiveData<ExamListAdapter> mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3;
        synchronized (this) {
            j = this.f13236a;
            this.f13236a = 0L;
        }
        ExamListVM examListVM = ((ActivityExamListBinding) this).f13234a;
        if ((62 & j) != 0) {
            if ((j & 50) != 0) {
                if (examListVM != null) {
                    convertInterface = ((BaseVM) examListVM).f8503a;
                    mutableLiveData3 = examListVM.j;
                } else {
                    convertInterface = null;
                    mutableLiveData3 = null;
                }
                updateLiveDataRegistration(1, mutableLiveData3);
                value3 = mutableLiveData3 != null ? mutableLiveData3.getValue() : null;
                if ((j & 52) == 0) {
                    value2 = null;
                } else {
                    if (examListVM != null) {
                        mutableLiveData2 = examListVM.k;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                        value2 = mutableLiveData2.getValue();
                    } else {
                        value2 = null;
                    }
                }
                if ((j & 56) == 0) {
                    value = null;
                } else {
                    if (examListVM != null) {
                        mutableLiveData = examListVM.i;
                    } else {
                        mutableLiveData = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveData);
                    if (mutableLiveData != null) {
                        value = mutableLiveData.getValue();
                    } else {
                        value = null;
                    }
                }
            } else {
                convertInterface = null;
            }
            if ((j & 52) == 0) {
                value2 = null;
            } else {
                if (examListVM != null) {
                    mutableLiveData2 = examListVM.k;
                } else {
                    mutableLiveData2 = null;
                }
                updateLiveDataRegistration(2, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value2 = mutableLiveData2.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 56) == 0) {
                value = null;
            } else {
                if (examListVM != null) {
                    mutableLiveData = examListVM.i;
                } else {
                    mutableLiveData = null;
                }
                updateLiveDataRegistration(3, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            convertInterface = null;
            value2 = null;
            value3 = null;
        }
        if ((52 & j) != 0) {
            CommonBindingAdapter.g(this.f13238a, value2, false, false);
        }
        if ((50 & j) != 0) {
            xq8.a(((ActivityExamListBinding) this).f13232a, value3, convertInterface);
        }
        if ((j & 56) != 0) {
            ((ActivityExamListBinding) this).f36399a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ActivityExamListBinding) this).f36399a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13236a != 0) {
                return true;
            }
            return ((ActivityExamListBinding) this).f36399a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13236a = 32L;
        }
        ((ActivityExamListBinding) this).f36399a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamListBinding
    public void k(@Nullable ExamListVM examListVM) {
        ((ActivityExamListBinding) this).f13234a = examListVM;
        synchronized (this) {
            this.f13236a |= 16;
        }
        notifyPropertyChanged(ok0.L);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ExamListAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13236a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13236a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13236a |= 8;
        }
        return true;
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13236a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ActivityExamListBinding) this).f36399a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.L != i) {
            return false;
        }
        k((ExamListVM) obj);
        return true;
    }

    public ActivityExamListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CommonSearchView) objArr[4], (StateLayout) objArr[1], (LayoutToolbarBindingBinding) objArr[3]);
        this.f13236a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13237a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f13238a = recyclerView;
        recyclerView.setTag(null);
        ((ActivityExamListBinding) this).f13232a.setTag(null);
        setContainedBinding(((ActivityExamListBinding) this).f36399a);
        setRootTag(view);
        invalidateAll();
    }
}
