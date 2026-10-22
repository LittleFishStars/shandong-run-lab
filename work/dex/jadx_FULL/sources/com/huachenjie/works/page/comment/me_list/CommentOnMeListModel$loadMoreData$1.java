package com.huachenjie.works.page.comment.me_list;

import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.me_list.CommentOnMeListModel$loadMoreData$1", f = "CommentOnMeListModel.kt", i = {1}, l = {27, 28}, m = "invokeSuspend", n = {"commentList"}, s = {"L$0"})
public final class CommentOnMeListModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CommentOnMeListModel this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.comment.me_list.CommentOnMeListModel$loadMoreData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.comment.me_list.CommentOnMeListModel$loadMoreData$1$1", f = "CommentOnMeListModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nCommentOnMeListModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentOnMeListModel.kt\ncom/huachenjie/works/page/comment/me_list/CommentOnMeListModel$loadMoreData$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n1855#2,2:52\n*S KotlinDebug\n*F\n+ 1 CommentOnMeListModel.kt\ncom/huachenjie/works/page/comment/me_list/CommentOnMeListModel$loadMoreData$1$1\n*L\n29#1:52,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageEntity<CommentOnMeBean> $commentList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageEntity<CommentOnMeBean> pageEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$commentList = pageEntity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$commentList, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<CommentOnMeBean> list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PageEntity<CommentOnMeBean> pageEntity = this.$commentList;
            if (pageEntity == null || (list = pageEntity.getList()) == null) {
                return null;
            }
            for (CommentOnMeBean commentOnMeBean : list) {
                Spanned spannedFromHtml = Html.fromHtml(new Regex("\\s{2,}").replace(StringsKt.replace$default(commentOnMeBean.getContent(), "\n", "<br>", false, 4, (Object) null), new Function1<MatchResult, CharSequence>() { // from class: com.huachenjie.works.page.comment.me_list.CommentOnMeListModel$loadMoreData$1$1$1$spanned$1
                    @NotNull
                    public final CharSequence invoke(@NotNull MatchResult matchResult) {
                        Intrinsics.checkNotNullParameter(matchResult, o.f);
                        return StringsKt.repeat("&nbsp;", matchResult.getValue().length());
                    }
                }));
                Object[] spans = spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "spanned.getSpans(\n      …ava\n                    )");
                for (URLSpan uRLSpan : (URLSpan[]) spans) {
                    RichTextUtils richTextUtils = RichTextUtils.f32968a;
                    String url = uRLSpan.getURL();
                    Intrinsics.checkNotNullExpressionValue(url, "url.url");
                    if (richTextUtils.g(url)) {
                        commentOnMeBean.getGoodsIndexArray().add(Boxing.boxInt(spannedFromHtml.getSpanStart(uRLSpan)));
                        commentOnMeBean.getGoodsIndexArray().add(Boxing.boxInt(spannedFromHtml.getSpanEnd(uRLSpan)));
                    }
                }
                String string = new SpannableString(spannedFromHtml).toString();
                Intrinsics.checkNotNullExpressionValue(string, "SpannableString(spanned).toString()");
                commentOnMeBean.setNoHtmlContent(string);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentOnMeListModel$loadMoreData$1(CommentOnMeListModel commentOnMeListModel, Continuation<? super CommentOnMeListModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = commentOnMeListModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentOnMeListModel$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity<?> pageEntity;
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
            this.this$0.u().setValue(pageEntity);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f36762a;
        int pageNum = this.this$0.getPageNum();
        String refreshTime = this.this$0.getRefreshTime();
        this.label = 1;
        obj = requestModel.I(pageNum, refreshTime, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity<?> pageEntity2 = (PageEntity) obj;
        CoroutineDispatcher coroutineDispatcherC = jo2.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(pageEntity2, null);
        this.L$0 = pageEntity2;
        this.label = 2;
        if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        pageEntity = pageEntity2;
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
