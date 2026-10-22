package com.igexin.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GTPopupMessage extends BaseMessage implements Serializable {
    private GtAction action;
    private String elementType;
    private EventProperties eventProperties;

    public static class EventProperties implements Serializable {
        private final String $popup_click_modal;
        private final String $popup_node_modal_name;
        private final String $popup_node_name;
        private final String $popup_plan_name;

        public EventProperties(String str, String str2, String str3, String str4) {
            this.$popup_plan_name = str;
            this.$popup_node_name = str2;
            this.$popup_click_modal = str3;
            this.$popup_node_modal_name = str4;
        }

        public String get$popup_click_modal() {
            return this.$popup_click_modal;
        }

        public String get$popup_node_modal_name() {
            return this.$popup_node_modal_name;
        }

        public String get$popup_node_name() {
            return this.$popup_node_name;
        }

        public String get$popup_plan_name() {
            return this.$popup_plan_name;
        }

        public String toString() {
            return "{\"$popup_plan_name\":\"" + this.$popup_plan_name + "\", \"$popup_node_name\":\"" + this.$popup_node_name + "\", \"$popup_click_modal\":\"" + this.$popup_click_modal + "\", \"$popup_node_modal_name\":\"" + this.$popup_node_modal_name + "\"}";
        }
    }

    public static class GtAction implements Serializable {
        private final String actionType;
        private final boolean closePopup;
        private final String intent;
        private final String url;

        public GtAction(String str, String str2, String str3, boolean z) {
            this.actionType = str;
            this.intent = str2;
            this.url = str3;
            this.closePopup = z;
        }

        public String getActionType() {
            return this.actionType;
        }

        public String getIntent() {
            return this.intent;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isClosePopup() {
            return this.closePopup;
        }
    }

    public GtAction getAction() {
        return this.action;
    }

    public String getElementType() {
        return this.elementType;
    }

    public EventProperties getEventProperties() {
        return this.eventProperties;
    }

    public void setAction(GtAction gtAction) {
        this.action = gtAction;
    }

    public void setElementType(String str) {
        this.elementType = str;
    }

    public void setEventProperties(EventProperties eventProperties) {
        this.eventProperties = eventProperties;
    }
}
