
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_0007ed08(long param_1)

{
  code *pcVar1;
  
  if (((param_1 != 0) &&
      (pcVar1 = (code *)FUN_000d8cc0(param_1,s_JNI_OnLoad_00014574), pcVar1 != Reset)) &&
     ((DAT_000e8415 & 1) == 0)) {
    (*pcVar1)(_DAT_000e8a68,0);
    DAT_000e8415 = 1;
  }
  return;
}

