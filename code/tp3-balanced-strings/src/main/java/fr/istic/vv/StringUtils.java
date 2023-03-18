package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    public static final char p1 = '(';
    public static final char p2 = '[';
    public static final char p3 = '{';
    public static final char p4 = ')';
    public static final char p5 = ']';
    public static final char p6 = '}';

    private StringUtils() {}

    public static boolean isBalanced(String str) {

        if (str == null){
            return false;
        } else if (str.isEmpty()){
            return true;
        }

        byte[] texte = str.getBytes();
        char courent, destack;
        Stack<Character> stack = new Stack<Character>();

        for (int i=0 ; i<texte.length ; i++){
            courent = (char) texte[i];
            switch (courent) {
                case p1:
                case p2:
                case p3:
                    stack.push(courent);
                    break;
                case p4:
                    if (stack.isEmpty()){
                        return false;
                    }
                    destack = stack.pop();
                    if(destack != '('){
                        return false;
                    }
                    break;
                case p5:
                    if (stack.isEmpty()){
                        return false;
                    }
                    destack = stack.pop();
                    if(destack != '['){
                        return false;
                    }
                    break;
                case p6:
                    if (stack.isEmpty()){
                        return false;
                    }
                    destack = stack.pop();
                    if(destack != '{'){
                        return false;
                    }
                    break;
                default:
                    break;
            } 
        }

        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
