Feature: Добавление товара в избранное

Background:
  Given Пользователь авторизован на сайте


  Scenario:
    When пользователь кликает в избранное товар
    Then пользователь видит товар в избранном
