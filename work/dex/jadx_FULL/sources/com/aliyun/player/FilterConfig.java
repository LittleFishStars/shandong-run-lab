package com.aliyun.player;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FilterConfig {
    private JSONArray filters = new JSONArray();

    public static class Filter {
        JSONObject filter;

        public Filter(String str) {
            JSONObject jSONObject = new JSONObject();
            this.filter = jSONObject;
            try {
                jSONObject.put("target", str);
            } catch (JSONException unused) {
            }
        }

        public JSONObject getFilter() {
            return this.filter;
        }

        public void setOptions(FilterOptions filterOptions) {
            if (filterOptions == null || filterOptions.getOptions().length() <= 0) {
                return;
            }
            try {
                this.filter.put("options", filterOptions.getOptions());
            } catch (JSONException unused) {
            }
        }
    }

    public static class FilterOptions {
        JSONObject options = new JSONObject();

        public JSONObject getOptions() {
            return this.options;
        }

        public void setOption(String str, Object obj) {
            try {
                this.options.put(str, obj);
            } catch (JSONException unused) {
            }
        }

        public String toString() {
            return this.options.toString();
        }
    }

    public void addFilter(Filter filter) {
        if (filter == null || filter.getFilter() == null) {
            return;
        }
        this.filters.put(filter.getFilter());
    }

    public String toString() {
        return this.filters.toString();
    }
}
