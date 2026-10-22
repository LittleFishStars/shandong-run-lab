package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.CaptionTrack;
import com.aliyun.svideosdk.common.struct.project.GifPasterTrack;
import com.aliyun.svideosdk.common.struct.project.PasterTrack;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.RollCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.SubTitleTrack;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PasterJsonDeserializer implements JsonDeserializer<PasterTrack> {

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.project.json.PasterJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25688a;

        static {
            int[] iArr = new int[PasterTrack.Type.values().length];
            f25688a = iArr;
            try {
                iArr[PasterTrack.Type.photo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25688a[PasterTrack.Type.gif.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25688a[PasterTrack.Type.subtitle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25688a[PasterTrack.Type.bubble_caption.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25688a[PasterTrack.Type.caption.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25688a[PasterTrack.Type.roll_captions.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public PasterTrack deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            switch (AnonymousClass1.f25688a[PasterTrack.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()]) {
                case 1:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, PhotoPasterTrack.class);
                case 2:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, GifPasterTrack.class);
                case 3:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, SubTitleTrack.class);
                case 4:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, BubbleCaptionTrack.class);
                case 5:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, CaptionTrack.class);
                case 6:
                    return (PasterTrack) jsonDeserializationContext.deserialize(jsonElement, RollCaptionTrack.class);
                default:
                    return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
