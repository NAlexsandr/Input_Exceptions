import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.io.File;
public class Main {
    static public String writeToFile = "";         // Запись в файл
    static public String writeToFileTemp = "";     // Временная запись в файл
    static public String surname = "";              // Фамилия
    public static void main(String[] args) throws imputNameException, imputNameNot_A_SymbolException, IOException {
        boolean boolimputName = false;
        while (!boolimputName) {
            try {
                writeToFileTemp = imputName();  // Вводим ФИО
                boolimputName = true;
                //System.out.println(writeToFileTemp);
            } catch (imputNameNot_A_SymbolException | imputNameException e) {
                System.out.println(e.getMessage());
            }
        }
        writeToFile = writeToFile + writeToFileTemp;

        boolean boolimputDateOfBirth = false;
        while (!boolimputDateOfBirth) {
            try {
                writeToFileTemp = imputDateOfBirth(); // Вводим дату рождения
                boolimputDateOfBirth = true;
                //System.out.println(writeToFileTemp);
            } catch (imputDateOfBirthException | imputDateOfBirthNoDigitException e) {
                System.out.println(e.getMessage());
            }
        }
        writeToFile = writeToFile + writeToFileTemp;

        boolean boolimputNumberPhone = false;
        while (!boolimputNumberPhone) {
            try {
                writeToFileTemp = imputNumberPhone(); // Вводим номер телефона
                boolimputNumberPhone = true;
                //System.out.println(writeToFile);
            } catch (imputNumberPhoneException | imputNumberPhoneNoDigitException e) {
                System.out.println(e.getMessage());
            }
        }
        writeToFile = writeToFile + writeToFileTemp;

        boolean boolIimputSex = false;
        while (!boolIimputSex) {
            try {
                writeToFileTemp = imputSex();           // Вводим пол
                boolIimputSex = true;
                //System.out.println(writeToFile);
            } catch (imputSexException e) {
                System.out.println(e.getMessage());
            }
        }
        writeToFile = writeToFile + writeToFileTemp;  // Получаем строку, которую нужно записать в файл
        //System.out.println(writeToFile);
        String path = surname + ".txt";               // Создаем имя файла
        //System.out.println(path);

        File file = new File(path);
        if (!(file.exists())) {     // Если файл не существует, то создаем его и делаем запись
            file.createNewFile();
            try {
                FileWriter writer = new FileWriter(path, true);
                writer.write(writeToFile);
                writer.write("\n");
                writer.close();

            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }
        }
        else {                  // Если файл с таким именем существует, то делаем дополнительную запись
            try {
                boolean recordYes = false;  // Проверяем, есть ли такая запись в файле (чтобы не было дубликатов)
                List<String> list = Files.readAllLines(Path.of(path));
                for (String str : list) {
                    if (str.equals(writeToFile)){recordYes = true;};
                }
                if (!recordYes) {           // Если записи нет, то делаем ее в одноименный файл
                    FileWriter writer = new FileWriter(path, true);
                    writer.write(writeToFile);
                    writer.write("\n");
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
                }
        }
    }
    public static String imputName() throws imputNameException, imputNameNot_A_SymbolException {
        System.out.println("Введите ваше ИМЯ в формате: Фамилия Имя Отчество: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String[] line = name.split("[,\\s]+");
        if (line.length != 3){
            throw new imputNameException();
        }
        String result = "";
        for (String el: line){
            result = result + el;
        }

        char[] charArray = result.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!(Character.isLetter(c))){
                throw new imputNameNot_A_SymbolException();
            }
        }
        surname = line[0];
        return result;
    }

  public static String imputDateOfBirth() throws imputDateOfBirthException, imputDateOfBirthNoDigitException,
                                                 imputNameNot_A_SymbolException {
      System.out.println("Введите вашe дату рождения в формате дд.мм.гггг: ");
      Scanner scanner = new Scanner(System.in);
      String name = scanner.nextLine();
      String[] line = name.split("\\.");

      if (line.length != 3){
          throw new imputDateOfBirthException();
      }
      if (line[0].length() != 2 || line[1].length() != 2 || line[2].length() != 4){
          throw new imputDateOfBirthException();
      }
      for (int j = 0; j < 3; j++) {
          char[] charArray = line[j].toCharArray();
          for (int i = 0; i < charArray.length; i++) {
                  if (!(Character.isDigit(charArray[i]))) {
                  throw new imputNameNot_A_SymbolException();
                  }
          }
      }
      return name;
  }

    public static String imputNumberPhone() throws imputNumberPhoneException, imputNumberPhoneNoDigitException {
        System.out.println("Введите номер своего телефона: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        char[] charArray = name.toCharArray();
        if (charArray.length != 11){
            throw new imputNumberPhoneException();
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!(Character.isDigit(c))){
                throw new imputNumberPhoneNoDigitException();
            }
        }
        return name;
    }

    public static String imputSex() throws imputSexException {
        System.out.println("Введите одну букву f (жен.) или одну букву m (муж.): ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!(name.equals("f")) && !(name.equals("m"))){
            throw new imputSexException();
        };
        return name;
    }
}