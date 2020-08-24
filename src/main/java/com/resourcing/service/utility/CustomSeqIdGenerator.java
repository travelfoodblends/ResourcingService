package com.resourcing.service.utility;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSeqIdGenerator implements IdentifierGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSeqIdGenerator.class);
	
	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        String prefix = "ACNT";
        Connection connection = session.connection();
        ResultSet rs = null;
        Statement statement = null;

        try {
            statement=connection.createStatement();

            rs=statement.executeQuery("select count(id) as Id from account");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                LOGGER.info("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        finally {
//        	try {
//	        	if(connection != null) {
//					connection.close();
//	        	}
//	        	
//	        	if(rs != null) {
//	        		rs.close();
//	        	}
//        	}catch(Exception ex) {
//        		LOGGER.error("Exception occurred while closing the connection :: "+ ex.getMessage());
//        	}
//        }


        return null;
    }

	
}
