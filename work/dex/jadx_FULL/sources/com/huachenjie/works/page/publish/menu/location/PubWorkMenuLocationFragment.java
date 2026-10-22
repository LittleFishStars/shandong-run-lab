package com.huachenjie.works.page.publish.menu.location;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.utils.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.adapter.publish.PubWorkMenuLocationAdapter;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.lj0;
import com.zj.adlib.qa4;
import com.zj.adlib.y57;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R2\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R#\u0010*\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010)R#\u0010/\u001a\n &*\u0004\u0018\u00010+0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationModel;", "", "initSelectedAddress", "initAdapter", "queryLocation", "", "pageNum", "searchNearby", "initView", "", "content", "searchContentChanged", "onDestroyView", "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "selectCallback", "Lkotlin/jvm/functions/Function1;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/LinearLayout;", "llSelected$delegate", "Lkotlin/Lazy;", "getLlSelected", "()Landroid/widget/LinearLayout;", "llSelected", "Lcom/baidu/mapapi/model/LatLng;", "latLng", "Lcom/baidu/mapapi/model/LatLng;", "city", "Ljava/lang/String;", "contentType", "I", "poiSearchNum", "Lcom/baidu/mapapi/search/poi/PoiSearch;", "kotlin.jvm.PlatformType", "poiSearch$delegate", "getPoiSearch", "()Lcom/baidu/mapapi/search/poi/PoiSearch;", "poiSearch", "Lcom/baidu/mapapi/search/sug/SuggestionSearch;", "suggestionSearch$delegate", "getSuggestionSearch", "()Lcom/baidu/mapapi/search/sug/SuggestionSearch;", "suggestionSearch", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPubWorkMenuLocationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMenuLocationFragment.kt\ncom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,221:1\n1#2:222\n*E\n"})
public final class PubWorkMenuLocationFragment extends BasePubWorkMenuFragment<PubWorkMenuLocationModel> {

    @NotNull
    private static final String BEAN_KEY = "bean";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int TYPE_AROUND = 0;
    private static final int TYPE_SEARCH = 1;
    private int contentType;

    @Nullable
    private LatLng latLng;
    private int poiSearchNum;

    @Nullable
    private Function1<? super PubWorkLocationItemBean, Unit> selectCallback;

    /* JADX INFO: renamed from: llSelected$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy llSelected = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment$llSelected$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LinearLayout m954invoke() {
            return (LinearLayout) this.this$0.insertViewToPlaceholder1(R.layout.works_view_pub_work_menu_address_selected);
        }
    });

    @NotNull
    private String city = "";

    /* JADX INFO: renamed from: poiSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy poiSearch = LazyKt.lazy(new Function0<PoiSearch>() { // from class: com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment$poiSearch$2

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0017J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$poiSearch$2$a", "Lcom/baidu/mapapi/search/poi/OnGetPoiSearchResultListener;", "Lcom/baidu/mapapi/search/poi/PoiResult;", bo.g, "", "onGetPoiResult", "Lcom/baidu/mapapi/search/poi/PoiDetailResult;", "onGetPoiDetailResult", "Lcom/baidu/mapapi/search/poi/PoiDetailSearchResult;", "Lcom/baidu/mapapi/search/poi/PoiIndoorResult;", "onGetPoiIndoorResult", "works_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nPubWorkMenuLocationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMenuLocationFragment.kt\ncom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$poiSearch$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,221:1\n1549#2:222\n1620#2,3:223\n*S KotlinDebug\n*F\n+ 1 PubWorkMenuLocationFragment.kt\ncom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$poiSearch$2$1$1\n*L\n76#1:222\n76#1:223,3\n*E\n"})
        public static final class a implements OnGetPoiSearchResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PubWorkMenuLocationFragment f37304a;

            public a(PubWorkMenuLocationFragment pubWorkMenuLocationFragment) {
                this.f37304a = pubWorkMenuLocationFragment;
            }

            @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
            @Deprecated(message = "Deprecated in Java")
            public void onGetPoiDetailResult(@Nullable PoiDetailResult p0) {
            }

            @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
            public void onGetPoiDetailResult(@Nullable PoiDetailSearchResult p0) {
            }

            @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
            public void onGetPoiIndoorResult(@Nullable PoiIndoorResult p0) {
            }

            @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
            public void onGetPoiResult(@Nullable PoiResult p0) {
                ArrayList arrayList;
                BaseLoadMoreModule loadMoreModule;
                BaseLoadMoreModule loadMoreModule2;
                List<PoiInfo> allPoi;
                String string;
                String string2;
                if (this.f37304a.contentType != 0) {
                    return;
                }
                if (p0 == null || (allPoi = p0.getAllPoi()) == null) {
                    arrayList = null;
                } else {
                    List<PoiInfo> list = allPoi;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (PoiInfo poiInfo : list) {
                        String str = poiInfo.city;
                        String str2 = poiInfo.name;
                        LatLng latLng = poiInfo.location;
                        String str3 = "";
                        if (latLng == null || (string = Double.valueOf(latLng.latitude).toString()) == null) {
                            string = "";
                        }
                        LatLng latLng2 = poiInfo.location;
                        if (latLng2 != null && (string2 = Double.valueOf(latLng2.longitude).toString()) != null) {
                            str3 = string2;
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "city");
                        Intrinsics.checkNotNullExpressionValue(str2, "name");
                        arrayList.add(new PubWorkLocationItemBean(str, str2, str3, string));
                    }
                }
                PubWorkMenuLocationAdapter pubWorkMenuLocationAdapter = (PubWorkMenuLocationAdapter) PubWorkMenuLocationFragment.access$getMViewModel(this.f37304a).B().getValue();
                ArrayList arrayList2 = arrayList;
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    this.f37304a.poiSearchNum = p0.getCurrentPageNum();
                    if (p0.getCurrentPageNum() == 0) {
                        if (pubWorkMenuLocationAdapter != null) {
                            pubWorkMenuLocationAdapter.setList(arrayList);
                        }
                    } else if (pubWorkMenuLocationAdapter != null) {
                        pubWorkMenuLocationAdapter.addData((Collection) arrayList);
                    }
                    if (pubWorkMenuLocationAdapter != null && (loadMoreModule = pubWorkMenuLocationAdapter.getLoadMoreModule()) != null) {
                        loadMoreModule.loadMoreComplete();
                    }
                } else if (pubWorkMenuLocationAdapter != null && (loadMoreModule2 = pubWorkMenuLocationAdapter.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule2, false, 1, null);
                }
                this.f37304a.hideLoading();
            }
        }

        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PoiSearch m955invoke() {
            PoiSearch poiSearchNewInstance = PoiSearch.newInstance();
            poiSearchNewInstance.setOnGetPoiSearchResultListener(new a(this.this$0));
            return poiSearchNewInstance;
        }
    });

    /* JADX INFO: renamed from: suggestionSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy suggestionSearch = LazyKt.lazy(new Function0<SuggestionSearch>() { // from class: com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment$suggestionSearch$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$suggestionSearch$2$a", "Lcom/baidu/mapapi/search/sug/OnGetSuggestionResultListener;", "Lcom/baidu/mapapi/search/sug/SuggestionResult;", bo.g, "", "onGetSuggestionResult", "works_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nPubWorkMenuLocationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMenuLocationFragment.kt\ncom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$suggestionSearch$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,221:1\n1549#2:222\n1620#2,3:223\n*S KotlinDebug\n*F\n+ 1 PubWorkMenuLocationFragment.kt\ncom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$suggestionSearch$2$1$1\n*L\n116#1:222\n116#1:223,3\n*E\n"})
        public static final class a implements OnGetSuggestionResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PubWorkMenuLocationFragment f37305a;

            public a(PubWorkMenuLocationFragment pubWorkMenuLocationFragment) {
                this.f37305a = pubWorkMenuLocationFragment;
            }

            @Override // com.baidu.mapapi.search.sug.OnGetSuggestionResultListener
            public void onGetSuggestionResult(@Nullable SuggestionResult p0) {
                ArrayList arrayList;
                List<SuggestionResult.SuggestionInfo> allSuggestions;
                String string;
                String string2;
                if (this.f37305a.contentType != 1) {
                    return;
                }
                BasePubWorkMenuAdapter<?, ?> value = PubWorkMenuLocationFragment.access$getMViewModel(this.f37305a).B().getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.huachenjie.works.adapter.publish.PubWorkMenuLocationAdapter");
                PubWorkMenuLocationAdapter pubWorkMenuLocationAdapter = (PubWorkMenuLocationAdapter) value;
                if (p0 == null || (allSuggestions = p0.getAllSuggestions()) == null) {
                    arrayList = null;
                } else {
                    List<SuggestionResult.SuggestionInfo> list = allSuggestions;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (SuggestionResult.SuggestionInfo suggestionInfo : list) {
                        String str = suggestionInfo.city;
                        String str2 = suggestionInfo.key;
                        LatLng latLng = suggestionInfo.pt;
                        String str3 = "";
                        if (latLng == null || (string = Double.valueOf(latLng.latitude).toString()) == null) {
                            string = "";
                        }
                        LatLng latLng2 = suggestionInfo.pt;
                        if (latLng2 != null && (string2 = Double.valueOf(latLng2.longitude).toString()) != null) {
                            str3 = string2;
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "city");
                        Intrinsics.checkNotNullExpressionValue(str2, CachedContentIndex.a.e);
                        arrayList.add(new PubWorkLocationItemBean(str, str2, str3, string));
                    }
                }
                pubWorkMenuLocationAdapter.setList(arrayList);
                BaseLoadMoreModule.loadMoreEnd$default(pubWorkMenuLocationAdapter.getLoadMoreModule(), false, 1, null);
            }
        }

        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SuggestionSearch m956invoke() {
            SuggestionSearch suggestionSearchNewInstance = SuggestionSearch.newInstance();
            suggestionSearchNewInstance.setOnGetSuggestionResultListener(new a(this.this$0));
            return suggestionSearchNewInstance;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment$a;", "", "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "bean", "Lcom/huachenjie/works/page/publish/menu/location/PubWorkMenuLocationFragment;", "a", "", "BEAN_KEY", "Ljava/lang/String;", "", "TYPE_AROUND", "I", "TYPE_SEARCH", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PubWorkMenuLocationFragment a(@Nullable PubWorkLocationItemBean bean) {
            PubWorkMenuLocationFragment pubWorkMenuLocationFragment = new PubWorkMenuLocationFragment();
            if (bean == null) {
                return pubWorkMenuLocationFragment;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("bean", bean);
            pubWorkMenuLocationFragment.setArguments(bundle);
            return pubWorkMenuLocationFragment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PubWorkMenuLocationModel access$getMViewModel(PubWorkMenuLocationFragment pubWorkMenuLocationFragment) {
        return (PubWorkMenuLocationModel) pubWorkMenuLocationFragment.getMViewModel();
    }

    private final LinearLayout getLlSelected() {
        return (LinearLayout) this.llSelected.getValue();
    }

    private final PoiSearch getPoiSearch() {
        return (PoiSearch) this.poiSearch.getValue();
    }

    private final SuggestionSearch getSuggestionSearch() {
        return (SuggestionSearch) this.suggestionSearch.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB = ((PubWorkMenuLocationModel) getMViewModel()).B();
        final PubWorkMenuLocationAdapter pubWorkMenuLocationAdapter = new PubWorkMenuLocationAdapter();
        y57.d(pubWorkMenuLocationAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.v27
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PubWorkMenuLocationFragment.initAdapter$lambda$6$lambda$4(this.f20169a, pubWorkMenuLocationAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        pubWorkMenuLocationAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.w27
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PubWorkMenuLocationFragment.initAdapter$lambda$6$lambda$5(this.f45512a);
            }
        });
        mutableLiveDataB.setValue(pubWorkMenuLocationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$4(PubWorkMenuLocationFragment pubWorkMenuLocationFragment, PubWorkMenuLocationAdapter pubWorkMenuLocationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationFragment, "this$0");
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Function1<? super PubWorkLocationItemBean, Unit> function1 = pubWorkMenuLocationFragment.selectCallback;
        if (function1 != null) {
            function1.invoke(pubWorkMenuLocationAdapter.getData().get(i));
        }
        pubWorkMenuLocationFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$5(PubWorkMenuLocationFragment pubWorkMenuLocationFragment) {
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationFragment, "this$0");
        pubWorkMenuLocationFragment.contentType = 0;
        pubWorkMenuLocationFragment.searchNearby(pubWorkMenuLocationFragment.poiSearchNum + 1);
    }

    private final void initSelectedAddress() {
        PubWorkLocationItemBean pubWorkLocationItemBean;
        Bundle arguments = getArguments();
        if (arguments == null || (pubWorkLocationItemBean = (PubWorkLocationItemBean) arguments.getParcelable("bean")) == null) {
            return;
        }
        ((TextView) getLlSelected().findViewById(R.id.tv_selected)).setText(getString(R.string.works_publish_work_works_selected, pubWorkLocationItemBean.getSubName()));
        ((TextView) getLlSelected().findViewById(R.id.bt_clear)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.u27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PubWorkMenuLocationFragment.initSelectedAddress$lambda$2$lambda$1(this.f45050a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSelectedAddress$lambda$2$lambda$1(PubWorkMenuLocationFragment pubWorkMenuLocationFragment, View view) {
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationFragment, "this$0");
        Function1<? super PubWorkLocationItemBean, Unit> function1 = pubWorkMenuLocationFragment.selectCallback;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
        pubWorkMenuLocationFragment.getLlSelected().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$0(PubWorkMenuLocationFragment pubWorkMenuLocationFragment) {
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationFragment, "this$0");
        EditText etSearch = pubWorkMenuLocationFragment.getEtSearch();
        if (etSearch != null) {
            etSearch.requestFocus();
        }
        qa4.c(pubWorkMenuLocationFragment.getEtSearch());
        return false;
    }

    private final void queryLocation() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        lj0.p(fragmentActivityRequireActivity, true, null, new HCJLocationListener() { // from class: com.zj.adlib.x27
            public final void onLocationListener(int i, HCJAddressInfo hCJAddressInfo) {
                PubWorkMenuLocationFragment.queryLocation$lambda$7(this.f45737a, i, hCJAddressInfo);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryLocation$lambda$7(PubWorkMenuLocationFragment pubWorkMenuLocationFragment, int i, HCJAddressInfo hCJAddressInfo) {
        Intrinsics.checkNotNullParameter(pubWorkMenuLocationFragment, "this$0");
        if (i != 0 || hCJAddressInfo == null) {
            return;
        }
        pubWorkMenuLocationFragment.latLng = new LatLng(hCJAddressInfo.getLat(), hCJAddressInfo.getLng());
        String cityName = hCJAddressInfo.getCityName();
        Intrinsics.checkNotNullExpressionValue(cityName, "hcjAddressInfo.cityName");
        pubWorkMenuLocationFragment.city = cityName;
        pubWorkMenuLocationFragment.searchNearby(0);
    }

    private final void searchNearby(int pageNum) {
        if (this.latLng == null) {
            return;
        }
        PoiSearch poiSearch = getPoiSearch();
        PoiNearbySearchOption poiNearbySearchOption = new PoiNearbySearchOption();
        poiNearbySearchOption.keyword("住宅区$教育培训$美食$酒店$购物$生活服务$旅游景点$医疗$交通设施$公司企业");
        poiNearbySearchOption.sortType(PoiSortType.distance_from_near_to_far);
        poiNearbySearchOption.pageNum(pageNum);
        poiNearbySearchOption.pageCapacity(20);
        poiNearbySearchOption.radius(2000);
        poiNearbySearchOption.radiusLimit(false);
        poiNearbySearchOption.location(this.latLng);
        poiSearch.searchNearby(poiNearbySearchOption);
    }

    @Nullable
    public final Function1<PubWorkLocationItemBean, Unit> getSelectCallback() {
        return this.selectCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((PubWorkMenuLocationModel) getMViewModel()).D().setValue(getString(R.string.works_publish_work_menu_location));
        ((PubWorkMenuLocationModel) getMViewModel()).G().setValue(Integer.valueOf(R.drawable.works_ic_publish_location));
        ((PubWorkMenuLocationModel) getMViewModel()).F().setValue(getString(R.string.works_publish_work_menu_location_hint));
        initSelectedAddress();
        initAdapter();
        showLoading();
        queryLocation();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.zj.adlib.y27
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return PubWorkMenuLocationFragment.initView$lambda$0(this.f45945a);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        getPoiSearch().destroy();
        getSuggestionSearch().destroy();
        super.onDestroyView();
    }

    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void searchContentChanged(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(this.city)) {
            return;
        }
        if (content.length() == 0) {
            this.contentType = 0;
            searchNearby(0);
            return;
        }
        this.contentType = 1;
        SuggestionSearch suggestionSearch = getSuggestionSearch();
        SuggestionSearchOption suggestionSearchOption = new SuggestionSearchOption();
        suggestionSearchOption.city(this.city);
        suggestionSearchOption.citylimit(Boolean.FALSE);
        suggestionSearchOption.keyword(content);
        suggestionSearch.requestSuggestion(suggestionSearchOption);
    }

    public final void setSelectCallback(@Nullable Function1<? super PubWorkLocationItemBean, Unit> function1) {
        this.selectCallback = function1;
    }
}
