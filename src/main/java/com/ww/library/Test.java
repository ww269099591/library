package com.ww.library;


public class Test {
/*     public static void main(String args[]){
         List<List<String>>  father=new ArrayList<>();
         List<String> children=new ArrayList<>();
         children.add("children1");
         father.add(children);
         children.add("children2");

     }*/



    public static void main(String args[]){
       char[] str={'a','b','c','d','a','b','c'};
       int[] next=new int[8];
        cal_next(str,next);
    }

    static void cal_next(char[] str, int[] next )
    {
        int len = str.length;
        next[0]=-1;
        int k = -1;
        int j = 0;
        while (j < len - 1)
        {
            if (k == -1 || str[j] == str[k])
            {
                ++k;
                ++j;
                next[j]=k;
               ;//表示第j个字符有k个匹配（“最大长度值” 整体向右移动一位，然后初始值赋为-1）
            }
            else
                k = next[k];//往前回溯
        }
    }

}
