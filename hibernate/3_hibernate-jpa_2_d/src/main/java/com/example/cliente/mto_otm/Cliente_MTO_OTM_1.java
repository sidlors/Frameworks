
package com.example.cliente.mto_otm;

import com.example.as.mto_otm.MTO_OTM_1_AS;
import com.example.util.JPAUtil;


public class Cliente_MTO_OTM_1 {

 
    public static void main(String[] args) throws Exception {
        MTO_OTM_1_AS mto_otm_1_as = new MTO_OTM_1_AS();
                
        mto_otm_1_as.m1();
        JPAUtil.getEMF1().close();

    }
}
