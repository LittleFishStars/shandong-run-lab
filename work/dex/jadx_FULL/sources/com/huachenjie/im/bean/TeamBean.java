package com.huachenjie.im.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TeamBean {
    private ArrayList<MemberBean> teamMemberList;

    public class MemberBean {
        private String accid;

        public MemberBean() {
        }

        public String getAccid() {
            return this.accid;
        }

        public void setAccid(String str) {
            this.accid = str;
        }
    }

    public ArrayList<MemberBean> getTeamMemberList() {
        return this.teamMemberList;
    }

    public void setTeamMemberList(ArrayList<MemberBean> arrayList) {
        this.teamMemberList = arrayList;
    }
}
