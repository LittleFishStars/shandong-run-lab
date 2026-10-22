package com.huachenjie.channel.page.channel_home;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.channel.page.channel_home.ChannelHomeVM;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.push.g.o;
import com.zj.adlib.wt1;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010?J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00128\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001e0\u00128\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R%\u0010$\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00128\u0006¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00128\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R%\u0010.\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010+0+0\u00128\u0006¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017R#\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0/8\u0006¢\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\b1\u00102R%\u00106\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010+0+0\u00128\u0006¢\u0006\f\n\u0004\b4\u0010\u0015\u001a\u0004\b5\u0010\u0017R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "position", "", "D", "B", "E", "", "", "contactIdList", "n", j.o, "A", "", "Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", GoodsSpecificationPreviewActivity.z, j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "w", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/channel/page/channel_home/ChannelHomeAdapter;", "kotlin.jvm.PlatformType", "b", "p", "adapter", "Lcom/huachenjie/base/adapter/BaseViewPager2Adapter;", "c", "x", "viewPagerAdapter", "d", "v", "selectPosition", "e", "s", "firstChannelList", "f", "u", "requestChannelList", "", y6b.f, "r", "createChannelCheckFlag", "", "Ljava/util/Map;", "q", "()Ljava/util/Map;", "channelMap", y6b.g, "y", "isRefreshing", "K", "I", "t", "()I", "C", "(I)V", "pageNum", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannelHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelHomeVM.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n1855#2,2:161\n1864#2,3:163\n*S KotlinDebug\n*F\n+ 1 ChannelHomeVM.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeVM\n*L\n146#1:161,2\n152#1:163,3\n*E\n"})
public final class ChannelHomeVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Map<String, String> channelMap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChannelHomeAdapter> adapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BaseViewPager2Adapter<ChannelHomeItemBean>> viewPagerAdapter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectPosition;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ChannelHomeItemBean>> firstChannelList;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ChannelHomeItemBean>> requestChannelList;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> createChannelCheckFlag;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    public ChannelHomeVM() {
        BaseLoadMoreModule loadMoreModule;
        MutableLiveData<ChannelHomeAdapter> mutableLiveData = new MutableLiveData<>(new ChannelHomeAdapter());
        this.adapter = mutableLiveData;
        this.viewPagerAdapter = new MutableLiveData<>();
        this.selectPosition = new MutableLiveData<>(0);
        this.firstChannelList = new MutableLiveData<>();
        this.requestChannelList = new MutableLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.createChannelCheckFlag = new MutableLiveData<>(bool);
        this.channelMap = new LinkedHashMap();
        ChannelHomeAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.hi1
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ChannelHomeVM.k(this.f42129a, baseQuickAdapter, view, i);
                }
            });
        }
        ChannelHomeAdapter value2 = mutableLiveData.getValue();
        if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
            loadMoreModule.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ii1
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    ChannelHomeVM.l(this.f42362a);
                }
            });
        }
        this.isRefreshing = new MutableLiveData<>(bool);
        this.pageNum = 1;
    }

    public static final void k(ChannelHomeVM channelHomeVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(channelHomeVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ChannelHomeAdapter value = channelHomeVM.adapter.getValue();
        if (value == null) {
            return;
        }
        value.e(value.getData().get(i));
        channelHomeVM.D(i);
    }

    public static final void l(ChannelHomeVM channelHomeVM) {
        Intrinsics.checkNotNullParameter(channelHomeVM, "this$0");
        channelHomeVM.z();
    }

    public final void A() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                MutableLiveData<Boolean> mutableLiveDataY = this.this$0.y();
                Boolean bool = Boolean.FALSE;
                mutableLiveDataY.setValue(bool);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.o(null);
                } else {
                    ChannelHomeVM channelHomeVM = this.this$0;
                    channelHomeVM.C(channelHomeVM.getPageNum() - 1);
                }
                ChannelHomeAdapter value = this.this$0.p().getValue();
                if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return bool;
            }
        }, null, new ChannelHomeVM$queryPageList$2(this, null), 11, null);
    }

    public final void B() {
        Boolean value = this.isRefreshing.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.isRefreshing.setValue(bool);
        this.pageNum = 1;
        A();
    }

    public final void C(int i) {
        this.pageNum = i;
    }

    public final void D(int position) {
        Integer value = this.selectPosition.getValue();
        if (value == null || value.intValue() != position) {
            BaseViewPager2Adapter<ChannelHomeItemBean> value2 = this.viewPagerAdapter.getValue();
            Fragment fragmentD = value2 != null ? value2.d(position) : null;
            MyChannelFragment myChannelFragment = fragmentD instanceof MyChannelFragment ? (MyChannelFragment) fragmentD : null;
            if (myChannelFragment != null) {
                myChannelFragment.updateRefresh();
                myChannelFragment.registerObserveContact();
            }
            Integer value3 = this.selectPosition.getValue();
            if (value3 != null) {
                BaseViewPager2Adapter<ChannelHomeItemBean> value4 = this.viewPagerAdapter.getValue();
                Fragment fragmentD2 = value4 != null ? value4.d(value3.intValue()) : null;
                MyChannelFragment myChannelFragment2 = fragmentD2 instanceof MyChannelFragment ? (MyChannelFragment) fragmentD2 : null;
                if (myChannelFragment2 != null) {
                    myChannelFragment2.unregisterObserveContact();
                }
            }
        }
        this.selectPosition.setValue(Integer.valueOf(position));
    }

    public final void E() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ChannelHomeVM$validCreateChannel$1(this, null), 14, null);
    }

    public final void n(@NotNull List<String> contactIdList) {
        ChannelHomeAdapter value;
        List<ChannelHomeItemBean> data;
        Intrinsics.checkNotNullParameter(contactIdList, "contactIdList");
        if (contactIdList.isEmpty() || (value = this.adapter.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = contactIdList.iterator();
        while (it.hasNext()) {
            String str = this.channelMap.get((String) it.next());
            if (!TextUtils.isEmpty(str) && !CollectionsKt.contains(arrayList, str)) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
        }
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) obj;
            if (arrayList.contains(channelHomeItemBean.getChannelNo())) {
                channelHomeItemBean.setUnreadCount(wt1.h().k().k(channelHomeItemBean.formatTeamIdList()));
                ChannelHomeAdapter value2 = this.adapter.getValue();
                if (value2 != null) {
                    value2.notifyItemChanged(i);
                }
            }
            i = i2;
        }
    }

    public final void o(List<ChannelHomeItemBean> list) {
        List<ChannelHomeItemBean> arrayList;
        if (list == null || (arrayList = CollectionsKt.toMutableList(list)) == null) {
            arrayList = new ArrayList<>();
        }
        ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) CollectionsKt.firstOrNull(arrayList);
        if (channelHomeItemBean != null) {
            channelHomeItemBean.setSelected(true);
        }
        this.firstChannelList.setValue(arrayList);
    }

    @NotNull
    public final MutableLiveData<ChannelHomeAdapter> p() {
        return this.adapter;
    }

    @NotNull
    public final Map<String, String> q() {
        return this.channelMap;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.createChannelCheckFlag;
    }

    @NotNull
    public final MutableLiveData<List<ChannelHomeItemBean>> s() {
        return this.firstChannelList;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MutableLiveData<List<ChannelHomeItemBean>> u() {
        return this.requestChannelList;
    }

    @NotNull
    public final MutableLiveData<Integer> v() {
        return this.selectPosition;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> w() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<BaseViewPager2Adapter<ChannelHomeItemBean>> x() {
        return this.viewPagerAdapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> y() {
        return this.isRefreshing;
    }

    public final void z() {
        Boolean value = this.isRefreshing.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.isRefreshing.setValue(bool);
        this.pageNum++;
        A();
    }
}
