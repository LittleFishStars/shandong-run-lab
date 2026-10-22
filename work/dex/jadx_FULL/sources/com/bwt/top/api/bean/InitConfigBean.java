package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InitConfigBean implements Serializable {

    @JSONField(name = "channelUrlList")
    private List<ChannelUrlBean> channelUrlList;

    @JSONField(name = "infoConfigBoList")
    private List<PlatformInfoBean> platformInfoList;

    @JSONField(name = "posIdRelationList")
    private List<PosInfoBean> posInfoList;

    @JSONField(name = "reportUrlList")
    private List<ReportInfoBean> reportInfoList;

    public class a implements Comparator<PlatformInfoBean> {
        public a(InitConfigBean initConfigBean) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PlatformInfoBean platformInfoBean, PlatformInfoBean platformInfoBean2) {
            return platformInfoBean.getSort() - platformInfoBean2.getSort();
        }
    }

    public List<ChannelUrlBean> getChannelUrlList() {
        return this.channelUrlList;
    }

    public List<PlatformInfoBean> getPlatformInfoList() {
        return this.platformInfoList;
    }

    public List<PosInfoBean> getPosInfoList() {
        return this.posInfoList;
    }

    public List<? extends ReportInfoBean> getReportInfoList() {
        return this.reportInfoList;
    }

    public void setChannelUrlList(List<ChannelUrlBean> list) {
        this.channelUrlList = list;
    }

    public void setPlatformInfoList(List<PlatformInfoBean> list) {
        Collections.sort(list, new a(this));
        this.platformInfoList = list;
    }

    public void setPosInfoList(List<PosInfoBean> list) {
        this.posInfoList = list;
    }

    public void setReportInfoList(List<ReportInfoBean> list) {
        this.reportInfoList = list;
    }

    public String toString() {
        return "InitConfigBean{platformInfoList=" + this.platformInfoList + ", posInfoList=" + this.posInfoList + ", reportInfoList=" + this.reportInfoList + ", channelUrlList=" + this.channelUrlList + '}';
    }
}
