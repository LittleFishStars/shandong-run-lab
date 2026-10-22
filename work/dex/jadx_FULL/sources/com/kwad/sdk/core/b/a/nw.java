package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nw implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString(VideoPlayerActivity.t);
        if (JSONObject.NULL.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (JSONObject.NULL.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    private static JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, VideoPlayerActivity.t, videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j = videoInfo.duration;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration", j);
        }
        int i = videoInfo.size;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "size", i);
        }
        int i2 = videoInfo.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", i2);
        }
        int i3 = videoInfo.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", i3);
        }
        double d = videoInfo.leftRatio;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leftRatio", d);
        }
        double d2 = videoInfo.topRatio;
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "topRatio", d2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
