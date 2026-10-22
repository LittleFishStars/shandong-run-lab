package com.byazt.kx;

import com.byazt.ca.a;
import com.byazt.ca.da;
import com.byazt.ca.i;
import com.byazt.ca.n;
import com.byazt.ca.sp;
import com.byazt.ca.tt;
import com.byazt.ca.uj;
import com.byazt.ca.ve;
import com.byazt.ca.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1433, 20})
public class c {
    public static final com.byazt.pz.c c;
    public String n;
    public final com.byazt.pz.c tt;
    public Deque<com.byazt.dr.c> uj = new LinkedList();
    public com.byazt.dr.c ve;

    static {
        int i = 8;
        a[] aVarArr = {new da(), new uj(), new i(), new tt(), new n(), new com.byazt.ca.c(), new sp(), new ve(), new x()};
        final com.byazt.pz.c cVar = new com.byazt.pz.c() { // from class: com.byazt.kx.c.1
            @Override // com.byazt.pz.c
            public int c(String str, int i2, Deque<com.byazt.dr.c> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final a aVar = aVarArr[i];
            i--;
            cVar = new com.byazt.pz.c() { // from class: com.byazt.kx.c.2
                @Override // com.byazt.pz.c
                public int c(String str, int i2, Deque<com.byazt.dr.c> deque) {
                    return aVar.c(str, i2, deque, cVar);
                }
            };
        }
        c = cVar;
    }

    private c(String str, com.byazt.pz.c cVar) {
        this.tt = cVar;
        this.n = str;
        try {
            c();
        } catch (Exception e) {
            throw new com.byazt.hh.tt(str, e);
        }
    }

    public static c c(String str) {
        return new c(str, c);
    }

    private void c() {
        int length = this.n.length();
        int i = 0;
        while (i < length) {
            int iC = this.tt.c(this.n, i, this.uj);
            if (iC == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.n.substring(0, i));
            }
            i = iC;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.byazt.dr.c cVarPollFirst = this.uj.pollFirst();
            if (cVarPollFirst == null) {
                this.ve = com.byazt.to.tt.c(arrayList, this.n, i);
                this.uj = null;
                return;
            }
            arrayList.add(0, cVarPollFirst);
        }
    }

    public <T> T c(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) c(map);
    }

    public <T> T c(Map<String, JSONObject> map) {
        return (T) this.ve.c(map);
    }
}
