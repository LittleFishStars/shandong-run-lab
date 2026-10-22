package com.ipd.dsp.internal.e1;

import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements Serializable {
    public static final String k = "left";
    public static final String l = "top";
    public static final String m = "right";
    public static final String n = "bottom";
    public static final String o = "center";
    public static final String p = "img_txtfloat";
    public static final String q = "upimg_downtxt";
    public static final String r = "leftimg_righttxt";
    public static final String s = "video_txtfloat";
    public static final String t = "video_txtdown";
    public static final String u = "upvideo_downcard";
    public static final String v = "leftvideo_rightcard";
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;

    public f(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f = "center";
            this.g = "";
            this.h = "";
            this.i = "";
            return;
        }
        this.f = jSONObject.optString("image_location");
        this.g = jSONObject.optString("image_ratio");
        this.h = jSONObject.optString("image_size");
        this.i = jSONObject.optString("location_size");
        String str = this.f;
        str.getClass();
        switch (str) {
            case "img_txtfloat":
                this.j = 1;
                break;
            case "leftvideo_rightcard":
                this.j = 7;
                break;
            case "upimg_downtxt":
                this.j = 2;
                break;
            case "leftimg_righttxt":
                this.j = 3;
                break;
            case "video_txtdown":
                this.j = 5;
                break;
            case "video_txtfloat":
                this.j = 4;
                break;
            case "upvideo_downcard":
                this.j = 6;
                break;
            default:
                this.j = 0;
                break;
        }
    }

    public static float a(String str, float f) {
        try {
            String[] strArrSplit = str.split("x");
            return Float.parseFloat(strArrSplit[0]) / Float.parseFloat(strArrSplit[1]);
        } catch (Throwable unused) {
            return f;
        }
    }
}
