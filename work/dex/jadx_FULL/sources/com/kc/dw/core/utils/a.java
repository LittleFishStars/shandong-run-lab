package com.kc.dw.core.utils;

import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.domain.SdkAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    public static ResultBean.AdInfo a(BaseAdSlot baseAdSlot) {
        String str = null;
        if (baseAdSlot == null) {
            return null;
        }
        Integer fieldExport = baseAdSlot.getFieldExport();
        if (fieldExport == null) {
            fieldExport = p0.o;
        }
        if (fieldExport == null || fieldExport.intValue() == 0) {
            return null;
        }
        ResultBean.AdInfo adInfo = new ResultBean.AdInfo();
        try {
            if ((fieldExport.intValue() & 1) == 1) {
                adInfo.setCreative_type(baseAdSlot.getAdPatternType() == 2 ? 2 : 1);
            }
            if ((fieldExport.intValue() & 2) == 2) {
                adInfo.setTitle(baseAdSlot.getTitle());
            }
            if ((fieldExport.intValue() & 4) == 4) {
                adInfo.setDesc(baseAdSlot.getDesc());
            }
            if ((fieldExport.intValue() & 8) == 8 && baseAdSlot.getAdPatternType() != 2) {
                adInfo.setImgUrls(baseAdSlot.getImageUrls());
            }
            if ((fieldExport.intValue() & 16) == 16 && baseAdSlot.getAdPatternType() == 2) {
                adInfo.setVideoUrls(baseAdSlot.getImageUrls());
                adInfo.setImgUrls(new String[]{baseAdSlot.getVideo_cover()});
            }
            if ((fieldExport.intValue() & 32) == 32) {
                adInfo.setIconUrl(baseAdSlot.getIcon());
            }
            if ((fieldExport.intValue() & 64) == 64) {
                adInfo.setCid(baseAdSlot.getCid());
            }
            if ((fieldExport.intValue() & 128) == 128) {
                adInfo.setAct_ext(baseAdSlot.getAct_ext());
            }
            if ((fieldExport.intValue() & 256) == 256) {
                adInfo.setDeepLink(baseAdSlot.getDeep_link());
            }
            if ((fieldExport.intValue() & 512) == 512) {
                if (baseAdSlot.getdUrl() != null && baseAdSlot.getdUrl().length > 0) {
                    str = baseAdSlot.getdUrl()[0];
                }
                adInfo.setLandingPageUrl(str);
            }
            if ((fieldExport.intValue() & 1024) == 1024) {
                adInfo.setPackageName(baseAdSlot.getPackageName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adInfo;
    }

    public static boolean a(AdSlot adSlot) {
        try {
            if ((adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getAppendInfo() != null) {
                return ((BaseAdSlot) adSlot).getAppendInfo().isHasExposed();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(com.kc.dw.core.loader.b bVar) {
        SdkAdInfo sdkAdInfo = bVar != null ? bVar.getSdkAdInfo() : null;
        if (sdkAdInfo != null) {
            try {
                if (sdkAdInfo.getAppendInfo() != null) {
                    return sdkAdInfo.getAppendInfo().isHasExposed();
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().userAdvertiserId() != null) {
            for (String str2 : com.kc.dw.base.a.adConfig().userAdvertiserId()) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String b(BaseAdSlot baseAdSlot) {
        if (baseAdSlot == null) {
            return null;
        }
        try {
            if (baseAdSlot.getImageUrls() == null || baseAdSlot.getImageUrls().length < 1) {
                return null;
            }
            return baseAdSlot.getImageUrls()[0];
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(AdSlot adSlot) {
        try {
            if ((adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getAppendInfo() != null) {
                return ((BaseAdSlot) adSlot).getAppendInfo().isHasVideoStart();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
