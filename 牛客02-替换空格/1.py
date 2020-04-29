# -*- coding:utf-8 -*-

#  %20替换空格  是为了对url地址进行处理，使得算法能正确读取url参数  替换方法是用 % + 对应的字符的ASCII码的十六进制表示

#方法1是用新字符串代替原始字符串，直接调用python内置的replace()函数
class Solution1:
    # s 源字符串
    def replaceSpace(self, s):
        # write code here
        return s.replace(' ','%20')               #s.replace(a,b)   将字符串s中的a字符用b字符替换

#方法2也是用新字符串代替原始字符串，挨个读取字符并做处理
class Solution2:
    # s 源字符串
    def replaceSpace(self, s):
        # write code here
        str = ''
        for item in s:
            if item == ' ':
                str += '%20'
            else :
                str += item
        return str

#方法3是用在原始字符串上进行操作，假定原始字符串内存空间足够大
# -*- coding:utf-8 -*-
class Solution3:
    # s 源字符串
    def replaceSpace(self, s):
        # write code here
        length_s = len(s)
        count_space = s.count(' ')
        add_space = count_space * 2
        length_all = length_s + add_space
        s = list(s)										#转换成列表
        s += ' ' * add_space 							#添加列表内存
        point_old_s = length_s - 1
        point_new_s = length_all - 1
        while (point_new_s != point_old_s):
            if s[point_old_s] == ' ':
                s[point_new_s] = '0'
                s[point_new_s - 1] = '2'
                s[point_new_s - 2] = '%'
                point_new_s -= 3
            else:
                s[point_new_s] = s[point_old_s]
                point_new_s -= 1
            point_old_s -= 1
        return ''.join(s)       				#list转换成str
                



s = 'I love China'
Solution1 = Solution1()                 		#python  函数self的使用，对类内方法添加了self参数，
												#使用时，先实例化一个类，再调用参数，就不用添加self参数
print(Solution1.replaceSpace(s))
print(Solution2.replaceSpace(s,s))
print(Solution3.replaceSpace(s,s))