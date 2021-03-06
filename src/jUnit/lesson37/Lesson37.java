package jUnit.lesson37;
// todo Введение в тестирование

// Test Case ( Тестирование сценарий )
// Артефакт, описывающий совокупность шагов, конкретных условий и параметров, необходимых для проверки реализации
// тестируемой функции или ее части.

// Под тест кейсом понимается структура вида:  Action > Expected Result > Test Result

// Пример: Open page "login" > Login page is opened > Passed


//           Уровни тестирование: ( от простого к самому высшему тестированию)
// Модульное тестирование - проверка работы программы на уровне отдельных модулей (классов, методов). Проверяет сами программисты
// Интеграционное тестирование - проверка совместной работы нескольких модулей.
// Системное тестирование - проверка работы системы в целом. Н: в готовом проекте тестировщик заходит на сайт и нажимает на все кнопкы и т.д.

// Мы будем изучать Модульное тестирование

//              Модульное(unit) тестирование
// Процесс проверки корректности работы отдельных частей исходного кода (чаще всего методов) прогаммы
// путем запуска тестов в искусственной среде.
// Осуществляется разработчиком!

//              Что делает тест?
// 1. Воспроизводит некоторые данные / делает предварительные действия.
// 2. Выполняет тестируемый метод, правильный результат работы которого очевиден автору теста.
// 3. Выполняет сопоставление полученного результата с ожидаемым (assert - это процесс, сопостовление ожидаемого результата).
//    Если "ожидание" и "реальность" совпадают, тест пройден. Если нет - тест завален (чаще всего генерируется специальное
//    исключение - AssertionError - Ошибка сопостовление).

// Test driving development - сначала создаются тесты, потом делается программа, чтобы сразу проходит все тесты

public class Lesson37 {
    public static void main(String[] args) {

    }
}
