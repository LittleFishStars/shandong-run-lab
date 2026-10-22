package com.huachenjie.mall.page.episodes_detail;

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
@DebugMetadata(c = "com.huachenjie.mall.page.episodes_detail.EpisodesDetailVM$loadData$1", f = "EpisodesDetailVM.kt", i = {1}, l = {35, 42}, m = "invokeSuspend", n = {"detailBean"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nEpisodesDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpisodesDetailVM.kt\ncom/huachenjie/mall/page/episodes_detail/EpisodesDetailVM$loadData$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public final class EpisodesDetailVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $episodeNo;
    final /* synthetic */ String $orderItemNo;
    final /* synthetic */ String $skuNo;
    Object L$0;
    int label;
    final /* synthetic */ EpisodesDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EpisodesDetailVM$loadData$1(String str, String str2, String str3, EpisodesDetailVM episodesDetailVM, Continuation<? super EpisodesDetailVM$loadData$1> continuation) {
        super(2, continuation);
        this.$episodeNo = str;
        this.$orderItemNo = str2;
        this.$skuNo = str3;
        this.this$0 = episodesDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EpisodesDetailVM$loadData$1(this.$episodeNo, this.$orderItemNo, this.$skuNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:33:0x008d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bb A[SYNTHETIC] */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        EpisodeDetailBean episodeDetailBean;
        PageEntity pageEntity;
        EpisodesDetailVM episodesDetailVM;
        EpisodeProgress episodeProgress;
        String lastPlayNo;
        Iterator it;
        Object next;
        EpisodeItemBean episodeItemBean;
        EpisodeItemBean lastPlayItem;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        EpisodeItemBean episodeItemBean2 = null;
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
                episodesDetailVM = this.this$0;
                episodeProgress = episodeDetailBean.getEpisodeProgress();
                if (episodeProgress != null) {
                    lastPlayNo = episodeProgress.getLastPlayNo();
                } else {
                    lastPlayNo = null;
                }
                if (!TextUtils.isEmpty(lastPlayNo)) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "pageItem.list");
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((EpisodeItemBean) next).getEpisodeItemNo(), lastPlayNo));
                    episodeItemBean = (EpisodeItemBean) next;
                    if (episodeItemBean != null) {
                        episodesDetailVM.t(episodesDetailVM.j().getValue());
                        lastPlayItem = episodesDetailVM.getLastPlayItem();
                        if (lastPlayItem != null) {
                            lastPlayItem.setPlaying(false);
                        }
                        episodeItemBean.setPlaying(true);
                        episodeItemBean2 = episodeItemBean;
                    }
                }
                episodesDetailVM.l().setValue(pageEntity.getList());
                if (episodeItemBean2 != null) {
                    episodesDetailVM.j().setValue(episodeItemBean2);
                    episodesDetailVM.o().setValue(Boxing.boxInt(1));
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
        this.this$0.k().setValue(episodeDetailBean2);
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
            episodesDetailVM = this.this$0;
            episodeProgress = episodeDetailBean.getEpisodeProgress();
            if (episodeProgress != null) {
                lastPlayNo = episodeProgress.getLastPlayNo();
            } else {
                lastPlayNo = null;
            }
            if (!TextUtils.isEmpty(lastPlayNo)) {
                List list2 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "pageItem.list");
                it = list2.iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((EpisodeItemBean) next).getEpisodeItemNo(), lastPlayNo));
                episodeItemBean = (EpisodeItemBean) next;
                if (episodeItemBean != null) {
                    episodesDetailVM.t(episodesDetailVM.j().getValue());
                    lastPlayItem = episodesDetailVM.getLastPlayItem();
                    if (lastPlayItem != null) {
                        lastPlayItem.setPlaying(false);
                    }
                    episodeItemBean.setPlaying(true);
                    episodeItemBean2 = episodeItemBean;
                }
            }
            episodesDetailVM.l().setValue(pageEntity.getList());
            if (episodeItemBean2 != null) {
                episodesDetailVM.j().setValue(episodeItemBean2);
                episodesDetailVM.o().setValue(Boxing.boxInt(1));
            }
        }
        return Unit.INSTANCE;
    }
}
