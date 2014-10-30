
package com.example.cliente.mtm;

import com.example.as.mtm.MTM_1_AS;
import com.example.util.JPAUtil;


public class Cliente_MTM_1 {

 
    public static void main(String[] args) throws Exception {
        MTM_1_AS mtm_1_as = new MTM_1_AS();
                
        mtm_1_as.m1();
        JPAUtil.getEMF1().close();

    }
}
