package com.alibaba.analytics.core.model;

import android.text.TextUtils;
import com.alibaba.analytics.a.q;
import com.alibaba.analytics.core.b.a.c;
import com.alibaba.analytics.core.b.b;
import com.alibaba.analytics.core.d.e;
import com.alibaba.analytics.core.d.g;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@c("log")
public class a extends b {

    @com.alibaba.analytics.core.b.a.a(com.heytap.mcssdk.constant.b.k)
    public String aD;

    @com.alibaba.analytics.core.b.a.a("streamId")
    public String aE;

    @com.alibaba.analytics.core.b.a.a("content")
    private String aF;

    @com.alibaba.analytics.core.b.a.a("_index")
    public String aG;

    @com.alibaba.analytics.core.b.a.b
    private String aH;

    @com.alibaba.analytics.core.b.a.b
    private String aI;

    @com.alibaba.analytics.core.b.a.b
    private String aJ;

    @com.alibaba.analytics.core.b.a.b
    private String aK;

    @com.alibaba.analytics.core.b.a.b
    private int i;

    @com.alibaba.analytics.core.b.a.a("priority")
    public String priority;

    @com.alibaba.analytics.core.b.a.a("time")
    public String time;

    @com.alibaba.analytics.core.b.a.b
    private Map<String, String> w;

    public a() {
        this.priority = "3";
        this.time = null;
        this.aG = "";
        this.i = 0;
    }

    private String a(List<String> list) {
        if (list == null) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i >= 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private String t() {
        StringBuilder sb = new StringBuilder();
        sb.append(g.a().b());
        String strSubstring = "";
        sb.append("");
        String string = sb.toString();
        if (!TextUtils.isEmpty(string)) {
            strSubstring = string.length() >= 2 ? string.substring(string.length() - 2, string.length()) : string;
        }
        return "2202".equalsIgnoreCase(this.aD) ? String.format("%s%06d,2202_%06d", strSubstring, Long.valueOf(g.a().c()), Long.valueOf(g.a().d())) : String.format("%s%06d", strSubstring, Long.valueOf(g.a().c()));
    }

    public void D() {
        if (TextUtils.isEmpty(this.time)) {
            this.time = String.valueOf(System.currentTimeMillis());
        }
        setContent(com.alibaba.analytics.core.d.c.a(this.aH, this.aD, this.aI, this.aJ, this.aK, this.w, this.aG, this.time));
    }

    public String getContent() {
        try {
            byte[] bArrDecode = com.alibaba.analytics.a.b.decode(this.aF.getBytes("UTF-8"), 2);
            if (bArrDecode != null) {
                return new String(q.rc4(bArrDecode));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setContent(String str) {
        if (str != null) {
            try {
                this.aF = new String(com.alibaba.analytics.a.b.encode(q.rc4(str.getBytes()), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "Log [eventId=" + this.aD + ", index=" + this.aG + "]";
    }

    public a(String str, List<String> list, String str2, Map<String, String> map) {
        this.time = null;
        this.aG = "";
        this.i = 0;
        this.priority = str;
        this.aE = a(list);
        this.aD = str2;
        this.time = String.valueOf(System.currentTimeMillis());
        this.aG = t();
        map.put(LogField.RESERVE3.toString(), this.aG);
        setContent(com.alibaba.analytics.core.d.c.a(map));
    }

    public a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.priority = "3";
        this.time = null;
        this.aG = "";
        this.i = 0;
        this.aD = str2;
        this.aH = str;
        this.aI = str3;
        this.aJ = str4;
        this.aK = str5;
        this.w = map;
        this.time = String.valueOf(System.currentTimeMillis());
        this.aG = t();
        this.priority = e.a().e(str2);
        D();
    }
}
