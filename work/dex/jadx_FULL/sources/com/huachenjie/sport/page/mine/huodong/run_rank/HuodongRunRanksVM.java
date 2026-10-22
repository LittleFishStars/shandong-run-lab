package com.huachenjie.sport.page.mine.huodong.run_rank;

import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.RunRankBean;
import com.huachenjie.sport.bean.UserRunRankBean;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksVM;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010GJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000b0\u000b0\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u001b0\u001b0\u00148\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\"\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b\u0016\u0010)\"\u0004\b.\u0010+R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0006¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\b008\u0006¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\b008\u0006¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\b008\u0006¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u00103R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020>008\u0006¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u00103R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b008\u0006¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\bB\u00103R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0006¢\u0006\f\n\u0004\b-\u00101\u001a\u0004\bD\u00103¨\u0006H"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksVM;", "Lcom/huachenjie/common/base/data_binding/BaseTitleVM;", "", "A", "x", "y", "", "rankNumber", "Lcom/huachenjie/sport/bean/RunRankBean;", t.d, "Lcom/huachenjie/common/callback/ValueCallback;", "", RenderCallContext.TYPE_CALLBACK, j.o, "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "m", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "j", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksAdapter;", "k", "adapter", "K", "I", "p", "()I", "D", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "E", "(Ljava/lang/String;)V", "refreshTime", y6b.f, "C", "activityCode", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "q", "()Landroidx/lifecycle/MediatorLiveData;", "rankingType", "b", "s", "top1", "c", "t", "top2", "d", "u", "top3", "Lcom/huachenjie/sport/bean/UserRunRankBean;", "e", "n", "myRank", "w", "isShowMyRank", j.b, "mySex", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongRunRanksVM extends BaseTitleVM {

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HuodongRunRanksAdapter> adapter = new MutableLiveData<>(new HuodongRunRanksAdapter());

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: g, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String activityCode = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Integer> rankingType = new MediatorLiveData<>(2);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RunRankBean> top1 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RunRankBean> top2 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RunRankBean> top3 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<UserRunRankBean> myRank = new MediatorLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> isShowMyRank = new MediatorLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Integer> mySex = new MediatorLiveData<>();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/sport/bean/RunRankBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<PageEntity<RunRankBean>> {
        public a() {
            super(HuodongRunRanksVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            BaseLoadMoreModule loadMoreModule;
            super.onFailed(code, message);
            if (HuodongRunRanksVM.this.getPageNum() == 1) {
                HuodongRunRanksVM.this.v().setValue(Boolean.FALSE);
                HuodongRunRanksVM.this.s().setValue(HuodongRunRanksVM.this.l(1));
                HuodongRunRanksVM.this.t().setValue(HuodongRunRanksVM.this.l(2));
                HuodongRunRanksVM.this.u().setValue(HuodongRunRanksVM.this.l(3));
                HuodongRunRanksAdapter value = HuodongRunRanksVM.this.k().getValue();
                if (value != null) {
                    value.setList(null);
                }
            } else {
                HuodongRunRanksVM huodongRunRanksVM = HuodongRunRanksVM.this;
                huodongRunRanksVM.D(huodongRunRanksVM.getPageNum() - 1);
            }
            HuodongRunRanksAdapter value2 = HuodongRunRanksVM.this.k().getValue();
            if (value2 == null || (loadMoreModule = value2.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }

        public void onCCSuccess(@Nullable PageEntity<RunRankBean> data) {
            List list;
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            HuodongRunRanksVM.this.E(data != null ? data.getRefreshTime() : null);
            if (HuodongRunRanksVM.this.getPageNum() == 1) {
                HuodongRunRanksVM.this.v().setValue(Boolean.FALSE);
                if ((data != null ? data.getList() : null) == null || data.getList().isEmpty()) {
                    HuodongRunRanksVM.this.s().setValue(HuodongRunRanksVM.this.l(1));
                    HuodongRunRanksVM.this.t().setValue(HuodongRunRanksVM.this.l(2));
                    HuodongRunRanksVM.this.u().setValue(HuodongRunRanksVM.this.l(3));
                    HuodongRunRanksAdapter value = HuodongRunRanksVM.this.k().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                } else {
                    HuodongRunRanksVM.this.s().setValue(data.getList().get(0));
                    data.getList().remove(0);
                    List list2 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    if (!list2.isEmpty()) {
                        HuodongRunRanksVM.this.t().setValue(data.getList().get(0));
                        data.getList().remove(0);
                    } else {
                        HuodongRunRanksVM.this.t().setValue(HuodongRunRanksVM.this.l(2));
                    }
                    List list3 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                    if (!list3.isEmpty()) {
                        HuodongRunRanksVM.this.u().setValue(data.getList().get(0));
                        data.getList().remove(0);
                    } else {
                        HuodongRunRanksVM.this.u().setValue(HuodongRunRanksVM.this.l(3));
                    }
                    List list4 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "data.list");
                    if (!list4.isEmpty()) {
                        HuodongRunRanksAdapter value2 = HuodongRunRanksVM.this.k().getValue();
                        if (value2 != null) {
                            value2.setList(data.getList());
                        }
                    } else {
                        HuodongRunRanksAdapter value3 = HuodongRunRanksVM.this.k().getValue();
                        if (value3 != null) {
                            value3.setList(null);
                        }
                    }
                }
            } else {
                if ((data == null || (list = data.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                    HuodongRunRanksAdapter value4 = HuodongRunRanksVM.this.k().getValue();
                    if (value4 != null) {
                        List list5 = data.getList();
                        Intrinsics.checkNotNullExpressionValue(list5, "data.list");
                        value4.addData((Collection) list5);
                    }
                } else {
                    HuodongRunRanksVM huodongRunRanksVM = HuodongRunRanksVM.this;
                    huodongRunRanksVM.D(huodongRunRanksVM.getPageNum() - 1);
                }
            }
            if (data != null && data.getHasNext()) {
                HuodongRunRanksAdapter value5 = HuodongRunRanksVM.this.k().getValue();
                if (value5 == null || (loadMoreModule2 = value5.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            HuodongRunRanksAdapter value6 = HuodongRunRanksVM.this.k().getValue();
            if (value6 == null || (loadMoreModule = value6.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/UserRunRankBean;", "data", "", "onCCSuccess", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<UserRunRankBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback<Boolean> f36706a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ValueCallback<Boolean> valueCallback) {
            super(HuodongRunRanksVM.this, true);
            this.f36706a = valueCallback;
        }

        public void onFinish() {
            this.f36706a.onCallback(Boolean.TRUE);
        }

        public void onCCSuccess(@Nullable UserRunRankBean data) {
            MediatorLiveData<UserRunRankBean> mediatorLiveDataN = HuodongRunRanksVM.this.n();
            if (data == null) {
                data = new UserRunRankBean(0, 0, null, null, 0L, 31, null);
            }
            mediatorLiveDataN.setValue(data);
        }
    }

    public static final void B(HuodongRunRanksVM huodongRunRanksVM, Boolean bool) {
        Intrinsics.checkNotNullParameter(huodongRunRanksVM, "this$0");
        huodongRunRanksVM.y();
    }

    public final void A() {
        HuodongRunRanksAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(null);
        }
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        z(new ValueCallback() { // from class: com.zj.adlib.k34
            @Override // com.huachenjie.common.callback.ValueCallback
            public final void onCallback(Object obj) {
                HuodongRunRanksVM.B(this.f42733a, (Boolean) obj);
            }
        });
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityCode = str;
    }

    public final void D(int i) {
        this.pageNum = i;
    }

    public final void E(@Nullable String str) {
        this.refreshTime = str;
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getActivityCode() {
        return this.activityCode;
    }

    @NotNull
    public final MutableLiveData<HuodongRunRanksAdapter> k() {
        return this.adapter;
    }

    public final RunRankBean l(int rankNumber) {
        return new RunRankBean(rankNumber, "虚位以待", "", 0L);
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: from getter */
    public final SportModel getModel() {
        return this.model;
    }

    @NotNull
    public final MediatorLiveData<UserRunRankBean> n() {
        return this.myRank;
    }

    @NotNull
    public final MediatorLiveData<Integer> o() {
        return this.mySex;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MediatorLiveData<Integer> q() {
        return this.rankingType;
    }

    @Nullable
    /* JADX INFO: renamed from: r, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MediatorLiveData<RunRankBean> s() {
        return this.top1;
    }

    @NotNull
    public final MediatorLiveData<RunRankBean> t() {
        return this.top2;
    }

    @NotNull
    public final MediatorLiveData<RunRankBean> u() {
        return this.top3;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.isRefreshing;
    }

    @NotNull
    public final MediatorLiveData<Boolean> w() {
        return this.isShowMyRank;
    }

    public final void x() {
        this.pageNum++;
        y();
    }

    public final void y() {
        SportModel sportModel = this.model;
        int i = this.pageNum;
        Integer value = this.rankingType.getValue();
        Intrinsics.checkNotNull(value);
        n76.e(this, sportModel.z(i, value.intValue(), this.activityCode)).u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    public final void z(ValueCallback<Boolean> callback) {
        n76.e(this, this.model.y(this.activityCode)).u5(Schedulers.io()).G3(d60.c()).p5(new b(callback));
    }
}
