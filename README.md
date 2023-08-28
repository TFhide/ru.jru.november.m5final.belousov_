## [REST API](http://localhost:8080/doc)

## Концепция:

- Spring Modulith
    - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
    - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
    - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

- Есть 2 общие таблицы, на которых не fk
    - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
    - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем
      проверять

## Аналоги

- https://java-source.net/open-source/issue-trackers

## Тестирование

- https://habr.com/ru/articles/259055/

Список выполненных задач:
1) Удалить социальные сети: vk, yandex
2) Вынести чувствительную информацию в переменные окружения
3) Адаптировать тестовые данные для H2
4) Сделать рефакторинг метода com.javarush.jira.bugtracking.attachment.FileUtil#upload
5) Написать тесты для всех публичных методов контроллера ProfileRestController
6) Добавить новый функционал: добавления тегов к задаче (REST API + реализация на сервисе)
7) Написать Dockerfile для основного сервера
8) Написать docker-compose файл для запуска контейнера сервера вместе с БД и nginx
9) Добавить подсчет времени сколько задача находилась в работе и тестировании. Написать 2 метода на уровне сервиса,
