#README: Credit Rewards for Android v1.0.0

This is a basic Android app that lets users select their constraints and preferences. Given those constraints and preferences, the app then presents users with the credit card best suited to their needs that they have a reasonable chance of being approved for.

This project was built using Android Studio (Java and XML).

##User Options

Users have 6 different UI devices that they can use to input their constraints and preferences.

+ Credit Score (text field)
+ Number of current cards (text field)
+ Max APR desired (range selected using drop-down)
  * < 14%
  * < 20%
  * < 24%
  * No preference
+ 5/24 (toggle)
+ No Annual Fee (toggle)
+ Rewards category (drop-down)
	* Starter
	* Cashback
	* Travel
	* Daily
	
##Logic
The most binding user info is the credit score. The credit score takes precedence over any other user info when presenting a card. If the score is missing, the app assumes 0.

The next most binding user info is 5/24 because that also affects which cards the user would be approved for.
Following that, the user preference is considered in the following order:
+ (No) Annual Fee
+ Rewards category
+ Max APR

##Disclaimer
This project was created in November 2016. Information is not guaranteed to be up to date. Please check individual companies' websites for most recent information on rewards, promotions, fees, rates, terms and conditions. Offers may vary based on individual profiles and credit reports.
