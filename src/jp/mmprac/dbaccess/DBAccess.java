/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.mmprac.dbaccess;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     * @param dbname // データベース名
     * @param user // ユーザ名
     * @param password // パスワード
     */
    public DBAccess(String dbname, String user, String password) {
        // データベースのコネクションを生成
        dbConnection = getConnection(dbname, user, password);
    }
    
    /***
     *  コネクション生成
     * @param dbname //データベース名
     * @param user // ユーザ名
     * @param password // パスワード
     * @return // データベースコネクション
     */
    private Connection getConnection(String dbname, String user, String password){
        
        // MySQL のJDBCドライバをロード
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } 
        // クラスが見つからない場合の例外処理
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // コネクション
        Connection con = null;
        
        // データベースのコネクションを確立する
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + dbname, user, password);
        } 
        // データベースアクセスにおける例外処理
        catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 確立したコネクションを返す
        return con;
        
    }
    
    /**
     * SELECT ステートメントの実行
     * @param sql // SELECT文の文字列
     * @return // 結果セット ResultSet
     */
    public ResultSet executeSelectSQL(String sql){
        // SELECT ステートメントの参照結果セット
        ResultSet res = null;
        // SELECT文の実行
        try {
            // dbConnection インスタンスから、Statement オブジェクトを生成
            Statement stat = dbConnection.createStatement();
            // SELECT ステートメントを実行
            res = stat.executeQuery(sql);
        } 
        // データベースアクセスに失敗した場合の例外処理
        catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 結果セットを返す
        return res;
        
    }
}
