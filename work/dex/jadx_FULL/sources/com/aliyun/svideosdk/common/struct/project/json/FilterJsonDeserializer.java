package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.project.EffectTrack;
import com.aliyun.svideosdk.common.struct.project.Filter;
import com.aliyun.svideosdk.common.struct.project.MVFilter;
import com.aliyun.svideosdk.common.struct.project.TimeFilter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FilterJsonDeserializer implements JsonDeserializer<EffectTrack> {

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.project.json.FilterJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25686a;

        static {
            int[] iArr = new int[EffectTrack.Type.values().length];
            f25686a = iArr;
            try {
                iArr[EffectTrack.Type.time_effect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25686a[EffectTrack.Type.mv.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25686a[EffectTrack.Type.filter.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25686a[EffectTrack.Type.animation_filter.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25686a[EffectTrack.Type.lut_filter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public EffectTrack deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("Type")) {
            return null;
        }
        try {
            int i = AnonymousClass1.f25686a[EffectTrack.Type.valueOf(asJsonObject.get("Type").getAsString()).ordinal()];
            if (i == 1) {
                return (EffectTrack) jsonDeserializationContext.deserialize(jsonElement, TimeFilter.class);
            }
            if (i == 2) {
                return (EffectTrack) jsonDeserializationContext.deserialize(jsonElement, MVFilter.class);
            }
            if (i == 3 || i == 4 || i == 5) {
                return (EffectTrack) jsonDeserializationContext.deserialize(jsonElement, Filter.class);
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
