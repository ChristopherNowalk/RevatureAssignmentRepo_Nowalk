#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)

#This is a comment in a feature file
Feature: Wikipedia Language links work.

	#Each Scenatio will connect to a user story
	Scenario: English Wikipedia works
		Given The Guest is on the Wikipedia Home Page
		When The Guest clicks English
		Then The Guest should be on the English Home Page
		
	Scenario: Spanish Wikipedia works
		Given The Guest is on the Wikipedia Home Page
		When The Guest clicks Spanish
		Then The Guest should be on the Spanish Home Page
