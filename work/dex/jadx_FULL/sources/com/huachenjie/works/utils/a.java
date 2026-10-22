package com.huachenjie.works.utils;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.external.utils.WorksUtils;
import com.huachenjie.works.utils.a;
import com.zj.adlib.e0a;
import com.zj.adlib.fv5;
import com.zj.adlib.jo9;
import com.zj.adlib.np9;
import com.zj.adlib.sw0;
import com.zj.adlib.y6b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002\"3B\u000f\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b1\u00102J>\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bJ\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010%R\u001c\u0010*\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010/¨\u00064"}, d2 = {"Lcom/huachenjie/works/utils/a;", "", "", "maxSelectNum", "", "isSelectPicture", "", "savePath", "Lkotlin/Function1;", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "", "onResult", "p", "Lcom/huachenjie/works/utils/a$b;", "session", "paths", "i", "path", "n", "Lkotlin/Pair;", j.b, "m", "Ljava/io/File;", "photoFile", "s", "photoPath", "r", "sourcePath", "targetPath", y6b.g, "videoPath", y6b.f, "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/works/utils/a$b;", "pickSession", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "mediaExecutor", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "b", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPubWorkMediaPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMediaPicker.kt\ncom/huachenjie/works/utils/PubWorkMediaPicker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n1#2:235\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 PubWorkMediaPicker.kt\ncom/huachenjie/works/utils/PubWorkMediaPicker\n*L\n82#1:236\n82#1:237,3\n92#1:240\n92#1:241,3\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler mainHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FragmentActivity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediaPickerLauncher picker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public PickSession pickSession;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final ExecutorService mediaExecutor;

    /* JADX INFO: renamed from: com.huachenjie.works.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/utils/a$a;", "", "", "url", "a", "savePath", "", "b", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPubWorkMediaPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMediaPicker.kt\ncom/huachenjie/works/utils/PubWorkMediaPicker$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,234:1\n731#2,9:235\n37#3,2:244\n13309#4,2:246\n*S KotlinDebug\n*F\n+ 1 PubWorkMediaPicker.kt\ncom/huachenjie/works/utils/PubWorkMediaPicker$Companion\n*L\n206#1:235,9\n207#1:244,2\n226#1:246,2\n*E\n"})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull String url) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(url)) {
                return url;
            }
            List listSplit = new Regex(WVNativeCallbackUtil.SEPERATER).split(new Regex("^[a-zA-Z]+://").replace(url, ""), 0);
            if (!listSplit.isEmpty()) {
                ListIterator listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                    if (!(((String) listIterator.previous()).length() == 0)) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            if (strArr.length == 0) {
                return url;
            }
            String str = strArr[strArr.length - 1];
            if (str.length() <= 32) {
                return str;
            }
            String strSubstring = str.substring(str.length() - 32, str.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void b(@NotNull String savePath) {
            File[] fileArrListFiles;
            Intrinsics.checkNotNullParameter(savePath, "savePath");
            if (StringsKt.startsWith$default(savePath, WorksUtils.f37135a.a(), false, 2, (Object) null)) {
                File file = new File(savePath);
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        Companion companion = a.INSTANCE;
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                        companion.b(absolutePath);
                    }
                }
                file.delete();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.utils.a$b, reason: from toString */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001b\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\u001a\b\u0002\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R)\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/utils/a$b;", "", "", "a", "", "b", "Lkotlin/Function1;", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "", "c", "savePath", "isVideo", "onResult", "d", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", y6b.f, "()Ljava/lang/String;", "Z", y6b.g, "()Z", "Lkotlin/jvm/functions/Function1;", "f", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class PickSession {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        public final String savePath;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        @NotNull
        public final Function1<List<PubWorkMediaData>, Unit> onResult;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        public final boolean isVideo;

        /* JADX WARN: Multi-variable type inference failed */
        public PickSession(@NotNull String str, boolean z, @NotNull Function1<? super List<PubWorkMediaData>, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "savePath");
            Intrinsics.checkNotNullParameter(function1, "onResult");
            this.savePath = str;
            this.isVideo = z;
            this.onResult = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PickSession e(PickSession pickSession, String str, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pickSession.savePath;
            }
            if ((i & 2) != 0) {
                z = pickSession.isVideo;
            }
            if ((i & 4) != 0) {
                function1 = pickSession.onResult;
            }
            return pickSession.d(str, z, function1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getSavePath() {
            return this.savePath;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getIsVideo() {
            return this.isVideo;
        }

        @NotNull
        public final Function1<List<PubWorkMediaData>, Unit> c() {
            return this.onResult;
        }

        @NotNull
        public final PickSession d(@NotNull String savePath, boolean isVideo, @NotNull Function1<? super List<PubWorkMediaData>, Unit> onResult) {
            Intrinsics.checkNotNullParameter(savePath, "savePath");
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            return new PickSession(savePath, isVideo, onResult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PickSession)) {
                return false;
            }
            PickSession pickSession = (PickSession) other;
            return Intrinsics.areEqual(this.savePath, pickSession.savePath) && this.isVideo == pickSession.isVideo && Intrinsics.areEqual(this.onResult, pickSession.onResult);
        }

        @NotNull
        public final Function1<List<PubWorkMediaData>, Unit> f() {
            return this.onResult;
        }

        @NotNull
        public final String g() {
            return this.savePath;
        }

        public final boolean h() {
            return this.isVideo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int iHashCode = this.savePath.hashCode() * 31;
            boolean z = this.isVideo;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode + r1) * 31) + this.onResult.hashCode();
        }

        @NotNull
        public String toString() {
            return "PickSession(savePath=" + this.savePath + ", isVideo=" + this.isVideo + ", onResult=" + this.onResult + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/utils/a$c", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements MediaPickerListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            PickSession pickSession = a.this.pickSession;
            a.this.pickSession = null;
            if (pickSession == null) {
                return;
            }
            if (result instanceof MediaPickerResult.Success) {
                a.this.i(pickSession, ((MediaPickerResult.Success) result).g());
                return;
            }
            if (result instanceof MediaPickerResult.a) {
                pickSession.f().invoke(CollectionsKt.emptyList());
            } else if (result instanceof MediaPickerResult.Error) {
                fv5.b(((MediaPickerResult.Error) result).f());
                pickSession.f().invoke(CollectionsKt.emptyList());
            }
        }
    }

    public a(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, TTDownloadField.TT_ACTIVITY);
        this.activity = fragmentActivity;
        this.mediaExecutor = Executors.newSingleThreadExecutor();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.picker = MediaPicker.w(fragmentActivity, new c());
    }

    public static final void j(PickSession pickSession) {
        Intrinsics.checkNotNullParameter(pickSession, "$session");
        pickSession.f().invoke(CollectionsKt.emptyList());
    }

    public static final void k(final PickSession pickSession, List list, a aVar) throws Exception {
        final ArrayList arrayList;
        Intrinsics.checkNotNullParameter(pickSession, "$session");
        Intrinsics.checkNotNullParameter(list, "$paths");
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        if (pickSession.h()) {
            List<String> list2 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str : list2) {
                String strG = aVar.g(str, pickSession.g());
                String str2 = strG == null ? str : strG;
                Pair<Integer, Integer> pairO = aVar.o(str2);
                arrayList.add(new PubWorkMediaData(null, str2, ((Number) pairO.component1()).intValue(), ((Number) pairO.component2()).intValue(), 1, null));
            }
        } else {
            List list3 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(aVar.n((String) it.next(), pickSession.g()));
            }
        }
        aVar.mainHandler.post(new Runnable() { // from class: com.zj.adlib.p27
            @Override // java.lang.Runnable
            public final void run() {
                a.l(pickSession, arrayList);
            }
        });
    }

    public static final void l(PickSession pickSession, List list) {
        Intrinsics.checkNotNullParameter(pickSession, "$session");
        Intrinsics.checkNotNullParameter(list, "$pickedList");
        pickSession.f().invoke(list);
    }

    public static /* synthetic */ void q(a aVar, int i, boolean z, String str, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            str = "";
        }
        aVar.p(i, z, str, function1);
    }

    public final String g(String videoPath, String savePath) throws Exception {
        boolean z;
        m(savePath);
        String str = savePath + File.separator + System.nanoTime() + ".mp4";
        android.util.Pair<Integer, Integer> pairJ = np9.j(new jo9.c(videoPath));
        Integer numValueOf = (Integer) pairJ.first;
        Integer numValueOf2 = (Integer) pairJ.second;
        int iIntValue = numValueOf.intValue();
        Intrinsics.checkNotNullExpressionValue(numValueOf2, "videoHeight");
        if (iIntValue * numValueOf2.intValue() > 2073600) {
            float fCoerceAtLeast = RangesKt.coerceAtLeast((numValueOf2.intValue() * 1.0f) / 1280, (numValueOf.intValue() * 1.0f) / 720);
            numValueOf = Integer.valueOf((int) (numValueOf.intValue() / fCoerceAtLeast));
            numValueOf2 = Integer.valueOf((int) (numValueOf2.intValue() / fCoerceAtLeast));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return h(videoPath, str);
        }
        jo9.d dVarX = jo9.f(this.activity).x(videoPath);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "videoWidth");
        jo9.d dVarZ = dVarX.z(numValueOf.intValue());
        Intrinsics.checkNotNullExpressionValue(numValueOf2, "videoHeight");
        dVarZ.y(numValueOf2.intValue()).A(str).B();
        return str;
    }

    public final String h(String sourcePath, String targetPath) {
        try {
            FilesKt.copyTo$default(new File(sourcePath), new File(targetPath), true, 0, 4, (Object) null);
            return targetPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void i(final PickSession session, final List<String> paths) {
        if (paths.isEmpty()) {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.n27
                @Override // java.lang.Runnable
                public final void run() {
                    a.j(session);
                }
            });
        } else {
            this.mediaExecutor.submit(new Runnable() { // from class: com.zj.adlib.o27
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    a.k(session, paths, this);
                }
            });
        }
    }

    public final void m(String path) {
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final PubWorkMediaData n(String path, String savePath) {
        m(savePath);
        String strS = s(new File(path), savePath);
        if (!StringsKt.startsWith$default(strS, savePath, false, 2, (Object) null)) {
            String strH = h(strS, savePath + File.separator + System.nanoTime() + FileTypes.F);
            if (strH != null) {
                strS = strH;
            }
        }
        String str = strS;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new PubWorkMediaData(str, null, options.outWidth, options.outHeight, 2, null);
    }

    public final Pair<Integer, Integer> o(String path) {
        try {
            android.util.Pair<Integer, Integer> pairJ = np9.j(new jo9.c(path));
            return TuplesKt.to(pairJ.first, pairJ.second);
        } catch (Exception e) {
            e.printStackTrace();
            return TuplesKt.to(0, 0);
        }
    }

    public final void p(int maxSelectNum, boolean isSelectPicture, @NotNull String savePath, @NotNull Function1<? super List<PubWorkMediaData>, Unit> onResult) {
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        this.pickSession = new PickSession(savePath, !isSelectPicture, onResult);
        if (isSelectPicture) {
            MediaPickerLauncher.Y(this.picker, "为了您可以拍摄照片用于发布作品，我们需要访问您终端设备的相机权限", maxSelectNum, 1080, 1024, false, 0.0f, 0.0f, false, 240, null);
        } else {
            this.picker.J(e0a.d().getVideoTime());
        }
    }

    public final String r(String photoPath, String savePath) {
        String str = savePath + File.separator + System.nanoTime() + ".webp";
        if (!sw0.c(BitmapFactory.decodeFile(photoPath), str, "webp", 75)) {
            return photoPath;
        }
        INSTANCE.b(photoPath);
        return str;
    }

    public final String s(File photoFile, String savePath) {
        if (StringsKt.equals("png", FilesKt.getExtension(photoFile), true)) {
            String absolutePath = photoFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "photoFile.absolutePath");
            return r(absolutePath, savePath);
        }
        String absolutePath2 = photoFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "photoFile.absolutePath");
        return absolutePath2;
    }
}
