// char            单个字符                                                                ''
// string          字符串常量   值不可变   速度慢                 string a = '123'           ""
// stringBuffer    字符串变量   值可变     速度中   多线程安全    stringBuffer a = new stringBuffer().append('123')  
// stringBuilder   字符串变量   值可变     速度快   多线程不安全  stringBuilder a = new stringBuilder().append('123') 

// s = '123'
// string --> stringBuffer   :   stringBuffer a = new stringBuffer().append('123')   
// 							  stringBuffer a = new stringBuffer(s)

// stringBuffer --> string   :   stringBuffer.toString() 


// 替换字符方法  StringBuffer 对象.setCharAt(int index, char ch);   String 对象.replace(string a,string b)
// 删除字符方法  StringBuffer 对象.deleteCharAt(int index);
// 设置长度方法  StringBuffer 对象.setLength(int newLength);

public class Solution1 {
    public String replaceSpace(StringBuffer str) {
        int length_str = str.length();
        int count_space = 0;
        for (int i = 0; i < length_str; i++){
            if(str.charAt(i) == ' '){
                count_space++;
            }
        }
        int length_new = length_str + 2 * count_space;
        str.setLength(length_new);
        int point_old_str = length_str - 1;
        int point_new_str = length_new - 1;
        while(point_old_str != point_new_str){
            if (str.charAt(point_old_str) == ' '){
                str.setCharAt(point_new_str,'0');
                str.setCharAt(point_new_str - 1,'2');
                str.setCharAt(point_new_str - 2,'%');
                point_new_str -= 3;
            }else{
                str.setCharAt(point_new_str,str.charAt(point_old_str));
                point_new_str -= 1;
            }
            point_old_str -= 1;
        }
        return str.toString();
    }
}

public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replace(" ","%20");                   //注意里面是两个双引号，代表字符序列，而非单引号，代表单个字符
    }
}

public class Solution3 {
    public String replaceSpace(StringBuffer str) {
    	String s = "";
        for (int i = 0; i < str.length();i++){
            if (str.charAt(i) == ' '){
                s += "%20";
            }else{
                s += str.charAt(i);
            }
        }
        return s;
    }
}