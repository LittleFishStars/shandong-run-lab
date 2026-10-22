package com.huachenjie.works.page.channel.list;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.R;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.page.channel.list.AllChannelListVM;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000e0\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huachenjie/works/page/channel/list/AllChannelListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "t", "r", "s", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/works/external/adapter/AllChannelListAdapter;", "b", "n", "adapter", "", "K", "I", "pageNum", "", "f", "Ljava/lang/String;", "refreshTime", "c", j.b, "u", "(Landroidx/lifecycle/MutableLiveData;)V", "channelNo", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AllChannelListVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AllChannelListAdapter> adapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> channelNo;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    public AllChannelListVM() {
        MutableLiveData<AllChannelListAdapter> mutableLiveData = new MutableLiveData<>(new AllChannelListAdapter());
        this.adapter = mutableLiveData;
        this.pageNum = 1;
        this.channelNo = new MutableLiveData<>();
        AllChannelListAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.o(R.layout.layout_empty_channel_list);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.n40
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    AllChannelListVM.q(this.f43440a);
                }
            });
        }
    }

    public static final void q(AllChannelListVM allChannelListVM) {
        Intrinsics.checkNotNullParameter(allChannelListVM, "this$0");
        allChannelListVM.r();
    }

    @NotNull
    public final MutableLiveData<AllChannelListAdapter> n() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.channelNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.isRefreshing;
    }

    public final void r() {
        this.pageNum++;
        s();
    }

    public final void s() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.channel.list.AllChannelListVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.pageNum == 1) {
                    this.this$0.p().setValue(Boolean.FALSE);
                    AllChannelListAdapter value = this.this$0.n().getValue();
                    if (value != null) {
                        value.p();
                    }
                    AllChannelListAdapter value2 = this.this$0.n().getValue();
                    if (value2 != null) {
                        value2.setList(CollectionsKt.emptyList());
                    }
                } else {
                    this.this$0.pageNum--;
                }
                AllChannelListAdapter value3 = this.this$0.n().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new AllChannelListVM$queryPageList$2(this, null), 11, null);
    }

    public final void t() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        s();
    }

    public final void u(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.channelNo = mutableLiveData;
    }
}
