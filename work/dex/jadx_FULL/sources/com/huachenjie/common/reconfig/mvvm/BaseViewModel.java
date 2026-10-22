package com.huachenjie.common.reconfig.mvvm;

import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModel;
import com.huachenjie.common.reconfig.liveData.SingleLiveEvent;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel.a;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel.b;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002\n\u0010B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002R\u001f\u0010\u000e\u001a\u00060\tR\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0013\u001a\u00060\u000fR\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "", y6b.f, "c", "", "msg", y6b.g, "f", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$b;", "a", "Lkotlin/Lazy;", "e", "()Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$b;", "uiLiveData", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$a;", "b", "d", "()Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$a;", "uiChangeLiveData", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public class BaseViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy uiLiveData = LazyKt.lazy(new Function0<b>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseViewModel$uiLiveData$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseViewModel.b m356invoke() {
            return this.this$0.new b();
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy uiChangeLiveData = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseViewModel$uiChangeLiveData$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseViewModel.a m355invoke() {
            return this.this$0.new a();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$a;", "", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "", "a", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "c", "()Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "showLoadingEvent", "b", "dismissLoadingEvent", "", "d", "toastEvent", "finishEvent", "<init>", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final SingleLiveEvent showLoadingEvent = new SingleLiveEvent();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final SingleLiveEvent dismissLoadingEvent = new SingleLiveEvent();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        @NotNull
        public final SingleLiveEvent<String> toastEvent = new SingleLiveEvent<>();

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        @NotNull
        public final SingleLiveEvent finishEvent = new SingleLiveEvent();

        public a() {
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: from getter */
        public final SingleLiveEvent getDismissLoadingEvent() {
            return this.dismissLoadingEvent;
        }

        @NotNull
        /* JADX INFO: renamed from: b, reason: from getter */
        public final SingleLiveEvent getFinishEvent() {
            return this.finishEvent;
        }

        @NotNull
        /* JADX INFO: renamed from: c, reason: from getter */
        public final SingleLiveEvent getShowLoadingEvent() {
            return this.showLoadingEvent;
        }

        @NotNull
        public final SingleLiveEvent<String> d() {
            return this.toastEvent;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel$b;", "", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "b", "()Landroidx/lifecycle/MutableLiveData;", "statusBarHeight", "c", "statusBarHeightPx", "navigationBarHeight", "<init>", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final MutableLiveData<Integer> statusBarHeight = new MutableLiveData<>();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final MutableLiveData<Integer> statusBarHeightPx = new MutableLiveData<>();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        @NotNull
        public final MutableLiveData<Integer> navigationBarHeight = new MutableLiveData<>();

        public b() {
        }

        @NotNull
        public final MutableLiveData<Integer> a() {
            return this.navigationBarHeight;
        }

        @NotNull
        public final MutableLiveData<Integer> b() {
            return this.statusBarHeight;
        }

        @NotNull
        public final MutableLiveData<Integer> c() {
            return this.statusBarHeightPx;
        }
    }

    public final void c() {
        d().getDismissLoadingEvent().call();
    }

    @NotNull
    public final a d() {
        return (a) this.uiChangeLiveData.getValue();
    }

    @NotNull
    public final b e() {
        return (b) this.uiLiveData.getValue();
    }

    public final void f() {
        d().getFinishEvent().call();
    }

    public final void g() {
        d().getShowLoadingEvent().call();
    }

    public final void h(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        d().d().postValue(msg);
    }
}
