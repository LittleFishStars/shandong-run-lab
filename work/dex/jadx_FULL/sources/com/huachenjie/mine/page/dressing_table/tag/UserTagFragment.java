package com.huachenjie.mine.page.dressing_table.tag;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentUserTagBinding;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.mine.page.dressing_table.tag.UserTagFragment;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import com.zj.adlib.fv5;
import com.zj.adlib.ik0;
import com.zj.adlib.yg3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/tag/UserTagFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentUserTagBinding;", "Lcom/huachenjie/mine/page/dressing_table/tag/UserTagVM;", "", "", "", "getVariables", "getLayoutResID", "", "initView", "", "isVisibleToUser", "setUserVisibleHint", "initDataObservable", "hasInitData", "Z", "<init>", "()V", "Companion", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class UserTagFragment extends BaseMVVMFragment<MineFragmentUserTagBinding, UserTagVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasInitData;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/tag/UserTagFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mine/page/dressing_table/tag/UserTagFragment;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (UserTagFragment.access$getMViewModel(UserTagFragment.this).j().isEmpty()) {
                fv5.b("请设置您的兴趣标签");
            } else {
                UserTagFragment.access$getMViewModel(UserTagFragment.this).m();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.tag.UserTagFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/tag/UserTagFragment$b;", "", "Lcom/huachenjie/mine/page/dressing_table/tag/UserTagFragment;", "a", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserTagFragment a() {
            return new UserTagFragment();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35384a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35384a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35384a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35384a.invoke(obj);
        }
    }

    public static final /* synthetic */ UserTagVM access$getMViewModel(UserTagFragment userTagFragment) {
        return userTagFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1$lambda$0(SettingInterestTagsAdapter settingInterestTagsAdapter, UserTagFragment userTagFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(settingInterestTagsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(userTagFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        InterestTag interestTag = (InterestTag) settingInterestTagsAdapter.getItem(i);
        if (interestTag.getIsHeader()) {
            return;
        }
        if (!interestTag.getSelected() && userTagFragment.getMViewModel().j().size() >= 3) {
            fv5.b("最多只支持选择3种兴趣标签");
            return;
        }
        interestTag.setSelected(!interestTag.getSelected());
        if (interestTag.getSelected()) {
            userTagFragment.getMViewModel().j().add(interestTag);
        } else {
            userTagFragment.getMViewModel().j().remove(interestTag);
        }
        settingInterestTagsAdapter.notifyItemChanged(i);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_user_tag;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().k().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.tag.UserTagFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    fv5.b("设置成功");
                    FragmentActivity activity = UserTagFragment.this.getActivity();
                    DressingTableActivity dressingTableActivity = activity instanceof DressingTableActivity ? (DressingTableActivity) activity : null;
                    if (dressingTableActivity != null) {
                        List<InterestTag> listJ = UserTagFragment.access$getMViewModel(UserTagFragment.this).j();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ, 10));
                        Iterator<T> it = listJ.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((InterestTag) it.next()).getTagName());
                        }
                        dressingTableActivity.f0(arrayList);
                    }
                    yg3 yg3Var = yg3.f46026a;
                    Context contextRequireContext = UserTagFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    yg3Var.a(contextRequireContext, yg3.SOURCE_TYPE_MY_PAGE);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<SettingInterestTagsAdapter> mutableLiveDataI = getMViewModel().i();
        final SettingInterestTagsAdapter settingInterestTagsAdapter = new SettingInterestTagsAdapter();
        settingInterestTagsAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.oi9
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UserTagFragment.initView$lambda$1$lambda$0(settingInterestTagsAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataI.setValue(settingInterestTagsAdapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser || this.hasInitData) {
            return;
        }
        this.hasInitData = true;
        getMViewModel().l();
    }
}
