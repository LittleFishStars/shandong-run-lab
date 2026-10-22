package com.huachenjie.works.page.alumni.find_alumni;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.bean.InterestTagGroupBean;
import com.huachenjie.works.databinding.WorksActivitySettingInterestTagsBinding;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.qk0;
import com.zj.adlib.yg3;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivitySettingInterestTagsBinding;", "Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "e0", "c0", "<init>", "()V", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSettingInterestTagsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingInterestTagsActivity.kt\ncom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,118:1\n1855#2,2:119\n*S KotlinDebug\n*F\n+ 1 SettingInterestTagsActivity.kt\ncom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity\n*L\n90#1:119,2\n*E\n"})
public final class SettingInterestTagsActivity extends BaseMVVMActivity<WorksActivitySettingInterestTagsBinding, SettingInterestTagsVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "tagGroups";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (SettingInterestTagsActivity.b0(SettingInterestTagsActivity.this).k().isEmpty()) {
                fv5.b("请设置您的兴趣标签");
            } else {
                SettingInterestTagsActivity.b0(SettingInterestTagsActivity.this).m();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsActivity$b;", "", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/InterestTagGroupBean;", "Lkotlin/collections/ArrayList;", SettingInterestTagsActivity.t, "", "a", "", "TAG_GROUPS", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ArrayList<InterestTagGroupBean> tagGroups) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(tagGroups, SettingInterestTagsActivity.t);
            Intent intent = new Intent(context, (Class<?>) SettingInterestTagsActivity.class);
            intent.putExtra(SettingInterestTagsActivity.t, tagGroups);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37168a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37168a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37168a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37168a.invoke(obj);
        }
    }

    public static final /* synthetic */ SettingInterestTagsVM b0(SettingInterestTagsActivity settingInterestTagsActivity) {
        return settingInterestTagsActivity.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d0(SettingInterestTagsAdapter settingInterestTagsAdapter, SettingInterestTagsActivity settingInterestTagsActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(settingInterestTagsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(settingInterestTagsActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        InterestTag interestTag = (InterestTag) settingInterestTagsAdapter.getItem(i);
        if (interestTag.getIsHeader()) {
            return;
        }
        if (!interestTag.getSelected() && settingInterestTagsActivity.getMViewModel().k().size() >= 3) {
            fv5.b("最多只支持选择3种兴趣标签");
            return;
        }
        interestTag.setSelected(!interestTag.getSelected());
        if (interestTag.getSelected()) {
            settingInterestTagsActivity.getMViewModel().k().add(interestTag);
        } else {
            settingInterestTagsActivity.getMViewModel().k().remove(interestTag);
        }
        settingInterestTagsAdapter.notifyItemChanged(i);
    }

    public static final void f0(SettingInterestTagsActivity settingInterestTagsActivity, View view) {
        Intrinsics.checkNotNullParameter(settingInterestTagsActivity, "this$0");
        settingInterestTagsActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().l().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsActivity$initDataObserve$1
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
                    yg3.f46026a.a(this.this$0, yg3.SOURCE_TYPE_SETTINGS);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final void c0() {
        MutableLiveData<SettingInterestTagsAdapter> mutableLiveDataJ = getMViewModel().j();
        final SettingInterestTagsAdapter settingInterestTagsAdapter = new SettingInterestTagsAdapter();
        settingInterestTagsAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.r78
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SettingInterestTagsActivity.d0(settingInterestTagsAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataJ.setValue(settingInterestTagsAdapter);
    }

    public final void e0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("兴趣标签");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.s78
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingInterestTagsActivity.f0(this.f44633a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_setting_interest_tags;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ArrayList<InterestTagGroupBean> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(t);
        if (parcelableArrayListExtra != null) {
            ArrayList arrayList = new ArrayList();
            for (InterestTagGroupBean interestTagGroupBean : parcelableArrayListExtra) {
                arrayList.add(new InterestTag(true, null, interestTagGroupBean.getTypeName(), false, 10, null));
                arrayList.addAll(interestTagGroupBean.getList());
            }
            SettingInterestTagsAdapter value = getMViewModel().j().getValue();
            if (value != null) {
                value.setList(arrayList);
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        e0();
        c0();
    }
}
