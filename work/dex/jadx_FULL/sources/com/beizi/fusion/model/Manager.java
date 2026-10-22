package com.beizi.fusion.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Manager {

    @JsonNode(key = "adSpaces")
    private List<AdSpacesBean> adSpaces;

    @JsonNode(key = "configVersion")
    private String configVersion;

    @JsonNode(key = "init")
    private InitBean init;

    @JsonNode(key = "locationFrequency")
    private long locationFrequency;

    @JsonNode(key = "openSDKId")
    private String openSDKId;

    @JsonNode(key = "openSensor")
    private int openSensor;

    @JsonNode(key = "personalRecommend")
    private int personalRecommend;

    public static class InitBean {

        @JsonNode(key = "workers")
        private List<String> workers;

        public static List<InitBean> arrayInitBeanFromData(String str) {
            try {
                return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<InitBean>>() { // from class: com.beizi.fusion.model.Manager.InitBean.1
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }

        public static InitBean objectFromData(String str) {
            try {
                return (InitBean) JsonResolver.fromJson(str, InitBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public List<String> getWorkers() {
            return this.workers;
        }

        public void setWorkers(List<String> list) {
            this.workers = list;
        }

        public String toString() {
            return "InitBean{workers=" + this.workers + '}';
        }

        public static InitBean objectFromData(String str, String str2) {
            try {
                return (InitBean) JsonResolver.fromJson(new JSONObject(str).getString(str), InitBean.class);
            } catch (JSONException | Exception unused) {
                return null;
            }
        }

        public static List<InitBean> arrayInitBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<InitBean>>() { // from class: com.beizi.fusion.model.Manager.InitBean.2
                }.getType());
            } catch (JSONException | Exception unused) {
                return new ArrayList();
            }
        }
    }

    public static List<Manager> arrayManagerBeanFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.Manager.1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public static Manager objectFromData(String str) {
        try {
            return (Manager) JsonResolver.fromJson(str, Manager.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public List<AdSpacesBean> getAdSpaces() {
        return this.adSpaces;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public InitBean getInit() {
        return this.init;
    }

    public long getLocationFrequency() {
        return this.locationFrequency;
    }

    public String getOpenSDKId() {
        return this.openSDKId;
    }

    public int getOpenSensor() {
        return this.openSensor;
    }

    public int getPersonalRecommend() {
        return this.personalRecommend;
    }

    public void setAdSpaces(List<AdSpacesBean> list) {
        this.adSpaces = list;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setInit(InitBean initBean) {
        this.init = initBean;
    }

    public void setLocationFrequency(long j) {
        this.locationFrequency = j;
    }

    public void setOpenSDKId(String str) {
        this.openSDKId = str;
    }

    public void setOpenSensor(int i) {
        this.openSensor = i;
    }

    public void setPersonalRecommend(int i) {
        this.personalRecommend = i;
    }

    public String toString() {
        return "Manager{configVersion='" + this.configVersion + "', init=" + this.init + ", adSpaces=" + this.adSpaces + '}';
    }

    public static Manager objectFromData(String str, String str2) {
        try {
            return (Manager) JsonResolver.fromJson(new JSONObject(str).getString(str), Manager.class);
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    public static List<Manager> arrayManagerBeanFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.Manager.2
            }.getType());
        } catch (JSONException | Exception unused) {
            return new ArrayList();
        }
    }
}
