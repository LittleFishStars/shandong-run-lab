package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.byazt.bog.a;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 84, 85})
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    private Map<String, String> sp;
    public final String TAG = MediationConstant.TAG;
    private String c = "";
    private String tt = "";
    private String ve = "";
    private int uj = 0;
    private String n = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29315a = "";

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = (MediationConfigUserInfoForSegment) obj;
            boolean z2 = getAge() == mediationConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), mediationConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), mediationConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), mediationConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), mediationConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), mediationConfigUserInfoForSegment.getGender());
            Map<String, String> customInfos = mediationConfigUserInfoForSegment.getCustomInfos();
            Map<String, String> map = this.sp;
            if (map == null || customInfos == null) {
                z = map == null && customInfos == null;
            } else {
                if (map.size() == customInfos.size()) {
                    Iterator<String> it = this.sp.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(this.sp.get(next), customInfos.get(next))) {
                            }
                        }
                    }
                }
            }
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public int getAge() {
        return this.uj;
    }

    @Nullable
    public String getChannel() {
        return this.tt;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.sp;
    }

    @Nullable
    public String getGender() {
        return this.n;
    }

    @Nullable
    public String getSubChannel() {
        return this.ve;
    }

    @Nullable
    public String getUserId() {
        return this.c;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.f29315a;
    }

    public void setAge(int i) {
        this.uj = i;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.tt = str;
        } else {
            a.n(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.sp = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    a.n(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (checkValid(entry.getValue())) {
                    this.sp.put(entry.getKey(), entry.getValue());
                } else {
                    a.n(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.n = str;
        } else {
            a.n(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.ve = str;
        } else {
            a.n(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.c = str;
        } else {
            a.n(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f29315a = str;
        } else {
            a.n(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }
}
