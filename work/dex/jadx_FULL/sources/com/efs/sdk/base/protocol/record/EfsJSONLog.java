package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.config.GlobalInfo;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class EfsJSONLog extends AbsRecordLog {
    private long beginTime;
    private long endTime;

    public EfsJSONLog(String str) {
        super(str);
        put("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String strGenerateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", strGenerateString);
        }
        return strGenerateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return new JSONObject(this.dataMap).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogBeginTime() {
        return this.beginTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogEndTime() {
        return this.endTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogBeginTime(long j) {
        this.beginTime = j;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogEndTime(long j) {
        this.endTime = j;
    }
}
