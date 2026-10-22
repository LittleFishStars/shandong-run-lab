package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.ActionFade;
import com.aliyun.svideosdk.common.struct.effect.ActionRotate;
import com.aliyun.svideosdk.common.struct.effect.ActionRotateBy;
import com.aliyun.svideosdk.common.struct.effect.ActionRotateTo;
import com.aliyun.svideosdk.common.struct.effect.ActionScale;
import com.aliyun.svideosdk.common.struct.effect.ActionSet;
import com.aliyun.svideosdk.common.struct.effect.ActionShader;
import com.aliyun.svideosdk.common.struct.effect.ActionTranslate;
import com.aliyun.svideosdk.common.struct.effect.ActionWipe;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionJsonDeserializer implements JsonDeserializer<ActionBase> {

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.project.json.ActionJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25683a;

        static {
            int[] iArr = new int[ActionBase.Type.values().length];
            f25683a = iArr;
            try {
                iArr[ActionBase.Type.alpha.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25683a[ActionBase.Type.scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25683a[ActionBase.Type.translate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25683a[ActionBase.Type.rotate_repeat.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25683a[ActionBase.Type.rotate_by.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25683a[ActionBase.Type.rotate_to.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25683a[ActionBase.Type.swipe.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25683a[ActionBase.Type.custom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25683a[ActionBase.Type.action_set.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActionBase deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            switch (AnonymousClass1.f25683a[ActionBase.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()]) {
                case 1:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionFade.class);
                case 2:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionScale.class);
                case 3:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionTranslate.class);
                case 4:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionRotate.class);
                case 5:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionRotateBy.class);
                case 6:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionRotateTo.class);
                case 7:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionWipe.class);
                case 8:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionShader.class);
                case 9:
                    return (ActionBase) ProjectJSONSupportImpl.mGson.fromJson(jsonElement, ActionSet.class);
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
