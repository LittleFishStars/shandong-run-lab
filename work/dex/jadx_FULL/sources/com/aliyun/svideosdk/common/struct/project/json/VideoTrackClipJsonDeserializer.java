package com.aliyun.svideosdk.common.struct.project.json;

import com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoTrackClipJsonDeserializer implements JsonDeserializer<VideoTrackClip> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public VideoTrackClip deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("ClassType")) {
            return (VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, MainVideoTrackClip.class);
        }
        try {
            return "pip".equalsIgnoreCase(asJsonObject.get("ClassType").getAsString()) ? (VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, PipVideoTrackClip.class) : (VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, MainVideoTrackClip.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
