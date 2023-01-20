//Assuming two subarrays do not overlap
class Question2 {
    EqualSubarray eq;
    public static void main(String[] args) {
        Question2 q = new Question2();
        q.doSplit();
    }
    void doSplit()
    {
        int[] arr = {1,2,3,1,5};
        eq = new EqualSubarray(arr);
        System.out.println("Input: ");
        printArray(arr);
	    eq.splitArray(1);
	    System.out.println();
        printResult();
    }
    void printArray(int[] arr)
    {
        System.out.print("{ ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.print("}");
    }
    void printResult()
    {
        System.out.print("Output: ");
        if(eq.presence)
        {
            System.out.print("The two arrays are ");
            printArray(eq.leftArr);
            System.out.print(" & ");
            printArray(eq.rightArr);
            System.out.println();
        }
        else
            System.out.println("Equal sum subarrays don't exist");
    }
}
class EqualSubarray
{
    int[] array;
    int len;     //array length
    int[] leftArr, rightArr;
    boolean presence;  //boolean variable to check existence of subarrays
    EqualSubarray()
    {}
    EqualSubarray(int[] arr)
    {
        array = arr;
        len = array.length;
        presence = true;
    }
    void splitArray(int mid)
    {
        if(mid==array.length)
        {
            presence = false;
            return;
        }
        int left = splitSum(0, mid);
        int right = splitSum(mid, array.length);
        if(left == right)
        {
            leftArr = new int[mid];
            rightArr = new int[array.length-mid];
            for(int i=0; i<leftArr.length; i++)
                leftArr[i] = array[i];
            for(int j=0; j<rightArr.length; j++)
                rightArr[j] = array[mid+j];
        }
        else
            splitArray(mid+1);
    }
    int splitSum(int l, int r)
    {
        int sum = 0;
        for(int i=l; i<r; i++)
            sum+=array[i];
        return sum;
    }
}