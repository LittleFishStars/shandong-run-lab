package com.huachenjie.mall.page.home_tab.search;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.google.gson.Gson;
import com.gyf.immersionbar.e;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityMallSearchBinding;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.home_tab.search.MallSearchActivity;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.i4a;
import com.zj.adlib.qa4;
import com.zj.adlib.r90;
import com.zj.adlib.y57;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002,\u001cB\u0007¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0006\u0010\u001b\u001a\u00020\u0006R\u001b\u0010 \u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006-"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/search/MallSearchActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityMallSearchBinding;", "Lcom/huachenjie/mall/page/home_tab/search/MallSearchVM;", "", "isDarkFont", "", "A0", "v0", "", "text", "I0", "u0", "", "levelList", "showDelete", "B0", "z0", bo.g, "H0", "", "", "", "V", "getLayoutResID", "initView", "initData", "r0", "b", "Lkotlin/Lazy;", "q0", "()Ljava/lang/String;", "searchKey", "c", "y0", "()Z", MallSearchActivity.x, "", "Ljava/util/List;", "historyList", "d", "flowViewIdList", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMallSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallSearchActivity.kt\ncom/huachenjie/mall/page/home_tab/search/MallSearchActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,274:1\n1855#2,2:275\n1864#2,3:277\n1#3:280\n*S KotlinDebug\n*F\n+ 1 MallSearchActivity.kt\ncom/huachenjie/mall/page/home_tab/search/MallSearchActivity\n*L\n189#1:275,2\n196#1:277,3\n*E\n"})
public final class MallSearchActivity extends BaseMVVMActivity<MallActivityMallSearchBinding, MallSearchVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "keyword";

    @NotNull
    public static final String x = "isSearch";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy searchKey = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.home_tab.search.MallSearchActivity$searchKey$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("keyword");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy isSearch = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.home_tab.search.MallSearchActivity$isSearch$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m561invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(MallSearchActivity.x, false));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<String> historyList = new ArrayList();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> flowViewIdList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/search/MallSearchActivity$a;", "", "Landroid/view/View;", "view", "", "c", "b", "a", "<init>", "(Lcom/huachenjie/mall/page/home_tab/search/MallSearchActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MallSearchActivity.this.historyList.clear();
            MallSearchActivity.this.p0();
            MallSearchActivity mallSearchActivity = MallSearchActivity.this;
            mallSearchActivity.B0(mallSearchActivity.historyList, false);
            MallSearchActivity.k0(MallSearchActivity.this).n().setValue(Boolean.FALSE);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MallSearchActivity.k0(MallSearchActivity.this).n().setValue(Boolean.FALSE);
            MallSearchActivity mallSearchActivity = MallSearchActivity.this;
            mallSearchActivity.B0(mallSearchActivity.historyList, false);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MallSearchActivity.k0(MallSearchActivity.this).n().setValue(Boolean.TRUE);
            MallSearchActivity mallSearchActivity = MallSearchActivity.this;
            mallSearchActivity.B0(mallSearchActivity.historyList, true);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.home_tab.search.MallSearchActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/search/MallSearchActivity$b;", "", "Landroid/content/Context;", "context", "", "keyword", "", MallSearchActivity.x, "", "a", "KEY_SEARCH_IS_SEARCH", "Ljava/lang/String;", "KEY_SEARCH_KEYWORD", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            companion.a(context, str, z);
        }

        public final void a(@NotNull Context context, @Nullable String keyword, boolean isSearch) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) MallSearchActivity.class);
            if (!(keyword == null || keyword.length() == 0)) {
                intent.putExtra("keyword", keyword);
            }
            intent.putExtra(MallSearchActivity.x, isSearch);
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ void C0(MallSearchActivity mallSearchActivity, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        mallSearchActivity.B0(list, z);
    }

    public static final void D0(MallSearchActivity mallSearchActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$title");
        mallSearchActivity.getMBinding().f10269a.getEtSearch().setText(str);
        mallSearchActivity.getMViewModel().m().setValue(Boolean.FALSE);
        MallSearchVM mViewModel = mallSearchActivity.getMViewModel();
        if (mViewModel != null) {
            mViewModel.r(str);
        }
        mallSearchActivity.getMBinding().f10269a.getEtSearch().clearFocus();
        KeyboardUtils.k(mallSearchActivity.getMBinding().f10269a.getEtSearch());
    }

    public static final boolean E0(final MallSearchActivity mallSearchActivity, final ConstraintLayout constraintLayout, final View view, final Flow flow, View view2) {
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        Intrinsics.checkNotNullParameter(constraintLayout, "$constraintLayout");
        Intrinsics.checkNotNullParameter(flow, "$flow");
        ft1.o(mallSearchActivity, "是否删除该搜索记录", OptionsPickerHelper.e, "确认", new View.OnClickListener() { // from class: com.zj.adlib.v65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MallSearchActivity.F0(constraintLayout, view, flow, mallSearchActivity, view3);
            }
        });
        return true;
    }

    public static final void F0(ConstraintLayout constraintLayout, View view, Flow flow, MallSearchActivity mallSearchActivity, View view2) {
        Intrinsics.checkNotNullParameter(constraintLayout, "$constraintLayout");
        Intrinsics.checkNotNullParameter(flow, "$flow");
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        constraintLayout.removeView(view);
        flow.removeView(view);
        mallSearchActivity.flowViewIdList.remove(Integer.valueOf(view.getId()));
        TextView textView = (TextView) view.findViewById(R.id.tv_level);
        if (textView != null) {
            List<String> list = mallSearchActivity.historyList;
            TypeIntrinsics.asMutableCollection(list).remove(textView.getText());
        }
    }

    public static final void G0(ConstraintLayout constraintLayout, View view, Flow flow, MallSearchActivity mallSearchActivity, View view2) {
        Intrinsics.checkNotNullParameter(constraintLayout, "$constraintLayout");
        Intrinsics.checkNotNullParameter(flow, "$flow");
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        constraintLayout.removeView(view);
        flow.removeView(view);
        mallSearchActivity.flowViewIdList.remove(Integer.valueOf(view.getId()));
        TextView textView = (TextView) view.findViewById(R.id.tv_level);
        if (textView != null) {
            List<String> list = mallSearchActivity.historyList;
            TypeIntrinsics.asMutableCollection(list).remove(textView.getText());
        }
    }

    public static final /* synthetic */ MallSearchVM k0(MallSearchActivity mallSearchActivity) {
        return mallSearchActivity.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void s0(CommodityAdapter commodityAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commodityAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        GoodsDetailActivity.INSTANCE.a(baseQuickAdapter.getContext(), ((CommodityBean) commodityAdapter.getItem(i)).getGoodsNo());
    }

    public static final void t0(MallSearchActivity mallSearchActivity) {
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        mallSearchActivity.getMViewModel().p();
    }

    public static final void w0(CommonSearchView commonSearchView, MallSearchActivity mallSearchActivity, View view, boolean z) {
        Intrinsics.checkNotNullParameter(commonSearchView, "$searchView");
        Intrinsics.checkNotNullParameter(mallSearchActivity, "this$0");
        if (z) {
            Editable text = commonSearchView.getEtSearch().getText();
            if (text == null || text.length() == 0) {
                mallSearchActivity.getMViewModel().m().setValue(Boolean.TRUE);
                C0(mallSearchActivity, mallSearchActivity.historyList, false, 2, null);
            }
        }
    }

    public static final boolean x0(CommonSearchView commonSearchView, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(commonSearchView, "$searchView");
        if (i != 3) {
            return true;
        }
        commonSearchView.getSearchListener().invoke(textView.getText().toString());
        return true;
    }

    public final void A0(boolean isDarkFont) {
        e eVarP3 = e.p3(this);
        int i = com.huachenjie.works.R.color.white;
        eVarP3.G2(i).T2(isDarkFont).u1(i).G1(true).a1();
    }

    public final void B0(List<String> levelList, boolean showDelete) {
        final Flow flow;
        MallActivityMallSearchBinding mBinding;
        final ConstraintLayout constraintLayout;
        i4a.c("showHistory");
        i4a.c("levelList:" + levelList);
        MallActivityMallSearchBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (flow = mBinding2.f10266a) == null || (mBinding = getMBinding()) == null || (constraintLayout = mBinding.f10267a) == null) {
            return;
        }
        Iterator<T> it = this.flowViewIdList.iterator();
        while (it.hasNext()) {
            View viewFindViewById = constraintLayout.findViewById(((Number) it.next()).intValue());
            if (viewFindViewById != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(it)");
                constraintLayout.removeView(viewFindViewById);
                flow.removeView(viewFindViewById);
            }
        }
        this.flowViewIdList.clear();
        int i = 0;
        for (Object obj : levelList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final String str = (String) obj;
            final View viewInflate = LayoutInflater.from(constraintLayout.getContext()).inflate(R.layout.mall_layout_search_level, (ViewGroup) null);
            viewInflate.setId(View.generateViewId());
            if (showDelete) {
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_delete);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.y65
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MallSearchActivity.G0(constraintLayout, viewInflate, flow, this, view);
                    }
                });
            } else {
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_delete);
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.z65
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MallSearchActivity.D0(this.f46196a, str, view);
                    }
                });
                viewInflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.a75
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return MallSearchActivity.E0(this.f15168a, constraintLayout, viewInflate, flow, view);
                    }
                });
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_level);
            if (textView != null) {
                textView.setText(str);
            }
            this.flowViewIdList.add(Integer.valueOf(viewInflate.getId()));
            constraintLayout.addView(viewInflate);
            flow.addView(viewInflate);
            i = i2;
        }
    }

    public final void H0() {
        String strQ0 = q0();
        Intrinsics.checkNotNullExpressionValue(strQ0, "searchKey");
        if (!(strQ0.length() > 0)) {
            getMBinding().f10269a.getEtSearch().requestFocus();
            qa4.d(getMBinding().f10269a.getEtSearch(), 500L);
        } else if (!y0()) {
            getMBinding().f10269a.getEtSearch().setHint(q0());
            getMBinding().f10269a.getEtSearch().requestFocus();
            qa4.d(getMBinding().f10269a.getEtSearch(), 500L);
        } else {
            getMBinding().f10269a.getEtSearch().setText(q0());
            Function1<String, Unit> searchListener = getMBinding().f10269a.getSearchListener();
            String strQ1 = q0();
            Intrinsics.checkNotNullExpressionValue(strQ1, "searchKey");
            searchListener.invoke(strQ1);
        }
    }

    public final void I0(String text) {
        if (TextUtils.isEmpty(text)) {
            fv5.b("请输入正确关键词搜索");
            return;
        }
        z0(text);
        getMViewModel().m().setValue(Boolean.FALSE);
        getMViewModel().r(text);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_mall_search;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        u0();
        C0(this, this.historyList, false, 2, null);
        H0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        v0();
        r0();
        A0(true);
    }

    public final void p0() {
        r90.V(new Gson().toJson(this.historyList));
    }

    public final String q0() {
        return (String) this.searchKey.getValue();
    }

    public final void r0() {
        MallActivityMallSearchBinding mBinding = getMBinding();
        if (mBinding != null) {
            final CommodityAdapter commodityAdapter = new CommodityAdapter(0.0f, 0.0f, 0.0f, 7, null);
            y57.d(commodityAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.b75
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MallSearchActivity.s0(commodityAdapter, baseQuickAdapter, view, i);
                }
            }, 1, null);
            View viewInflate = LayoutInflater.from(mBinding.getRoot().getContext()).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            commodityAdapter.o(viewInflate);
            commodityAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.c75
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    MallSearchActivity.t0(this.f40913a);
                }
            });
            getMViewModel().i().setValue(commodityAdapter);
        }
    }

    public final void u0() {
        String[] strArr = (String[]) new Gson().fromJson(r90.r(), String[].class);
        this.historyList.clear();
        if (strArr != null) {
            if (strArr.length == 0) {
                return;
            }
            CollectionsKt.addAll(this.historyList, strArr);
        }
    }

    public final void v0() {
        final CommonSearchView commonSearchView;
        MallActivityMallSearchBinding mBinding = getMBinding();
        if (mBinding == null || (commonSearchView = mBinding.f10269a) == null) {
            return;
        }
        commonSearchView.setClearListener(new Function0<Unit>() { // from class: com.huachenjie.mall.page.home_tab.search.MallSearchActivity$initSearchView$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m560invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m560invoke() {
                MallSearchActivity.k0(this.this$0).m().setValue(Boolean.TRUE);
                MallSearchActivity mallSearchActivity = this.this$0;
                MallSearchActivity.C0(mallSearchActivity, mallSearchActivity.historyList, false, 2, null);
            }
        });
        commonSearchView.getEtSearch().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.zj.adlib.w65
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                MallSearchActivity.w0(commonSearchView, this, view, z);
            }
        });
        commonSearchView.getEtSearch().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.x65
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return MallSearchActivity.x0(commonSearchView, textView, i, keyEvent);
            }
        });
        commonSearchView.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.home_tab.search.MallSearchActivity$initSearchView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x006b  */
            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                if (str.length() == 0) {
                    String strQ0 = this.this$0.q0();
                    Intrinsics.checkNotNullExpressionValue(strQ0, "searchKey");
                    if (!(strQ0.length() > 0) || this.this$0.y0()) {
                        this.this$0.I0(str);
                    } else {
                        String string = this.this$0.getMBinding().f10269a.getEtSearch().getHint().toString();
                        this.this$0.getMBinding().f10269a.getEtSearch().setText(string);
                        this.this$0.getMBinding().f10269a.getEtSearch().setSelection(string.length());
                        this.this$0.I0(string);
                    }
                } else {
                    this.this$0.I0(str);
                }
                commonSearchView.getEtSearch().clearFocus();
                KeyboardUtils.k(commonSearchView.getEtSearch());
            }
        });
    }

    public final boolean y0() {
        return ((Boolean) this.isSearch.getValue()).booleanValue();
    }

    public final void z0(String text) {
        Object next;
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Iterator<T> it = this.historyList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!TextUtils.equals((String) next, text));
        String str = (String) next;
        if (str != null) {
            this.historyList.remove(str);
        }
        this.historyList.add(0, text);
        while (this.historyList.size() > 20) {
            CollectionsKt.removeLast(this.historyList);
        }
        r90.V(new Gson().toJson(this.historyList));
    }
}
