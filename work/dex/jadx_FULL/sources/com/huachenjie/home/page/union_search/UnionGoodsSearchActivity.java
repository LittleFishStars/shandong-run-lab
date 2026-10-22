package com.huachenjie.home.page.union_search;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.databinding.HomeActivityUnionGoodsSearchBinding;
import com.huachenjie.home.page.SignUpWebActivity;
import com.huachenjie.home.page.good_stuff.GoodStuffAdapter;
import com.huachenjie.home.page.union_search.UnionGoodsSearchActivity;
import com.huachenjie.home.util.TasksUtil;
import com.igexin.push.g.o;
import com.zj.adlib.il0;
import com.zj.adlib.kq5;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/home/page/union_search/UnionGoodsSearchActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityUnionGoodsSearchBinding;", "Lcom/huachenjie/home/page/union_search/UnionGoodsSearchVM;", "", "", "", "V", "getLayoutResID", "", "initView", "h0", "g0", "d0", "", "text", "i0", "b", "Lkotlin/Lazy;", "c0", "()Ljava/lang/String;", SignUpWebActivity.A, "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class UnionGoodsSearchActivity extends BaseMVVMActivity<HomeActivityUnionGoodsSearchBinding, UnionGoodsSearchVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "task_config_no";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy taskConfigNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.home.page.union_search.UnionGoodsSearchActivity$taskConfigNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra(UnionGoodsSearchActivity.t);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.home.page.union_search.UnionGoodsSearchActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/home/page/union_search/UnionGoodsSearchActivity$a;", "", "Landroid/content/Context;", "context", "", SignUpWebActivity.A, "", "a", "KEY_TASK_CONFIG_NO", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.a(context, str);
        }

        public final void a(@NotNull Context context, @Nullable String taskConfigNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) UnionGoodsSearchActivity.class);
            intent.putExtra(UnionGoodsSearchActivity.t, taskConfigNo);
            context.startActivity(intent);
        }
    }

    public static final void e0(UnionGoodsSearchActivity unionGoodsSearchActivity) {
        Intrinsics.checkNotNullParameter(unionGoodsSearchActivity, "this$0");
        BaseStateRequestModel.x(unionGoodsSearchActivity.getMViewModel(), false, 1, null);
    }

    public static final void f0(GoodStuffAdapter goodStuffAdapter, UnionGoodsSearchActivity unionGoodsSearchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(goodStuffAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(unionGoodsSearchActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MultiItemEntity multiItemEntity = (MultiItemEntity) goodStuffAdapter.getItem(i);
        if (multiItemEntity instanceof GoodStuffBean) {
            String clickUrl = ((GoodStuffBean) multiItemEntity).getPublishInfo().getClickUrl();
            if (TextUtils.isEmpty(clickUrl)) {
                return;
            }
            if (!StringsKt.startsWith$default(clickUrl, "http", false, 2, (Object) null)) {
                clickUrl = "https://" + clickUrl;
            }
            il0.f42382a.d(unionGoodsSearchActivity, clickUrl);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    public final String c0() {
        return (String) this.taskConfigNo.getValue();
    }

    public final void d0() {
        MutableLiveData<GoodStuffAdapter> mutableLiveDataB = getMViewModel().B();
        final GoodStuffAdapter goodStuffAdapter = new GoodStuffAdapter(new WeakReference(this), 0.0f, 0.0f, 0.0f, 14, null);
        goodStuffAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.jg9
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                UnionGoodsSearchActivity.e0(this.f42582a);
            }
        });
        y57.d(goodStuffAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.kg9
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UnionGoodsSearchActivity.f0(goodStuffAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        UnionGoodsSearchVM mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f9338a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        mViewModel.o(this, stateLayout, goodStuffAdapter, false);
        BaseStateRequestModel.n(getMViewModel(), this, goodStuffAdapter, false, 4, null);
        mutableLiveDataB.setValue(goodStuffAdapter);
    }

    public final void g0() {
        getMBinding().f9339a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.home.page.union_search.UnionGoodsSearchActivity$initSearchView$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                this.this$0.i0(str);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_union_goods_search;
    }

    public final void h0() {
        e eVarP3 = e.p3(this);
        int i = R.color.white;
        eVarP3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    public final void i0(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        getMViewModel().C().setValue(text);
        getMViewModel().r().setValue(4);
        getMViewModel().y();
        String strC0 = c0();
        if (!(strC0 == null || strC0.length() == 0)) {
            TasksUtil tasksUtil = TasksUtil.f34372a;
            String strC1 = c0();
            Intrinsics.checkNotNull(strC1);
            TasksUtil.k(tasksUtil, strC1, null, 2, null);
        }
        kq5.b(this, MobClickConstants.k, MapsKt.mapOf(TuplesKt.to("keyword", text)));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        g0();
        d0();
        h0();
    }
}
