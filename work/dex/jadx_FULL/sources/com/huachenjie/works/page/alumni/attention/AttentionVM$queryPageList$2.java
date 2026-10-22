package com.huachenjie.works.page.alumni.attention;

import android.graphics.Color;
import android.text.TextUtils;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.WorkDetailBean;
import com.zj.adlib.jo2;
import com.zj.adlib.v39;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.attention.AttentionVM$queryPageList$2", f = "AttentionVM.kt", i = {1}, l = {79, 80}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
public final class AttentionVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AttentionVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.attention.AttentionVM$queryPageList$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.alumni.attention.AttentionVM$queryPageList$2$1", f = "AttentionVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAttentionVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttentionVM.kt\ncom/huachenjie/works/page/alumni/attention/AttentionVM$queryPageList$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n1855#2,2:133\n*S KotlinDebug\n*F\n+ 1 AttentionVM.kt\ncom/huachenjie/works/page/alumni/attention/AttentionVM$queryPageList$2$1\n*L\n81#1:133,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageEntity<WorkDetailBean> $data;
        int label;
        final /* synthetic */ AttentionVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageEntity<WorkDetailBean> pageEntity, AttentionVM attentionVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = pageEntity;
            this.this$0 = attentionVM;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$data, this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<WorkDetailBean> list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PageEntity<WorkDetailBean> pageEntity = this.$data;
            if (pageEntity == null || (list = pageEntity.getList()) == null) {
                return null;
            }
            AttentionVM attentionVM = this.this$0;
            for (WorkDetailBean workDetailBean : list) {
                workDetailBean.setTextContent(RichTextUtils.f32968a.i(workDetailBean.getContent(), Color.parseColor("#00B6DE")));
                if (TextUtils.isEmpty(workDetailBean.getTextContent())) {
                    workDetailBean.setShowLookMore(Boxing.boxBoolean(false));
                } else {
                    CharSequence textContent = workDetailBean.getTextContent();
                    Intrinsics.checkNotNull(textContent);
                    workDetailBean.setShowLookMore(Boxing.boxBoolean(v39.f(textContent, attentionVM.r(), attentionVM.q()).getLineCount() > 2));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionVM$queryPageList$2(AttentionVM attentionVM, Continuation<? super AttentionVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = attentionVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AttentionVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00da  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x010d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0122  */
    /* JADX WARN: Code duplicated, block: B:61:0x0125  */
    /* JADX WARN: Code duplicated, block: B:66:0x013d  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity pageEntity;
        String refreshTime;
        boolean z;
        AttentionWorksAdapter value;
        List list;
        boolean z2;
        AttentionWorksAdapter value2;
        BaseLoadMoreModule loadMoreModule;
        AttentionWorksAdapter value3;
        BaseLoadMoreModule loadMoreModule2;
        List list2;
        AttentionWorksAdapter value4;
        AttentionWorksAdapter value5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pageEntity = (PageEntity) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            AttentionVM attentionVM = this.this$0;
            if (pageEntity != null) {
                refreshTime = pageEntity.getRefreshTime();
            } else {
                refreshTime = null;
            }
            attentionVM.refreshTime = refreshTime;
            if (this.this$0.pageNum == 1) {
                this.this$0.v().setValue(Boxing.boxBoolean(false));
                if (pageEntity != null) {
                    list2 = pageEntity.getList();
                } else {
                    list2 = null;
                }
                if (list2 != null || pageEntity.getList().isEmpty()) {
                    value4 = this.this$0.o().getValue();
                    if (value4 != null) {
                        value4.setList(null);
                    }
                    value5 = this.this$0.o().getValue();
                    if (value5 != null) {
                        value5.u();
                    }
                } else {
                    AttentionWorksAdapter value6 = this.this$0.o().getValue();
                    if (value6 != null) {
                        value6.t();
                    }
                    AttentionWorksAdapter value7 = this.this$0.o().getValue();
                    if (value7 != null) {
                        value7.setList(pageEntity.getList());
                    }
                }
            } else {
                if (pageEntity == null && (list = pageEntity.getList()) != null && (!list.isEmpty())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    value = this.this$0.o().getValue();
                    if (value != null) {
                        List list3 = pageEntity.getList();
                        Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                        value.addData((Collection) list3);
                    }
                } else {
                    this.this$0.pageNum--;
                }
            }
            if (pageEntity == null && pageEntity.getHasNext()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                value3 = this.this$0.o().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value2 = this.this$0.o().getValue();
                if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f36762a;
        int i2 = this.this$0.pageNum;
        String str = this.this$0.refreshTime;
        this.label = 1;
        obj = requestModel.z(i2, str, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity pageEntity2 = (PageEntity) obj;
        CoroutineDispatcher coroutineDispatcherC = jo2.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(pageEntity2, this.this$0, null);
        this.L$0 = pageEntity2;
        this.label = 2;
        if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        pageEntity = pageEntity2;
        AttentionVM attentionVM2 = this.this$0;
        if (pageEntity != null) {
            refreshTime = pageEntity.getRefreshTime();
        } else {
            refreshTime = null;
        }
        attentionVM2.refreshTime = refreshTime;
        if (this.this$0.pageNum == 1) {
            this.this$0.v().setValue(Boxing.boxBoolean(false));
            if (pageEntity != null) {
                list2 = pageEntity.getList();
            } else {
                list2 = null;
            }
            if (list2 != null) {
                value4 = this.this$0.o().getValue();
                if (value4 != null) {
                    value4.setList(null);
                }
                value5 = this.this$0.o().getValue();
                if (value5 != null) {
                    value5.u();
                }
            } else {
                value4 = this.this$0.o().getValue();
                if (value4 != null) {
                    value4.setList(null);
                }
                value5 = this.this$0.o().getValue();
                if (value5 != null) {
                    value5.u();
                }
            }
        } else {
            if (pageEntity == null) {
                z = false;
            } else {
                z = false;
            }
            if (z) {
                value = this.this$0.o().getValue();
                if (value != null) {
                    List list4 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "data.list");
                    value.addData((Collection) list4);
                }
            } else {
                this.this$0.pageNum--;
            }
        }
        if (pageEntity == null) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (z2) {
            value3 = this.this$0.o().getValue();
            if (value3 != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            value2 = this.this$0.o().getValue();
            if (value2 != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
