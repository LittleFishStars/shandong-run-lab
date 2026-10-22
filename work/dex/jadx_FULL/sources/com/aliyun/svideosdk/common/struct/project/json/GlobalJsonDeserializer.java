package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.project.GlobalTrack;
import com.aliyun.svideosdk.common.struct.project.PaintTrack;
import com.aliyun.svideosdk.common.struct.project.TailWaterMark;
import com.aliyun.svideosdk.common.struct.project.WaterMark;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GlobalJsonDeserializer implements JsonDeserializer<GlobalTrack> {

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.project.json.GlobalJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25687a;

        static {
            int[] iArr = new int[GlobalTrack.Type.values().length];
            f25687a = iArr;
            try {
                iArr[GlobalTrack.Type.paint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25687a[GlobalTrack.Type.watermark.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25687a[GlobalTrack.Type.tail_watermark.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GlobalTrack deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            int i = AnonymousClass1.f25687a[GlobalTrack.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()];
            if (i == 1) {
                return (GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, PaintTrack.class);
            }
            if (i == 2) {
                return (GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, WaterMark.class);
            }
            if (i != 3) {
                return null;
            }
            return (GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, TailWaterMark.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
