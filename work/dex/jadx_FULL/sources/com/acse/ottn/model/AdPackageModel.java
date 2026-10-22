package com.acse.ottn.model;

import com.acse.ottn.l0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdPackageModel {
    private String ad_id;
    private String aes_key;
    private int code;
    private int delay_readpage_time;
    private String new_package_setting;
    private String ocr_screen_scroll;
    private String package_name;
    private String package_setting;
    private String pos_id;
    private int r;
    private String read_description;
    private String read_timeout;
    private String send_page_read_state;
    private String send_state;
    private String tb_readpage_type;
    private int readpage_time = 7000;
    private String is_click_jd_title = "0";
    private List<String> keywords_names = new ArrayList();
    private String readpage_activity_type = "0";
    private int jd_readpage_size = l0.p;
    private int tb_readpage_size = l0.o;
    private String jd_readpage_type = "0";

    public String getAd_id() {
        return this.ad_id;
    }

    public String getAes_key() {
        return this.aes_key;
    }

    public int getCode() {
        return this.code;
    }

    public int getDelay_readpage_time() {
        return this.delay_readpage_time;
    }

    public String getIs_click_jd_title() {
        return this.is_click_jd_title;
    }

    public int getJd_readpage_size() {
        return this.jd_readpage_size;
    }

    public String getJd_readpage_type() {
        return this.jd_readpage_type;
    }

    public List<String> getKeywords_names() {
        return this.keywords_names;
    }

    public String getNew_package_setting() {
        return this.new_package_setting;
    }

    public String getOcr_screen_scroll() {
        return this.ocr_screen_scroll;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getPackage_setting() {
        return this.package_setting;
    }

    public String getPos_id() {
        return this.pos_id;
    }

    public int getR() {
        return this.r;
    }

    public String getRead_description() {
        return this.read_description;
    }

    public String getRead_timeout() {
        return this.read_timeout;
    }

    public String getReadpage_activity_type() {
        return this.readpage_activity_type;
    }

    public int getReadpage_time() {
        return this.readpage_time;
    }

    public String getSend_page_read_state() {
        return this.send_page_read_state;
    }

    public String getSend_state() {
        return this.send_state;
    }

    public int getTb_readpage_size() {
        return this.tb_readpage_size;
    }

    public String getTb_readpage_type() {
        return this.tb_readpage_type;
    }

    public void setAd_id(String str) {
        this.ad_id = str;
    }

    public void setAes_key(String str) {
        this.aes_key = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDelay_readpage_time(int i) {
        this.delay_readpage_time = i;
    }

    public void setIs_click_jd_title(String str) {
        this.is_click_jd_title = str;
    }

    public void setJd_readpage_size(int i) {
        this.jd_readpage_size = i;
    }

    public void setJd_readpage_type(String str) {
        this.jd_readpage_type = str;
    }

    public void setKeywords_names(List<String> list) {
        this.keywords_names = list;
    }

    public void setNew_package_setting(String str) {
        this.new_package_setting = str;
    }

    public void setOcr_screen_scroll(String str) {
        this.ocr_screen_scroll = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setPackage_setting(String str) {
        this.package_setting = str;
    }

    public void setPos_id(String str) {
        this.pos_id = str;
    }

    public void setR(int i) {
        this.r = i;
    }

    public void setRead_description(String str) {
        this.read_description = str;
    }

    public void setRead_timeout(String str) {
        this.read_timeout = str;
    }

    public void setReadpage_activity_type(String str) {
        this.readpage_activity_type = str;
    }

    public void setReadpage_time(int i) {
        this.readpage_time = i;
    }

    public void setSend_page_read_state(String str) {
        this.send_page_read_state = str;
    }

    public void setSend_state(String str) {
        this.send_state = str;
    }

    public void setTb_readpage_size(int i) {
        this.tb_readpage_size = i;
    }

    public void setTb_readpage_type(String str) {
        this.tb_readpage_type = str;
    }

    public String toString() {
        return "AdPackageModel{package_setting='" + this.package_setting + "', code=" + this.code + ", send_page_read_state='" + this.send_page_read_state + "', new_package_setting='" + this.new_package_setting + "', read_description='" + this.read_description + "', delay_readpage_time=" + this.delay_readpage_time + ", readpage_time=" + this.readpage_time + ", is_click_jd_title='" + this.is_click_jd_title + "', send_state='" + this.send_state + "', ad_id='" + this.ad_id + "', r=" + this.r + ", ocr_screen_scroll='" + this.ocr_screen_scroll + "', pos_id='" + this.pos_id + "', package_name='" + this.package_name + "', tb_readpage_type='" + this.tb_readpage_type + "', aes_key='" + this.aes_key + "', read_timeout='" + this.read_timeout + "', keywords_names=" + this.keywords_names + ", readpage_activity_type='" + this.readpage_activity_type + "', jd_readpage_size=" + this.jd_readpage_size + ", tb_readpage_size=" + this.tb_readpage_size + ", jd_readpage_type='" + this.jd_readpage_type + "'}";
    }
}
