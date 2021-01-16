package lesson5;

public class Main {
    //1) Создают одномерный длинный массив, например:
    //static final int size = 10000000;
    //static final int h = size / 2;
    //float[] arr = new float[size];
    //2) Заполняют этот массив единицами;
    //3) Засекают время выполнения: long a = System.currentTimeMillis();
    //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //5) Проверяется время окончания метода System.currentTimeMillis();
    //6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
    //Отличие первого метода от второго:
    //Первый просто бежит по массиву и вычисляет значения.
    //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    //
    //Пример деления одного массива на два:
    //System.arraycopy(arr, 0, a1, 0, h);
    //System.arraycopy(arr, h, a2, 0, h);
    //
    //Пример обратной склейки:
    //System.arraycopy(a1, 0, arr, 0, h);
    //System.arraycopy(a2, 0, arr, h, h);
    //
    //Примечание:
    //System.arraycopy() копирует данные из одного массива в другой:
    //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
    //По замерам времени:
    //Для первого метода надо считать время только на цикл расчета:
    //for (int i = 0; i < size; i++) {
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //}
    //Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        fillArray(arr);
        long a = System.currentTimeMillis();
        arrayEstimate(arr, a);
        fillArray(arr);
        arrayThreadEstimate(arr);

    }

    private static void fillArray(float[] arr) {
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
    }

    private static void arrayEstimate(float[] arr, long a) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }


        System.out.println("Текущее Время в конце цикла " + System.currentTimeMillis());
        System.out.println("Время однопоточного вычисления " + (System.currentTimeMillis() - a));
    }

    private static void arrayThreadEstimate(float[] arr) {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        long b = System.currentTimeMillis();
        new Thread(()->threadEstimateArr1(arr, arr1, b)).start();
        new Thread(()->threadEstimateArr2(arr, arr2, b)).start();
    }

    private static void threadEstimateArr1(float[] arr, float[] arr1, long a) {
        long currentTimeTODivideArray = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.out.println("Время разбивки 1 половины массива " + (System.currentTimeMillis() - currentTimeTODivideArray));
        long currentTimeToEstimateArray = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время расчета 1 половины массива " + (System.currentTimeMillis() - currentTimeToEstimateArray));
        long currentTimeToCopyArray = System.currentTimeMillis();
        System.arraycopy(arr1,0, arr, 0, h);
        System.out.println("Время склейки 1 половины массива " + (System.currentTimeMillis() - currentTimeToCopyArray));
        System.out.println("Время выполнения первого потока " + (System.currentTimeMillis() - a));
        System.out.println("Текущее Время в конце 1 потока " + System.currentTimeMillis());
    }

    private static void threadEstimateArr2(float[] arr, float[] arr2, long a) {
        long currentTimeTODivideArray = System.currentTimeMillis();
        System.arraycopy(arr, h, arr2, 0, h);
        System.out.println("Время разбивки 2 половины массива " + (System.currentTimeMillis() - currentTimeTODivideArray));
        long currentTimeToEstimateArray = System.currentTimeMillis();
        for (int i = h; i < arr.length; i++) {
            arr2[i - h] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println("Время расчета 2 половины массива " + (System.currentTimeMillis() - currentTimeToEstimateArray));
        long currentTimeToCopyArray = System.currentTimeMillis();
        System.arraycopy(arr2, 0,arr, h, h);
        System.out.println("Время склейки 2 половины массива " + (System.currentTimeMillis() - currentTimeToCopyArray));
        System.out.println("Время выполнения второго потока " + (System.currentTimeMillis() - a));
        System.out.println("Время выполнения многопоточного вычисления " + (System.currentTimeMillis() - a));
        System.out.println("Текущее в конце Время 2 потока " + System.currentTimeMillis());
    }

}
