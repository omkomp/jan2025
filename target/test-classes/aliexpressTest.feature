Feature: Test of adds fav in aliexpress


  Background:
    Given get authorisation on aliexpress

  Scenario:
    When adds favorites to goods
    Then check added favorites