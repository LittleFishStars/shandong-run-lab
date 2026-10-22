package com.beizi.fusion.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TaskConfig {

    @JsonNode(key = "checkInterval")
    private long checkInterval;

    @JsonNode(key = "configVersion")
    private String configVersion;

    @JsonNode(key = "id")
    private String id;

    @JsonNode(key = "job")
    private String job;

    @JsonNode(key = "url")
    private String url;

    @JsonNode(key = "version")
    private String version;

    public static List<TaskConfig> arrayTaskConfigFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskConfig.1
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TaskConfig objectFromData(String str) {
        try {
            return (TaskConfig) JsonResolver.fromJson(str, TaskConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public String getId() {
        return this.id;
    }

    public String getJob() {
        return this.job;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCheckInterval(long j) {
        this.checkInterval = j;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setJob(String str) {
        this.job = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static TaskConfig objectFromData(String str, String str2) {
        try {
            return (TaskConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), TaskConfig.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<TaskConfig> arrayTaskConfigFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskConfig.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }
}
