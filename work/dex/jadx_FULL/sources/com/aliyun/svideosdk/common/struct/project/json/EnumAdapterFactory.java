package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.EffectTrack;
import com.aliyun.svideosdk.common.struct.project.GlobalTrack;
import com.aliyun.svideosdk.common.struct.project.PasterTrack;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnumAdapterFactory implements TypeAdapterFactory {

    public class EnumTypeAdapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TypeToken<T> f25685a;

        public EnumTypeAdapter(EnumAdapterFactory enumAdapterFactory, TypeToken<T> typeToken) {
            this.f25685a = typeToken;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public T read2(JsonReader jsonReader) {
            try {
                return (T) ((Object[]) this.f25685a.getRawType().getMethod("values", new Class[0]).invoke(null, new Object[0]))[jsonReader.nextInt()];
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(Enum.valueOf(t.getClass().asSubclass(Enum.class), t.toString()).ordinal());
            }
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (rawType.equals(GlobalTrack.Type.class) || rawType.equals(PasterTrack.Type.class) || rawType.equals(ActionBase.Type.class) || rawType.equals(EffectTrack.Type.class) || rawType.equals(Effect.Type.class) || !rawType.isEnum()) {
            return null;
        }
        return new EnumTypeAdapter(this, typeToken);
    }
}
