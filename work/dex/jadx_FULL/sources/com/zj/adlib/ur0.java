package com.zj.adlib;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00022\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/ur0;", "", "T", "", "data", "Ljava/lang/reflect/Type;", "listType", "stringToObject", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "someObjects", "objectToString", "(Ljava/lang/Object;)Ljava/lang/String;", "", "stringToObjectList", "objectListToString", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public class ur0 {

    @NotNull
    private final Gson gson = new Gson();

    @NotNull
    public final <T> String objectListToString(@Nullable List<? extends T> someObjects) {
        String json = this.gson.toJson(someObjects);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }

    @NotNull
    public final <T> String objectToString(@Nullable T someObjects) {
        String json = this.gson.toJson(someObjects);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }

    @Nullable
    public final <T> T stringToObject(@Nullable String data, @NotNull Type listType) {
        Intrinsics.checkNotNullParameter(listType, "listType");
        if (data == null || data.length() == 0) {
            return null;
        }
        return (T) this.gson.fromJson(data, listType);
    }

    @NotNull
    public final <T> List<T> stringToObjectList(@Nullable String data, @NotNull Type listType) {
        Intrinsics.checkNotNullParameter(listType, "listType");
        if (data == null || data.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = this.gson.fromJson(data, listType);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(data, listType)");
        return (List) objFromJson;
    }
}
