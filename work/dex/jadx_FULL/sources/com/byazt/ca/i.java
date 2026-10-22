package com.byazt.ca;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 42})
public class i extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        com.byazt.dr.c cVarPollFirst;
        if (')' != c(i, str)) {
            return cVar.c(str, i, deque);
        }
        LinkedList<com.byazt.dr.c> linkedList = new LinkedList();
        while (true) {
            cVarPollFirst = deque.pollFirst();
            if (cVarPollFirst == null || cVarPollFirst.c() == com.byazt.zg.uj.LEFT_PAREN || ((cVarPollFirst instanceof com.byazt.lw.da) && cVarPollFirst.c() == com.byazt.zg.tt.METHOD && !((com.byazt.lw.da) cVarPollFirst).ve())) {
                break;
            }
            linkedList.addFirst(cVarPollFirst);
        }
        if (cVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (cVarPollFirst.c() != com.byazt.zg.tt.METHOD) {
            deque.push(com.byazt.to.tt.c(linkedList, str, i));
            return i + 1;
        }
        com.byazt.lw.da daVar = (com.byazt.lw.da) cVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.byazt.dr.c cVar2 : linkedList) {
            if (cVar2.c() == com.byazt.zg.uj.COMMA) {
                linkedList2.add(com.byazt.to.tt.c(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(cVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.byazt.to.tt.c(linkedList3, str, i));
        }
        daVar.c((com.byazt.dr.c[]) linkedList2.toArray(new com.byazt.dr.c[linkedList2.size()]));
        daVar.c(true);
        int i2 = i + 1;
        deque.push(daVar);
        return i2;
    }
}
