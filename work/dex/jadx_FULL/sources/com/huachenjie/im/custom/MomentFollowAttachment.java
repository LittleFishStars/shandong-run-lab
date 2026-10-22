package com.huachenjie.im.custom;

import android.text.TextUtils;
import com.huachenjie.im.custom.base.BaseAttachment;
import com.zj.adlib.ai9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class MomentFollowAttachment extends BaseAttachment {
    protected String followAppUserCode = "";
    protected String followNickName = "";
    protected String appUserCode = "";
    protected String nickName = "";

    public String formatContent() {
        String userId = ai9.e().getUserId();
        if (TextUtils.equals(userId, this.followAppUserCode)) {
            Object[] objArr = new Object[1];
            String str = this.nickName;
            objArr[0] = str != null ? str : "";
            return String.format("%s跟随了我", objArr);
        }
        if (TextUtils.equals(userId, this.appUserCode)) {
            Object[] objArr2 = new Object[1];
            String str2 = this.followNickName;
            objArr2[0] = str2 != null ? str2 : "";
            return String.format("您跟随了%s", objArr2);
        }
        Object[] objArr3 = new Object[2];
        String str3 = this.nickName;
        if (str3 == null) {
            str3 = "";
        }
        objArr3[0] = str3;
        String str4 = this.followNickName;
        objArr3[1] = str4 != null ? str4 : "";
        return String.format("%s跟随了%s", objArr3);
    }

    public String getAppUserCode() {
        return this.appUserCode;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 7;
    }

    public String getFollowAppUserCode() {
        return this.followAppUserCode;
    }

    public String getFollowNickName() {
        return this.followNickName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setAppUserCode(String str) {
        this.appUserCode = str;
    }

    public void setFollowAppUserCode(String str) {
        this.followAppUserCode = str;
    }

    public void setFollowNickName(String str) {
        this.followNickName = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
