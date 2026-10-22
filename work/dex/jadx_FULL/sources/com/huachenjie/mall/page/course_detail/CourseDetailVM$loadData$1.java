package com.huachenjie.mall.page.course_detail;

import android.text.TextUtils;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.bean.EpisodeProgress;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.course_detail.CourseDetailVM$loadData$1", f = "CourseDetailVM.kt", i = {1}, l = {35, 41}, m = "invokeSuspend", n = {"detailBean"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nCourseDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseDetailVM.kt\ncom/huachenjie/mall/page/course_detail/CourseDetailVM$loadData$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class CourseDetailVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $episodeNo;
    final /* synthetic */ String $orderItemNo;
    final /* synthetic */ String $skuNo;
    Object L$0;
    int label;
    final /* synthetic */ CourseDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseDetailVM$loadData$1(String str, String str2, String str3, CourseDetailVM courseDetailVM, Continuation<? super CourseDetailVM$loadData$1> continuation) {
        super(2, continuation);
        this.$episodeNo = str;
        this.$orderItemNo = str2;
        this.$skuNo = str3;
        this.this$0 = courseDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CourseDetailVM$loadData$1(this.$episodeNo, this.$orderItemNo, this.$skuNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x008e  */
    /* JADX WARN: Code duplicated, block: B:35:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:59:0x010e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0122  */
    /* JADX WARN: Code duplicated, block: B:66:0x0135  */
    /* JADX WARN: Code duplicated, block: B:68:0x0140  */
    /* JADX WARN: Code duplicated, block: B:71:0x0109 A[SYNTHETIC] */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        EpisodeDetailBean episodeDetailBean;
        PageEntity pageEntity;
        CourseDetailVM courseDetailVM;
        EpisodeItemBean episodeItemBean;
        EpisodeItemBean episodeItemBean2;
        EpisodeProgress episodeProgress;
        String lastPlayNo;
        CourseDetailAdapter value;
        Iterator it;
        Object next;
        EpisodeItemBean episodeItemBean3;
        EpisodeItemBean episodeItemBeanN;
        EpisodeItemBean episodeItemBean4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        EpisodeItemBean episodeItemBean5 = null;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                episodeDetailBean = (EpisodeDetailBean) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pageEntity = (PageEntity) obj;
            if (pageEntity != null) {
                courseDetailVM = this.this$0;
                if (pageEntity.getList().size() == 1) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "pageItem.list");
                    episodeItemBean4 = (EpisodeItemBean) CollectionsKt.getOrNull(list, 0);
                    if (episodeItemBean4 != null) {
                        episodeItemBean4.setPositionType(3);
                    }
                } else {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "pageItem.list");
                    episodeItemBean = (EpisodeItemBean) CollectionsKt.getOrNull(list2, 0);
                    if (episodeItemBean != null) {
                        episodeItemBean.setPositionType(1);
                    }
                    List list3 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list3, "pageItem.list");
                    episodeItemBean2 = (EpisodeItemBean) CollectionsKt.getOrNull(list3, pageEntity.getList().size() - 1);
                    if (episodeItemBean2 != null) {
                        episodeItemBean2.setPositionType(2);
                    }
                }
                episodeProgress = episodeDetailBean.getEpisodeProgress();
                if (episodeProgress != null) {
                    lastPlayNo = episodeProgress.getLastPlayNo();
                } else {
                    lastPlayNo = null;
                }
                if (!TextUtils.isEmpty(lastPlayNo)) {
                    List list4 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "pageItem.list");
                    it = list4.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((EpisodeItemBean) next).getEpisodeItemNo(), lastPlayNo));
                    episodeItemBean3 = (EpisodeItemBean) next;
                    if (episodeItemBean3 != null) {
                        courseDetailVM.t(courseDetailVM.k().getValue());
                        episodeItemBeanN = courseDetailVM.getLastPlayItem();
                        if (episodeItemBeanN != null) {
                            episodeItemBeanN.setPlaying(false);
                        }
                        episodeItemBean3.setPlaying(true);
                        episodeItemBean5 = episodeItemBean3;
                    }
                }
                value = courseDetailVM.j().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
                if (episodeItemBean5 != null) {
                    courseDetailVM.k().setValue(episodeItemBean5);
                    courseDetailVM.o().setValue(Boxing.boxInt(1));
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        MallModel mallModel = MallModel.f34763a;
        String str = this.$episodeNo;
        String str2 = this.$orderItemNo;
        String str3 = this.$skuNo;
        this.label = 1;
        obj = mallModel.x(str, str2, str3, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        EpisodeDetailBean episodeDetailBean2 = (EpisodeDetailBean) obj;
        if (episodeDetailBean2 == null) {
            return Unit.INSTANCE;
        }
        this.this$0.l().setValue(episodeDetailBean2);
        EpisodeProgress episodeProgress2 = episodeDetailBean2.getEpisodeProgress();
        if (TextUtils.isEmpty(episodeProgress2 != null ? episodeProgress2.getLastPlayNo() : null)) {
            this.this$0.o().setValue(Boxing.boxInt(0));
        }
        MallModel mallModel2 = MallModel.f34763a;
        String str4 = this.$episodeNo;
        String str5 = this.$orderItemNo;
        String str6 = this.$skuNo;
        this.L$0 = episodeDetailBean2;
        this.label = 2;
        Object objZ = mallModel2.z(str4, str5, str6, this);
        if (objZ == coroutine_suspended) {
            return coroutine_suspended;
        }
        episodeDetailBean = episodeDetailBean2;
        obj = objZ;
        pageEntity = (PageEntity) obj;
        if (pageEntity != null) {
            courseDetailVM = this.this$0;
            if (pageEntity.getList().size() == 1) {
                List list5 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list5, "pageItem.list");
                episodeItemBean4 = (EpisodeItemBean) CollectionsKt.getOrNull(list5, 0);
                if (episodeItemBean4 != null) {
                    episodeItemBean4.setPositionType(3);
                }
            } else {
                List list6 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list6, "pageItem.list");
                episodeItemBean = (EpisodeItemBean) CollectionsKt.getOrNull(list6, 0);
                if (episodeItemBean != null) {
                    episodeItemBean.setPositionType(1);
                }
                List list7 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list7, "pageItem.list");
                episodeItemBean2 = (EpisodeItemBean) CollectionsKt.getOrNull(list7, pageEntity.getList().size() - 1);
                if (episodeItemBean2 != null) {
                    episodeItemBean2.setPositionType(2);
                }
            }
            episodeProgress = episodeDetailBean.getEpisodeProgress();
            if (episodeProgress != null) {
                lastPlayNo = episodeProgress.getLastPlayNo();
            } else {
                lastPlayNo = null;
            }
            if (!TextUtils.isEmpty(lastPlayNo)) {
                List list8 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list8, "pageItem.list");
                it = list8.iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((EpisodeItemBean) next).getEpisodeItemNo(), lastPlayNo));
                episodeItemBean3 = (EpisodeItemBean) next;
                if (episodeItemBean3 != null) {
                    courseDetailVM.t(courseDetailVM.k().getValue());
                    episodeItemBeanN = courseDetailVM.getLastPlayItem();
                    if (episodeItemBeanN != null) {
                        episodeItemBeanN.setPlaying(false);
                    }
                    episodeItemBean3.setPlaying(true);
                    episodeItemBean5 = episodeItemBean3;
                }
            }
            value = courseDetailVM.j().getValue();
            if (value != null) {
                value.setList(pageEntity.getList());
            }
            if (episodeItemBean5 != null) {
                courseDetailVM.k().setValue(episodeItemBean5);
                courseDetailVM.o().setValue(Boxing.boxInt(1));
            }
        }
        return Unit.INSTANCE;
    }
}
