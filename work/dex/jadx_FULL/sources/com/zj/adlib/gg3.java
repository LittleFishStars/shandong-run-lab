package com.zj.adlib;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Pair;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0005J9\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u001c\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00060\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/gg3;", "", "", "", "paths", "Lkotlin/Function1;", "", "callBack", "d", "path", "Lkotlin/Function2;", "e", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "videoPath", "savePath", "b", "f", "a", "Ljava/lang/String;", "fileDirPath", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFileUploadUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUploadUtils.kt\ncom/huachenjie/mall/utils/FileUploadUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,185:1\n1549#2:186\n1620#2,3:187\n*S KotlinDebug\n*F\n+ 1 FileUploadUtils.kt\ncom/huachenjie/mall/utils/FileUploadUtils\n*L\n32#1:186\n32#1:187,3\n*E\n"})
public final class gg3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final gg3 f41898a = new gg3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String fileDirPath = Utils.a().getCacheDir().getAbsolutePath() + File.separator;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/zj/adlib/gg3$a", "Lcom/huachenjie/common/aliyun/file_upload/MultipleUploadCallback;", "", "Lcom/zj/adlib/pf6;", "fileInfoList", "", "c", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nFileUploadUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUploadUtils.kt\ncom/huachenjie/mall/utils/FileUploadUtils$uploadPictures$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n1855#2,2:186\n1549#2:189\n1620#2,3:190\n1#3:188\n*S KotlinDebug\n*F\n+ 1 FileUploadUtils.kt\ncom/huachenjie/mall/utils/FileUploadUtils$uploadPictures$1\n*L\n50#1:186,2\n57#1:189\n57#1:190,3\n*E\n"})
    public static final class a implements MultipleUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f41899a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Function1<List<String>, Unit> f16760a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<String> list, Function1<? super List<String>, Unit> function1) {
            this.f41899a = list;
            this.f16760a = function1;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
        public void c(@Nullable List<pf6> fileInfoList) {
            pf6 pf6Var;
            Object next;
            Iterator<T> it = this.f41899a.iterator();
            while (it.hasNext()) {
                new File((String) it.next()).delete();
            }
            ArrayList arrayList = null;
            if (fileInfoList != null) {
                Iterator<T> it2 = fileInfoList.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(!((pf6) next).f()));
                pf6Var = (pf6) next;
            } else {
                pf6Var = null;
            }
            if (pf6Var != null) {
                this.f16760a.invoke((Object) null);
                return;
            }
            Function1<List<String>, Unit> function1 = this.f16760a;
            if (fileInfoList != null) {
                List<pf6> list = fileInfoList;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it3 = list.iterator();
                while (it3.hasNext()) {
                    arrayList.add(((pf6) it3.next()).e());
                }
            }
            function1.invoke(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/gg3$b", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f41900a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Function2<String, String, Unit> f16761a;
        public final /* synthetic */ String b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, Function2<? super String, ? super String, Unit> function2, String str2) {
            this.f41900a = str;
            this.f16761a = function2;
            this.b = str2;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            if (StringsKt.startsWith$default(this.f41900a, gg3.fileDirPath, false, 2, (Object) null)) {
                new File(this.f41900a).delete();
            }
            this.f16761a.invoke((Object) null, (Object) null);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            if (StringsKt.startsWith$default(this.f41900a, gg3.fileDirPath, false, 2, (Object) null)) {
                new File(this.f41900a).delete();
            }
            this.f16761a.invoke(this.b, fileUrl);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/gg3$c", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f41901a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f16762a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<String> f16763a;

        public c(String str, Ref.ObjectRef<String> objectRef, CountDownLatch countDownLatch) {
            this.f41901a = str;
            this.f16763a = objectRef;
            this.f16762a = countDownLatch;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            new File(this.f41901a).delete();
            this.f16762a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            new File(this.f41901a).delete();
            this.f16763a.element = fileUrl;
            this.f16762a.countDown();
        }
    }

    public final String b(String videoPath, String savePath) throws Exception {
        boolean z;
        String str = savePath + File.separator + System.nanoTime() + ".mp4";
        Pair<Integer, Integer> pairJ = np9.j(new jo9.c(videoPath));
        Integer numValueOf = (Integer) pairJ.first;
        Integer numValueOf2 = (Integer) pairJ.second;
        int iIntValue = numValueOf.intValue();
        Intrinsics.checkNotNullExpressionValue(numValueOf2, "videoHeight");
        if (iIntValue * numValueOf2.intValue() > 1400000) {
            float fCoerceAtLeast = RangesKt.coerceAtLeast((numValueOf2.intValue() * 1.0f) / 1280, (numValueOf.intValue() * 1.0f) / 720);
            numValueOf = Integer.valueOf((int) (numValueOf.intValue() / fCoerceAtLeast));
            numValueOf2 = Integer.valueOf((int) (numValueOf2.intValue() / fCoerceAtLeast));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return videoPath;
        }
        jo9.d dVarF = jo9.f(Utils.a());
        dVarF.x(videoPath);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "videoWidth");
        jo9.d dVarZ = dVarF.z(numValueOf.intValue());
        Intrinsics.checkNotNullExpressionValue(numValueOf2, "videoHeight");
        dVarZ.y(numValueOf2.intValue()).A(str).B();
        return str;
    }

    public final String c(String path) {
        if (!StringsKt.startsWith$default(path, "content://", false, 2, (Object) null)) {
            return path;
        }
        String strC = mf9.c(Utils.a(), path);
        Intrinsics.checkNotNullExpressionValue(strC, "{\n            URIUtil_We…getApp(), path)\n        }");
        return strC;
    }

    public final void d(@NotNull List<String> paths, @NotNull Function1<? super List<String>, Unit> callBack) throws IOException {
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        List<String> list = paths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            String str2 = fileDirPath + System.nanoTime() + ".webp";
            sw0.c(ImageUtils.Z(f41898a.c(str), 1080, 1920), str2, "webp", 75);
            arrayList.add(str2);
        }
        u66.e(Utils.a(), UploadFileType.UPLOAD_MALL_AFTER_SALE, arrayList, new a(arrayList, callBack));
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull Function2<? super String, ? super String, Unit> function2, @NotNull Continuation<? super Unit> continuation) throws Exception {
        String strSubstring;
        String strC = c(str);
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(strC, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default >= 0) {
            strSubstring = strC.substring(iLastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        } else {
            strSubstring = "mp4";
        }
        String strB = b(strC, fileDirPath + System.nanoTime() + '.' + strSubstring);
        String strF = f(strB);
        if (strF == null) {
            function2.invoke((Object) null, (Object) null);
            return Unit.INSTANCE;
        }
        u66.d(Utils.a(), UploadFileType.UPLOAD_MALL_AFTER_SALE, strB, new b(strB, function2, strF));
        return Unit.INSTANCE;
    }

    public final String f(String videoPath) throws InterruptedException, IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(videoPath);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
        mediaMetadataRetriever.release();
        String str = fileDirPath + File.separator + System.nanoTime() + "-cover.webp";
        sw0.c(frameAtTime, str, "webp", 75);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        u66.d(Utils.a(), UploadFileType.UPLOAD_MALL_AFTER_SALE, str, new c(str, objectRef, countDownLatch));
        countDownLatch.await();
        return (String) objectRef.element;
    }
}
