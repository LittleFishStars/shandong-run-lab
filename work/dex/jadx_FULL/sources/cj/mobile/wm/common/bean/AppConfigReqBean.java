package cj.mobile.wm.common.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppConfigReqBean {
    public String apptoken;
    public DataBean data;
    public String sign;

    public static class DataBean {
        public App app;
        public Device device;
        public Gps gps;
        public Networks network;

        public static class App {
            public String appName;
            public String appVersion;
            public String pkgName;

            public String getAppName() {
                return this.appName;
            }

            public String getAppVersion() {
                return this.appVersion;
            }

            public String getPkgName() {
                return this.pkgName;
            }

            public void setAppName(String str) {
                this.appName = str;
            }

            public void setAppVersion(String str) {
                this.appVersion = str;
            }

            public void setPkgName(String str) {
                this.pkgName = str;
            }
        }

        public static class Device {
            public String androidId;
            public String boot_mark;
            public String ctzid;
            public String density;
            public int deviceType;
            public String dpi;
            public String fingerprint;
            public String imei;
            public String language;
            public String mac;
            public String meid;
            public String model;
            public String oaid;
            public int orientation;
            public int osType;
            public String osVersion;
            public int ppi;
            public float pxratio;
            public String resolution;
            public ScreenSize screenSize;
            public String timezone;
            public String ua;
            public String update_mark;
            public String vendor;
            public String xdpi;
            public String ydpi;

            public String getAndroidId() {
                return this.androidId;
            }

            public String getBoot_mark() {
                return this.boot_mark;
            }

            public String getCtzid() {
                return this.ctzid;
            }

            public String getDensity() {
                return this.density;
            }

            public int getDeviceType() {
                return this.deviceType;
            }

            public String getDpi() {
                return this.dpi;
            }

            public String getFingerprint() {
                return this.fingerprint;
            }

            public String getImei() {
                return this.imei;
            }

            public String getLanguage() {
                return this.language;
            }

            public String getMac() {
                return this.mac;
            }

            public String getMeid() {
                return this.meid;
            }

            public String getModel() {
                return this.model;
            }

            public String getOaid() {
                return this.oaid;
            }

            public int getOrientation() {
                return this.orientation;
            }

            public int getOsType() {
                return this.osType;
            }

            public String getOsVersion() {
                return this.osVersion;
            }

            public int getPpi() {
                return this.ppi;
            }

            public float getPxratio() {
                return this.pxratio;
            }

            public String getResolution() {
                return this.resolution;
            }

            public ScreenSize getScreenSize() {
                return this.screenSize;
            }

            public String getTimezone() {
                return this.timezone;
            }

            public String getUa() {
                return this.ua;
            }

            public String getUpdate_mark() {
                return this.update_mark;
            }

            public String getVendor() {
                return this.vendor;
            }

            public String getXdpi() {
                return this.xdpi;
            }

            public String getYdpi() {
                return this.ydpi;
            }

            public void setAndroidId(String str) {
                this.androidId = str;
            }

            public void setBoot_mark(String str) {
                this.boot_mark = str;
            }

            public void setCtzid(String str) {
                this.ctzid = str;
            }

            public void setDensity(String str) {
                this.density = str;
            }

            public void setDeviceType(int i) {
                this.deviceType = i;
            }

            public void setDpi(String str) {
                this.dpi = str;
            }

            public void setFingerprint(String str) {
                this.fingerprint = str;
            }

            public void setImei(String str) {
                this.imei = str;
            }

            public void setLanguage(String str) {
                this.language = str;
            }

            public void setMac(String str) {
                this.mac = str;
            }

            public void setMeid(String str) {
                this.meid = str;
            }

            public void setModel(String str) {
                this.model = str;
            }

            public void setOaid(String str) {
                this.oaid = str;
            }

            public void setOrientation(int i) {
                this.orientation = i;
            }

            public void setOsType(int i) {
                this.osType = i;
            }

            public void setOsVersion(String str) {
                this.osVersion = str;
            }

            public void setPpi(int i) {
                this.ppi = i;
            }

            public void setPxratio(float f) {
                this.pxratio = f;
            }

            public void setResolution(String str) {
                this.resolution = str;
            }

            public void setScreenSize(ScreenSize screenSize) {
                this.screenSize = screenSize;
            }

            public void setTimezone(String str) {
                this.timezone = str;
            }

            public void setUa(String str) {
                this.ua = str;
            }

            public void setUpdate_mark(String str) {
                this.update_mark = str;
            }

            public void setVendor(String str) {
                this.vendor = str;
            }

            public void setXdpi(String str) {
                this.xdpi = str;
            }

            public void setYdpi(String str) {
                this.ydpi = str;
            }
        }

        public static class Gps {
            public String latitude;
            public String longitude;

            public String getLatitude() {
                return this.latitude;
            }

            public String getLongitude() {
                return this.longitude;
            }

            public void setLatitude(String str) {
                this.latitude = str;
            }

            public void setLongitude(String str) {
                this.longitude = str;
            }
        }

        public static class Networks {
            public int connectionType;

            @Deprecated
            public String imsi;
            public String mcc;
            public String mnc;
            public String operator;
            public int operatorType;

            public int getConnectionType() {
                return this.connectionType;
            }

            @Deprecated
            public String getImsi() {
                return this.imsi;
            }

            public String getMcc() {
                return this.mcc;
            }

            public String getMnc() {
                return this.mnc;
            }

            public String getOperator() {
                return this.operator;
            }

            public int getOperatorType() {
                return this.operatorType;
            }

            public void setConnectionType(int i) {
                this.connectionType = i;
            }

            @Deprecated
            public void setImsi(String str) {
                this.imsi = str;
            }

            public void setMcc(String str) {
                this.mcc = str;
            }

            public void setMnc(String str) {
                this.mnc = str;
            }

            public void setOperator(String str) {
                this.operator = str;
            }

            public void setOperatorType(int i) {
                this.operatorType = i;
            }
        }

        public App getApp() {
            return this.app;
        }

        public Device getDevice() {
            return this.device;
        }

        public Gps getGps() {
            return this.gps;
        }

        public Networks getNetwork() {
            return this.network;
        }

        public void setApp(App app) {
            this.app = app;
        }

        public void setDevice(Device device) {
            this.device = device;
        }

        public void setGps(Gps gps) {
            this.gps = gps;
        }

        public void setNetwork(Networks networks) {
            this.network = networks;
        }
    }

    public String getApptoken() {
        return this.apptoken;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getSign() {
        return this.sign;
    }

    public void setApptoken(String str) {
        this.apptoken = str;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
