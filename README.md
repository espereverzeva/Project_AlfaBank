# Проект по автоматизации тестирования для компании [Альфа-Банк](https://alfabank.ru/)
## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="5%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="5%" title="Jira" src="images/logo/Jira.svg">
</p>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

### Локальный запуск тестов из терминала

```bash
./gradlew clean test
```

### Удалённый запуск осуществляется через Jenkins

При необходимости также можно переопределить параметры запуска

```bash
clean
test
-DremoteUrl=${SELENOID_URL}
-DbaseUrl=${BASE_URL}
-DbrowserSize=${BROWSER_SIZE}
-Dbrowser=${BROWSER_NAME}
-Dbrowser_version="${BROWSER_VERSION}"
```

### Параметры сборки

- <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты.
- <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты.
- <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.
- <code>BASE_URL</code> – Url, по которому будет открываться тестируемое приложение.
- <code>REMOTE_BROWSER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.