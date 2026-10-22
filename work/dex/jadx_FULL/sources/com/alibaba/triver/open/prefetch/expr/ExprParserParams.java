package com.alibaba.triver.open.prefetch.expr;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExprParserParams implements Serializable {
    public List<String> blacklist;
    public Map ext;
    public Intent intent;
    public Map<String, String[]> subParam;
    public String targetUrl;
    public Uri uri;

    public ExprParserParams(String str, Map<String, String[]> map, List<String> list, Intent intent) {
        this.targetUrl = str;
        this.subParam = map;
        this.blacklist = list;
        this.intent = intent;
    }
}
