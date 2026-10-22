package com.byazt.dna;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 71})
public class x implements n, Function {
    public volatile Function c;
    public volatile n tt;

    public x(n nVar) {
        this.tt = nVar;
    }

    public x(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.dna.n
    public byte[] decrypt(byte[] bArr) {
        if (this.tt != null) {
            return this.tt.decrypt(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        return (byte[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String decryptAESWithCBC(String str) {
        if (this.tt != null) {
            return this.tt.decryptAESWithCBC(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String decryptWithCBC(String str) {
        if (this.tt != null) {
            return this.tt.decryptWithCBC(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public boolean detectHostLocalIp(String str) {
        if (this.tt != null) {
            return this.tt.detectHostLocalIp(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.n
    public boolean enableSetHARSensorCallBack(int i) {
        if (this.tt != null) {
            return this.tt.enableSetHARSensorCallBack(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Integer.valueOf(i));
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.n
    public byte[] encrypt(byte[] bArr) {
        if (this.tt != null) {
            return this.tt.encrypt(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bArr);
        return (byte[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String encryptAESWithCBC(String str) {
        if (this.tt != null) {
            return this.tt.encryptAESWithCBC(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String encryptBody(JSONObject jSONObject) {
        if (this.tt != null) {
            return this.tt.encryptBody(jSONObject);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, jSONObject);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String getArchEnv() {
        if (this.tt != null) {
            return this.tt.getArchEnv();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public Context getArmorContext() {
        if (this.tt != null) {
            return this.tt.getArmorContext();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (Context) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public boolean getArmorLoadStatus() {
        if (this.tt != null) {
            return this.tt.getArmorLoadStatus();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.n
    public String getSoftChara() {
        if (this.tt != null) {
            return this.tt.getSoftChara();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public int getSpecificArmorLoadStatus() {
        if (this.tt != null) {
            return this.tt.getSpecificArmorLoadStatus();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.n
    public void initPglArmorCallApi(n.tt ttVar) {
        if (this.tt != null) {
            this.tt.initPglArmorCallApi(ttVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        if (ttVar != null) {
            ttVar = new sp(ttVar);
        }
        sparseArray.put(1, ttVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void initPglCryptUtils() {
        if (this.tt != null) {
            this.tt.initPglCryptUtils();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        if (this.tt != null) {
            this.tt.pglArmorCallApi2c(motionEvent);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, motionEvent);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        if (this.tt != null) {
            return this.tt.pglArmorCallApi2ccc(str, j, i, z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, Boolean.valueOf(z));
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public String pglArmorCallApi2getProperty(String str, String str2) {
        if (this.tt != null) {
            return this.tt.pglArmorCallApi2getProperty(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void pglArmorCallApi2src(long j, int i) {
        if (this.tt != null) {
            this.tt.pglArmorCallApi2src(j, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public boolean registerHarSensors() {
        if (this.tt != null) {
            return this.tt.registerHarSensors();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.n
    public void setHARSensorCallBack(n.c cVar) {
        if (this.tt != null) {
            this.tt.setHARSensorCallBack(cVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        if (cVar != null) {
            cVar = new a(cVar);
        }
        sparseArray.put(1, cVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public boolean signVerifyMD5withRSA(String str, String str2) {
        if (this.tt != null) {
            return this.tt.signVerifyMD5withRSA(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.n
    public void softDecTool2ua(double d, long j) {
        if (this.tt != null) {
            this.tt.softDecTool2ua(d, j);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Double.valueOf(d));
        sparseArray.put(2, Long.valueOf(j));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void updateHARSettings(JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.updateHARSettings(jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, jSONObject);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void updateNetworkStatus(int i) {
        if (this.tt != null) {
            this.tt.updateNetworkStatus(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.n
    public void updateScreenStatus(String str) {
        if (this.tt != null) {
            this.tt.updateScreenStatus(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }
}
