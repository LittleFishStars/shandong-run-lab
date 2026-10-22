package com.heytap.msp.push.mode;

import android.text.TextUtils;
import com.heytap.mcssdk.utils.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MessageStat {
    private static final String APP_PACKAGE = "appPackage";
    private static final String DATA_EXTRA = "data_extra";
    private static final String EVENT_ID = "eventID";
    private static final String EVENT_TIME = "eventTime";
    private static final String GLOBAL_ID = "globalID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String PROPERTY = "property";
    private static final String STATISTICS_EXTRA = "statistics_extra";
    private static final String TASK_ID = "taskID";
    private String mAppPackage;
    private String mDataExtra;
    private String mEventId;
    private long mEventTime;
    private String mGlobalId;
    private String mProperty;
    private String mStatisticsExtra;
    private String mTaskID;
    private int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    public MessageStat(int i, String str, String str2, String str3) {
        this(i, str, null, null, str2, str3);
    }

    public MessageStat(int i, String str, String str2, String str3, String str4, String str5) {
        this(i, str, str2, str3, str4, str5, "", "");
    }

    public MessageStat(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(i);
        setAppPackage(str);
        setGlobalId(str2);
        setTaskID(str3);
        setEventId(str4);
        setProperty(str5);
        setStatisticsExtra(str6);
        setDataExtra(str7);
    }

    public MessageStat(String str, String str2) {
        this(4096, str, null, null, str2, "");
    }

    public MessageStat(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
    }

    public static MessageStat parse(String str) {
        MessageStat messageStat = new MessageStat();
        try {
            JSONObject jSONObject = new JSONObject(str);
            messageStat.setType(jSONObject.optInt(MESSAGE_TYPE, 0));
            messageStat.setAppPackage(jSONObject.optString("appPackage"));
            messageStat.setEventId(jSONObject.optString(EVENT_ID));
            messageStat.setGlobalId(jSONObject.optString("globalID", ""));
            messageStat.setTaskID(jSONObject.optString("taskID", ""));
            messageStat.setProperty(jSONObject.optString(PROPERTY, ""));
            messageStat.setEventTime(jSONObject.optLong("eventTime", System.currentTimeMillis()));
            messageStat.setStatisticsExtra(jSONObject.optString("statistics_extra"));
            messageStat.setDataExtra(jSONObject.optString("data_extra"));
            return messageStat;
        } catch (Exception e) {
            d.e(e.getLocalizedMessage());
            return null;
        }
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getDataExtra() {
        return this.mDataExtra;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public String getProperty() {
        return this.mProperty;
    }

    public String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public int getType() {
        return this.mType;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setDataExtra(String str) {
        this.mDataExtra = str;
    }

    public void setEventId(String str) {
        this.mEventId = str;
    }

    public void setEventTime(long j) {
        this.mEventTime = j;
    }

    public void setGlobalId(String str) {
        this.mGlobalId = str;
    }

    public void setProperty(String str) {
        this.mProperty = str;
    }

    public void setStatisticsExtra(String str) {
        this.mStatisticsExtra = str;
    }

    public void setTaskID(int i) {
        this.mTaskID = String.valueOf(i);
    }

    public void setTaskID(String str) {
        this.mTaskID = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MESSAGE_TYPE, Integer.valueOf(this.mType));
            jSONObject.putOpt(EVENT_ID, this.mEventId);
            jSONObject.putOpt("appPackage", this.mAppPackage);
            jSONObject.putOpt("eventTime", Long.valueOf(this.mEventTime));
            if (!TextUtils.isEmpty(this.mGlobalId)) {
                jSONObject.putOpt("globalID", this.mGlobalId);
            }
            if (!TextUtils.isEmpty(this.mTaskID)) {
                jSONObject.putOpt("taskID", this.mTaskID);
            }
            if (!TextUtils.isEmpty(this.mProperty)) {
                jSONObject.putOpt(PROPERTY, this.mProperty);
            }
            if (!TextUtils.isEmpty(this.mStatisticsExtra)) {
                jSONObject.putOpt("statistics_extra", this.mStatisticsExtra);
            }
            if (!TextUtils.isEmpty(this.mDataExtra)) {
                jSONObject.putOpt("data_extra", this.mDataExtra);
            }
        } catch (Exception e) {
            d.e(e.getLocalizedMessage());
        }
        return jSONObject.toString();
    }
}
