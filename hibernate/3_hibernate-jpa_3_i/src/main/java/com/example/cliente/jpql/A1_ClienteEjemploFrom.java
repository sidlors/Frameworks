package com.example.cliente.jpql;

import org.apache.log4j.Logger;

import com.example.as.jpql.OperadorEjemplosJPQL_AS;
import com.example.util.JPAUtil;

public class A1_ClienteEjemploFrom {

    private static Logger logger = Logger.getLogger(A1_ClienteEjemploFrom.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

        try {
            OperadorEjemplosJPQL_AS operadorEjemplosJPQL_AS = new OperadorEjemplosJPQL_AS();
            operadorEjemplosJPQL_AS.ejemploFrom();
            JPAUtil.getEMF1().close();
        } catch (Throwable t) {
            logger.error("t:" + t.getMessage(),t);
            System.out.println("Hubo un pequeño error..");
        }

    }
}
