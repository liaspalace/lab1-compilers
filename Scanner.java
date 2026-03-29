import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Scanner
{
    public static void main(String[] args){
        String string = "position = initial + rate * 60";
        List<String> tokens = new ArrayList<>();
        Map<String, Integer> tabela = new HashMap<>();
        int contador = 1;
        
        Pattern p = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*|\\d+|[=+\\-*]");
        Matcher m = p.matcher(string);
        
        while (m.find()){
            String lexema = m.group();
            
            if (lexema.matches("[a-zA-Z_][a-zA-Z0-9_]*")){
                if (!tabela.containsKey(lexema)){
                    tabela.put(lexema,contador++);
                }
                tokens.add("(id," + tabela.get(lexema) + ")");
            } else if (lexema.matches("\\d+")){
                tokens.add("(" + lexema + ")");
            } else{
                tokens.add("(" + lexema + ")");
            }
        }
        
        for (String token : tokens){
             System.out.print(token + " ");
        }
    }
}
