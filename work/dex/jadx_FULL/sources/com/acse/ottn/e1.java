package com.acse.ottn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e1<T> implements Converter<T, RequestBody> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaType f22968a = MediaType.parse("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(T t) throws IOException {
        return RequestBody.create(f22968a, JSON.toJSONBytes(t, new SerializerFeature[0]));
    }
}
