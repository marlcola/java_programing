/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.mmprac.dbaccess;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mori
 */
public class DBAccess {
    // データベースコネクション
    private final Connection dbConnection;
    
    /***
     *  コンストラクタ
     * @param dbname
     * @param user
     * @param password 
     */
    public DBAccess(String dbname, String user, String password) {
        // データベースのコネクションを生成
        dbConnection = getConnection(dbname, user, password);
    }
    
    /***
     *  コネクション生成
     * @param dbname
     * @param user
     * @param password
     * @return 
     */
    private Connection getConnection(String dbname, String user, String password){
        
        // MySQL のJDBCドライバをロード
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // コネクション
        Connection con = null;
        
        // データベースのコネクションを確立する
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + dbname, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 確立したコネクションを返す
        return con;
        
    }
    
}
