package com.huachenjie.works.external.utils;

import com.blankj.utilcode.util.Utils;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.database.PublicWorkDraft;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/external/utils/WorksUtils;", "", "", "a", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWorksUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorksUtils.kt\ncom/huachenjie/works/external/utils/WorksUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class WorksUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WorksUtils f37135a = new WorksUtils();

    @NotNull
    public final String a() {
        return Utils.a().getFilesDir().getAbsolutePath() + File.separator + "works";
    }

    @Nullable
    public final Object b(@NotNull Continuation<? super Integer> continuation) {
        return v41.h(jo2.c(), new WorksUtils$queryDraftSize$2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object c(@NotNull Continuation<? super String> continuation) {
        WorksUtils$queryLatestWorksPic$1 worksUtils$queryLatestWorksPic$1;
        String picPath;
        PubWorkMediaData videoMedia;
        List<PubWorkMediaData> picList;
        if (continuation instanceof WorksUtils$queryLatestWorksPic$1) {
            worksUtils$queryLatestWorksPic$1 = (WorksUtils$queryLatestWorksPic$1) continuation;
            int i = worksUtils$queryLatestWorksPic$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                worksUtils$queryLatestWorksPic$1.label = i - Integer.MIN_VALUE;
            } else {
                worksUtils$queryLatestWorksPic$1 = new WorksUtils$queryLatestWorksPic$1(this, continuation);
            }
        } else {
            worksUtils$queryLatestWorksPic$1 = new WorksUtils$queryLatestWorksPic$1(this, continuation);
        }
        Object objH = worksUtils$queryLatestWorksPic$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = worksUtils$queryLatestWorksPic$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objH);
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            WorksUtils$queryLatestWorksPic$2 worksUtils$queryLatestWorksPic$2 = new WorksUtils$queryLatestWorksPic$2(null);
            worksUtils$queryLatestWorksPic$1.label = 1;
            objH = v41.h(coroutineDispatcherC, worksUtils$queryLatestWorksPic$2, worksUtils$queryLatestWorksPic$1);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objH);
        }
        PublicWorkDraft publicWorkDraft = (PublicWorkDraft) objH;
        if (publicWorkDraft != null && (picList = publicWorkDraft.getPicList()) != null) {
            Iterator<T> it = picList.iterator();
            do {
                if (!it.hasNext()) {
                    picPath = null;
                    break;
                }
                picPath = ((PubWorkMediaData) it.next()).getPicPath();
            } while (picPath == null);
        } else {
            picPath = null;
            break;
        }
        if (picPath != null) {
            return picPath;
        }
        if (publicWorkDraft == null || (videoMedia = publicWorkDraft.getVideoMedia()) == null) {
            return null;
        }
        return videoMedia.getVideoPath();
    }
}
