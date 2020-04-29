public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int[] temp = new int[32];
        if (n >= 0){
            while(n!= 0){
                if ((n & 1) == 1){
                    count++;
                }
                n >>= 1;
            }
        }else{
            long n1 = -n;            //这里用long是防止int型数据溢出，-2^32    Python没有这个问题
            n1 = Math.abs(n1);      //在求绝对值才可以得到原始数据的真实绝对值，否则会改变原始数据
            int i = 31;
            while(n1 != 0){
                temp[i] = (int)(n1 & 1);   //强制类型转换   用int数据进行位运算
                n1 >>= 1;
                i--;
            }
            temp[0] = 1;
            for(i = 1;i < 32;i++){
                temp[i] = temp[i] ^ 1;
            }
            temp[31]++;
            for (i = 31;i > 0;i--){
                if (temp[i] == 2){
                    temp[i] = 0;
                    temp[i - 1]++; 
                }
            }
            temp[0] = 1;
            for (i = 0; i < 32;i++){
                if (temp[i] == 1){
                    count++;
                }    
            }
        }
        return count;
    }
}




// 在机器中，整数的存储和运算都是其补码表示的。

// 正数右移：保持为正数，相当于/2。

// 负数右移：保持为负数，移位前是负数，移位后保持是负数，因此移位后最高位设为1。如果一直右移，最终会变成-1，即(-1)>>1是-1。

// 正数左移：不保持为正数，相当于*2。（注意：1左移31时为负数最大值）

// 负数左移：不保持为负数，在左移的过程中会有正有负的情况。所以切记负数左移不会特殊处理符号位。如果一直左移，最终会变成0。







public class Solution {      //因为数字在机器中存储都是补码，所以可以直接对数字进行位运算，判断每一位是否为1
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;      //正数可以一直右移，最后变成0     负数一直右移会陷入死循环  -1  的  补码
        while (flag != 0){
            if ((n & flag) != 0){           //因此，不右移数字，而是左移标志位，看每次与运算结果是否为0
                count++;                    //不为0，就说明对应位是1，计数
            }
            flag <<= 1;
        }
        return count;
    }
}


public class Solution {             //利用 n &= (n - 1); 消除最右边一位的1，直到n变成0
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n &= (n - 1);
        }
        return count;
    }
}

public class Solution {             //调用库函数，得到数字的二进制表达式在转换成字符数组，然后遍历
    public int NumberOf1(int n) {
        int count = 0;
        char[] temp = Integer.toBinaryString(n).toCharArray();
        for (int i = 0;i < temp.length;i++){
            if (temp[i] == '1'){
                count++;
            }
        }
        return count;
    }
}