package com.byazt.ut;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.byakv.z.SoftDecTool;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 54})
public class ve implements com.byazt.dna.n, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -1:
                pglArmorCallApiCancelListener();
                return null;
            case 0:
            case 14:
            case 19:
            case 26:
            default:
                return null;
            case 1:
                return encrypt((byte[]) sparseArray.get(1));
            case 2:
                return Boolean.valueOf(getArmorLoadStatus());
            case 3:
                return decryptWithCBC((String) sparseArray.get(1));
            case 4:
                return decrypt((byte[]) sparseArray.get(1));
            case 5:
                return Boolean.valueOf(signVerifyMD5withRSA((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 6:
                return Boolean.valueOf(detectHostLocalIp((String) sparseArray.get(1)));
            case 7:
                return getSoftChara();
            case 8:
                pglArmorCallApi2c((MotionEvent) sparseArray.get(1));
                return null;
            case 9:
                return pglArmorCallApi2ccc((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 10:
                pglArmorCallApi2src(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 11:
                return pglArmorCallApi2getProperty((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 12:
                return getArmorContext();
            case 13:
                return getArchEnv();
            case 15:
                softDecTool2ua(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 16:
                Object aVar = sparseArray.get(1);
                if (aVar != null) {
                    aVar = new com.byazt.dna.a((Function) aVar);
                }
                setHARSensorCallBack((com.byazt.dna.n.c) aVar);
                return null;
            case 17:
                return Boolean.valueOf(registerHarSensors());
            case 18:
                Object spVar = sparseArray.get(1);
                if (spVar != null) {
                    spVar = new com.byazt.dna.sp((Function) spVar);
                }
                initPglArmorCallApi((com.byazt.dna.n.tt) spVar);
                return null;
            case 20:
                updateScreenStatus((String) sparseArray.get(1));
                return null;
            case 21:
                updateNetworkStatus(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 22:
                return Integer.valueOf(getSpecificArmorLoadStatus());
            case 23:
                updateHARSettings((JSONObject) sparseArray.get(1));
                return null;
            case 24:
                initPglCryptUtils();
                return null;
            case 25:
                return Boolean.valueOf(enableSetHARSensorCallBack(((Integer) sparseArray.get(1)).intValue()));
            case 27:
                return encryptBody((JSONObject) sparseArray.get(1));
            case 28:
                return decryptAESWithCBC((String) sparseArray.get(1));
            case 29:
                return encryptAESWithCBC((String) sparseArray.get(1));
        }
    }

    @Override // com.byazt.dna.n
    public byte[] decrypt(byte[] bArr) {
        return com.byazt.qi.i.c().tt(bArr);
    }

    @Override // com.byazt.dna.n
    public String decryptAESWithCBC(String str) {
        return com.byazt.nr.c.ve(str);
    }

    @Override // com.byazt.dna.n
    public String decryptWithCBC(String str) {
        return com.byazt.qi.i.c().c(str);
    }

    @Override // com.byazt.dna.n
    public boolean detectHostLocalIp(String str) {
        return com.byazt.qi.uj.c(str);
    }

    @Override // com.byazt.dna.n
    public boolean enableSetHARSensorCallBack(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zTt = com.byazt.gf.n.c().tt();
        boolean z = ((long) (i - 1)) % com.byazt.gf.n.c().n() == 0;
        boolean z2 = jCurrentTimeMillis - com.byazt.gf.uj.c().uj() > com.byazt.gf.n.c().uj();
        boolean zVe = com.byazt.gf.uj.c().ve();
        com.byazt.gf.n.c();
        com.byazt.gf.n.c();
        com.byazt.gf.n.c();
        com.byazt.gf.n.c();
        double d = SoftDecTool.acs;
        long j = SoftDecTool.act;
        return z && z2 && zTt && !zVe;
    }

    @Override // com.byazt.dna.n
    public byte[] encrypt(byte[] bArr) {
        return com.byazt.qi.i.c().c(bArr);
    }

    @Override // com.byazt.dna.n
    public String encryptAESWithCBC(String str) {
        return com.byazt.nr.c.tt(str);
    }

    @Override // com.byazt.dna.n
    public String encryptBody(JSONObject jSONObject) {
        JSONObject jSONObjectC = com.byazt.qi.i.c().c(jSONObject);
        return jSONObjectC != null ? jSONObjectC.toString() : "";
    }

    @Override // com.byazt.dna.n
    public String getArchEnv() {
        return com.byazt.qi.a.tt();
    }

    @Override // com.byazt.dna.n
    public Context getArmorContext() {
        return com.byazt.qi.a.ve();
    }

    @Override // com.byazt.dna.n
    public boolean getArmorLoadStatus() {
        return com.byazt.qi.i.tt();
    }

    @Override // com.byazt.dna.n
    public String getSoftChara() {
        return com.byazt.qi.a.c(com.byazt.aas.ve.c);
    }

    @Override // com.byazt.dna.n
    public int getSpecificArmorLoadStatus() {
        return com.byazt.qi.i.ve();
    }

    @Override // com.byazt.dna.n
    public void initPglArmorCallApi(final com.byazt.dna.n.tt ttVar) {
        com.byazt.qi.sp.c cVarC = new com.byazt.qi.sp.c(gt.getContext(), p.sp(), "7611").c(true);
        cVarC.c(new com.byazt.qi.x() { // from class: com.byazt.ut.ve.2
            @Override // com.byazt.qi.x
            public void c(long j, boolean z) {
                ttVar.setCryptInitStatus(j, z);
            }

            @Override // com.byazt.qi.x
            public void c(String str, JSONObject jSONObject) {
                ttVar.reportSoftDecData(str, jSONObject);
            }

            @Override // com.byazt.qi.x
            public long c() {
                return ttVar.getArmorFlags();
            }
        });
        com.byazt.qi.a.c(cVarC.c());
    }

    @Override // com.byazt.dna.n
    public void initPglCryptUtils() {
        com.byazt.qi.i.c();
    }

    @Override // com.byazt.dna.n
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        com.byazt.qi.a.c(motionEvent);
    }

    @Override // com.byazt.dna.n
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        return com.byazt.qi.a.c(str, j, i, z);
    }

    @Override // com.byazt.dna.n
    public String pglArmorCallApi2getProperty(String str, String str2) {
        return com.byazt.qi.a.c(str, str2);
    }

    @Override // com.byazt.dna.n
    public void pglArmorCallApi2src(long j, int i) {
        com.byazt.qi.a.c(j, i);
    }

    public void pglArmorCallApiCancelListener() {
        com.byazt.qi.a.c();
    }

    @Override // com.byazt.dna.n
    public boolean registerHarSensors() {
        return com.byazt.gf.uj.c().tt();
    }

    @Override // com.byazt.dna.n
    public void setHARSensorCallBack(final com.byazt.dna.n.c cVar) {
        com.byazt.gf.uj.c().c(new com.byazt.gf.uj.c() { // from class: com.byazt.ut.ve.1
            @Override // com.byazt.gf.uj.c
            public void c(JSONObject jSONObject) {
                cVar.reportSensorData(jSONObject);
            }
        });
    }

    @Override // com.byazt.dna.n
    public boolean signVerifyMD5withRSA(String str, String str2) throws Exception {
        return com.byazt.qi.uj.c(str, str2);
    }

    @Override // com.byazt.dna.n
    public void softDecTool2ua(double d, long j) {
        SoftDecTool.ua(d, j);
        double d2 = SoftDecTool.acs;
    }

    @Override // com.byazt.dna.n
    public void updateHARSettings(JSONObject jSONObject) {
        com.byazt.gf.n.c().c(jSONObject);
    }

    @Override // com.byazt.dna.n
    public void updateNetworkStatus(int i) {
        com.byazt.gf.tt.c().c(i);
    }

    @Override // com.byazt.dna.n
    public void updateScreenStatus(String str) {
        com.byazt.gf.tt.c().tt(str);
    }
}
