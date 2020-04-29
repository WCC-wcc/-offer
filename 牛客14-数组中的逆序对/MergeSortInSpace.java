public void MergeSort(int[] array,int[] temp,int left,int right){
	if (left < right){
		int mid = (left + right) / 2;
		MergeSort(array,temp,left,mid);
		MergeSort(array,temp,mid + 1,right);
		Merge(array,temp,left,mid,right);
	}
}
public void Merge(int[] array,int[] temp,int left,int mid,int right){
	int i = left;
	int j = mid + 1;
	int k = left;
	while(i <= mid && j <= right){
		if (array[i] <= array[j]){
			temp[k++] = array[i++];
		}else{
			temp[k++] = array[j++];
		}
	}
	while(i <= mid){
		temp[k++] = array[i++];
	}
	while(j <= right){
		temp[k++] = array[j++];
	}
	while(left <= right){
		array[left] = temp[left];
		left++;
	}
}

