package EXC_PHONE_BOOK;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Phone_book {
    public static void main(String[] args) {
        System.out.println(" Выберите, что вы хотите сделать: ");
        System.out.println("1 - Создать новую запись в файле или дописать в файл.");
        System.out.println("2 - Посмотреть какие записи есть.");
        System.out.println("3 - Открыть файл и вывести его на консоль.");
        System.out.println(" Введите цифру для работы сменю: ");
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        if (num == 1) {System.out.println(" Создать новую запись в файле или дописать в файл."); dataProcessing();}
        else if (num == 2) { System.out.println(" Посмотреть какие записи есть."); direct();}
        else if (num == 3) { System.out.println(" Открываем файл и выводим на консоль"); nameFile();}
        else {System.out.println(" Вы так ничего и не выбрали. ");}
    }
//// 1 ________________________________________________________________________________________________________________
    public static void dataProcessing() {
        int[] arr = {1,2,3,4,5,6};
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        shuffleArray(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "");
            if (arr[i]==1) {str1 = surnameProcessing();}
            else if (arr[i]==2) {str2 = nameProcessing();}
            else if (arr[i]==3) {str3 = middleNameProcessing();}
            else if (arr[i]==4) {str4 = b_data();}
            else if (arr[i]==5) {str5 = telephoneProcessing();}
            else if (arr[i]==6) {str6 = manWomenProcessing();}
            else {System.out.println(" Данные введены");}
        }
        String[] dataP = new String[6];
        dataP[0] = str1;
        dataP[1] = str2;
        dataP[2] = str3;
        dataP[3] = str4;
        dataP[4] = str5;
        dataP[5] = str6;
        String fileName = str1+".txt";
        fileProcessing(dataP, fileName);
    }
    static void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i --){
            int index = rnd.nextInt(i+1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i]= a;
        }
    }
////    1.1____________________________________________________________________________________________________________
    public static String surnameProcessing(){         // Модуль обработки входящей фамилии.
        System.out.println(" Введите Вашу фамилию");
        Scanner in = new Scanner(System.in);
        String sN = in.nextLine();
        if(sN.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); surnameProcessing();}
        else {System.out.println(" Вы ввели: " + sN);}
        return sN;
    }
////    1.2____________________________________________________________________________________________________________
    public static String nameProcessing(){          // Модуль обработки входящего имени.
        System.out.println(" Введите Ваше Имя");
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();
        if(N.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); nameProcessing();}
        else {System.out.println(" Вы ввели: " + N);}
        return N;
    }
////    1.3____________________________________________________________________________________________________________
    public static String middleNameProcessing(){        // Модуль обработки входящего отчества.
        System.out.println(" Введите Ваше Отчество");
        Scanner in = new Scanner(System.in);
        String M = in.nextLine();
        if(M.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); middleNameProcessing();}
        else {System.out.println(" Вы ввели: " + M);}
        return M;
    }
////    1.4____________________________________________________________________________________________________________
    public static String b_data() {
        System.out.println(" Пожалуйста, введите ДАТУ вашего рождения !!!");
        System.out.println(" Введите ДЕНЬ вашего рождения !!!");
        String bd;
        bd = birthDateProcessing();
        System.out.println(" Введите МЕСЯЦ вашего рождения !!!");
        String md;
        md = monthOfBirthProcessing();
        System.out.println(" Введите ГОД вашего рождения !!!");
        String yd;
        yd = yearOfBirthProcessing();
        String data = String.join(".", bd, md, yd);
        System.out.println("data" + data);
        return data;
    }
    public static String birthDateProcessing() {
        String bd = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите ДЕНЬ цифрами от 1 до 31");
        String day = scanner.nextLine();
        if (day.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); birthDateProcessing();}
        else {System.out.println(" Вы ввели день: " + day);}
        if (day.matches("\\d") || day.matches("\\d{2}")) {}
        else {System.out.println(" Увы, цифр больше 2-х"); birthDateProcessing();}
        int bDay = Integer.parseInt(day);
        if (bDay >= 1 && bDay <= 31) {bd = String.valueOf(bDay);}
        else {System.out.println(" Число не попадает в диапазон от 1 до 31"); birthDateProcessing();}
        return bd;
    }
    public static String monthOfBirthProcessing() {
        String md = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите МЕСЯЦ цифрами от 1 до 12");
        String month = scanner.nextLine();
        if (month.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); monthOfBirthProcessing();}
        else {System.out.println(" Вы ввели месяц: " + month);}
        if (month.matches("\\d") || month.matches("\\d{2}")) {}
        else {System.out.println(" Увы, цифр больше 2-х"); monthOfBirthProcessing();}
        int bMonth = Integer.parseInt(month);
        if (bMonth >= 1 && bMonth <= 31) {md = String.valueOf(bMonth);System.out.println("строка " + md);}
        else {System.out.println(" Число не попадает в диапазон от 1 до 12"); monthOfBirthProcessing();}
        return md;
    }
    public static String yearOfBirthProcessing() {
        String yd = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите ГОД цифрами от 1900 до 2023");
        String year = scanner.nextLine();
        if (year.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!"); yearOfBirthProcessing();}
        else {System.out.println(" Вы ввели год: " + year);}
        if(year.matches("\\d{4}")) {}
        else {System.out.println(" Увы,"); yearOfBirthProcessing();}
        int bYear = Integer.parseInt(year);
        if (bYear >= 1900 && bYear <= 2023){yd = String.valueOf(bYear);}
        else {System.out.println(" Число не попадает в диапазон от 1900 до 2023"); yearOfBirthProcessing();}
        return yd;
    }
////    1.5____________________________________________________________________________________________________________
    public static String telephoneProcessing() {
        String phone = "";
        String str = "+7";
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите ваш номер телефона после +7: ");
        String tel = scanner.nextLine();
        if (tel.isEmpty()) {System.out.println(" Вы ввели пустую строку!!!");telephoneProcessing();}
        else { phone = str + tel; System.out.println(" Вы ввели номер телефона: " + phone);}
        if (tel.matches("\\d{10}")) {}
        else {System.out.println(" Увы, больше или меньше 10 цифр или не цифры");telephoneProcessing();}
        return phone;
    }
////    1.6____________________________________________________________________________________________________________
    public static String manWomenProcessing(){
        String str6 = "";
        String Men = "m";
        String Women = "f";
        System.out.println(" Введите Ваш пол латинскими буквами: m - мужчина, f - женщина.");
        Scanner in = new Scanner(System.in);
        String strMF = in.nextLine();
        if(strMF.isEmpty()){
            System.out.println(" Вы ввели пустую строку!!!");
            System.out.println(" Попробуйте ещё раз, возможно у Вас получится!!!");
            manWomenProcessing();}
        else if (Men.equals(strMF) ){ str6 = strMF;System.out.println(" Вы ввели: 'm'. Поздравляю Вы Мужчина !!!");}
        else if (Women.equals(strMF)) {str6 = strMF;System.out.println(" Вы ввели: 'f' женщина");}
        else {System.out.println(" В мире около 300 видов гендеров, а умирают только мужчины и женщины. ");
            System.out.println(" Пора уже определиться, кто ты - Мужчина или женщина?");
            manWomenProcessing();}
        return str6;
    }
////___________________________________________________________________________________________________________________
    public static void fileProcessing(String[]Pdata, String fileName) {
        File folder1 = new File("Phone_Book");      // Создание папки (директории).
        folder1.mkdirs();
        String[] data = new String[]{"Surname", "Name", "Middle_Name", "Birth_Date", "Phone_Number", "Gender"};
        String separator = File.separator;
        String path =  folder1 + separator + fileName;
        File file = new File(path);
        String del = ";";
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveToCSVFile(file, del, data, Pdata);
        System.out.println("Готово !!!");
    }
    ////___________________________________________________________________________________________________________________
    public static void saveToCSVFile(File file, String del, String[]d, String[]P){
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))){
            // Позволяет добавлять запись в файл не удаляя предыдущую запись.
            for (int i = 0; i < d.length; i++){
                pw.println(d[i] + del + P[i]);
            }
            pw.append("\n");            // Добавляет пустую строчку после записи.
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //// 2 _____________________________________________________________________________________________________________
    public static void direct() {
        File workFolder = new File("Phone_Book");
        File[] files = workFolder.listFiles();     //  Возвращает массив файлов и подкаталогов, которые находятся в
//                                                      определённом каталоге.
        for (int i = 0; i < files.length; i++) {System.out.println(files[i]);}
    }
//// 3 ________________________________________________________________________________________________________________
    public static void nameFile(){
        System.out.println(" Введите имя файла c расширением для его чтения: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();                           // Получили строку
        readTheFile(fileName);
    }
    public static void readTheFile(String fileName){
        try {
            String separator = File.separator;                              // Для разных систем Win или Linux
            String path =  "Phone_Book" + separator + fileName;
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())   {System.out.println(scanner.nextLine());}
            scanner.close();
        } catch (Exception e){e.printStackTrace();}
    }
////___________________________________________________________________________________________________________________
}