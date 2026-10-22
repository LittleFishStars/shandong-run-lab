package com.huachenjie.works.page.details.picture;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.bean.WorksPromotionInfo;
import com.huachenjie.works.databinding.WorksFragmentPicturePromotionBinding;
import com.huachenjie.works.page.details.picture.PicturePromotionFragment;
import com.huachenjie.works.page.details.picture.PicturePromotionFragment.a;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import com.zj.adlib.yj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001d\u001a\u00060\u0019R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentPicturePromotionBinding;", "Lcom/huachenjie/works/page/details/picture/PicturePromotionModel;", "", "initTitle", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "initDataObservable", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView$delegate", "Lkotlin/Lazy;", "getStateView", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "", "worksNo$delegate", "getWorksNo", "()Ljava/lang/String;", yj7.g.WORKS_NO, "Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment$a;", "clickProxy$delegate", "getClickProxy", "()Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment$a;", "clickProxy", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PicturePromotionFragment extends BaseMVVMFragment<WorksFragmentPicturePromotionBinding, PicturePromotionModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_WORKS_NO = "works_no";

    /* JADX INFO: renamed from: stateView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionFragment$stateView$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m923invoke() {
            return StateUtilsKt.c(this.this$0);
        }
    });

    /* JADX INFO: renamed from: worksNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionFragment$worksNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("works_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionFragment$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PicturePromotionFragment.a m922invoke() {
            return this.this$0.new a();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            WorksPromotionInfo worksPromotionInfo;
            WorkDetailBean value = PicturePromotionFragment.access$getMViewModel(PicturePromotionFragment.this).l().getValue();
            if (value == null || (worksPromotionInfo = value.getWorksPromotionInfo()) == null) {
                return;
            }
            PicturePromotionFragment picturePromotionFragment = PicturePromotionFragment.this;
            int jumpType = worksPromotionInfo.getJumpType();
            if (jumpType == 1) {
                if (TextUtils.isEmpty(worksPromotionInfo.getJumpUrl())) {
                    return;
                }
                su9.v(picturePromotionFragment.getContext(), worksPromotionInfo.getJumpUrl());
            } else if (jumpType == 2 && !TextUtils.isEmpty(worksPromotionInfo.getJumpUrl())) {
                ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", worksPromotionInfo.getJumpUrl()).navigation();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.details.picture.PicturePromotionFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment$b;", "", "", yj7.g.WORKS_NO, "Lcom/huachenjie/works/page/details/picture/PicturePromotionFragment;", "a", "KEY_WORKS_NO", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PicturePromotionFragment a(@NotNull String worksNo) {
            Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
            PicturePromotionFragment picturePromotionFragment = new PicturePromotionFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PicturePromotionFragment.KEY_WORKS_NO, worksNo);
            picturePromotionFragment.setArguments(bundle);
            return picturePromotionFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37264a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37264a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37264a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37264a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentPicturePromotionBinding access$getMBinding(PicturePromotionFragment picturePromotionFragment) {
        return picturePromotionFragment.getMBinding();
    }

    public static final /* synthetic */ PicturePromotionModel access$getMViewModel(PicturePromotionFragment picturePromotionFragment) {
        return picturePromotionFragment.getMViewModel();
    }

    private final a getClickProxy() {
        return (a) this.clickProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateLayout getStateView() {
        return (StateLayout) this.stateView.getValue();
    }

    private final String getWorksNo() {
        return (String) this.worksNo.getValue();
    }

    private final void initTitle() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(getString(R.string.works_picture_promotion_title));
        int i = R.color.color_2C3E50;
        BindingTitleBean backClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.jr6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePromotionFragment.initTitle$lambda$0(this.f42652a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(backClick.setStatusBarHeight(value.intValue()).setShowDivider(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$0(PicturePromotionFragment picturePromotionFragment, View view) {
        Intrinsics.checkNotNullParameter(picturePromotionFragment, "this$0");
        FragmentActivity activity = picturePromotionFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_picture_promotion;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.k), getClickProxy()), TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getStateView().setFilterContentViewIds(new int[]{R.id.cl_title});
        StateLayout.showLoading$default(getStateView(), null, false, false, 7, null);
        PicturePromotionModel mViewModel = getMViewModel();
        String worksNo = getWorksNo();
        Intrinsics.checkNotNullExpressionValue(worksNo, yj7.g.WORKS_NO);
        mViewModel.k(worksNo);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().j().observe(this, new c(new Function1<ResultException, Unit>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResultException) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResultException resultException) {
                StateLayout.showError$default(PicturePromotionFragment.this.getStateView(), null, 1, null);
            }
        }));
        getMViewModel().l().observe(this, new c(new Function1<WorkDetailBean, Unit>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WorkDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WorkDetailBean workDetailBean) {
                CommonBanner commonBanner;
                WorksFragmentPicturePromotionBinding worksFragmentPicturePromotionBindingAccess$getMBinding = PicturePromotionFragment.access$getMBinding(PicturePromotionFragment.this);
                if (worksFragmentPicturePromotionBindingAccess$getMBinding != null && (commonBanner = worksFragmentPicturePromotionBindingAccess$getMBinding.f14238a) != null) {
                    PicturePromotionFragment picturePromotionFragment = PicturePromotionFragment.this;
                    List<WorkImageBean> imageList = workDetailBean.getAttachmentInfo().getImageList();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageList, 10));
                    for (WorkImageBean workImageBean : imageList) {
                        arrayList.add(new CommonBannerBean(workImageBean.getPath(), workImageBean.getWidth(), workImageBean.getHeight(), workImageBean.getDelFlag(), 0.0f, 16, null));
                    }
                    CommonBanner.setImageList$default(commonBanner, picturePromotionFragment, arrayList, (CommonBannerConfig) null, 4, (Object) null);
                }
                StateLayout.showContent$default(PicturePromotionFragment.this.getStateView(), null, 1, null);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitle();
    }
}
