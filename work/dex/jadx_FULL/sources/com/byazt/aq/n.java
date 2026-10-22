package com.byazt.aq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 46})
public class n {
    public static final Map<String, Integer> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f28294a;
    public a n;
    public String sp;
    public String tt;
    public String uj;
    public String ve;

    static {
        HashMap map = new HashMap();
        c = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put(MediaFormat.KEY_SUBTITLE, 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put(com.byazt.dyf.tt.AD_TAG_DISLIKE, 3);
        map.put("close", 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put(FreeSpaceBox.TYPE, 27);
        map.put("timedown", 13);
        map.put(RemoteMessageConst.Notification.ICON, 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
        map.put("image-flip-slide", 29);
    }

    public int a() {
        return this.n.yf();
    }

    public int c() {
        if (TextUtils.isEmpty(this.tt)) {
            return 0;
        }
        if (this.tt.equals("logo")) {
            String str = this.tt + this.ve;
            this.tt = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.tt.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = c;
        if (map.get(this.tt) != null) {
            return map.get(this.tt).intValue();
        }
        return -1;
    }

    public String getType() {
        return this.tt;
    }

    public a n() {
        return this.n;
    }

    public a sp() {
        return this.f28294a;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.tt + "', data='" + this.ve + "', value=" + this.n + ", themeValue=" + this.f28294a + ", dataExtraInfo='" + this.sp + "'}";
    }

    public String tt() {
        return this.ve;
    }

    public void uj(String str) {
        this.sp = str;
    }

    public String ve() {
        return this.uj;
    }

    public void tt(String str) {
        this.ve = str;
    }

    public String uj() {
        return this.sp;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public void tt(a aVar) {
        this.f28294a = aVar;
    }

    public void c(String str) {
        this.tt = str;
    }

    public void c(a aVar) {
        this.n = aVar;
    }
}
