package com.huachenjie.base.app_widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import androidx.core.app.JobIntentService;
import androidx.core.app.MyJobIntentService;
import com.huachenjie.base.R;
import com.huachenjie.base.api.RequestModel;
import com.huachenjie.base.bean.InspirationWidgetInfo;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.pm1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/base/app_widget/InspirationWidgetJobService;", "Landroidx/core/app/MyJobIntentService;", "Landroid/content/Intent;", "intent", "", "onHandleWork", "Lcom/huachenjie/base/bean/InspirationWidgetInfo;", "widgetInfo", "a", "Landroid/widget/RemoteViews;", "updateViews", "c", "Landroid/app/PendingIntent;", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationWidgetJobService extends MyJobIntentService {
    public static final int K = 10012;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String f = "key_logout";

    /* JADX INFO: renamed from: com.huachenjie.base.app_widget.InspirationWidgetJobService$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/base/app_widget/InspirationWidgetJobService$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "work", "", "a", "", "JOB_ID", "I", "", "KEY_LOGOUT", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent work) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(work, "work");
            JobIntentService.enqueueWork(context, (Class<?>) InspirationWidgetJobService.class, 10012, work);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.app_widget.InspirationWidgetJobService$onHandleWork$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException;", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.app_widget.InspirationWidgetJobService$onHandleWork$1", f = "InspirationWidgetJobService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ResultException, Continuation<? super Boolean>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return InspirationWidgetJobService.this.new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull ResultException resultException, @Nullable Continuation<? super Boolean> continuation) {
            return create(resultException, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InspirationWidgetJobService.this.a(null);
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.app_widget.InspirationWidgetJobService$onHandleWork$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.app_widget.InspirationWidgetJobService$onHandleWork$2", f = "InspirationWidgetJobService.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $intent;
        int label;
        final /* synthetic */ InspirationWidgetJobService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Intent intent, InspirationWidgetJobService inspirationWidgetJobService, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$intent = intent;
            this.this$0 = inspirationWidgetJobService;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$intent, this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
            return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$intent.getBooleanExtra(InspirationWidgetJobService.f, false)) {
                    this.this$0.a(null);
                } else {
                    RequestModel requestModel = RequestModel.f32789a;
                    this.label = 1;
                    obj = requestModel.n(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.a((InspirationWidgetInfo) obj);
            return Unit.INSTANCE;
        }
    }

    public final void a(InspirationWidgetInfo widgetInfo) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.widget_inspiration);
        boolean z = false;
        remoteViews.setTextViewText(R.id.tv_total, String.valueOf(widgetInfo != null ? widgetInfo.getTotalInspiration() : 0));
        remoteViews.setTextViewText(R.id.tv_today_get, String.valueOf(widgetInfo != null ? widgetInfo.getTodayGained() : 0));
        int i = R.id.tv_get_more;
        if (widgetInfo != null && widgetInfo.getHasPendingReward()) {
            z = true;
        }
        remoteViews.setTextViewText(i, z ? "闪金币待领取" : "前往查看");
        remoteViews.setOnClickPendingIntent(R.id.rlRoot, b());
        c(remoteViews);
    }

    public final PendingIntent b() {
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, Class.forName("com.huachenjie.shandong_school.splash.InspirationWidgetTempActivity")), 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           ….FLAG_IMMUTABLE\n        )");
        return activity;
    }

    public final void c(RemoteViews updateViews) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, (Class<?>) InspirationWidget.class));
        Intrinsics.checkNotNullExpressionValue(appWidgetIds, "appWidgetIds");
        if (!(appWidgetIds.length == 0)) {
            appWidgetManager.partiallyUpdateAppWidget(appWidgetIds, updateViews);
        }
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, new AnonymousClass1(null), null, new AnonymousClass2(intent, this, null), 5, null);
    }
}
