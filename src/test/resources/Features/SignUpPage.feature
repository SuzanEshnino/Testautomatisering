Feature:Test sign up functionality


  Scenario Outline: Check sing up functionality with different usernames and passwords
    Given User has started browser"<Browser>"
    * User Enter email"<Email>"
    * Enter username"<Username>"
    * Enter password
    When Clicks on sign up "button"
    Then The user will get the result"<result>"

    Examples:
    | Browser |  Email       | Username      |result|
    | chrome  |  existEmail  | existUsername |Another user with this username already exists. Maybe it's your evil twin. Spooky.|
    | chrome  |  empty       | normalUser    |Please enter a value  |
    | edge    |  normalEmail |longUserName   |Enter a value less than 100 characters long|
    | chrome  |  NewEmail    |NewUser        | Check your email     |


