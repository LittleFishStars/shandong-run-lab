package com.kc.bw.okhttp.db;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TableEntity {
    public List<ColumnEntity> list = new ArrayList();
    public String tableName;

    public TableEntity(String str) {
        this.tableName = str;
    }

    public TableEntity addColumn(ColumnEntity columnEntity) {
        this.list.add(columnEntity);
        return this;
    }

    public String buildTableString() {
        String strDexa;
        StringBuilder sb = new StringBuilder(dexg.dexa("DSFBUF!UBCMF!JG!OPU!FYJTUT!"));
        sb.append(this.tableName);
        sb.append('(');
        for (ColumnEntity columnEntity : this.list) {
            if (columnEntity.compositePrimaryKey != null) {
                sb.append(dexg.dexa("QSJNBSZ!LFZ!)"));
                for (String str : columnEntity.compositePrimaryKey) {
                    sb.append(str);
                    sb.append(dexg.dexa(c49.f40900a));
                }
                sb.deleteCharAt(sb.length() - 1);
                strDexa = dexg.dexa("*");
            } else {
                sb.append(columnEntity.columnName);
                sb.append(" ");
                sb.append(columnEntity.columnType);
                if (columnEntity.isNotNull) {
                    sb.append(dexg.dexa("!OPU!OVMM"));
                }
                if (columnEntity.isPrimary) {
                    sb.append(dexg.dexa("!QSJNBSZ!LFZ"));
                }
                if (columnEntity.isAutoincrement) {
                    sb.append(dexg.dexa("!BVUPJODSFNFOU"));
                }
                strDexa = dexg.dexa(c49.f40900a);
            }
            sb.append(strDexa);
        }
        if (sb.toString().endsWith(dexg.dexa(c49.f40900a))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int getColumnCount() {
        return this.list.size();
    }

    public int getColumnIndex(String str) {
        int columnCount = getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (this.list.get(i).columnName.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public String getColumnName(int i) {
        return this.list.get(i).columnName;
    }
}
