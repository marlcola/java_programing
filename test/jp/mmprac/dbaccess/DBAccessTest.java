/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.mmprac.dbaccess;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mori
 */
public class DBAccessTest{
    
    public DBAccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /***
     * 初期化テスト
     */
    @Test
    public void testInit() {
        // データベースアクセスオブジェクト生成
        DBAccess dbAccess = new DBAccess("java_prac", "masaki", "cola3101");
        // クラスを取得
        Class c = dbAccess.getClass();
        
        // コネクションを取得しているか？
        try {
            // dbAccessクラスの dbConnection フィールドを取得
            Field fld = c.getDeclaredField("dbConnection");
            // 取得したフィールドへのアクセスを許可
            fld.setAccessible(true);
            // dbAccess オブジェクトの dbConnection フィールドが Null ではないことをテスト
            assertNotNull(fld.get(dbAccess));
        } 
        // フィールドが見つからない場合の例外処理
        catch (NoSuchFieldException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // セキュリティ違反に伴う例外処理
        catch (SecurityException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // dbAccess の dbConnection フィールドにアクセス出来ない場合の例外処理
        catch (IllegalArgumentException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // Field オブジェクト(fld)の get(object obj) メソッドに、不正な引数を指定した場合の例外処理
        catch (IllegalAccessException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testExecuteSelectSQL() {
        // データベースアクセスオブジェクト生成
        DBAccess dbAccess = new DBAccess("java_prac", "masaki", "cola3101");
        // SELECT 文
        String selectSQL = "select * from address;";
        // SELECT 文を実行して、結果が返ってくること確認
        assertNotNull(dbAccess.executeSelectSQL(selectSQL));
        
    }
}