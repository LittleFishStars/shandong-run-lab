package com.huachenjie.compat.api;

import com.google.gson.Gson;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.bean.NotifyConfig;
import com.huachenjie.base.bean.NotifyConfigList;
import com.huachenjie.common.enums.ThirdLoginType;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.compat.bean.PhonePreCheck;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.zj.adlib.y6b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0005J\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0005J%\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/compat/api/CompatNewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/compat/api/CompatNewApi;", "Lcom/huachenjie/base/bean/NotifyConfigList;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/base/bean/NotifyConfig;", "notifyConfigList", "", "j", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "feedbackContent", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/huachenjie/base/bean/BindInfo;", y6b.f, "Lcom/huachenjie/common/enums/ThirdLoginType;", "type", VerifyCodeActivity.y, "c", "(Lcom/huachenjie/common/enums/ThirdLoginType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "(Lcom/huachenjie/common/enums/ThirdLoginType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/compat/bean/PhonePreCheck;", y6b.g, "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CompatNewModel extends BaseRepository<CompatNewApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CompatNewModel f33981a = new CompatNewModel();

    @Nullable
    public final Object c(@NotNull ThirdLoginType thirdLoginType, @NotNull String str, @NotNull Continuation<Object> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("thirdType", Boxing.boxInt(thirdLoginType.getType())), TuplesKt.to(VerifyCodeActivity.y, str)}));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(\n         …,\n            )\n        )");
        return BaseRepositoryExtKt.a(this, new CompatNewModel$bindThirdUser$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object d(@NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new CompatNewModel$closeUserFace$2(null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new CompatNewModel$feedback$2(str, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super NotifyConfigList> continuation) {
        return BaseRepositoryExtKt.a(this, new CompatNewModel$getUserNotifyConfig$2(null), continuation);
    }

    @Nullable
    public final Object g(@NotNull Continuation<? super BindInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new CompatNewModel$getUserSettings$2(null), continuation);
    }

    @Nullable
    public final Object h(@NotNull Continuation<? super PhonePreCheck> continuation) {
        return BaseRepositoryExtKt.a(this, new CompatNewModel$modifyPhonePreCheck$2(null), continuation);
    }

    @Nullable
    public final Object i(@NotNull ThirdLoginType thirdLoginType, @NotNull Continuation<Object> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(MapsKt.mapOf(TuplesKt.to("thirdType", Boxing.boxInt(thirdLoginType.getType()))));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(\n         …\" to type.type)\n        )");
        return BaseRepositoryExtKt.a(this, new CompatNewModel$unBindThirdUser$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object j(@NotNull List<NotifyConfig> list, @NotNull Continuation<Object> continuation) {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("notifyConfigList", list));
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(mapMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(map)");
        return BaseRepositoryExtKt.a(this, new CompatNewModel$updateUserNotifyConfig$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }
}
