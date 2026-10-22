package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TeamInvitationAttachment extends BaseAttachment {
    protected String inviteRecordCode = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 1;
    }

    public String getInviteRecordCode() {
        return this.inviteRecordCode;
    }

    public void setInviteRecordCode(String str) {
        this.inviteRecordCode = str;
    }
}
