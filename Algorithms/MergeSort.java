public class MergeSort {
    public static void main (String args[])
    {
        int[] array ={8,2,4,7,89,5,6,24,1,19};
    merge_Sort(array); 
    for (int i=0; i<array.length;i++){
        System.out.print(array[i]+" ");
      
        }
    }
    private static void merge_Sort(int[] array){
        int length = array.length;
        if (length<=1)return ;

        int middle=length/2;
        int[] left_array = new int [middle];
        int[] right_array= new int [length-middle];

        int i =0 ;
        int j =0;

        for (;i<length;i++){
            if (i<middle){
                left_array[i]=array[i];
            }
            else{
                right_array[j]=array[i];
                j++;
            }
        }
        merge_Sort(left_array);
        merge_Sort(right_array);
        merge(left_array,right_array,array);


    }
    private static void merge(int[] left_array, int[] right_array, int[] array){
        int left_size=array.length/2;
        int right_size=array.length-left_size;
        int l=0,r=0, i=0;
        
        while(l<left_size && r<right_size){
            if (left_array[l]<right_array[r]){
                array[i]=left_array[l];
                i++;
                l++;
            }
            else{
                array[i]=right_array[r];
                i++;
                r++;
            }
        }
        while(l<left_size){
            array[i]=left_array[l];
            i++;
            l++;
        }
        while(r<right_size){
            array[i]=right_array[r];
            i++;
            r++;
        }
    }
}

