//Checks addition, subtraction, multiplication and division
//checks only expressions enclosed in parenthesis
class Question1 {
    ExpressionChecker expCheck;
    public static void main(String[] args) {
        Question1 answer = new Question1();
        answer.doCheck("(a+b)(a*b)");
        System.out.println();
        answer.doCheck("(ab)(ab+)");
        System.out.println();
        answer.doCheck("((a+b)");
        System.out.println();
    }
    void doCheck(String expression)
    {
        System.out.println("Input: "+expression);
        expCheck = new ExpressionChecker(expression);
        boolean isValid = expCheck.check();
        System.out.println("Output: "+(isValid?"Valid":"Invalid"));
    }
}

class ExpressionChecker
{
    String expression;
    char[] stack;
    int top;
    boolean isValid;
    ExpressionChecker()
    {}
    ExpressionChecker(String expression)
    {
        this.expression = expression;
        stack = new char[expression.length()];
        isValid = true;
        top = -1;
    }
    boolean check()
    {
        boolean needChar=false;
        int len = expression.length();
        for(int i=0; i<len; i++)
        {
            char c = expression.charAt(i);
            if(needChar && !Character.isLetter(c)){
                isValid = false;
                break;
            }
            else if(c=='(' || Character.isLetter(c))
            {
                push(c);
                needChar=false;
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/')
            {
                if(Character.isLetter(stack[top]))
                {
                    needChar = true;
                    push(c);
                }
                else
                    return false;
            }
            else if(c==')')
            {
                try{
                    popTillParen();
                }catch(ArrayIndexOutOfBoundsException ex)
                {
                    return false;
                }
            }
            else
            {
                isValid = false;
                break;
            }
            
        }
        if(top>=0)
            isValid = false;
        return isValid;
    }
    void push(char c)
    {
        top++;
        stack[top] = c;
    }
    void popTillParen()
    {
        while(stack[top]!='(')
            top--;
        top--;
    }
}
