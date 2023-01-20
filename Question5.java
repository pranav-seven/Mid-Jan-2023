class Question5 {
    public static void main(String[] args) {
        String input = "Hello World Please";
        String ref = "Help";
        CharacterCount counter = new CharacterCount(input);
        System.out.println("inputString: "+input);
        System.out.println("refString: "+ref);
        String refCopy = ref.toUpperCase();
        int[] count = counter.findCount();
        for(int i=0; i<ref.length(); i++)
        {
            char current = refCopy.charAt(i);
            System.out.print(ref.charAt(i)+":"+(current!=' '?count[current-'A']:count[26])+" ");
        }
    }
}
class CharacterCount
{
    private int[] count;
    private String inputString;
    private int inputLength;
    CharacterCount()
    {}
    CharacterCount(String input)
    {
        inputString = input.toUpperCase();
        inputLength = inputString.length();
        count = new int[27];    //count table for each letter
    }
    int[] findCount()
    {
        for(int i=0; i<inputLength; i++)
        {
            char current = inputString.charAt(i);
            if(current == ' ')
                count[26]++;
            else
                count[current-'A']++;    //each letter is mapped from 0 to 25
        }
        return count;
    }
}
