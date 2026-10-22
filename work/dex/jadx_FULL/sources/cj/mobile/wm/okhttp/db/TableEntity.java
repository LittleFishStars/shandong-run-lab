package cj.mobile.wm.okhttp.db;

import cj.mobile.wm.dexc;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
        StringBuilder sb = new StringBuilder(dexc.dexa("DSFBUF!UBCMF!JG!OPU!FYJTUT!"));
        sb.append(this.tableName);
        sb.append('(');
        for (ColumnEntity columnEntity : this.list) {
            if (columnEntity.compositePrimaryKey != null) {
                sb.append(dexc.dexa("QSJNBSZ!LFZ!)"));
                for (String str : columnEntity.compositePrimaryKey) {
                    sb.append(str);
                    sb.append(dexc.dexa(c49.f40900a));
                }
                sb.deleteCharAt(sb.length() - 1);
                strDexa = dexc.dexa("*");
            } else {
                sb.append(columnEntity.columnName);
                sb.append(" ");
                sb.append(columnEntity.columnType);
                if (columnEntity.isNotNull) {
                    sb.append(dexc.dexa("!OPU!OVMM"));
                }
                if (columnEntity.isPrimary) {
                    sb.append(dexc.dexa("!QSJNBSZ!LFZ"));
                }
                if (columnEntity.isAutoincrement) {
                    sb.append(dexc.dexa("!BVUPJODSFNFOU"));
                }
                strDexa = dexc.dexa(c49.f40900a);
            }
            sb.append(strDexa);
        }
        if (sb.toString().endsWith(dexc.dexa(c49.f40900a))) {
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
