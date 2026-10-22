package cn.hzjizhun.admin.api.bean;

import cn.hzjizhun.admin.util.ALog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InitConfigBean implements Serializable {
    private List<ChannelUrlBean> channelUrlList;
    private List<PlatformInfoBean> platformInfoList;
    private List<PosInfoBean> posInfoList;
    private List<String> qAppList;
    private List<ReportInfoBean> reportInfoList;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PlatformInfoBean platformInfoBean, PlatformInfoBean platformInfoBean2) {
            return platformInfoBean.getSort() - platformInfoBean2.getSort();
        }
    }

    public static InitConfigBean toBean(String str) {
        InitConfigBean initConfigBean = new InitConfigBean();
        try {
            ALog.d("InitConfigBean: " + str);
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("infoConfigBoList");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(PlatformInfoBean.toBean(jSONArrayOptJSONArray.optString(i)));
                }
                initConfigBean.setPlatformInfoList(arrayList);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("posIdRelationList");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    arrayList2.add(PosInfoBean.toBean(jSONArrayOptJSONArray2.optString(i2)));
                }
                initConfigBean.posInfoList = arrayList2;
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("reportUrlList");
            if (jSONArrayOptJSONArray3 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    arrayList3.add(ReportInfoBean.toBean(jSONArrayOptJSONArray3.optString(i3)));
                }
                initConfigBean.reportInfoList = arrayList3;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("channelUrlList");
            if (jSONArrayOptJSONArray4 != null) {
                ArrayList arrayList4 = new ArrayList();
                for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                    arrayList4.add(ChannelUrlBean.toBean(jSONArrayOptJSONArray4.optString(i4)));
                }
                initConfigBean.channelUrlList = arrayList4;
            }
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("qAppList");
            if (jSONArrayOptJSONArray5 != null) {
                ArrayList arrayList5 = new ArrayList();
                for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                    arrayList5.add(jSONArrayOptJSONArray5.optString(i5));
                }
                initConfigBean.qAppList = arrayList5;
            }
        } catch (Throwable unused) {
        }
        return initConfigBean;
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

    public List<String> getqAppList() {
        return this.qAppList;
    }

    public void setPlatformInfoList(List<PlatformInfoBean> list) {
        Collections.sort(list, new a());
        this.platformInfoList = list;
    }

    public String toString() {
        return "InitConfigBean{platformInfoList=" + this.platformInfoList + ", posInfoList=" + this.posInfoList + ", reportInfoList=" + this.reportInfoList + ", channelUrlList=" + this.channelUrlList + '}';
    }
}
