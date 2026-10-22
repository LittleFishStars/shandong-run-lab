package com.huachenjie.common.util.media_picker;

import com.zj.adlib.PickedMedia;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "", "<init>", "()V", "a", "b", "c", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult$a;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult$b;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult$c;", "common_release"}, k = 1, mv = {1, 8, 0})
public abstract class MediaPickerResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerResult$a;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends MediaPickerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f33925a = new a();

        public a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.MediaPickerResult$b, reason: from toString */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerResult$b;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "", "a", "", "b", "code", "message", "c", "toString", "hashCode", "", "other", "", "equals", "I", "e", "()I", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Error extends MediaPickerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int code;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        @NotNull
        public final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.code = i;
            this.message = str;
        }

        public static /* synthetic */ Error d(Error error, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.code;
            }
            if ((i2 & 2) != 0) {
                str = error.message;
            }
            return error.c(i, str);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final Error c(int code, @NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(code, message);
        }

        public final int e() {
            return this.code;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.code == error.code && Intrinsics.areEqual(this.message, error.message);
        }

        @NotNull
        public final String f() {
            return this.message;
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(code=" + this.code + ", message=" + this.message + ")";
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.MediaPickerResult$c, reason: from toString */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerResult$c;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "", "Lcom/zj/adlib/wq6;", "a", "items", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "f", "()Ljava/util/List;", y6b.f, "paths", "d", "()Lcom/zj/adlib/wq6;", "firstItem", "e", "()Ljava/lang/String;", "firstPath", "<init>", "(Ljava/util/List;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nMediaPickerContract.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaPickerContract.kt\ncom/huachenjie/common/util/media_picker/MediaPickerResult$Success\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,202:1\n1549#2:203\n1620#2,3:204\n*S KotlinDebug\n*F\n+ 1 MediaPickerContract.kt\ncom/huachenjie/common/util/media_picker/MediaPickerResult$Success\n*L\n174#1:203\n174#1:204,3\n*E\n"})
    public static final /* data */ class Success extends MediaPickerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        public final List<PickedMedia> items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(@NotNull List<PickedMedia> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "items");
            this.items = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success c(Success success, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = success.items;
            }
            return success.b(list);
        }

        @NotNull
        public final List<PickedMedia> a() {
            return this.items;
        }

        @NotNull
        public final Success b(@NotNull List<PickedMedia> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new Success(items);
        }

        @Nullable
        public final PickedMedia d() {
            return (PickedMedia) CollectionsKt.firstOrNull(this.items);
        }

        @Nullable
        public final String e() {
            PickedMedia pickedMediaD = d();
            if (pickedMediaD != null) {
                return pickedMediaD.e();
            }
            return null;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.items, ((Success) other).items);
        }

        @NotNull
        public final List<PickedMedia> f() {
            return this.items;
        }

        @NotNull
        public final List<String> g() {
            List<PickedMedia> list = this.items;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((PickedMedia) it.next()).e());
            }
            return arrayList;
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        @NotNull
        public String toString() {
            return "Success(items=" + this.items + ")";
        }
    }

    public MediaPickerResult() {
    }

    public /* synthetic */ MediaPickerResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
