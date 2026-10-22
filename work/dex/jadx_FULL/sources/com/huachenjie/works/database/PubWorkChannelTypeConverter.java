package com.huachenjie.works.database;

import androidx.room.TypeConverter;
import com.google.gson.reflect.TypeToken;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.zj.adlib.ur0;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/database/PubWorkChannelTypeConverter;", "Lcom/zj/adlib/ur0;", "", "data", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "stringToChannel", "someObjects", "channelToString", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PubWorkChannelTypeConverter extends ur0 {
    @TypeConverter
    @NotNull
    public final String channelToString(@Nullable PubWorkChannelBean someObjects) {
        return objectToString(someObjects);
    }

    @TypeConverter
    @Nullable
    public final PubWorkChannelBean stringToChannel(@Nullable String data) {
        Type type = new TypeToken<PubWorkChannelBean>() { // from class: com.huachenjie.works.database.PubWorkChannelTypeConverter.stringToChannel.1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<PubWorkChannelBean?>() {}.type");
        return (PubWorkChannelBean) stringToObject(data, type);
    }
}
