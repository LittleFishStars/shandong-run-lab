package com.huachenjie.works.page.alumni.channel;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.R;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.page.alumni.channel.AlumniChannelVM;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001b0\u001b0\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\t8\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR%\u0010%\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00150\u00150\t8\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b&\u0010\u000f¨\u0006*"}, d2 = {"Lcom/huachenjie/works/page/alumni/channel/AlumniChannelVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "x", "", "refreshTime", "v", "u", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "b", "s", "isRefreshing", "", "K", "I", "pageNum", "f", "Ljava/lang/String;", "Lcom/huachenjie/works/external/adapter/AllChannelListAdapter;", "c", j.b, "channelAdapter", "", "d", "p", "headerImageUrl", "e", "r", "verticalOffset", "q", "startLoadNativeAd", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AlumniChannelVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorksAdapter> adapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AllChannelListAdapter> channelAdapter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Object> headerImageUrl;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> verticalOffset;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> startLoadNativeAd;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String refreshTime;

    public AlumniChannelVM() {
        MutableLiveData<WorksAdapter> mutableLiveData = new MutableLiveData<>(new WorksAdapter(true, false, true, 2, null));
        this.adapter = mutableLiveData;
        this.isRefreshing = new MutableLiveData<>(Boolean.FALSE);
        this.pageNum = 1;
        this.refreshTime = "";
        this.channelAdapter = new MutableLiveData<>(new AllChannelListAdapter());
        this.headerImageUrl = new MutableLiveData<>(Integer.valueOf(R.drawable.works_ic_channel_header_empty));
        this.verticalOffset = new MutableLiveData<>(0);
        this.startLoadNativeAd = new MutableLiveData<>();
        WorksAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.e50
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    AlumniChannelVM.t(this.f41347a);
                }
            });
        }
    }

    public static final void t(AlumniChannelVM alumniChannelVM) {
        Intrinsics.checkNotNullParameter(alumniChannelVM, "this$0");
        alumniChannelVM.u();
    }

    @NotNull
    public final MutableLiveData<WorksAdapter> n() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<AllChannelListAdapter> o() {
        return this.channelAdapter;
    }

    @NotNull
    public final MutableLiveData<Object> p() {
        return this.headerImageUrl;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.startLoadNativeAd;
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return this.verticalOffset;
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return this.isRefreshing;
    }

    public final void u() {
        this.pageNum++;
        w();
    }

    public final void v(@NotNull String refreshTime) {
        Intrinsics.checkNotNullParameter(refreshTime, "refreshTime");
        BaseViewModelExtKt.b(this, false, false, null, null, new AlumniChannelVM$queryAlumniChannelList$1(refreshTime, this, null), 15, null);
    }

    public final void w() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.channel.AlumniChannelVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.pageNum == 1) {
                    this.this$0.s().setValue(Boolean.FALSE);
                    WorksAdapter value = this.this$0.n().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    WorksAdapter value2 = this.this$0.n().getValue();
                    if (value2 != null) {
                        value2.r();
                    }
                } else {
                    this.this$0.pageNum--;
                }
                WorksAdapter value3 = this.this$0.n().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new AlumniChannelVM$queryPageList$2(this, null), 11, null);
    }

    public final void x() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = String.valueOf(System.currentTimeMillis());
        w();
        v(this.refreshTime);
    }
}
