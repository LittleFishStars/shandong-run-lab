package com.huachenjie.works.database;

import androidx.room.TypeConverter;
import com.google.gson.reflect.TypeToken;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.zj.adlib.ur0;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\b\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/database/PubWorkMediaListTypeConverter;", "Lcom/zj/adlib/ur0;", "", "data", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "stringToMediaList", "someObjects", "mediaListToString", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PubWorkMediaListTypeConverter extends ur0 {
    @TypeConverter
    @NotNull
    public final String mediaListToString(@Nullable List<PubWorkMediaData> someObjects) {
        return objectListToString(someObjects);
    }

    @TypeConverter
    @NotNull
    public final List<PubWorkMediaData> stringToMediaList(@Nullable String data) {
        Type type = new TypeToken<List<? extends PubWorkMediaData>>() { // from class: com.huachenjie.works.database.PubWorkMediaListTypeConverter.stringToMediaList.1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<List<…orkMediaData>?>() {}.type");
        return stringToObjectList(data, type);
    }
}
