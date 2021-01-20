package lesson2;


public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"2", "3",  "error"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println("Результат: " + sumElementsOfArray(arr));
    }

    private static int sumElementsOfArray(String[]... arr) {
        String[][] arrException = new String[4][4];
        if ( arr.length != arrException.length || arr[0].length != arrException[0].length) {
            MyArraySizeException e = new MyArraySizeException("Неверная длина массива , должна быть Array[4][4]");
            e.printStackTrace();
          }
        int summ = 0;
        for (int i = 0; i <  arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                try {
                   summ+= Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                  e = new MyArrayDataException("Не верный формат данных в ячейке " + "arr" + "[" + i + "]" + "[" + j + "] = " + arr[i][j]);
                  e.printStackTrace();
                };
            }
        };
        return summ;

    };



}
