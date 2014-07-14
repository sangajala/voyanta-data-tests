package com.voyanta.data.utils;


import com.mysql.jdbc.Statement;
import org.apache.log4j.Logger;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sriramangajala on 07/07/2014.
 */
public class DBUtils {

    private static Connection conn;
    static Logger LOGGER = Logger.getLogger(DBUtils.class);



    public static Connection connectToDataBase(String dbuserName,String dbpassword,String url) throws SQLException
    {
        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();


            conn = DriverManager.getConnection(url, dbuserName, dbpassword);
            LOGGER.info ("Database connection established");
            return conn;

        }catch(Exception e){
            e.printStackTrace();
        }


        return conn;
    }

    public static ResultSet executeStatement(String query) throws SQLException {
        Statement statement = (Statement) conn.createStatement();
        return statement.executeQuery(query);
    }

    public static ResultSet connectAndExecuteStatement(String dbuserName,String dbpassword,String url,String query) throws SQLException {
        connectToDataBase(dbuserName,dbpassword,url);
        return executeStatement(query);
    }

    public static List<VHashMap> executeAndGetResults(String query) throws SQLException {
        int counter=0;
        LOGGER.info("Executing the query");
        LOGGER.info(query);
        ResultSet rs = executeStatement(query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<VHashMap> row = new LinkedList<VHashMap>();// = new HashMap[];
        LOGGER.debug("DATA BASE RECORDS");
        while (rs.next()){
            VHashMap hashMap = new VHashMap();
            for(int i=1; i<=columns; i++){
                hashMap.put(md.getColumnName(i), rs.getObject(i));
//                hashMap.put(md.getColumnName(i), String.valueOf(rs.getObject(i)).replace(".00000",""));
//                hashMap.put(md.getColumnName(i),hashMap.get(md.getColumnName(i)).toString());

                LOGGER.info("Key = " + md.getColumnName(i) + " Value = " + rs.getObject(i));

            }
            row.add(hashMap);
            counter++;
        }
        LOGGER.info("Database columns found are :"+columns+" and rows:"+counter);
        return row;
    }

    public static void closeConnection()
    {

        try {
            if(conn != null && !conn.isClosed()){
                LOGGER.info("Closing Database Connection");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String loadSQLFile(String filePath)
    {
        String scriptFileName = (filePath);
        File script = new File(scriptFileName);
        BufferedReader reader = null;
        String line,SQL="";
        try {
            reader = new BufferedReader(new FileReader(script));

               while ((line = reader.readLine()) != null)
                {
                    SQL = SQL+line;
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return SQL;
    }
}
