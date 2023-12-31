# Экзаменационная работа. Часть 2

<img src="https://i.imgur.com/1kJARPo.png" alt="Logos"/>

## Разработать проект автотестов с использованием Cucumber, Maven, Rest Assured, Allure

За основу берётся следующее задание.

**Написать фильтрацию запросов и ответов для API, для того, чтобы всё отображалось в отчётности Allure для задач 1 и 2. Для понимания логики следует обратиться во встроенный класс AllureRestAssured.**

### Задача 1
На сайте есть документация по АPI по сериалу Рик и Морти https://rickandmortyapi.com/documentation/#episode-schema.

Найти информацию по персонажу Морти Смит. 
Выбрать из ответа последний эпизод, где появлялся Морти. 
Получить из списка последнего эпизода последнего персонажа. 
Получить данные по местонахождению и расе этого персонажа. 
Проверить, этот персонаж той же расы и находится там же где и Морти?


### Задача 2

На сайте есть документация по АPI https://reqres.in/. Создать в проекте файл с расширением .json
```
{ "name": "Potato" }
```
Создать тест запрос для создания пользователя (CREATE). Body в запрос передать из ранее созданного файла, поменяв name и добавив поле job
`{ "name": "Tomato", "job": "Eat maket" }`
Проверить, что получили ответ 200. Свериться, что полученный response имеет валидные данные по значениям key и value.
```
{ 
"name": "Tomato", 
"job": "Eat maket", 
"id": "325", 
"createdAt": "2021-08-03T10:22:44.071Z" 
}
```

## Экзаменационное задание

Поменять среду тестирования в проекте на Cucumber. Проверить, что код соответствует требованиям:
> - Не должно быть System.out.println
> - Все проверки должны быть проведены через assertions
> - В импортах не должно быть ничего не используемого
> - Все входные параметры в тесте должны использоваться только из application.properties
> - Тест должен работать из консоли
> - Должен строиться Allure отчет
> - В проекте, в git должны быть только: папка src с наполнением, .gitignore, pom.xml, README.md
> - Проект должен быть отдельным

## Как работать с проектом

Для запуска теста ввести в консоль `mvn clean test`

Для создания и открытия отчёта ввести в консоль `mvn allure:serve`

Для выхода из процесса зажать `Ctr+С` и ввести в консоль `Y`

Для запуска только первой задачи добавить в классе TestRunner в @CucumberOptions параметр `tags = "@API1"`

Для запуска только второй задачи добавить в классе TestRunner в @CucumberOptions параметр `tags = "@API2"`
