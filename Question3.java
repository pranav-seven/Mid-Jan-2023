class Question3 {
    SuperString superStr;
    public static void main(String[] args) {
        Question3 q = new Question3();
        q.doFind();
    }
    void doFind()
    {
        String[] X = {"ceo","alco","caaeio","ceai"};
        String[] Y = {"ce","co","ceo"};
        superStr = new SuperString(X, Y);
        System.out.println("Input: ");
        System.out.print("X: ");
        printArray(X);
        System.out.print("Y: ");
        printArray(Y);
        System.out.println("Output: "+superStr.countSuper());
    }
    void printArray(String[] arr)
    {
        System.out.print("{ ");
        for(int i=0; i<arr.length; i++)
            System.out.print("\""+arr[i]+"\" ");
        System.out.println("}");
    }
}
class SuperString
{
    String[] X, Y;
    int count;
    SuperString()
    {}
    SuperString(String[] X, String[] Y)
    {
        this.X = X;
        this.Y = Y;
    }
    int countSuper()
    {
        outer:
        for(String x:X)
        {
            inner:
            for(String y:Y)
            {
                if(x.length()<y.length())
                    continue outer;
                if(!isSubsequence(x,y))
                    continue outer;
            }
            count++;
        }
        return count;
    }
    boolean isSubsequence(String str1, String str2)
    {
        int l1 = str1.length(), l2 = str2.length();
        int s1Index=0, s2Index=0;
        while(s1Index<l1 && s2Index<l2)
        {
            //chech each chaer of str2 with those of str1
            if(str1.charAt(s1Index)==str2.charAt(s2Index))
                s2Index++;
            s1Index++;
        }
        return(s2Index==l2)?true:false;
    }
    
}