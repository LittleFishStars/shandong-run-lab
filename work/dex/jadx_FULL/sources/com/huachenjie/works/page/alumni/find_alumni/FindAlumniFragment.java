package com.huachenjie.works.page.alumni.find_alumni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.bean.InterestTagGroupBean;
import com.huachenjie.works.bean.SchoolMateBean;
import com.huachenjie.works.bean.SchoolmateGradeBean;
import com.huachenjie.works.databinding.WorksFragmentFindAlumniBinding;
import com.huachenjie.works.external.dialog.AddFriendDialog;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment;
import com.huachenjie.works.widget.FindAlumniPicker;
import com.igexin.push.g.o;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentFindAlumniBinding;", "Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniVM;", "", "initPicker", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFindAlumniFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FindAlumniFragment.kt\ncom/huachenjie/works/page/alumni/find_alumni/FindAlumniFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n1549#2:152\n1620#2,3:153\n1855#2,2:156\n*S KotlinDebug\n*F\n+ 1 FindAlumniFragment.kt\ncom/huachenjie/works/page/alumni/find_alumni/FindAlumniFragment\n*L\n78#1:152\n78#1:153,3\n90#1:156,2\n*E\n"})
public final class FindAlumniFragment extends BaseMVVMFragment<WorksFragmentFindAlumniBinding, FindAlumniVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String GRADE_LIST = "gradeList";

    @NotNull
    private static final String TAG_LIST = "tagList";

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.xg3
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            FindAlumniFragment.onRefreshListener$lambda$0(this.f45817a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/SchoolmateGradeBean;", "Lkotlin/collections/ArrayList;", FindAlumniFragment.GRADE_LIST, "Lcom/huachenjie/works/bean/InterestTagGroupBean;", FindAlumniFragment.TAG_LIST, "Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniFragment;", "a", "", "GRADE_LIST", "Ljava/lang/String;", "TAG_LIST", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FindAlumniFragment a(@Nullable ArrayList<SchoolmateGradeBean> gradeList, @Nullable ArrayList<InterestTagGroupBean> tagList) {
            FindAlumniFragment findAlumniFragment = new FindAlumniFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(FindAlumniFragment.GRADE_LIST, gradeList);
            bundle.putParcelableArrayList(FindAlumniFragment.TAG_LIST, tagList);
            findAlumniFragment.setArguments(bundle);
            return findAlumniFragment;
        }
    }

    public static final /* synthetic */ FindAlumniVM access$getMViewModel(FindAlumniFragment findAlumniFragment) {
        return findAlumniFragment.getMViewModel();
    }

    private final void initAdapter() {
        MutableLiveData<FindAlumniAdapter> mutableLiveDataQ = getMViewModel().q();
        final FindAlumniAdapter findAlumniAdapter = new FindAlumniAdapter();
        findAlumniAdapter.addChildClickViewIds(R.id.iv_avatar, R.id.tv_greet);
        y57.b(findAlumniAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.vg3
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FindAlumniFragment.initAdapter$lambda$8$lambda$6(findAlumniAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        findAlumniAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.wg3
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                FindAlumniFragment.initAdapter$lambda$8$lambda$7(this.f45590a);
            }
        });
        mutableLiveDataQ.setValue(findAlumniAdapter);
        FindAlumniVM mViewModel = getMViewModel();
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText("暂无校友…");
        ViewGroup.LayoutParams layoutParams = ((ImageView) viewInflate.findViewById(R.id.emptyView)).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.4f;
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…   0.4f\n                }");
        mViewModel.r(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$6(final FindAlumniAdapter findAlumniAdapter, final FindAlumniFragment findAlumniFragment, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(findAlumniAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(findAlumniFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final SchoolMateBean item = findAlumniAdapter.getItem(i);
        int id = view.getId();
        if (id == R.id.iv_avatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", item.getAppUserCode()).navigation();
            return;
        }
        if (id == R.id.tv_greet) {
            AddFriendDialog addFriendDialog = new AddFriendDialog(findAlumniFragment.requireContext(), new UserInfoBean(null, item.getUserName(), item.getAvatarUrl(), null, null, null, item.getAccId(), null, 0, false, 0, null, null, false, false, 32697, null));
            addFriendDialog.setApplyFriendSucCallback(new Function0<Unit>() { // from class: com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment$initAdapter$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m847invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m847invoke() {
                    item.setApplied(true);
                    findAlumniAdapter.notifyItemChanged(i);
                    FindAlumniFragment.access$getMViewModel(findAlumniFragment).D();
                }
            });
            addFriendDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$7(FindAlumniFragment findAlumniFragment) {
        Intrinsics.checkNotNullParameter(findAlumniFragment, "this$0");
        findAlumniFragment.getMViewModel().t();
    }

    private final void initPicker() {
        FindAlumniPicker findAlumniPicker;
        ArrayList<InterestTagGroupBean> parcelableArrayList;
        FindAlumniPicker findAlumniPicker2;
        FindAlumniPicker findAlumniPicker3;
        ArrayList<SchoolmateGradeBean> parcelableArrayList2;
        FindAlumniPicker findAlumniPicker4;
        FindAlumniPicker findAlumniPicker5;
        FindAlumniPicker findAlumniPicker6;
        WorksFragmentFindAlumniBinding mBinding = getMBinding();
        if (mBinding != null && (findAlumniPicker6 = mBinding.b) != null) {
            findAlumniPicker6.setPickerData(CollectionsKt.listOf(new InterestTag[]{new InterestTag(false, "", "全部性别", true, 1, null), new InterestTag(false, "2", "男生", false, 9, null), new InterestTag(false, "1", "女生", false, 9, null)}));
        }
        WorksFragmentFindAlumniBinding mBinding2 = getMBinding();
        if (mBinding2 != null && (findAlumniPicker5 = mBinding2.b) != null) {
            findAlumniPicker5.setOnConfirmListener(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment.initPicker.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<String>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull List<String> list) {
                    Intrinsics.checkNotNullParameter(list, o.f);
                    FindAlumniFragment.access$getMViewModel(FindAlumniFragment.this).z((String) CollectionsKt.firstOrNull(list));
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null && (parcelableArrayList2 = arguments.getParcelableArrayList(GRADE_LIST)) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parcelableArrayList2, 10));
            for (SchoolmateGradeBean schoolmateGradeBean : parcelableArrayList2) {
                arrayList.add(new InterestTag(false, schoolmateGradeBean.getGradeCode(), schoolmateGradeBean.getGradeName(), false, 9, null));
            }
            List<InterestTag> mutableList = CollectionsKt.toMutableList(arrayList);
            mutableList.add(0, new InterestTag(false, "", "全部年级", true, 1, null));
            WorksFragmentFindAlumniBinding mBinding3 = getMBinding();
            if (mBinding3 != null && (findAlumniPicker4 = mBinding3.f14190a) != null) {
                findAlumniPicker4.setPickerData(mutableList);
            }
        }
        WorksFragmentFindAlumniBinding mBinding4 = getMBinding();
        if (mBinding4 != null && (findAlumniPicker3 = mBinding4.f14190a) != null) {
            findAlumniPicker3.setOnConfirmListener(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment.initPicker.3
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<String>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull List<String> list) {
                    Intrinsics.checkNotNullParameter(list, o.f);
                    FindAlumniFragment.access$getMViewModel(FindAlumniFragment.this).w((String) CollectionsKt.firstOrNull(list));
                }
            });
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (parcelableArrayList = arguments2.getParcelableArrayList(TAG_LIST)) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (InterestTagGroupBean interestTagGroupBean : parcelableArrayList) {
                arrayList2.add(new InterestTag(true, null, interestTagGroupBean.getTypeName(), false, 10, null));
                arrayList2.addAll(interestTagGroupBean.getList());
            }
            WorksFragmentFindAlumniBinding mBinding5 = getMBinding();
            if (mBinding5 != null && (findAlumniPicker2 = mBinding5.c) != null) {
                findAlumniPicker2.setPickerData(arrayList2);
            }
        }
        WorksFragmentFindAlumniBinding mBinding6 = getMBinding();
        if (mBinding6 == null || (findAlumniPicker = mBinding6.c) == null) {
            return;
        }
        findAlumniPicker.setOnConfirmListener(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment.initPicker.5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, o.f);
                FindAlumniFragment.access$getMViewModel(FindAlumniFragment.this).B(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(FindAlumniFragment findAlumniFragment) {
        Intrinsics.checkNotNullParameter(findAlumniFragment, "this$0");
        findAlumniFragment.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_find_alumni;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        FindAlumniVM.v(getMViewModel(), null, null, null, 7, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initPicker();
        initAdapter();
    }
}
