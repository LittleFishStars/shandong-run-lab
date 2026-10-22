package com.huachenjie.works.arouter;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.works.R;
import com.huachenjie.works.page.publish.delegate.PublishWorksDelegate;
import com.zj.adlib.fv5;
import com.zj.adlib.zj7;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Interceptor(priority = 12)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R5\u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040\r0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/arouter/WorksInterceptor;", "Lcom/alibaba/android/arouter/facade/template/IInterceptor;", "Landroid/content/Context;", "context", "", "init", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "Lcom/alibaba/android/arouter/facade/callback/InterceptorCallback;", RenderCallContext.TYPE_CALLBACK, "process", "", "", "Lkotlin/Function1;", "a", "Lkotlin/Lazy;", "()Ljava/util/Map;", "processorMap", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksInterceptor implements IInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy processorMap = LazyKt.lazy(new Function0<Map<String, Function1<? super Postcard, ? extends Unit>>>() { // from class: com.huachenjie.works.arouter.WorksInterceptor$processorMap$2
        @NotNull
        public final Map<String, Function1<Postcard, Unit>> invoke() {
            return new LinkedHashMap();
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksInterceptor$init$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Postcard, Unit> {
        public AnonymousClass1(Object obj) {
            super(1, obj, WorksDetailProcessor.class, "process", "process(Lcom/alibaba/android/arouter/facade/Postcard;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Postcard) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable Postcard postcard) {
            ((WorksDetailProcessor) ((CallableReference) this).receiver).a(postcard);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksInterceptor$init$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Postcard, Unit> {
        public AnonymousClass2(Object obj) {
            super(1, obj, WorksDetailProcessor.class, "processQuote", "processQuote(Lcom/alibaba/android/arouter/facade/Postcard;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Postcard) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable Postcard postcard) {
            ((WorksDetailProcessor) ((CallableReference) this).receiver).c(postcard);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksInterceptor$init$3, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Postcard, Unit> {
        public AnonymousClass3(Object obj) {
            super(1, obj, WorksDetailProcessor.class, "processPost", "processPost(Lcom/alibaba/android/arouter/facade/Postcard;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Postcard) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable Postcard postcard) {
            ((WorksDetailProcessor) ((CallableReference) this).receiver).b(postcard);
        }
    }

    public final Map<String, Function1<Postcard, Unit>> a() {
        return (Map) this.processorMap.getValue();
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@Nullable Context context) {
        Map<String, Function1<Postcard, Unit>> mapA = a();
        WorksDetailProcessor worksDetailProcessor = WorksDetailProcessor.f36763a;
        mapA.put(zj7.i.WORKS_DETAIL, new AnonymousClass1(worksDetailProcessor));
        a().put(zj7.i.BROADCAST_FLOOR, new AnonymousClass2(worksDetailProcessor));
        a().put(zj7.i.POST_DETAIL, new AnonymousClass3(worksDetailProcessor));
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(@Nullable Postcard postcard, @Nullable InterceptorCallback callback) {
        if (Intrinsics.areEqual(postcard != null ? postcard.getPath() : null, zj7.i.WORKS_PUBLISH) && PublishWorksDelegate.f14925a.h()) {
            fv5.a(R.string.works_publish_work_publishing);
            return;
        }
        if (!a().containsKey(postcard != null ? postcard.getPath() : null)) {
            if (callback != null) {
                callback.onContinue(postcard);
            }
        } else {
            if (callback != null) {
                callback.onInterrupt(null);
            }
            Function1<Postcard, Unit> function1 = a().get(postcard != null ? postcard.getPath() : null);
            if (function1 != null) {
                function1.invoke(postcard);
            }
        }
    }
}
