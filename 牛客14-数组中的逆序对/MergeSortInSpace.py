def MergeSort(array,temp,left,right):
	if(left < right):
		mid = (left + right) // 2
		MergeSort(array,temp,left,mid)
		MergeSort(array,temp,mid + 1,right)
		Merge(array,temp,left,mid,right)

def Merge(array,temp,left,mid,right):
	global count
	i = left
	j = mid + 1  
	k = left
	while(i <= mid and j <= right):
		if(array[i] <= array[j]):
			temp[k] = array[i]
			i += 1
		else:
			temp[k] = array[j]
			j += 1
		k += 1
	while (i <= mid):
		temp[k] = array[i]
		i += 1
		k += 1
	while(j <= right):
		temp[k] = array[j]
		j += 1
		k += 1
	while(left <= right):
		array[left] = temp[left]
		left += 1

array = [4,3,2,1,4]
temp = [0] * len(array)
MergeSort(array,temp,0,len(array) - 1)
print(temp)
