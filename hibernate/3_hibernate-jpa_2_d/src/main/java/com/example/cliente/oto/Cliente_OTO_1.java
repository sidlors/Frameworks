
package com.example.cliente.oto;

import com.example.as.oto.OTO_1_AS;
import com.example.util.JPAUtil;


public class Cliente_OTO_1 {

 
    public static void main(String[] args) throws Exception {
        OTO_1_AS oto_1_as = new OTO_1_AS();
                
        oto_1_as.m1();
        JPAUtil.getEMF1().close();
    }
}
