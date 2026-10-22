package com.huachenjie.college.api;

import com.zj.adlib.lo7;
import huachenjie.sdk.http.BaseEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J<\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002R\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/college/api/CollegeModel;", "", "", "adCode", "", "platformType", "", "durationTime", "startTime", "thirdUserId", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "a", "Lcom/huachenjie/college/api/CollegeApi;", "Lkotlin/Lazy;", "b", "()Lcom/huachenjie/college/api/CollegeApi;", "api", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class CollegeModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy api = LazyKt.lazy(new Function0<CollegeApi>() { // from class: com.huachenjie.college.api.CollegeModel$api$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CollegeApi m327invoke() {
            return (CollegeApi) lo7.e().d(CollegeApi.class);
        }
    });

    @NotNull
    public final Observable<BaseEntity<Object>> a(@NotNull String adCode, int platformType, long durationTime, long startTime, @NotNull String thirdUserId) {
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        Intrinsics.checkNotNullParameter(thirdUserId, "thirdUserId");
        return b().k(adCode, platformType, durationTime, startTime, thirdUserId);
    }

    public final CollegeApi b() {
        Object value = this.api.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-api>(...)");
        return (CollegeApi) value;
    }
}
