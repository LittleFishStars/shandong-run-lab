package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Tips {
    public String notMsg;
    public String notTitle;
    public int notiTime;
    public int notySwitch;
    public int notyft;

    public String getNotMsg() {
        return this.notMsg;
    }

    public String getNotTitle() {
        return this.notTitle;
    }

    public int getNotiTime() {
        return this.notiTime;
    }

    public int getNotySwitch() {
        return this.notySwitch;
    }

    public int getNotyft() {
        return this.notyft;
    }

    public void setNotMsg(String str) {
        this.notMsg = str;
    }

    public void setNotTitle(String str) {
        this.notTitle = str;
    }

    public void setNotiTime(int i) {
        this.notiTime = i;
    }

    public void setNotySwitch(int i) {
        this.notySwitch = i;
    }

    public void setNotyft(int i) {
        this.notyft = i;
    }
}
