package com.huachenjie.college.page.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.RecommendItemBean;
import com.huachenjie.college.databinding.CollegeFragmentCollegiateTownItemBinding;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.college.page.lightningPlay.LightningPlayActivity;
import com.huachenjie.college.page.popcorn.PopcornWebActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.kq5;
import com.zj.adlib.su9;
import com.zj.adlib.uk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/huachenjie/college/page/home/CollegeTownItemFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/college/databinding/CollegeFragmentCollegiateTownItemBinding;", "Lcom/huachenjie/college/page/home/CollegeTownItemVM;", "", "initAdapter", "Lcom/huachenjie/college/bean/RecommendItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "clickSale", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "onResume", "onDestroy", "onDestroyView", "", "itemType$delegate", "Lkotlin/Lazy;", "getItemType", "()Ljava/lang/String;", CollegeTownItemFragment.ITEM_TYPE, "", "hasLoadData", "Z", "getHasLoadData", "()Z", "setHasLoadData", "(Z)V", "<init>", "()V", "Companion", "a", "college_release"}, k = 1, mv = {1, 8, 0})
public final class CollegeTownItemFragment extends BaseMVVMFragment<CollegeFragmentCollegiateTownItemBinding, CollegeTownItemVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ITEM_TYPE = "itemType";
    private boolean hasLoadData;

    /* JADX INFO: renamed from: itemType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemType = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.college.page.home.CollegeTownItemFragment$itemType$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString(CollegeTownItemFragment.ITEM_TYPE);
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.college.page.home.CollegeTownItemFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/college/page/home/CollegeTownItemFragment$a;", "", "", "type", "Lcom/huachenjie/college/page/home/CollegeTownItemFragment;", "a", "ITEM_TYPE", "Ljava/lang/String;", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CollegeTownItemFragment a(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            CollegeTownItemFragment collegeTownItemFragment = new CollegeTownItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CollegeTownItemFragment.ITEM_TYPE, type);
            collegeTownItemFragment.setArguments(bundle);
            return collegeTownItemFragment;
        }
    }

    private final void clickSale(RecommendItemBean bean) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int jumpType = bean.getJumpType();
        if (jumpType == 1) {
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", bean.getRelationUrl()).navigation();
        } else if (jumpType == 2) {
            ARouter.getInstance().build(zj7.g.MERCHANTS).withString("shopNo", bean.getRelationUrl()).navigation();
        } else {
            if (jumpType != 3) {
                return;
            }
            su9.l(context, bean.getRelationUrl());
        }
    }

    private final String getItemType() {
        return (String) this.itemType.getValue();
    }

    private final void initAdapter() {
        CollegeTownAdapter collegeTownAdapter = new CollegeTownAdapter();
        y57.d(collegeTownAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.nn1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CollegeTownItemFragment.initAdapter$lambda$2$lambda$0(this.f43565a, baseQuickAdapter, view, i);
            }
        }, 1, null);
        collegeTownAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.on1
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                CollegeTownItemFragment.initAdapter$lambda$2$lambda$1(this.f43785a);
            }
        });
        CollegeTownItemVM mViewModel = getMViewModel();
        MutableLiveData<CollegeTownAdapter> mutableLiveDataI = mViewModel != null ? mViewModel.i() : null;
        if (mutableLiveDataI == null) {
            return;
        }
        mutableLiveDataI.setValue(collegeTownAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void initAdapter$lambda$2$lambda$0(CollegeTownItemFragment collegeTownItemFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<CollegeTownAdapter> mutableLiveDataI;
        CollegeTownAdapter value;
        String itemType;
        Intrinsics.checkNotNullParameter(collegeTownItemFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        CollegeTownItemVM mViewModel = collegeTownItemFragment.getMViewModel();
        if (mViewModel == null || (mutableLiveDataI = mViewModel.i()) == null || (value = mutableLiveDataI.getValue()) == null) {
            return;
        }
        List<T> data = value.getData();
        boolean z = false;
        if (i >= 0 && i < data.size()) {
            z = true;
        }
        if (z) {
            RecommendItemBean recommendItemBean = (RecommendItemBean) data.get(i);
            if (recommendItemBean.getPostType() == 1 || (itemType = collegeTownItemFragment.getItemType()) == null) {
                return;
            }
            int iHashCode = itemType.hashCode();
            if (iHashCode == 51) {
                if (itemType.equals("3")) {
                    LightningPlayActivity.Companion companion = LightningPlayActivity.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    companion.a(context, recommendItemBean.getRelationUrl());
                    return;
                }
                return;
            }
            if (iHashCode == 52) {
                if (itemType.equals("4")) {
                    Intent intent = new Intent(view.getContext(), (Class<?>) PopcornWebActivity.class);
                    intent.putExtra("url", recommendItemBean.getRelationUrl());
                    Context context2 = view.getContext();
                    if (context2 != null) {
                        context2.startActivity(intent);
                        return;
                    }
                    return;
                }
                return;
            }
            switch (iHashCode) {
                case 1567:
                    if (!itemType.equals("10")) {
                        return;
                    }
                    break;
                case 1568:
                    if (!itemType.equals("11")) {
                        return;
                    }
                    break;
                case 1569:
                    if (!itemType.equals("12")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            if (Intrinsics.areEqual(collegeTownItemFragment.getItemType(), "10")) {
                kq5.c(view.getContext(), MobClickConstants.b);
            }
            collegeTownItemFragment.clickSale(recommendItemBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(CollegeTownItemFragment collegeTownItemFragment) {
        Intrinsics.checkNotNullParameter(collegeTownItemFragment, "this$0");
        collegeTownItemFragment.getMViewModel().n();
    }

    public final boolean getHasLoadData() {
        return this.hasLoadData;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_fragment_collegiate_town_item;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().q(getItemType());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initAdapter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.hasLoadData = false;
        super.onDestroy();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.hasLoadData = false;
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hasLoadData) {
            return;
        }
        this.hasLoadData = true;
        getMViewModel().p();
    }

    public final void setHasLoadData(boolean z) {
        this.hasLoadData = z;
    }
}
