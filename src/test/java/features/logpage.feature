Feature: Login function

   Scenario: Login
     When navigate to page login
     And enter username and password and sign in
     Then get successful message

