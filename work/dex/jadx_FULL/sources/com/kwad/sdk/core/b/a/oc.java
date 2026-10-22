package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class oc implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }

    private static void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = videoPosition.leftMarginRation;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leftMarginRation", d);
        }
        double d2 = videoPosition.topMarginRation;
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "topMarginRation", d2);
        }
        double d3 = videoPosition.widthRation;
        if (d3 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "widthRation", d3);
        }
        double d4 = videoPosition.heightWidthRation;
        if (d4 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "heightWidthRation", d4);
        }
        int i = videoPosition.leftMargin;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leftMargin", i);
        }
        int i2 = videoPosition.topMargin;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "topMargin", i2);
        }
        int i3 = videoPosition.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", i3);
        }
        int i4 = videoPosition.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", i4);
        }
        int i5 = videoPosition.borderRadius;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "borderRadius", i5);
        }
        return jSONObject;
    }
}
