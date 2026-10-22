package cj.mobile.wm;

import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex12 implements j {
    public final Class<?> dexa;
    public final Enum[] dexb;
    public final Enum[] dexc;
    public long[] dexd;

    public dex12(Class<?> cls) {
        this.dexa = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.dexc = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.dexd = new long[enumArr.length];
        int i = 0;
        while (true) {
            Enum[] enumArr2 = this.dexc;
            if (i >= enumArr2.length) {
                break;
            }
            String strName = enumArr2[i].name();
            long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
            for (int i2 = 0; i2 < strName.length(); i2++) {
                jCharAt = (jCharAt ^ ((long) strName.charAt(i2))) * TypeUtils.fnv1a_64_magic_prime;
            }
            jArr[i] = jCharAt;
            this.dexd[i] = jCharAt;
            i++;
        }
        Arrays.sort(this.dexd);
        this.dexb = new Enum[this.dexc.length];
        for (int i3 = 0; i3 < this.dexd.length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                if (this.dexd[i3] == jArr[i4]) {
                    this.dexb[i3] = this.dexc[i4];
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        try {
            dex13 dex13Var = dex11Var.dexe;
            int i = dex13Var.dexa;
            if (i == 2) {
                int iDexe = dex13Var.dexe();
                dex13Var.dexb(16);
                if (iDexe >= 0) {
                    Object[] objArr = this.dexc;
                    if (iDexe <= objArr.length) {
                        return (T) objArr[iDexe];
                    }
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("parse enum " + this.dexa.getName() + " error, value : " + iDexe);
            }
            if (i != 4) {
                if (i == 8) {
                    dex13Var.dexb(16);
                    return null;
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("parse enum " + this.dexa.getName() + " error, value : " + dex11Var.dexe());
            }
            String strDext = dex13Var.dext();
            dex13Var.dexb(16);
            if (strDext.length() == 0) {
                return null;
            }
            long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
            for (int i2 = 0; i2 < strDext.length(); i2++) {
                jCharAt = (jCharAt ^ ((long) strDext.charAt(i2))) * TypeUtils.fnv1a_64_magic_prime;
            }
            int iBinarySearch = Arrays.binarySearch(this.dexd, jCharAt);
            if (iBinarySearch < 0) {
                return null;
            }
            return (T) this.dexb[iBinarySearch];
        } catch (com.wangmai.insightvision.openadsdk.d.d e) {
            throw e;
        } catch (Exception e2) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e2.getMessage(), e2);
        }
    }
}
