import java.util.*;
import java.lang.*;
public class Openclosepatternmatch {
    public Openclosepatternmatch() {
        super();
    }

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solution("<"));
        long a=10L,b=11L;
        
    }
    public static String solution(String angles) {
            // Type your solution here
            if(angles.isEmpty()){
                return "";
            }
            
            Stack<String> patterns=new Stack<String>();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<angles.length();i++){
                System.out.println(angles.charAt(i));
                if(angles.charAt(i)=='<'){
                    patterns.push("<");
                    sb.append("<");
                }
                else if(angles.charAt(i)=='>'){
                    if(patterns.peek()!=null){
                        patterns.pop();
                        sb.append(">");
                    }
                    else{
                        sb.append("<>");
                    }
                }
            }
            while(patterns!=null&&patterns.size()!=0){
                if(patterns.peek()!=null){
                patterns.pop();
                sb.append(">");}
            }
            return sb.toString();
        }
}
