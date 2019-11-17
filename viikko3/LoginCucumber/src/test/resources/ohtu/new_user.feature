Feature: A new user account can be created if a proper unused username and password are given

	Scenario: creation is successful with valid username and password
		Given command new is selected
		When username "ville" and password "koira123" are entered
		Then system will respond with "new user registered"

	Scenario: creation fails with already taken username and valid password
		Given command new is selected
		When username "pekka" and password "koira123" are entered
		Then system will respond with "new user not registered"

	Scenario: creation fails with too short username and valid password
		Given command new is selected
		When username "pe" and password "koira123" are entered
		Then system will respond with "new user not registered"

	Scenario: creation fails with valid username and too short password
		Given command new is selected
		When username "pekka" and password "koira" are entered
		Then system will respond with "new user not registered"

	Scenario: creation fails with valid username and password long enough but consisting only of letters
		Given command new is selected
		When username "pekka" and password "kissatkoiria" are entered
		Then system will respond with "new user not registered"

	Scenario: can login with successfully generated account
		Given user "eero" with password "salainen1" is created
		And command login is selected
		When username "eero" and password "salainen1" are entered
		Then system will respond with "logged in"
