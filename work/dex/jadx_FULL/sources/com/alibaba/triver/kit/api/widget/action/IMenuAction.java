package com.alibaba.triver.kit.api.widget.action;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IMenuAction {

    public enum MENU_TYPE {
        SHARE,
        ABOUT,
        COMPLAINTS,
        HOME,
        AUTHORIZE_SETTING,
        DEBUG,
        COMMENT,
        CUSTOM
    }

    public interface OnMenuItemClickListener {
        void onItemClick(String str);
    }

    void addCustomItem(String str, int i, OnMenuItemClickListener onMenuItemClickListener);

    void addCustomItem(String str, String str2, OnMenuItemClickListener onMenuItemClickListener);

    void addItem(MENU_TYPE menu_type);

    void hideExtraView();

    void hideMenu();

    void removeItem(MENU_TYPE menu_type);

    void resetMenu();

    void showMenu();
}
