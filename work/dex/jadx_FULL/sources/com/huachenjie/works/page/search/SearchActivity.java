package com.huachenjie.works.page.search;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksActivitySearchBinding;
import com.huachenjie.works.page.search.SearchActivity;
import com.huachenjie.works.page.search.fast_lenovo.SearchFastLenovoFragment;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment;
import com.huachenjie.works.page.search.result.SearchResultFragment;
import com.igexin.push.g.o;
import com.zj.adlib.kq5;
import com.zj.adlib.qa4;
import com.zj.adlib.qk0;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0007¢\u0006\u0004\b.\u0010/J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/huachenjie/works/page/search/SearchActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivitySearchBinding;", "Lcom/huachenjie/works/page/search/SearchVM;", "", "", "", "V", "getLayoutResID", "", "initView", "", "content", "", "saveHistory", "k0", "fragmentTag", "Landroidx/fragment/app/Fragment;", "fragment", "j0", "Lcom/huachenjie/common/widget/CommonSearchViewV2;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "h0", "()Lcom/huachenjie/common/widget/CommonSearchViewV2;", "searchView", "Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment;", "c", "e0", "()Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment;", SearchActivity.t, "Lcom/huachenjie/works/page/search/fast_lenovo/SearchFastLenovoFragment;", "d", "d0", "()Lcom/huachenjie/works/page/search/fast_lenovo/SearchFastLenovoFragment;", SearchActivity.x, "Lcom/huachenjie/works/page/search/result/SearchResultFragment;", "e", "f0", "()Lcom/huachenjie/works/page/search/result/SearchResultFragment;", SearchActivity.y, "f", "g0", "()Ljava/lang/String;", "searchKey", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchActivity.kt\ncom/huachenjie/works/page/search/SearchActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n65#2,16:154\n93#2,3:170\n1855#3,2:173\n*S KotlinDebug\n*F\n+ 1 SearchActivity.kt\ncom/huachenjie/works/page/search/SearchActivity\n*L\n77#1:154,16\n77#1:170,3\n113#1:173,2\n*E\n"})
public final class SearchActivity extends BaseMVVMActivity<WorksActivitySearchBinding, SearchVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "hotSpotFragment";

    @NotNull
    public static final String x = "fastLenovoFragment";

    @NotNull
    public static final String y = "resultFragment";

    @NotNull
    public static final String z = "keyword";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy searchView = LazyKt.lazy(new Function0<CommonSearchViewV2>() { // from class: com.huachenjie.works.page.search.SearchActivity$searchView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CommonSearchViewV2 m965invoke() {
            return (CommonSearchViewV2) this.this$0.findViewById(R.id.search_view);
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy hotSpotFragment = LazyKt.lazy(new Function0<SearchHotSpotFragment>() { // from class: com.huachenjie.works.page.search.SearchActivity$hotSpotFragment$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SearchHotSpotFragment m962invoke() {
            SearchHotSpotFragment searchHotSpotFragment = new SearchHotSpotFragment();
            final SearchActivity searchActivity = this.this$0;
            searchHotSpotFragment.setClickHistoryCallback(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.search.SearchActivity$hotSpotFragment$2$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    searchActivity.k0(str, false);
                }
            });
            return searchHotSpotFragment;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy fastLenovoFragment = LazyKt.lazy(new Function0<SearchFastLenovoFragment>() { // from class: com.huachenjie.works.page.search.SearchActivity$fastLenovoFragment$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SearchFastLenovoFragment m961invoke() {
            return new SearchFastLenovoFragment();
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy resultFragment = LazyKt.lazy(new Function0<SearchResultFragment>() { // from class: com.huachenjie.works.page.search.SearchActivity$resultFragment$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SearchResultFragment m963invoke() {
            return new SearchResultFragment();
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy searchKey = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.search.SearchActivity$searchKey$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("keyword");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.search.SearchActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/search/SearchActivity$a;", "", "Landroid/content/Context;", "context", "", "keyword", "", "a", "FRAGMENT_TAG_FAST_LENOVO", "Ljava/lang/String;", "FRAGMENT_TAG_HOT_SPOT", "FRAGMENT_TAG_RESULT", "KEY_SEARCH_KEYWORD", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
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

        public final void a(@NotNull Context context, @Nullable String keyword) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) SearchActivity.class);
            intent.putExtra("keyword", keyword);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 SearchActivity.kt\ncom/huachenjie/works/page/search/SearchActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n78#2,7:98\n71#3:105\n77#4:106\n*E\n"})
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            if (s == null || s.length() == 0) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.j0(SearchActivity.t, searchActivity.e0());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    public static final void i0(SearchActivity searchActivity, View view, boolean z2) {
        Intrinsics.checkNotNullParameter(searchActivity, "this$0");
        if (z2) {
            Editable text = searchActivity.h0().getEtSearch().getText();
            if (text == null || text.length() == 0) {
                searchActivity.j0(t, searchActivity.e0());
            }
        }
    }

    public static /* synthetic */ void l0(SearchActivity searchActivity, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        searchActivity.k0(str, z2);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    public final SearchFastLenovoFragment d0() {
        return (SearchFastLenovoFragment) this.fastLenovoFragment.getValue();
    }

    public final SearchHotSpotFragment e0() {
        return (SearchHotSpotFragment) this.hotSpotFragment.getValue();
    }

    public final SearchResultFragment f0() {
        return (SearchResultFragment) this.resultFragment.getValue();
    }

    public final String g0() {
        return (String) this.searchKey.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_search;
    }

    public final CommonSearchViewV2 h0() {
        return (CommonSearchViewV2) this.searchView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        h0().getEtSearch().addTextChangedListener(new b());
        String strG0 = g0();
        Intrinsics.checkNotNullExpressionValue(strG0, "searchKey");
        if (strG0.length() > 0) {
            getMBinding().f13941a.getEtSearch().setHint(g0());
        }
        h0().getEtSearch().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.zj.adlib.mx7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                SearchActivity.i0(this.f43407a, view, z2);
            }
        });
        h0().setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.search.SearchActivity.initView.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                SearchActivity searchActivity = SearchActivity.this;
                if (str.length() == 0) {
                    str = SearchActivity.this.g0();
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (it.isEmpty()) searchKey else it");
                SearchActivity.l0(searchActivity, str, false, 2, null);
            }
        });
        j0(t, e0());
    }

    public final void j0(String fragmentTag, Fragment fragment) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (Fragment fragment2 : fragments) {
            if (fragment2 != null && !Intrinsics.areEqual(fragment2, fragmentFindFragmentByTag)) {
                fragmentTransactionBeginTransaction.hide(fragment2);
            }
        }
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.show(fragment);
        } else {
            fragmentTransactionBeginTransaction.add(R.id.fl_container, fragment, fragmentTag);
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    public final void k0(@NotNull String content, boolean saveHistory) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (content.length() == 0) {
            j0(t, e0());
        } else {
            h0().getEtSearch().setText(content);
            SearchResultFragment searchResultFragmentF0 = f0();
            searchResultFragmentF0.searchContent(content);
            Unit unit = Unit.INSTANCE;
            j0(y, searchResultFragmentF0);
            if (saveHistory) {
                e0().saveSearchHistory(content);
            }
            kq5.b(this, MobClickConstants.j, MapsKt.mapOf(TuplesKt.to("keyword", content)));
        }
        h0().getEtSearch().clearFocus();
        qa4.b(h0().getEtSearch());
    }
}
