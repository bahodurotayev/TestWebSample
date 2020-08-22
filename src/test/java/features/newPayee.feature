Feature: Login function

   Background: Login
     When navigate to page login
     And enter username and password and sign in
     Then logged successfully

     Scenario Outline: Add new Payee (Positive)
       When click Payee Bills add new Payee
       And  add Payee "<Name>", "<Address>", "<Account>" and "<Payee Details>"
       And  click Add Button
       Then if the test "<result>"
       Examples:
         | Name | Address  | Account | Payee Details | result  |
         | John | 321 Main | 321321  | TechnoBank    | success |
         |      | 321 Main | 321321  | TechnoBank    | fail    |








