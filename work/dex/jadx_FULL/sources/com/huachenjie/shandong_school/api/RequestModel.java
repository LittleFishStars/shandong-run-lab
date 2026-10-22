package com.huachenjie.shandong_school.api;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.base.bean.ActivityPopBean;
import com.huachenjie.base.bean.MainTabRedDotBean;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/shandong_school/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/shandong_school/api/AppApi;", "Lcom/alibaba/fastjson/JSONObject;", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/ActivityPopBean;", "f", "", "activityNo", "", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cid", y6b.f, "Lcom/huachenjie/base/bean/MainTabRedDotBean;", "d", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<AppApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f36018a = new RequestModel();

    @Nullable
    public final Object c(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$activityRead$2(str, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super MainTabRedDotBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkFlashCoinsRedDot$2(null), continuation);
    }

    @Nullable
    public final Object e(@NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkMessageRedDot$2(null), continuation);
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super ActivityPopBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getActivityPopInfo$2(null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateGeTuiCid$2(str, null), continuation);
    }
}
