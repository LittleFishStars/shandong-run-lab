package com.byazt.dna;

import android.content.Context;
import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface n {

    public interface c {
        void reportSensorData(JSONObject jSONObject);
    }

    public interface tt {
        long getArmorFlags();

        void reportSoftDecData(String str, JSONObject jSONObject);

        void setCryptInitStatus(long j, boolean z);
    }

    byte[] decrypt(byte[] bArr);

    String decryptAESWithCBC(String str);

    String decryptWithCBC(String str);

    boolean detectHostLocalIp(String str);

    boolean enableSetHARSensorCallBack(int i);

    byte[] encrypt(byte[] bArr);

    String encryptAESWithCBC(String str);

    String encryptBody(JSONObject jSONObject);

    String getArchEnv();

    Context getArmorContext();

    boolean getArmorLoadStatus();

    String getSoftChara();

    int getSpecificArmorLoadStatus();

    void initPglArmorCallApi(tt ttVar);

    void initPglCryptUtils();

    void pglArmorCallApi2c(MotionEvent motionEvent);

    String pglArmorCallApi2ccc(String str, long j, int i, boolean z);

    String pglArmorCallApi2getProperty(String str, String str2);

    void pglArmorCallApi2src(long j, int i);

    boolean registerHarSensors();

    void setHARSensorCallBack(c cVar);

    boolean signVerifyMD5withRSA(String str, String str2) throws Exception;

    void softDecTool2ua(double d, long j);

    void updateHARSettings(JSONObject jSONObject);

    void updateNetworkStatus(int i);

    void updateScreenStatus(String str);
}
