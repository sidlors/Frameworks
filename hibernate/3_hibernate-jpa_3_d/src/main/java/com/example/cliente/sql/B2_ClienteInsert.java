package com.example.cliente.sql;

import org.apache.log4j.Logger;

import com.example.as.sql.OperadorEjemplosSQL_AS;
import com.example.util.JPAUtil;

public class B2_ClienteInsert {

    private static Logger logger = Logger.getLogger(A1_ClienteSelect.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            OperadorEjemplosSQL_AS operadorEjemplosSQL_AS = new OperadorEjemplosSQL_AS();
            operadorEjemplosSQL_AS.ejemploInsert();
            JPAUtil.getEMF1().close();

        } catch (Throwable t) {
            logger.error("t:" + t.getMessage(), t);
            System.out.println("Hubo un pequeño error..");
        }


    }
}