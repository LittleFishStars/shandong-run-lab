package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.im.R;
import com.huachenjie.im.page.SignalTowerFragment;
import com.huachenjie.im.vm.ChatRoomVM;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentChatRoomBindingImpl extends FragmentChatRoomBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9672a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9674a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34414a = sparseIntArray;
        sparseIntArray.put(R.id.flContainer, 1);
        sparseIntArray.put(R.id.recycler, 2);
        sparseIntArray.put(R.id.input_panel_container, 3);
    }

    public FragmentChatRoomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9672a, f34414a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9673a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9673a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9673a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentChatRoomBinding
    public void l(@Nullable SignalTowerFragment.h hVar) {
        ((FragmentChatRoomBinding) this).f9670a = hVar;
    }

    @Override // com.huachenjie.im.databinding.FragmentChatRoomBinding
    public void m(@Nullable ChatRoomVM chatRoomVM) {
        ((FragmentChatRoomBinding) this).f9671a = chatRoomVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 == i) {
            m((ChatRoomVM) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            l((SignalTowerFragment.h) obj);
        }
        return true;
    }

    public FragmentChatRoomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (FrameLayout) objArr[3], (RecyclerView) objArr[2]);
        this.f9673a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9674a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
