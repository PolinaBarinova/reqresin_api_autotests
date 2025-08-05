<a href="https://reqres.in/"> <img src="media/logo.png" width="800" height="200"> 
<h2 >Проект по автоматизации API тестов для компании <a href="https://reqres.in/ "> REQRES </a></h2> 

## Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins) и из терминала
- Allure-отчет
- Интеграция с Allure TestOps
- Интеграция с Jira
- Уведомление в Telegram о результатах прогона тестов


<a id="tools"></a>
## Технологии и инструменты:
<p align="center">
  <img width="8%" title="Java" src="media/java-svgrepo-com.svg">
  <img width="8%" title="IntelliJ IDEA" src="media/intellij-idea-svgrepo-com.svg">
  <img width="8%" title="GitHub" src="media/github-badge-svgrepo-com.svg">
  <img width="8%" title="JUnit 5" src="media/Junit5.svg">
  <img width="8%" title="Gradle" src="media/gradle-svgrepo-com.svg">
  <img width="8%" title="Rest Assured" src="media/rest-assured.jpg">
  <img width="8%" title="Jira" src="media/Jira.svg">
  <img width="8%" title="Allure Report" src="media/Allure.svg">
  <img width="8%" title="Jenkins" src="media/Jenkins.svg">
  <img width="8%" title="Telegram" src="media/Telegram.svg">
</p>

<a id="cases"></a>
## Реализованные проверки:
- Получение списка пользователей
- Создание пользователя
- Обновление информации о пользователе
- Замена чаcти информации o пользователе
- Получение ошибки при запросе несуществующего пользователя
- Удаление пользователя

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/reqresin_api_autotest/)


<p align="center">  
<img src="media/JenkinsBuild.jpg" alt="Jenkins" width="950"/></a>  
</p>


## Параметры сборки в Jenkins:

При запуске сборки в **Jenkins** можно использовать следующие параметры:

- `TASK` — выбор тестов для запуска, **по умолчанию** `reqresin_test`


## Команда для запуска из терминала
Локальный запуск
```bash
gradle clean reqresin_test
```
Удаленный запуск через Jenkins:
```bash  
clean ${TASK}
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure [Report](https://jenkins.autotests.cloud/job/reqresin_api_autotest/3/allure/)	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReport.jpg" width="850">  
</p>  

____
## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>


