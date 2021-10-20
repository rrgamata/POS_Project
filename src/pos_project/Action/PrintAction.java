/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_project.Action;

/**
 *
 * @author Cif3r
 */
public class PrintAction {
    
    
      public static String addAfterSpaces(String strWord,int nSpaces){
        for(int i=strWord.length();i<nSpaces;i++){
            strWord+=" ";
        }
        return strWord;
    }
      
      /**
     * Adds white spaces before a text until it reaches the specified maximum character count
     * @param strWord
     * @param nMaxCharCount
     * @return strNewWord
     */
    public static String rightAlignString(String strWord, int nMaxCharCount){
        String strNewWord = "";
        String strSpaces = "";
        if(strWord.length()!=nMaxCharCount){
            for(int i=strWord.length();i<nMaxCharCount;i++){
                strSpaces+=" ";
            }
            strNewWord = strSpaces + strWord;
        }else{
            strNewWord = strWord;
        }
        return strNewWord;
    }
    
    public static String rightAlignStringForHalf(String strWord, int nMaxCharCount){
        String strNewWord = "";
        String strSpaces = "";
        if(strWord.length()!=nMaxCharCount){
            for(int i=strWord.length();i<nMaxCharCount;i++){
                strSpaces+="  ";
            }
            strNewWord = strSpaces + strWord;
        }else{
            strNewWord = strWord;
        }
        return strNewWord;
    }
}
