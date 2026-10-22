package com.huachenjie.base.api;

import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.bean.WorksConfig;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SemesterBean;
import com.zj.adlib.lo7;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002J\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00030\u0002J\u0016\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00030\u0002J\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00030\u0002J\u0018\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003\u0018\u00010\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u0002R#\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/base/api/BaseModel;", "", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/common/bean/CommonUserInfo;", y6b.f, "", "Lcom/huachenjie/common/bean/SemesterBean;", "e", "Lcom/huachenjie/base/bean/WorksConfig;", "a", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "c", "Lcom/huachenjie/base/bean/AddressInfo;", "b", "Lcom/huachenjie/base/bean/BindInfo;", "f", "Lcom/huachenjie/base/api/BaseApi;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "d", "()Lcom/huachenjie/base/api/BaseApi;", "mApi", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy mApi = LazyKt.lazy(new Function0<BaseApi>() { // from class: com.huachenjie.base.api.BaseModel$mApi$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseApi m209invoke() {
            return (BaseApi) lo7.e().d(BaseApi.class);
        }
    });

    @NotNull
    public final Observable<BaseEntity<WorksConfig>> a() {
        return d().u();
    }

    @Nullable
    public final Observable<BaseEntity<AddressInfo>> b() {
        return d().v();
    }

    @NotNull
    public final Observable<BaseEntity<CommonSwitchConfig>> c() {
        return d().a();
    }

    public final BaseApi d() {
        return (BaseApi) this.mApi.getValue();
    }

    @NotNull
    public final Observable<BaseEntity<List<SemesterBean>>> e() {
        return d().d();
    }

    @NotNull
    public final Observable<BaseEntity<BindInfo>> f() {
        return d().o();
    }

    @NotNull
    public final Observable<BaseEntity<CommonUserInfo>> g() {
        return d().b(MapsKt.emptyMap());
    }
}
