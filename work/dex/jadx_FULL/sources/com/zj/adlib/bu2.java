package com.zj.adlib;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bu2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<int[]> f40839a = new ArrayList();
    public final List<String> b = new ArrayList();

    public final void a(int[] iArr, String str) {
        this.f40839a.add(iArr);
        this.b.add(str);
    }

    public final synchronized void b() {
        if (this.f40839a.isEmpty()) {
            a(new int[]{0, 19}, "US/CA");
            a(new int[]{30, 39}, "US");
            a(new int[]{60, 139}, "US/CA");
            a(new int[]{300, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, "FR");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, "BG");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400}, "SI");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500}, "HR");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500}, "BA");
            a(new int[]{400, WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_LIKE}, "DE");
            a(new int[]{450, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME}, "JP");
            a(new int[]{460, 469}, "RU");
            a(new int[]{471}, "TW");
            a(new int[]{474}, "EE");
            a(new int[]{475}, "LV");
            a(new int[]{476}, "AZ");
            a(new int[]{477}, "LT");
            a(new int[]{478}, "UZ");
            a(new int[]{479}, "LK");
            a(new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, "PH");
            a(new int[]{481}, "BY");
            a(new int[]{482}, "UA");
            a(new int[]{484}, "MD");
            a(new int[]{485}, "AM");
            a(new int[]{486}, "GE");
            a(new int[]{ky5.j}, "KZ");
            a(new int[]{489}, "HK");
            a(new int[]{490, 499}, "JP");
            a(new int[]{500, 509}, "GB");
            a(new int[]{520}, "GR");
            a(new int[]{528}, ib3.p);
            a(new int[]{529}, "CY");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE}, "MK");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD}, "MT");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP}, "IE");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 549}, "BE/LU");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ}, AssistPushConsts.MSG_VALUE_PAYLOAD);
            a(new int[]{569}, "IS");
            a(new int[]{570, 579}, "DK");
            a(new int[]{590}, "PL");
            a(new int[]{594}, "RO");
            a(new int[]{SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR}, "HU");
            a(new int[]{600, 601}, "ZA");
            a(new int[]{603}, "GH");
            a(new int[]{608}, "BH");
            a(new int[]{609}, "MU");
            a(new int[]{611}, "MA");
            a(new int[]{613}, "DZ");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH}, "KE");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB}, "CI");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID}, "TN");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME}, "SY");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME}, "EG");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME}, "LY");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME}, "JO");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME}, "IR");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME}, "KW");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME}, "SA");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME}, "AE");
            a(new int[]{640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME}, "FI");
            a(new int[]{690, 695}, "CN");
            a(new int[]{700, 709}, "NO");
            a(new int[]{729}, "IL");
            a(new int[]{730, 739}, "SE");
            a(new int[]{740}, b.j);
            a(new int[]{741}, "SV");
            a(new int[]{742}, "HN");
            a(new int[]{743}, "NI");
            a(new int[]{744}, "CR");
            a(new int[]{745}, "PA");
            a(new int[]{746}, "DO");
            a(new int[]{750}, "MX");
            a(new int[]{754, 755}, "CA");
            a(new int[]{759}, "VE");
            a(new int[]{760, 769}, "CH");
            a(new int[]{770}, "CO");
            a(new int[]{773}, "UY");
            a(new int[]{775}, "PE");
            a(new int[]{777}, "BO");
            a(new int[]{779}, "AR");
            a(new int[]{780}, "CL");
            a(new int[]{784}, "PY");
            a(new int[]{785}, "PE");
            a(new int[]{786}, "EC");
            a(new int[]{789, 790}, "BR");
            a(new int[]{800, 839}, "IT");
            a(new int[]{840, 849}, "ES");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME}, "CU");
            a(new int[]{858}, "SK");
            a(new int[]{859}, "CZ");
            a(new int[]{860}, "YU");
            a(new int[]{865}, "MN");
            a(new int[]{867}, "KP");
            a(new int[]{868, TTAdConstant.VALUE_CLICK_AREA_OTHER}, "TR");
            a(new int[]{870, 879}, "NL");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE}, "KR");
            a(new int[]{885}, "TH");
            a(new int[]{888}, "SG");
            a(new int[]{890}, "IN");
            a(new int[]{893}, "VN");
            a(new int[]{896}, "PK");
            a(new int[]{899}, "ID");
            a(new int[]{900, 919}, "AT");
            a(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 939}, "AU");
            a(new int[]{940, 949}, "AZ");
            a(new int[]{955}, "MY");
            a(new int[]{958}, "MO");
        }
    }

    public String c(String str) {
        int[] iArr;
        int i;
        b();
        int i2 = Integer.parseInt(str.substring(0, 3));
        int size = this.f40839a.size();
        for (int i3 = 0; i3 < size && i2 >= (i = (iArr = this.f40839a.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (i2 <= i) {
                return this.b.get(i3);
            }
        }
        return null;
    }
}
