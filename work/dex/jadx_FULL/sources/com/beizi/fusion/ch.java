package com.beizi.fusion;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ch implements id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f2.a f27142a;
    private f2 b;

    @Override // com.beizi.fusion.id
    public String a(String str, String str2, id.a aVar, boolean z) {
        byte[] bArrA = a(str.getBytes(), str2, aVar, z);
        if (bArrA != null) {
            return new String(bArrA);
        }
        if (z) {
            return str;
        }
        return null;
    }

    @Override // com.beizi.fusion.id
    public String b(String str, String str2, id.a aVar, boolean z) {
        byte[] bArrB = b(str.getBytes(), str2, aVar, z);
        if (bArrB != null) {
            return new String(bArrB);
        }
        if (z) {
            return str;
        }
        return null;
    }

    @Override // com.beizi.fusion.id
    public byte[] a(byte[] bArr, String str, id.a aVar, boolean z) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                if (!linkedList.contains(str2)) {
                    linkedList.addFirst(str2);
                    if (aVar == id.a.STEP_BY_STEP) {
                        linkedList.addFirst("-999");
                    }
                }
            }
        }
        if (aVar == id.a.AS_LAST_OR_FIRST) {
            linkedList.addFirst("-999");
        }
        return a(bArr, linkedList);
    }

    @Override // com.beizi.fusion.id
    public byte[] b(byte[] bArr, String str, id.a aVar, boolean z) {
        try {
            LinkedList linkedList = new LinkedList();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(",")) {
                    String strTrim = str2.trim();
                    if (!linkedList.contains(strTrim)) {
                        linkedList.addLast(strTrim);
                        if (aVar == id.a.STEP_BY_STEP) {
                            linkedList.addLast("-999");
                        }
                    }
                }
            }
            if (aVar == id.a.AS_LAST_OR_FIRST) {
                linkedList.addLast("-999");
            }
            return b(bArr, linkedList);
        } catch (Throwable th) {
            om.a(th);
            return null;
        }
    }

    private byte[] a(byte[] bArr, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ma maVarA = a((String) it.next());
            if (maVarA != null) {
                if (bArr == null) {
                    break;
                }
                bArr = maVarA.a(bArr);
            }
        }
        return bArr;
    }

    private byte[] b(byte[] bArr, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ma maVarA = a((String) it.next());
            if (maVarA != null) {
                if (bArr == null) {
                    break;
                }
                bArr = maVarA.b(bArr);
            }
        }
        return bArr;
    }

    @Override // com.beizi.fusion.id
    public void a(f2.a aVar) {
        this.f27142a = aVar;
    }

    private ma a(String str) {
        if ("1001".equals(str)) {
            if (this.b == null) {
                this.b = new f2(this.f27142a);
            }
            return this.b;
        }
        if ("101".equals(str)) {
            return s8.a();
        }
        if ("-999".equals(str)) {
            return f3.a();
        }
        return null;
    }
}
