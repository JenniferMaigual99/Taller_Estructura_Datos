package ExpresionMatematica;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;

public class Verificador {

    // Ignorar esta seleccion
    private Pattern pattern = Pattern.compile("([\\(\\[]?\\s*\\d+(?:\\s*[+-\\/*]\\s*\\d+)+\\s*[\\)\\]]?)");
    private Pattern patternTerm = Pattern.compile("[+\\-*\\/]");
    // ----------------------------------------------------------------

    private String expresionComplete;

    //Verificador caracteres especiales "() []"
    private Stack<Character> expresionSpecial;

    //Completemento para caracteres especiales
    private HashMap<Character, Character> especialMap = new HashMap<>();

    public Verificador() {
        this.expresionSpecial = new Stack<>();
        especialMap.put('(', ')');
        especialMap.put('[', ']');
    }

    public Verificador(String expresion) {
        this.expresionSpecial = new Stack<>();
        especialMap.put('(', ')');
        especialMap.put('[', ']');
        this.expresionComplete = expresion;
    }

    // Metodos privados o de clase

    private boolean isAbierto(char c) {
        return especialMap.containsKey(c);
    }

    private boolean isCerrado(char c) {
        return especialMap.containsValue(c);
    }

    private boolean cerradoCorrecto(char cOpen, char cClose) { 
        return especialMap.get(cOpen) == cClose;
    }

    // Metodos publicos

    public String getExpresion() {
        return this.expresionComplete;
    }

    public void setExpresion(String expression) {
        expresionComplete = expression;
    }

    public boolean verificar() {
        expresionSpecial.clear();
        for (Character character : expresionComplete.toCharArray()) { 
            if (isAbierto(character)) {
                expresionSpecial.push(character); // ["("]
            } else if (isCerrado(character)) {
                if (expresionSpecial.isEmpty() || !cerradoCorrecto(expresionSpecial.pop(), character)) {
                    return false;
                }
            }
        }
        return expresionSpecial.isEmpty();
    }

    // Otra cosa que no nos pidieron y nadie nos preguntó

    private float eval(String exp, float n1, float n2) {
        switch (exp) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            default:
                return n1 / n2;
        }
    }

    private String replaceResult(String text) {
        StringBuilder sb = new StringBuilder();
        Matcher m = pattern.matcher(text);
        boolean found = false;
        while (m.find()) {
            found = true;
            String repString = m.group(1);
            String exp = repString.replace("(", "")
                    .replace(")", "")
                    .replace("[", "").replace("]", "")
                    .replace(" ", "");
            Matcher mt = patternTerm.matcher(exp);
            if (mt.find()) {
                String value = mt.group();

                String[] nums = exp.split(patternTerm.pattern());
                float result = eval(value, Float.parseFloat(nums[0]), Float.parseFloat(nums[1]));
                m.appendReplacement(sb, String.valueOf(result));
            }
        }
        m.appendTail(sb);
        String resultText = sb.toString();
        if (found && !resultText.equals(text)){
            return replaceResult(sb.toString());
        }else {
            return sb.toString();
        }
        
    }

    public String result() {
        if (verificar()) {
            return replaceResult(expresionComplete);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "{" +
                " expresion='" + getExpresion() + "'" +
                "}";
    }

}
