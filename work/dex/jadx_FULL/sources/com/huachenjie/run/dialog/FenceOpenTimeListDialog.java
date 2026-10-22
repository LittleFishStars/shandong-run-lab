package com.huachenjie.run.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.bean.NewOpenTimesBean;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.FenceOpenTimeListAdapter;
import com.huachenjie.run.bean.OpenTimeBean;
import com.huachenjie.run.databinding.RunDialogFenceOpenTimeListBinding;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/dialog/FenceOpenTimeListDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFenceOpenTimeListDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FenceOpenTimeListDialog.kt\ncom/huachenjie/run/dialog/FenceOpenTimeListDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n1855#2:77\n1855#2,2:78\n1856#2:80\n*S KotlinDebug\n*F\n+ 1 FenceOpenTimeListDialog.kt\ncom/huachenjie/run/dialog/FenceOpenTimeListDialog\n*L\n60#1:77\n62#1:78,2\n60#1:80\n*E\n"})
public final class FenceOpenTimeListDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_LIST = "key_list";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/FenceOpenTimeListDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/dialog/FenceOpenTimeListDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            FenceOpenTimeListDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.FenceOpenTimeListDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/dialog/FenceOpenTimeListDialog$b;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/common/bean/NewOpenTimesBean;", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "Lcom/huachenjie/run/dialog/FenceOpenTimeListDialog;", "a", "", "KEY_LIST", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FenceOpenTimeListDialog a(@NotNull ArrayList<NewOpenTimesBean> list) {
            Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
            FenceOpenTimeListDialog fenceOpenTimeListDialog = new FenceOpenTimeListDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(FenceOpenTimeListDialog.KEY_LIST, list);
            fenceOpenTimeListDialog.setArguments(bundle);
            return fenceOpenTimeListDialog;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_dialog_fence_open_time_list), Integer.valueOf(lk0.L), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return this.WARP;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        ArrayList<NewOpenTimesBean> parcelableArrayList;
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunDialogFenceOpenTimeListBinding");
        RunDialogFenceOpenTimeListBinding runDialogFenceOpenTimeListBinding = (RunDialogFenceOpenTimeListBinding) binding;
        final FenceOpenTimeListAdapter fenceOpenTimeListAdapter = new FenceOpenTimeListAdapter(R.layout.run_item_fence_open_time_header, R.layout.run_item_fence_open_time_time);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.huachenjie.run.dialog.FenceOpenTimeListDialog.init.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return ((OpenTimeBean) fenceOpenTimeListAdapter.getItem(position)).getIsHeader() ? 2 : 1;
            }
        });
        runDialogFenceOpenTimeListBinding.f11706a.setLayoutManager(gridLayoutManager);
        ArrayList arrayList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null && (parcelableArrayList = arguments.getParcelableArrayList(KEY_LIST)) != null) {
            for (NewOpenTimesBean newOpenTimesBean : parcelableArrayList) {
                arrayList.add(new OpenTimeBean(true, newOpenTimesBean.getWeekTime()));
                Iterator<T> it = newOpenTimesBean.getOpenTimes().iterator();
                while (it.hasNext()) {
                    arrayList.add(new OpenTimeBean(false, (String) it.next()));
                }
            }
        }
        fenceOpenTimeListAdapter.setList(arrayList);
        runDialogFenceOpenTimeListBinding.f11706a.setAdapter(fenceOpenTimeListAdapter);
    }
}
