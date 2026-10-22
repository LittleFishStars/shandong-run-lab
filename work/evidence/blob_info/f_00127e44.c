
ulong * FUN_00127e44(ulong *param_1,ulong param_2,byte *param_3,ulong param_4)

{
  byte *__src;
  byte bVar1;
  long lVar2;
  byte *__src_00;
  ulong uVar3;
  byte *pbVar4;
  
  bVar1 = (byte)*param_1;
  if ((bVar1 & 1) == 0) {
    uVar3 = (ulong)(bVar1 >> 1);
  }
  else {
    uVar3 = param_1[1];
  }
  if (param_2 <= uVar3) {
    if ((bVar1 & 1) == 0) {
      lVar2 = 0x16;
    }
    else {
      lVar2 = (*param_1 & 0xfffffffffffffffe) - 1;
    }
    if (lVar2 - uVar3 < param_4) {
      FUN_00120060(param_1,lVar2,(uVar3 + param_4) - lVar2,uVar3,param_2,0,param_4,param_3);
    }
    else if (param_4 != 0) {
      if ((bVar1 & 1) == 0) {
        pbVar4 = (byte *)((long)param_1 + 1);
      }
      else {
        pbVar4 = (byte *)param_1[2];
      }
      __src = pbVar4 + param_2;
      __src_00 = param_3;
      if (uVar3 - param_2 != 0) {
        __src_00 = param_3 + param_4;
        if (pbVar4 + uVar3 <= param_3 || param_3 < __src) {
          __src_00 = param_3;
        }
        memmove(__src + param_4,__src,uVar3 - param_2);
      }
      memmove(__src,__src_00,param_4);
      uVar3 = uVar3 + param_4;
      if ((*param_1 & 1) == 0) {
        *(char *)param_1 = (char)uVar3 * '\x02';
      }
      else {
        param_1[1] = uVar3;
      }
      pbVar4[uVar3] = 0;
    }
    return param_1;
  }
                    /* WARNING: Subroutine does not return */
  FUN_0011ff38(param_1);
}

