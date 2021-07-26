Feature: Searching of Wikipedia
#the background executes before each and every scenario outline
	Background: 
		Given The Guest is on the Wikipedia Home Page
		
	Scenario Outline: The Guest tries to search for a Character
		When The User types in "<character>" and presses Enter
		Then The title of the article should be "<title>"
		
		Examples: 
			|	character	|	title							|
			|	Luigi			| Luigi - Wikipedia	|
			| Wario			|	Wario - Wikipedia	|
