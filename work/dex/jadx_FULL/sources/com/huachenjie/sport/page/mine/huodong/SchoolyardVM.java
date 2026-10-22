package com.huachenjie.sport.page.mine.huodong;

import androidx.p002lifecycle.MutableLiveData;
import com.byazt.bv.BaseConstants;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.HuodongBean;
import com.huachenjie.sport.bean.SchoolyardBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006H\u0002R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R%\u0010+\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u000b0\u000b0!8\u0006¢\u0006\f\n\u0004\b\u001e\u0010#\u001a\u0004\b'\u0010%¨\u0006."}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "isMy", "", j.b, "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/sport/bean/SchoolyardBean;", "observable", "n", "", "K", "I", "i", "()I", "p", "(I)V", "index", "", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "q", "(Ljava/lang/String;)V", BaseConstants.MARKET_URI_AUTHORITY_SEARCH, "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "k", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/sport/page/mine/huodong/SchoolyardAdapter;", "Landroidx/lifecycle/MutableLiveData;", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "j", "m", "isRefreshing", "kotlin.jvm.PlatformType", "layoutState", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolyardVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int index = 1;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String search = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolyardAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>(1);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/mine/huodong/SchoolyardVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/sport/bean/SchoolyardBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<SchoolyardBean> {
        public a() {
            super(true);
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            SchoolyardVM.this.j().setValue(3);
        }

        public void onFinish() {
            super.onFinish();
            SchoolyardVM.this.m().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@Nullable SchoolyardBean data) {
            if (data == null || SchoolyardVM.this.h().getValue() == null) {
                return;
            }
            List<HuodongBean> list = data.getList();
            if (list != null) {
                SchoolyardVM schoolyardVM = SchoolyardVM.this;
                if (schoolyardVM.getIndex() == 1) {
                    SchoolyardAdapter value = schoolyardVM.h().getValue();
                    Intrinsics.checkNotNull(value);
                    value.setList(list);
                } else {
                    SchoolyardAdapter value2 = schoolyardVM.h().getValue();
                    Intrinsics.checkNotNull(value2);
                    value2.addData((Collection) list);
                }
            }
            if (data.getHasNext()) {
                SchoolyardAdapter value3 = SchoolyardVM.this.h().getValue();
                Intrinsics.checkNotNull(value3);
                value3.getLoadMoreModule().loadMoreComplete();
            } else {
                SchoolyardAdapter value4 = SchoolyardVM.this.h().getValue();
                Intrinsics.checkNotNull(value4);
                BaseLoadMoreModule.loadMoreEnd$default(value4.getLoadMoreModule(), false, 1, null);
            }
            if (SchoolyardVM.this.getIndex() != 1) {
                SchoolyardVM.this.j().setValue(1);
            } else if (data.getList() == null || data.getList().isEmpty()) {
                SchoolyardVM.this.j().setValue(2);
            } else {
                SchoolyardVM.this.j().setValue(1);
            }
        }
    }

    @NotNull
    public final MutableLiveData<SchoolyardAdapter> h() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.layoutState;
    }

    @NotNull
    /* JADX INFO: renamed from: k, reason: from getter */
    public final SportModel getModel() {
        return this.model;
    }

    @NotNull
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getSearch() {
        return this.search;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.isRefreshing;
    }

    public final void n(Observable<BaseEntity<SchoolyardBean>> observable) {
        observable.u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    public final void o(boolean isMy) {
        n(isMy ? this.model.v(this.index, this.search) : this.model.D(this.index, this.search));
    }

    public final void p(int i) {
        this.index = i;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.search = str;
    }
}
