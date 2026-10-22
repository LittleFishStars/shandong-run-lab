package com.huachenjie.social_contact.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.OperateCallback;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.zj.adlib.ai9;
import com.zj.adlib.dj1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SearchResultBean {
    public static final int TYPE_APPLIED = 3;
    public static final int TYPE_CAN_ADD = 1;
    public static final int TYPE_FRIEND = 3;
    public static final int TYPE_MINE = 2;
    private int type;
    private String accId = "";
    private String nickName = "";
    private String avatarUrl = "";
    private String avatarFrameImgUrl = "";
    private String metaverseUserId = "";

    public static void updateUserInfo(final SearchResultBean searchResultBean, final OperateCallback<Boolean> operateCallback) {
        if (searchResultBean == null || TextUtils.isEmpty(searchResultBean.accId)) {
            operateCallback.onFailed(0);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(searchResultBean.accId);
        dj1.F(arrayList, new DefaultCallback<List<NimUserInfo>>() { // from class: com.huachenjie.social_contact.bean.SearchResultBean.1
            @Override // com.huachenjie.im.DefaultCallback
            public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
                if (i != 200 || list == null || list.isEmpty()) {
                    operateCallback.onFailed(0);
                    return;
                }
                NimUserInfo nimUserInfo = list.get(0);
                searchResultBean.setAvatarUrl(nimUserInfo.getAvatar());
                searchResultBean.setNickName(nimUserInfo.getName());
                Map extensionMap = nimUserInfo.getExtensionMap();
                if (extensionMap == null) {
                    extensionMap = new HashMap();
                }
                Object obj = extensionMap.get("avatarFrameImgUrl");
                if (obj instanceof String) {
                    searchResultBean.setAvatarFrameImgUrl((String) obj);
                }
                if (ai9.e().getUserId().equals(extensionMap.get("appUserCode"))) {
                    searchResultBean.setType(2);
                } else if (dj1.i(searchResultBean.accId)) {
                    searchResultBean.setType(3);
                } else {
                    searchResultBean.setType(1);
                }
                operateCallback.onSuccess(Boolean.TRUE);
            }
        });
    }

    public String getAccId() {
        return this.accId;
    }

    public String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getMetaverseUserId() {
        return this.metaverseUserId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getType() {
        return this.type;
    }

    public void setAccId(String str) {
        this.accId = str;
    }

    public void setAvatarFrameImgUrl(String str) {
        this.avatarFrameImgUrl = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setMetaverseUserId(String str) {
        this.metaverseUserId = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
