package pos_project.classes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cif3r
 */
public final class SqlStatements {
    public static final String SELECT_ALL_CLIENTS = "SELECT * FROM client WHERE client_del_flag = 0 AND client_type_flag != 3  AND client_type_flag != 2 AND client_type_flag != 4";
    public static final String SELECT_CLIENT = "SELECT * FROM client WHERE client_del_flag = 0 AND client_id = ?";
    public static final String UPDATE_CLIENT = "UPDATE client SET client_name = ? , client_address = ? , client_phone = ? , client_type_flag = ? , client_edit_date = ? , client_edit_user = ? , client_number = ?, client_credit_limit = ?, client_sub_type = ? WHERE client_id = ?";
    public static final String DELETE_CLIENT = "UPDATE client SET client_del_flag = 1 , client_del_date = ?  WHERE client_id = ?";
    public static final String INSERT_INTO_CLIENTS = "INSERT INTO client (client_name, client_address, client_phone, client_del_flag, client_type_flag, client_add_date, client_add_user, client_number, client_credit_limit, client_sub_type) "
            + "VALUES (?,?,?,0,?,?,?,?,?,?)";
//    public static final String SELECT_ALL_SUPPLIERS = "SELECT client_number, client_name FROM client WHERE client_type_flag = 1 AND client_del_flag = 0";
    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM client WHERE client_type_flag = ? AND client_del_flag = 0";
    
    //ITEM SQLS
    public static final String SELECT_ALL_ITEMS = "SELECT * ,c.client_name FROM item i, client c WHERE i.item_client_number = c.client_id AND i.item_del_flag != 1 ";
    public static final String SELECT_ALL_ITEMS_IN_STOCK = "SELECT * ,c.client_name FROM item i, client c WHERE i.item_client_number = c.client_id AND i.item_current_quantity != 0 AND i.item_del_flag != 1 ";
//    public static final String SELECT_ALL_ITEMS_IN_STOCKS = "SELECT i.* ,c.client_name FROM item i, client c, stocks s WHERE i.item_client_number = c.client_id AND i.item_id = s.stocks_item_id AND s.stocks_location_id = ? AND s.stocks_del_flag = 0 AND i.item_del_flag = 0 ";
    
    //USES STOCK TABLE
    public static final String SELECT_ALL_ITEMS_IN_STOCKS = "SELECT i.* ,c.client_name FROM item i, client c, stocks s WHERE i.item_client_number = c.client_id AND i.item_id = s.stocks_item_id AND s.stocks_location_id = ? AND s.stocks_del_flag = 0 AND i.item_del_flag = 0 ORDER BY i.item_name";
    
    //COMPUTES FOR STOCKS
    public static final String SELECT_ALL_ITEMS_WITH_STOCK = 
//            "SELECT ite.*, cli.client_name from item ite, client cli WHERE ite.item_id IN(" +
"SELECT  b.item_id, b.item_name, b.item_client_number, b.item_price, c.client_name FROM client c, (SELECT @tot_dur:= 0, @cur_id:= 0 ) inst,  " +
"	( SELECT * ,  " +
"		(CASE " +
"			WHEN invoice_type_flag = '1' " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			WHEN invoice_type_flag = '0'  " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			END)  AS tot_dur, SUM(stock) stocks " +
"           FROM(  " +
"				SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, i.item_client_number, i.item_price, t.transaction_price, t.transaction_quantity, n.invoice_location_id , i.item_id, @tot_dur as summary " +
"				 ,(CASE  " +
"						WHEN n.invoice_type_flag = '1' THEN transaction_quantity*1  " +
"						WHEN n.invoice_type_flag = '0' THEN transaction_quantity*-1  " +
"					END) AS stock " +
"					FROM item i  " +
"					RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND n.invoice_location_id = ? AND n.invoice_del_flag = 0  " +
"				UNION  " +
"				SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name,  " +
"					(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN '0'  " +
"						WHEN inv.invoice_type_flag = '0' THEN '1'  " +
"					END) AS invoice_type_flag,  " +
"					it.item_name, it.item_client_number, it.item_price, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, inv.invoice_location_id, it.item_id,  @tot_dur as summary  " +
"					,(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN transaction_quantity*-1  " +
"						WHEN inv.invoice_type_flag = '0' THEN transaction_quantity*1  " +
"					END) AS stock " +
"					FROM returns r, item it  " +
"					RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND inv.invoice_location_id = ?  " +
"					AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id  " +
"					AND r.return_del_flag = 0 ORDER BY item_id, invoice_date, transaction_id  " +
"				) AS retList GROUP BY item_id " +
"	)b WHERE stocks > 0 AND b.item_client_number = c.client_id ORDER BY b.item_name " ;
//"	) AND cli.client_id = ite.item_client_number";
    
    public static final String SELECT_SUPPLIER_ITEMS = "SELECT * ,c.client_name FROM item i, client c WHERE i.item_client_number = c.client_id AND i.item_client_number = ? AND i.item_del_flag != 1 ";
    public static final String SELECT_ALL_SUPPLIER_ITEMS = "SELECT * ,c.client_name FROM item i, client c WHERE i.item_client_number = c.client_id AND i.item_del_flag != 1 ";
//    public static final String SELECT_SUPPLIER_ITEMS_WITH_STOCKS = "SELECT * ,c.client_name, s.stocks_quantity FROM item i, client c, stocks s WHERE i.item_client_number = c.client_id AND i.item_client_number = ? AND i.item_id = s.stocks_item_id AND s.stocks_location_id = ? AND i.item_del_flag != 1 ";

    //USES STock table to get INVENTORY REPORT
    public static final String SELECT_SUPPLIER_ITEMS_WITH_STOCKS = "SELECT * ,c.client_name, s.stocks_quantity FROM item i, client c, stocks s WHERE i.item_client_number = c.client_id AND i.item_client_number = ? AND i.item_id = s.stocks_item_id AND s.stocks_location_id = ?  AND stocks_del_flag = 0 AND i.item_del_flag != 1 ";
    
    //Computes Stocks to get INVENTORY REPORT
    public static final String SELECT_SUPPLIER_ITEMS_WITH_STOCK = "SELECT  b.item_id, b.item_name, b.item_client_number, b.item_price, b.client_name, b.stocks as stocks_quantity, b.invoice_date as item_date_as_of FROM (SELECT @tot_dur:= 0 ) inst,  " +
"	( SELECT * ,  " +
"		(CASE " +
"			WHEN invoice_type_flag = '1' " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			WHEN invoice_type_flag = '0'  " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			END)  AS tot_dur, SUM(stock) stocks " +
"           FROM(  " +
"				SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, n.invoice_location_id , i.item_id, i.item_client_number, i.item_price, @tot_dur as summary " +
"				 ,(CASE  " +
"						WHEN n.invoice_type_flag = '1' THEN transaction_quantity*1  " +
"						WHEN n.invoice_type_flag = '0' THEN transaction_quantity*-1  " +
"					END) AS stock " +
"					FROM item i  " +
"					RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND n.invoice_location_id = ? AND n.invoice_del_flag = 0  " +
"				UNION  " +
"				SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name,  " +
"					(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN '0'  " +
"						WHEN inv.invoice_type_flag = '0' THEN '1'  " +
"					END) AS invoice_type_flag,  " +
"					it.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, inv.invoice_location_id, it.item_id, it.item_client_number, it.item_price, @tot_dur as summary  " +
"					,(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN transaction_quantity*-1  " +
"						WHEN inv.invoice_type_flag = '0' THEN transaction_quantity*1  " +
"					END) AS stock " +
"					FROM returns r, item it  " +
"					RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND inv.invoice_location_id = ?  " +
"					AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id  " +
"					AND r.return_del_flag = 0 ORDER BY item_id, invoice_date DESC, transaction_id  " +
"				) AS retList GROUP BY item_id " +
"	)b WHERE b.item_client_number = ? ORDER BY invoice_date ";
    
    public static final String SELECT_ITEM = "SELECT * ,c.client_name FROM item i, client c WHERE i.item_id = ? AND i.item_client_number = c.client_id AND  i.item_del_flag != 1";
//    public static final String SELECT_FULL_ITEM = "SELECT i.item_id, i.item_name, i.item_price, IFNULL(SUM(n.invoice_quantity),0) AS quantity FROM item i LEFT OUTER JOIN invoice n  ON n.invoice_item_number = i.item_id WHERE i.item_id = ? AND i.item_del_flag != 1";
    public static final String SELECT_FULL_ITEM = "SELECT i.item_id, i.item_name, i.item_price, item_current_quantity ,c.client_name ,i.item_client_number FROM item i, client c WHERE i.item_client_number = c.client_id AND i.item_id = ? AND i.item_del_flag != 1";
    public static final String UPDATE_ITEM = "UPDATE item SET item_name = ? , item_client_number = ? , item_price = ? , item_edit_date = ?, item_edit_user = ? WHERE item_id = ?";
    public static final String UPDATE_ITEM_QUANTITY = "UPDATE item SET item_current_quantity = ?, item_date_as_of = ? WHERE item_id = ?";
    public static final String INSERT_INTO_ITEMS = "INSERT INTO item (item_name, item_client_number, item_price, item_del_flag, item_current_quantity, item_add_date, item_add_user) "
            + "VALUES (?,?,?,0,0,?,?)";
    public static final String DELETE_ITEM = "UPDATE item SET item_del_flag = 1 , item_del_date = ?  WHERE item_id = ?";
// SELECT CURRENT DETAILED SALES
    public static final String SELECT_DET_SALES_SUPPLIER = "SELECT i.item_client_number, c.client_name, i.item_name, SUM(t.transaction_quantity) as quantity, COALESCE(SUM(r.returns_quantity),0) as returns FROM item i, client c, transaction t " +
"LEFT JOIN (SELECT * FROM returns WHERE return_del_flag = 0)r on t.transaction_id = returns_transaction_id " +
"LEFT JOIN (SELECT * FROM invoice WHERE invoice_del_flag = 0 AND invoice_transfer_flag = 0)n on t.transaction_invoice_id = invoice_id " +
"WHERE i.item_client_number = c.client_id " +
"AND i.item_id = t.transaction_item_number AND t.transaction_del_flag = 0 AND n.invoice_location_id = ? AND i.item_client_number = ? AND n.invoice_date BETWEEN ? AND ? GROUP BY i.item_id";
    
    
    
    //INVOICE SQL
//   public static final String INSERT_IN_INVOICE = "INSERT INTO invoice (invoice_number, invoice_item_number, invoice_price, invoice_date, invoice_quantity, invoice_transaction_flag, invoice_del_flag) "
//            + "VALUES (?,?,?,?,?,0,0)";
   public static final String INSERT_IN_INVOICE = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user) "
            + "VALUES (?,?,?,?,?,?,?,?,1,?,?,?)";
   public static final String INSERT_OUT_INVOICE = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user) "
            + "VALUES (?,?,?,?,?,?,?,?,0,?,?,?)";
   public static final String INSERT_INVOICE = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user, invoice_location_id, invoice_driver, invoice_salesperson_id) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
   public static final String INSERT_INVOICE_REMARKS = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user, invoice_location_id, invoice_driver, invoice_remarks) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
   public static final String INSERT_INVOICE_DEBIT_MEMO = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user, invoice_location_id, invoice_driver, invoice_dm_flag) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
   public static final String INSERT_INVOICE_TRANSFER = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_date, invoice_payment_type, invoice_total_price, invoice_current_balance, invoice_due_date, invoice_receivable_flag, invoice_type_flag, invoice_paid_flag, invoice_add_date, invoice_add_user, invoice_location_id, invoice_transfer_flag) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
   public static final String EDIT_INVOICE = "UPDATE invoice SET invoice_number = ?, invoice_client_number = ?, invoice_date = ?, invoice_payment_type = ?, invoice_total_price = ?, invoice_current_balance = ?,invoice_due_date = ?, invoice_receivable_flag = ?, invoice_type_flag = ?, invoice_paid_flag = ?, invoice_location_id = ?, invoice_edit_date = ?, invoice_edit_user = ?, invoice_driver = ?, invoice_salesperson_id = ? "
           + "WHERE invoice_id = ?";
   
   public static final String DELETE_INVOICE = "UPDATE invoice SET invoice_edit_date = ?, invoice_edit_user = ?, invoice_del_flag = 1, invoice_del_date = ? "
           + "WHERE invoice_id = ?";
//            + "VALUES (?,?,?,?,?,?,?,?,0,?,?,?)";
   
   public static final String SELECT_INVOICE_WITH_NAME = "SELECT i.*, c.client_name FROM invoice i, client c WHERE invoice_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_del_flag = 0";
   public static final String SELECT_INVOICE_WITH_ID = "SELECT i.*, c.client_name, c.client_id, c.client_address FROM invoice i, client c WHERE invoice_id = ? AND c.client_id = i.invoice_client_number AND i.invoice_del_flag = 0";
   public static final String SELECT_ALL_INVOICE_SEARCH = "SELECT i.*, c.client_name, c.client_id, c.client_address FROM invoice i, client c WHERE c.client_id = i.invoice_client_number AND invoice_payment_type != 0 AND invoice_del_flag = 0";
   public static final String SELECT_ALL_INVOICE_SEARCH_WITH_TYPE = "SELECT i.*, c.client_name, c.client_id, c.client_address FROM invoice i, client c WHERE c.client_id = i.invoice_client_number AND invoice_payment_type != 0 AND invoice_paid_flag != 1 AND invoice_type_flag = ? AND invoice_del_flag = 0";
   public static final String SELECT_INVOICE_WITH_CLIENT_OLD = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND c.client_id = i.invoice_client_number AND invoice_receivable_flag = 1";
   public static final String SELECT_INVOICE_WITH_CLIENT = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND c.client_id = i.invoice_client_number AND invoice_receivable_flag = 1 AND invoice_paid_flag = 0 ORDER BY invoice_date";
   public static final String SELECT_INVOICE_WITH_CLIENT_PAYMENTS = "SELECT client_number, client_address, client_name, SUM(invoice_total_price) AS grandtotal_price, SUM(invoice_current_balance) AS grandcurrent_balance, SUM(invoice_payments) AS grand_payments, credit_limit FROM "
           + "( " +
"SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name, c.client_number, c.client_address, IFNULL(n.invoice_balance,0) as invoice_payments, " +
"IFNULL(c.client_credit_limit,'0') AS credit_limit FROM invoice i " +
" LEFT JOIN " +
"(SELECT inv.invoice_id as invoice_id, IFNULL(SUM(collection_amount),0) AS invoice_balance FROM collections col, invoice inv " +
"  WHERE collection_invoice_id = inv.invoice_id AND inv.invoice_client_number = ? AND collection_del_flag = 0 GROUP BY invoice_id) AS n " +
"ON i.invoice_id = n.invoice_id , client c " +
"WHERE invoice_client_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_receivable_flag = 1 AND i.invoice_del_flag = 0) res";
   
   public static final String SELECT_INVOICE_WITH_ALL_CLIENT_PAYMENTS = "SELECT client_id, client_number, client_address, client_name, client_sub_type, SUM(invoice_total_price) AS grandtotal_price, SUM(invoice_current_balance) AS grandcurrent_balance, SUM(invoice_payments) AS grand_payments, credit_limit FROM "
           + "( " +
"SELECT client_id, i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name, c.client_number, c.client_address, client_sub_type, IFNULL(n.invoice_balance,0) as invoice_payments, " +
"IFNULL(c.client_credit_limit,'0') AS credit_limit FROM invoice i " +
" LEFT JOIN " +
"(SELECT inv.invoice_id as invoice_id, IFNULL(SUM(collection_amount),0) AS invoice_balance FROM collections col, invoice inv " +
"  WHERE collection_invoice_id = inv.invoice_id AND collection_del_flag = 0 GROUP BY invoice_id) AS n " +
"ON i.invoice_id = n.invoice_id , client c " +
"WHERE c.client_id = i.invoice_client_number AND client_type_flag = ? AND i.invoice_receivable_flag = 1 AND i.invoice_del_flag = 0) res GROUP BY client_id ORDER BY client_number";
   
   
   public static final String SELECT_INVOICE_WITH_ALL_CLIENT_PAYMENTS_SUBTYPE = "SELECT client_id, client_number, client_address, client_name, client_sub_type, SUM(invoice_total_price) AS grandtotal_price, SUM(invoice_current_balance) AS grandcurrent_balance, SUM(invoice_payments) AS grand_payments, credit_limit FROM "
           + "( " +
"SELECT client_id, i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name, c.client_number, c.client_address, client_sub_type, IFNULL(n.invoice_balance,0) as invoice_payments, " +
"IFNULL(c.client_credit_limit,'0') AS credit_limit FROM invoice i " +
" LEFT JOIN " +
"(SELECT inv.invoice_id as invoice_id, IFNULL(SUM(collection_amount),0) AS invoice_balance FROM collections col, invoice inv " +
"  WHERE collection_invoice_id = inv.invoice_id AND collection_del_flag = 0 GROUP BY invoice_id) AS n " +
"ON i.invoice_id = n.invoice_id , client c " +
"WHERE c.client_id = i.invoice_client_number AND client_type_flag = ? AND client_sub_type = ? AND i.invoice_receivable_flag = 1 AND i.invoice_del_flag = 0) res GROUP BY client_id ORDER BY client_number";
   
   public static final String SELECT_ALL_INVOICE_WITH_CLIENT = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_client_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_del_flag = 0";
   public static final String SELECT_ALL_INVOICE_WITH_CLIENT_NOT_DEBIT = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_client_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_del_flag = 0 AND i.invoice_dm_flag = 0";
   public static final String SELECT_ALL_INVOICE_WITH_CLIENT_DATE = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_client_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_date BETWEEN ? AND ? AND i.invoice_del_flag = 0 AND i.invoice_dm_flag = 0";
   public static final String SELECT_ALL_INVOICE_WITH_SALES_PERSON = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_salesperson_id = ? AND c.client_id = i.invoice_client_number AND i.invoice_date BETWEEN ? AND ? AND i.invoice_del_flag = 0 AND i.invoice_dm_flag = 0";
   public static final String SELECT_ALL_INVOICE_WITH_DATE = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_date LIKE ? AND c.client_id = i.invoice_client_number AND i.invoice_del_flag = 0";
   public static final String SELECT_ALL_INVOICE_COLLECTION_WITH_CLIENT = "SELECT i.*,IFNULL(i.invoice_edit_user,'-')AS edit_user, IFNULL(i.invoice_add_user,'-')AS add_user, c.client_name FROM invoice i, client c WHERE invoice_client_number = ? AND c.client_id = i.invoice_client_number AND i.invoice_payment_type != 0 AND i.invoice_del_flag = 0";
//   public static final String INSERT_OUT_INVOICE = "INSERT INTO invoice (invoice_number, invoice_client_number, invoice_item_number, invoice_price, invoice_date, invoice_quantity, invoice_transaction_flag, invoice_del_flag) "
//            + "VALUES (?,?,?,?,?,?,1,0)";
   public static final String SELECT_LATEST_INVOICE = "SELECT MAX(invoice_id)AS invoice_id FROM invoice";
   public static final String SELECT_ALL_INDIV_INVOICE = "SELECT n.invoice_number, IFNULL(c.client_name,'')AS customer_name, cn.client_name AS supplier_name, i.item_id, i.item_name, i.item_price, n.invoice_quantity , n.invoice_price, n.invoice_date, n.invoice_transaction_flag FROM item i "
            + "RIGHT JOIN invoice n  ON n.invoice_item_number = i.item_id "
            + "LEFT OUTER JOIN client c ON n.invoice_client_number = c.client_id "
            + "LEFT OUTER JOIN client cn ON i.item_client_number = cn.client_id WHERE i.item_del_flag != 1 LIMIT 50";
      
   public static final String SELECT_ITEM_LEDGER = "SELECT n.invoice_date, n.invoice_number, cn.client_name,n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, t.transaction_quantity_as_of FROM item i "
   + " RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id"
   + " LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE i.item_del_flag != 1 AND i.item_id = ? ORDER BY invoice_date";
   
   public static final String SELECT_ITEM_LEDGER_FROM_TO = "SELECT n.invoice_date, n.invoice_number, cn.client_name,n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, t.transaction_quantity_as_of FROM item i "
   + " RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id"
   + " LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_date BETWEEN ? AND ? ORDER BY invoice_date";
   
   public static final String SELECT_ITEM_LEDGER_FROM_TO_WITH_LOCATION_OLD = "SELECT n.invoice_date, n.invoice_number, cn.client_name,n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, t.transaction_quantity_as_of FROM item i "
   + " RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id"
   + " LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_date BETWEEN ? AND ? ORDER BY invoice_date";
   
   public static final String SELECT_ITEM_LEDGER_FROM_TO_WITH_LOCATION_BUGGED = "SELECT n.invoice_date, n.invoice_number, cn.client_name,n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity FROM item i " +
"    RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id" +
"    LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_date BETWEEN ? AND ? AND n.invoice_del_flag = 0 " +
"UNION " +
"SELECT r.returns_date as invoice_date, 'RTN' as invoice_number, cn.client_name, " +
"(CASE " +
"	  WHEN n.invoice_type_flag = '1' THEN '0' " +
"	  WHEN n.invoice_type_flag = '0' THEN '1' " +
"END) AS invoice_type_flag, " +
" i.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity FROM returns r, item i " +
"    RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id " +
"    LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND r.returns_transaction_id = t.transaction_id AND r.returns_date BETWEEN ? AND ? " +
" " +
"ORDER BY invoice_date";
   
//   public static final String SELECT_ITEM_LEDGER_FROM_TO_WITH_LOCATION =
////           " SET @tot_dur:=0; "
//            "SELECT o.invoice_date, o.invoice_number, o.client_name, o.invoice_type_flag, o.item_name, o.transaction_price, o.transaction_quantity, o.invoice_remarks, beggining.tot_dur as quantity_as_of "
//           + " FROM ( "
//           + "SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, n.invoice_remarks FROM item i "
//           + "RIGHT JOIN transaction t ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id "
//           + "LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_date BETWEEN ? AND ? AND n.invoice_del_flag = 0 "
//           + "UNION "
//           + "SELECT t.transaction_id, CONCAT('RTN',r.returns_id)  as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cn.client_name, "
//           + "(CASE "
//           + "WHEN n.invoice_type_flag = '1' THEN '0' "
//           + "WHEN n.invoice_type_flag = '0' THEN '1' "
//           + "END) AS invoice_type_flag, "
//           + "i.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, '-' as invoice_remarks FROM returns r, item i "
//           + "RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id "
//           + "LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND r.returns_transaction_id = t.transaction_id AND r.returns_date BETWEEN ? AND ? "
//           + "ORDER BY invoice_date, transaction_id )  o, "
//           + "(SELECT b.transaction_id, b.invoice_id, b.tot_dur  FROM (SELECT @tot_dur:= 0 ) inst, "
//           + "( "
//           + "SELECT * , (CASE "
//           + "WHEN invoice_type_flag = '1' "
//           + "THEN IF (transaction_quantity IS NOT NULL, "
//           + "@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0) "
//           + "WHEN invoice_type_flag = '0' "
//           + "THEN IF (transaction_quantity IS NOT NULL, "
//           + "@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0) "
//           + "END) AS tot_dur "
//           + "FROM( "
//           + "SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity , @tot_dur as summary "
//           + "FROM item i "
//           + "RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id "
//           + "LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_del_flag = 0 "
////           + "ORDER BY  n.invoice_date "
////           + ") AS tranList "
//           + "UNION "
////           + "SELECT * , (CASE "
////           + "WHEN invoice_type_flag = '1' "
////           + "THEN IF (transaction_quantity IS NOT NULL, "
////           + "@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0) "
////           + "WHEN invoice_type_flag = '0' "
////           + "THEN IF (transaction_quantity IS NOT NULL, "
////           + "@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0) "
////           + "END) AS tot_dur FROM ( "
//           + "SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name, "
//           + "(CASE "
//           + "WHEN inv.invoice_type_flag = '1' THEN '0' "
//           + "WHEN inv.invoice_type_flag = '0' THEN '1' "
//           + "END) AS invoice_type_flag, "
//           + "it.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity,  @tot_dur as summary "
//           + "FROM returns r, item it "
//           + "RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id "
//           + "LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND it.item_id = ? AND inv.invoice_location_id = ? AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id "
//           + "AND r.return_del_flag = 0 ORDER BY invoice_date, transaction_id "
//           + ") AS retList "
//           + "ORDER BY invoice_date "
//           + ") b "
//           + ") beggining "
////           + "WHERE o.invoice_id = beggining.invoice_id ORDER BY invoice_date ";
//           + "WHERE o.invoice_id = beggining.invoice_id AND o.transaction_id = beggining.transaction_id ORDER BY invoice_date ";
   
   
public static final String SELECT_ITEM_LEDGER_FROM_TO_WITH_LOCATION = "Select * from ("
      + "SELECT o.invoice_date, o.invoice_number, o.client_name, o.invoice_type_flag, o.item_name, o.transaction_price, o.transaction_quantity, o.invoice_remarks,  o.tot_dur as quantity_as_of FROM "
//      + " #initialize tot_quantity"
      + "(SELECT @tot_dur:= 0 )  inst,"
//      + " #b start   "
      + "(SELECT * , (CASE WHEN invoice_type_flag = '1' "
              + " THEN IF (transaction_quantity IS NOT NULL, "
              + " @tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0) "
              + " WHEN invoice_type_flag = '0' "
              + " THEN IF (transaction_quantity IS NOT NULL, "
              + " @tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0)  END) AS tot_dur "
              + " FROM "
                + "(SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity ,n.invoice_remarks, @tot_dur as summary "
                + "FROM item i "
                + "RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id "
                + "LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_del_flag = 0 "
                + "UNION "
                + "SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name, "
                + "(CASE WHEN inv.invoice_type_flag = '1' THEN '0' "
                + "WHEN inv.invoice_type_flag = '0' THEN '1' END) AS invoice_type_flag, "
                + "it.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, '-' as invoice_remarks, @tot_dur as summary "
                + "FROM returns r, item it "
                + "RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id "
                + "LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND it.item_id = ? AND inv.invoice_location_id = ? AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id "
      + "AND r.return_del_flag = 0 ORDER BY invoice_date, transaction_id ) AS retList "
    + "ORDER BY invoice_date ) "
+ "o) al WHERE al.invoice_date BETWEEN ? AND ? ";
   
   public static final String SELECT_INVOICE_WITH_DATE = "SELECT invoice_number as nNum, invoice_date as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, '-' as check_date FROM invoice "
           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1  AND invoice_date BETWEEN ? AND ? ORDER BY nDate, nNum" ;
   
   public static final String SELECT_INVOICE_WITHOUT_DATE = "SELECT invoice_number as nNum, invoice_date as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, '-' as check_date FROM invoice "
           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1  AND invoice_date BETWEEN ? AND ? ORDER BY nDate, nNum" ;
   
//   public static final String SELECT_ALL_INVOICE = "SELECT n.*,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number";
    public static final String SELECT_ALL_INVOICE = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_del_flag = 0 AND n.invoice_dm_flag = 0 ORDER BY n.invoice_date DESC";
    public static final String SELECT_ALL_INVOICE_BETWEEN = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_date BETWEEN ? AND ? AND n.invoice_del_flag = 0 AND n.invoice_dm_flag = 0 ORDER BY n.invoice_date DESC";
    public static final String SELECT_ALL_INVOICE_WITH_NUMBER = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_del_flag = 0 AND n.invoice_dm_flag = 0 AND n.invoice_number = ?";
    public static final String COUNT_ALL_INVOICE_WITH_NUMBER = "SELECT Count(*) as number FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_del_flag = 0 AND n.invoice_dm_flag = 0 AND n.invoice_number = ?";
   public static final String SELECT_ALL_DEBIT_MEMO = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_del_flag = 0 AND n.invoice_dm_flag = 1 ORDER BY n.invoice_date DESC";
   public static final String SELECT_ALL_INVOICE_TRANSFER = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_del_flag = 0";
   public static final String SELECT_ALL_DAILY_SALES_REPORT = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number  AND c.client_id != 4 AND n.invoice_del_flag = 0 AND n.invoice_date BETWEEN ? AND ? AND n.invoice_transfer_flag = 0 AND n.invoice_dm_flag = 0 AND c.client_type_flag != 4 ORDER BY n.invoice_date";
   
   public static final String SELECT_ALL_DAILY_OTC_REPORT = "SELECT n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name FROM invoice n, client c WHERE c.client_id = n.invoice_client_number AND n.invoice_payment_type = 0  AND c.client_id != 4 AND n.invoice_del_flag = 0 AND n.invoice_date BETWEEN ? AND ? AND n.invoice_transfer_flag = 0 AND n.invoice_dm_flag = 0 AND c.client_type_flag != 4 ORDER BY n.invoice_date";
//   public static final String SELECT_INVOICE_BALANCE = "SELECT IFNULL(SUM(collection_amount),0) AS invoice_balance FROM collections WHERE collection_invoice_number = ? AND collection_del_flag = 0";
   public static final String SELECT_INVOICE_BALANCE = "SELECT IFNULL(SUM(collection_amount),0) AS invoice_balance FROM collections WHERE collection_invoice_id = ? AND collection_del_flag = 0";
   public static final String UPDATE_INVOICE_BALANCE = "UPDATE invoice SET invoice_current_balance = ?, invoice_paid_flag = ?, invoice_date_as_of = ? WHERE invoice_id = ?";
//   public static final String SELECT_ACCOUNTS_RECEIVABLE_PAYABLE = "SELECT withDate.* , beggining.balance FROM "
//           + "( SELECT '1' as id, invoice_id as nId, invoice_number as nVoice, invoice_number as nNum, "
//           + "DATE(invoice_date) as nDate, invoice_number as particular, invoice_total_price as charge, "
//           + "'0' as credit, '-' as check_date, '-' as collection_or_number FROM invoice "
//           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1  AND invoice_date BETWEEN ? AND ? "
//           + "UNION ALL "
//           + "SELECT '2' as id, CONCAT('COL',c.collection_id) as nId, inv.invoice_number as nVoice, c.collection_invoice_number as nNum, "
//           + "DATE(c.collection_date) as nDate, "
//           + "coalesce(c.collection_number,'Cash')as particular, "
//           + "'0' as charge, "
//           + "c.collection_amount as credit, "
//           + "coalesce(DATE(c.collection_check_date),'-') as check_date, "
//           + "coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c, invoice inv "
//           + "WHERE collection_del_flag = 0 AND c.collection_invoice_id = inv.invoice_id AND inv.invoice_client_number = ? AND inv.invoice_receivable_flag = 1 AND collection_date BETWEEN ? AND ? "
//           + "GROUP BY nId,nVoice ORDER BY nDate,nNum,id ) withDate, "
//           + "( SELECT *, "
//           + "CASE  "
//           + "WHEN b.charge = '0' THEN @tot_dur:= @tot_dur - credit "
//           + "WHEN b.credit = '0' THEN @tot_dur:= @tot_dur + charge END AS balance "
//           + "FROM (SELECT @tot_dur:= 0) as init, "
//           + "( SELECT '1' as id, invoice_id as nId, invoice_number as nVoice, invoice_number as nNum, "
//           + "DATE(invoice_date) as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, "
//           + "'-' as check_date, '-' as collection_or_number FROM invoice i "
//           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1 "
//           + "UNION "
//           + "SELECT '2' as id, CONCAT('COL',c.collection_id) as nId, inv.invoice_number as nVoice, c.collection_invoice_number as nNum, "
//           + "DATE(c.collection_date) as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, "
//           + "c.collection_amount as credit, coalesce(DATE(c.collection_check_date),'-') as check_date, "
//           + "coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c, invoice inv "
//           + "WHERE collection_del_flag = 0 AND c.collection_invoice_id = inv.invoice_id "
//           + "AND inv.invoice_client_number = ? AND inv.invoice_receivable_flag = 1 "
//           + "GROUP BY nId,nVoice ORDER BY nDate,nNum,id ) b"
//           + ") beggining "
//           + "WHERE withDate.nId = beggining.nId GROUP BY nId,nVoice ORDER BY nDate,nNum,nid,id";
//   
   
//   public static final String SELECT_ACCOUNTS_RECEIVABLE_PAYABLE = "SELECT withDate.* , beggining.balance FROM "
//           + "( SELECT '1' as id, invoice_id as nId, invoice_number as nVoice, invoice_number as nNum, "
//           + "DATE(invoice_date) as nDate, invoice_number as particular, invoice_total_price as charge, "
//           + "'0' as credit, '-' as check_date, '-' as collection_or_number FROM invoice "
//           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1  AND invoice_date BETWEEN ? AND ? "
//           + "UNION ALL "
//           + "SELECT '2' as id, CONCAT('COL',c.collection_id) as nId, inv.invoice_number as nVoice, c.collection_invoice_number as nNum, "
//           + "DATE(c.collection_date) as nDate, "
//           + "coalesce(c.collection_number,'Cash')as particular, "
//           + "'0' as charge, "
//           + "c.collection_amount as credit, "
//           + "coalesce(DATE(c.collection_check_date),'-') as check_date, "
//           + "coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c, invoice inv "
//           + "WHERE collection_del_flag = 0 AND inv.invoice_del_flag = 0 AND c.collection_invoice_id = inv.invoice_id AND inv.invoice_client_number = ? AND inv.invoice_receivable_flag = 1 AND collection_date BETWEEN ? AND ? "
//           + "GROUP BY nId,nVoice ORDER BY nDate,nNum,id ) withDate, "
//           + "( SELECT *, "
//           + "CASE  "
//           + "WHEN b.charge = '0' THEN @tot_dur:= @tot_dur - credit "
//           + "WHEN b.credit = '0' THEN @tot_dur:= @tot_dur + charge END AS balance "
//           + "FROM (SELECT @tot_dur:= 0) as init, "
//           + "( SELECT '1' as id, invoice_id as nId, invoice_number as nVoice, invoice_number as nNum, "
//           + "DATE(invoice_date) as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, "
//           + "'-' as check_date, '-' as collection_or_number FROM invoice i "
//           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1 "
//           + "UNION "
//           + "SELECT '2' as id, CONCAT('COL',c.collection_id) as nId, inv.invoice_number as nVoice, c.collection_invoice_number as nNum, "
//           + "DATE(c.collection_date) as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, "
//           + "c.collection_amount as credit, coalesce(DATE(c.collection_check_date),'-') as check_date, "
//           + "coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c, invoice inv "
//           + "WHERE collection_del_flag = 0 AND inv.invoice_del_flag = 0 AND c.collection_invoice_id = inv.invoice_id "
//           + "AND inv.invoice_client_number = ? AND inv.invoice_receivable_flag = 1 "
//           + "GROUP BY nId,nVoice ORDER BY nDate,nNum,id ) b"
//           + ") beggining "
//           + "WHERE withDate.nId = beggining.nId GROUP BY nId,nVoice ORDER BY nDate,nNum,nid,id";
   
   public static final String SELECT_ACCOUNTS_RECEIVABLE_PAYABLE = 
           "SELECT beggining.* , beggining.balance FROM "
            + " ( SELECT *, CASE WHEN b.charge = '0' THEN @tot_dur:= @tot_dur - credit "
            + "WHEN b.credit = '0' THEN @tot_dur:= @tot_dur + charge END AS balance "
            + "FROM "
                + "(SELECT @tot_dur:= 0) as init, "
                + "( SELECT '1' as id, invoice_id as nId, invoice_number as nVoice, invoice_id as nNum, DATE(i.invoice_date) as invoice_date, NULL as collection_date, "
                + "DATE(invoice_date) as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, " 
                + "'-' as check_date, '-' as collection_or_number FROM invoice i " 
                + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1 "
                + "UNION "
                + "SELECT '2' as id, CONCAT('COL',c.collection_id) as nId, inv.invoice_number as nVoice, c.collection_invoice_id as nNum, "
                + "NULL as invoice_date, DATE(c.collection_date) as collection_date, DATE(c.collection_date) as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, "
                + "c.collection_amount as credit, coalesce(DATE(c.collection_check_date),'-') as check_date, "
                + "coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c, invoice inv "
                + "WHERE collection_del_flag = 0 AND inv.invoice_del_flag = 0 AND c.collection_invoice_id = inv.invoice_id "
                + "AND inv.invoice_client_number = ? AND inv.invoice_receivable_flag = 1 "
                + "GROUP BY nId,nVoice ORDER BY nDate,nNum,id ) b "
           + ") beggining "
           + "WHERE  nDate BETWEEN ? AND ? GROUP BY nId, nVoice ORDER BY nNum, id, nDate, nid ";
   
   
   
   //Transaction SQL
   public static final String INSERT_IN_TRANSACTION = "INSERT INTO transaction (transaction_invoice_id, transaction_item_number, transaction_price, transaction_quantity, transaction_quantity_as_of, transaction_date, transaction_del_flag, transaction_add_date, transaction_add_user, transaction_preorder_transaction_id)"
           + "VALUES (?,?,?,?,?,?,0,?,?,?)" ;
   public static final String DELETE_TRANSACTION = " UPDATE transaction SET  transaction_del_date = ?, transaction_edit_date = ?, transaction_edit_user =?, transaction_del_flag = 1 WHERE transaction_id = ?";
   public static final String SELECT_TRANSACTIONS_INV = "SELECT t.*, i.item_name, c.client_name FROM transaction t, item i, client c where t.transaction_invoice_id = ? AND t.transaction_item_number = i.item_id AND i.item_client_number = c.client_id AND transaction_del_flag = 0";
   public static final String SELECT_TRANSACTION = "SELECT t.*, i.item_name, c.client_name FROM transaction t, item i, client c where t.transaction_id = ? AND t.transaction_item_number = i.item_id AND i.item_client_number = c.client_id AND transaction_del_flag = 0";
   public static final String SELECT_QUANTITY_PO_TRANSACTIONS_INVOICE = "SELECT IFNULL(SUM(transaction_quantity),0) as quantity FROM transaction t WHERE t.transaction_preorder_transaction_id = ? ";
   
   //Collection SQL
   public static final String SELECT_LATEST_COLLECTION = "SELECT MAX(collection_id)AS collection_id FROM collections";
   
   public static final String INSERT_IN_COLLECTION_CHECK = "INSERT INTO collections (collection_number, collection_invoice_id, collection_amount, collection_date, collection_check_date, collection_balance_as_of, collection_type_flag, collection_cleared_flag, collection_add_date, collection_add_user, collection_invoice_number, collection_or_number, collection_credit_memo_flag)"
           + "VALUES (?,?,?,?,?,?,1,?,?,?,?,?,?)" ;
   public static final String INSERT_IN_COLLECTION = "INSERT INTO collections (collection_number, collection_invoice_id, collection_amount, collection_date, collection_check_date, collection_balance_as_of, collection_type_flag, collection_cleared_flag, collection_add_date, collection_add_user, collection_invoice_number, collection_or_number)"
           + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)" ;
   
   public static final String INSERT_IN_COLLECTION_CASH = "INSERT INTO collections (collection_invoice_id, collection_amount, collection_date, collection_balance_as_of, collection_type_flag, collection_cleared_flag, collection_add_date, collection_add_user, collection_invoice_number, collection_or_number)"
           + "VALUES (?,?,?,?,0,1,?,?,?,?)" ;
   public static final String CLEAR_COLLECTION = "UPDATE collections SET collection_cleared_flag = 1 WHERE collection_id = ?" ;
   
   public static final String DELETE_COLLECTION = "UPDATE collections SET collection_del_flag = 1, collection_del_date = ? WHERE collection_id = ?" ;
   
   public static final String DELETE_COLLECTION_WITH_INVOICE_ID = "UPDATE collections SET collection_del_flag = 1, collection_del_date = ? WHERE collection_invoice_id = ?" ;
   
   public static final String SELECT_RECEIVABLE_LEDGER = "SELECT invoice_date as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, '' as check_date FROM invoice WHERE invoice_client_number = ? "
           + "UNION "
           + "SELECT c.collection_date as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, c.collection_amount as credit FROM collections c, invoice i "
           + "WHERE c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = ? ORDER BY nDate" ;
   
   public static final String SELECT_RECEIVABLE_LEDGER_WITH_DATE = "SELECT invoice_number as nNum, invoice_date as nDate, invoice_number as particular, invoice_total_price as charge, '0' as credit, '-' as check_date FROM invoice "
           + "WHERE invoice_del_flag = 0 AND invoice_client_number = ? AND invoice_receivable_flag = 1  AND invoice_date BETWEEN ? AND ? "
           + "UNION "
           + "SELECT c.collection_invoice_number as nNum, c.collection_date as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, c.collection_amount as credit, coalesce(DATE(c.collection_check_date),'-') as check_date FROM collections c, invoice i "
           + "WHERE collection_del_flag = 0 AND c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = ? AND collection_date BETWEEN ? AND ? ORDER BY nNum" ;
   
   public static final String SELECT_COLLECTED_BALACE = "SELECT  sum(c.collection_amount) AS balance from collections c WHERE c. collection_invoice_id = ? and collection_del_flag = 0";
   public static final String SELECT_COLLECTED_BALACE_USING_ID = "SELECT  sum(c.collection_amount) AS balance from collections c WHERE c. collection_invoice_id = ? " +
"and collection_del_flag = 0 AND (( collection_type_flag = '1' AND collection_cleared_flag ='1' ) OR collection_type_flag = '0' OR collection_type_flag = '3')";
   
   public static final String SELECT_COLLECTED_BALACE_NOT_ID = "SELECT  sum(c.collection_amount) AS balance from collections c WHERE c. collection_invoice_id = ? " +
"and collection_del_flag = 0 AND collection_id != ? AND (( collection_type_flag = '1' AND collection_cleared_flag ='1' ) OR collection_type_flag = '0' OR collection_type_flag = '3')";
   
   public static final String SELECT_COLLECTION_WITH_DATE = "SELECT c.collection_invoice_number as nNum, c.collection_date as nDate, coalesce(c.collection_number,'Cash')as particular, '0' as charge, c.collection_amount as credit, coalesce(DATE(c.collection_check_date),'-') as check_date, coalesce((c.collection_or_number),'-') as collection_or_number FROM collections c "
           + "WHERE collection_del_flag = 0 AND c.collection_invoice_number = ? AND collection_date BETWEEN ? AND ? ORDER BY nNum" ;
   public static final String SELECT_COLLECTION_LIST = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user FROM collections c WHERE c.collection_invoice_number = ? AND collection_del_flag = 0" ;
   public static final String SELECT_COLLECTION_LIST_USING_ID = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user FROM collections c WHERE c.collection_invoice_id = ? AND collection_del_flag = 0" ;
   public static final String SELECT_POST_DATED_COLLECTION_LIST = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user FROM collections c, invoice i WHERE c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = ? AND c.collection_cleared_flag = 0  AND i.invoice_del_flag = 0 AND collection_del_flag = 0" ;
   public static final String SELECT_COLLECTION_LIST_DATE = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user, cu.client_name FROM collections c, invoice i, client cu WHERE c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = cu.client_id AND i.invoice_type_flag = 0  AND c.collection_date LIKE ? AND i.invoice_del_flag = 0 AND i.invoice_receivable_flag != 0 AND collection_del_flag = 0" ;
   public static final String SELECT_PAYMENT_LIST_DATE = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user, cu.client_name FROM collections c, invoice i, client cu WHERE c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = cu.client_id AND i.invoice_type_flag = 1 AND c.collection_date LIKE ? AND i.invoice_del_flag = 0 AND i.invoice_receivable_flag != 0 AND collection_del_flag = 0" ;
   
   //USED TO GET DAILY SALES COLLECTION AND PAYMENT
   public static final String SELECT_COLLECTION_PAYMENT_LIST_DATE = "SELECT *, coalesce(c.collection_number,'Cash')as particular, IFNULL(c.collection_or_number,'-') as or_number, IFNULL(c.collection_add_user,'-') as add_user, IFNULL(c.collection_edit_user,'-') as edit_user, cu.client_name FROM collections c, invoice i, client cu WHERE c.collection_invoice_id = i.invoice_id AND i.invoice_client_number = cu.client_id AND i.invoice_type_flag = ? AND c.collection_date BETWEEN ? AND ? AND i.invoice_del_flag = 0 AND i.invoice_receivable_flag != 0 AND collection_del_flag = 0" ;
   
   
   public static final String SELECT_COLLECTION = "SELECT * FROM collections c WHERE c.collection_id = ? AND collection_del_flag = 0" ;
//   public static final String UPDATE_CHECK_COLLECTION = "UPDATE collections SET collection_date = ?, collection_check_date = ?, collection_type_flag = ?, collection_Number = ?, collection_cleared_flag = ?, collection_amount = ?, collection_edit_date = ?, collection_edit_user = ?  WHERE c.collection_id = ?" ;
   public static final String UPDATE_CHECK_COLLECTION = "UPDATE collections SET collection_date = ?, collection_check_date = ?, collection_type_flag = ?, collection_Number = ?, collection_cleared_flag = ?, collection_amount = ?, collection_edit_date = ?, collection_edit_user = ?, collection_or_number = ? WHERE collection_id = ?" ;
//   public static final String UPDATE_CASH_COLLECTION = "UPDATE collections SET collection_date = ?, collection_type_flag = ?, collection_cleared_flag = ?, collection_amount = ?, collection_edit_date = ?, collection_edit_user = ? WHERE collection_id = ?" ;
   public static final String UPDATE_CASH_COLLECTION = "UPDATE collections SET collection_date = ?, collection_type_flag = ?, collection_cleared_flag = ?, collection_amount = ?, collection_edit_date = ?, collection_edit_user = ?, collection_or_number = ? WHERE collection_id = ?" ;
   
   //User
   public static final String SELECT_USER_WITH_USERNAME= "SELECT COUNT(user_id) AS val FROM user WHERE user_username = ? AND user_del_flg = 0";
   public static final String SELECT_USER_WITH_ID= "SELECT *, IFNULL(user_last_name,'') AS last_name , IFNULL(user_first_name,'') AS first_name FROM user WHERE user_id = ? AND user_del_flg = 0";
   public static final String SELECT_ALL_USER= "SELECT *, IFNULL(user_last_name,'') AS last_name , IFNULL(user_first_name,'') AS first_name FROM user WHERE user_del_flg != 1";
   public static final String INSERT_USER= "INSERT INTO user (user_first_name, user_last_name, user_password, user_type, user_username, user_add_date, user_del_flg, user_add_user) "
           + "VALUES (?,?,?,?,?,?,0,?)";
   public static final String EDIT_USER= "UPDATE user SET user_first_name = ?, user_last_name = ?, user_type = ?, user_username = ?, user_edit_date = ?, user_edit_user = ? WHERE user_id = ?";
   public static final String EDIT_USER_PASSWORD= "UPDATE user SET user_password = ? WHERE user_id = ?";
   public static final String DELETE_USER = "UPDATE user SET user_del_flg = 1 , user_del_date = ?  WHERE user_id = ?";
   public static final String CHECK_USERPASS = "SELECT * , IFNULL(user_last_name,'') AS last_name , IFNULL(user_first_name,'') AS first_name   FROM user WHERE user_username LIKE BINARY ? AND user_password LIKE BINARY ? AND user_del_flg = 0";
   
   //Location
//   public static final String SELECT_ALL_LOCATIONS = "SELECT * FROM location WHERE location_del_flag = 0";
   public static final String SELECT_ALL_LOCATIONS = "SELECT * FROM client WHERE client_del_flag = 0 AND client_type_flag = 3";
   public static final String SELECT_LOCATION = "SELECT * FROM location WHERE location_del_flag = 0 AND location_id = ?";
   public static final String INSERT_INTO_LOCATION = "INSERT INTO location (location_name, location_address, location_tel_no, location_del_flag, location_add_date, location_add_user) "
            + "VALUES (?,?,?,0,?,?)";
   public static final String UPDATE_LOCATION = "UPDATE location SET location_name = ? , location_address = ? , location_tel_no = ? , location_edit_date = ? , location_edit_user = ? WHERE location_id = ?";
    public static final String DELETE_LOCATION = "UPDATE location SET location_del_flag = 1 , location_del_date = ?  WHERE location_id = ?";
    
    //Stocks
//    public static final String SELECT_STOCKS_EXIST = "SELECT COUNT(1) AS count FROM stocks WHERE stocks_item_id = ? AND stocks_location_id = ?";
    public static final String SELECT_STOCKS_EXIST = "SELECT COUNT(1) AS count FROM stocks WHERE stocks_item_id = ? AND stocks_location_id = ? AND stocks_del_flag = 0";
//    public static final String SELECT_STOCKS = "SELECT * FROM stocks WHERE stocks_item_id = ? AND stocks_location_id = ?";
    public static final String SELECT_STOCKS = "SELECT * FROM stocks WHERE stocks_item_id = ? AND stocks_location_id = ? AND stocks_del_flag = 0 ORDER BY stocks_add_date DESC, stocks_del_flag LIMIT 1";
//    public static final String INSERT_INTO_STOCKS = "INSERT INTO stocks (stocks_item_id, stocks_location_id, stocks_quantity) "
//    + "VALUES (?,?,?)";
    
    //calculates stocks value according to item ledger
    public static final String CALCULATE_STOCKS = "SELECT b.transaction_id as stocks_id, b.invoice_id, b.tot_dur as stocks_quantity, invoice_date, b.invoice_location_id as stocks_location_id, b.item_id as stocks_item_id  FROM (SELECT @tot_dur:= 0 ) inst,  " +
"	( SELECT * , " +
"		(CASE " +
"			WHEN invoice_type_flag = '1' " +
"			THEN IF (transaction_quantity IS NOT NULL, " +
"				@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0) " +
"			WHEN invoice_type_flag = '0' " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			END) AS tot_dur  " +
"           FROM(  " +
"				SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, n.invoice_location_id , i.item_id, @tot_dur as summary  " +
"					FROM item i  " +
"					RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND i.item_id = ? AND n.invoice_location_id = ? AND n.invoice_del_flag = 0  " +
"				UNION  " +
"				SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name,  " +
"					(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN '0'  " +
"						WHEN inv.invoice_type_flag = '0' THEN '1'  " +
"					END) AS invoice_type_flag,  " +
"					it.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, inv.invoice_location_id, it.item_id,  @tot_dur as summary  " +
"					FROM returns r, item it  " +
"					RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND it.item_id = ? AND inv.invoice_location_id = ?  " +
"					AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id  " +
"					AND r.return_del_flag = 0 ORDER BY invoice_date, transaction_id  " +
"				) AS retList  " +
"	)b ORDER BY invoice_date " +
"   DESC LIMIT 1";
    
    public static final String INSERT_INTO_STOCKS = "INSERT INTO stocks (stocks_item_id, stocks_location_id, stocks_quantity, stocks_add_date) "
            + "VALUES (?,?,?, NOW())";
    
    public static final String INSERT_INTO_STOCKS_FULL = "INSERT INTO stocks (stocks_item_id, stocks_location_id, stocks_quantity, stocks_add_date, stocks_del_flag) "
            + "VALUES (?,?,?, NOW(),?)";
   public static final String UPDATE_STOCKS = "UPDATE stocks SET stocks_item_id = ?, stocks_location_id  = ?,stocks_quantity = ? WHERE stocks_id = ?";
   
   public static final String DELETE_STOCKS = "UPDATE stocks SET stocks_del_flag = 1 WHERE stocks_id = ?";
   
   public static final String INSERT_INTO_TRANSFER = "INSERT INTO transfer (transfer_number, transfer_from_invoice_id, transfer_to_invoice_id, transfer_date, transfer_add_date, transfer_add_user) "
            + "VALUES (?,?,?,?,?,?)";
   public static final String SELECT_TRANSFERS = "SELECT t.*, cn.client_name as from_name, ct.client_name as to_name FROM transfer t, " +
                                                  "invoice i , client cn , invoice n , client ct WHERE t.transfer_from_invoice_id = i.invoice_id "+
                                                 "AND t.transfer_to_invoice_id = n.invoice_id AND t.transfer_del_flag = 0 AND i.invoice_location_id = cn.client_id AND n.invoice_location_id = ct.client_id";
   
   public static final String SELECT_TRANSFER = "SELECT t.*, cn.client_name as from_name, ct.client_name as to_name, i.invoice_location_id as from_location, n.invoice_location_id as to_location FROM transfer t, " +
"invoice i , client cn , invoice n , client ct WHERE t.transfer_id = ? AND " +
"t.transfer_from_invoice_id = i.invoice_id AND t.transfer_to_invoice_id = n.invoice_id AND t.transfer_del_flag = 0 " +
"AND i.invoice_client_number = cn.client_id AND n.invoice_client_number = ct.client_id";
   
   public static final String DELETE_TRANSFER = "UPDATE transfer SET transfer_del_flag = 1, transfer_del_date  = ? WHERE stocks_id = ?";
   
   public static final String SELECT_TRANSFERS_FROM = "SELECT t.*, cn.client_name as from_name, ct.client_name as to_name FROM transfer t, " +
                                                  "invoice i , client cn , invoice n , client ct WHERE t.transfer_from_invoice_id = i.invoice_id "+
                                                 "AND t.transfer_to_invoice_id = n.invoice_id AND t.transfer_del_flag = 0 AND i.invoice_client_number = cn.client_id AND n.invoice_client_number = ct.client_id "
                                                + "AND transfer_date BETWEEN ? AND ?";
   
   public static final String UPDATE_TRANSFER = "UPDATE transfer SET transfer_number = ?,  transfer_date = ?,  transfer_edit_date = ?, transfer_edit_user = ? "
            + "WHERE transfer_id = ?";
   
   
   //Return_Main
   public static final String INSERT_RETURN_MAIN = "INSERT INTO return_main (return_main_invoice_id, return_main_number, return_main_date, return_main_total ,return_main_add_date, return_main_add_user, return_main_location_id ) "
            + "VALUES (?,?,?,?,?,?,?)";
   
   public static final String UPDATE_RETURN_MAIN = "UPDATE return_main SET return_main_invoice_id = ?, return_main_number = ?, return_main_date = ?, return_main_total = ? ,return_main_edit_date = ?, return_main_edit_user = ?, return_main_location_id = ? WHERE return_main_id = ?";
   
   public static final String DELETE_RETURN_MAIN = "UPDATE return_main SET return_main_del_flag = 1, return_main_del_user = ?, return_main_edit_user = ?, return_main_edit_date = ? WHERE return_main_id = ? ";
   
   public static final String SELECT_LATEST_RETURN_MAIN = "SELECT MAX(return_main_id)AS return_main_id FROM return_main";
   
   public static final String SELECT_RETURN_MAIN_LIST_USING_ID = "SELECT * , IFNULL(r.return_main_add_user,'-') as add_user, IFNULL(r.return_main_edit_user,'-') as edit_user FROM return_main r WHERE r.return_main_invoice_id = ? AND return_main_del_flag = 0" ;
   
   
   
   //returns
   public static final String INSERT_RETURNS = "INSERT INTO returns (returns_transaction_id, returns_quantity, returns_amount, returns_date, returns_add_date, returns_add_user, return_main_id)"
           + "VALUES (?,?,?,?,?,?,?)" ;
   public static final String INSERT_RETURNS_WITH_COLLECTION = "INSERT INTO returns (returns_transaction_id, returns_quantity, returns_amount, returns_date, returns_add_date, returns_add_user, return_main_id, return_collection_number)"
           + "VALUES (?,?,?,?,?,?,?,?)" ;
   public static final String SELECT_RETURNS_QUANTITY = "SELECT SUM(returns_quantity) as quantity FROM returns WHERE returns_transaction_id = ? AND return_del_flag = 0 ";
   
   public static final String SELECT_ALL_RETURNS = "SELECT n.*,i.invoice_number AS invoice_number, IFNULL(n.return_main_add_user,'-')AS add_user,c.client_name FROM return_main n, client c, invoice i WHERE c.client_id = i.invoice_client_number AND n.return_main_invoice_id = i.invoice_id AND n.return_main_del_flag = 0 ORDER BY n.return_main_id ASC";
   
   public static final String SELECT_RETURN_MAIN = "SELECT n.*,i.invoice_number AS invoice_number, IFNULL(n.return_main_add_user,'-')AS add_user,c.client_name FROM return_main n, client c, invoice i WHERE c.client_id = i.invoice_client_number AND n.return_main_invoice_id = i.invoice_id AND n.return_main_del_flag = 0 AND return_main_id = ? ORDER BY n.return_main_id ASC";
   
   public static final String SELECT_RETURNS_INV = "SELECT r.*, i.item_name, c.client_name, i.item_id FROM transaction t, item i, client c, returns r where r.return_main_id = ? AND r.returns_transaction_id = t.transaction_id AND t.transaction_item_number = i.item_id AND i.item_client_number = c.client_id AND r.return_del_flag = 0";
   
   public static final String DELETE_RETURNS = "UPDATE returns SET return_del_flag = 1, return_edit_user = ?, return_edit_date = ? WHERE returns_id = ?";
   
   //Preorder
   
   public static final String INSERT_PREORDER = "INSERT INTO preorder (preorder_number, preorder_client_id, preorder_date, preorder_price, preorder_add_date, preorder_add_user, preorder_location_id) "
            + "VALUES (?,?,?,?,?,?,?)";
  public static final String INSERT_PREORDER_TRANSACTION = "INSERT INTO preorder_transaction (preorder_transaction_preorder_id, preorder_transaction_item_id, preorder_transaction_price, preorder_transaction_quantity, preorder_transaction_date, preorder_transaction_del_flag, preorder_transaction_add_date, preorder_transaction_add_user)"
           + "VALUES (?,?,?,?,?,0,?,?)" ; 
  public static final String SELECT_ALL_PREORDER_WITH_CLIENT = "SELECT i.*,IFNULL(i.preorder_edit_user,'-')AS edit_user, IFNULL(i.preorder_add_user,'-')AS add_user, c.client_name FROM preorder i, client c WHERE preorder_client_id = ? AND c.client_id = i.preorder_client_id AND i.preorder_del_flag = 0";
  
  public static final String SELECT_PREORDER_WITH_ID = "SELECT i.*, c.client_name, c.client_id, c.client_address, c.client_number FROM preorder i, client c WHERE preorder_id = ? AND c.client_id = i.preorder_client_id AND i.preorder_del_flag = 0";

public static final String SELECT_TRANSACTIONS_PO = "SELECT t.*, i.item_name, c.client_name FROM preorder_transaction t, item i, client c where t.preorder_transaction_preorder_id = ? AND t.preorder_transaction_item_id = i.item_id AND i.item_client_number = c.client_id AND preorder_transaction_del_flag = 0";

public static final String DELETE_PREORDER_TRANSACTION = " UPDATE preorder_transaction SET  preorder_transaction_del_date = ?, preorder_transaction_edit_date = ?, preorder_transaction_edit_user =?, preorder_transaction_del_flag = 1 WHERE preorder_transaction_id = ?";

public static final String EDIT_PREORDER = "UPDATE preorder SET preorder_number = ?, preorder_client_id = ?, preorder_date = ?, preorder_price = ?, preorder_location_id = ?, preorder_edit_date = ?, preorder_edit_user = ? "
           + "WHERE preorder_id = ?";

public static final String SELECT_LATEST_PREORDER = "SELECT MAX(preorder_id)AS preorder_id FROM preorder";

public static final String DELETE_PREORDER = "UPDATE preorder SET preorder_edit_date = ?, preorder_edit_user = ?, preorder_del_flag = 1, preorder_del_date = ? "
           + "WHERE preorder_id = ?";

public static final String SELECT_PREORDER_TRANSACTION = "SELECT t.*, i.item_name, c.client_name FROM preorder_transaction t, item i, client c where t.preorder_transaction_id = ? AND t.preorder_transaction_item_id = i.item_id AND i.item_client_number = c.client_id AND preorder_transaction_del_flag = 0";

public static final String SELECT_ALL_PREORDER = "SELECT n.*,IFNULL(n.preorder_edit_user,'-')AS edit_user,IFNULL(n.preorder_add_user,'-')AS add_user,c.client_name FROM preorder n, client c WHERE c.client_id = n.preorder_client_id AND n.preorder_del_flag = 0 ORDER BY n.preorder_id DESC";


//Item Limit
public static final String SELECT_ITEM_LIMIT_EXIST = "SELECT COUNT(1) AS count FROM item_limit WHERE item_limit_item_id = ? AND item_limit_location_id = ?";
public static final String SELECT_ITEM_LIMIT = "SELECT * FROM item_limit WHERE item_limit_item_id = ? AND item_limit_location_id = ?";
    public static final String INSERT_INTO_ITEM_LIMIT = "INSERT INTO item_limit (item_limit_item_id, item_limit_location_id, item_limit_quantity) "
            + "VALUES (?,?,?)";
   public static final String UPDATE_ITEM_LIMIT = "UPDATE item_limit SET item_limit_item_id = ?, item_limit_location_id  = ?, item_limit_quantity = ? WHERE item_limit_id = ?";
   
//   public static final String SELECT_ALL_ITEMS_IN_STOCKS_LIMIT = "SELECT i.* ,c.client_name, s.stocks_quantity, il.item_limit_quantity FROM item i, client c, stocks s, item_limit il WHERE i.item_client_number = c.client_id AND i.item_id = s.stocks_item_id AND i.item_id = il.item_limit_item_id AND s.stocks_location_id = ? AND il.item_limit_location_id = ? AND s.stocks_quantity < il.item_limit_quantity AND i.item_del_flag = 0 ";

//USES STock table
   public static final String SELECT_ALL_ITEMS_IN_STOCKS_LIMIT = "SELECT i.* ,c.client_name, s.stocks_quantity, il.item_limit_quantity FROM item i, client c, "
           + "stocks s, item_limit il WHERE i.item_client_number = c.client_id AND s.stocks_del_flag = 0 AND i.item_id = s.stocks_item_id AND i.item_id = il.item_limit_item_id AND s.stocks_location_id = ? AND il.item_limit_location_id = ? AND s.stocks_quantity < il.item_limit_quantity AND i.item_del_flag = 0 ";
   
   
//Computes for stock value   
   public static final String SELECT_ALL_ITEMS_WITH_STOCKS_UNDER_LIMIT = "SELECT  b.item_id, b.item_name, b.item_client_number, b.item_price, b.client_name, b.stocks as stocks_quantity, il.item_limit_quantity FROM (SELECT @tot_dur:= 0 ) inst,  " +
"	( SELECT * ,  " +
"		(CASE " +
"			WHEN invoice_type_flag = '1' " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur + transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			WHEN invoice_type_flag = '0'  " +
"			THEN IF (transaction_quantity IS NOT NULL,  " +
"				@tot_dur := @tot_dur - transaction_quantity, @tot_dur:= @totdur + 0)  " +
"			END)  AS tot_dur, SUM(stock) stocks " +
"           FROM(  " +
"				SELECT t.transaction_id, n.invoice_id, n.invoice_date, n.invoice_number, cn.client_name, n.invoice_type_flag, i.item_name, t.transaction_price, t.transaction_quantity, n.invoice_location_id , i.item_id, i.item_client_number, i.item_price, @tot_dur as summary " +
"				 ,(CASE  " +
"						WHEN n.invoice_type_flag = '1' THEN transaction_quantity*1  " +
"						WHEN n.invoice_type_flag = '0' THEN transaction_quantity*-1  " +
"					END) AS stock " +
"					FROM item i  " +
"					RIGHT JOIN transaction t  ON t.transaction_item_number = i.item_id LEFT OUTER JOIN invoice n ON n.invoice_id = t.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cn ON n.invoice_client_number = cn.client_id WHERE t.transaction_del_flag = 0 AND i.item_del_flag != 1 AND n.invoice_location_id = ? AND n.invoice_del_flag = 0  " +
"				UNION  " +
"				SELECT tr.transaction_id, CONCAT('RTN',r.returns_id) as invoice_id, r.returns_date as invoice_date, 'RTN' as invoice_number, cl.client_name,  " +
"					(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN '0'  " +
"						WHEN inv.invoice_type_flag = '0' THEN '1'  " +
"					END) AS invoice_type_flag,  " +
"					it.item_name, r.returns_amount as transaction_price, r.returns_quantity as transaction_quantity, inv.invoice_location_id, it.item_id, it.item_client_number, it.item_price, @tot_dur as summary  " +
"					,(CASE  " +
"						WHEN inv.invoice_type_flag = '1' THEN transaction_quantity*-1  " +
"						WHEN inv.invoice_type_flag = '0' THEN transaction_quantity*1  " +
"					END) AS stock " +
"					FROM returns r, item it  " +
"					RIGHT JOIN transaction tr  ON tr.transaction_item_number = it.item_id LEFT OUTER JOIN invoice inv ON inv.invoice_id = tr.transaction_invoice_id  " +
"					LEFT OUTER JOIN client cl ON inv.invoice_client_number = cl.client_id WHERE it.item_del_flag != 1 AND inv.invoice_location_id = ?  " +
"					AND inv.invoice_del_flag = 0  AND r.returns_transaction_id = tr.transaction_id  " +
"					AND r.return_del_flag = 0 ORDER BY item_id, invoice_date, transaction_id  " +
"				) AS retList GROUP BY item_id " +
"	)b, item_limit il WHERE b.stocks < il.item_limit_quantity AND il.item_limit_item_id = b.item_id AND il.item_limit_location_id = ? ORDER BY invoice_date";

//Get user Rights   
public static final String SELECT_USER_RIGHTS = "SELECT * FROM user_type_access u WHERE u.user_type_id = ?";

//Get Accounts Receivable/Payable Rights
public static final String SELECT_ARP_REPORT_RIGHTS = "SELECT * FROM ar_report_access a WHERE a.ar_report_access_user_id = ?";

//Get Reports Rights
public static final String SELECT_OT_REPORT_RIGHTS = "SELECT * FROM ot_report_access a WHERE a.ot_report_access_user_id = ?";

//Insert Convert
public static final String INSERT_INTO_CONVERT = "INSERT INTO converts (convert_number, convert_from_invoice_id, convert_to_invoice_id, convert_date, convert_add_date, convert_add_user) "
            + "VALUES (?,?,?,?,?,?)";

//Check Voucher
public static final String SELECT_CHECK_VOUCHER = " Select i.invoice_id, i.invoice_number, i.invoice_total_price, i.invoice_date, c.collection_number, c.collection_date, c.collection_amount, c.collection_check_date, c.collection_credit_memo_flag " +
"from invoice i INNER JOIN collections c ON i.invoice_id = c.collection_invoice_id WHERE i.invoice_type_flag = 1 AND i.invoice_client_number = ? AND i.invoice_del_flag = 0 AND c.collection_del_flag = 0 " +
"order by collection_number, invoice_number ";

public static final String SELECT_INVOICE_CHECK_VOUCHER = " Select i.invoice_id, i.invoice_number, i.invoice_total_price, i.invoice_date, c.collection_number, c.collection_date, c.collection_amount, c.collection_check_date, c.collection_credit_memo_flag " +
"from invoice i INNER JOIN collections c ON i.invoice_id = c.collection_invoice_id WHERE i.invoice_type_flag = 1 AND i.invoice_client_number = ? AND i.invoice_del_flag = 0 AND c.collection_del_flag = 0 " +
"order by invoice_number, collection_number ";

public static final String SELECT_COLLECTION_CHECK_VOUCHER = " Select * FROM ( SELECT i.invoice_id, i.invoice_number, i.invoice_total_price, i.invoice_date, c.collection_number, c.collection_date, c.collection_amount, c.collection_check_date, c.collection_credit_memo_flag " +
"from invoice i INNER JOIN collections c ON i.invoice_id = c.collection_invoice_id WHERE i.invoice_type_flag = 1 AND i.invoice_client_number = ? AND i.invoice_del_flag = 0 AND c.collection_del_flag = 0 AND c.collection_type_flag = 1 AND c.collection_credit_memo_flag = 0 " +
"order by collection_number, invoice_number) as checks UNION "+
"SELECT i.invoice_id, i.invoice_number, i.invoice_total_price, i.invoice_date, c.collection_number, c.collection_date, c.collection_amount, c.collection_check_date, c.collection_credit_memo_flag " +
"from invoice i INNER JOIN collections c ON i.invoice_id = c.collection_invoice_id WHERE i.invoice_type_flag = 1 AND i.invoice_client_number = ? AND i.invoice_del_flag = 0 AND c.collection_del_flag = 0 AND c.collection_type_flag = 1 AND c.collection_credit_memo_flag = 1 ";

}


