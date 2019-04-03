package com.company.project.compute;

public class ReplaceSpace {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replace(String str){
       if(str==null){
           return null;
       }
       StringBuilder newStr = new StringBuilder();
       for(int i=0;i<str.length();i++){
           if(str.charAt(i) == ' '){
               newStr.append("%20");
           }else{
               newStr.append(str.charAt(i));
           }
       }
       return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace("We Are Happy"));
    }
}
