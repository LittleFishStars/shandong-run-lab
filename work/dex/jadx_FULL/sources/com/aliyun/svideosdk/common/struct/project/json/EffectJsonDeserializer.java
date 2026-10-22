package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.effect.BlurBackground;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.effect.TransitionCircle;
import com.aliyun.svideosdk.common.struct.effect.TransitionFade;
import com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar;
import com.aliyun.svideosdk.common.struct.effect.TransitionShutter;
import com.aliyun.svideosdk.common.struct.effect.TransitionTranslate;
import com.aliyun.svideosdk.common.struct.project.AudioEffect;
import com.aliyun.svideosdk.common.struct.project.AudioFade;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.RunningDisplayMode;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EffectJsonDeserializer implements JsonDeserializer<Effect> {

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.project.json.EffectJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25684a;

        static {
            int[] iArr = new int[Effect.Type.values().length];
            f25684a = iArr;
            try {
                iArr[Effect.Type.blur_background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25684a[Effect.Type.running_display_mode.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25684a[Effect.Type.transition.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25684a[Effect.Type.audio_effect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25684a[Effect.Type.audio_fade.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Effect a(JsonElement jsonElement, int i, JsonDeserializationContext jsonDeserializationContext) {
        try {
            if (i == 0) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionShutter.class);
            }
            if (i == 1) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionTranslate.class);
            }
            if (i == 2) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionCircle.class);
            }
            if (i == 3) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionFiveStar.class);
            }
            if (i == 4) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionFade.class);
            }
            if (i != 5) {
                return null;
            }
            return (Effect) jsonDeserializationContext.deserialize(jsonElement, TransitionBase.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Effect deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            int i = AnonymousClass1.f25684a[Effect.Type.valueOf(asJsonObject.get("Type").getAsString()).ordinal()];
            if (i == 1) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, BlurBackground.class);
            }
            if (i == 2) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, RunningDisplayMode.class);
            }
            if (i == 3) {
                return a(jsonElement, asJsonObject.get("TransitionType").getAsInt(), jsonDeserializationContext);
            }
            if (i == 4) {
                return (Effect) jsonDeserializationContext.deserialize(jsonElement, AudioEffect.class);
            }
            if (i != 5) {
                return null;
            }
            return (Effect) jsonDeserializationContext.deserialize(jsonElement, AudioFade.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
