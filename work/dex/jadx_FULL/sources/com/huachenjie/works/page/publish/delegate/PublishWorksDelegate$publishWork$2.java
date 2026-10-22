package com.huachenjie.works.page.publish.delegate;

import android.app.Application;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.works.R;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.bean.publish.PubWorksAttachmentInfo;
import com.huachenjie.works.bean.publish.PublishWorksBean;
import com.huachenjie.works.database.PublicWorkDatabase;
import com.huachenjie.works.database.PublicWorkDraft;
import com.huachenjie.works.utils.LocalVideoUtils;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.oz9;
import com.zj.adlib.v41;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$2", f = "PublishWorksDelegate.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class PublishWorksDelegate$publishWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<String> $goodsList;
    final /* synthetic */ String $requestId;
    final /* synthetic */ List<RichSubjectBean> $topicList;
    final /* synthetic */ List<RichUserBean> $userList;
    final /* synthetic */ PublicWorkDraft $workDraft;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$2$1", f = "PublishWorksDelegate.kt", i = {}, l = {122, 124, 132, 152}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nPublishWorksDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorksDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorksDelegate$publishWork$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n1#2:408\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<String> $goodsList;
        final /* synthetic */ String $requestId;
        final /* synthetic */ List<RichSubjectBean> $topicList;
        final /* synthetic */ List<RichUserBean> $userList;
        final /* synthetic */ PublicWorkDraft $workDraft;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PublicWorkDraft publicWorkDraft, List<RichUserBean> list, List<RichSubjectBean> list2, String str, ArrayList<String> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$workDraft = publicWorkDraft;
            this.$userList = list;
            this.$topicList = list2;
            this.$requestId = str;
            this.$goodsList = arrayList;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$workDraft, this.$userList, this.$topicList, this.$requestId, this.$goodsList, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:50:0x0145  */
        /* JADX WARN: Code duplicated, block: B:53:0x014e  */
        /* JADX WARN: Code duplicated, block: B:54:0x015a  */
        /* JADX WARN: Code duplicated, block: B:63:0x0173  */
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws InterruptedException, IOException {
            Object objQ;
            Object objP;
            PubWorksAttachmentInfo pubWorksAttachmentInfo;
            Object objV;
            WorkDetailBean workDetailBean;
            String worksNo;
            PubWorkMediaData videoMedia;
            String videoPath;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String str = "";
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$workDraft.getAttachmentType() == 1) {
                    PublishWorksDelegate publishWorksDelegate = PublishWorksDelegate.f14925a;
                    List<PubWorkMediaData> picList = this.$workDraft.getPicList();
                    this.label = 1;
                    objP = publishWorksDelegate.p(picList, this);
                    if (objP == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pubWorksAttachmentInfo = (PubWorksAttachmentInfo) objP;
                } else {
                    PublishWorksDelegate publishWorksDelegate2 = PublishWorksDelegate.f14925a;
                    PubWorkMediaData videoMedia2 = this.$workDraft.getVideoMedia();
                    Intrinsics.checkNotNull(videoMedia2);
                    String mediaPath = this.$workDraft.getMediaPath();
                    PubWorkMediaData pubWorkMediaData = (PubWorkMediaData) CollectionsKt.firstOrNull(this.$workDraft.getPicList());
                    String picPath = pubWorkMediaData != null ? pubWorkMediaData.getPicPath() : null;
                    this.label = 2;
                    objQ = publishWorksDelegate2.q(videoMedia2, mediaPath, picPath, this);
                    if (objQ == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pubWorksAttachmentInfo = (PubWorksAttachmentInfo) objQ;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objP = obj;
                pubWorksAttachmentInfo = (PubWorksAttachmentInfo) objP;
            } else {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objV = obj;
                    workDetailBean = (WorkDetailBean) objV;
                    if (workDetailBean != null || (worksNo = workDetailBean.getWorksNo()) == null) {
                        worksNo = "";
                    }
                    if (this.$workDraft.getAttachmentType() == 1) {
                        com.huachenjie.works.utils.a.INSTANCE.b(this.$workDraft.getMediaPath());
                    } else {
                        LocalVideoUtils localVideoUtils = LocalVideoUtils.f14946a;
                        videoMedia = this.$workDraft.getVideoMedia();
                        if (videoMedia != null && (videoPath = videoMedia.getVideoPath()) != null) {
                            str = videoPath;
                        }
                        localVideoUtils.d(worksNo, str);
                    }
                    if (workDetailBean != null) {
                        oz9 oz9Var = oz9.f43864a;
                        Application context = PublishWorksDelegate.f14925a.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        workDetailBean.replaceVideoPath();
                        Unit unit = Unit.INSTANCE;
                        oz9Var.d(context, workDetailBean);
                    }
                    PublicWorkDatabase.INSTANCE.getPublicWorkDao().delWork(this.$workDraft);
                    oz9 oz9Var2 = oz9.f43864a;
                    PublishWorksDelegate publishWorksDelegate3 = PublishWorksDelegate.f14925a;
                    Application context2 = publishWorksDelegate3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    oz9Var2.g(context2);
                    publishWorksDelegate3.m(100);
                    publishWorksDelegate3.m(-2);
                    fv5.a(R.string.works_publish_work_publish_upload_success);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                objQ = obj;
                pubWorksAttachmentInfo = (PubWorksAttachmentInfo) objQ;
            }
            if (pubWorksAttachmentInfo == null) {
                PublishWorksDelegate publishWorksDelegate4 = PublishWorksDelegate.f14925a;
                PublicWorkDraft publicWorkDraft = this.$workDraft;
                this.label = 3;
                if (publishWorksDelegate4.l(publicWorkDraft, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            PublishWorksBean publishWorksBean = new PublishWorksBean(null, null, null, null, null, null, 0, null, 0, null, null, null, null, 8191, null);
            List<RichUserBean> list = this.$userList;
            PublicWorkDraft publicWorkDraft2 = this.$workDraft;
            List<RichSubjectBean> list2 = this.$topicList;
            String str2 = this.$requestId;
            ArrayList<String> arrayList = this.$goodsList;
            publishWorksBean.getAtUserList().addAll(list);
            publishWorksBean.setTitle(StringsKt.trim(publicWorkDraft2.getTitle()).toString());
            publishWorksBean.setContent(StringsKt.trim(publicWorkDraft2.getContent()).toString());
            publishWorksBean.setLocation(publicWorkDraft2.getLocation());
            publishWorksBean.getSubjectList().addAll(list2);
            PubWorkChannelBean channel = publicWorkDraft2.getChannel();
            publishWorksBean.setChannelNo(channel != null ? channel.getChannelNo() : null);
            publishWorksBean.setAttachmentType(publicWorkDraft2.getAttachmentType());
            publishWorksBean.setAttachmentInfo(pubWorksAttachmentInfo);
            publishWorksBean.setVisit(publicWorkDraft2.getPermissionType());
            publishWorksBean.setRequestId(str2);
            publishWorksBean.setGoodsList(arrayList);
            String categoryNo = publicWorkDraft2.getCategoryNo();
            if (categoryNo == null) {
                categoryNo = "";
            }
            publishWorksBean.setCategoryNo(categoryNo);
            String tagNo = publicWorkDraft2.getTagNo();
            if (tagNo == null) {
                tagNo = "";
            }
            publishWorksBean.setTagNo(tagNo);
            RequestModel requestModel = RequestModel.f36762a;
            this.label = 4;
            objV = requestModel.v(publishWorksBean, this);
            if (objV == coroutine_suspended) {
                return coroutine_suspended;
            }
            workDetailBean = (WorkDetailBean) objV;
            if (workDetailBean != null) {
                worksNo = "";
            } else {
                worksNo = "";
            }
            if (this.$workDraft.getAttachmentType() == 1) {
                com.huachenjie.works.utils.a.INSTANCE.b(this.$workDraft.getMediaPath());
            } else {
                LocalVideoUtils localVideoUtils2 = LocalVideoUtils.f14946a;
                videoMedia = this.$workDraft.getVideoMedia();
                if (videoMedia != null) {
                    str = videoPath;
                }
                localVideoUtils2.d(worksNo, str);
            }
            if (workDetailBean != null) {
                oz9 oz9Var3 = oz9.f43864a;
                Application context3 = PublishWorksDelegate.f14925a.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                workDetailBean.replaceVideoPath();
                Unit unit2 = Unit.INSTANCE;
                oz9Var3.d(context3, workDetailBean);
            }
            PublicWorkDatabase.INSTANCE.getPublicWorkDao().delWork(this.$workDraft);
            oz9 oz9Var4 = oz9.f43864a;
            PublishWorksDelegate publishWorksDelegate5 = PublishWorksDelegate.f14925a;
            Application context4 = publishWorksDelegate5.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            oz9Var4.g(context4);
            publishWorksDelegate5.m(100);
            publishWorksDelegate5.m(-2);
            fv5.a(R.string.works_publish_work_publish_upload_success);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishWorksDelegate$publishWork$2(PublicWorkDraft publicWorkDraft, List<RichUserBean> list, List<RichSubjectBean> list2, String str, ArrayList<String> arrayList, Continuation<? super PublishWorksDelegate$publishWork$2> continuation) {
        super(2, continuation);
        this.$workDraft = publicWorkDraft;
        this.$userList = list;
        this.$topicList = list2;
        this.$requestId = str;
        this.$goodsList = arrayList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishWorksDelegate$publishWork$2(this.$workDraft, this.$userList, this.$topicList, this.$requestId, this.$goodsList, continuation);
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
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$workDraft, this.$userList, this.$topicList, this.$requestId, this.$goodsList, null);
            this.label = 1;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
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
