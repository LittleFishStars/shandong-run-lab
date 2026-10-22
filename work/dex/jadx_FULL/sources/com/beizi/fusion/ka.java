package com.beizi.fusion;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ka implements sb {
    private String[] columns;
    protected long primaryID;

    private String[] a() {
        Field[] declaredFields = getClass().getDeclaredFields();
        if (declaredFields.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(j6.class)) {
                field.setAccessible(true);
                j6 j6Var = (j6) field.getAnnotation(j6.class);
                if (j6Var != null) {
                    arrayList.add(j6Var.column());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.beizi.fusion.sb
    public String[] getColumns() {
        String[] strArr = this.columns;
        if (strArr == null || strArr.length == 0) {
            this.columns = a();
        }
        return this.columns;
    }

    @Override // com.beizi.fusion.sb
    public ContentValues getContentValuesStruct() {
        Map<String, String> mapStruct = getMapStruct();
        if (mapStruct == null || mapStruct.isEmpty()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, String> entry : mapStruct.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                contentValues.put(key, value);
            }
        }
        return contentValues;
    }

    public Map<String, String> getMapStruct() {
        HashMap map = new HashMap();
        List<Field> listB = pl.b(getClass());
        if (!listB.isEmpty()) {
            for (Field field : listB) {
                j6 j6Var = (j6) field.getAnnotation(j6.class);
                if (j6Var != null) {
                    field.setAccessible(true);
                    String strColumn = j6Var.column();
                    try {
                        Object obj = field.get(this);
                        if (obj != null) {
                            if (j6Var.encode()) {
                                map.put(strColumn, f3.c(obj.toString()));
                            } else {
                                map.put(strColumn, obj.toString());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        om.a(e);
                    }
                }
            }
        }
        return map;
    }

    public long getPrimaryID() {
        return this.primaryID;
    }

    @Override // com.beizi.fusion.sb
    public void parseFromDb(Cursor cursor) {
        int columnIndex;
        if (cursor != null) {
            int columnIndex2 = cursor.getColumnIndex("id");
            if (columnIndex2 != -1) {
                setPrimaryID(cursor.getLong(columnIndex2));
            }
            for (Field field : getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(j6.class)) {
                    field.setAccessible(true);
                    j6 j6Var = (j6) field.getAnnotation(j6.class);
                    if (j6Var != null && (columnIndex = cursor.getColumnIndex(j6Var.column())) != -1) {
                        try {
                            String string = cursor.getString(columnIndex);
                            if (j6Var.encode()) {
                                field.set(this, f3.b(string));
                            } else {
                                field.set(this, string);
                            }
                        } catch (IllegalAccessException e) {
                            om.a(e);
                        }
                    }
                }
            }
        }
    }

    public void setPrimaryID(long j) {
        this.primaryID = j;
    }
}
