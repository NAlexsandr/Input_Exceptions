public class InputExceptions {
}

class imputNameException extends Exception {
    public imputNameException() {
        super("Ошибка: Вы ввели имя в неправильном формате!");
    }
}
class imputNameNot_A_SymbolException extends Exception {
    public imputNameNot_A_SymbolException() {
        super("Ошибка: Введен символ - не буква");
    }
}
class imputDateOfBirthException extends Exception {
    public imputDateOfBirthException() {
        super("Ошибка: Введен неправильный формат дд.мм.гггг");
    }
}
class imputDateOfBirthNoDigitException extends Exception {
    public imputDateOfBirthNoDigitException() {
        super("Ошибка: Все введенные символы должны быть цифрами дд.мм.гггг");
    }
}
class imputNumberPhoneException extends Exception {
    public imputNumberPhoneException() {
        super("Ошибка ввода номера телефона: Введите 11 чисел");
    }
}
class imputNumberPhoneNoDigitException extends Exception {
    public imputNumberPhoneNoDigitException() {
        super("Ошибка: Все введенные символы должны быть цифрами");
    }
}
class imputSexException extends Exception {
    public imputSexException() {
        super("Ошибка: Введите одну букву f (жен.) или одну букву m (муж.)");
    }
}