package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkTrackEventBean {
    public String media_slot_id;
    public String request_id;
    public long request_time;
    public List<EventBean> track_event;

    @Keep
    public static class EventBean {
        public String ext1;
        public String ext2;
        public Map<String, String> ext_data;
        public int third_id;
        public String third_slot_id;
        public long time;
        public TrackEventEnum type;

        public EventBean() {
            this.time = System.currentTimeMillis();
        }

        public EventBean(TrackEventEnum trackEventEnum) {
            this.type = trackEventEnum;
            this.time = System.currentTimeMillis();
        }

        public EventBean(TrackEventEnum trackEventEnum, long j) {
            this.type = trackEventEnum;
            this.time = j;
        }

        public EventBean(TrackEventEnum trackEventEnum, long j, String str) {
            this.type = trackEventEnum;
            this.time = j;
            this.ext1 = str;
        }

        public EventBean(TrackEventEnum trackEventEnum, long j, String str, String str2) {
            this.type = trackEventEnum;
            this.time = j;
            this.ext1 = str;
            this.ext2 = str2;
        }

        public EventBean(TrackEventEnum trackEventEnum, String str) {
            this.type = trackEventEnum;
            this.ext1 = str;
            this.time = System.currentTimeMillis();
        }

        public String getExt1() {
            return this.ext1;
        }

        public String getExt2() {
            return this.ext2;
        }

        public Map<String, String> getExt_data() {
            return this.ext_data;
        }

        public int getThird_id() {
            return this.third_id;
        }

        public String getThird_slot_id() {
            return this.third_slot_id;
        }

        public long getTime() {
            return this.time;
        }

        public TrackEventEnum getType() {
            return this.type;
        }

        public void setExt1(String str) {
            this.ext1 = str;
        }

        public void setExt2(String str) {
            this.ext2 = str;
        }

        public void setExt_data(Map<String, String> map) {
            this.ext_data = map;
        }

        public void setThird_id(int i) {
            this.third_id = i;
        }

        public void setThird_slot_id(String str) {
            this.third_slot_id = str;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public void setType(TrackEventEnum trackEventEnum) {
            this.type = trackEventEnum;
        }

        public String toString() {
            return dexg.dexa("UsbdlCfbo|uzqf>") + this.type + dexg.dexa("-!ujnf>") + this.time + dexg.dexa("-!uijse`je>") + this.third_id + dexg.dexa("-!uijse`tmpu`je>(") + this.third_slot_id + '\'' + dexg.dexa("-!fyu2>(") + this.ext1 + '\'' + dexg.dexa("-!fyu3>(") + this.ext2 + "'}";
        }
    }

    @Keep
    public enum TrackEventEnum {
        NotSet(0),
        AdInit(1),
        AdConfigReq(2),
        AdConfigRespSuccess(3),
        AdConfigRespFailure(4),
        AdBidReq(5),
        AdBidRespSuccess(6),
        AdBidRespFailure(7),
        AdSdkBidReq(8),
        AdSdkBidRespSuccess(9),
        AdSdkBidRespFailure(10),
        AdCacheReq(11),
        AdCacheRespSuccess(12),
        AdCacheRespFailure(13),
        AdBidFinish(14),
        AdWin(15),
        AdSdkPrepareSuccess(16),
        AdSdkPrepareFailure(17),
        AdSdkDisplayReq(18),
        AdSdkDisplayRespSuccess(19),
        AdSdkDisplayRespFailure(20),
        AdClick(21);

        public int typeId;

        TrackEventEnum(int i) {
            this.typeId = i;
        }
    }

    public void addEvent(EventBean eventBean) {
        if (this.track_event == null) {
            this.track_event = new ArrayList();
        }
        this.track_event.add(eventBean);
    }

    public String getMedia_slot_id() {
        return this.media_slot_id;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public long getRequest_time() {
        return this.request_time;
    }

    public List<EventBean> getTrack_event() {
        return this.track_event;
    }

    public void setMedia_slot_id(String str) {
        this.media_slot_id = str;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setRequest_time(long j) {
        this.request_time = j;
    }

    public void setTrack_event(List<EventBean> list) {
        this.track_event = list;
    }

    public String toString() {
        return dexg.dexa("TelUsbdlSfqpsuCfbo|sfrvftu`je>(") + this.request_id + '\'' + dexg.dexa("-!sfrvftu`ujnf>") + this.request_time + dexg.dexa("-!nfejb`tmpu`je>(") + this.media_slot_id + '\'' + dexg.dexa("-!epu>") + this.track_event + '}';
    }
}
