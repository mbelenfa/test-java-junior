package com.monica.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "testjava.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Monica\\Documents\\apps\\test-java-junior\\" + DB_NAME;

    public static final String TABLE_POTLUCK = "potluck";
    public static final String COLUMN_POTLUCK_ID = "id";
    public static final String COLUMN_POTLUCK_NAME = "name";
    public static final String COLUMN_POTLUCK_FOOD = "food";
    public static final String COLUMN_POTLUCK_CONFIRM = "confirmed";
    public static final String COLUMN_POTLUCK_SIGNUP_DATE = "signup_date";

    public static final String QUERY_CREATE_TABLE = "CREATE TABLE " + TABLE_POTLUCK + "IF NOT EXISTS " +
            " (" + COLUMN_POTLUCK_ID + "INTEGER NOT NULL, " + COLUMN_POTLUCK_NAME + "TEXT, " +
            COLUMN_POTLUCK_FOOD + " TEXT ," + COLUMN_POTLUCK_CONFIRM + " CHARACTER(1) ," + COLUMN_POTLUCK_SIGNUP_DATE +
            " TEXT, PRIMARY_KEY "+ (COLUMN_POTLUCK_ID) +")";

    public static final String QUERY_VIEW_POTLUCK_INFO ="SELECT * FROM " + TABLE_POTLUCK;

    public static final String QUERY_POTLUCK_BY_ID = "SELECT * FROM " + TABLE_POTLUCK +
            " WHERE " + COLUMN_POTLUCK_ID + " = ?";

    public static final String QUERY_POTLUCK_BY_NAME = "SELECT * FROM " + TABLE_POTLUCK +
            " WHERE " + COLUMN_POTLUCK_NAME + " = ?";

    public static final String QUERY_POTLUCK_BY_FOOD = "SELECT * FROM " + TABLE_POTLUCK +
            " WHERE " + COLUMN_POTLUCK_FOOD + " = ?";

    public static final String QUERY_POTLUCK_BY_CONFIRMED = "SELECT * FROM " + TABLE_POTLUCK +
            " WHERE " + COLUMN_POTLUCK_CONFIRM + " = ?";

    public static final String QUERY_POTLUCK_BY_SIGNUP_DATE = "SELECT * FROM " + TABLE_POTLUCK +
            " WHERE " + COLUMN_POTLUCK_SIGNUP_DATE + " = ?";


    private Connection conn;

    private PreparedStatement queryCreateTable;
    private PreparedStatement queryPotluckInfoView;
    private PreparedStatement queryUpdate;
    private PreparedStatement queryPotluckById;
    private PreparedStatement queryPotluckByName;
    private PreparedStatement queryPotluckByFood;
    private PreparedStatement queryPotluckByConfirmed;
    private PreparedStatement queryPotluckBySignUp;

    private static Datasource instance = new Datasource();

    private Datasource(){

    }

    public static Datasource getInstance(){
        return instance;
    }

    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryCreateTable = conn.prepareStatement(QUERY_CREATE_TABLE);
            queryPotluckInfoView = conn.prepareStatement(QUERY_VIEW_POTLUCK_INFO);
            queryPotluckById = conn.prepareStatement(QUERY_POTLUCK_BY_ID);
            queryPotluckByName = conn.prepareStatement(QUERY_POTLUCK_BY_NAME);
            queryPotluckByFood = conn.prepareStatement(QUERY_POTLUCK_BY_FOOD);
            queryPotluckByConfirmed = conn.prepareStatement(QUERY_POTLUCK_BY_CONFIRMED);
            queryPotluckBySignUp = conn.prepareStatement(QUERY_POTLUCK_BY_SIGNUP_DATE);


            return true;
        }catch (SQLException e){
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if(conn!=null) {
                conn.close();
                if(queryPotluckInfoView != null){
                    queryPotluckInfoView.close();
                }
                if(queryPotluckById!= null){
                    queryPotluckById.close();
                }
                if(queryPotluckByName!= null){
                    queryPotluckByName.close();
                }
                if(queryPotluckByFood!= null){
                    queryPotluckByFood.close();
                }
                if(queryPotluckByConfirmed!= null){
                    queryPotluckByConfirmed.close();
                }
                if(queryPotluckBySignUp!= null){
                    queryPotluckBySignUp.close();
                }
            }
            }catch(SQLException e){
                System.out.println("Couldn't close to database: " + e.getMessage());
            }
    }

    public List<PotLuck> queryPotLuck(String columnName, String columnValue){
        ResultSet results=null;
        try {
            switch (columnName) {
                case COLUMN_POTLUCK_ID:
                    queryPotluckById.setInt(1, Integer.valueOf(columnValue));
                    results = queryPotluckById.executeQuery();
                    break;
                case COLUMN_POTLUCK_NAME:
                    queryPotluckByName.setString(1, columnValue);
                    results = queryPotluckByName.executeQuery();
                    break;
                case COLUMN_POTLUCK_FOOD:
                    queryPotluckByFood.setString(1, columnValue);
                    results = queryPotluckByFood.executeQuery();
                    break;
                case COLUMN_POTLUCK_CONFIRM:
                    queryPotluckByConfirmed.setString(1,columnValue);
                    results = queryPotluckByConfirmed.executeQuery();
                    break;
                case COLUMN_POTLUCK_SIGNUP_DATE:
                    queryPotluckBySignUp.setDate(1, Date.valueOf(columnValue));
                    results = queryPotluckBySignUp.executeQuery();
                    break;
                default:
                    break;
            }
            List<PotLuck> potlucks = new ArrayList<>();
            while(results.next()) {
                PotLuck potLuck = new PotLuck();
                potLuck.setId(results.getInt(1));
                potLuck.setName(results.getString(2));
                potLuck.setFood(results.getString(3));
                potLuck.setConfirmed(results.getString(4));
                potLuck.setDate(results.getString(5));
                potlucks.add(potLuck);
            }
            return potlucks;
        }catch (SQLException e){
            System.out.println("Query faild: " + e.getMessage());
            return null;
        }
    }

}
