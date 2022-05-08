package com.mycompany.mavenproject1;
import java.util.*;

/**
 *
 * @author William Douglas
 */

class ProblemsSolutions {
    public static void main(String[] args) {
        //Caso teste da Questão 1
        int[] valuesTest1 = {1, 3, 6, 4, 1, 2};
        System.out.println("Questão 01) Menor Valor: " + new Solution1().solution(valuesTest1));
        
        //Caso teste da Questão 2
        int[] valuesTest2 = {-2, -1, 0, 2, 4, 7, 8, 9, 9};
        System.out.println("Questão 02) Resultado: " + new Solution2().getMultiples(valuesTest2, 8));
        
        //Caso teste da Questão 3
        System.out.println(String.format("Questão 03) Resultado: %.11f", new Solution3().calcPM(1000, 0.999999999999D)));
        
        //Caso teste da Questão 4
        int[] valuesTest3 = {-2, 7,-2, 2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 5, 15, 4, 7, 9, -1, 0, 2, 2, -2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 9, -1, 0,  9, -1, 0, 2, 2, -2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 9, -1, 0, 2, 2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 8, 9, 9};
        int[] valuesTest4 = {-2, -1, 0, 2, 4, 7, 4, 7, 8, 9, 9, 4, 7, 5, 15, 4, 7, 9, -1, 0, 2, 2, -2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 9, -1, 0,  9, -1, 0, 2, 2, -2, -1, 0, 2, 4, 7, 8, 9, 9, 4, 7, 9, -1, 0, 2, 2, -1,  8, 9, 9};
        new Solution4().printIntersection(valuesTest3, valuesTest4);
    }
}

class Solution1 {
    public int solution(int[] inputNumbers){
        int lowestNumber = 0;
        int highestNumber = 0;
        if(inputNumbers != null){
            List<Integer> positiveNumbersFromInput = new ArrayList<>();
            for(int index = 0; index < inputNumbers.length; index++){
                if(inputNumbers[index] > 0){
                    positiveNumbersFromInput.add(inputNumbers[index]);
                    if(highestNumber < inputNumbers[index])
                        highestNumber = inputNumbers[index];
                }
            }
            for(int possibleNumber = 1; possibleNumber <= highestNumber; possibleNumber++){
                if(!positiveNumbersFromInput.contains(possibleNumber)){
                    lowestNumber = possibleNumber;
                    break;
                }
            }
            if(lowestNumber == 0)
                lowestNumber = highestNumber + 1;
        }
        return lowestNumber;
    }
}

class Solution2{
    public String getMultiples(int[] inputNumbers, int resultValue){
        String valuesResult = "[";
        if(inputNumbers != null){
            for(int currentValue = 0; currentValue < inputNumbers.length; currentValue++){
                for(int nextValue = currentValue; nextValue < inputNumbers.length; nextValue++){
                    if(inputNumbers[currentValue] + inputNumbers[nextValue] == resultValue){
                        String valueToBeAdd = "";
                        if(inputNumbers[currentValue] < inputNumbers[nextValue])
                            valueToBeAdd += "[" + inputNumbers[currentValue] + ", " + inputNumbers[nextValue] + "]";
                        else
                            valueToBeAdd += "[" + inputNumbers[nextValue] + ", " + inputNumbers[currentValue] + "]";
                        if(!valuesResult.contains(valueToBeAdd)){
                            if(!valuesResult.equals("["))
                                valuesResult += ", ";
                            valuesResult += valueToBeAdd;
                        }
                    }
                }
            }
        }
        valuesResult += "]";
        return valuesResult;
    }
}

class Solution3 {
    public double calcPM(int exponent, double value){
        double multiplicationValue = value;
        for(int i = 0; i < exponent; i++){
            value *= multiplicationValue;
        }
        return value;
    }
}

class Solution4 {
    public void printIntersection(int[] setA, int[] setB) {
        if (setA != null && setB != null) {
            Arrays.sort(setA);
            Arrays.sort(setB);
            ArrayList<Integer> commonSet = new ArrayList<>();

            //Código Removido
            /*for (int i = 0; i < setA.length; i++) {
                for (int j = 0; j < setB.length; j++) {
                    if (setA[i] == setB[j] && !commonSet.contains(setA[i])) {
                        commonSet.add(setA[i]);
                    }
                }
            }*/
            
            //Código feito
            int[] equalValues = Arrays.stream(setA).filter(x -> Arrays.stream(setB).anyMatch(y -> y == x)).toArray();
            for(int i = 0; i < equalValues.length; i++){
                if(!commonSet.contains(equalValues[i]))
                    commonSet.add(equalValues[i]);
            }
            System.out.print("Questão 04) Resultado: ");
            
            
            for (int k = 0; k < commonSet.size(); k++) {
                System.out.print(commonSet.get(k) + " ");
            }
        }
    }
}