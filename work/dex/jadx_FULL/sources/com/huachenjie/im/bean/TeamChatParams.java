package com.huachenjie.im.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TeamChatParams {
    private ArrayList<String> roomUserList;
    private String teamRoomId = "";
    private String publicRoomId = "";
    private String metaverseTeamCode = "";

    public String getMetaverseTeamCode() {
        return this.metaverseTeamCode;
    }

    public String getPublicRoomId() {
        return this.publicRoomId;
    }

    public ArrayList<String> getRoomUserList() {
        return this.roomUserList;
    }

    public String getTeamRoomId() {
        return this.teamRoomId;
    }

    public void setMetaverseTeamCode(String str) {
        this.metaverseTeamCode = str;
    }

    public void setPublicRoomId(String str) {
        this.publicRoomId = str;
    }

    public void setRoomUserList(ArrayList<String> arrayList) {
        this.roomUserList = arrayList;
    }

    public void setTeamRoomId(String str) {
        this.teamRoomId = str;
    }
}
