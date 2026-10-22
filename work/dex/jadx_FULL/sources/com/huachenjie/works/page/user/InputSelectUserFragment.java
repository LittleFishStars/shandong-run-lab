package com.huachenjie.works.page.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.InputSelectUserAdapter;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.user.InputSelectUserFragment;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.qa4;
import com.zj.adlib.y57;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0014\u0010\r\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R2\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001e\u001a\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/huachenjie/works/page/user/InputSelectUserFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/works/page/user/InputSelectUserModel;", "", "initAdapter", "initTypeChangeView", "", "checkedId", "setCurrentStatus", "restoreDefaultList", "initView", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "entityValue", "saveExtraListValue", "updateAdapterSuccess", "Lkotlin/Function1;", "Lcom/huachenjie/base/bean/UserInfoBean;", "selectCallback", "Lkotlin/jvm/functions/Function1;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "selectIdList$delegate", "Lkotlin/Lazy;", "getSelectIdList", "()Ljava/util/ArrayList;", "selectIdList", "Landroid/widget/RadioGroup;", "rgMenu$delegate", "getRgMenu", "()Landroid/widget/RadioGroup;", "rgMenu", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInputSelectUserFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputSelectUserFragment.kt\ncom/huachenjie/works/page/user/InputSelectUserFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,188:1\n1#2:189\n*E\n"})
public final class InputSelectUserFragment extends BasePubWorkMenuFragment<InputSelectUserModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SELECTED_USER_KEY = "selected_user_key";

    @Nullable
    private Function1<? super UserInfoBean, Unit> selectCallback;

    /* JADX INFO: renamed from: selectIdList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectIdList = LazyKt.lazy(new Function0<ArrayList<String>>() { // from class: com.huachenjie.works.page.user.InputSelectUserFragment$selectIdList$2
        {
            super(0);
        }

        @Nullable
        public final ArrayList<String> invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getStringArrayList(InputSelectUserFragment.SELECTED_USER_KEY);
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: rgMenu$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rgMenu = LazyKt.lazy(new Function0<RadioGroup>() { // from class: com.huachenjie.works.page.user.InputSelectUserFragment$rgMenu$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioGroup m977invoke() {
            return (RadioGroup) this.this$0.insertViewToPlaceholder1(R.layout.works_view_input_select_user_menu);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.user.InputSelectUserFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J<\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/works/page/user/InputSelectUserFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectIdList", "Lkotlin/Function1;", "Lcom/huachenjie/base/bean/UserInfoBean;", "", "selectCallback", "a", "SELECTED_USER_KEY", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @NotNull ArrayList<String> selectIdList, @NotNull Function1<? super UserInfoBean, Unit> selectCallback) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(selectIdList, "selectIdList");
            Intrinsics.checkNotNullParameter(selectCallback, "selectCallback");
            InputSelectUserFragment inputSelectUserFragment = new InputSelectUserFragment();
            inputSelectUserFragment.setSelectCallback(selectCallback);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(InputSelectUserFragment.SELECTED_USER_KEY, selectIdList);
            inputSelectUserFragment.setArguments(bundle);
            inputSelectUserFragment.show(manager, InputSelectUserFragment.class.getSimpleName());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37341a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37341a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37341a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37341a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RadioGroup getRgMenu() {
        return (RadioGroup) this.rgMenu.getValue();
    }

    private final ArrayList<String> getSelectIdList() {
        return (ArrayList) this.selectIdList.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB = ((InputSelectUserModel) getMViewModel()).B();
        final InputSelectUserAdapter inputSelectUserAdapter = new InputSelectUserAdapter();
        y57.d(inputSelectUserAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.wa4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                InputSelectUserFragment.initAdapter$lambda$4$lambda$2(inputSelectUserAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        inputSelectUserAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.xa4
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                InputSelectUserFragment.initAdapter$lambda$4$lambda$3(this.f45776a);
            }
        });
        mutableLiveDataB.setValue(inputSelectUserAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$2(InputSelectUserAdapter inputSelectUserAdapter, InputSelectUserFragment inputSelectUserFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(inputSelectUserAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(inputSelectUserFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        UserInfoBean userInfoBean = inputSelectUserAdapter.getData().get(i);
        ArrayList<String> selectIdList = inputSelectUserFragment.getSelectIdList();
        boolean z = false;
        if (selectIdList != null && selectIdList.contains(userInfoBean.getAppUserCode())) {
            z = true;
        }
        if (z) {
            fv5.a(R.string.works_publish_work_user_selected);
            return;
        }
        Function1<? super UserInfoBean, Unit> function1 = inputSelectUserFragment.selectCallback;
        if (function1 != null) {
            function1.invoke(userInfoBean);
        }
        inputSelectUserFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$4$lambda$3(InputSelectUserFragment inputSelectUserFragment) {
        Intrinsics.checkNotNullParameter(inputSelectUserFragment, "this$0");
        ((InputSelectUserModel) inputSelectUserFragment.getMViewModel()).w(false);
    }

    private final void initTypeChangeView() {
        getRgMenu().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.zj.adlib.ua4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                InputSelectUserFragment.initTypeChangeView$lambda$5(this.f45102a, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTypeChangeView$lambda$5(InputSelectUserFragment inputSelectUserFragment, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(inputSelectUserFragment, "this$0");
        inputSelectUserFragment.setCurrentStatus(i);
        inputSelectUserFragment.restoreDefaultList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$0(InputSelectUserFragment inputSelectUserFragment, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(inputSelectUserFragment, "this$0");
        if (!TextUtils.isEmpty(((InputSelectUserModel) inputSelectUserFragment.getMViewModel()).H().getValue())) {
            ((InputSelectUserModel) inputSelectUserFragment.getMViewModel()).C().setValue(3);
            ((InputSelectUserModel) inputSelectUserFragment.getMViewModel()).y();
        }
        qa4.b(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void restoreDefaultList() {
        RecyclerView recyclerView;
        Integer value = ((InputSelectUserModel) getMViewModel()).C().getValue();
        PubWorksMenuPageEntity<UserInfoBean> value2 = (value != null && value.intValue() == 1) ? ((InputSelectUserModel) getMViewModel()).J().getValue() : ((InputSelectUserModel) getMViewModel()).K().getValue();
        if (value2 == null) {
            ((InputSelectUserModel) getMViewModel()).y();
            return;
        }
        BasePubWorkMenuAdapter<?, ?> value3 = ((InputSelectUserModel) getMViewModel()).B().getValue();
        if (value3 != null) {
            ((InputSelectUserAdapter) value3).setList(value2.getList());
            WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
            if (worksFragmentPubWorkMenuBinding != null && (recyclerView = worksFragmentPubWorkMenuBinding.f14275a) != null) {
                recyclerView.scrollToPosition(0);
            }
            setListLoadMore(value2.getHasNext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setCurrentStatus(int checkedId) {
        ((InputSelectUserModel) getMViewModel()).C().setValue(checkedId == R.id.rb_follow ? 1 : 2);
    }

    @Nullable
    public final Function1<UserInfoBean, Unit> getSelectCallback() {
        return this.selectCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((InputSelectUserModel) getMViewModel()).D().setValue(getString(R.string.works_publish_work_menu_user));
        ((InputSelectUserModel) getMViewModel()).G().setValue(Integer.valueOf(R.drawable.works_ic_publish_user));
        ((InputSelectUserModel) getMViewModel()).F().setValue(getString(R.string.works_publish_work_menu_user_hint));
        initAdapter();
        initTypeChangeView();
        showLoading();
        ((InputSelectUserModel) getMViewModel()).C().setValue(1);
        ((InputSelectUserModel) getMViewModel()).y();
        ((InputSelectUserModel) getMViewModel()).H().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.user.InputSelectUserFragment.initView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                if (str.length() == 0) {
                    InputSelectUserFragment.this.getRgMenu().setVisibility(0);
                    InputSelectUserFragment inputSelectUserFragment = InputSelectUserFragment.this;
                    inputSelectUserFragment.setCurrentStatus(inputSelectUserFragment.getRgMenu().getCheckedRadioButtonId());
                    InputSelectUserFragment.this.restoreDefaultList();
                }
            }
        }));
        EditText etSearch = getEtSearch();
        if (etSearch != null) {
            etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.va4
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return InputSelectUserFragment.initView$lambda$0(this.f45317a, textView, i, keyEvent);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void saveExtraListValue(@NotNull PubWorksMenuPageEntity<?> entityValue) {
        PubWorksMenuPageEntity<UserInfoBean> value;
        Intrinsics.checkNotNullParameter(entityValue, "entityValue");
        if (entityValue.getPageNum() == 1) {
            int type = entityValue.getType();
            if (type == 1) {
                ((InputSelectUserModel) getMViewModel()).J().setValue(entityValue);
            } else if (type == 2) {
                ((InputSelectUserModel) getMViewModel()).K().setValue(entityValue);
            }
            hideLoading();
            return;
        }
        int type2 = entityValue.getType();
        if (type2 != 1) {
            if (type2 == 2 && (value = ((InputSelectUserModel) getMViewModel()).K().getValue()) != null) {
                List list = value.getList();
                List list2 = entityValue.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "pageEntity.list");
                list.addAll(list2);
                value.setPageNum(entityValue.getPageNum());
                return;
            }
            return;
        }
        PubWorksMenuPageEntity<UserInfoBean> value2 = ((InputSelectUserModel) getMViewModel()).J().getValue();
        if (value2 != null) {
            List list3 = value2.getList();
            List list4 = entityValue.getList();
            Intrinsics.checkNotNullExpressionValue(list4, "pageEntity.list");
            list3.addAll(list4);
            value2.setPageNum(entityValue.getPageNum());
        }
    }

    public final void setSelectCallback(@Nullable Function1<? super UserInfoBean, Unit> function1) {
        this.selectCallback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void updateAdapterSuccess() {
        if (((InputSelectUserModel) getMViewModel()).I(3)) {
            getRgMenu().setVisibility(8);
        }
    }
}
