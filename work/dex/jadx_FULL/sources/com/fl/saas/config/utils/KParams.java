package com.fl.saas.config.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class KParams {
    private String copyJs;
    private int device_keyword_freq;
    private int device_keyword_interval;
    private String keyword_regex;
    private String keyword_url;
    private int keyword_use_time_range;

    public String getCopyJs() {
        return this.copyJs;
    }

    public int getDevice_keyword_freq() {
        return this.device_keyword_freq;
    }

    public int getDevice_keyword_interval() {
        return this.device_keyword_interval;
    }

    public String getKeyword_regex() {
        return this.keyword_regex;
    }

    public String getKeyword_url() {
        return this.keyword_url;
    }

    public int getKeyword_use_time_range() {
        return this.keyword_use_time_range;
    }

    public void setCopyJs(String str) {
        this.copyJs = str;
    }

    public void setDevice_keyword_freq(int i) {
        this.device_keyword_freq = i;
    }

    public void setDevice_keyword_interval(int i) {
        this.device_keyword_interval = i;
    }

    public void setKeyword_regex(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.keyword_regex = new String(Base64Utils.safeUrlBase64Decode(str), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setKeyword_url(String str) {
        this.keyword_url = str;
    }

    public void setKeyword_use_time_range(int i) {
        this.keyword_use_time_range = i;
    }
}
