package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class StarAllianceAttachment extends BaseAttachment {
    protected String inviteCode = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 3;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }
}
