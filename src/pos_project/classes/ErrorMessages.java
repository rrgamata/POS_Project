/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

/**
 *
 * @author Cif3r
 */
public final class ErrorMessages {
    
    public static final String TITLE_SUCCESS ="Success!";
    public static final String TITLE_ERROR ="Error!";
    public static final String TITLE_WARNING ="Warning";
    public static final String TITLE_DELETE ="Delete";
    public static final String TITLE_LOGOFF ="Log-Out";
    public static final String TITLE_EDIT ="Edit";
    public static final String TITLE_INFORMATION ="Message";
    
    //Invoice Messages
    public static final String CONFIRM_ADDED_ITEM = "Successfully Added Invoice. Would you like to Add Another?";
    public static final String CONFIRM_DELETE_INVOICE = "Are you sure you want to void the Invoice?";
    public static final String CONFIRM_EDIT_INVOICE = "Are you sure you want to Edit the Invoice?";
    public static final String CONFIRM_ADD_INVOICE_PO = "Do you want to add Invoice from PO?";
    public static final String ERROR_INVOICE_SEARCH = "Invalid Invoice Number";
    public static final String ERROR_INVOICE_SEARCH_NOT_FOUND = "Please input a valid Invoice Number";
    
    //Collection
    public static final String CONFIRM_ADDED_Collection = "Successfully Added Collection. Would you like to Add Another?";
    public static final String CONFIRM_DELETE_COLLECTION = "Are you sure you want to cancel the Check?";
    public static final String CONFIRM_EDIT_COLLECTION = "Are you sure you want to Edit the Payment Details?";
    public static final String CONFIRM_CLEAR_COLLECTION = "Are you sure you want to set the Check as cleared?";
    
    //Client Messages
    public static final String ERROR_CLIENT_NAME = "Name Not Entered \n";
    public static final String ERROR_CLIENT_ADDRESS = "Address Not Entered \n";
    public static final String ERROR_CLIENT_PHONE = "Phone Not Entered \n";
    public static final String ERROR_NO_SELECTED_CLIENT = "No Client Selected ";
    public static final String CONFIRM_ADDED_CLIENT = "Successfully Added a Client. Would you like to Add Another?";
    public static final String CONFIRM_EDITED_CLIENT = "Successfully Edited Client.";
    public static final String CONFIRM_DELETE_CLIENT = "Are you sure you want to Delete Client?";
    
    //ITEM MESSAGES
    public static final String ERROR_ITEM_NAME = "Name Not Entered \n";
    public static final String ERROR_ITEM_MANUFACTURER = "Manufacturer Empty \n";
    public static final String ERROR_ITEM_QUANTITY = "Quantity Not Entered or is Invalid \n";
    public static final String ERROR_ITEM_PRICE = "Price Not Etered or is Invalid \n";
    public static final String ERROR_NO_SELECTED_ITEM = "No Item Selected ";
    public static final String CONFIRM_EDITED_ITEM = "Successfully Edited Item.";
    public static final String CONFIRM_DELETE_ITEM = "Are you sure you want to Delete Item?";
    
    
    //TRANSACTION MESSAGE
    public static final String ERROR_TRANSACTION_ITEM = "No Item Selected \n";
    public static final String ERROR_TRANSACTION_CUSTOMER = "No Customer Selected \n";
    public static final String ERROR_TRANSACTION_NUMBER = "Invoice Number Empty \n";
    public static final String ERROR_TRANSACTION_NOT_FOUND = "Invoice Number Not Found \n";
    public static final String ERROR_COLLECTION_TRANSACTION_INVALID = "Invoice Not Entered \n";
    public static final String ERROR_COLLECTION_CHECK_INVALID = "Check Number Not Entered \n";
    public static final String ERROR_TRANSACTION_QUANTITY = "Quantity Empty/Invalid \n";
    public static final String ERROR_TRANSACTION_QUANTITY_OFB = "Quantity is greater than Stock \n";
    public static final String ERROR_TRANSACTION_PRICE = "Price Empty/Invalid \n";
    
   //TIME ERROR 
    public static final String ERROR_TIME_PARAMETERS_ = "Invalid Time Parameters.";
    
    
    //USER ERROR
    public static final String ERROR_USER_FULL_NAME = "Full Name Not Entered";
    public static final String ERROR_USER_NAME_FOUND = "Username Exists";
    public static final String ERROR_USER_NAME_NOT_FOUND = "Username Not Found";
    public static final String ERROR_USER_NAME = "Username Not Entered";
    public static final String ERROR_PASSWORD_NO_MATCH = "Password Did Not Match";
    public static final String ERROR_NO_SELECTED_USER = "No User Selected ";
    public static final String ERROR_PASSWORD = "Password Not Entered";
    public static final String CONFIRM_DELETE_USER = "Are you sure you want to Delete User?";
    public static final String CONFIRM_LOGOFF_USER = "Are you sure you want to Log-Off?";
    public static final String ERROR_AUTHORIZATION = "Unauthorized Access: \n Please Log in as an Administrator ";
    
    
    
    //Location
    public static final String ERROR_NO_SELECTED_LOCATION = "No Location Selected ";
    public static final String CONFIRM_ADDED_LOCATION = "Successfully Added a Location. Would you like to Add Another?";
    public static final String CONFIRM_EDITED_LOCATION = "Successfully Edited Location.";
    public static final String CONFIRM_DELETE_LOCATION = "Are you sure you want to Delete Location?";
    
    //Warning labels
    public static final String WARNING_ITEM_LIMIT = "Can not Add. Item Limit Reached";
    public static final String WARNING_CREDIT_LIMIT = "Credit Limit of ";
    public static final String WARNING_CREDIT_LIMIT_MESSAGE = " has been reached would you like to continue?";
     
    
    //PO
    public static final String CONFIRM_DELETE_PO = "Are you sure you want to void the PO?";
    
    //Return Messages
    public static final String CONFIRM_CREATE_RETURN_COLLECTION = "Would you like to create a collection for this return?";
    public static final String WARNING_INVOICE_FULLY_PAID = "Invoice is already fully paid ";
    public static final String WARNING_INVOICE_BALANCE = "WARNING! Projected balance is ";
    public static final String WARNING_ERROR_COLLECTION = "This process would likely create an error and will now abort ";
    public static final String WARNING_ASSIGN_COLLECTION = "would you like to assign this collection to another invoice?";
    public static final String CONFIRM_DELETE_RETURN = "Are you sure you want to void the Return?";
    
    //Check Voucher
    public static final String WARNING_CHECK_VOUCHER_LIMIT = "Check Voucher Limit Reached. \\n Please Clear Table.";
    
}     
