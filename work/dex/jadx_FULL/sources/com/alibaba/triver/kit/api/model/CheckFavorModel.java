package com.alibaba.triver.kit.api.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CheckFavorModel implements Serializable {
    public CExtend ext;
    public boolean result;

    public static class AddFavoriteTip implements Serializable {
        public String rewardText;
        public String subTitle;
        public String title;
    }

    public static class CExtend implements Serializable {
        public DExtend detail;
    }

    public static class DExtend implements Serializable {
        public EExtend extProperties;
    }

    public static class EExtend implements Serializable {
        public AddFavoriteTip addFavoriteTip;
        public IsFavoriteTip isFavoriteTip;
    }

    public static class IsFavoriteTip implements Serializable {
        public String guideTip;
        public String taskTip;
    }

    public AddFavoriteTip getAddFavoriteTip() {
        DExtend dExtend;
        EExtend eExtend;
        CExtend cExtend = this.ext;
        if (cExtend == null || (dExtend = cExtend.detail) == null || (eExtend = dExtend.extProperties) == null) {
            return null;
        }
        return eExtend.addFavoriteTip;
    }

    public IsFavoriteTip getIsFavTip() {
        DExtend dExtend;
        EExtend eExtend;
        CExtend cExtend = this.ext;
        if (cExtend == null || (dExtend = cExtend.detail) == null || (eExtend = dExtend.extProperties) == null) {
            return null;
        }
        return eExtend.isFavoriteTip;
    }
}
