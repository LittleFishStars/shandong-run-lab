package com.zj.adlib;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lcom/zj/adlib/vs8;", "", "", "data", "", "b", "someObjects", "a", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class vs8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Gson gson = new Gson();

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/zj/adlib/vs8$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends TypeToken<List<? extends String>> {
    }

    @TypeConverter
    @NotNull
    public final String a(@Nullable List<String> someObjects) {
        String json = this.gson.toJson(someObjects);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }

    @TypeConverter
    @NotNull
    public final List<String> b(@Nullable String data) {
        if (data == null || data.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = this.gson.fromJson(data, new a().getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(data, listType)");
        return (List) objFromJson;
    }
}
