package com.byazt.ds;

import android.content.Context;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 72})
public class da extends ve {
    public final Context n;

    public da(Context context) {
        super(true, false);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        String str;
        int iSp = com.byazt.yv.c.sp();
        switch (iSp) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case 420:
            case WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_LIKE /* 440 */:
            case GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH /* 480 */:
                str = "xxhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ /* 560 */:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", iSp);
        jSONObject.put("display_density", str);
        jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, com.byazt.yv.c.x() + "x" + com.byazt.yv.c.i());
        return true;
    }
}
