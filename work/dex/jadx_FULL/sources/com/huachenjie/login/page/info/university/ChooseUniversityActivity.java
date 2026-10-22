package com.huachenjie.login.page.info.university;

import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.databinding.LoginActivityChooseUniversityBinding;
import com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity;
import com.huachenjie.login.page.info.university.ChooseUniversityActivity;
import com.huachenjie.login.page.school.SearchSchoolActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.pg3;
import com.zj.adlib.rd6;
import com.zj.adlib.zk0;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/login/page/info/university/ChooseUniversityActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityChooseUniversityBinding;", "Lcom/huachenjie/login/page/info/university/ChooseUniversityVM;", "", "", "", "V", "getLayoutResID", "", "initData", "W", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "a", "Landroidx/activity/result/ActivityResultLauncher;", "startActivityDispatch", "Lcom/zj/adlib/rd6;", "", "b", "Lkotlin/Lazy;", "d0", "()Lcom/zj/adlib/rd6;", "optionsPickerView", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseUniversityActivity extends BaseMVVMActivity<LoginActivityChooseUniversityBinding, ChooseUniversityVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public ActivityResultLauncher<Intent> startActivityDispatch;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy optionsPickerView = LazyKt.lazy(new ChooseUniversityActivity$optionsPickerView$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/login/page/info/university/ChooseUniversityActivity$a;", "", "Landroid/view/View;", "v", "", "a", "c", "b", "d", "<init>", "(Lcom/huachenjie/login/page/info/university/ChooseUniversityActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseUniversityActivity.this.getOnBackPressedDispatcher().onBackPressed();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseUniversityActivity.a0(ChooseUniversityActivity.this).l();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ActivityResultLauncher activityResultLauncher = ChooseUniversityActivity.this.startActivityDispatch;
            if (activityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startActivityDispatch");
                activityResultLauncher = null;
            }
            activityResultLauncher.launch(new Intent(ChooseUniversityActivity.this, (Class<?>) SearchSchoolActivity.class));
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseUniversityActivity.a0(ChooseUniversityActivity.this).i();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34724a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34724a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34724a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34724a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChooseUniversityVM a0(ChooseUniversityActivity chooseUniversityActivity) {
        return chooseUniversityActivity.getMViewModel();
    }

    public static final void e0(ChooseUniversityActivity chooseUniversityActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(chooseUniversityActivity, "this$0");
        if (activityResult.getResultCode() == -1) {
            MutableLiveData<SchoolInfo> mutableLiveDataN = chooseUniversityActivity.getMViewModel().n();
            Intent data = activityResult.getData();
            mutableLiveDataN.setValue(data != null ? (SchoolInfo) data.getParcelableExtra("selectedSchool") : null);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().m().observe(this, new b(new Function1<List<? extends GradeBean>, Unit>() { // from class: com.huachenjie.login.page.info.university.ChooseUniversityActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<GradeBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<GradeBean> list) {
                Intrinsics.checkNotNullExpressionValue(list, GoodsSpecificationPreviewActivity.z);
                List<GradeBean> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((GradeBean) it.next()).getName());
                }
                ChooseUniversityActivity chooseUniversityActivity = this.this$0;
                chooseUniversityActivity.d0().C(arrayList);
                chooseUniversityActivity.d0().t();
            }
        }));
        getMViewModel().j().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.login.page.info.university.ChooseUniversityActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                pg3.gradeInfo = ChooseUniversityActivity.a0(this.this$0).k().getValue();
                pg3.com.huachenjie.common.constants.UserConstants.LOGIN_PARAMS.c java.lang.String = ChooseUniversityActivity.a0(this.this$0).n().getValue();
                CommonUserInfo commonUserInfoE = ai9.e();
                commonUserInfoE.setUserType(2);
                ai9.s(commonUserInfoE);
                this.this$0.startActivity(new Intent(this.this$0, (Class<?>) GenerateAlumnusActivity.class));
                this.this$0.finishAffinity();
            }
        }));
    }

    public final rd6<String> d0() {
        return (rd6) this.optionsPickerView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_choose_university;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.sk1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ChooseUniversityActivity.e0(this.f44706a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…          }\n            }");
        this.startActivityDispatch = activityResultLauncherRegisterForActivityResult;
    }
}
