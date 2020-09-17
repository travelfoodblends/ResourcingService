package com.resourcing.service.utility;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSeqIdGenerator implements IdentifierGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSeqIdGenerator.class);
	
	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {

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
                String generatedId = prefix + Integer.toString(id);
                LOGGER.info("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return null;
    }

	
}
