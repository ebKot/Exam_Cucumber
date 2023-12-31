#language: ru

@API1
Функция: Изучение API с Rest Assured на примере сервиса с API по сериалу Рик и Морти https://rickandmortyapi.com/

  Сценарий: Сравнение расы и локации двух персонажей
    Когда Отправляем GET-запрос для поиска информации по персонажу с id "2"
    Затем Выбираем из ответа последний эпизод, где появлялся первый персонаж
    И Получаем из списка последнего эпизода последнего персонажа
    И Получаем данные по местонахождению и расе второго персонажа
    Тогда Проверяем то, что раса второго персонажа такая же, как у первого
    И Проверяем то, что персонажи находятся в одной локации