package com.igexin.push.extension.mod;

import android.text.TextUtils;
import com.igexin.push.core.e;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class PushTaskBean {
    private String action;
    private List<BaseActionBean> actionChains;
    private String appid;
    private Map<String, String> conditionMap;
    private int currentActionid;
    private int executeTimes;
    private String id;
    private String messageId;
    private String msgAddress;
    private byte[] msgExtra;
    private int perActionid;
    private int status;
    private String taskId;
    private String appKey = "";
    private boolean isHttpImg = false;
    private boolean isStop = false;

    public String getAction() {
        return this.action;
    }

    public BaseActionBean getActionByType(String str) {
        List<BaseActionBean> actionChains = getActionChains();
        if (actionChains == null) {
            return null;
        }
        for (BaseActionBean baseActionBean : actionChains) {
            if (baseActionBean.getType().equals(str)) {
                return baseActionBean;
            }
        }
        return null;
    }

    public List<BaseActionBean> getActionChains() {
        return this.actionChains;
    }

    public String getActionIdByType(String str) {
        List<BaseActionBean> actionChains = getActionChains();
        if (actionChains == null) {
            return null;
        }
        for (BaseActionBean baseActionBean : actionChains) {
            if (baseActionBean.getType().equals(str)) {
                return baseActionBean.getActionId();
            }
        }
        return null;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppid() {
        return this.appid;
    }

    public BaseActionBean getBaseAction(String str) {
        for (BaseActionBean baseActionBean : getActionChains()) {
            if (baseActionBean.getActionId().equals(str)) {
                return baseActionBean;
            }
        }
        return null;
    }

    public Map<String, String> getConditionMap() {
        return this.conditionMap;
    }

    public int getCurrentActionid() {
        return this.currentActionid;
    }

    public int getExecuteTimes() {
        return this.executeTimes;
    }

    public String getId() {
        return this.id;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsgAddress() {
        return this.msgAddress;
    }

    public byte[] getMsgExtra() {
        return this.msgExtra;
    }

    public int getPerActionid() {
        return this.perActionid;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public boolean isHttpImg() {
        return this.isHttpImg;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void parse(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("appid") && jSONObject.get("appid").equals(e.f38001a)) {
            this.appid = jSONObject.getString("appid");
        }
        if (jSONObject.has("appkey")) {
            this.appKey = jSONObject.getString("appkey");
        }
        if (jSONObject.has("taskid")) {
            this.taskId = jSONObject.getString("taskid");
        }
        if (jSONObject.has("messageid")) {
            this.messageId = jSONObject.getString("messageid");
        }
        if (TextUtils.isEmpty(this.appid)) {
            this.appid = e.f38001a;
        }
        this.currentActionid = 1;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setActionChains(List<BaseActionBean> list) {
        this.actionChains = list;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setConditionMap(Map<String, String> map) {
        this.conditionMap = map;
    }

    public void setCurrentActionid(int i) {
        this.currentActionid = i;
    }

    public void setExecuteTimes(int i) {
        this.executeTimes = i;
    }

    public void setHttpImg(boolean z) {
        this.isHttpImg = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgAddress(String str) {
        this.msgAddress = str;
    }

    public void setMsgExtra(byte[] bArr) {
        this.msgExtra = bArr;
    }

    public void setPerActionid(int i) {
        this.perActionid = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStop(boolean z) {
        this.isStop = z;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }
}
