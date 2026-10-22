package com.huachenjie.login.page.school;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.SearchSchoolInfoBean;
import com.huachenjie.login.databinding.LoginActivitySearchSchoolBinding;
import com.huachenjie.login.page.school.SearchSchoolActivity;
import com.igexin.push.g.o;
import com.zj.adlib.qa4;
import com.zj.adlib.zk0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/login/page/school/SearchSchoolActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivitySearchSchoolBinding;", "Lcom/huachenjie/login/page/school/SearchSchoolVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "h0", "j0", "e0", "<init>", "()V", "a", "b", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SearchSchoolActivity extends BaseMVVMActivity<LoginActivitySearchSchoolBinding, SearchSchoolVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f34736a = 500;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final b f10111a = new b(null);

    @NotNull
    public static final String t = "selectedSchool";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/login/page/school/SearchSchoolActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/login/page/school/SearchSchoolActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SearchSchoolActivity.this.getOnBackPressedDispatcher().onBackPressed();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/login/page/school/SearchSchoolActivity$b;", "", "", "SEARCH_DELAY_TIME", "J", "", "SELECTED_SCHOOL", "Ljava/lang/String;", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void f0(SearchSchoolActivity searchSchoolActivity) {
        Intrinsics.checkNotNullParameter(searchSchoolActivity, "this$0");
        searchSchoolActivity.getMViewModel().m();
    }

    public static final void g0(SearchSchoolActivity searchSchoolActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<SchoolInfo> list;
        SchoolInfo schoolInfo;
        Intrinsics.checkNotNullParameter(searchSchoolActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SearchSchoolInfoBean value = searchSchoolActivity.getMViewModel().l().getValue();
        if (value == null || (list = value.getList()) == null || (schoolInfo = list.get(i)) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("selectedSchool", schoolInfo);
        Unit unit = Unit.INSTANCE;
        searchSchoolActivity.setResult(-1, intent);
        searchSchoolActivity.finish();
    }

    public static final boolean i0(SearchSchoolActivity searchSchoolActivity, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(searchSchoolActivity, "this$0");
        if (i != 3) {
            return true;
        }
        searchSchoolActivity.j0();
        return true;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    public final void e0() {
        MutableLiveData<SearchSchoolAdapter> mutableLiveDataJ = getMViewModel().j();
        SearchSchoolAdapter searchSchoolAdapter = new SearchSchoolAdapter();
        searchSchoolAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.my7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                SearchSchoolActivity.f0(this.f43411a);
            }
        });
        searchSchoolAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ny7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchSchoolActivity.g0(this.f43631a, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataJ.setValue(searchSchoolAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_search_school;
    }

    public final void h0() {
        getMBinding().f34668a.getEtSearch().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.ky7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchSchoolActivity.i0(this.f42946a, textView, i, keyEvent);
            }
        });
        getMBinding().f34668a.openIntervalCallback(500L, new Function1<String, Unit>() { // from class: com.huachenjie.login.page.school.SearchSchoolActivity$initEditView$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                List<SchoolInfo> list;
                Intrinsics.checkNotNullParameter(str, o.f);
                this.this$0.getMViewModel().k().setValue(str);
                if (!(str.length() == 0)) {
                    this.this$0.getMViewModel().n();
                    return;
                }
                SearchSchoolAdapter value = this.this$0.getMViewModel().j().getValue();
                if (value != null) {
                    value.s(true);
                    value.setList(CollectionsKt.emptyList());
                }
                SearchSchoolInfoBean value2 = this.this$0.getMViewModel().l().getValue();
                if (value2 == null || (list = value2.getList()) == null) {
                    return;
                }
                list.clear();
            }
        });
        getMBinding().f34668a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.login.page.school.SearchSchoolActivity$initEditView$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                this.this$0.j0();
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().n();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        h0();
        e0();
    }

    public final void j0() {
        getMViewModel().k().setValue(String.valueOf(getMBinding().f34668a.getText()));
        getMViewModel().n();
        getMBinding().f34668a.getEtSearch().clearFocus();
        qa4.b(getMBinding().f34668a.getEtSearch());
    }
}
