package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MaterialInformationBean {
    public static final int SOURCE_TYPE_API = 1;
    public static final int SOURCE_TYPE_SDK = 2;
    public int action_type;
    public AdMaterialInfo adm;
    public int adm_type;
    public String advertiser;
    public String media_slot_id;
    public String request_id;
    public int source_type;
    public int third_id;
    public String third_slot_id;
    public int third_slot_key;

    @Keep
    public static class AdMaterialInfo {
        public String crid;
        public String deeplink;
        public String description;
        public AppInformation download_app;
        public List<Image> image;
        public String landingpage;
        public double price;
        public String title;
        public Video video;

        @Keep
        public static class AppInformation {
            public String app_desc;
            public String app_desc_url;
            public int app_size;
            public String bundle;
            public String developer;
            public String icon;
            public String name;
            public List<Permission> permission;
            public String permission_url;
            public String privacy_policy_url;
            public String ver;

            @Keep
            public static class Permission {
                public String permission_desc;
                public String permission_name;

                public String getDesc() {
                    return this.permission_desc;
                }

                public String getName() {
                    return this.permission_name;
                }

                public void setDesc(String str) {
                    this.permission_desc = str;
                }

                public void setName(String str) {
                    this.permission_name = str;
                }
            }

            public String getBundle() {
                return this.bundle;
            }

            public String getDesc() {
                return this.app_desc;
            }

            public String getDesc_url() {
                return this.app_desc_url;
            }

            public String getDeveloper() {
                return this.developer;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getName() {
                return this.name;
            }

            public List<Permission> getPermission() {
                return this.permission;
            }

            public String getPermission_url() {
                return this.permission_url;
            }

            public String getPrivacy_policy_url() {
                return this.privacy_policy_url;
            }

            public int getSize() {
                return this.app_size;
            }

            public String getVer() {
                return this.ver;
            }

            public void setBundle(String str) {
                this.bundle = str;
            }

            public void setDesc(String str) {
                this.app_desc = str;
            }

            public void setDesc_url(String str) {
                this.app_desc_url = str;
            }

            public void setDeveloper(String str) {
                this.developer = str;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setPermission(List<Permission> list) {
                this.permission = list;
            }

            public void setPermission_url(String str) {
                this.permission_url = str;
            }

            public void setPrivacy_policy_url(String str) {
                this.privacy_policy_url = str;
            }

            public void setSize(int i) {
                this.app_size = i;
            }

            public void setVer(String str) {
                this.ver = str;
            }
        }

        @Keep
        public static class Image {
            public int h;
            public String url;
            public int w;

            public int getH() {
                return this.h;
            }

            public String getUrl() {
                return this.url;
            }

            public int getW() {
                return this.w;
            }

            public void setH(int i) {
                this.h = i;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setW(int i) {
                this.w = i;
            }
        }

        @Keep
        public static class Video {
            public int duration;
            public int h;
            public String url;
            public int video_size;
            public int w;

            public int getDuration() {
                return this.duration;
            }

            public int getH() {
                return this.h;
            }

            public int getSize() {
                return this.video_size;
            }

            public String getUrl() {
                return this.url;
            }

            public int getW() {
                return this.w;
            }

            public void setDuration(int i) {
                this.duration = i;
            }

            public void setH(int i) {
                this.h = i;
            }

            public void setSize(int i) {
                this.video_size = i;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setW(int i) {
                this.w = i;
            }
        }

        public String getCrid() {
            return this.crid;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public String getDesc() {
            return this.description;
        }

        public AppInformation getDownload_app() {
            return this.download_app;
        }

        public List<Image> getImage() {
            return this.image;
        }

        public String getLandingpage() {
            return this.landingpage;
        }

        public double getPrice() {
            return this.price;
        }

        public String getTitle() {
            return this.title;
        }

        public Video getVideo() {
            return this.video;
        }

        public void setCrid(String str) {
            this.crid = str;
        }

        public void setDeeplink(String str) {
            this.deeplink = str;
        }

        public void setDesc(String str) {
            this.description = str;
        }

        public void setDownload_app(AppInformation appInformation) {
            this.download_app = appInformation;
        }

        public void setImage(List<Image> list) {
            this.image = list;
        }

        public void setLandingpage(String str) {
            this.landingpage = str;
        }

        public void setPrice(double d) {
            this.price = d;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVideo(Video video) {
            this.video = video;
        }
    }

    @Keep
    public interface InteractionType {
        public static final int APPLET = 3;
        public static final int DOWNLOAD = 1;
        public static final int LAND_PAGE = 2;
        public static final int UNKNOWN = 9;
    }

    @Keep
    public interface MaterialType {
        public static final int H5 = 3;
        public static final int IMAGE = 1;
        public static final int UNKNOWN = 9;
        public static final int VIDEO = 2;
    }

    public MaterialInformationBean(String str, String str2, int i, String str3, int i2) {
        this.request_id = str;
        this.media_slot_id = str2;
        this.third_id = i;
        this.third_slot_id = str3;
        this.third_slot_key = i2;
    }

    public int getActionType() {
        return this.action_type;
    }

    public AdMaterialInfo getAdm() {
        return this.adm;
    }

    public int getAdmType() {
        return this.adm_type;
    }

    public String getAdvertiser() {
        return this.advertiser;
    }

    public String getDemandAdSlotId() {
        return this.third_slot_id;
    }

    public int getDemandPlatformId() {
        return this.third_id;
    }

    public String getMediaAdSlotId() {
        return this.media_slot_id;
    }

    public String getRequestId() {
        return this.request_id;
    }

    public int getSource_type() {
        return this.source_type;
    }

    public int getThirdSlotKey() {
        return this.third_slot_key;
    }

    public void setActionType(int i) {
        this.action_type = i;
    }

    public void setAdm(AdMaterialInfo adMaterialInfo) {
        this.adm = adMaterialInfo;
    }

    public void setAdmType(int i) {
        this.adm_type = i;
    }

    public void setAdvertiser(String str) {
        this.advertiser = str;
    }

    public void setDemandAdSlotId(String str) {
        this.third_slot_id = str;
    }

    public void setDemandPlatformId(int i) {
        this.third_id = i;
    }

    public void setMediaAdSlotId(String str) {
        this.media_slot_id = str;
    }

    public void setRequestId(String str) {
        this.request_id = str;
    }

    public void setSource_type(int i) {
        this.source_type = i;
    }

    public void setThirdSlotKey(int i) {
        this.third_slot_key = i;
    }
}
