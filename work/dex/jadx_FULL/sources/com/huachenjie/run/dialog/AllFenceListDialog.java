package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GeoFenceListV2Adapter;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003./0B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J(\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/huachenjie/run/dialog/AllFenceListDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/run/dialog/AllFenceListVM;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "", "initDisList", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "init", "Landroidx/fragment/app/FragmentManager;", "fm", "", "tag", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "default", "show", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Landroid/view/View;", "view", "", "position", "onItemClick", "", "mData", "Ljava/util/List;", "Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", "mListener", "Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", "getMListener", "()Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", "setMListener", "(Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;)V", "Lcom/huachenjie/run/adapter/GeoFenceListV2Adapter;", "mAdapter", "Lcom/huachenjie/run/adapter/GeoFenceListV2Adapter;", "mDefault", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "<init>", "()V", "Companion", "a", "b", "OnSureCallback", "run_release"}, k = 1, mv = {1, 8, 0})
public final class AllFenceListDialog extends BaseVMDialogFragment<AllFenceListVM> implements OnItemClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private GeoFenceListV2Adapter mAdapter;

    @Nullable
    private List<? extends GeoFenceDetail> mData;

    @Nullable
    private GeoFenceDetail mDefault;

    @Nullable
    private OnSureCallback mListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", "", "any", "", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public interface OnSureCallback {
        void a(@Nullable Object any);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/AllFenceListDialog$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/dialog/AllFenceListDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            AllFenceListDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.AllFenceListDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/dialog/AllFenceListDialog$b;", "", "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", RVParams.DEFAULT_TITLE, "Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/huachenjie/run/dialog/AllFenceListDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AllFenceListDialog a(@Nullable List<? extends GeoFenceDetail> dt, @Nullable OnSureCallback listener) {
            AllFenceListDialog allFenceListDialog = new AllFenceListDialog();
            allFenceListDialog.mData = dt;
            allFenceListDialog.setMListener(listener);
            return allFenceListDialog;
        }
    }

    private final void initDisList() {
        if (this.mAdapter == null) {
            this.mAdapter = new GeoFenceListV2Adapter();
        }
        GeoFenceListV2Adapter geoFenceListV2Adapter = this.mAdapter;
        if (geoFenceListV2Adapter != null) {
            geoFenceListV2Adapter.setOnItemClickListener(this);
        }
        AllFenceListVM allFenceListVM = (AllFenceListVM) ((BaseVMDialogFragment) this).mState;
        MutableLiveData<GeoFenceListV2Adapter> mutableLiveDataH = allFenceListVM != null ? allFenceListVM.h() : null;
        if (mutableLiveDataH != null) {
            mutableLiveDataH.setValue(this.mAdapter);
        }
        GeoFenceListV2Adapter geoFenceListV2Adapter2 = this.mAdapter;
        if (geoFenceListV2Adapter2 != null) {
            geoFenceListV2Adapter2.setList(this.mData);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_dialog_all_fence_list), Integer.valueOf(lk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(\n     …m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Nullable
    public final OnSureCallback getMListener() {
        return this.mListener;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        initDisList();
        AllFenceListVM allFenceListVM = (AllFenceListVM) ((BaseVMDialogFragment) this).mState;
        MutableLiveData<GeoFenceDetail> mutableLiveDataI = allFenceListVM != null ? allFenceListVM.i() : null;
        if (mutableLiveDataI == null) {
            return;
        }
        mutableLiveDataI.setValue(this.mDefault);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, com.huachenjie.common.R.style.ActionSheetDialogStyle);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int position) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (position < 0 || position >= adapter.getData().size()) {
            return;
        }
        ((AllFenceListVM) ((BaseVMDialogFragment) this).mState).i().setValue((GeoFenceDetail) adapter.getItem(position));
        OnSureCallback onSureCallback = this.mListener;
        if (onSureCallback != null) {
            onSureCallback.a(((AllFenceListVM) ((BaseVMDialogFragment) this).mState).i().getValue());
        }
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setWindowAnimations(R.style.common_bottom_dialog_style);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = (int) (fx7.h() * 0.55f);
        }
        if (attributes != null) {
            attributes.gravity = 80;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        setCancelable(true);
    }

    public final void setMListener(@Nullable OnSureCallback onSureCallback) {
        this.mListener = onSureCallback;
    }

    public final void show(@NotNull FragmentManager fm, @Nullable String tag, @Nullable GeoFenceDetail geoFenceDetail) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        super.show(fm, tag);
        this.mDefault = geoFenceDetail;
    }
}
