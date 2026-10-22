package com.huachenjie.works.utils;

import com.google.gson.Gson;
import com.huachenjie.works.bean.LocalVideoInfoBean;
import com.huachenjie.works.external.utils.WorksUtils;
import com.zj.adlib.r90;
import com.zj.adlib.yj7;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\b\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/utils/LocalVideoUtils;", "", "", yj7.g.WORKS_NO, "videoPath", "", "d", "b", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/works/bean/LocalVideoInfoBean;", "c", "Lcom/google/gson/Gson;", "a", "Lcom/google/gson/Gson;", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nLocalVideoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalVideoUtils.kt\ncom/huachenjie/works/utils/LocalVideoUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,62:1\n1#2:63\n1855#3,2:64\n766#3:66\n857#3,2:67\n*S KotlinDebug\n*F\n+ 1 LocalVideoUtils.kt\ncom/huachenjie/works/utils/LocalVideoUtils\n*L\n45#1:64,2\n52#1:66\n52#1:67,2\n*E\n"})
public final class LocalVideoUtils {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final LocalVideoUtils f14946a = new LocalVideoUtils();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Gson gson = new Gson();

    @NotNull
    public final Gson a() {
        return gson;
    }

    @Nullable
    public final String b(@NotNull String worksNo) {
        Object next;
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Iterator<T> it = c().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((LocalVideoInfoBean) next).getWorksNo(), worksNo));
        LocalVideoInfoBean localVideoInfoBean = (LocalVideoInfoBean) next;
        if (localVideoInfoBean != null) {
            return localVideoInfoBean.getLocalPath();
        }
        return null;
    }

    public final List<LocalVideoInfoBean> c() {
        List<LocalVideoInfoBean> mutableList;
        LocalVideoInfoBean[] localVideoInfoBeanArr = (LocalVideoInfoBean[]) new Gson().fromJson(r90.n(), LocalVideoInfoBean[].class);
        return (localVideoInfoBeanArr == null || (mutableList = ArraysKt.toMutableList(localVideoInfoBeanArr)) == null) ? new ArrayList() : mutableList;
    }

    public final void d(@NotNull String worksNo, @NotNull String videoPath) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        List mutableList = CollectionsKt.toMutableList(c());
        mutableList.add(new LocalVideoInfoBean(worksNo, videoPath, System.currentTimeMillis()));
        r90.S(gson.toJson(mutableList));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object e(@NotNull Continuation<? super Unit> continuation) {
        LocalVideoUtils$removeLocalVideo$1 localVideoUtils$removeLocalVideo$1;
        List arrayList;
        List list;
        if (continuation instanceof LocalVideoUtils$removeLocalVideo$1) {
            localVideoUtils$removeLocalVideo$1 = (LocalVideoUtils$removeLocalVideo$1) continuation;
            int i = localVideoUtils$removeLocalVideo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                localVideoUtils$removeLocalVideo$1.label = i - Integer.MIN_VALUE;
            } else {
                localVideoUtils$removeLocalVideo$1 = new LocalVideoUtils$removeLocalVideo$1(this, continuation);
            }
        } else {
            localVideoUtils$removeLocalVideo$1 = new LocalVideoUtils$removeLocalVideo$1(this, continuation);
        }
        Object objB = localVideoUtils$removeLocalVideo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = localVideoUtils$removeLocalVideo$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objB);
            List<LocalVideoInfoBean> listC = c();
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<LocalVideoInfoBean> list2 = listC;
            for (LocalVideoInfoBean localVideoInfoBean : list2) {
                if (jCurrentTimeMillis - localVideoInfoBean.getSaveTime() > 86400000) {
                    a.Companion companion = a.INSTANCE;
                    String parent = new File(localVideoInfoBean.getLocalPath()).getParent();
                    if (parent == null) {
                        parent = localVideoInfoBean.getLocalPath();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(parent, "File(it.localPath).parent ?: it.localPath");
                    }
                    companion.b(parent);
                }
            }
            arrayList = new ArrayList();
            for (Object obj : list2) {
                if (jCurrentTimeMillis - ((LocalVideoInfoBean) obj).getSaveTime() < 86400000) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                WorksUtils worksUtils = WorksUtils.f37135a;
                localVideoUtils$removeLocalVideo$1.L$0 = arrayList;
                localVideoUtils$removeLocalVideo$1.label = 1;
                objB = worksUtils.b(localVideoUtils$removeLocalVideo$1);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList;
            }
            r90.S(gson.toJson(arrayList));
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        list = (List) localVideoUtils$removeLocalVideo$1.L$0;
        ResultKt.throwOnFailure(objB);
        if (((Number) objB).intValue() == 0) {
            a.INSTANCE.b(WorksUtils.f37135a.a());
        }
        arrayList = list;
        r90.S(gson.toJson(arrayList));
        return Unit.INSTANCE;
    }
}
