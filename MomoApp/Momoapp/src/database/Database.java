package database;

import java.util.HashMap;
import java.util.Map;

import entity.Product;

public class Database {
  /**
   * Danh sach san pham
  */
  public static  Map<Integer,Product> products  = new HashMap<Integer,Product>();
  
  /**
   * Bien luu gia tri so lan mua cung 1 san pham lien tiep
   */
  public static int count = 0;

  /**
   * Ngân sách hiện tại cua chương trình KM
   */
  public static int  budget = 0;

  /**
   * Lưu giá trị id sản phẩm mua trước đó
   */

  public static int id=0;
    
}