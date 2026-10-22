package com.huachenjie.login.page.info.alumnus;

import android.view.View;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.databinding.LoginActivityGenerateAlumnusBinding;
import com.huachenjie.login.util.LoginUtil;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.jo2;
import com.zj.adlib.oj3;
import com.zj.adlib.pg3;
import com.zj.adlib.v41;
import com.zj.adlib.zk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/login/page/info/alumnus/GenerateAlumnusActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityGenerateAlumnusBinding;", "Lcom/huachenjie/login/page/info/alumnus/GenerateAlumnusModel;", "", "", "", "V", "getLayoutResID", "", "initData", "<init>", "()V", "a", "login_release"}, k = 1, mv = {1, 8, 0})
public final class GenerateAlumnusActivity extends BaseMVVMActivity<LoginActivityGenerateAlumnusBinding, GenerateAlumnusModel> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/login/page/info/alumnus/GenerateAlumnusActivity$a;", "", "Landroid/view/View;", "v", "", "b", "Lcom/huachenjie/login/bean/LoginResultData;", "a", "<init>", "(Lcom/huachenjie/login/page/info/alumnus/GenerateAlumnusActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final LoginResultData a() {
            LoginResultData loginResultDataE = pg3.f18845a.e();
            if (loginResultDataE == null) {
                String userId = ai9.e().getUserId();
                String token = ai9.e().getToken();
                String str = token == null ? "" : token;
                String satoken = ai9.e().getSatoken();
                loginResultDataE = new LoginResultData(userId, str, satoken == null ? "" : satoken, ai9.e().getUserType(), Boolean.FALSE, null);
            }
            loginResultDataE.setUserType(ai9.e().getUserType());
            return loginResultDataE;
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            LoginUtil loginUtil = LoginUtil.f34754a;
            GenerateAlumnusActivity generateAlumnusActivity = GenerateAlumnusActivity.this;
            loginUtil.b(generateAlumnusActivity, GenerateAlumnusActivity.Z(generateAlumnusActivity), a());
            pg3.f18845a.a();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1", f = "GenerateAlumnusActivity.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1$1", f = "GenerateAlumnusActivity.kt", i = {0, 0, 1}, l = {39, 41}, m = "invokeSuspend", n = {"$this$flow", o.f, "$this$flow"}, s = {"L$0", "I$0", "L$0"})
        @SourceDebugExtension({"SMAP\nGenerateAlumnusActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenerateAlumnusActivity.kt\ncom/huachenjie/login/page/info/alumnus/GenerateAlumnusActivity$initData$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n1855#2,2:78\n*S KotlinDebug\n*F\n+ 1 GenerateAlumnusActivity.kt\ncom/huachenjie/login/page/info/alumnus/GenerateAlumnusActivity$initData$1$1\n*L\n38#1:78,2\n*E\n"})
        public static final class C08131 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            public C08131(Continuation<? super C08131> continuation) {
                super(2, continuation);
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C08131 c08131 = new C08131(continuation);
                c08131.L$0 = obj;
                return c08131;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super Integer> flowCollector, @Nullable Continuation<? super Unit> continuation) {
                return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x004a  */
            /* JADX WARN: Code duplicated, block: B:15:0x0063 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x0064  */
            /* JADX WARN: Code duplicated, block: B:18:0x006b  */
            /* JADX WARN: Code duplicated, block: B:20:0x0079 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:21:0x007a  */
            /* JADX WARN: Code duplicated, block: B:23:0x0080  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007a -> B:22:0x007c). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0080 -> B:11:0x0044). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @org.jetbrains.annotations.Nullable
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r9.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L32
                    if (r1 == r3) goto L23
                    if (r1 != r2) goto L1b
                    java.lang.Object r1 = r9.L$1
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r9.L$0
                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                    kotlin.ResultKt.throwOnFailure(r10)
                    r10 = r9
                    goto L7c
                L1b:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L23:
                    int r1 = r9.I$0
                    java.lang.Object r4 = r9.L$1
                    java.util.Iterator r4 = (java.util.Iterator) r4
                    java.lang.Object r5 = r9.L$0
                    kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                    kotlin.ResultKt.throwOnFailure(r10)
                    r10 = r9
                    goto L69
                L32:
                    kotlin.ResultKt.throwOnFailure(r10)
                    java.lang.Object r10 = r9.L$0
                    kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                    r1 = 3
                    r4 = 0
                    kotlin.ranges.IntProgression r1 = kotlin.ranges.RangesKt.downTo(r1, r4)
                    java.util.Iterator r1 = r1.iterator()
                    r4 = r9
                L44:
                    boolean r5 = r1.hasNext()
                    if (r5 == 0) goto L84
                    r5 = r1
                    kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
                    int r5 = r5.nextInt()
                    java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                    r4.L$0 = r10
                    r4.L$1 = r1
                    r4.I$0 = r5
                    r4.label = r3
                    java.lang.Object r6 = r10.emit(r6, r4)
                    if (r6 != r0) goto L64
                    return r0
                L64:
                    r8 = r5
                    r5 = r10
                    r10 = r4
                    r4 = r1
                    r1 = r8
                L69:
                    if (r1 <= 0) goto L80
                    r10.L$0 = r5
                    r10.L$1 = r4
                    r10.label = r2
                    r6 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r6, r10)
                    if (r1 != r0) goto L7a
                    return r0
                L7a:
                    r1 = r4
                    r4 = r5
                L7c:
                    r8 = r4
                    r4 = r10
                    r10 = r8
                    goto L44
                L80:
                    r1 = r4
                    r4 = r10
                    r10 = r5
                    goto L44
                L84:
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity.AnonymousClass1.C08131.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1$2", f = "GenerateAlumnusActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GenerateAlumnusActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(GenerateAlumnusActivity generateAlumnusActivity, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = generateAlumnusActivity;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super Integer> flowCollector, @Nullable Throwable th, @Nullable Continuation<? super Unit> continuation) {
                return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                GenerateAlumnusActivity.Z(this.this$0).k().setValue(Boxing.boxBoolean(true));
                GenerateAlumnusActivity.Z(this.this$0).j().setValue(this.this$0.getResources().getString(R.string.login_next));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity$initData$1$a */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", o.f, "", "a", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GenerateAlumnusActivity f34707a;

            public a(GenerateAlumnusActivity generateAlumnusActivity) {
                this.f34707a = generateAlumnusActivity;
            }

            @Nullable
            public final Object a(int i, @NotNull Continuation<? super Unit> continuation) {
                GenerateAlumnusActivity.Z(this.f34707a).j().setValue(this.f34707a.getResources().getString(R.string.login_generate_alumnus_countdown, Boxing.boxInt(i)));
                return Unit.INSTANCE;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).intValue(), continuation);
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return GenerateAlumnusActivity.this.new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowE1 = oj3.e1(oj3.O0(oj3.J0(new C08131(null)), jo2.e()), new AnonymousClass2(GenerateAlumnusActivity.this, null));
                a aVar = new a(GenerateAlumnusActivity.this);
                this.label = 1;
                if (flowE1.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ GenerateAlumnusModel Z(GenerateAlumnusActivity generateAlumnusActivity) {
        return generateAlumnusActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_generate_alumnus;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        v41.e(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }
}
