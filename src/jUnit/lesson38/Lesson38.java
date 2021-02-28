package jUnit.lesson38;

// todo JUnit (часть I)

//          Основные правила
// 1. Каждый тестовый сценарий (test case) - отдельный метод. Методы необходимо помечать аноотацией @Test.
// 2. Существует вспомогательные методы с аннотацией @Before, @BeforeClass, @After, @AfterClass, (о них в слудующем уроке)
// 3. Тестовый класс необходимо называть с суффиксом Test (Н: Vector2DTest)
// 4. Тестовые методы желательно должны содержать "should" в названии (Н: sumShouldBePositive)

//          Аннотоция @Test
// Объявляет метод (обязательно public void) тестовым.
    // Аннотация @Test может исп-ть параметры:
        // expected - код в тесте проверяется на генерацию определенного исключения. Т.е. должно выбросить опре-е исключение иначе тест завален
        // timeout - код в тесте должен работать не более указанного времени (иначе тест завален)

//          org.junit.Assert
//          Проверка "ожидание / реальность" expected/actual
//          Методы:
// assertTrue(), assertFalse(), assertEqual(), assertArrayEquals(), assertNotEquals(), assertSame(), assertNotSame()
// fail() - гарантированное падение теста.

public class Lesson38 {
    public static void main(String[] args) {
        // Практикумся

        // Для этого создаем НОВЫЙ проект Maven (в нашем случае создали MavenProject)

    }
}
